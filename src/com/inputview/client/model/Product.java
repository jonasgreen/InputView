package com.inputview.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Product {

    private static int idCount = 1;
    private int id = idCount++;
    private String name;
    private List<ProductVersion> versions = new ArrayList<ProductVersion>();


    public Product(String name) {
        this.name = name;
    }

    public void addVersion(String author, String reviewer, String start, String end, boolean draft){
        versions.add(new ProductVersion(name, author, reviewer, start, end, Type.product, draft));
    }

    public List<ProductVersion> getVersions() {
        return versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        if (id != product.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
