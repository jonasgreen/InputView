package com.inputview.client.pagetabel;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeRoot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EditorTable extends DivCompositeRoot<DataList>{


    private List<DataList> model;

    public EditorTable(List<DataList> model, int width) {
        super(width);
        this.model = model;
    }

    @Override
    public List<DivComposite<DataList>> createRows() {
        List<DivComposite<DataList>> list = new ArrayList<DivComposite<DataList>>();

        for (DataList dl : model) {
            EditorRowList row = new EditorRowList(0, this, dl);
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
        return Window.getClientHeight()-40;
    }
}
