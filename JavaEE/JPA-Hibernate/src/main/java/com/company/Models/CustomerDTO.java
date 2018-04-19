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
@Table(name="CUSTOMER")
public class CustomerDTO extends AbstractDTO {
   
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "customer",cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<PurchaseDTO> pucharses;




    public CustomerDTO() {
    }

    public CustomerDTO(String firstName, String lastName, String email, List<PurchaseDTO> pucharses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pucharses = pucharses;
    }



    public List<PurchaseDTO> getPucharses() {
        return pucharses;
    }

    public void setPucharses(List<PurchaseDTO> pucharses) {
        this.pucharses = pucharses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "["+getId()+","+firstName+","+lastName+","+email+"]";
    }
}
