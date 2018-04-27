package com.company;

import com.company.Hibernate.*;
import com.company.JPA.*;
import com.company.Models.*;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import sun.applet.Main;

import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.FormatFlagsConversionMismatchException;
import java.util.LinkedList;
import java.util.List;

//All relations are Bidirectional
//Ale tables have Cascade type ALL
//One Customer can have Many Purchases
//One Purchase can have Many PurchaseItems
//One Product can have Many Purchase Items
//One DeliveryCompany can have Many Purchases

public class App {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerJpaDao();
        ProductDao productDao = new ProductJpaDao();
/*
    List<CustomerDTO> list = customerDao.findByLastName("Kowalski");

        for (CustomerDTO c: list) {
            System.out.println(c.toString());

        }
*/
/*
        List<ProductDTO> list = productDao.findInRange(50, 200);

        for (ProductDTO p : list
                ) {
            System.out.println(p.toString());

        }

*/

       // System.out.println(productDao.findTheExpensivest());

/*
        List<PurchaseDTO> list = customerDao.findHisPurchases(3);

        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

            */



/*
    List<ProductDTO> list = productDao.findWithoutPurchase();

    for (int i=0;i<list.size();i++)
        System.out.println(list.get(i));

*/
List<Long> list=productDao.test();
            for (int i=0;i<list.size();i++)
                System.out.println(list.get(i));

        /*
        List<ProductDTO> list = productDao.findWithMostPieces();

        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));

        long ig=2;
        ProductDTO d = productDao.findById(ig);
        List<PurchaseItemDTO> list1 = d.getPurchaseItems();

        System.out.println(list1.size());
*/





    }


}
