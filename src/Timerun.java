import java.util.Scanner;

public class Timerun {
    public static void main(String[] args) {
        System.out.println("Put in the date you want to convert into 13th month Calander date");
        System.out.println("Make sure the Date is formated like month/day/year");
        boolean go = true;
        while (go) {
            Scanner keyboard = new Scanner(System.in);
            String day = keyboard.nextLine();
            Time outime = new Time(day);
            System.out.println(outime.toString());
            Scanner goer = new Scanner(System.in);
            System.out.println("Would you like to do more dates? (y or n)");
            String going = goer.nextLine();
            if(going.substring(0,1).equals("y")||going.substring(0,1).equals("yes")||going.substring(0,1).equals("Y"))
            {
                go=true;
            }
            else
            {
                go=false;
            }
        }

    }
}
