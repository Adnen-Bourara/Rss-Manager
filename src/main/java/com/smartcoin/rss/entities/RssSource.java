package com.smartcoin.lms.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class RssSource {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private String image;

    private Boolean filtrable;

    private Date created_at;

    private Date updated_at;

    private Date deleted_at;
}
