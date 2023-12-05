package com.example.component.column


class TypeStringInvl(name: String) : Column(name) {

    override val type = TypeColumn.STRINGINVL.name


    override fun validate(value: String): Boolean {
        val parts = value.split(" - ").map { it.trim() }

        if (parts.size != 2) {
            return false // Incorrect format (must have the " - " delimiter)
        }

        val (value1, value2) = parts

        // Check if value1 is less than value2
        return value1 < value2
    }
}
