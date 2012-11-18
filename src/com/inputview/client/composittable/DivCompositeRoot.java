package com.inputview.client.composittable;


import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CustomScrollPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

import java.util.List;

/**
 *
 */
public abstract class DivCompositeRoot<M> extends FocusPanel implements DivCompositeParent<M>{

    private List<DivComposite<M>> rows;
    private FlowPanel content;

    private CustomScrollPanel customScrollPanel;
    private FlowPanel scrollPanelContent = new FlowPanel();

    private FlowPanel header;

    protected DivCompositeRoot() {
    }

    public void paint() {
        add(getContent());
        getContent().add(getHeader());
        getContent().add(getCustomScrollPanel());

        for (DivComposite<M> row : getRows()) {
            scrollPanelContent.add(row);
        }

        onResize();
        Timer t = new Timer() {
            @Override
            public void run() {
                getRows().get(0).setFocus(true);
            }
        };

        t.schedule(500);
    }

    public abstract List<DivComposite<M>> createRows();


    public FlowPanel getHeader() {
        if (header == null) {
            header = createHeader();
        }
        return header;
    }

    protected abstract FlowPanel createHeader();


    public FlowPanel getContent() {
        if (content == null) {
            content = new FlowPanel();
        }
        return content;
    }

    public ScrollPanel getCustomScrollPanel() {
        if (customScrollPanel == null) {
            customScrollPanel = new CustomScrollPanel(scrollPanelContent);
            customScrollPanel.setHeight(getTableHeight() + "px");
            customScrollPanel.setStyleName("customScrollPanel");
        }
        return customScrollPanel;
    }

    public List<DivComposite<M>> getRows() {
        if (rows == null) {
            rows = createRows();
        }
        return rows;
    }

    public void onResize() {
        getCustomScrollPanel().onResize();
    }

    public abstract int getTableHeight();


    public void down(DivComposite<M> child) {
        int index = rows.indexOf(child);
        if(index == rows.size()-1){
            return;
        }
        rows.get(index+1).setFocusDown(true);

    }

    public void up(DivComposite<M> r) {
        int index = rows.indexOf(r);
        if(index == 0){
            return;
        }
        rows.get(index-1).setFocusUp(true);
    }


}