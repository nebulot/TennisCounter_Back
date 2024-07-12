package org.talan.tennistestmaven.model.rest;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Referee {
    private Long id;
    private String firstName;
    private String lastName;
    //add more information for player
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    private String image;


    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    // Modifier la méthode setBirthdate pour formater la date en "dd/MM/yyyy"
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}


