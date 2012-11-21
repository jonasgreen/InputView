package com.inputview.client.compositemodel;

import java.io.Serializable;

/**
 *
 */
public abstract class DataValue extends Data implements Serializable {

    private static final long serialVersionUID = 6070278387871773681L;

    private String value;

    private DataList parent;

    public DataValue(DataList parent, String description, String value) {
        super(description);
        this.parent = parent;
        this.value = value;
    }


    @Override
    public boolean isDataValue() {
        return true;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DataList getParent() {
        return parent;
    }
}
