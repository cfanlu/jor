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
    static String[] columnNames = new String[] { "ʡ��������", "���", "�������ƽ�����", "�˿ڣ���", "ʡ��" };
    static Class[] columnClasses = new Class[] {
            String.class, String.class, Double.class, Double.class, String.class
        };
    static Object[] data = new Object[] {
            new Object[] { "������          ", "��", new Double(1.68), new Double(1143), "" }, //
            new Object[] { "�����          ", "��", new Double(1.1), new Double(927), "" }, //
            new Object[] { "�ӱ�ʡ          ", "��", new Double(19), new Double(6742), "ʯ��ׯ��" }, //
            new Object[] { "ɽ��ʡ          ", "��", new Double(15), new Double(3245), "̫ԭ��" }, //
            new Object[] { "���ɹ�������    ", "���ɹ�", new Double(110), new Double(2355), "���ͺ�����" }, //
            new Object[] { "����ʡ          ", "��", new Double(15), new Double(4155), "������" }, //
            new Object[] { "����ʡ          ", "��", new Double(18), new Double(2649), "������" }, //
            new Object[] { "������ʡ        ", "��", new Double(46), new Double(3732), "��������" }, //
            new Object[] { "�Ϻ���          ", "��", new Double(0.58), new Double(1334), "" }, //
            new Object[] { "����ʡ          ", "��", new Double(10), new Double(7127), "�Ͼ���" }, //
            new Object[] { "�㽭ʡ          ", "��", new Double(10), new Double(4536), "������" }, //
            new Object[] { "����ʡ          ", "��", new Double(13), new Double(6369), "����ʡ" }, //
            new Object[] { "����ʡ          ", "��", new Double(12), new Double(3332), "������" }, //
            new Object[] { "����ʡ          ", "��", new Double(16), new Double(4263), "�ϲ���" }, //
            new Object[] { "ɽ��ʡ          ", "³", new Double(15), new Double(9069), "������" }, //
            new Object[] { "����ʡ          ", "ԥ", new Double(16), new Double(9683), "֣����" }, //
            new Object[] { "����ʡ          ", "��", new Double(18), new Double(5978), "�人��" }, //
            new Object[] { "����ʡ          ", "��", new Double(21), new Double(6564), "��ɳ��" }, //
            new Object[] { "�㶫ʡ          ", "��", new Double(18), new Double(7649), "������" }, //
            new Object[] { "����׳��������  ", "��", new Double(23), new Double(4791), "������" }, //
            new Object[] { "����ʡ          ", "��", new Double(3.4), new Double(779), "������" }, //
            new Object[] { "������          ", "��", new Double(8.23), new Double(3114), "" }, //
            new Object[] { "�Ĵ�ʡ          ", "������", new Double(48), new Double(8474), "�ɶ���" }, //
            new Object[] { "����ʡ          ", "ǭ����", new Double(17), new Double(3748), "������" }, //
            new Object[] { "����ʡ          ", "�ᡢ��", new Double(38), new Double(4141), "������" }, //
            new Object[] { "����������      ", "��", new Double(120), new Double(255), "������" }, //
            new Object[] { "����ʡ          ", "�¡���", new Double(19), new Double(3611), "������" }, //
            new Object[] { "����ʡ          ", "�ʡ�¤", new Double(39), new Double(2568), "������" }, //
            new Object[] { "�ຣʡ          ", "��", new Double(72), new Double(487), "������" }, //
            new Object[] { "���Ļ���������  ", "��", new Double(6.6), new Double(573), "������" }, //
            new Object[] { "�½�ά���������", "��", new Double(160), new Double(1860), "��³ľ����" }, //
            new Object[] { "����ر�������  ", "��", new Double(0.1101), new Double(681.01), "" }, //
            new Object[] { "�����ر�������  ", "��", new Double(0.0025), new Double(44.8495), "" }, //
            new Object[] { "̨��ʡ          ", "̨", new Double(3.6), new Double(2260), "" } //
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
            throw new ZDataException("ָ�����в����� [��" + col + "].");
        }
    }

    /* (non-Javadoc)
     * @see com.jatools.data.ZBeanDataset#getColumnClass(int)
     */
    public Class getColumnClass(int col) throws ZDataException {
        if ((col > -1) && (col < getColumnCount())) {
            return columnClasses[col];
        } else {
            throw new ZDataException("ָ�����в����� [��" + col + "].");
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
            throw new ZDataException("ָ�������в����� [��=" + row + ",��" + col + "].");
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
