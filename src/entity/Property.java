package entity;

import java.io.Serializable;

public abstract class Property implements Serializable {
    private int propertyId;
    private String propertyTitle;
    private Address address;
    private double propertyPrice;
    private long area;

    public Property(int propertyId, String propertyTitle, Address address, double propertyPrice, long area) {
        this.propertyId=propertyId;
        this.propertyTitle = propertyTitle;
        this.address = address;
        this.propertyPrice = propertyPrice;
        this.area = area;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

}
