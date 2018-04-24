/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PURCHASE")
public class PurchaseDTO extends AbstractDTO {
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customerID")
    private CustomerDTO customer;
    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.MERGE})
    private List<PurchaseItemDTO> purchaseItems;

    private String deliveryCity;
    private String deliveryStreet;
    private int deliveryStreetNumber;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "deliveredBy")
    private DeliveryCompanyDTO deliveryCompany;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)//It must be.Describes data precision
    private Date date;


    public DeliveryCompanyDTO getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(DeliveryCompanyDTO deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public PurchaseDTO(CustomerDTO customer, List<PurchaseItemDTO> purchaseItems, String deliveryCity, String deliveryStreet, int deliveryStreetNumber, DeliveryCompanyDTO deliveryCompany, Date date) {
        this.customer = customer;
        this.purchaseItems = purchaseItems;
        this.deliveryCity = deliveryCity;
        this.deliveryStreet = deliveryStreet;
        this.deliveryStreetNumber = deliveryStreetNumber;
        this.deliveryCompany = deliveryCompany;
        this.date = date;
    }

    public PurchaseDTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public int getDeliveryStreetNumber() {
        return deliveryStreetNumber;
    }

    public void setDeliveryStreetNumber(int deliveryStreetNumber) {
        this.deliveryStreetNumber = deliveryStreetNumber;
    }

    public void setPurchaseItems(List<PurchaseItemDTO> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

}
