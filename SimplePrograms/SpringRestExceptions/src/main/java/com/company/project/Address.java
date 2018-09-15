package com.company.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String cuntry;
    private String city;

    public Address(String cuntry, String city) {
        this.cuntry = cuntry;
        this.city = city;
    }
}
