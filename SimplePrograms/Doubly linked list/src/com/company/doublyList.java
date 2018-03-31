package com.company;

import java.util.List;

public class doublyList
{
    private  Node first;

    public doublyList()
    {
        first=null;
    }

    public void  add(int n)
    {
        if(first==null)
        {
            Node node= new Node(n);
            first=node;
            node.setBefore(null);
        }

        else
        {
            Node pom=first;

            while(pom.getNext()!=null)
                pom=pom.getNext();

            Node node = new Node(n);
            node.setBefore(pom);
            pom.setNext(node);
        }
    }

    public void delete(int n)
    {
        Node pom=first;
        Node bef,nex;

        while(pom!=null)
        {
            bef=pom.getBefore();
            nex=pom.getNext();
            if(pom.getNumber()==n)
                break;

            pom=pom.getNext();
        }

        if(pom==first)
        {

            Node nod;
            nod=first;
            first=first.getNext();
            first.setBefore(null);
            nod=null;
        }
        else if(pom.getNext()==null)
        {

            pom.getBefore().setNext(null);
            pom.setBefore(null);
            pom=null;
        }

        else if(pom.getNext()!=null && pom.getBefore()!=null)
        {

            pom.getBefore().setNext(pom.getNext());
            pom.getNext().setBefore(pom.getBefore());
            pom=null;

        }

    }

    public void show()
    {
        Node pom = first;

        while(pom!=null)
        {
            System.out.print(pom.getNumber() + " ");
            pom=pom.getNext();
        }

    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}
