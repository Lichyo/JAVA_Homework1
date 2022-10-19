import java.util.Scanner;
/*
* 質數作業 
* Name: Lichyo
* Class: 資二甲
* ID: 111016041
*/

class PrimeFac
{
    int input;
    int detector;
    int counter;

    int input()   // Input a Integer x that x > 0.
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

    void result(int input)
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
         System.out.println("是");
         else if(counter ==0)
         System.out.println("否");
    }
}

public class HomeWork_1
{
    public static void main(String args[])
    {   
        PrimeFac prime = new PrimeFac();
        prime.result(prime.input());
    }
}
