package com.project.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.validator.constraints.Email;



@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idUser;
    private String name;
    private String surname;
    @Email
    private String email;
    private String password;
    private Date birthday;

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name ="User_hobby",
               joinColumns = {@JoinColumn(name = "idUser")},
                inverseJoinColumns = { @JoinColumn(name = "idHobby")})
    Set<Hobby> hobbySet= new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private Set<Gift> giftSet;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user1")
    private Set<Relation> relationSetUser1;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user2")
    private Set<Relation> relationSetUser2;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private Set<Event> eventSet;
}
