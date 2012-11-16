package com.inputview.client.warpview;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class WarpView extends FlowPanel {

    FlowPanel content = new FlowPanel();

    public static FlowPanel top = new FlowPanel();
    public static FlowPanel bottom = new FlowPanel();
    public static RightPanel rp;


    public static MiddlePanel mp;

    public static int idCount = 0;

    public static List<Section> sections = new ArrayList<Section>();

    public static CustomScrollPanel scrollPanel;



    public WarpView() {
        setWidth("100%");
        getElement().getStyle().setBackgroundColor("#444D52");
        getElement().getStyle().setColor("#333333");


        content.getElement().getStyle().setMargin(0, Style.Unit.PX);
        content.getElement().getStyle().setProperty("margin", "auto");
        content.setWidth("1000px");
        add(content);


        initSections();

        top.getElement().getStyle().setBackgroundColor("#444D52");
        top.setHeight("20px");
        top.setWidth("700px");
        top.getElement().getStyle().setPaddingLeft(220, Style.Unit.PX);
        top.getElement().getStyle().setZIndex(20000000);
        content.add(top);


        LeftPanel lp = new LeftPanel();
        lp.setHeight("260px");
        lp.setWidth("200px");
        lp.getElement().getStyle().setBackgroundColor("darkgrey");
        lp.getElement().getStyle().setFloat(Style.Float.LEFT);
        content.add(lp);

        mp = new MiddlePanel();
        scrollPanel = new CustomScrollPanel(mp);
        scrollPanel.getElement().getStyle().setBackgroundColor("white");


        mp.setWidth("700px");
        mp.getElement().getStyle().setFloat(Style.Float.LEFT);
        mp.getElement().getStyle().setBackgroundColor("white");

        content.add(scrollPanel);
        scrollPanel.getElement().getStyle().setFloat(Style.Float.LEFT);

        scrollPanel.setHeight(Window.getClientHeight()-40 + "px");
        scrollPanel.setWidth("700px");
        scrollPanel.setAlwaysShowScrollBars(false);
        scrollPanel.removeVerticalScrollbar();


        rp  = new RightPanel();
        rp.setHeight(Window.getClientHeight()-40+"px");
        rp.setWidth("20px");
        rp.getElement().getStyle().setBackgroundColor("darkgrey");
        rp.getElement().getStyle().setFloat(Style.Float.LEFT);
        content.add(rp);

        content.add(bottom);
        bottom.getElement().getStyle().setBackgroundColor("#444D52");
        bottom.setHeight("20px");
        bottom.setWidth("1000px");

        scrollPanel.addScrollHandler(new ScrollHandler() {
            public void onScroll(ScrollEvent event) {
                updateTopAndBottom();
            }
        });

        updateTopAndBottom();

    }



    private void initSections() {
        Section firmaaftale = new Section("Aftaletype");
        final ListBox w = new ListBox();
        w.addItem("");
        w.addItem("Dyr");
        w.addItem("Mellem");
        w.addItem("Billig");
        w.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if(w.getValue(w.getSelectedIndex()).equals("")){
                    RightPanel.sputs.get(0).updateColor("#CC0000");
                }
                else{
                    RightPanel.sputs.get(0).updateColor("green");
                }
            }
        });

        firmaaftale.addInput("Vælg aftale", w);
        sections.add(firmaaftale);


        Section sygdom = new Section("Helbredsoplysninger");
        final CheckBox w1 = new CheckBox();
        w1.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                if(!w1.getValue()){
                    RightPanel.sputs.get(1).updateColor("#CC0000");
                }
                else{
                    RightPanel.sputs.get(1).updateColor("green");
                }
            }
        });
        sygdom.addInput("Har haft mæslinger", w1);

        final TextArea textArea = new TextArea();
        textArea.setWidth("360px");
        textArea.setHeight("40px");
        //textArea.setHeight("");
        sygdom.addInput("Angiv astmasymptomer", textArea);
        textArea.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {

                if(textArea.getText() == null || textArea.getText().equals("") ){
                    RightPanel.sputs.get(2).updateColor("#CC0000");
                }
                else{
                    RightPanel.sputs.get(2).updateColor("green");
                }

            }
        });




        sections.add(sygdom);

        Section invaliditet = new Section("Invaliditet");
        final TextBox tb = new TextBox();

        tb.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {

                if(tb.getText() == null || tb.getText().equals("") ){
                    RightPanel.sputs.get(3).updateColor("#CC0000");
                }
                else{
                    RightPanel.sputs.get(3).updateColor("green");
                }

            }
        });

        tb.setWidth("200px");
        invaliditet.addInput("Anden form for invaliditet", tb);
        sections.add(invaliditet);

        Section bonusordning = new Section("Bonusordning");
        final ListBox w2 = new ListBox();
        w2.addItem("");
        w2.addItem("Fuld");
        w2.addItem("Medium");
        w2.addItem("Lav");

        w2.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if(w2.getValue(w2.getSelectedIndex()).equals("")){
                    RightPanel.sputs.get(4).updateColor("#CC0000");
                }
                else{
                    RightPanel.sputs.get(4).updateColor("green");
                }
            }
        });

        bonusordning.addInput("Får bonus", w2);
        sections.add(bonusordning);
    }

    public static void updateTopAndBottom(){
        rp.updateCursorPanel(scrollPanel.getVerticalScrollPosition());


    }
}
