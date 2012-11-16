package com.inputview.client.warpview;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RightPanel extends FlowPanel {


    public static List<Sputs> sputs = new ArrayList<Sputs>();
    public static FlowPanel cursorPanel = new FlowPanel();


    public RightPanel() {
        setStyleName("right_panel");

        this.sputs.add(new Sputs(8, WarpView.sections.get(0).getFields().get(0)));
        this.sputs.add(new Sputs(20, WarpView.sections.get(1).getFields().get(0)));
        this.sputs.add(new Sputs(24, WarpView.sections.get(1).getFields().get(1)));
        this.sputs.add(new Sputs(88, WarpView.sections.get(2).getFields().get(0)));
        this.sputs.add(new Sputs(93, WarpView.sections.get(3).getFields().get(0)));

        for (Sputs sput : sputs) {
            add(sput);
        }

        Window.addResizeHandler(new ResizeHandler() {
            public void onResize(ResizeEvent event) {
                setHeight(event.getHeight() - 40 + "px");
                WarpView.scrollPanel.setHeight(event.getHeight() - 40 + "px");
                updateSputs(event.getHeight() - 40);
            }
        });

        updateSputs(Window.getClientHeight() - 40);
        cursorPanel.setHeight("60px");
        cursorPanel.setWidth("20px");
        cursorPanel.getElement().getStyle().setOpacity(0.3);
        cursorPanel.getElement().getStyle().setBackgroundColor("yellow");

        cursorPanel.getElement().getStyle().setPosition(Style.Position.RELATIVE);
        cursorPanel.getElement().getStyle().setTop(0, Style.Unit.PX);
        add(cursorPanel);
    }

    public void updateSputs(int totalHeight) {
        for (Sputs sput : sputs) {
            sput.update(totalHeight);
        }
    }

    public void updateCursorPanel(int position) {
        int value = position - 20;
        if (value > Window.getClientHeight() - 120) {
            value = Window.getClientHeight() - 120;
        }
        cursorPanel.getElement().getStyle().setTop(value, Style.Unit.PX);

    }

}
