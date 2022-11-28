import java.util.Scanner;


public class H5_111016041
{
    public static void main(String [] args)
    {
        /*
         * infex -> prefix
         * 
         */

        Scanner scanner = new Scanner(System.in);
        String testinput = "1 + 2 + 3";
        String [] input;
        
        


        System.out.print("請輸入中序表示式，並以空格間隔每個運算子、元：");
        input = scanner.nextLine().split(" ");
        scanner.close();
        // 將輸入存入 input，並以空格分開
        for(int i = 0; i < input.length; i++)
        {
            System.out.println(input[i]);
        }

        // infix -> prefix alg


        
         

         
    }
}