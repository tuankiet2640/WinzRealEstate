package entity;

import java.io.Serializable;

public class GroundProperty extends Property implements Serializable {
    private int numberOfPool;
    public GroundProperty(int propertyId, String propertyTitle, Address address, double propertyPrice, long area, int numberOfPool) {
        super(propertyId,propertyTitle, address, propertyPrice, area);
        this.numberOfPool=numberOfPool;
    }

    @Override
    public String toString() {
        return "GroundProperty{" +
                ", propertyId=" + propertyId +
                ", propertyTitle='" + propertyTitle + '\'' +
                ", address=" + address +
                ", propertyPrice=" + propertyPrice +
                ", area=" + area +
                ", numberOfPool=" + numberOfPool +
                '}';
    }
}
