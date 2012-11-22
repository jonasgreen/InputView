package com.inputview.client.pagetabel;

import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeRoot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ContentTable extends DivCompositeRoot<DataList>{


    private List<DataList> model;

    public ContentTable(List<DataList> model, int width) {
        super(width);
        this.model = model;
        getElement().getStyle().setBackgroundColor("rgb(245,245,245)");
    }

    @Override
    public List<DivComposite<DataList>> createRows() {
        List<DivComposite<DataList>> list = new ArrayList<DivComposite<DataList>>();

        for (DataList dl : model) {
            ContentRow row = new ContentRow(0, this, dl);
            row.setWidth(width+"px");
            list.add(row);
        }

        getCustomScrollPanel().setWidth(width+"px");

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
