package org.talan.tennistestmaven.model.data;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Objects;

    @Entity

    @Table(name = "td_player", schema = "i_match")
    public class Joueur {

        @Id
        @GeneratedValue(generator = "id_player")
        @SequenceGenerator(name = "id_player", sequenceName = "id_player_seq", schema = "i_match")

        @Column(name = "id_player")
        private Long id;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "birth_date")
        private LocalDate birthdate;

        @Column(name = "weight")
        private double weight; // Poids en kg

        @Column(name = "height")
        private long height; // Taille en cm

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

        public LocalDate getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public long getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setHeight(long height) {
            this.height = height;
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
            Joueur joueur = (Joueur) o;
            return Objects.equals(id, joueur.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
