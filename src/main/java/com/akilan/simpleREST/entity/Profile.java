package com.akilan.simpleREST.entity;
import org.springframework.stereotype.Component;

@Component
public class Profile {
    public int id;
    public String name;
    public String age;
    public String profession;
    public String place;

    public Profile() {
    }
    public Profile(int id, String name, String age, String profession, String place) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.place = place;
    }

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
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", profession='" + profession + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
