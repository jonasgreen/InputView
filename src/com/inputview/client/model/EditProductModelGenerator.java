package com.inputview.client.model;

import com.google.gwt.user.client.Random;
import com.inputview.client.compositemodel.DataList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EditProductModelGenerator {

    private char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};


    public List<DataList> getModelList() {
        List<DataList> model = new ArrayList<DataList>();

        DataList list = new DataList("Aftaletype");
        generateData(list, 0);
        model.add(list);

        list = new DataList("Helbredsoplysninger");
        generateData(list, 0);
        model.add(list);

        list = new DataList("Invaliditet");
        generateData(list, 0);
        model.add(list);

        list = new DataList("Bonusordning");
        generateData(list, 0);
        model.add(list);

        list = new DataList("Andet");
        generateData(list, 0);
        model.add(list);




        return model;
    }


    public void generateData(DataList list, int depth) {
        if (depth > 4) {
            generateValuesOnly(list);
        }
        else {
            DataList l = generateValuesAndList(list);
            if (l != null) {
                generateData(l, depth + 1);
                list.add(l);
            }
        }


    }

    private DataList generateValuesAndList(DataList list) {
        generateValuesOnly(list);
        int i = Random.nextInt(4);
        if(i < 2){
            return null;
        }

        return new DataList(getString("L_"));
    }

    private void generateValuesOnly(DataList list) {
        int i = Random.nextInt(20);
        i = i < 4 ? 4 : i;
        int index = 0;
        while (index++ < i) {
            createValue(list);
        }
    }

    private void createValue(DataList container) {
        String start = "V";

        switch (Random.nextInt(2)) {
            case 0:
                container.add(getString(start), Random.nextInt(1000));
            case 1:
                container.add(getString(start), Random.nextInt(1000));
            case 2:
                container.add(getString(start), getString(""));
        }
    }

    private String getString(String start) {
        StringBuilder sb = new StringBuilder(start).append("_");
        int i = Random.nextInt(20);
        i = i < 6 ? 6 : i;

        int index = 0;
        while (index++ < i) {
            sb.append(chars[Random.nextInt(chars.length - 1)]);
        }

        return sb.toString();

    }


}
