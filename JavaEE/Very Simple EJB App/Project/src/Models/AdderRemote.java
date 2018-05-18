package Models;

import javax.ejb.Remote;

import  java.util.*;
@Remote
public interface AdderRemote {
    int add(int x, int y);

    int getElement(int i);

     int  example();
}
