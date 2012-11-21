package com.inputview.client.pages;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.model.EditProductModelGenerator;
import com.inputview.client.model.Product;
import com.inputview.client.pagetabel.BackgroundSelectionManager;
import com.inputview.client.pagetabel.ContentTable;
import com.inputview.client.pagetabel.EditorTable;
import com.inputview.client.producttable.ProductTable;

import java.util.List;

/**
 *
 */
public class SearchPage extends FlowPanel {

    private List<Product> products;
    private ProductTable productTable;
    private ContentTable page;

    private static BackgroundSelectionManager selectionManager;

    public SearchPage(List<Product> products) {
        this.products = products;
        setHeight(Window.getClientHeight() + "px");

        List<DataList> model = getModel();

        FlowPanel flowPanel = new FlowPanel();
        flowPanel.setWidth("250px");
        flowPanel.getElement().getStyle().setFloat(Style.Float.LEFT);
        add(flowPanel);
        ContentTable contentPage = new ContentTable(model, 250);
        EditorTable editPage = new EditorTable(model, 800);

        SearchField sf = new SearchField(contentPage, editPage);
        sf.setWidth("240px");
        sf.getElement().getStyle().setMarginBottom(20, Style.Unit.PX);
        flowPanel.add(sf);

        contentPage.paint();
        flowPanel.add(contentPage);

        editPage.getElement().getStyle().setFloat(Style.Float.LEFT);

        add(editPage);
        editPage.paint();

        editPage.getElement().getStyle().setBackgroundColor("white");
        editPage.getElement().getStyle().setMarginLeft(50, Style.Unit.PX);
        flowPanel.getElement().getStyle().setMarginTop(30, Style.Unit.PX);
        editPage.getElement().getStyle().setMarginTop(30, Style.Unit.PX);
        flowPanel.getElement().getStyle().setMarginLeft(50, Style.Unit.PX);

        selectionManager = new BackgroundSelectionManager(editPage, contentPage);

    }


    private List<DataList> getModel() {
        return new EditProductModelGenerator().getModelList();
    }


    public static void onFocus(boolean fromContent, Data model) {
        selectionManager.inFocus(fromContent, model);
    }
}
