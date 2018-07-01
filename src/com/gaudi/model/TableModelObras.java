package com.gaudi.model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier Vergara Lee
 */
public class TableModelObras extends DefaultTableModel{

    public TableModelObras() {
        initTable();
    }
    
    private void initTable(){
        this.addColumn("Código");
        this.addColumn("Nombre");
        this.addColumn("Año");
        this.addColumn("Dimensiones");
        this.addColumn("Técnica");
        this.addColumn("Género");
        this.addColumn("Autor");
        this.addColumn("Sala");
    }

    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRowCount(int rowCount) {
        super.setRowCount(rowCount); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return super.getRowCount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRow(int row) {
        super.removeRow(row); //To change body of generated methods, choose Tools | Templates.
    }
}
