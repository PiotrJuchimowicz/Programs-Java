package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
public class PossibleTypes
{
    @Id
    @GeneratedValue
    private long ID;

    private int someInt;
    private short someShort;
    private  double someDouble;

    private  Integer someInteger;
    private BigDecimal someBigDecimal;

    private int[] integerArray;

    private MyEnum myEnum;

    @Transient//wont be int DB
    private int ignoredFiled;


    public int getIgnoredFiled() {
        return ignoredFiled;
    }

    public void setIgnoredFiled(int ignoredFiled) {
        this.ignoredFiled = ignoredFiled;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public short getSomeShort() {
        return someShort;
    }

    public void setSomeShort(short someShort) {
        this.someShort = someShort;
    }

    public double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(double someDouble) {
        this.someDouble = someDouble;
    }

    public Integer getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    public BigDecimal getSomeBigDecimal() {
        return someBigDecimal;
    }

    public void setSomeBigDecimal(BigDecimal someBigDecimal) {
        this.someBigDecimal = someBigDecimal;
    }

    public int[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }
}
