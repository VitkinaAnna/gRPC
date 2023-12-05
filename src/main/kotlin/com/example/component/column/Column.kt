package com.example.component.column

import java.io.Serializable

abstract class Column(var name: String) : Serializable {
    abstract val type: String
    abstract fun validate(data: String): Boolean


}
