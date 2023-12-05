package com.example.component.column

class TypeReal(name: String) : Column(name) {
    override val type = TypeColumn.REAL.name
    override fun validate(data: String) = data.toDoubleOrNull() != null
}

