import java.util.Scanner;


public class H5_111016041
{
    static int count_fail_push = 0;
    public static void push(String [] stack, int index, String input)
    {
        stack[index + 1] = input;
    }
    public static void push(int [] priority, int index, int input)
    {
        priority[index + 1] = input;
    }
    public static int deter(String [] stack, int [] priority, String [] inputs, int top, int input_priority, int i)
    {
        int count_fail_push = 0;
        while(top != -1 && priority[top] >= input_priority)
        {
            System.out.print(pop(stack, top) + " ");
            top--;
            count_fail_push++;
        }
        if(count_fail_push > 0)
        {
            push(stack, top, inputs[i]);
            push(priority, top, input_priority);
            top++;
            count_fail_push = 0;
        }
        if(top != -1 && priority[top] < input_priority )
        {   
            push(stack, top, inputs[i]);
            push(priority, top, input_priority);
            top++;
        }
        if(top == -1)
        {
            push(stack, top, inputs[i]);   
            push(priority, top, input_priority);
            top++;
        }
        return top;
    }
    public static String pop(String [] stack, int index)
    {
        return stack[index];
    }
    public static int [] deterPrefix(String [] stack, int [] priority, String [] inputs, String [] prefix, int top, int input_priority, int i, int prefix_top)
    {
        String prefix_input = inputs[inputs.length -1 -i];
        int  [] result = new int [2];

        // priority[top] <= priority of input
        if(top != -1 && priority[top] <= input_priority)
        {
            push(stack, top, prefix_input);
            push(priority, top, input_priority);
            top++;
            // System.out.print("Present stack : ");
            // for(int x = 0; x < stack.length; x++)
            // {   
            //     System.out.print(stack[x] + " ");
            // }
        }
        
        // priority[top] > priority of input
        else if(top != -1 && ((priority[top] > input_priority)))
        {
            while(priority[top] > input_priority)
            {
                push(prefix, prefix_top, pop(stack, top));
                prefix_top++;
                count_fail_push++;
                if(top == 0)
                {
                    System.out.println("into 6 ");
                    push(stack , top, prefix_input);
                    push(priority, top, input_priority);
                    top++;
                    count_fail_push = 0;
                    break;
                }
                top--;
                System.out.println("into 1");
                System.out.println("top = " + top);
            }
            if(count_fail_push > 0)
            {
                System.out.println("into 2");
                push(stack, top, prefix_input);
                System.out.println("into 3");
                push(priority, top, input_priority);
                top++;
                System.out.println("into 4");
                System.out.print("Present stack : ");
                for(int x = 0; x < stack.length; x++)
                {   
                    System.out.print(stack[x] + " ");
                }
                count_fail_push = 0;
            }
        }
        else if(top == -1)
        {   
            push(stack, top, prefix_input);
            push(priority, top, input_priority);
            System.out.print("Present stack : ");
            for(int x = 0; x < stack.length; x++)
            {   
                System.out.print(stack[x] + " ");
            }
            top++;
        }
        result[0] = top;
        result[1] = prefix_top;
        return result;
    }
    
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String [] input;
        int top = -1;
        int prefix_top = -1;
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

        String [] prefix = new String [input.length];
        for(int i = 0; i < input.length; i++)
        {
            prefix[i] = "";
        }

        System.out.println("Your input :");
        // print out what user input
        for(int i = 0; i < input.length; i++)
        {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        // 1 + 2 * 3 + 4 / 2 - 7
        // ( 1 + 2 ) * 3 + 4 / 2

        // transfer infix to postfix
        {
            System.out.print("This is infix to postfix : ");
        for(int i = 0 ; i < input.length; i++ )
        {
            switch(input[i])
            {
                case "+" :
                    input_priority = 1;
                    top = deter(stack, priority, input, top, input_priority, i);
                    break;

                case "-" :
                    input_priority = 1;
                    top = deter(stack, priority, input, top, input_priority, i);
                    break;
                    

                case "*" :
                    input_priority = 2;
                    top = deter(stack, priority, input, top, input_priority, i);
                    break;

                case "/" :
                    input_priority = 2;
                    top = deter(stack, priority, input, top, input_priority, i);
                    break;

                case "(" :
                    input_priority = 3;
                    push(stack, top, "(");
                    top++;
                    break;

                case ")" :
                    input_priority = 3;
                    while(pop(stack, top) != "(")
                    {
                        System.out.print(pop(stack, top) + " ");
                        top--;
                    }
                    if(pop(stack, top) == "(")
                    {
                        top--;
                    }
                    break;

                default:
                    System.out.print(input[i] + " ");
                    break;
            }
        }   
        // Output post fix
        for(int j = 0;j < stack.length; j++)
        {
            if(top >= 0)
            {
                System.out.print(pop(stack, top) + " ");
                top--;
            }
        }

        }
        
        // prefix
        top = -1;
        prefix_top = -1;
        int result [] = new int [2];
        // clean up operator stack
        for(int j = 0; j < stack.length; j++)
        {
            stack[j] = "";
        }
        String prefix_input = "";
        System.out.println();
        System.out.print("This is infix to prefix : ");
        for(int i = 0 ; i < input.length; i++ )
        {
            prefix_input = input[input.length -1 -i];
            switch(prefix_input)
            {
                case "+" :
                    input_priority = 1;
                    result = deterPrefix(stack, priority, input, prefix, top, input_priority, i, prefix_top);
                    top = result[0];
                    prefix_top = result[1];
                    break;

                case "-" :
                    input_priority = 1;
                    result = deterPrefix(stack, priority, input, prefix, top, input_priority, i, prefix_top);
                    top = result[0];
                    prefix_top = result[1];
                    break;
                    

                case "*" :
                    input_priority = 2;
                    result = deterPrefix(stack, priority, input, prefix, top, input_priority, i, prefix_top);
                    top = result[0];
                    prefix_top = result[1];
                    break;

                case "/" :
                    input_priority = 2;
                    result = deterPrefix(stack, priority, input, prefix, top, input_priority, i, prefix_top);
                    top = result[0];
                    prefix_top = result[1];
                    break;
                
                case ")" :
                    push(stack, top, ")");
                    top++;
                    break;

                case "(" :
                    while(pop(stack, top) != "(" && top != 1)
                    {
                        push(prefix, prefix_top, pop(stack, top));
                        prefix_top++;
                        top--;
                    }
                    if(pop(stack, top) == ")" && top != 1)
                    {
                        push(stack, top, "");
                        top--;
                    }
                    break;

                

                default:
                    push(prefix, prefix_top, prefix_input);
                    prefix_top++;
                    System.out.print("Present prefix stack : ");
                    for(int x = 0; x < prefix.length; x++)
                    {   
                        System.out.print(prefix[x] + " ");
                    }
                    break;
            }
        }   
        
        System.out.println();
        System.out.print("This is stack : ");
        for(int i = 0; i < input.length; i++)
        {   
            if(top == -1)
                break;
            System.out.print(pop(stack, top) + " ");
            push(prefix, prefix_top, pop(stack, top));
            prefix_top++;
            top--;
        }
        System.out.println();
        System.out.print("This is prefix stack : ");
        for(int i = 0; i < input.length; i++)
        {   
            if(prefix_top == -1)
                break;
            System.out.print(pop(prefix, prefix_top) + " ");
            prefix_top--;
        }
    }
}