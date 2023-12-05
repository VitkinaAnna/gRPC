package com.example.component.column;


import com.example.component.Column;
public class TypeReal extends Column {

    public TypeReal(String name){
        super(name);
        this.type = TypeColumn.REAL.name();
    }

    @Override
    public boolean validate(String data) {
        if (data == null || data.isEmpty()){
            return true;
        }
        try {
            Double.parseDouble(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
