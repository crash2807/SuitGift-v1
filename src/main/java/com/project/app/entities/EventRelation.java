package com.project.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class EventRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEventRelation;
    @ManyToOne
    @JoinColumn(name = "idEvent", nullable = false)
    private Event event;
    @ManyToOne
    @JoinColumn(name = "idRelation",nullable = false)
    private Relation relation;
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "eventRelation")
    //private Set<ForumEvent> forumEventSet;


}
