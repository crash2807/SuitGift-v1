package com.project.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Table
@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idEvent;
    private String eventName;
    private String eventPlace;
    private Date eventDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "event")
    private Set<EventRelation> eventRelationSet;
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "event")
    //private Set<GiftRelationEvent> giftRelationEventSet;


}
