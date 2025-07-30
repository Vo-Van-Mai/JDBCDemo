/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vvm.pojo;

import java.util.List;

/**
 *
 * @author admin
 */
public class Question {
    private String id;
    private String content;
    private Category category;
    private List<Choice> choice;

    public Question(String id, String indexes) {
        this.id = id;
        this.content = indexes;
    }
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the choice
     */
    public List<Choice> getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(List<Choice> choice) {
        this.choice = choice;
    }
}
