package com.inputview.client.pages;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.model.Product;

import java.util.List;

/**
 *
 */
public class InputViewPage extends FlowPanel {

    private static List<Product> modelList;

    private static EditPage editPage;
    private static SearchPage searchPage;


    public InputViewPage(List<Product> modelList) {
        this.modelList = modelList;
        add(getSearchPage());
        add(getEditPage());
    }

    public static SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage(modelList);
            searchPage.getElement().getStyle().setFloat(Style.Float.LEFT);
        }
        return searchPage;
    }

    public static EditPage getEditPage() {
        if (editPage == null) {
            editPage = new EditPage();
        }
        return editPage;
    }


}
