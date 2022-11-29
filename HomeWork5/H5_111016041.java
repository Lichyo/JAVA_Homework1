import java.util.Scanner;


public class H5_111016041
{
    public static void push(String [] stack, int index, String input)
    {
        stack[index + 1] = input;
        for(int i = 0; i < 5; i++)
        {
            System.out.println("現在的stack = " + stack[i]);
        }
    }

    public static String pop(String [] stack, int index)
    {
        return stack[index];
    }
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String [] input;
        int top = -1;
        int count_fail_push = 0;
        int count = 0;
        int input_priority = 0;

        int [] priority = new int[500];
        for(int i = 0; i < 500; i++)
        {
            priority[i] = 0;
        }
        String stack [] = new String [500];
        for(int i = 0; i < 500; i++)
        {
            stack[i] = "";
        }

        System.out.print("請輸入中序表示式，並以空格間隔每個運算子、元：");
        input = scanner.nextLine().split(" ");
        scanner.close();

        System.out.println("Your input :");
        // print out what 
        for(int i = 0; i < input.length; i++)
        {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        // 1 + 2 + 3
        for(int i = 0 ; i < input.length; i++ )
        {
            switch(input[i])
            {
                // System.out.println("進到Switch");
                case "+" :
                    System.out.println("進到case + ");
                    
                    // empty
                    if(top != -1 && priority[top] < input_priority )
                    {   
                        push(stack, top, "+");
                        top++;
                    }
                    while(top != -1 && priority[top] > input_priority)
                    {
                        System.out.print(pop(stack, top));
                        top--;
                        count_fail_push++;
                    }
                    if(count_fail_push > 0)
                    {
                        push(stack, top, "+");
                        top++;
                        count_fail_push = 0;
                    }
                    if(top == -1)
                    {
                        push(stack, 0, "+");   
                        top++;
                    }
                    break;
                case "" :
                    System.out.println("transfer done");
                    break;

                default:
                    System.out.print("this is default : ");
                    System.out.println(input[i]);
                    break;
            }
        }   
            for(int j = 0;j < stack.length; j++)
            {
                if(top >= 0)
                {
                    System.out.println("進到最後的pop");
                    System.out.println("top = " + top);
                    System.out.print(pop(stack, top));
                    top--;
                }
            }
    }
}