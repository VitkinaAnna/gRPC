package com.example.component.column


class TypeHTML(name: String) : Column(name) {

    override val   type = TypeColumn.HTML.name

    override fun validate(value: String): Boolean {
        return value.toLowerCase().endsWith(".html")
    }
}
