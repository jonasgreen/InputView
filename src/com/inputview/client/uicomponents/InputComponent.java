package com.inputview.client.uicomponents;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.*;

/**
 *
 */
public abstract class InputComponent<T extends FocusWidget> extends FlowPanel{

    private Label label;
    private int widthLabel;
    private int widthWidgetInput;

    protected InputComponent(String description, int widthLabel, int widthInputWidget) {
        this.widthLabel = widthLabel;
        this.widthWidgetInput = widthInputWidget;
        getLabel().setText(description);
        add(getLabel());
        add(getInputWidget());
        getInputWidget().getElement().getStyle().setFloat(Style.Float.LEFT);
        getInputWidget().getElement().getStyle().setMarginLeft(40, Style.Unit.PX);
        getInputWidget().setWidth(widthInputWidget+"px");

        getInputWidget().addFocusHandler(new FocusHandler() {
            @Override
            public void onFocus(FocusEvent event) {
                addStyleName("myText");
            }
        });

        getInputWidget().addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                removeStyleName("myText");
            }
        });

    }

    public Label getLabel() {
        if (label == null) {
            label = new Label();
            label.setWidth(widthLabel+"px");
            label.getElement().getStyle().setFloat(Style.Float.LEFT);
        }
        return label;
    }

    public abstract T getInputWidget();




}
