/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.Models;

import org.hibernate.sql.Select;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({@NamedQuery(name = "findInRange", query = "select p From ProductDTO p where price between ?1 and ?2"),
        @NamedQuery(name = "findTheExpensivest", query = "SELECT p from  ProductDTO p  WHERE  p.price = (select max(price) From ProductDTO )"), @NamedQuery(name = "findWithoutPurchase", query = "select r From ProductDTO r where r.id NOT IN (select b.product.id From PurchaseItemDTO b) "),@NamedQuery(name = "findWithMostPieces",query = "select product from ProductDTO product WHere product.id IN (SELECT b.product.id From PurchaseItemDTO b group by b.product.id having count (b.product.purchaseItems.size)= (:subquerry) )"),@NamedQuery(name = "changePrice",query = "update ProductDTO p SET p.price=p.price*((100+ :percent)/100)")})


public class ProductDTO extends AbstractDTO {

    private String name;
    private Double price;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
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
