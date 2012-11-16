package com.inputview.client.warpview;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

/**
 *
 */
public class MiddlePanel extends FlowPanel {



    public MiddlePanel() {
        int i = 0;
        setStyleName("middle_panel");
        addSectionOne(WarpView.sections.get(0));
        addSpace();
        addSectionTwo(WarpView.sections.get(1));
        addSpace();
        addSectionThree(WarpView.sections.get(2));
        addSpace();
        addSectionFour(WarpView.sections.get(3));

    }

    private void addSpace() {
        FlowPanel f = new FlowPanel();
        f.getElement().getStyle().setBackgroundColor("#444D52");
        f.getElement().getStyle().setProperty("clear", "both");

        add(f);
        f.setHeight("20px");
    }


    private void addSectionOne(Section s) {
        addSectionHeader(s);
        add(getDummyTextShort());
        addInput(s.getFields().get(0));
    }

    private void addSectionHeader(Section s) {

        add(s.getLabelBackGround());
        s.getLabelBackGround().add(s.getLabel());
    }

    private void addSectionTwo(Section s) {
        addSectionHeader(s);
        add(getDummyTextLong());
        addInput(s.getFields().get(0));
        add(getDummyTextShort());

        addInput(s.getFields().get(1));

    }

    private void addSectionThree(Section s) {
        addSectionHeader(s);
        add(getDummyTextLong());

        add(getDummyTextShort());
        add(getDummyTextLong());
        add(getDummyTextLong());
        add(getDummyTextShort());
        add(getDummyTextLong());
        add(getDummyTextLong());
        add(getDummyTextLong());



        addInput(s.getFields().get(0));

    }

    private void addSectionFour(Section s) {
        addSectionHeader(s);
        s.getLabelBackGround().getElement().getStyle().setPaddingBottom(20, Style.Unit.PX);
        addInput(s.getFields().get(0));
        add(getDummyTextShort());
    }


    private HTML getDummyTextLong() {
        return new HTML("<div style=\"clear:both;\"><p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line i.</p></div>");
    }

    private HTML getDummyTextShort() {
        return new HTML("<div style=\"clear:both;\"><p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting.</p></div>");
    }

    private void addInput(InputField f){
        f.getLabel().setStyleName("input_field_name");
        add(f.getLabel());

        f.getFocusWidget().setStyleName("input_field_value");
        add(f.getFocusWidget());
    }
}
