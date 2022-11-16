import java.util.Scanner;

public class H2_111016041 
{
    public static void main(String [] args)
    {   
        /*
        * Name: 李其祐
        * Class: 資二甲
        * ID: 111016041
        * 自評分數：90
        * 有做到輸出正確結果、擋非數字，但是程式寫的不太好看
        */


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
        // for(int i = 0; i < array.length; i++)   // 找最大最小
        // {
        //     if(array[i] > max)
        //     {
        //         max = array[i];
        //         // System.out.println(array[i]);
        //     }
        //     if(min > array[i])
        //     {
        //         min = array[i];
        //         //System.out.println(array[i]);
        //     }
        // }
        // System.out.println("max = " + max);
        // System.out.println("min = " + min);
        int [] temp = new int[array.length];

        int pointer=0;
        // 找最大最小，然後把數字排進temp
        for(int j=0;j<array.length;j++)
        {			
            max = min;
            pointer = 0;
            for(int i = 0;i < array.length; i++)
            {		
                if(max < array[i])
                {					
                    max = array[i];
                    pointer = i;
                }
            }	
            array[pointer] = min -1;				
            temp[temp.length - 1 - j] = max;                               
        }
        // 顯示結果
        for(int i = 0;i < temp.length; i++)
        {			
            System.out.print(temp[i]+" ");
        }
    }    
}
