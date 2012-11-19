package com.inputview.client.pages;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.pagetabel.EditPageContentTable;
import com.inputview.client.producttable.ProductTable;
import com.inputview.client.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SearchPage extends FlowPanel {

    private List<Product> products;
    private ProductTable productTable;
    private EditPageContentTable page;

    public SearchPage(List<Product> products) {
        this.products = products;
        setHeight(Window.getClientHeight() + "px");
        add(getPage());
        getPage().paint();

    }



    public ProductTable getProductTable() {
        if (productTable == null) {
            productTable = new ProductTable(products);
        }
        return productTable;
    }

    public EditPageContentTable getPage() {
        if (page == null) {
            page = new EditPageContentTable(getModel());
        }
        return page;
    }

    private List<DataList> getModel() {
        List<DataList> list = new ArrayList<DataList>();

        DataList l = new DataList("First headline");
        l.add("Integer", 23);

        DataList lsub = new DataList("sub 1");
        lsub.add("sub value", 23);
        l.add(lsub);

        lsub = new DataList("sub 1");
        lsub.add("sub value 2", 23);
        l.add(lsub);

        lsub = new DataList("sub 1");
        lsub.add("sub value 3", 23);
        l.add(lsub);
        list.add(l);




        l = new DataList("Second headline");

        list.add(l);

        l = new DataList("Third headline");
        list.add(l);

        l = new DataList("Fourth headline");
        list.add(l);

        return list;

    }


}
