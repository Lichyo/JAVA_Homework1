import java.util.Scanner;

public class H2_111016041 
{
    public static void main(String [] args)
    {   
        int max = 0, min = 0;
        Scanner scn = new Scanner(System.in);
        System.out.println("請依序輸入欲排序數字，並以空白間隔每個數字");
        System.out.println("例如：2 3 4 7 11 6");
        String[] input= scn.nextLine().split(" ");
        scn.close();
        int [] array = new int[input.length];
        for(int i=0;i<input.length;i++) // 偵測有沒有輸入非數字相關符號字元，如果有將跳出程式，沒有就將String 轉成 int
        {
            try
            {
                array[i] = Integer.parseInt(String.valueOf(input[i]));        
            }catch(Exception e){
                System.out.println("輸入錯誤，將退出程式");
                return;     // 離開程式
            }
        }
        max = 0;
        min = 0;
        for(int i = 0; i < array.length; i++)   // 找最大最小
        {
            if(array[i] > max)
            {
                max = array[i];
                // System.out.println(array[i]);
            }
            if(array[i] < min)
            {
                min = array[i];
                System.out.println(array[i]);
            }
        }
        int temp = 0;
        // System.out.println(min);
        for(int j = 0; j < array.length; j++)
        {
            for(int i = 0; i < array.length; i++)
            {
                if(array[i] == min)
                {
                    min = array[i];
                    array[i] = max;
                }
            }
            System.out.printf(array[j] + " ");
        }
    }    
}
