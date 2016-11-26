/*
 * Created on 2004-8-8
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jatools.data.rs.bean;

import java.awt.Component;

import com.jatools.core.ZDataProvider;
import com.jatools.data.ZDataException;


/**
 * @author java
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ZBeanDataset {

	public void loadData(ZDataProvider p) throws ZDataException;
	
	public String getSupportedProperties();
	
	public Component getEditorComponent();
	
	

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ZDataException DOCUMENT ME!
     */
    public int getColumnCount() throws ZDataException;

    /**
     * DOCUMENT ME!
     *
     * @param col DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ZDataException DOCUMENT ME!
     */
    public String getColumnName(int col) throws ZDataException;

    /**
     * DOCUMENT ME!
     *
     * @param col DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ZDataException DOCUMENT ME!
     */
    public Class getColumnClass(int col) throws ZDataException;

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ZDataException DOCUMENT ME!
     */
    public int getRowCount() throws ZDataException;

    /**
     * DOCUMENT ME!
     *
     * @param row DOCUMENT ME!
     * @param col DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     *
     * @throws ZDataException DOCUMENT ME!
     */
    public Object getValueAt(int row, int col) throws ZDataException;
}
