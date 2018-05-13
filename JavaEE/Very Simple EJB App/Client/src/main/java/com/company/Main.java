package com.company;

import Models.AdderRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws NamingException {
        /*
       Hashtable<String,String> env = new Hashtable<String, String>();

       env.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
       env.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
       //env.put(Context.URL_PKG_PREFIXES,"orj.jboss.naming.:org.jnp.interfaces");
      // env.put(Context.PROVIDER_URL,"jnp://localhost:8080");

       InitialContext context = new InitialContext(env);
//ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName
        AdderRemote adder = (AdderRemote) context.lookup("java:global/Project.jar/Adder!Models.AdderRemote");
       // AdderRemote adderRemote = (AdderRemote) context.lookup(AdderRemote.class.getName());

       */
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        // create a context passing these properties
        Context ctx = new InitialContext(jndiProps);
        //jb:Project/Adder!Models.AdderRemote
//name = ejb:/JarFile/BeanClass!com.company.RemoteInterface
        Object object= ctx.lookup("ejb:/Project/Adder!Models.AdderRemote");
        AdderRemote remote = (AdderRemote) object;

         int x =remote.add(2,3);

        System.out.println(x);


        //System.out.println(object.toString());


    }


}
