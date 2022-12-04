package com.example.quizzgameproject.Topic;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Topic implements Serializable {
    private String id;
    private String name;
    private int resourceID;

    public Topic(String id, String name, int resourceID) {
        this.id = id;
        this.name = name;
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}