package com.ztvgzh.computerservice.Models;

public class User {
    private String name, email, number, password;
    public User(){}
    public User(String name,String email, String number, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
