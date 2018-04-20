package com.company.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "DELIVERY_COMPANY")
public class DeliveryCompanyDTO extends AbstractDTO {
    private String name;
    private String city;
    private String zipCode;
    private String street;
    private int streetNumber;

    @OneToMany(mappedBy = "deliveryCompany", cascade = {CascadeType.ALL})
    private List<PurchaseDTO> purchases;

    public DeliveryCompanyDTO() {
    }


    public List<PurchaseDTO> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseDTO> purchases) {
        this.purchases = purchases;
    }

    public DeliveryCompanyDTO(String name, String city, String zipCode, String street, int streetNumber, List<PurchaseDTO> purchases) {
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
