package com.project.app.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class GiftRelationEventId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idGift",nullable = false, referencedColumnName = "idGift")
    private Gift gift;

    @ManyToOne
    @JoinColumn(name = "idRelation",nullable = false)
    private Relation relation;

    @ManyToOne
    @JoinColumn(name = "idEvent",nullable = false)
    private Event event;
}
