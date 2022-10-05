import java.util.Scanner;

public class HomeWork_1
{
    public static void main(String args[])
    {
        /*
         * 質數作業 
         * Name: Lichyo
         * Class: 資二甲
         * ID: 111016041
         */
         // Declares   
         int input = 0; // User's Input
         int counter = 0;
         Scanner scn = new Scanner(System.in);

         System.out.println("Please input a number x, x>0. ");
         input = scn.nextInt();

         // Input a Integer x that x > 0.
         while(input <= 0)
         {
            System.out.println("x <1, Please input x again. ");
            input = scn.nextInt();
         }

         // Run the Result
         for( int detector = 2; detector < input; detector++)
         {
            if( (input % detector) == 0 )
            {
                counter++;
                break;
            }
         }

         if(counter == 1 )
            System.out.println("是");
         else if(counter ==0)
            System.out.println("否");
         
        scn.close();
    }
}
