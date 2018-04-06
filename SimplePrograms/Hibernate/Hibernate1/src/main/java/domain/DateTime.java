package domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
public class DateTime
{
    @Id
    @GeneratedValue
    private long id;
    private  java.sql.Date dateSql;
    private java.sql.Time timeSql;
    private java.sql.Timestamp timestampSql;

    @Temporal(TemporalType.DATE)
    private java.util.Date dateUtil1;
    @Temporal(TemporalType.TIME)
    private java.util.Date dateUtil2;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateUtil3;
    @Temporal(TemporalType.DATE)
    private java.util.Calendar calendarUtil;

    public java.util.Date getDateUtil1() {
        return dateUtil1;
    }

    public void setDateUtil1(java.util.Date dateUtil1) {
        this.dateUtil1 = dateUtil1;
    }

    public java.util.Date getDateUtil2() {
        return dateUtil2;
    }

    public void setDateUtil2(java.util.Date dateUtil2) {
        this.dateUtil2 = dateUtil2;
    }

    public java.util.Date getDateUtil3() {
        return dateUtil3;
    }

    public void setDateUtil3(java.util.Date dateUtil3) {
        this.dateUtil3 = dateUtil3;
    }

    public Calendar getCalendarUtil() {
        return calendarUtil;
    }

    public void setCalendarUtil(Calendar calendarUtil) {
        this.calendarUtil = calendarUtil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateSql() {
        return dateSql;
    }

    public void setDateSql(Date dateSql) {
        this.dateSql = dateSql;
    }

    public Time getTimeSql() {
        return timeSql;
    }

    public void setTimeSql(Time timeSql) {
        this.timeSql = timeSql;
    }

    public Timestamp getTimestampSql() {
        return timestampSql;
    }

    public void setTimestampSql(Timestamp timestampSql) {
        this.timestampSql = timestampSql;
    }
}
