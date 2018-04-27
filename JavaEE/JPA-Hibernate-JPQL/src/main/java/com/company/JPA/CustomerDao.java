package com.company.JPA;

import com.company.Models.CustomerDTO;
import com.company.Models.PurchaseDTO;

import java.util.List;


public interface CustomerDao extends GenericDao<CustomerDTO, Long> {

     List<CustomerDTO> findByLastName(String param);

     List <PurchaseDTO> findHisPurchases(long id);


}
