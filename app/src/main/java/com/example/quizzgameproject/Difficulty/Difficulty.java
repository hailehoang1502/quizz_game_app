package com.example.quizzgameproject.Difficulty;

import java.io.Serializable;

public class Difficulty implements Serializable {
    private String id;
    private String name;
    private int resourceID;

    public Difficulty(String id, String name, int resourceID) {
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

