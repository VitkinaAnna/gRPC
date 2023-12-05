package com.example.component

import com.example.component.column.*

class Table(val name: String) {
    val rows = mutableListOf<Row>()
    val columns = mutableListOf<Column>()

    constructor(table: Table) : this(table.name) {
        table.rows.forEach { row ->
            val newRow = Row()
            newRow.values.addAll(row.values)
            rows.add(newRow)
        }

        table.columns.forEach { column ->
            val newColumn = when (TypeColumn.valueOf(column.type)) {
                TypeColumn.INT -> TypeInteger(column.name)
                TypeColumn.REAL -> TypeReal(column.name)
                TypeColumn.STRING -> TypeString(column.name)
                TypeColumn.CHAR -> TypeChar(column.name)
                TypeColumn.HTML -> TypeHTML(column.name)
                TypeColumn.STRINGINVL -> TypeStringInvl(column.name)
            }
            columns.add(newColumn)
        }
    }

    fun addRow(row: Row) {
        rows.add(row)
    }

    fun deleteRow(rowIndex: Int) {
        rows.removeAt(rowIndex)
    }

    fun deleteColumn(columnIndex: Int) {
        columns.removeAt(columnIndex)
        rows.forEach { row ->
            row.values.removeAt(columnIndex)
        }
    }

    fun addColumn(column: Column) {
        columns.add(column)
    }
}
