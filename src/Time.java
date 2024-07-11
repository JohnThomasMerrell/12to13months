import java.time.LocalDateTime;

public class Time {
    public String out="";
    static int days [] = { 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31 };
    static int bdays [] = { 28, 28, 28, 28, 28, 28,
            28, 28, 28, 28, 28, 29 };

    public Time(String day) {
       int d=0;
       int m=0;
       int y=0;
       boolean l=false;
        String[] timear = new String[3];
       boolean g=false;
        try{
             timear = day.split("/");
             m= Integer.parseInt(timear[0]);
             d= Integer.parseInt(timear[1]);
             y= Integer.parseInt(timear[2]);
            g=true;
        }
        catch (Exception e)
        {
            g=false;
        }
        if(m>12)
        {
            g=false;
        }
        if (y<0)
        {
            g=false;
        }
        if (d>days[m-1])
        {
            g=false;
        }
        if(y%100==0) {
            if (y % 400 == 0)
            {
                l=true;
            }
            else
            {
                l=false;
            }
        }
        else if(y%4==0)
        {
            l=true;
        }
        else
        {
            l=false;
        }
        out = getdate(d,m,y,g,l);
    }
    public String getdate(int day, int month, int year,boolean good, boolean leap) {
        if(good) {
            if (month > 2 && year % 4 == 0 &&
                    (year % 100 != 0 || year % 400 == 0))
            {
                ++day;
            }
            if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            {
                leap=true;
            }
            else
            {
                leap=false;
            }

            // Add the days in the previous months
            while (--month > 0)
            {
                day = day + days[month - 1];
            }
        //    return ""+day;
            int cday=day;
            int cmonth=0;
            if(leap)
            {
                if (!(cday==30 && cmonth==12)) {
                    while (cday > 28) {
                        if (cmonth == 0) {
                            cday = cday - (bdays[cmonth] + 1);
                            cmonth++;
                        }
                        else
                        {
                            cday = cday - (bdays[cmonth]);
                            cmonth++;
                        }
                    }
                }
            }
            else
            {
                while (cday>28)
                {
                    cday = cday - (bdays[cmonth]);
                    cmonth++;
                }
            }
            if(cday<1)
            {cday=bdays[cmonth]-(cday*-1);}
            cmonth++;
            return (cmonth+"/"+cday+"/"+year);






        }
        else {
            return "Error";
        }
    }

    public String toString() {
        return out;
    }
}