package com.inputview.client.uicomponents;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 */
public class TextComponent extends InputComponent<TextBox> {

    private TextBox textBox;

    public TextComponent(String description, int widthLabel, int widthInputWidget) {
        super(description, widthLabel, widthInputWidget);
    }

    @Override
    public TextBox getInputWidget() {
        if(textBox == null){
            textBox = new TextBox();
            textBox.setHeight("14px");
            textBox.getElement().getStyle().setFontSize(11, Style.Unit.PX);
            textBox.getElement().getStyle().setPadding(2, Style.Unit.PX);


        }
        return textBox;
    }
}
