package com.project.app.entities;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
@Data
public class ForumEvent implements Serializable {

    @EmbeddedId
    private ForumEventId forumEventId;

    private String comment;


}
