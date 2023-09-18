package entity;

import java.io.Serializable;

public class DraftContract implements Serializable {
    private Property property;
    private Buyer buyer;
    private Seller seller;

    public DraftContract(Property property, Buyer buyer, Seller seller) {
        this.property = property;
        this.buyer =buyer;
        this.seller =seller;
    }
}
