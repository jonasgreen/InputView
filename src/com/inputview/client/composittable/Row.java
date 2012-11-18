package com.inputview.client.composittable;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.inputview.client.model.TableLine;

/**
 *
 */
public class Row implements HasClickHandlers, HasMouseOverHandlers, HasFocusHandlers {

   /* FlowPanel content = new FlowPanel();
    FlowPanel primaryContent = new FlowPanel();
    private ProductTable child;

    private TableLine model;
    //private DivTableComposite parent;
    private Label plusMinus;

    public Row(TableLine model, DivTableComposite DivTable) {
        this.parent = DivTable;
        this.model = model;
        setStyleName("row");
        primaryContent.setStyleName("rowPrimaryContent");
        content.setStyleName("rowContent");
        if (model.isDraft()) {
            getElement().getStyle().setBackgroundColor("rgb(247,247,247)");
            getElement().getStyle().setColor("rgb(151,151,151)");
        }



        content.add(primaryContent);

        add(content);
        addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                InputViewPage.getEditPage().hide();
                event.stopPropagation();
                event.preventDefault();
            }
        });


        addFocusHandler(new FocusHandler() {
            public void onFocus(FocusEvent event) {
                primaryContent.getElement().getStyle().setBackgroundColor("rgb(77,98,62)");
                if (Row.this.model.isDraft()) {
                }
                else {
                    primaryContent.getElement().getStyle().setColor("white");
                }
            }
        });

        addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {

                if (Row.this.model.isDraft()) {
                    primaryContent.getElement().getStyle().setBackgroundColor("rgb(247,247,247)");
                }
                else {
                    primaryContent.getElement().getStyle().setBackgroundColor("white");
                    primaryContent.getElement().getStyle().setColor("rgb(51,51,51)");
                }
            }
        });

        addMouseOverHandler(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });

        addDoubleClickHandler(new DoubleClickHandler() {
            public void onDoubleClick(DoubleClickEvent event) {
                showEditPage();
                event.stopPropagation();
                event.preventDefault();
            }
        });

        addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (KeyCodes.KEY_DOWN == event.getNativeKeyCode()) {
                    parent.down(Row.this);
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_UP == event.getNativeKeyCode()) {
                    parent.up(Row.this);
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_RIGHT == event.getNativeKeyCode()) {
                    addChild();
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_LEFT == event.getNativeKeyCode()) {
                    removeChild();
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if (KeyCodes.KEY_ENTER == event.getNativeKeyCode()) {
                    showEditPage();
                    event.stopPropagation();
                    event.preventDefault();
                }
            }
        });
    }

    private void showEditPage() {
        InputViewPage.getEditPage().show();
    }


    private void addChild() {
        if(child != null){
            return;
        }
        getPlusMinus().setText("-");
        child = new Table(new ModelGenerator().getModelList());
        child.getElement().getStyle().setBackgroundColor("yellow");
        child.getElement().getStyle().setClear(Style.Clear.BOTH);
        content.add(child);

        Table.EVENT_BUS.fireEvent(new OnResizeEvent(0,0));
    }

    private void removeChild() {
        if(child != null){
            child.removeFromParent();
            child = null;
        }
        getPlusMinus().setText("+");
        Table.EVENT_BUS.fireEvent(new OnResizeEvent(0,0));
    }


    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }


    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }


    public HandlerRegistration addFocusHandler(FocusHandler handler) {
        return addDomHandler(handler, FocusEvent.getType());
    }

*/

    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public HandlerRegistration addFocusHandler(FocusHandler handler) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void fireEvent(GwtEvent<?> event) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
