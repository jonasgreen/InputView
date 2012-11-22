package com.inputview.client.pagetabel;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.DataCell;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeParent;
import com.inputview.client.pages.SearchPage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ContentRow extends DivComposite<DataList> {

    private DataCell plusMinus;

    protected ContentRow(int tabIndex, DivCompositeParent parent, DataList model) {
        super(tabIndex, parent, model);
        removeStyleName("row");
    }

    protected void styleOnFocus() {
        super.styleOnFocus();
        SearchPage.onFocus(true, model);
    }

    @Override
    public String getDescription() {
        return model.getDescription();
    }


    @Override
    protected ClickHandler getClickHandler() {
        return new ClickHandler() {
            public void onClick(ClickEvent event) {
                toggleChildren();
                SearchPage.scrollTo(getModel());
                event.stopPropagation();
                event.preventDefault();
            }
        };

    }

    @Override
    protected void enterPressed() {
        toggleChildren();
        SearchPage.scrollTo(getModel());
    }

    @Override
    protected void onChildrenShow() {
        if (model.containsADataList()) {
            getPlusMinus().setText("-");
        }
    }

    @Override
    protected void onChildrenHide() {
        if (model.containsADataList()) {
            getPlusMinus().setText("+");
        }
    }

    @Override
    protected FlowPanel createContent(DataList model) {
        FlowPanel fl = new FlowPanel();
        int i = 0;
        while (i < tabIndex) {
            fl.add(new DataCell(""));
            i++;
        }
        fl.add(getPlusMinus());
        if (model.containsADataList()) {
            getPlusMinus().setText("+");
        }

        fl.add(new DataCell(150, model.getDescription()));
        return fl;
    }

    @Override
    protected List<DivComposite<?>> createChildren() {
        List<DivComposite<?>> children = new ArrayList<DivComposite<?>>();
        for (Data data : model.getValues()) {
            if (data instanceof DataList) {
                children.add(new ContentRow(tabIndex + 1, this, (DataList) data));
            }
        }
        return children;
    }

    public DataCell getPlusMinus() {
        if (plusMinus == null) {
            plusMinus = new DataCell("");
            plusMinus.getElement().getStyle().setTextAlign(Style.TextAlign.RIGHT);
            plusMinus.getElement().getStyle().setPaddingRight(4, Style.Unit.PX);
        }
        return plusMinus;
    }
}
