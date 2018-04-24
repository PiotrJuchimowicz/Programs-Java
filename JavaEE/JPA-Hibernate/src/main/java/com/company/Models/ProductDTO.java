/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class ProductDTO extends AbstractDTO {

    private String name;
    private Double price;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE})
    private List<PurchaseItemDTO> purchaseItems;


    public ProductDTO(String name, Double price, List<PurchaseItemDTO> purchaseItems) {
        this.name = name;
        this.price = price;
        this.purchaseItems = purchaseItems;
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItemDTO> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + getId() + "," + name + "," + price;
    }
}
