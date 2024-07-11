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
            if(m==2 &&(y%4==0 || y % 400 == 0))
            {
             if(d>29)
             {
                 g=false;
             }
             else
             {
                 g=true;
             }
            }
            else {
                g = false;
            }
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
            if ((month > 2 && (year % 4 == 0)))
            {
                day++;
            }

            // Add the days in the previous months
            while (--month > 0)
            {
                day = day + days[month - 1];
            }
        //    return ""+day;
            int cday=day;
            int cmonth=(cday/28)+1;
            if(cday%28 ==0)
            {
                cmonth--;
            }
            cday = cday-(((cmonth-1)*28));
            if(cmonth==14)
            {
                cmonth--;
                cday+=(28);
            }
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