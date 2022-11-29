import java.util.Scanner;


public class H5_111016041
{
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String [] input;
        int [] priority = new int[500];
        String stack [] = new String [500];
        int temp_priority = 0;
        for(int i = 0; i < 500; i++)
        {
            priority[i] = 0;
        }
        for(int i = 0; i < 500; i++)
        {
            stack[i] = "";
        }
        int top = -1;
        int count_fail_push = 0;
        
        System.out.print("請輸入中序表示式，並以空格間隔每個運算子、元：");
        input = scanner.nextLine().split(" ");
        scanner.close();
        int count = 0;
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
                    temp_priority = 1;
                    if(top != -1 && priority[top] < temp_priority )
                    {
                        stack[count] = "+";
                        priority[count] = 1;
                        top++;
                        count++;
                        System.out.println("top = " + top);
                        System.out.println("count = " + count);
                    }
                    while(top != -1 && priority[top] > temp_priority)
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

                // case "-" :
                //     if(top == -1)
                //     {
                //         stack[i] = input[i];
                //         priority[i] = 1;
                //         top++;
                //     }
                //     temp_priority = 1;
                //     if(top != -1 && priority[top] < temp_priority )
                //     {
                //         stack[i] = "-";
                //         priority[i] = 1;
                //         top++;
                //     }
                //     while(top != -1 && priority[top] > temp_priority)
                //     {
                //         System.out.print(stack[i]);
                //         top--;
                //         count_fail_push++;
                //     }
                //     if(count_fail_push > 0)
                //     {
                //         stack[i] = "-";
                //         priority[i] = 1;
                //         top++;
                //     }
                //     break;

                // case "*" :
                //     if(top == -1)
                //     {
                //         stack[i] = input[i];
                //         priority[i] = 2;
                //     }
                //     temp_priority = 2;
                //     if(top != -1 && priority[top] < temp_priority )
                //     {
                //         stack[i] = "*";
                //         priority[i] = 2;
                //         top++;
                //     }
                //     while(top != -1 && priority[top] > temp_priority)
                //     {
                //         System.out.print(stack[i]);
                //         top--;
                //         count_fail_push++;
                //     }
                //     if(count_fail_push > 0)
                //     {
                //         stack[i] = "*";
                //         priority[i] = 2;
                //         top++;
                //     }
                //     break;

                // case "/" :
                //     if(top == -1)
                //     {
                //         stack[i] = input[i];
                //         priority[i] = 2;
                //     }
                //     temp_priority = 2;
                //     if(top != -1 && priority[top] < temp_priority )
                //     {
                //         stack[i] = "/";
                //         priority[i] = 2;
                //         top++;
                //     }
                //     while(top != -1 && priority[top] > temp_priority)
                //     {
                //         System.out.print(stack[i]);
                //         top--;
                //         count_fail_push++;
                //     }
                //     if(count_fail_push > 0)
                //     {
                //         stack[i] = "/";
                //         priority[i] = 2;
                //         top++;
                //     }
                //     break;

                // case "(" :
                //     if(top == -1)
                //     {
                //         stack[i] = input[i];
                //         priority[i] = 3;
                //     }
                //     temp_priority = 3;
                //     if(top != -1 && priority[top] < temp_priority )
                //     {
                //         stack[i] = "(";
                //         priority[i] = 3;
                //         top++;
                //     }
                //     while(top != -1 && priority[top] > temp_priority)
                //     {
                //         System.out.print(stack[i]);
                //         top--;
                //         count_fail_push++;
                //     }
                //     if(count_fail_push > 0)
                //     {
                //         stack[i] = "(";
                //         priority[i] = 3;
                //         top++;
                //     }
                //     break;

                // case ")" :
                //     if(top == -1)
                //     {
                //         stack[i] = input[i];
                //         priority[i] = 3;
                //     }
                //     temp_priority = 3;
                //     if(top != -1 && priority[top] < temp_priority )
                //     {
                //         stack[i] = ")";
                //         priority[i] = 3;
                //         top++;
                //     }
                //     while(top != -1 && priority[top] > temp_priority)
                //     {
                //         System.out.print(stack[i]);
                //         top--;
                //         count_fail_push++;
                //     }
                //     if(count_fail_push > 0)
                //     {
                //         stack[i] = ")";
                //         priority[i] = 3;
                //         top++;
                //     }
                //     break;
                default:
                    System.out.print(input[count]);
                    break;
            }
            // if(top != -1)
            // {
            //     System.out.print(stack[top]);
            //     top--;
            // }
            // if(top == -1)
            // {
            //     System.out.println();
            //     System.out.println("輸出結束");
            // }
        }

    }   
}