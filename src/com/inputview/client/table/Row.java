package com.inputview.client.table;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.inputview.client.model.TableLine;
import com.sun.java.swing.plaf.nimbus.TableEditorPainter;

/**
 *
 */
public class Row extends FocusPanel implements HasClickHandlers, HasMouseOverHandlers, HasFocusHandlers {

    private static int idCount = 1;
    private int id = idCount++;


    private FlowPanel colOne;
    private FlowPanel colTwo;
    private FlowPanel colThree;
    private FlowPanel colFour;
    FlowPanel content = new FlowPanel();

    private TableLine model;
    private Table parent;

    public Row(TableLine model, Table table) {
        this.parent = table;
        this.model = model;
        setStyleName("row");

        this.setWidth(Table.WIDTH+"px");
        content.add(getColOne());
        content.add(getColTwo());
        content.add(getColThree());
        content.add(getColFour());

        add(content);
        addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

            }
        });


        addFocusHandler(new FocusHandler() {
            public void onFocus(FocusEvent event) {
                getElement().getStyle().setBorderColor("blue");
                getElement().getStyle().setFontSize(18, Style.Unit.PX);
                getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
            }
        });

        addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {
                getElement().getStyle().setBorderColor("white");
                getElement().getStyle().setFontSize(14, Style.Unit.PX);
                getElement().getStyle().setFontWeight(Style.FontWeight.NORMAL);

            }
        });

        addMouseOverHandler(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                getElement().getStyle().setCursor(Style.Cursor.POINTER);
            }
        });

        addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if(KeyCodes.KEY_DOWN == event.getNativeKeyCode()){
                    parent.down(Row.this);
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if(KeyCodes.KEY_UP == event.getNativeKeyCode()){
                    parent.up(Row.this);
                    event.stopPropagation();
                    event.preventDefault();
                }
                else if(KeyCodes.KEY_RIGHT == event.getNativeKeyCode()){
                    addChild();
                    event.stopPropagation();
                    event.preventDefault();
                }
            }
        });
    }

    private void addChild() {
        FlowPanel fl = new FlowPanel();
        fl.add(new Label(" ---- Child"));
        fl.getElement().getStyle().setClear(Style.Clear.BOTH);

        content.add(fl);
        fl.setHeight("40px");
        fl.setWidth("400px");
        fl.getElement().getStyle().setBackgroundColor("yellow");
        fl.getElement().getStyle().setMarginLeft(30, Style.Unit.PX);

        this.setHeight("80px");
        parent.getCustomScrollPanel().onResize();

    }

    public FlowPanel getColOne() {
        if (colOne == null) {
            colOne = new Column(model.getType().name());
        }
        return colOne;
    }

    public FlowPanel getColTwo() {
        if (colTwo == null) {
            colTwo = new Column(model.getName());
        }
        return colTwo;
    }

    public FlowPanel getColThree() {
        if (colThree == null) {
            colThree = new Column(model.isDraft() ? "Kladde" : "");
        }
        return colThree;
    }

    public FlowPanel getColFour() {
        if (colFour == null) {
            colFour = new Column(model.getAuthor());
        }
        return colFour;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Row widgets = (Row) o;

        if (id != widgets.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
