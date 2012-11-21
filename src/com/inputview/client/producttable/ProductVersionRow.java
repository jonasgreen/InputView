package com.inputview.client.producttable;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.inputview.client.composittable.DataCell;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeParent;
import com.inputview.client.model.ProductVersion;
import com.inputview.client.model.Type;
import com.inputview.client.pages.InputViewPage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ProductVersionRow extends DivComposite<ProductVersion> {

    private FlowPanel colOne;
    private FlowPanel colTwo;
    private FlowPanel colThree;
    private FlowPanel colFour;
    private FlowPanel colTo;
    private Label plusMinus;


    protected ProductVersionRow(DivCompositeParent parent, ProductVersion model) {
        super(0, parent, model);
    }

    @Override
    protected void enterPressed() {
        InputViewPage.getEditPage().show();
    }

    @Override
    protected FlowPanel createContent(ProductVersion model) {
        FlowPanel panel = new FlowPanel();
        panel.add(getPlusMinus());
        panel.add(getColType());
        panel.add(getColName());
        panel.add(getColDraft());
        panel.add(getColFrom());
        panel.add(getColTo());
        return panel;
    }

    @Override
    protected List<DivComposite<?>> createChildren() {
        List<DivComposite<?>> list = new ArrayList<DivComposite<?>>();
        ProductVersion pv = new ProductVersion("C_NRK_34", model.getAuthor(), model.getReviewer(), model.getStartDate(), model.getEndDate(), Type.cover, false);
        list.add(new ProductVersionChildRow(this, pv));

        pv = new ProductVersion("C_YYY_04", model.getAuthor(), model.getReviewer(), model.getStartDate(), model.getEndDate(), Type.cover, false);
        list.add(new ProductVersionChildRow(this, pv));

        pv = new ProductVersion("C_KIK_03", model.getAuthor(), model.getReviewer(), model.getStartDate(), model.getEndDate(), Type.cover, false);
        list.add(new ProductVersionChildRow(this, pv));

        pv = new ProductVersion("C_ZXK_13", model.getAuthor(), model.getReviewer(), model.getStartDate(), model.getEndDate(), Type.cover, false);
        list.add(new ProductVersionChildRow(this, pv));
        return list;
    }


    @Override
    protected void onChildrenShow() {
        getPlusMinus().setText("-");
    }

    @Override
    protected void onChildrenHide() {
        getPlusMinus().setText("+");

    }


    public Label getPlusMinus() {
        if (plusMinus == null) {
            plusMinus = new Label("+");
            plusMinus.setStyleName("plusMinus");
            plusMinus.setWidth("10px");

        }
        return plusMinus;
    }


    public FlowPanel getColType() {
        if (colOne == null) {
            colOne = new DataCell(model.getType().name());
            colOne.setWidth("120px");
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

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}


}
