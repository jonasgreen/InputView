package com.inputview.client.model;

import java.util.Date;

/**
 *
 */
public class ProductVersion implements TableLine{

    private static int idCount = 1;
    private int id = idCount++;


    private String name;
    private String author;
    private String reviewer;

    private String startDate;
    private String endDate;

    private Type type;
    private boolean draft;

    public ProductVersion(String name, String author, String reviewer, String startDate, String endDate, Type type, boolean draft) {
        this.name = name;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.draft = draft;
        this.reviewer = reviewer;
    }



    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Type getType() {
        return type;
    }


    public boolean isDraft() {
        return draft;
    }

    public String getReviewer() {
        return reviewer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductVersion that = (ProductVersion) o;

        if (id != that.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
