package com.project.app.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;

@Data
@Embeddable
public class ForumEventId implements Serializable {

    private Date date;

    @ManyToOne
    @JoinColumn(name = "idEvent", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "idEventRelation",nullable = false)
    private EventRelation eventRelation;
}
