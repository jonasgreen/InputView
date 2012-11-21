package com.inputview.client.composittable;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

/**
 *
 */
public class EmptyColumn extends FlowPanel {

    public EmptyColumn() {
        getElement().getStyle().setFloat(Style.Float.LEFT);
        HTML w = new HTML("&nbsp;");
        w.setWidth("20px");
        add(w);
    }

}
