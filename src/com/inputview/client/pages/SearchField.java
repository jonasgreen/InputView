package com.inputview.client.pages;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.TextBox;
import com.inputview.client.compositemodel.DataList;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.pagetabel.ContentTable;
import com.inputview.client.pagetabel.EditorTable;

/**
 *
 */
public class SearchField extends TextBox {

    private static String DEFAULT_TEXT = "search...";
    private ContentTable contentTable;
    private EditorTable editTable;


    public SearchField(ContentTable contentTable, EditorTable editTable) {
        this.editTable = editTable;
        this.contentTable = contentTable;

        onBlur();
        addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                search();
            }
        });

        addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                SearchField.this.onBlur();
            }
        });

        addFocusHandler(new FocusHandler() {
            @Override
            public void onFocus(FocusEvent event) {
                SearchField.this.onFocus();
            }
        });
    }

    private void onFocus() {
        String text = getText();
        if (text != null && text.equals(DEFAULT_TEXT)) {
            setText("");
            getElement().getStyle().setFontStyle(Style.FontStyle.NORMAL);
        }

        getElement().getStyle().setColor("rgb(51,51,51)");
    }

    private void onBlur() {
        String text = getText();
        if (text == null || text.equals("")) {
            setText(DEFAULT_TEXT);
            getElement().getStyle().setColor("grey");
            getElement().getStyle().setFontStyle(Style.FontStyle.ITALIC);
        }
    }

    private void search() {
        String text = getText();
        if (text == null || text.equals("")) {
            showAll();
            return;
        }
        showAll(text);
    }

    private void showAll(String text) {
        for (DivComposite<DataList> child : editTable.getRows()) {
            child.showChildrenThatContains(text);
        }

        editTable.getCustomScrollPanel().onResize();
    }

    private void showAll() {
        showAll("");

    }


}
