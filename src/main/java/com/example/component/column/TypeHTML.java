package com.example.component.column;

import com.example.component.Column;

public class TypeHTML extends Column {
    public TypeHTML(String name) {
        super(name);
        this.type = TypeColumn.HTML.name();
    }

    @Override
    public boolean validate(String value) {
        return value.toLowerCase().endsWith(".html");
    }
}