package com.company;

import java.util.List;

public class doublyList
{
    private Node first;

    public doublyList()
    {
        first=null;
    }

    public void add(int n)
    {
        Node pom=first;

        if(pom==null)
        {
            first= new Node(n);
            first.setBefore(null);
        }

        else
        {
            while (pom.getNext()!=null)
            {
                pom=pom.getNext();
            }

            Node node= new Node(n);
            pom.setNext(node);
            node.setBefore(pom);
        }

    }

    public void show()
    {
        Node pom=first;
        if(pom==null)
            return;
        else
            while(pom!=null)
            {
                System.out.print(pom.getNumber()+ " ");
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
