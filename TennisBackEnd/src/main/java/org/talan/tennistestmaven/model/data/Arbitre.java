package org.talan.tennistestmaven.model.data;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "td_referee", schema = "i_match")
public class Arbitre {

    @Id
    @GeneratedValue(generator = "id_referee")
    @SequenceGenerator(name = "id_referee", sequenceName = "id_referee_seq", schema = "i_match")

    @Column(name = "id_referee")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    @Column(name ="image")
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arbitre arbitre = (Arbitre) o;
        return Objects.equals(id, arbitre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
