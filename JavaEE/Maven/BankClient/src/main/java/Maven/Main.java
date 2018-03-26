package Maven;


import java.util.Scanner;
import java.util.logging.*;
import java.util.*;
import  java.io.*;
import java.util.logging.Formatter;
public class Main
{
    public static  void main(String[] args) throws IOException {
    Logger logger = Logger.getLogger(Main.class.getName());
    logger.setLevel(Level.FINER);
    FileHandler fileHandler= new FileHandler("Log%g.txt",1024*1024,4);
    Formatter SimpleFormatter= new SimpleFormatter();
    fileHandler.setFormatter(SimpleFormatter);
    logger.addHandler(fileHandler);
    logger.finer("Początek działania aplikacji");
    //Tablica do przekazywania parametrow metod w logach
    String tab[]=new String[4];
    Scanner scanner = new Scanner(System.in);
    String name,address;
    int choose;
    Bank bank = new BankImpl();
    do {
        try {

            System.out.println("1-Tworzenie nowego konta.");
            System.out.println("2-Znajdywanie identyfikatora konta.");
            System.out.println("3-Dodanie środków do konta.");
            System.out.println("4-Sprawdzenie środków na koncie.");
            System.out.println("5-Pobranie środków z konta.");
            System.out.println("6-Przelanie środków między kontami");
            System.out.println("7-Wyjdź");
            choose = scanner.nextInt();
            //Do wczytania białego znaku po nextInt
            scanner.nextLine();
            switch (choose) {
                case 1: {
                    System.out.println("Tworzenie nowego konta");
                    System.out.println("Podaj imię i nazwisko użytkownika");
                    name = scanner.nextLine();
                    System.out.println("Podaj adres użytkownika");
                    address = scanner.next();
                    tab[0]=name;
                    tab[1]=address;
                    int numberBefore=BankImpl.getNumber();
                    int i=bank.createAccount(name,address );
                    int numberNow=BankImpl.getNumber();
                    logger.log(Level.FINE, "Wywołano metody createAccount  oraz findAccount z parametrami  {0} , {1} ",tab);
                    //Jesli utworzono nowe konto to zmienna number musiala ulec zmianie
                    //Uzyteczne przy sprawdzaniu czy utworzono nowe konto


                    if(numberNow==numberBefore)
                    {

                        System.out.println("To konto juz istnieje");
                        System.out.println("Jego id to " + i);

                    }
                    break;
                }

                case 2: {
                    System.out.println("Znajdywanie identyfikatora konta");
                    System.out.println("Podaj imię i nazwisko użytkownika");
                    name = scanner.nextLine();
                    tab[0]=name;
                    System.out.println("Podaj adres użytkownika");
                    address = scanner.next();
                    tab[1]=address;
                    Integer i = bank.findAccount(name,address );
                    logger.log(Level.FINE, "Wywołano metodę findAccount z parametrami  {0} , {1} ",tab);
                    if (i == null)
                        System.out.println("Brak takiego konta");
                    else
                        System.out.println("Id to " + i);
                    break;
                }

                case 3: {
                    System.out.println("3-Dodanie środków do konta.");
                    int id;
                    long amount;
                    System.out.println("Podaj id konta");
                    id = scanner.nextInt();
                    System.out.println("Podaj kwote");
                    amount = scanner.nextLong();
                    if(amount<0)
                    {
                        System.out.println("Niepoprawna kwota");
                        break;
                    }
                    tab[0]=Integer.toString(id);
                    tab[1]=Long.toString(amount);
                    bank.deposit(id, amount);
                    logger.log(Level.FINE, "Wywołano metodę deposit z parametrami  {0} , {1} ",tab);
                    break;
                }

                case 4: {
                    System.out.println("4-Sprawdzenie środków na koncie.");
                    System.out.println("Podaj id konta");
                    int id = scanner.nextInt();
                    Long l = bank.getBalance(id);
                    logger.log(Level.FINE, "Wywołano metodę getBalance z parametrem  {0} ",id);
                    System.out.println(l);
                    break;
                }

                case 5: {
                    int id;
                    long amount;
                    System.out.println("5-Pobranie środków z konta.");
                    System.out.println("Podaj id konta");
                    id = scanner.nextInt();
                    System.out.println("Podaj kwote");
                    amount = scanner.nextLong();
                    if(amount<0)
                    {
                        System.out.println("Niepoprawna kwota");
                        break;
                    }
                    tab[0]=Integer.toString(id);
                    tab[1]=Long.toString(amount);
                    bank.withdraw(id, amount);
                    logger.log(Level.FINE, "Wywołano metodę withdraw z parametrami  {0} , {1} ",tab);
                    break;
                }

                case 6: {
                    System.out.println("6-Przelanie środków między kontami");
                    int id1, id2;
                    long amount;
                    System.out.println("Podaj id konta z którego chcesz przelać pieniądze");
                    id1 = scanner.nextInt();
                    System.out.println("Podaj id konta na które chcesz przelać pieniądze");
                    id2 = scanner.nextInt();
                    System.out.println("Podaj kwote");
                    amount = scanner.nextLong();
                    if(amount<0)
                    {
                        System.out.println("Niepoprawna kwota");
                        break;

                    }
                    tab[0]=Integer.toString(id1);
                    tab[1]=Integer.toString(id2);
                    tab[2]=Long.toString(amount);
                    bank.transfer(id1, id2, amount);
                    logger.log(Level.FINE, "Wywołano metodę transfer z parametrami  {0} , {1} , {2} ",tab);

                    break;
                }

                case 7: {
                    logger.finer("Koniec działania aplikacji");
                    return;

                }
                default: {
                    System.out.println("Niepoprawny wybór");

                }
            }
        } catch (Bank.InsufficientFundsException e) {
            System.out.println("Nie ma  tylu środków na koncie");
            logger.log(Level.CONFIG, "Nie ma tylu środków na koncie" ,e);
        } catch (Bank.AccountIdException e) {
            System.out.println("Niepoprawne id konta");
            logger.log(Level.CONFIG, "Niepoprawne id konta" ,e);
        } catch (InputMismatchException e) {
            System.out.println("Niepoprawne dane wejściowe");
            logger.log(Level.CONFIG, "Niepoprawne dane wejściowe" ,e);

        } catch (NullPointerException e) {
            System.out.println("Nie ma konta o takim id");
            logger.log(Level.CONFIG,"Nie ma konta o takim id" ,e );
        } catch (Exception e) {
            System.out.println("Nieznany Błąd");
            logger.log(Level.WARNING, "Nieznany Błąd" ,e);

        }
    }
    while(true);

}
}
