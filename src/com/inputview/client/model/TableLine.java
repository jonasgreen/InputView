package com.inputview.client.model;

/**
 *
 */
public interface TableLine {

    public String getStartDate();
    public String getEndDate();

    public String getName();
    public Type getType();

    public String getAuthor();

    public boolean isDraft();

    public String getReviewer();

}
