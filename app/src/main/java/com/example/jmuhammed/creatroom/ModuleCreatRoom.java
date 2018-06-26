package com.example.jmuhammed.creatroom;

public class ModuleCreatRoom {
    private String id , name , pass;

    public ModuleCreatRoom(){

    }

    public ModuleCreatRoom(String id ,String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    //ModuleSetMaster
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
