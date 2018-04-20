/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.Models;

import javax.persistence.*;

@Entity
@Table(name = "PURCHASE_ITEM")
public class PurchaseItemDTO extends AbstractDTO {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productID")
    private ProductDTO product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchaseID")
    private PurchaseDTO purchase;
    private Integer quantity;


    public PurchaseItemDTO(ProductDTO product, PurchaseDTO purchase, Integer quantity) {
        this.product = product;
        this.purchase = purchase;
        this.quantity = quantity;
    }

    public PurchaseItemDTO() {
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PurchaseDTO getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDTO purchase) {
        this.purchase = purchase;
    }
}
