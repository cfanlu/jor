package jatools.velocity;

import jatools.engine.ReportJob;
import jatools.io.DefaultResourceOutputFactory;
import jatools.server.JobCacher;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.ASTReference;
import org.apache.velocity.runtime.parser.node.Node;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.invoke.MethodHandles;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 第一个参数为报表文件资源地址,后续都为报表参数,参数名称为velocity变量名称,参数值对应变量值
 */
public class JorDirective extends Directive {

    static Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public String getName() {
        return "jor";
    }

    @Override
    public int getType() {
        return LINE;
    }

    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        if (node.jjtGetNumChildren() == 0) {
            throw new IllegalArgumentException("template file can't be null!");
        }

        //第一个参数为模板文件地址
        Node templateNode = node.jjtGetChild(0);
        String template = templateNode.value(context).toString();
        if (StringUtils.isEmpty(template)) {
            throw new IllegalArgumentException("template file can't be empty!");
        }

        //后面为传入参数
        Map<String, Object> parameters = new HashMap<>();
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            Node child = node.jjtGetChild(i);
            if (child.getType() == 18) { //只处理表达式
                String key = ((ASTReference) child).getRootString();
                parameters.put(key, child.value(context));
            }
        }

        //输出报表
        writeOut(template, parameters, writer);

        return true;
    }

    //由原来ReportTag改写,为何用session我也不知道
    private void writeOut(
            String template,
            Map<String, Object> parameters,
            Writer out) throws IOException {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        HttpSession session = request.getSession();

        try {
            InputStream is = null;
            String xmluuid = request.getParameter("xmluuid");

            if (xmluuid != null) {
                String xml = (String) session.getServletContext().getAttribute(xmluuid);

                if (xml != null) {
                    is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
                }
            } else if (template != null) {
                try {
                    ResourceLoader loader = new DefaultResourceLoader();
                    Resource resource = loader.getResource(template);
                    is = resource.getInputStream();
                } catch (FileNotFoundException e) {
                    throw new Exception("\u6253\u4E0D\u5F00\u6307\u5B9A\u6A21\u677F: ");
                }
            }

            ReportJob job;
            if (is == null) {
                job = JobCacher.callJob(request.getSession(),
                        request.getParameter(ReportJob.JOB_SESSION_ID));
            } else {
                job = new ReportJob(is);
            }

            for (Enumeration en = request.getParameterNames(); en.hasMoreElements();) {
                String name = (String) en.nextElement();
                job.setParameter(name, request.getParameter(name));
            }

            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    Object val = parameters.get(key);

                    if (logger.isDebugEnabled()) {
                        logger.debug("res.11" + key + " = " + val);
                    }
                    job.setParameter(key, val);
                }
            }

            job.setParameter("file", template);
            job.setParameter("as", "dhtml");
            job.setParameter(ReportJob.HTML_BODY_ONLY, "true");
//            job.setParameter(ReportJob.HTML_REPORT_ID, "j" + id);
            job.setParameter(ReportJob.HTTP_REQUEST, request);

            if (true || ReportJob.USE_SESSION2) {
                job.setParameter(ReportJob.HTTP_SESSION2, session);
            }

            job.printAsDHTML(
                    DefaultResourceOutputFactory.createInstance(session),
                    out);

            if (true || ReportJob.USE_SESSION2) {
                JobCacher.doCache(session, job);
            }

            job = null;
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }
    }
}
