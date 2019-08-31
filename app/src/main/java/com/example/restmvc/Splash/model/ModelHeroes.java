package com.example.restmvc.Splash.model;

public class ModelHeroes {
    private String name;
    private String photo;
    private String realName;
    private String height;
    private String power;
    private String abilities;
    private String groups;

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }
    public String getPhoto(){
        return this.photo;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }
    public String getRealName(){
        return this.realName;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }
    public String getHeight(){
        return this.height;
    }

    public void setPower(String power)
    {
        this.power = power;
    }
    public String getPower(){
        return this.power;
    }

    public void setAbilities(String abilities)
    {
        this.abilities = abilities;
    }
    public String getAbilities(){
        return this.abilities;
    }

    public void setGroups(String groups)
    {
        this.groups = groups;
    }
    public String getGroups(){
        return this.groups;
    }
}
