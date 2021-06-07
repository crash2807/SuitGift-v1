package com.project.app.entities;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class GiftRelationEvent implements Serializable {
   @EmbeddedId
    private GiftRelationEventId giftRelationEventId;

}
