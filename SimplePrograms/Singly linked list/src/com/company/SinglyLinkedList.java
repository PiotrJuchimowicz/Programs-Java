package com.company;

public class SinglyLinkedList
{
    private Node first;

    public SinglyLinkedList()
    {
        first=null;
    }


    public void add(int n)
    {
        if(first==null)
        {
            first=new Node(n);
        }
        else
        {
            Node pom=first;

            while(pom.getNext()!=null)
                pom=pom.getNext();

            pom.setNext(new Node(n));
        }
    }

    public  void delete(int n) {
        Node pom = first;
        Node before=first;
        if (pom == null)
            return;

        while(pom!=null)
        {
            //Remembers  ref to two nodes

            if(pom.getNum()==n)
                break;
            else
            {
                before=pom;
                pom=pom.getNext();


            }
        }
        //first node
        if(pom==first)
        {
            first=null;
        }
        //last node
        else if(pom.getNext()==null)
        {
            before.setNext(null);
        }
        else
        {
            Node node=pom.getNext();
            before.setNext(node);
            pom=null;
        }
    }

    void showList()
    {
        Node pom=first;

        while(pom!=null)
        {
            System.out.print(pom.getNum() + "\n");
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
