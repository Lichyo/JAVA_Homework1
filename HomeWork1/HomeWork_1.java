import java.util.Scanner;
/*
* 質數作業 
* Name: Lichyo
* Class: 資二甲
* ID: 111016041
*/

class PrimeFac
{   
    private
    int choice;
    boolean result_ans;
    int input;
    int detector;
    int counter;

    public
    // user's input
    int input()
    {
        Scanner scn = new Scanner(System.in);
        input = 0;
        
        System.out.println("Please input a number x, x>0. ");
        //System.out.println("If you input 0, then the program will close. ");
        input = scn.nextInt();

        while(input <= 0)
        {
            System.out.println("x <1, Please input x again. ");
            input = scn.nextInt();
        }
        scn.close(); 
        return input;
    }
    
    // showing the result whether the number is prime or not
    boolean result(int input)
    {
        int counter = 0;
        for( int detector = 2; detector < input; detector++)
         {
            if( (input % detector) == 0 )
            {
                counter++;
                break;
            }
         }
         if(counter == 1 || input == 2)
         result_ans = true;

         else if(counter ==0)
         result_ans = false;

         return result_ans;
    }
    
    // processing decomposition
    void decomposition(int input, boolean result_ans)
    {
        // if input is prime number then break
        if(result_ans == true)
        {
            System.out.println(input + "is a prime number.");
            return;
        }
        
        // if not, Processing decomposition and print on screen
        System.out.printf(input + "= ");
        int temp = input;
        counter = 0;
        for(detector = 2; detector < temp; detector++)
        {
            if(input % detector == 0)
            {
                System.out.printf(detector + " * ");
                input /= detector;
                detector = 2;
                counter++;
            }
            if(input == 1 && counter != 0)
            {
                System.out.printf("1");
                return;
            }

        }
    }
    
    // show the functions and return the the user's choice
    int menu()
    {
       while(true)
       {
        Scanner scn = new Scanner(System.in);
        System.out.println("0. Exit.");
        System.out.println("1. Identify whether the number is a prime number.");
        System.out.println("2. Processing Prime Factorization.");
        System.out.printf("Choice a function : ");
        choice = scn.nextInt();
        scn.close();
        return choice;
       }
    }
}

public class HomeWork_1
{
    public static void main(String args[])
    {   
        PrimeFac prime = new PrimeFac();
        int choice;
        int input = 0;
        boolean result = false;

        while(true)
        {
            choice = prime.menu();

            // Input a Nature number to identify whether the number is a prime number or not.
            if(choice == 1)
            {
                input = prime.input();
                result = prime.result(input);
                System.out.println(result);
            }

            // Decomposition.
            if(choice == 2)
            {
                // user haven't input a number. Back to Menu.
                if(input == 0)
                    continue;
                
                prime.decomposition(input, result);
            }

            // Exit.
            if(choice == 0)
                return;
        }
    }
}
