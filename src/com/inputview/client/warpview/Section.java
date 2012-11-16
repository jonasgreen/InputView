package com.inputview.client.warpview;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Label;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Section {

    private List<InputField> fields = new ArrayList<InputField>();
    private Label label;
    private FlowPanel labelBackGround = new FlowPanel();

    private String name;
    private String id = "" + WarpView.idCount++;

    public Section(String name) {
        this.name = name;
        this.label = new Label(name);
        this.label.setStyleName("headline");
        this.label.getElement().getStyle().setProperty("clear", "both");
        this.labelBackGround.setWidth("100%");
        this.labelBackGround.setStyleName("background_color");
    }


    public void addInput(String name, FocusWidget w) {
        fields.add(new InputField(name, w));
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<InputField> getFields() {
        return fields;
    }

    public Label getLabel() {
        return label;
    }

    public FlowPanel getLabelBackGround() {
        return labelBackGround;
    }
}
