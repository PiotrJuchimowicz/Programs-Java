/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.Models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="PURCHASE")
public class PurchaseDTO extends AbstractDTO {
    @ManyToOne
    @JoinColumn(name = "customerID")
    private CustomerDTO customer;
    @OneToMany(mappedBy = "purchase", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<PurchaseItemDTO> purchaseItems;




    public PurchaseDTO() {
    }

    public PurchaseDTO(CustomerDTO customer, List<PurchaseItemDTO> purchaseItems) {
        this.customer = customer;
        this.purchaseItems = purchaseItems;
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
