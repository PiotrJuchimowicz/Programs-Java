package com.company;

import com.company.Hibernate.*;
import com.company.JPA.*;
import com.company.Models.*;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.Date;
import java.util.LinkedList;

//All relations are Bidirectional
//Ale tables have Cascade type ALL
//One Customer can have Many Purchases
//One Purchase can have Many PurchaseItems
//One Product can have Many Purchase Items
//One DeliveryCompany can have Many Purchases

public class App {
    public static void main(String[] args) {

        //creating some data

        LinkedList<PurchaseItemDTO> purchaseItems = new LinkedList<>();
        PurchaseItemDTO purchaseItem = new PurchaseItemDTO();
        purchaseItem.setQuantity(2000);
        purchaseItems.add(purchaseItem);

        LinkedList<PurchaseDTO> purchases = new LinkedList<>();
        LinkedList<ProductDTO> products = new LinkedList<>();


        PurchaseDTO purchase = new PurchaseDTO();
        purchases.add(purchase);

        ProductDTO product = new ProductDTO();
        products.add(product);

        purchaseItem.setProduct(product);
        purchaseItem.setPurchase(purchase);


        product.setName("Computer");
        product.setPrice(2000.0);
        product.setPurchaseItems(purchaseItems);

        purchase.setPurchaseItems(purchaseItems);

        CustomerDTO customer = new CustomerDTO();
        customer.setPucharses(purchases);
        customer.setEmail("email");
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");

        purchase.setCustomer(customer);

        purchase.setDeliveryCity("Warsaw");
        purchase.setDeliveryStreet("Short");
        purchase.setDeliveryStreetNumber(2);
        purchase.setDate(new Date());


        DeliveryCompanyDTO deliveryCompany = new DeliveryCompanyDTO("Company", "Warsaw", "15-333", "Street", 12, purchases);

        purchase.setDeliveryCompany(deliveryCompany);

        CustomerDao customerDao = new CustomerJpaDao();
        DeliveryCompanyDao deliveryCompanyDao = new DeliveryCompanyJpaDao();
        ProductDao productDao = new ProductJpaDao();
        PucharseItemDao pucharseItemDao = new PurchaseItemJpaDao();
        PurchaseDao purchaseDao = new PurchaseJpaDao();

        //adding customer
        //I've turned on cascade type ALL so all I need to do is add the Customer.

        //little update
        //Date and City have been updated
        long id = 1;


        customerDao.save(customer);
        PurchaseDTO updatedPurchase = purchaseDao.findById(id);
        updatedPurchase.setDate(new Date());
        updatedPurchase.setDeliveryCity("Bialystok");
        purchaseDao.update(updatedPurchase);


    }
}
