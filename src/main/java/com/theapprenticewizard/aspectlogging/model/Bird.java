package com.theapprenticewizard.aspectlogging.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Bird {

    @Id
    @GeneratedValue
    private String id;

    private String airspeedVelocity;

    @Embedded
    private Family family;
}