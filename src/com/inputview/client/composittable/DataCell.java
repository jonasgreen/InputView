package com.inputview.client.composittable;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 */
public class DataCell extends FlowPanel {

    private Widget child;


    public DataCell(String value) {
        this(20, value);
    }

    public DataCell(int width, String value) {
        getElement().getStyle().setFloat(Style.Float.LEFT);
        setWidth(width+"px");
        setStyleName("dataCell");
        if (value == null || value.equals("")) {
            this.child = new HTML("&nbsp;");
        }
        else {
            child = new Label(value);
        }

        add(child);
    }

    public void setText(String text){
        if(child instanceof Label){
            ((Label) child).setText(text);
        }
        else{
            child.removeFromParent();
            child = new Label(text);
            add(child);
        }
    }


}
