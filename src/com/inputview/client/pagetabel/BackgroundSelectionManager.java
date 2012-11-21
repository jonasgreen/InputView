package com.inputview.client.pagetabel;

import com.google.gwt.user.client.ui.ScrollPanel;
import com.inputview.client.compositemodel.Data;
import com.inputview.client.compositemodel.DataValue;
import com.inputview.client.composittable.DivComposite;

/**
 *
 */
public class BackgroundSelectionManager {

    private String UN_SELECTED_COLOR = "rgb(51,51,51)";
    private String SELECTED_COLOR = "white";

    private String UN_SELECTED_BACKGROUND = "transparent";
    private String UN_SELECTED_BACKGROUND_TAB_INDEX_0 = "rgb(245,245,245)";

    private String SELECTED_BACKGROUND = "rgb(84,124,182)";

    private Data model;

    private DivComposite<?> lastContentSelection;
    private DivComposite<?> lastEditSelection;

    private EditorTable editTable;
    private ContentTable contentTable;

    private ScrollPanel scrollPanel;

    public BackgroundSelectionManager(EditorTable editTable, ContentTable contentTable) {
        this.scrollPanel = editTable.getCustomScrollPanel();
        this.editTable = editTable;
        this.contentTable = contentTable;
    }

    public void inFocus(boolean fromContentTable, Data newModelInFocus) {
        removePreviousSelections(fromContentTable);

        handleContentPart(fromContentTable, newModelInFocus);
        handleEditPart(fromContentTable, newModelInFocus);
    }

    private void handleEditPart(boolean fromContentTable, Data newModelInFocus) {
        lastEditSelection = editTable.getElement(newModelInFocus);
        lastEditSelection.getFocusPanel().getElement().getStyle().setBackgroundColor(SELECTED_BACKGROUND);

        if (fromContentTable) {
            scrollPanel.ensureVisible(lastEditSelection);
        }
        else{
           	lastEditSelection.getFocusPanel().getElement().getStyle().setColor(SELECTED_COLOR);                   	
        }
        
    }

    private void handleContentPart(boolean fromContentTable, Data newModelInFocus) {
        if(newModelInFocus instanceof DataValue){
            handleContentPart(fromContentTable, ((DataValue) newModelInFocus).getParent());
            return;
        }
        lastContentSelection = contentTable.getElement(newModelInFocus);
        lastContentSelection.getFocusPanel().getElement().getStyle().setBackgroundColor(SELECTED_BACKGROUND);

        if (fromContentTable) {
            lastContentSelection.getFocusPanel().getElement().getStyle().setColor(SELECTED_COLOR);
        }
        else{
            lastContentSelection.showChildren();            
        }
        
    }

    private void removePreviousSelections(boolean fromContent) {
        if (lastContentSelection != null) {
            lastContentSelection.getFocusPanel().getElement().getStyle().setBackgroundColor(UN_SELECTED_BACKGROUND);
            lastContentSelection.getFocusPanel().getElement().getStyle().setColor(UN_SELECTED_COLOR);

            if(!fromContent){
                if(lastContentSelection.getTabIndex() == 0){
                    lastContentSelection.collapse(true);
                }
            }
        }
        if (lastEditSelection != null) {
            lastEditSelection.getFocusPanel().getElement().getStyle().setBackgroundColor(UN_SELECTED_BACKGROUND);
            lastEditSelection.getFocusPanel().getElement().getStyle().setColor(UN_SELECTED_COLOR);
            if(lastEditSelection.getTabIndex() == 0){
                lastEditSelection.getFocusPanel().getElement().getStyle().setColor(UN_SELECTED_COLOR);
                lastEditSelection.getFocusPanel().getElement().getStyle().setBackgroundColor(UN_SELECTED_BACKGROUND_TAB_INDEX_0);
            }
        }
    }


}
