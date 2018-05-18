package com.company;

import Domain.ModifiedString;

import Remote.CacheRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sound.midi.Soundbank;

import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NamingException {

        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        // create a context passing these properties
        Context ctx = new InitialContext(jndiProps);

        Object object = ctx.lookup("ejb:/Project/Cache!Remote.CacheRemote");

        CacheRemote cr = (CacheRemote) object;


        Scanner scanner = new Scanner(System.in);

        int choose = 0;
        String key = null;
        String value = null;

        while (true) {
            System.out.println("1 - add");
            System.out.println("2 - remove");
            System.out.println("3 - get");
            System.out.println("4 - contains");
            System.out.println("5 - exit");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Enter key");
                    key = scanner.next();
                    System.out.println("Enter value");
                    value = scanner.next();
                    ModifiedString cs = new ModifiedString();
                    cs.setText(value);
                    cr.add(key, cs);
                    break;


                case 2:
                    System.out.println("Enter key");
                    key = scanner.next();
                    cr.remove(key);
                    break;

                case 3:
                    System.out.println("Enter key");
                    key = scanner.next();
                    Object o = cr.get(key);
                    System.out.println(o.toString());
                    break;

                case 4:
                    System.out.println("Enter key");
                    key = scanner.next();
                    boolean bool = cr.contains(key);
                    System.out.println(bool);
                    break;
                case 5:
                    scanner.close();
                    return;

            }
        }


    }


}
