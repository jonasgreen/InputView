package com.inputview.client.compositemodel;

import java.io.Serializable;

/**
 *
 */
public class DataComposite extends Data{

    private static final long serialVersionUID = -205039258420000410L;

    protected DataComposite() {
    }

    @Override
    public boolean isDataValue() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
