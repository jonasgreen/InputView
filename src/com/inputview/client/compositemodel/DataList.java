package com.inputview.client.compositemodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class DataList extends Data{

    private static final long serialVersionUID = -6837197794805603784L;
    private List<Data> values = new ArrayList<Data>();


    public DataList() {
    }

    public List<Data> getValues() {
        return values;
    }

    public void setValues(List<Data> values) {
        this.values = values;
    }

    public void add(String description, Integer value){
        values.add(new IntegerValue(description, String.valueOf(value)));
    }

    public void add(String description, String value){
        values.add(new StringValue(description, value));
    }

    public void add(String description, Double value){
        values.add(new DoubleValue(description, String.valueOf(value)));
    }

    public void add(String description, Boolean value){
        values.add(new BooleanValue(description, String.valueOf(value)));
    }

    public void add(String description, Date value){
        values.add(new DateValue(description, String.valueOf(value)));
    }


}
