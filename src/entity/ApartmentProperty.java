package entity;

import java.io.Serializable;

public class ApartmentProperty extends Property implements Serializable {
    private int apartmentNumber;
    public ApartmentProperty(int propertyId, String propertyTitle, Address address, double propertyPrice, long area,int apartmentNumber) {
        super(propertyId,propertyTitle, address, propertyPrice, area);
        this.apartmentNumber=apartmentNumber;
    }

    @Override
    public String toString() {
        return "ApartmentProperty{" +
                ", propertyId=" + propertyId +
                ", propertyTitle='" + propertyTitle + '\'' +
                ", address=" + address +
                ", propertyPrice=" + propertyPrice +
                ", area=" + area +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
