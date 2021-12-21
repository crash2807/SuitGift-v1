package com.project.app.entities;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
public class Hobby {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idHobby;
    private String hobbyName;
    @Nullable
    private String description;

    @ManyToMany(mappedBy = "hobbySet",fetch = FetchType.EAGER)
    private Set<User> userSet= new HashSet<>();
    

}
