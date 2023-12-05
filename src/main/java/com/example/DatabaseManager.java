package com.example;

import com.example.component.Column;
import com.example.component.Database;
import com.example.component.Row;
import com.example.component.Table;
import com.example.component.column.*;

public class DatabaseManager {
    private static DatabaseManager instance;
//    public static DBMS instanceCSW;

    private DatabaseManager(){
    }

    public static DatabaseManager getInstance(){
        if (instance == null){
            instance = new DatabaseManager();
//            instanceCSW = DBMS.getInstance();
        }
        return instance;
    }

    public static Database database;

    public static void populateTable() {
        Table table = new Table("testTable" + database.tables.size());
        table.addColumn(new TypeInteger("column1"));
        table.addColumn(new TypeReal("column2"));
        table.addColumn(new TypeString("column3"));
        table.addColumn(new TypeChar("column4"));
        table.addColumn(new TypeHTML("column5"));
        table.addColumn(new TypeStringInvl("column6"));
        Row row1 = new Row();
        row1.values.add("10");
        row1.values.add("10.0");
        row1.values.add("10");
        row1.values.add("1");
        row1.values.add("hehe.html");
        row1.values.add("hehe-hihi");
        table.addRow(row1);
        Row row2 = new Row();
        row2.values.add("15");
        row2.values.add("15.0");
        row2.values.add("15");
        row2.values.add("3");
        row2.values.add("hehe.html");
        row2.values.add("hehe-hihi");
        table.addRow(row2);
        database.addTable(table);
    }

    public void createDB(String name) {
        database = new Database(name);
    }

    public Boolean addTable(String name){
        if (name != null && !name.isEmpty()) {
            Table table = new Table(name);
            database.addTable(table);
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean deleteTable(int tableIndex){

        if (tableIndex != -1) {
            database.deleteTable(tableIndex);
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean addColumn(int tableIndex, String columnName, TypeColumn typeColumn) {
        if (columnName != null && !columnName.isEmpty()) {
            if (tableIndex != -1) {

                switch (typeColumn) {
                    case INT -> {
                        Column columnInt = new TypeInteger(columnName);
                        database.tables.get(tableIndex).addColumn(columnInt);
                    }
                    case REAL -> {
                        Column columnReal = new TypeReal(columnName);
                        database.tables.get(tableIndex).addColumn(columnReal);
                    }
                    case STRING -> {
                        Column columnStr = new TypeString(columnName);
                        database.tables.get(tableIndex).addColumn(columnStr);
                    }
                    case CHAR -> {
                        Column columnChar = new TypeChar(columnName);
                        database.tables.get(tableIndex).addColumn(columnChar);
                    }
                    case HTML -> {
                        Column typeHTML = new TypeHTML(columnName);
                        database.tables.get(tableIndex).addColumn(typeHTML);
                    }
                    case STRINGINVL -> {
                        Column typeStringInvl = new TypeStringInvl(columnName);
                        database.tables.get(tableIndex).addColumn(typeStringInvl);
                    }
                }
                for (Row row : database.tables.get(tableIndex).rows) {
                    row.values.add("");
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }


    public Boolean deleteColumn(int tableIndex, int columnIndex/*, CustomTableModel tableModel*/){
        if (columnIndex != -1) {
            database.tables.get(tableIndex).deleteColumn(columnIndex);
            return true;
        } else {
            return false;
        }
    }

    public Boolean addRow(int tableIndex, com.example.component.Row row){
        if (tableIndex != -1) {
            for (int i = row.values.size(); i < database.tables.get(tableIndex).columns.size(); i++) {
                row.values.add("");
            }
            database.tables.get(tableIndex).addRow(row);
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean deleteRow(int tableIndex, int rowIndex/*, CustomTableModel tableModel*/){
        if (rowIndex != -1) {
            database.tables.get(tableIndex).deleteRow(rowIndex);
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean updateCellValue(String value, int tableIndex, int columnIndex, int rowIndex/*, CustomTable table*/){
        Table table = database.tables.get(tableIndex);
        com.example.component.Column column = table.columns.get(columnIndex);
        if (column.validate(value)){
            com.example.component.Row row = table.rows.get(rowIndex);
            row.setAt(columnIndex,value.trim());
            return true;
        }
        return false;
    }

    public static boolean changeColumnName(int tableIndex, int columnIndex, String newName){
        database.tables.get(tableIndex).columns.get(columnIndex).setName(newName);
        return true;
    }
}
