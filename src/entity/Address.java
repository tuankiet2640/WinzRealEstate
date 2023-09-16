package entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String district;
    private String city;
    private String housenumber;

    public Address district(String district) {
        this.district=district;
        return this;
    }

    public Address city(String city) {
        this.city=city;
        return this;
    }

    public Address houseNumber(String houseNumber) {
        this.housenumber=houseNumber;
        return this;
    }
}
