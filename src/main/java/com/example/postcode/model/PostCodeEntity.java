package com.example.postcode.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PostCode")
public class PostCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_code")
    private Integer postCode;

    @Column(name = "suburb_name")
    private String suburbName;
}
