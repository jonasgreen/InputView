package com.inputview.client.composittable;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.inputview.client.compositemodel.Data;

import java.util.List;


/**
 *
 */
public abstract class DivComposite<M> extends FlowPanel implements DivCompositeParent<M> {

    private static int idCount = 1;
    private int id = idCount++;

    protected int tabIndex;

    protected M model;
    protected DivCompositeParent<M> parent;
    protected List<DivComposite<?>> divCompositeChildren;

    private FocusPanel focusPanel = new FocusPanel();
    private FlowPanel content;
    private FlowPanel childrenHolder;

    protected DivComposite(int tabIndex, DivCompositeParent parent, M model) {
        this.tabIndex = tabIndex;
        this.model = model;
        this.parent = parent;
        add(focusPanel);
        focusPanel.add(getContent());

        focusPanel.addClickHandler(getClickHandler());
        focusPanel.addDoubleClickHandler(getDoubleClickHandler());
        focusPanel.addKeyDownHandler(getKeyDownHandler());
        focusPanel.addMouseOverHandler(getMouseOverHandler());
        focusPanel.addFocusHandler(getFocusHandler());
        focusPanel.addBlurHandler(getBlurHandler());

        setStyleName("row");
        focusPanel.setStyleName("rowPrimaryContent");
        content.setStyleName("rowContent");

    }

    protected ClickHandler getClickHandler() {
        return new ClickHandler() {
            public void onClick(ClickEvent event) {
                //   toggleChildren();
                event.stopPropagation();
                event.preventDefault();
            }
        };
    }

    protected MouseOverHandler getMouseOverHandler() {
        return new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        };
    }

    protected FocusHandler getFocusHandler() {
        return new FocusHandler() {
            public void onFocus(FocusEvent event) {
                styleOnFocus();
            }
        };
    }

    protected void styleOnFocus() {
    }

    protected BlurHandler getBlurHandler() {
        return new BlurHandler() {
            public void onBlur(BlurEvent event) {
                styleOnBlur();
            }
        };
    }

    protected void styleOnBlur() {
        getFocusPanel().getElement().getStyle().setBackgroundColor("transparent");
        getFocusPanel().getElement().getStyle().setColor("rgb(51,51,51)");
    }

    protected DoubleClickHandler getDoubleClickHandler() {
        return new DoubleClickHandler() {
            public void onDoubleClick(DoubleClickEvent event) {

                event.stopPropagation();
                event.preventDefault();
            }
        };
    }

    public abstract String getDescription();

    public FocusPanel getFocusPanel() {
        if (focusPanel == null) {
            focusPanel = new FocusPanel();
        }
        return focusPanel;
    }

    protected KeyDownHandler getKeyDownHandler() {
        return new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (KeyCodes.KEY_DOWN == event.getNativeKeyCode()) {
                    down(DivComposite.this);
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_UP == event.getNativeKeyCode()) {
                    up(DivComposite.this);
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_RIGHT == event.getNativeKeyCode()) {
                    showChildren();
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_LEFT == event.getNativeKeyCode()) {
                    hideChildren();
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_ENTER == event.getNativeKeyCode()) {
                    enterPressed();
                    event.stopPropagation();
                    event.preventDefault();
                }
            }
        };
    }

    protected abstract void enterPressed();

    public void showChildren() {
        if (childrenHolder == null) {
            enableChildren();
        }
        else if (!childrenHolder.isAttached()) {
            add(childrenHolder);
            onChildrenShow();
        }
        parent.showChildren();
    }

    protected boolean childrenIsShowing() {
        return childrenHolder != null && childrenHolder.isAttached() && divCompositeChildren != null && divCompositeChildren.size() != 0;
    }

    protected void hideChildren() {
        if (childrenHolder == null || !childrenHolder.isAttached()) {
            return;
        }
        childrenHolder.removeFromParent();
        onChildrenHide();
    }

    protected void toggleChildren() {
        System.out.println("toggle");
        if (childrenHolder == null) {
            enableChildren();
        }
        else {
            if (childrenHolder.isAttached()) {
                childrenHolder.removeFromParent();
                onChildrenHide();
            }
            else {
                add(childrenHolder);
                onChildrenShow();
            }
        }
    }

    private void enableChildren() {
        childrenHolder = new FlowPanel();
        add(childrenHolder);
        List<DivComposite<?>> children = getDivCompositeChildren();
        if (children != null && !children.isEmpty()) {
            for (DivComposite<?> child : children) {
                childrenHolder.add(child);
            }
        }
        onChildrenShow();
    }

    public List<DivComposite<?>> getDivCompositeChildren() {
        if (divCompositeChildren == null) {
            divCompositeChildren = createChildren();
        }
        return divCompositeChildren;
    }


    public FlowPanel getContent() {
        if (content == null) {
            content = createContent(model);
        }
        return content;
    }

    protected abstract void onChildrenShow();

    protected abstract void onChildrenHide();

    protected abstract FlowPanel createContent(M model);

    protected abstract List<DivComposite<?>> createChildren();


    public void onResize() {
        if (parent != null) {
            parent.onResize();
        }
    }


    public void down(DivComposite<M> r) {
        if (childrenIsShowing()) {
            int index = divCompositeChildren.indexOf(r);
            //if last
            if (index == divCompositeChildren.size() - 1) {
                if (parent != null) {
                    parent.down(this);
                }
            }
            else {
                divCompositeChildren.get(index + 1).setFocusDown(true);
            }
        }
        else {
            parent.down(this);
        }

    }

    public void setFocus(boolean focus) {
        focusPanel.setFocus(focus);
    }

    public void setFocusDown(boolean focus) {
        focusPanel.setFocus(focus);
    }

    public void setFocusUp(boolean focus) {
        if (childrenIsShowing()) {
            divCompositeChildren.get(divCompositeChildren.size() - 1).setFocusUp(true);
        }
        else {
            focusPanel.setFocus(focus);
        }
    }


    public void up(DivComposite<M> r) {
        if (childrenIsShowing()) {
            int index = divCompositeChildren.indexOf(r);
            //not from a child
            if (index == -1) {
                parent.up(this);
            }
            //if first
            else if (index == 0) {
                setFocus(true);
            }
            else {
                divCompositeChildren.get(index - 1).setFocusUp(true);
            }
        }
        else {
            parent.up(this);
        }


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DivComposite widgets = (DivComposite) o;

        if (id != widgets.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public M getModel() {
        return model;
    }

    public DivComposite<?> getElement(Data modelOfConcern) {
        if (model.equals(modelOfConcern)) {
            return this;
        }

        if (hasChildren()) {
            for (DivComposite<?> child : getDivCompositeChildren()) {
                DivComposite<?> dc = child.getElement(modelOfConcern);
                if (dc != null) {
                    return dc;
                }
            }
        }
        return null;
    }

    public void collapse(boolean recursive) {
        if (childrenIsShowing()) {
            hideChildren();
        }
        if (recursive) {
            for (DivComposite<?> child : getDivCompositeChildren()) {
                child.collapse(true);
            }
        }
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public boolean showChildrenThatContains(String text) {
        boolean containsText = false;

        if (hasChildren()) {
            for (DivComposite<?> div : getDivCompositeChildren()) {
                containsText = div.showChildrenThatContains(text) || containsText;
            }
        }

        containsText = getDescription().contains(text) || containsText;
        getFocusPanel().setVisible(containsText);

        if (containsText) {
            System.out.println("return " + getDescription() + ":  " + containsText);
        }

        return containsText;

    }

    private boolean hasChildren() {
        return getDivCompositeChildren() != null && !getDivCompositeChildren().isEmpty();
    }
}
