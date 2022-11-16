import java.util.Scanner;
import java.util.Arrays;

public class H3_111016041 {
    public static void main(String [] args)
    {
        int A = 0;
        int B = 0;
        String input;   // 使用者輸入
        int num [] = new int [4];     // 測試使用者輸入是否正確
        boolean check[]=new boolean[4];
        boolean inputCheck = false;
        Scanner scn = new Scanner(System.in);
        String question="";

        // 由電腦隨機給出題目
		for(int i=0;i<4;i++) question+=(int)(Math.random()*10);

        // 使用者開始猜數字
        while(true)
        {
            System.out.println("請輸入四個不重複整數，例如：1234");
            input = scn.next();

            // 確認輸入的都是整數
            for(int i = 0;i < 4; i++){			
                try{
                    num[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
                }catch(Exception e){
                    inputCheck = true;
                    break;
                }				
            }

            // 確認輸入的數字沒有重複
            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    if(input.charAt(i) == input.charAt(j) && i != j)
                    {
                        inputCheck = true;
                    }
                }
            }

            // 確認輸入數字皆大於0
            for(int i = 0; i < 4; i++)
            {
                if(num[i] <= 0)
                {
                    inputCheck = true;
                }
            }

            if(inputCheck == true)
            {
                System.out.println("輸入錯誤，將退出程式");
                return;
            }

            A = 0;
            B = 0;
            Arrays.fill(check, false);

            // Check A
            for(int i = 0; i < 4; i++)
            {
                if(question.charAt(i) == input.charAt(i))
                {
                    check[i] = true;    //此位置已檢查過
                    A++;
                }
            }

            // Check B
            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    if(!check[j] && question.charAt(j) == input.charAt(i)){
                        check[j]=true;
                        B++;
                        break;
                    }
                }
            }


            // Output
            if(A==4)
            {
                System.out.println("恭喜答對");
                break;
            }
            else
            {
                System.out.println(A+"A"+B+"B");
            }
        }

        
        
        
    }
}