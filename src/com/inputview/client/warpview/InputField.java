package com.inputview.client.warpview;

import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class InputField {

    Label label;
    private FocusWidget focusWidget;
    private String name;
    private String id = ""+WarpView.idCount++;

    public InputField(String name, FocusWidget w) {
        this.label = new Label(name);
        this.name = name;
        this.focusWidget = w;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public FocusWidget getFocusWidget() {
        return focusWidget;
    }


    public Label getLabel() {
        return label;
    }
}
