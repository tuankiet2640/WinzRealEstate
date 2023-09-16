package entity;

import java.io.Serializable;

public class GroundProperty extends Property implements Serializable {
    private boolean hasPool;
    public GroundProperty(int propertyId, String propertyTitle, Address address, double propertyPrice, long area, boolean hasPool) {
        super(propertyId,propertyTitle, address, propertyPrice, area);
        this.hasPool=hasPool;
    }
}
