package com.inputview.client.pages;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.composittable.ProductTable;
import com.inputview.client.model.Product;

import java.util.List;

/**
 *
 */
public class SearchPage extends FlowPanel {

    private List<Product> products;
    private ProductTable productTable;

    public SearchPage(List<Product> products) {
        this.products = products;
        setHeight(Window.getClientHeight() + "px");
        add(getProductTable());
        getProductTable().paint();
    }



    public ProductTable getProductTable() {
        if (productTable == null) {
            productTable = new ProductTable(products);
        }
        return productTable;
    }




}
