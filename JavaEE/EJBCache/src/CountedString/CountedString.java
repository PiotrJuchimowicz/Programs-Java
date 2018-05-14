package CountedString;

public class CountedString {
    private String value;
    private long start=0;



    public void startCount()
    {
        start=System.nanoTime()/(1000000000);
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
