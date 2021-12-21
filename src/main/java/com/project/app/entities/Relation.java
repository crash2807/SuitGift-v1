package com.project.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity
@Data
public class Relation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idRelation;
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user1;
    @ManyToOne
    @JoinColumn(name = "idUser_2", nullable = false)
    private User user2;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "relation")
    private Set<EventRelation> eventRelationSet;
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "relation")
    //private Set<GiftRelationEvent> giftRelationEventSet;


}
