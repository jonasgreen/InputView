package com.inputview.client.uicomponents;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.CustomScrollPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 */
public class ScrollComponent extends CustomScrollPanel {

    private Timer verticalScrollTimer;

    public ScrollComponent(FlowPanel scrollPanelContent) {
        super(scrollPanelContent);
    }

    public void verticalScrollTo(Widget target) {
        if(verticalScrollTimer != null){
            verticalScrollTimer.cancel();
        }

        int targetPosition = target.getElement().getAbsoluteTop();
        int scrollPanelPosition = getElement().getAbsoluteTop();

        final boolean stepIsPositive = targetPosition - scrollPanelPosition > 0;
        final int endPosition = targetPosition - scrollPanelPosition + getVerticalScrollPosition();

        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                verticalScrollTimer = new Timer() {
                    @Override
                    public void run() {
                        int pos = getVerticalScrollbar().getVerticalScrollPosition();
                        int step = Math.abs(endPosition-pos) < 700 ? (stepIsPositive ? 10 : -10) : (stepIsPositive ? 70 : -70);

                        int nextPosition = pos + step;
                        if(getMaximumVerticalScrollPosition() < nextPosition){
                            stop(getMaximumVerticalScrollPosition());
                            return;
                        }
                        if (stepIsPositive && pos >= endPosition || !stepIsPositive && pos <= endPosition) {
                            stop(endPosition);
                            return;
                        }
                        setVerticalScrollPosition(nextPosition);
                    }

                    private void stop(int endPosition) {
                        System.out.println("STOP: "+endPosition);
                        cancel();

                        setVerticalScrollPosition(endPosition);
                        verticalScrollTimer = null;
                    }
                };

                verticalScrollTimer.scheduleRepeating(1);
            }
        });



    }



}
