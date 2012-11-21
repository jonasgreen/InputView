package com.inputview.client.producttable;

import com.google.gwt.user.client.ui.FlowPanel;
import com.inputview.client.composittable.DataCell;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeParent;
import com.inputview.client.model.ProductVersion;
import com.inputview.client.pages.InputViewPage;

import java.util.List;

/**
 *
 */
public class ProductVersionChildRow extends DivComposite<ProductVersion> {

    private FlowPanel colOne;
    private FlowPanel colTwo;
    private FlowPanel colThree;
    private FlowPanel colFour;
    private FlowPanel colTo;
    private FlowPanel colEmpty;


    protected ProductVersionChildRow(DivCompositeParent parent, ProductVersion model) {
        super(1, parent, model);
        setStyleName("row_child");
    }

    @Override
    protected void enterPressed() {
        InputViewPage.getEditPage().show();
    }


    @Override
    protected FlowPanel createContent(ProductVersion model) {
        FlowPanel panel = new FlowPanel();
        panel.add(getColEmpty());
        panel.add(getColType());
        panel.add(getColName());
        panel.add(getColDraft());
        panel.add(getColFrom());
        panel.add(getColTo());
        return panel;
    }

    @Override
    protected List<DivComposite<?>> createChildren() {
        return null;
    }



    @Override
    protected void onChildrenShow() {
    }

    @Override
    protected void onChildrenHide() {
    }



    public FlowPanel getColType() {
        if (colOne == null) {
            colOne = new DataCell("cover");
            colOne.setWidth("94px");
        }
        return colOne;
    }

    public FlowPanel getColName() {
        if (colTwo == null) {
            colTwo = new DataCell(model.getName());
            colTwo.setWidth("120px");

        }
        return colTwo;
    }

    public FlowPanel getColEmpty() {
        if (colEmpty == null) {
            colEmpty = new DataCell("");
            colEmpty.setWidth("40px");
        }
        return colEmpty;
    }

    public FlowPanel getColDraft() {
        if (colThree == null) {
            colThree = new DataCell(model.isDraft() ? "Kladde" : "");
            colThree.setWidth("70px");
        }
        return colThree;
    }

    public FlowPanel getColFrom() {
        if (colFour == null) {
            colFour = new DataCell(model.getStartDate());
            colFour.setWidth("90px");
        }
        return colFour;
    }

    public FlowPanel getColTo() {
        if (colTo == null) {
            colTo = new DataCell(model.getEndDate());
            colTo.setWidth("90px");
        }
        return colTo;
    }

    protected void styleOnFocus() {
        getFocusPanel().getElement().getStyle().setBackgroundColor("rgb(255,135,0)");
        getFocusPanel().getElement().getStyle().setColor("white");
    }

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}



}
