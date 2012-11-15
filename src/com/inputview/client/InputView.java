package com.inputview.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.inputview.client.model.ModelGenerator;
import com.inputview.client.model.Product;
import com.inputview.client.pages.SearchPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InputView implements EntryPoint {
	public void onModuleLoad() {

        RootPanel.getBodyElement().getStyle().setMargin(0, Style.Unit.PX);

        FlowPanel panel = new FlowPanel();
        RootPanel.get("panel").add(panel);

        List<Product> modelList = new ModelGenerator().getModelList();

        SearchPage searchPage = new SearchPage(modelList);
        panel.add(searchPage);



	}



}
