
package feepaymentsystem;
import java.util.Scanner;

/*
 * Student.java
 * 
 * Written by : Shridhar Hegde
 * Written for: XYZ University
 * Date       : 20th April 2018
 * Version    : 1.0
 *
 */
/*
        This class acts as the student who wants to pay the fees. 
        Inputs like login credentials, online trasaction credentials are given from this class.

	@Author 	Shridhar Hegde
        @Version	1.0, 20/April/2018
	@See 		FeePaymentAssistant
*/

public class Student 
{
    private float feesPaid;
    private String cardNumber,pin;
    
    //Student enters his username and password through this methods
    public String inputUserCredentials()
    {
        Scanner input = new Scanner(System.in);
        String temp = input.next();
        return(temp);
    }
    
    public String payFees(int choice)   //Function which is used while paying fees
    {
        Scanner input = new Scanner(System.in);
        switch(choice)     //Choice variable to choose between different options
        {
            case 1: cardNumber = input.next();  
                    return(cardNumber);
            case 2: pin = input.next(); 
                    return(pin);
            case 3: feesPaid = input.nextFloat();
                    return(String.valueOf(feesPaid));   //Return float as string variable
        }
         return("");    
    }
}
