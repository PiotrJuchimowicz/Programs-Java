package base.Models;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private  String zipCode,city;

    public Address() {
    }

    public Address(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
