package com.inputview.client.table;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class Column extends FlowPanel {

    private String value;
    private Label label;

    public Column(String value) {
        this.value = value;
        getElement().getStyle().setFloat(Style.Float.LEFT);
        setStyleName("column");
        setWidth("150px");
        if (value == null || value.equals("")) {
            add(new HTML("&nbsp;"));
        }
        else {
            add(getLabel());
        }
    }


    public Label getLabel() {
        if (label == null) {
            label = new Label(value);
            label.setStyleName("columnLabel");

        }
        return label;
    }
}
