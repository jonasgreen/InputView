package com.inputview.client.producttable;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeRoot;
import com.inputview.client.model.Product;
import com.inputview.client.model.ProductVersion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ProductTable extends DivCompositeRoot<ProductVersion> {
    private List<Product> products;

    public ProductTable(List<Product> products) {
        super(400);
        this.products = products;
        getElement().getStyle().setPadding(40, Style.Unit.PX);
    }


    @Override
    public List<DivComposite<ProductVersion>> createRows() {
        List<DivComposite<ProductVersion>> rows = new ArrayList<DivComposite<ProductVersion>>();
        for (Product p : products) {
            for (ProductVersion version : p.getVersions()) {
                rows.add(new ProductVersionRow(this, version));
            }
        }
        return rows;
    }

    @Override
    public FlowPanel createHeader() {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("table_header_row");

        Label label = new Label("Type");
        label.setStyleName("table_header");
        label.setWidth("114px");
        label.getElement().getStyle().setPaddingLeft(18, Style.Unit.PX);

        panel.add(label);

        label = new Label("Name");
        label.setStyleName("table_header");
        label.setWidth("110px");
        panel.add(label);

        FlowPanel fl = new FlowPanel();
        HTML html = new HTML("&nbsp;");
        fl.add(html);
        fl.setStyleName("table_header");
        fl.setWidth("70px");
        panel.add(fl);


        label = new Label("From");
        label.setStyleName("table_header");
        label.setWidth("78px");
        panel.add(label);


        label = new Label("To");
        label.setStyleName("table_header");
        label.setWidth("70px");
        panel.add(label);

        return panel;
    }

    @Override
    public int getTableHeight() {
        return Window.getClientHeight() - 150;
    }



}
