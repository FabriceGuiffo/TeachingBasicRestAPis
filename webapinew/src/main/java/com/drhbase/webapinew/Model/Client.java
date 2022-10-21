package com.drhbase.webapinew.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom", length=25)
    @NotNull(message = "vous devez fournir un nom de famille")
    @Size(max=25, min=3)
    private String name;

    @Column(name="prenom", length=25)
    @Size(max=25, message = "le prenom est trop long 25 caracteres max")
    private String christianName;

    @Column(name="age")
    @Min(value=18, message="cette appli est pour des individus majeurs 18+")
    @Max(value=60, message="nous visons les preretraites donc 60-")
    private int age;

    @Column(name="email")
    @Size(max=50,message="50 caracteres grand max")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChristianName() {
        return christianName;
    }

    public void setChristianName(String christianName) {
        this.christianName = christianName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", christianName='" + christianName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

   /* public Client(String name, String christianName, int age, String email) {
        this.name = name;
        this.christianName = christianName;
        this.age = age;
        this.email = email;
    }*/
}
