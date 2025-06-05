package com.doga.game;

public class Variable {
    private String desc;
    private double value;
    private String valueString = "";

    Variable (String desc, double value){
        this.desc = desc;
        this.value = value;
    }

    Variable (String desc, String valueString){
        this.desc = desc;
        this.valueString = valueString;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }
}
