package io.datajek.spring.basics.rest01;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String nationality;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private int titles;

    public Player() {

    }

    public Player(String name, String nationality, Date birthDate, int titles) {
        super();

        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    public Player(int id, String name, String nationality, Date birthDate, int titles) {
        super();

        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }
}
