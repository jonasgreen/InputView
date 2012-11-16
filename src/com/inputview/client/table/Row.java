package com.inputview.client.table;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.inputview.client.model.TableLine;
import com.inputview.client.pages.InputViewPage;

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
    private FlowPanel colTo;
    FlowPanel content = new FlowPanel();

    private TableLine model;
    private Table parent;
    private Label plusMinus;

    public Row(TableLine model, Table table) {
        this.parent = table;
        this.model = model;
        setStyleName("row");
        if(model.isDraft()){
            getElement().getStyle().setBackgroundColor("rgb(247,247,247)");
            getElement().getStyle().setColor("rgb(151,151,151)");
        }

        //this.setWidth(Table.WIDTH+"px");

        /*FlowPanel fl = new FlowPanel();
        fl.add(getPlusMinus());
        fl.getElement().getStyle().setFloat(Style.Float.LEFT);
        content.add(fl);
        */
        content.add(getColType());
        content.add(getColName());
        content.add(getColDraft());
        content.add(getColFrom());
        content.add(getColTo());

        add(content);
        addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

            }
        });


        addFocusHandler(new FocusHandler() {
            public void onFocus(FocusEvent event) {
                getElement().getStyle().setBackgroundColor("yellow");
            }
        });

        addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {

                if(Row.this.model.isDraft()){
                    getElement().getStyle().setBackgroundColor("rgb(247,247,247)");
                }
                else {
                    getElement().getStyle().setBackgroundColor("white");
                }
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
                else if(KeyCodes.KEY_ENTER == event.getNativeKeyCode()){
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

    public Label getPlusMinus() {
        if (plusMinus == null) {
            plusMinus = new Label("+");
            plusMinus.setStyleName("plusMinus");

        }
        return plusMinus;
    }

    private void addChild() {
        FlowPanel fl = new FlowPanel();
        fl.add(new Label(" ---- Child"));
        fl.getElement().getStyle().setClear(Style.Clear.BOTH);

        content.add(fl);
        fl.setHeight("40px");
        fl.setWidth("400px");
        fl.getElement().getStyle().setMarginLeft(30, Style.Unit.PX);

        this.setHeight("80px");
        parent.getCustomScrollPanel().onResize();

    }

    public FlowPanel getColType() {
        if (colOne == null) {
            colOne = new Column(model.getType().name());
            colOne.setWidth("100px");
        }
        return colOne;
    }

    public FlowPanel getColName() {
        if (colTwo == null) {
            colTwo = new Column(model.getName());
        }
        return colTwo;
    }

    public FlowPanel getColDraft() {
        if (colThree == null) {
            colThree = new Column(model.isDraft() ? "Kladde" : "");
            colThree.setWidth("70px");
        }
        return colThree;
    }

    public FlowPanel getColFrom() {
        if (colFour == null) {
            colFour = new Column(model.getStartDate());
            colFour.setWidth("90px");
        }
        return colFour;
    }

    public FlowPanel getColTo() {
        if (colTo == null) {
            colTo = new Column(model.getEndDate());
            colTo.setWidth("90px");
        }
        return colTo;
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
