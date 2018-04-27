/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.JPA;

import com.company.Models.PurchaseDTO;
import java.util.List;

public interface PurchaseDao extends GenericDao<PurchaseDTO, Long> {
    List<PurchaseDTO> selectAllPurchases();
    List<PurchaseDTO> selectAllPurchasesV2();
}

