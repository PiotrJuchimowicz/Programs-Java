package Maven;


public interface Bank
{


        /**
         * Tworzy nowe lub zwraca id istniejącego konta.
         * @param name imie i nazwisko własciciela
         * @param address adres własciciela
         * @return id utworzonego lub istniejacego konta.
         */
        Integer createAccount(String name, String address);
/*

         * Znajduje identyfikator konta.
         * @param name imię i nazwisko właściciela
         * @param address adres właściciela
         * @return id konta lub null, gdy brak konta o podanych parametrach
*/
        Integer findAccount(String name, String address);

/*
         * Dodaje srodki do konta.
         * @param id
         * @param amount srodki
         * @throws AccountIdException, gdy id konta jest nieprawidlowe
*/
        void deposit(Integer id, long amount);

/*
         * Zwraca ilosc srodkow na koncie.
         * @param id
         * @return srodki
         * @throws AccountIdException, gdy id konta jest nieprawidlowe
*/
        long getBalance(Integer id);

/*
         * Pobiera srodki z konta.
         * @param id
         * @param amount srodki
         * @throws AccountIdException, gdy id konta jest nieprawidlowe
         * @throws InsufficientFundsException, gdy srodki na koncie nie sa wystarczajace do wykonania operacji
*/
        void withdraw(Integer id, long amount);

/*
         * Przelewa srodki miedzy kontami.
         * @param idSource
         * @param idDestination
         * @param amount srodki
         * @throws AccountIdException, gdy id konta jest nieprawidlowe
         * @throws InsufficientFundsException, gdy srodki na koncie nie sa wystarczajace do wykonania operacji
*/
        void transfer(Integer idSource, Integer idDestination, long amount);

        class InsufficientFundsException extends RuntimeException
        {


        };
        class AccountIdException extends RuntimeException
        {


        };


}
