package com.theapprenticewizard.aspectlogging.model;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Family {
    private String region;
    private  String genius;
}
