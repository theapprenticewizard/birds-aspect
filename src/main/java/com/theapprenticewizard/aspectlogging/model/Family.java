package com.theapprenticewizard.aspectlogging.model;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
class Family {
    private String region;
    private  String genius;
}
