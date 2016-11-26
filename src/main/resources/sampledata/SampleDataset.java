/*
 * Created on 2004-8-8
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package userx;

import java.awt.Component;

import com.jatools.core.ZDataProvider;
import com.jatools.data.ZDataException;
import com.jatools.data.rs.bean.ZBeanDataset;


/**
 * @author java
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SampleDataset implements ZBeanDataset {
    static String[] columnNames = new String[] { "省级行政区", "简称", "面积（万平方公里）", "人口（万）", "省会" };
    static Class[] columnClasses = new Class[] {
            String.class, String.class, Double.class, Double.class, String.class
        };
    static Object[] data = new Object[] {
            new Object[] { "北京市          ", "京", new Double(1.68), new Double(1143), "" }, //
            new Object[] { "天津市          ", "津", new Double(1.1), new Double(927), "" }, //
            new Object[] { "河北省          ", "冀", new Double(19), new Double(6742), "石家庄市" }, //
            new Object[] { "山西省          ", "晋", new Double(15), new Double(3245), "太原市" }, //
            new Object[] { "内蒙古自治区    ", "内蒙古", new Double(110), new Double(2355), "呼和浩特市" }, //
            new Object[] { "辽宁省          ", "辽", new Double(15), new Double(4155), "沈阳市" }, //
            new Object[] { "吉林省          ", "吉", new Double(18), new Double(2649), "长春市" }, //
            new Object[] { "黑龙江省        ", "黑", new Double(46), new Double(3732), "哈尔滨市" }, //
            new Object[] { "上海市          ", "沪", new Double(0.58), new Double(1334), "" }, //
            new Object[] { "江苏省          ", "苏", new Double(10), new Double(7127), "南京市" }, //
            new Object[] { "浙江省          ", "浙", new Double(10), new Double(4536), "杭州市" }, //
            new Object[] { "安徽省          ", "皖", new Double(13), new Double(6369), "安徽省" }, //
            new Object[] { "福建省          ", "闽", new Double(12), new Double(3332), "福州市" }, //
            new Object[] { "江西省          ", "赣", new Double(16), new Double(4263), "南昌市" }, //
            new Object[] { "山东省          ", "鲁", new Double(15), new Double(9069), "济南市" }, //
            new Object[] { "河南省          ", "豫", new Double(16), new Double(9683), "郑州市" }, //
            new Object[] { "湖北省          ", "鄂", new Double(18), new Double(5978), "武汉市" }, //
            new Object[] { "湖南省          ", "湘", new Double(21), new Double(6564), "长沙市" }, //
            new Object[] { "广东省          ", "粤", new Double(18), new Double(7649), "广州市" }, //
            new Object[] { "广西壮族自治区  ", "桂", new Double(23), new Double(4791), "南宁市" }, //
            new Object[] { "海南省          ", "琼", new Double(3.4), new Double(779), "海口市" }, //
            new Object[] { "重庆市          ", "渝", new Double(8.23), new Double(3114), "" }, //
            new Object[] { "四川省          ", "川、蜀", new Double(48), new Double(8474), "成都市" }, //
            new Object[] { "贵州省          ", "黔、贵", new Double(17), new Double(3748), "贵阳市" }, //
            new Object[] { "云南省          ", "滇、云", new Double(38), new Double(4141), "昆明市" }, //
            new Object[] { "西藏自治区      ", "藏", new Double(120), new Double(255), "拉萨市" }, //
            new Object[] { "陕西省          ", "陕、秦", new Double(19), new Double(3611), "西安市" }, //
            new Object[] { "甘肃省          ", "甘、陇", new Double(39), new Double(2568), "兰州市" }, //
            new Object[] { "青海省          ", "青", new Double(72), new Double(487), "西宁市" }, //
            new Object[] { "宁夏回族自治区  ", "宁", new Double(6.6), new Double(573), "银川市" }, //
            new Object[] { "新疆维吾尔自治区", "新", new Double(160), new Double(1860), "乌鲁木齐市" }, //
            new Object[] { "香港特别行政区  ", "港", new Double(0.1101), new Double(681.01), "" }, //
            new Object[] { "澳门特别行政区  ", "澳", new Double(0.0025), new Double(44.8495), "" }, //
            new Object[] { "台湾省          ", "台", new Double(3.6), new Double(2260), "" } //
        };

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#initParameters(com.jatools.core.ZDataProvider)
     */
    public void initParameters(ZDataProvider provider) {
    }

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#getColumnCount()
     */
    public int getColumnCount() throws ZDataException {
        return columnNames.length;
    }

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#getColumnName(int)
     */
    public String getColumnName(int col) throws ZDataException {
        if ((col > -1) && (col < getColumnCount())) {
            return columnNames[col];
        } else {
            throw new ZDataException("指定的列不存在 [列" + col + "].");
        }
    }

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#getColumnClass(int)
     */
    public Class getColumnClass(int col) throws ZDataException {
        if ((col > -1) && (col < getColumnCount())) {
            return columnClasses[col];
        } else {
            throw new ZDataException("指定的列不存在 [列" + col + "].");
        }
    }

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#getRowCount()
     */
    public int getRowCount() throws ZDataException {
        return data.length;
    }

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#getValueAt(int, int)
     */
    public Object getValueAt(int row, int col) throws ZDataException {
        if ((row > -1) && (row < getRowCount()) && (col > -1) && (col < getColumnCount())) {
            return ((Object[]) data[row])[col];
        } else {
            throw new ZDataException("指定的行列不存在 [行=" + row + ",列" + col + "].");
        }
    }



	/* (non-Javadoc)
	 * @see com.jatools.data.rs.bean.ZBeanDataset#loadData(com.jatools.core.ZDataProvider)
	 */
	public void loadData(ZDataProvider p) throws ZDataException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.jatools.data.rs.bean.ZBeanDataset#getSupportedProperties()
	 */
	public String getSupportedProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jatools.data.rs.bean.ZBeanDataset#getEditorComponent()
	 */
	public Component getEditorComponent() {
		// TODO Auto-generated method stub
		return null;
	}


}
