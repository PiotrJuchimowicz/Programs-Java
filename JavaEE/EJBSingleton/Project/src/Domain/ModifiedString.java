package Domain;

import java.io.Serializable;

public class ModifiedString implements Serializable {
    private String text;
    private  long startTime=0;

    public void  startCount()
    {
        //Conversion into seconds
        startTime=System.nanoTime()/(1000000000);
    }

    public void resetTime()
    {
        startTime=0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "ModifiedString{" +
                "text='" + text + '\'' +
                '}';
    }
}
