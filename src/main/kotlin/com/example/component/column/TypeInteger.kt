package com.example.component.column

class TypeInteger(name: String) : Column(name) {
    override val type = TypeColumn.INT.name
    override fun validate(data: String) = data.toIntOrNull() != null
}

