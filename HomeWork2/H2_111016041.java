import java.util.Scanner;

public class H2_111016041 
{
    public static void main(String [] args)
    {   
        int arraySpace = 0;
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Please input a number x, x>1. ");
        // while(!scn.hasNextInt() ||  scn.nextInt() <1)
        // {
        //     System.out.println("輸入錯誤！！！");
        //     System.out.printf("請重新輸入：");
        // }
        arraySpace = scn.nextInt();

        int array [] = new int[arraySpace];
        System.out.println("請依序輸入欲排序數字，並以空白間隔每個數字");
        System.out.println("例如：2 3 4 7 11 6");
        for(int count = 0; count < arraySpace; count++)
        {
            array[count] = scn.nextInt();
        }
        scn.close();

        int temp = 0;
        for(int i = 0; i < arraySpace; i++)
        {
            for(int j = 0; j < arraySpace-1; j++)
            {
                if(array[j] < array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp; 
                }
            }
        }
        for(int i = 0; i< arraySpace; i++)
        {
            System.out.printf(array[i] + " ");
        }
    }    
}
