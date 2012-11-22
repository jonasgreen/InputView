package com.inputview.client.pagetabel;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.DataValue;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.pages.SearchPage;
import com.inputview.client.uicomponents.TextComponent;

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
        TextComponent comp = new TextComponent(model.getDescription(), 100, 100);
        comp.setWidth(248+"px");
        comp.setHeight("20px");
        comp.getElement().getStyle().setMarginLeft(100, Style.Unit.PX);
        comp.getElement().getStyle().setPaddingLeft(4, Style.Unit.PX);
        return comp;
    }

    @Override
    protected List<DivComposite<?>> createChildren() {
        return null;
    }

}
