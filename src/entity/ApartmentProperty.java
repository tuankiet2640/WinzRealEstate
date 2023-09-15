package entity;

public class ApartmentProperty extends Property {
    private int floor;
    public ApartmentProperty(String propertyTitle, Address address, double propertyPrice, long area,int floor) {
        super(propertyTitle, address, propertyPrice, area);
        this.floor=floor;
    }
}
