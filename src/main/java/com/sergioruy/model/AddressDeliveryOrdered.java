package com.sergioruy.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AddressDeliveryOrdered {

    private String zipcode;

    private String street;

    private String number;

    private String complement;

    private String district;

    private String city;

    private String state;
}
