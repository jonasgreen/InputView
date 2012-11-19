package com.inputview.client.model;

import com.inputview.client.compositemodel.DataList;

/**
 *
 */
public class EditProductModelGenerator {


    public DataList getModelList(){
        DataList list = new DataList();
        generateData(list, 0);
        return list;
    }


    public void generateData(DataList list, int depth){
        if(depth > 5){
            generateValuesOnly(list);
            return;
        }




    }

    private void generateValuesOnly(DataList list) {

    }





}
