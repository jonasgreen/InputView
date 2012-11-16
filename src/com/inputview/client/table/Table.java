package com.inputview.client.table;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.inputview.client.model.Product;
import com.inputview.client.model.ProductVersion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Table extends FlowPanel {

    private List<Product> products;
    private List<Row> rows = new ArrayList<Row>();
    private CustomScrollPanel customScrollPanel;
    private FlowPanel rowPanel = new FlowPanel();

    public Table(List<Product> products) {
        this.products = products;
        //add(rowPanel);
        addHeaderRow();
        add(getCustomScrollPanel());
        addRows();
        getElement().getStyle().setPadding(40, Style.Unit.PX);
    }



    public ScrollPanel getCustomScrollPanel() {
        if (customScrollPanel == null) {
            customScrollPanel = new CustomScrollPanel(rowPanel);
            customScrollPanel.setHeight(Window.getClientHeight() - 150 + "px");
            customScrollPanel.setStyleName("customScrollPanel");

        }
        return customScrollPanel;
    }


    private void addHeaderRow() {
        FlowPanel panel = new FlowPanel();
        panel.setStyleName("table_header_row");

        Label label = new Label("Type");
        label.setStyleName("table_header");
        label.setWidth("96px");
        panel.add(label);

        label = new Label("Name");
        label.setStyleName("table_header");
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

        add(panel);

    }



    private void addRows() {
        for (Product p : products) {
            addProductRows(p);
        }
    }

    private void addProductRows(Product p) {

        for (ProductVersion version : p.getVersions()) {
            Row r = new Row(version, this);
            rows.add(r);
            rowPanel.add(r);
        }
    }


    public void down(Row r) {
        int index = rows.indexOf(r);
        if(index == rows.size()-1){
            return;
        }
        rows.get(index+1).setFocus(true);
    }

    public void up(Row r) {
        int index = rows.indexOf(r);
        if(index == 0){
            return;
        }
        rows.get(index-1).setFocus(true);
    }
}
