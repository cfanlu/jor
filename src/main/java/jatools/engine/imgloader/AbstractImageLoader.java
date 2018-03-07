//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package jatools.engine.imgloader;


import jatools.dataset.Dataset;
import jatools.dom.DatasetBasedNode;
import jatools.dom.RowNode;
import jatools.dom.field.RowField;
import jatools.engine.script.Script;
import jatools.util.Base64Util;
import jatools.util.Util;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public abstract class AbstractImageLoader implements ImageLoader {
    static ImageLoader defaults;
    static JLabel label = new JLabel();
    Map images;

    public AbstractImageLoader() {
    }

    protected abstract Script getScript();

    protected final Image loadImage(String src) {
        Image result = null;
        if (src.startsWith("url")) {
            src = src.substring("url".length() + 1);
            //modify by henry @ 17/09/07
            if (src.startsWith("$") || src.startsWith("=$")) {
                Script script = this.getScript();
                Object urlObj = script.get(src);
                if (urlObj != null) {
                    result = this.loadUrl(urlObj.toString());
                }
            } else {
                result = this.loadUrl(src);
            }
        } else if (src.startsWith("field")) {
            result = this.loadDatasetField(src.substring("field".length() + 1));
        } else if (src.startsWith("classpath")) {
            result = this.loadClassPath(src.substring("classpath".length() + 1));
        } else if (src.startsWith("file")) {
            result = this.loadFile(src.substring("file".length() + 1));
        } else if (src.startsWith("builtin")) {
            result = this.loadBase64(src.substring("builtin".length() + 1));
        }

        return result;
    }

    protected Image loadFile(String src) {
        try {
            FileInputStream is = new FileInputStream(src);
            return this.loadInputStream(is);
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    protected Image loadInputStream(InputStream is) {
        Image result = null;

        try {
            byte[] e = new byte[is.available()];
            is.read(e);
            result = Toolkit.getDefaultToolkit().createImage(e);
            MediaTracker mt = new MediaTracker(label);
            mt.addImage(result, 0);
            mt.waitForID(0);
        } catch (IOException var5) {
            var5.printStackTrace();
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

        return result;
    }

    protected Image loadClassPath(String src) {
        return this.loadInputStream(Util.class.getResourceAsStream(src));
    }

    protected Image loadDatasetField(String src) {
        Script script = this.getScript();
        if (script != null) {
            script.clearValue2();
            script.eval(src);
            Object o = script.getValue2();
            if (o instanceof RowField) {
                RowField field = (RowField) o;
                if (field.getNode() instanceof DatasetBasedNode) {
                    RowNode node = field.getNode();
                    Dataset rows = node.getDataset();
                    int col = field.getColumn();
                    if (col == -1) {
                        return null;
                    }

                    InputStream is = rows.getBinaryStream(rows.getRow(node.getRowSet().rowAt(0)).index, col);
                    return this.loadInputStream(is);
                }
            }
        }

        return null;
    }

    protected Image loadUrl(String src) {
        try {
            return (new ImageIcon(new URL(src))).getImage();
        } catch (MalformedURLException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    protected Image loadBase64(String src) {
        return (new ImageIcon(Base64Util.decode(src))).getImage();
    }
}
