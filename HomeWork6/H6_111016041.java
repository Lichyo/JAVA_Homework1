import java.util.Scanner;


public class H6_111016041 {
    public static void main(String [] args) {
        /*
         * 姓名：李其祐
         * 學號：111016041
         * 輸入說明：
         * 自評分數：100
         * 評分理由：
         *      ㄧ、可以正常執行
         *      二、可以輸出正確答案，並且輸入"q"時會跳出Exception 並終止程式
         *      三、輸入錯誤時會跳出提示並且可以重新輸入
         */
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        String input = "";
        System.out.println("Input 5 numbers to calculate the sum, or input ' q ' to Exit");
        // input and catch exception
        for(int i = 0; i < 5; i++)
        {
            try 
            {
                input = scanner.next();
                result += Integer.parseInt(input);                    
            }
            catch(Exception exception)
            {
                System.out.println("Exception : " + exception);
                if(input.equals("q"))
                {
                    System.out.println("Exit !");
                    System.exit(0); // Exit
                }
                System.out.print("Please input the next number : ");
                i--;
            }
        }
        scanner.close();
        System.out.println("Result = " + result);
        System.out.println();
     }
}