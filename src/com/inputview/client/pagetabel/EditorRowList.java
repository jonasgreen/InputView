package com.inputview.client.pagetabel;

import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.compositemodel.DataValue;
import com.inputview.client.composittable.DataCell;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeParent;
import com.inputview.client.pages.SearchPage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EditorRowList extends EditorRow<DataList> {


    protected EditorRowList(int tabIndex, DivCompositeParent parent, DataList model) {
        super(tabIndex, parent, model);
        showChildren();
    }

    @Override
    protected FlowPanel createContent(DataList model) {
        FlowPanel fl = new FlowPanel();
        DataCell cell = new DataCell(150, model.getDescription());
        fl.add(cell);
        EditorRowListStyle.style(tabIndex, cell);
        getFocusPanel().setHeight("46px");
        if (tabIndex == 0) {
            getFocusPanel().getElement().getStyle().setBackgroundColor("rgb(245,245,245)");
        }

        return fl;
    }

    @Override
    protected void styleOnFocus() {
        super.styleOnFocus();
        SearchPage.onFocus(false, getModel());
    }


    @Override
    protected List<DivComposite<?>> createChildren() {
        List<DivComposite<?>> children = new ArrayList<DivComposite<?>>();
        for (Data data : model.getValues()) {
            if (data instanceof DataList) {
                children.add(new EditorRowList(tabIndex + 1, this, (DataList) data));
            }
            else {
                children.add(new EditorRowValue(tabIndex + 1, this, (DataValue) data));
            }
        }
        return children;
    }


}
