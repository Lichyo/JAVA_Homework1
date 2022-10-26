import java.util.Scanner;

public class PrimeFac
{
    private
    int input; 
    boolean flag;
    int counter;
    int detector;

    // Input a Integer x that x > 0 and return int input.
    public int input()   
    {
        Scanner scn = new Scanner(System.in);
        input = 0;
        
        System.out.println("Please input a number x, x>1. ");
        System.out.printf("x = ");
        input = scn.nextInt();

        // because input <= 1, let user re-input a number
        while(input <= 1)
         {
            System.out.println("x <= 1, Please input x again. ");
            input = scn.nextInt();
         }
         scn.close(); 
         return input;
    }

    // return boolean result of prime detection
    public boolean result(int input)
    {
        flag = false;
        counter = 0;

        // 2 is a prime number
        if(input == 2)
        {
            flag = true;
        }

        // detect wether input is a prime number
        for( int detector = 2; detector < input; detector++)
         {
            if( (input % detector) == 0 )
            {
                counter++;
                break;
            }
         }
         // if false represent composition number
         if(counter == 1)
            flag = false;

         // if true represent prime number
         else if(counter ==0)
            flag = true;

         // return result
         return flag;
    }

    // print decomposition result
    public void decomposition(int input, boolean flag)
    {
        detector = 2;

        // if input is prime number then break
        if(flag == true)
        {
            System.out.println(input + " is a prime number.");
            return;
        }
        
        // else, Processing decomposition and print on screen
        System.out.printf(input + " = ");
        counter = 0;
        
        // running decomposition
        while(detector <= input)
        {
            if(input % detector == 0)
            {
                System.out.printf(detector + " * ");
                input /= detector;
                detector = 2;
                counter++;
            }

            else if (input % detector != 0)
            {
                detector++;
            }
        }
        if(input == 1)
        {
            System.out.println("1");
            System.out.println();
            return;     // break to main()
        }
    }   
}