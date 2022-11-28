import java.util.Scanner;
import java.util.Arrays;

/*
 * 班級：資二甲
 * 姓名：李其祐
 * 遊戲規則：輸入四個不重複的數字，然後每一輪將會公布在對的位置、錯的位置的數字共有多少個
 *          一共可以猜十輪，若是十輪到了，或是輸入錯誤（輸入非整數、小於零的數、重複數字），將直接退出遊戲
 * 自評分數：90（所有功能都有達到）
 */


public class H3_111016041 {
    public static void main(String [] args)
    {
        int A = 0;
        int B = 0;
        int count = 0;
        String input;   // 使用者輸入
        int num [] = new int [4];     // 測試使用者輸入是否正確
        boolean check[]=new boolean[4];
        boolean inputCheck = false;
        Scanner scn = new Scanner(System.in);
        String question="";

        // 由電腦隨機給出題目
		for(int i=0;i<4;i++) question+=(int)(Math.random()*10);

        System.out.println(question);
        // 使用者開始猜數字
        while(true)
        {
            if(count == 10)
            {
                System.out.println("共計玩了十輪，遊戲即將終止");
                System.out.print("正確答案為：" + question);
                return;

            }
            System.out.println("請輸入四個不重複整數，例如：1234");
            input = scn.next();
            count++;

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

            // 確認輸入數字皆大於等於0
            for(int i = 0; i < 4; i++)
            {
                if(num[i] < 0)
                {
                    inputCheck = true;
                }
            }

            // 若是輸入錯誤，將退出程式
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
                System.out.println("一共玩了：" + count + " 輪");
                break;
            }
            else
            {
                System.out.println(A+"A"+B+"B");
                System.out.println("第 "+ count +" 輪結束");
            }
        }
    }
}