package com.inputview.client.pages;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.model.Product;
import com.inputview.client.table.Table;

import java.util.List;

/**
 *
 */
public class SearchPage extends FlowPanel {

    private List<Product> products;
    private Table table;

    public SearchPage(List<Product> products) {
        this.products = products;
        setHeight(Window.getClientHeight() + "px");
        getElement().getStyle().setBackgroundColor("yellow");
        add(getTable());
    }



    public Table getTable() {
        if (table == null) {
            table = new Table(products);
        }
        return table;
    }




}
