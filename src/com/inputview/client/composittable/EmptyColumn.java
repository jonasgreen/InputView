package com.inputview.client.composittable;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class EmptyColumn extends FlowPanel {

    public EmptyColumn() {
        getElement().getStyle().setFloat(Style.Float.LEFT);
        setWidth("20px");
        add(new HTML("&nbsp;"));
    }

}
