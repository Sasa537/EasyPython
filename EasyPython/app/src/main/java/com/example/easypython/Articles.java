package com.example.easypython;

public class Articles {

    private String title;
    private String preview;
    private String full_text;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getPreview() {
        return preview;
    }

    public String getFull_text() {
        return full_text;
    }

    public String getDate() {
        return date;
    }

    public Articles(String title, String preview, String full_text, String date) {
        this.title = title;
        this.preview = preview;
        this.full_text = full_text;
        this.date = date;
    }

    private String date;

    public Articles() {
    }
}

