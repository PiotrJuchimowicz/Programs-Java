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

        CustomerDao customerDao = new CustomerJpaDao();
        DeliveryCompanyDao deliveryCompanyDao = new DeliveryCompanyJpaDao();
        PucharseItemDao pucharseItemDao = new PurchaseItemJpaDao();
        ProductDao productDao = new ProductJpaDao();
        PurchaseDao purchaseDao = new PurchaseJpaDao();


        //1st program launch:
        //adding some data
/*
        CustomerDTO customer = new CustomerDTO();

        customer.setEmail("email");
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");

        LinkedList<PurchaseDTO> purchases = new LinkedList<>();
        PurchaseDTO purchase = new PurchaseDTO();
        purchases.add(purchase);
        customer.setPucharses(purchases);


        DeliveryCompanyDTO deliveryCompany = new DeliveryCompanyDTO("Company", "Warsaw", "15-333", "Street", 12, purchases);

        LinkedList<PurchaseItemDTO> purchaseItems = new LinkedList<>();
        PurchaseItemDTO purchaseItem = new PurchaseItemDTO();
        purchaseItem.setQuantity(2000);
        purchaseItems.add(purchaseItem);











        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Computer");
        productDTO.setPrice(20000.0);
        productDTO.setPurchaseItems(purchaseItems);

        purchaseItem.setProduct(productDTO);





        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setDeliveryCity("Warsaw");
        purchaseDTO.setCustomer(customer);
        purchaseDTO.setPurchaseItems(purchaseItems);
        purchaseDTO.setDeliveryStreetNumber(1);
        purchaseDTO.setDeliveryStreet("Long");
        purchaseDTO.setDeliveryCompany(deliveryCompany);
        purchaseDTO.setDate(new Date());

        purchaseItem.setPurchase(purchaseDTO);




        customerDao.save(customer);
        deliveryCompanyDao.save(deliveryCompany);
        productDao.save(productDTO);
        purchaseDao.save(purchaseDTO);
        pucharseItemDao.save(purchaseItem);

   */


        //2nd program launch
        //updating City and Street in Purchases
        /*
        long id1=1;
        PurchaseDTO updatedPurchase= purchaseDao.findById(id1);

        updatedPurchase.setDeliveryStreet("newStreet");
        updatedPurchase.setDeliveryCity("newCity");

        purchaseDao.update(updatedPurchase);
        */


    }
}
