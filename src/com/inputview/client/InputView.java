package com.inputview.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;
import com.inputview.client.model.ModelGenerator;
import com.inputview.client.pages.InputViewPage;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InputView implements EntryPoint {

    public void onModuleLoad() {

        RootPanel.getBodyElement().getStyle().setMargin(0, Style.Unit.PX);
        RootPanel.get("panel").add(new InputViewPage(new ModelGenerator().getModelList()));

        setupSingleAppKeyboardShortcuts();
    }


    public void setupSingleAppKeyboardShortcuts() {
        // Define an inner class to handle the event
        Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
            public void onPreviewNativeEvent(Event.NativePreviewEvent preview) {
                if(KeyCodes.KEY_ESCAPE == preview.getNativeEvent().getKeyCode()){
                    InputViewPage.getEditPage().hide();
                }
            }
        });
    }



}
