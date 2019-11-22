package com.example.math_learning_app.model;

public class Quiz {
    private String id;
    private String language;

    public Quiz(String id, String language) {
        this.id = id;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
