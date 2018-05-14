package com.company;

import Remote.CacheRemote;
import Models.CountedString;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NamingException {

        double start = System.nanoTime();
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        // create a context passing these properties
        Context ctx = new InitialContext(jndiProps);

        Object object = ctx.lookup("ejb:/EJBCache.jar/Cache!Remote.CacheRemote");

        CacheRemote remote = (CacheRemote) object;

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
                    CountedString cs = new CountedString();
                    cs.setValue(value);
                    remote.add(key, cs);
                    break;


                case 2:
                    System.out.println("Enter key");
                    key = scanner.next();
                    remote.remove(key);
                    break;

                case 3:
                    System.out.println("Enter key");
                    key = scanner.next();
                    Object o = remote.get(key);
                    break;

                case 4:
                    System.out.println("Enter key");
                    key = scanner.next();
                    boolean bool = remote.contains(key);
                    break;
                case 5:
                    scanner.close();
                    return;

            }
        }


    }
}
