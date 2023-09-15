package entity;

public class GroundProperty extends Property {
    private boolean hasPool;
    public GroundProperty(String propertyTitle, Address address, double propertyPrice, long area, boolean hasPool) {
        super(propertyTitle, address, propertyPrice, area);
        this.hasPool=hasPool;
    }
}
