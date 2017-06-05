package calculateclientages;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
 
public class CalculateClientAges {
 
/**
* Month Representations
*/
static final int JAN = 0;
static final int FEB = 1;
static final int MAR = 2;
static final int APR = 3;
static final int MAY = 4;
static final int JUN = 5;
static final int JUL = 6;
static final int AUG = 7;
static final int SEP = 8;
static final int OCT = 9;
static final int NOV = 10;
static final int DEC = 11;
 
public static void main(String[] args) {
      
    int d, m, y;
    int count = 1;
    String response;
    ArrayList<Integer> listAge = new ArrayList<Integer>();
    ArrayList<Integer> listDay = new ArrayList<Integer>();
    ArrayList<Integer> listMonth = new ArrayList<Integer>();
    ArrayList<Integer> listYear = new ArrayList<Integer>();
    ArrayList<Integer> listClientCount = new ArrayList<Integer>();
    ;
    
    Scanner input = new Scanner(System.in);
   
       do{
             System.out.println("Enter your birth day: ");
             d = input.nextInt();
             listDay.add(d);
             System.out.println("Enter your birth month: ");
             m = input.nextInt();
             listMonth.add(m);
             System.out.println("Enter your birth year: ");
             y = input.nextInt();
             listYear.add(y);
              
             listAge.add(calculateMyAge(y,m,d));
             listClientCount.add(count++);
      
     
             System.out.println("Would you like to enter details for another client? (Y/N): ");
             response = input.next();
            
             if (response.equalsIgnoreCase("n")){
    	   
            	 for (int x = 0; x < listAge.size(); x++){
            		 System.out.println("Client " + listClientCount.get(x) + " was born in " + listMonth.get(x) +"/"+ listDay.get(x) +"/"+ listYear.get(x) + ". They are currently "
            		 + listAge.get(x) + " years old.\n");	   
            	 }
            	 System.out.println("Thanks for using the age calculator!");
              
             }
 
       }while (response.equalsIgnoreCase("y"));

}

  private static int calculateMyAge(int year, int month, int day) {
 
       Calendar birthCal = new GregorianCalendar(year, month, day);
 
       Calendar nowCal = new GregorianCalendar();
 
       int age = nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
 
       boolean isMonthGreater = birthCal.get(Calendar.MONTH) >= nowCal
                     .get(Calendar.MONTH);
 
       boolean isMonthSameButDayGreater = birthCal.get(Calendar.MONTH) == nowCal
                     .get(Calendar.MONTH)
                     && birthCal.get(Calendar.DAY_OF_MONTH) > nowCal
                     .get(Calendar.DAY_OF_MONTH);
 
       if (isMonthGreater || isMonthSameButDayGreater) {
              age=age-1;
       }
              return age;
    }
 
}
 
 