package com.inputview.client.compositemodel;

import java.io.Serializable;

/**
 *
 */
public abstract class DataValue extends Data implements Serializable {

    private static final long serialVersionUID = 6070278387871773681L;

    private String description;
    private String value;

    public DataValue() {
    }

    @Override
    public boolean isDataValue() {
        return true;
    }

    public DataValue(String description, String value) {
        this.description = description;
        this.value = value;
    }

    public DataValue(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
