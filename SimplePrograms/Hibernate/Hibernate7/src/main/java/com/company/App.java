package com.company;

import OneToOneBidirectional.Address;
import OneToOneBidirectional.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Address and Employee in relation OneToOne(BiDirectional)
//Phone and Worker in relation OneToMany(BiDirectional)
//ZOO and Animal in relation OneToMany(Unidirectional)
public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address address = new Address("Zwierzyniecka", "Bialystok", 10);
        Employee employee = new Employee("Jan", "Kowalski", 1234, address);
        entityManager.persist(employee);

        entityManager.getTransaction().begin();

        entityManager.persist(address);
        entityManager.persist(employee);

        //entityManager.remove(entityManager.find(Address.class,4L));
        //entityManager.remove(entityManager.find(Employee.class,3L));


        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}

#include<stdio.h>
        #include<stdlib.h>
        #include<signal.h>
        #include<pthread.h>
        #include<memory.h>
        #include<stdbool.h>
        #include<stdint.h>
        #include<unistd.h>

        //Counts writers who realy write
        int criticalWriters;

        int numberOfReaders;
        int numberOfWriters;
        int numberOfReadersReading;
        int numberOfWritersWritting;

        pthread_mutex_t resourceMutex;
        pthread_mutex_t tryResourceMutex;
        pthread_mutex_t readerMutex;
        pthread_mutex_t writerMutex;

        void*readerFunction(void*idP)
        {

        int*id=(int*)idP;

        while(1)
        {
        //Wstepny mutex przy dostepie do zasobu,moze byc zablkowany przez pisarza lub przez czytelnika

        pthread_mutex_lock(&tryResourceMutex);

        //Czytelnicy wchodza do czytelni pojedynczo

        pthread_mutex_lock(&readerMutex);

        // W srodku jest czytelni wiec jest ich o 1 wiecej
        numberOfReadersReading++;
        //Jesli do czytelni wchodzi pierwszy czytelnik zasob jest blokowany.Pisarz nie  moze wejsc
        if(numberOfReadersReading==1)
        pthread_mutex_lock(&resourceMutex);

        //Inni czytelnicy moga wejsc
        pthread_mutex_unlock(&readerMutex);


        //zwalnia wstepona blokade zasobu
        pthread_mutex_unlock(&tryResourceMutex);
        //poczatek sekcji krytycznej
        printf("Reader with id = %d entered \n",*id);
        printf("ReaderQ: %d , WriterQ: %d [in: R:%d W:%d]\n",numberOfReaders-numberOfReadersReading,numberOfWriters-criticalWriters,numberOfReadersReading,criticalWriters);
        //koniec czesci krytycznej
        sleep(1);

        pthread_mutex_lock(&readerMutex);
        numberOfReadersReading--;

        //Jesli w czytelni nie ma juz czytelnikow zasob jest odblkowany. Pisarz moze wejsc
        if(numberOfReadersReading==0)
        pthread_mutex_unlock(&resourceMutex);

        pthread_mutex_unlock(&readerMutex);
        }

        }

        void*writerFunction(void*idP)
        {


        int*id=(int*)idP;
        while(1)
        {

        //Tylko jeden pisarz  moze wejsc wiec blokuje mutex

        pthread_mutex_lock(&writerMutex);

        numberOfWritersWritting++;
        if(numberOfWritersWritting==1)
        pthread_mutex_lock(&tryResourceMutex);//Blokuje dostep innym czytelnikom do biblioteki

        pthread_mutex_unlock(&writerMutex);


        pthread_mutex_lock(&resourceMutex);
        criticalWriters++;
        //poczatek sekcji krytycznej
        printf("Writer with id = %d entered \n",*id);
        printf("ReaderQ: %d , WriterQ: %d [in: R:%d W:%d]\n",numberOfReaders-numberOfReadersReading,numberOfWriters-criticalWriters,numberOfReadersReading,criticalWriters);
        sleep(1);
        //koniec sekcji krytycznej
        pthread_mutex_unlock(&resourceMutex);
        criticalWriters--;

        pthread_mutex_lock(&writerMutex);
        numberOfWritersWritting--;
        if(numberOfWritersWritting==0)
        pthread_mutex_unlock(&tryResourceMutex);

        //Jesli w kolejce do zasobu czeka pisarz od razu daje mu dostep

        pthread_mutex_unlock(&writerMutex);


        }
        }

        void Initialisation(int argc,char**argv)
        {
        //Liczba argumentow musi byc rowna 3 (nazwa programu,ilosc czytelnikow,ilosc pisarzy)
        if(argc!=3)
        {
        printf("Invalid number of arguments.");
        exit(-1);
        }
        //konwersja "tablicy charow" na inty
        numberOfReaders=strtol(argv[1],NULL,10);
        numberOfWriters=strtol(argv[2],NULL,10);
        numberOfReadersReading=0;
        numberOfWritersWritting=0;
        criticalWriters=0;

        printf("\n");
        printf(" Number of readers=%d\n",numberOfReaders);
        printf(" Numbers of writers=%d\n",numberOfWriters);

        //Inicjalizacja muteksow
        pthread_mutex_init(&readerMutex,NULL);
        pthread_mutex_init(&writerMutex,NULL);
        pthread_mutex_init(&resourceMutex,NULL);
        pthread_mutex_init(&tryResourceMutex,NULL);

        //tablice do watkow
        pthread_t readers[numberOfReaders];
        pthread_t writers[numberOfWriters];


        //Utworzenie danej liczby czytelnikow i zlecenie im wykonywania pracy
        for(int i=0;i<numberOfReaders; i++){
        int*id=(int*)(malloc(sizeof(int)));
        *id=i;
        pthread_create(&readers[i],NULL,&readerFunction,(void*)id);
        }

        //Utworzenie danej liczby pisarzy i zlecenie im wykonywania pracy
        for(int i=0;i<numberOfWriters; i++){
        int*id=(int*)(malloc(sizeof(int)));
        *id=i;
        pthread_create(&writers[i],NULL,&writerFunction,(void*)id);
        }

        //Czeka na wykonanie 1 w dodatkowego watku aby watek main nie doszedl do return 0
        pthread_join(readers[0],NULL);


        }


        int main(int argc,char**argv)
        {

        Initialisation(argc,argv);

        return 0;

        }


