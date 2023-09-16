package entity;

import java.io.Serializable;

public class ApartmentProperty extends Property implements Serializable {
    private int apartmentNumber;
    public ApartmentProperty(int propertyId, String propertyTitle, Address address, double propertyPrice, long area,int apartmentNumber) {
        super(propertyId,propertyTitle, address, propertyPrice, area);
        this.apartmentNumber=apartmentNumber;
    }
}
