package com.inputview.client.composittable;

import com.google.gwt.event.logical.shared.ResizeEvent;

/**
 *
 */
public class OnResizeEvent extends ResizeEvent {
    /**
     * Construct a new {@link com.google.gwt.event.logical.shared.ResizeEvent}.
     *
     * @param width  the new width
     * @param height the new height
     */
    protected OnResizeEvent(int width, int height) {
        super(width, height);
    }
}
