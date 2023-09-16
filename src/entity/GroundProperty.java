package entity;

import java.io.Serializable;

public class GroundProperty extends Property implements Serializable {
    private int numberOfPool;
    public GroundProperty(int propertyId, String propertyTitle, Address address, double propertyPrice, long area, int numberOfPool) {
        super(propertyId,propertyTitle, address, propertyPrice, area);
        this.numberOfPool=numberOfPool;
    }
}
