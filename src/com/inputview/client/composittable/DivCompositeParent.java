package com.inputview.client.composittable;


/**
 *
 */
public interface DivCompositeParent<M>{

    public void onResize();

    public void down(DivComposite<M> widgets);
    public void up(DivComposite<M> widgets);
    public M getModel();

    public void showChildren();
}
