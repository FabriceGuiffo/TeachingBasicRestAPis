package com.rest.apiconsumer.Model;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;
    private String christianName;
    private int age;
    private String email;

    public Client(String name, String christianName, int age, String email) {
        this.name = name;
        this.christianName = christianName;
        this.age = age;
        this.email = email;
    }


}
