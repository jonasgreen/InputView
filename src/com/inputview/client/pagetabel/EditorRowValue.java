package com.inputview.client.pagetabel;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.DataValue;
import com.inputview.client.composittable.DataCell;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.pages.SearchPage;

import java.util.List;

/**
 *
 */
public class EditorRowValue extends EditorRow<DataValue> {

    private EditorRowList list;

    protected EditorRowValue(int tabIndex, EditorRowList parent, DataValue model) {
        super(tabIndex, parent, model);
        this.list = parent;
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
    protected void styleOnFocus() {
        super.styleOnFocus();
        SearchPage.onFocus(false, getModel());
    }

    @Override
    protected FlowPanel createContent(DataValue model) {
        FlowPanel fl = new FlowPanel();
        DataCell name = new DataCell(model.getDescription());
        name.setWidth(200+"px");
        name.getElement().getStyle().setPaddingLeft(50, Style.Unit.PX);
        fl.add(name);
        DataCell value = new DataCell(model.getValue());
        value.setWidth("150px");
        fl.add(value);

        return fl;
    }

    @Override
    protected List<DivComposite<?>> createChildren() {
        return null;
    }

}
