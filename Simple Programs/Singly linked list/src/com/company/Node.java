package com.company;

public class Node
{
    private int num;
    private Node next;

    public  Node(int n)
    {
        num=n;
        next=null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
