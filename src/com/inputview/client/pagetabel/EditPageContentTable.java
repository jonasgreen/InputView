package com.inputview.client.pagetabel;

import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeRoot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EditPageContentTable extends DivCompositeRoot<DataList>{


    private List<DataList> model;

    public EditPageContentTable(List<DataList> model) {
        this.model = model;
    }

    @Override
    public List<DivComposite<DataList>> createRows() {
        List<DivComposite<DataList>> list = new ArrayList<DivComposite<DataList>>();

        for (DataList dl : model) {
            list.add(new ListContentRow(1, this, dl));
        }

        return list;
    }

    @Override
    protected FlowPanel createHeader() {
        return new FlowPanel();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTableHeight() {
        return 400;
    }
}
