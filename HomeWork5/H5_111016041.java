import java.util.Scanner;


public class H5_111016041
{
    public static void main(String [] args)
    {
        /*
         * infex -> prefix
         * 
         */
        public static void push(char input, String stack [])
        {
            {
            String [] copy_stack = new String [stack.length];
            copy_stack = stack;
            for(int i = 0; i < stack.length; i++)
            {
                while(i == stack.length-1)
                {
                    System.out.println("push done");
                }
                System.out.println("111");
                stack[i+1] = copy_stack[i];
            }
            }
        }
        Scanner scanner = new Scanner(System.in);
        String [] input;
        String stack [] = new String [200];
        
        System.out.print("請輸入中序表示式，並以空格間隔每個運算子、元：");
        input = scanner.nextLine().split(" ");
        scanner.close();
        // 將輸入存入 input，並以空格分開
        for(int i = 0; i < input.length; i++)
        {
            System.out.println(input[i]);
        }
        Operator fun;
        fun.push('+', stack);
        






        // infix -> prefix alg
        // while( loop_counter != 0)
        // {
        //     for(int i = 0; i < input.length; i++)
        //     {
        //         if(input[i] == "+" || input[i] == "-" || input[i] == "*" || input[i] == "/" || input[i] == "(" || input[i] == ")" )
        //         {
        //             operator_operand_flag = true;
        //         }
        //     }
        // }


        
         

         
    }
}