/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.JPA;

import com.company.Models.ProductDTO;

import java.util.List;

public interface ProductDao extends GenericDao<ProductDTO, Long> {
    List<ProductDTO> findInRange(double parA,double parB);

    ProductDTO findTheExpensivest();

    List<ProductDTO> findWithoutPurchase();

    List<ProductDTO> findWithMostPieces();

    List<Long>  test();





}
