package com.inputview.client.pagetabel;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 */
public class EditorRowListStyle {

    public static void style(int tabIndex, FlowPanel cell){
        Style style = cell.getElement().getStyle();
        if(tabIndex == 0){
            style.setFontSize(22, Style.Unit.PX);
        }
        else if(tabIndex == 1){
            style.setFontSize(14, Style.Unit.PX);

        }
        else if(tabIndex == 2){
            style.setFontSize(12, Style.Unit.PX);
            style.setFontWeight(Style.FontWeight.BOLD);
        }
        style.setPadding(6, Style.Unit.PX);
        style.setPaddingTop(12, Style.Unit.PX);


    }

}
