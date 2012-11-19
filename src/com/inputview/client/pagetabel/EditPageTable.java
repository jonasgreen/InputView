package com.inputview.client.pagetabel;

import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeRoot;

import java.util.List;

/**
 *
 */
public class EditPageTable extends DivCompositeRoot<DataList>{
    @Override
    public List<DivComposite<DataList>> createRows() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected FlowPanel createHeader() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTableHeight() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
