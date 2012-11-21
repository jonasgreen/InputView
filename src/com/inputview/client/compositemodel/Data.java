package com.inputview.client.compositemodel;

import java.io.Serializable;

/**
 *
 */
public abstract class Data implements Serializable {
    private static final long serialVersionUID = 7311171272352593451L;

    private static int idCount = 1;
    private int id = idCount++;

    private String description;

    protected Data(String description) {
        this.description = description;
    }


    public abstract boolean isDataValue();

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Data data = (Data) o;

        if (id != data.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
