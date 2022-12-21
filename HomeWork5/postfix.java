import java.util.Scanner;

public class postfix implements Expression
{
    public int setPriority(String input)
    {
        int priority = 0;
        switch(input)
        {
            case add:
            case sub:
                priority = 1;
                break;

            case mul:
            case div:
                priority = 2;
        }
        return priority;
    }
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner (System.in);
        int [] priority;
        String [] input_container;
        String input;
    }
}
