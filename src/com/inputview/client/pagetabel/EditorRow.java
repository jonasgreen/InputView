package com.inputview.client.pagetabel;

import com.inputview.client.compositemodel.Data;
import com.inputview.client.composittable.DivComposite;
import com.inputview.client.composittable.DivCompositeParent;

import java.util.List;

/**
 *
 */
public abstract class EditorRow<T extends Data> extends DivComposite<T> {

    protected EditorRow(int tabIndex, DivCompositeParent parent, T model) {
        super(tabIndex, parent, model);
        removeStyleName("row");
        showChildren();
    }


    @Override
    public String getDescription() {
        return model.getDescription();
    }

    @Override
    protected void enterPressed() {
    }

    protected void hideChildren() {
    }

    @Override
    protected void onChildrenShow() {
    }

    @Override
    protected void onChildrenHide() {
    }

    @Override
    public void styleOnBlur(){
        super.styleOnBlur();
    }


    @Override
    protected List<DivComposite<?>> createChildren() {
        return null;
    }

}
