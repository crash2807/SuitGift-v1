package com.project.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Table
@Entity
@Data
public class Gift {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idGift;
    private String gift;
    private BigDecimal price;
    private String size;
    private String brand;
    private String color;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "gift")
    //private Set<GiftRelationEvent> giftRelationEventSet;

}
