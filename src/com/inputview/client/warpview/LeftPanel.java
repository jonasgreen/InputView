package com.inputview.client.warpview;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class LeftPanel extends FlowPanel {

    public LeftPanel() {
        setStyleName("left_panel");
        for (final Section section : WarpView.sections) {
            final Label l = new Label(section.getName());
            l.setStyleName("sections_left");
            l.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    WarpView.scrollPanel.ensureVisible(section.getLabel());

                    section.getLabelBackGround().getElement().getStyle().setBackgroundColor("#A3A3A3");
                    Timer t = new Timer() {
                        @Override
                        public void run() {
                            section.getLabelBackGround().getElement().getStyle().setBackgroundColor("white");
                        }
                    };

                    t.schedule(1000);

                }
            });
            l.addMouseOverHandler(new MouseOverHandler() {
                public void onMouseOver(MouseOverEvent event) {
                    l.getElement().getStyle().setCursor(Style.Cursor.POINTER);
                }
            });
            add(l);
        }
    }
}
