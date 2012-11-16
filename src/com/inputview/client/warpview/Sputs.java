package com.inputview.client.warpview;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 */
public class Sputs extends FlowPanel implements HasClickHandlers, HasMouseOverHandlers{


    private double procent;
    private final InputField field;

    public Sputs(double procent, InputField f) {
        this.setTitle(f.getName());
        this.setHeight(4+"px");
        this.setWidth(20 + "px");
        this.field = f;
        this.procent = procent;
        getElement().getStyle().setZIndex(30);

        getElement().getStyle().setPosition(Style.Position.RELATIVE);
        getElement().getStyle().setBackgroundColor("#CC0000");
        addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                WarpView.scrollPanel.ensureVisible(field.getFocusWidget());
                field.getFocusWidget().setFocus(true);

                field.getLabel().getElement().getStyle().setBorderColor("blue");
                Timer t = new Timer() {
                    @Override
                    public void run() {
                        field.getLabel().getElement().getStyle().setBorderColor("white");
                    }
                };

                t.schedule(1000);




            }
        });

        addMouseOverHandler(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });
    }

    public void update(double totalHeight){
        double value = procent * (totalHeight / 100);
        getElement().getStyle().setTop(value, Style.Unit.PX);
    }


    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }


    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }

    public void updateColor(String s) {
        getElement().getStyle().setBackgroundColor(s);
        field.getLabel().getElement().getStyle().setColor(s);
    }
}
