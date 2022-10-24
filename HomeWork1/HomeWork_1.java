import java.util.Scanner;

class PrimeFac
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
public class HomeWork_1
{
    public static void main(String args[])
    {   
        /*
        * 質數作業 ：
        * Name: 李其祐
        * Class: 資二甲
        * ID: 111016041
        * Github: https://github.com/Lichyo/JAVA_Homeworks.git
        */

        /*
         * 程式使用說明：
         * 程式開始
         * 請先輸入一個大於 1 的正整數
         * true 代表該數字為質數
         * false 代表該數字為合數
         * 最後程式會顯示該數字的質因數分解結果
         * 程式結束並退出
         */

        // 評分標準(加分部分為可能最大值, 減分部分則為固定值):
        // 1. 程式有意義且可以執行 (+10%)
        // 2. 正確顯示答案 (+70%)    
        // 3. 顯示其因式分解可供驗證是否為質數 (+20%)
        // 4. 程式檔案沒有遵照規定命名 (-10%)
        // 5. 主程式開始沒有包含作者、操作說明及符合的評分標準等資訊 (即不遵守作業繳交通則C) (-10%)
        // 6. 程式沒有適當註解 (-10%)
        // 7. 抄襲 (上述評分不計, 直接 -50%)

        // 自評分數： 90
        // 1. 將程式做資料封裝
        // 2. 程式可以正常執行(true and false)
        // 3. 使用者輸入錯誤整數不會直接跳出程式，會讓使用者重新輸入
        // 4. 可以執行質因數分解
        // 5. 有進行適當註解
        

        PrimeFac prime = new PrimeFac();    // Constructor

        boolean flag = false;   // result
        int input = 0;      // Variable that User should Input.

        // input function  
        input = prime.input();  
        
        // result function
        flag = prime.result(input);
        System.out.println("Result = " + flag);

        // decomposition function
        prime.decomposition(input, flag);
        
    }
}