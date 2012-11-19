package com.inputview.client.pagetabel;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataComposite;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.Column;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeParent;
import com.inputview.client.composittable.EmptyColumn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ListContentRow extends DivComposite<DataList>{

    private int tabIndex;
    private Label plusMinus;

    protected ListContentRow(int tabIndex, DivCompositeParent parent, DataList model) {
        super(parent, model);
        this.tabIndex = tabIndex;
    }

    @Override
    protected void enterPressed() {

    }

    @Override
    protected void onChildrenShow() {
    }

    @Override
    protected void onChildrenHide() {
    }

    @Override
    protected FlowPanel createContent(DataList model) {
        FlowPanel fl = new FlowPanel();
        int i = 0;
        while (i < tabIndex){
            fl.add(new EmptyColumn());
            i++;
        }
        fl.add(getPlusMinus());
        fl.add(new Column(model.getDescription()));
        return fl;
    }

    @Override
    protected List<DivComposite<?>> createChildren() {
        List<DivComposite<?>> children = new ArrayList<DivComposite<?>>();
        for (Data data : model.getValues()) {
            if(data instanceof DataList){
                children.add(new ListContentRow(tabIndex+1, this, (DataList) data));
            }
        }
        return children;
    }

    public Label getPlusMinus() {
        if (plusMinus == null) {
            plusMinus = new Label("+");
            plusMinus.setStyleName("plusMinus");
            plusMinus.setWidth("10px");

        }
        return plusMinus;
    }
}
