package com.PiotrJuchimowicz;

public class Account
{
    private int id;
    private String name,address;
    private float funds;

    public Account(){};

    public Account(String name,String addres,float funds)
    {
        this.id=BankImpl.getNumber();
        this.name=name;
        this.address=addres;
        this.funds=funds;



    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds)
    {
        this.funds = funds;
    }
}

