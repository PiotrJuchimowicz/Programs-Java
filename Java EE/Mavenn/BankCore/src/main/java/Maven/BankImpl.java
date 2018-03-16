package Maven;

import java.util.LinkedList;
//Numer czlowieka na liscie to rowniez jego id
public class BankImpl implements Bank
{
    private LinkedList<Account> list;
    private static int number;//Zlicza klientów

    public BankImpl()
    {
        list = new LinkedList<Account>();
        number=0;
    }
    //Zwraca id konta dla podanych parametrów
    public Integer findAccount(String name,String address)
    {
        for(int i=0;i<list.size();i++)
        {
            if((list.get(i).getName().equals(name))&&(list.get(i).getAddress().equals(address)))
                return  new Integer(list.get(i).getId());
        }
        return null;
    }
    //Zwraca konto o podanym id,jesli nie znajdzie zwaraca null
    public Account findObject(int id)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getId()==id)
                return list.get(i);
        }
        return null;
    }



    public Integer createAccount(String name, String address)
    {

        Integer  id=findAccount(name,address);
        if(id!=null)
            return id;
        else
        {
            list.add(new Account(name,address,0));
            number++;

            return  number-1;
        }


    }

    //Dodaje srodki użytkownikowi o danym koncie
    public void deposit(Integer id, long amount) throws AccountIdException
    {

        //Szuka konta o takim id i dodaje mu środki
        for(int i=0;i<list.size();i++)
            if (list.get(i).getId() == id)
            {
                list.get(i).setFunds(list.get(i).getFunds()+amount);
                return;
            }
        //Wyrzuca wyjątek jeśli nie ma takiego konta
        throw new  AccountIdException();
    }

    public  long getBalance(Integer id)
    {
        if(findObject(id)==null)
            throw new AccountIdException();

        return (long)findObject(id).getFunds();

    }

    public  void withdraw(Integer id, long amount) throws AccountIdException,InsufficientFundsException
    {
        if(findObject(id)==null)
            throw new AccountIdException();

        else
        {
            float sum=findObject(id).getFunds();
            if(sum>=amount)
                findObject(id).setFunds(sum-amount);
            else
                throw new InsufficientFundsException();
        }
    }

    public void transfer(Integer idSource, Integer idDestination, long amount)
    {
        //Jesli podano zle id kont
        if((findObject(idSource)==null) || (findObject(idDestination)==null))
            throw new AccountIdException();
        else
        {
            //Jesli na koncie z ktorego idzie przelew nia ma wystarczajacych srodkow
            if(findObject(idSource).getFunds()<amount)
                throw new InsufficientFundsException();
            else
            {
                float a=findObject(idSource).getFunds();
                float b=findObject(idDestination).getFunds();
                a=a-amount;
                b=b+amount;
                findObject(idSource).setFunds(a);
                findObject(idDestination).setFunds(b);
            }
        }
    }

    public LinkedList<Account> getList()
    {
        return list;
    }

    public static int getNumber()
    {
        return number;
    }




}
