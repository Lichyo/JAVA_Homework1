import java.util.Scanner;


public class H5_111016041
{
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
      
        for(int i = 0 ; i < input.length; i++ )
        {
            switch(input[count])
            {
                case "+" :
                    if(top == -1)
                    {
                        stack[count] = input[count];
                        priority[count] = 1;
                        top++;
                        count++;
                        System.out.println("top = " + top);
                        System.out.println("count = " + count);
                    }
                    input_priority = 1;
                    if(top != -1 && priority[top] < input_priority )
                    {
                        stack[count] = "+";
                        priority[count] = 1;
                        top++;
                        count++;
                        System.out.println("top = " + top);
                        System.out.println("count = " + count);
                    }
                    while(top != -1 && priority[top] > input_priority)
                    {
                        System.out.print(stack[count]);
                        top--;
                        count_fail_push++;
                        System.out.println("top = " + top);
                        System.out.println("count = " + count);
                    }
                    if(count_fail_push > 0)
                    {
                        stack[count] = "+";
                        top++;
                        count++;
                        System.out.println("top = " + top);
                        System.out.println("count = " + count);
                    }
                    break;
            }

        }   
    }
}