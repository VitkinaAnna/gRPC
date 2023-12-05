package com.example.component.column

class TypeChar(name: String) : Column(name) {
    override val type = TypeColumn.CHAR.name
    override fun validate(data: String) = data.length <= 1
}


