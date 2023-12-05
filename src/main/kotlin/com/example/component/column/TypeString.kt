package com.example.component.column

class TypeString(name: String) : Column(name) {
    override val type = TypeColumn.STRING.name
    override fun validate(data: String) = true
}