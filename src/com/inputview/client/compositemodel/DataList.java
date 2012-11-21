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


    public DataList(String description) {
        super(description);
    }

    @Override
    public boolean isDataValue() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Data> getValues() {
        return values;
    }

    public void setValues(List<Data> values) {
        this.values = values;
    }

    public void add(String description, Integer value){
        values.add(new IntegerValue(this, description, String.valueOf(value)));
    }

    public void add(String description, String value){
        values.add(new StringValue(this, description, value));
    }

    public void add(String description, Double value){
        values.add(new DoubleValue(this, description, String.valueOf(value)));
    }

    public void add(String description, Boolean value){
        values.add(new BooleanValue(this, description, String.valueOf(value)));
    }

    public void add(String description, Date value){
        values.add(new DateValue(this, description, String.valueOf(value)));
    }

    public void add(Data data) {
        values.add(data);
    }

    public boolean containsADataList(){
        for (Data value : values) {
            if(value instanceof DataList){
                return true;
            }
        }
        return false;
    }


}
