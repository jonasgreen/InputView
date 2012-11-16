package com.inputview.client.pages;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.warpview.WarpView;

/**
 *
 */
public class EditPage extends FlowPanel {

    public int width;
    public int right;

    public EditPage() {
        this.width = 1000;
        right = -width;
        setStyleName("editPage");
        setWidth(width + "px");
        setHeight(Window.getClientHeight() + "px");
        getElement().getStyle().setRight(right, Style.Unit.PX);
        addStyleName("animateEditPage");
        add(new WarpView());
    }


    public void show() {
        right = right < 0 ? 0 : -width;
        getElement().getStyle().setRight(right, Style.Unit.PX);
    }


    public void hide() {
        if(right < 0){
            return;
        }
        show();
    }
}
