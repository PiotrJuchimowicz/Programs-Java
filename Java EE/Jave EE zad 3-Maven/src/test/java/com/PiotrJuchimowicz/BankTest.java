package com.PiotrJuchimowicz;


import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class BankTest
{
    private BankImpl bank;

    //Robi sie przed kazdym testem
    @Before
    public void start() {
        bank = new BankImpl();
        bank.createAccount("Piotr Juchimowicz", "Łomża");
        bank.createAccount("Michał Kuc","Białystok");
    }

    //Test dla zmiennej przyporządkowywującej kolejne id
    @Test
    public void test1() {
        assert BankImpl.getNumber() == 2;
    }
    //Test dla konstruktora
    @Test
    public void test2() {
        assert bank.getList() != null;

    }

    //Testy dla metody  createAccount
    //Sprawdza czy prawidłowo dodano konto.Myślę że atomowość jest ok.
    @Test
    public void test3()
    {
        assert bank.getList().get(0).getAddress().equals("Łomża");
        assert bank.getList().get(0).getName().equals("Piotr Juchimowicz");
        assert bank.getList().get(0).getFunds()==0;

    }
    //Sprawdza czy metoda zwroci id juz istniejacego konta
    @Test
    public void test4()
    {
        assert bank.createAccount("Piotr Juchimowicz", "Łomża")==0;



    }
    //Testuje czy mozna odnaleźć konto po konkretnym id
    @Test
    public void test5()
    {
        //Moglem tez porownac przez assert po prostu.
        assertEquals("Niepoprawne id",1,bank.findAccount("Michał Kuc","Białystok"),0);

    }
    //Testuje czy zwroci null jesli brak konta o danym adresie
    @Test
    public void test6()
    {
        assert bank.findAccount("Marek Ciborowski","Białystok") ==null;
    }
    //Testuje metode deposit
    @Test
    public void test7()
    {
        bank.deposit(0,2500);
        assert bank.getList().getFirst().getFunds()==2500;
    }
    //Metoda ma zwrócić wyjątek dla niepoprawnego id
    @Test
    public void test8()
    {
        try {bank.deposit(4,3000);}
        catch(Bank.AccountIdException e)
        {
            assert true;
        }
    }

    //Testy dla metody getBalance
    @Test
    public void test9()
    {
        bank.deposit(1,10000);
        assert bank.findObject(1).getFunds()==10000;

    }
    //Testy dla metody withdraw
    //Jesli nie ma konta o takim id
    @Test
    public void test10()
    {
        try
        {
            bank.withdraw(5,200);
        }
        catch(Bank.AccountIdException e)
        {
            assert true;
        }
    }

    //Jesli nie ma srodkow na koncie
    @Test
    public void test11()
    {
        assert bank.findObject(0).getFunds()==0;
        bank.deposit(0,2000);
        try
        {
            bank.withdraw(0,10000);
        }
        catch(Bank.InsufficientFundsException e)
        {
            assert true;
        }
    }

    //Sprawdza czy poprawnie odjęto dane środki
    @Test
    public void test12()
    {
        bank.findObject(0).setFunds(1500);
        bank.withdraw(0,500);
        assertEquals(1000,bank.findObject(0).getFunds(),0);
    }

    //Testy dla metody transfer
    //Testy dla niepoprawnych danych wejściowych
    @Test
    public void test13()
    {
        try
        {
            bank.transfer(10,20,5);
        }
        catch(Bank.AccountIdException a)
        {
            assert true;
        }
    }

    @Test
    public void test14()
    {
        bank.findObject(0).setFunds(2000);
        bank.findObject(1).setFunds(5000);

        try
        {
            bank.transfer(0,1,4000);
        }

        catch(Bank.InsufficientFundsException e)
        {
            assert  true;
        }
    }

    //Sprawdza czy odpowiednio przelano srodki
    @Test
    public void test15()
    {
        bank.findObject(0).setFunds(2000);
        bank.findObject(1).setFunds(5000);
        bank.transfer(0,1,1000);

        assert (bank.findObject(0).getFunds()==1000 && bank.findObject(1).getFunds()==6000);
    }


}
