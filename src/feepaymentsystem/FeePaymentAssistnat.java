
package feepaymentsystem;
import java.util.*;
import java.io.Console;

/*
 * FeePaymentAssistant.java
 * 
 * Written by : Shridhar Hegde
 * Written for: XYZ University
 * Date       : 20th April 2018
 * Version    : 1.0
 *
 */
/*
        This class acts as the FPA that was designed in the earlier phase of the project.
        In this code, the FPA just asks the user for loign credentials and validates the user.
        In the current programme following assumption is made about the username and password:
            Username:  Contains 12 characters
            Password:  Username with "123" at the end

	@Author 	Shridhar Hegde
        @Version	1.0, 20/April/2018
	@See 		Student
*/

public class FeePaymentAssistnat
{
    private String username,password;
    private float pendingFees = (float) 25000.00;
    private float feesPaid;
    
    public float getPendingFees()
    {
        return(pendingFees);
    }
       
    //Authenticate user based on the username and password
    public boolean userAuthentication(Student student) throws Exception
    {
        Scanner input = new Scanner(System.in);
        int count = 0;
        boolean booleanFlag1=false, booleanFlag2=false;
        
        boolean flag =true;
        while(true)
        {   
            if(count>3)     //Check maximum number of attempts to log in 
                return(false);
            System.out.print("\tEnter the username >> ");
            username = input.nextLine();    //get inputs from the user
            count++;    
            if(username.length()<12 || username.length()>12)    //Validate the username
            {
                System.out.println("\t\tOops. Invalid username. Please enter again.");
                continue;
            }
            else
            { booleanFlag1=true; break; }
        }       
        while(true)
        {
            if(count>3)     //Maximum number of attempts check
                return(false);
            System.out.print("\tEnter the password >> ");
            password = input.next();
            count++;
            String temp = this.username+"123";
            if(!password.equals(temp))      //Checking the username and password
            {
                System.out.println("\t\tOops. Invalid username. Please enter again.");
                continue;
            } else
            { 
                booleanFlag2=true; break;   //If successful,return
            }
        }     
        if(booleanFlag1 && booleanFlag2)
            return(true);
        else
            return(false);            
    }  
    
    public boolean collectFees(Student student)
    {
        int count =0;
        while(true)
        {
            if(count > 3)       //maximum attempts check
                return(false);
            String temp;    //Temporary variable to store user credentials which will be later disposed
            System.out.print("\tEnter card number >> ");
            temp=student.payFees(1);
            System.out.print("\tEnter pin number >> ");
            temp = student.payFees(2);
            System.out.print("\tEnter the amount to pay >> ");
            temp =  student.payFees(3);
            feesPaid = Float.parseFloat(temp);      //Get the amount paied by the user
            count++;
            if(feesPaid < pendingFees)      //If user pays less fees, then exit the function
            {
                System.out.println(" !!! Opps. Payed amount was lesser than the pending fees. Try again. !!!");
                continue;
            }
            else
                return(true);
        } 
    }
      
    public static void main(String[] args) throws Exception
    {
        System.out.println("===================================================================");
        System.out.println(" __ __ __   __            __    ___   __    __    __     \n" +
                    "|_ |_ |_   |__) /\\\\_/|\\/||_ |\\ | |   (_ \\_/(_ \\_/|_ |\\/| \n" +
                    "|  |__|__  |   /--\\| |  ||__| \\| |   __) | __) | |__|  | \n" +
                        "                                                         ");
        System.out.println("===================================================================");
        
        //Create an object of the Fee Payment Assistant to carry out operations
        FeePaymentAssistnat FPA = new FeePaymentAssistnat();
        Student student = new Student();
        
        System.out.println("--- USER AUTHENTICATION ---");
        boolean authenticationFlag = FPA.userAuthentication(student);
        
        if(authenticationFlag)  //TO confirm whether the authentication is done properly or not
            System.out.println("--- AUTHENTICATION SUCCESSFUL ---");
        else
        {
            System.out.println(" !!! Authentication FAILED !!!");
            System.exit(0);     //If authentication is failed then exit the program
        }
        
        System.out.print("--- PENDING FEES ---");
        float pendingFees = FPA.getPendingFees();
        System.out.println("\nFees to be paid --> Rs."+pendingFees);
        System.out.println("CONNECTING TO BANK PORTAL ...");
        boolean paymentFlag = FPA.collectFees(student);     //Fee payment flag
        
        if(paymentFlag)     //If payment is failed then notify the user
            System.out.println("--- PAYMENT SUCCESFUL ---");
        else
            System.out.println("\tOpps. Payment did not happen correctly. Plase try again");
        
        System.out.println("  _____ _  _   _   _  _ _  __ __   _____  _   _ \n" +
                        " |_   _| || | /_\\ | \\| | |/ / \\ \\ / / _ \\| | | |\n" +
                        "   | | | __ |/ _ \\| .` | ' <   \\ V / (_) | |_| |\n" +
                        "   |_| |_||_/_/ \\_\\_|\\_|_|\\_\\   |_| \\___/ \\___/ \n" +
                           "                                                ");
    }
}
