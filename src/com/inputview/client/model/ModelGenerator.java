package com.inputview.client.model;

import com.google.gwt.user.client.Random;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ModelGenerator {

    private char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};

    private String[] names = new String[]{"Sophie Jensen", "Allan Nielsen", "Morten Just", "Dennis Hjortshøj"};


    public List<Product> getModelList(){
        List<Product> modelList = new ArrayList<Product>();

        int i = 1;

        while (i < 40){
            Product p = new Product(nextProductName());
            p.addVersion(nextPersonName(), nextPersonName(), "01-01-2010", "01-06-2014", false);
            if(Random.nextInt(10) < 3){
                p.addVersion(nextPersonName(), nextPersonName(), "01-12-2014", "01-06-2020", false);
                if(Random.nextInt(10) < 3){
                    p.addVersion(nextPersonName(), nextPersonName(), "01-12-2014", "01-06-20020", true);
                }
            }
            else if(Random.nextInt(10) < 3){
                p.addVersion(nextPersonName(), nextPersonName(), "01-12-2013", "01-06-20020", true);
            }

            modelList.add(p);
            i++;
        }

        return modelList;
    }


    private String nextProductName(){
        StringBuilder sb = new StringBuilder();
        sb.append(chars[Random.nextInt(chars.length)]);
        sb.append(chars[Random.nextInt(chars.length)]);
        sb.append(chars[Random.nextInt(chars.length)]);
        sb.append("_");
        sb.append(Random.nextInt(100));
        return sb.toString();
    }


    private String nextPersonName(){
        return names[Random.nextInt(names.length)];
    }



}
