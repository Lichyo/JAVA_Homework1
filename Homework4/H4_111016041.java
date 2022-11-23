/*
 * 姓名：李其祐
 * 學號：111016041
 * 前情提要：我先找了一個年份很好看並且1 / 1是星期一的年份為起始，這樣比較方便計算，google一下發現1900年很剛好就是我要的，所以使用者只能輸入1900年之後的年份做查詢 
 * 操作說明：使用者分開輸入年份、月份、日期，若是輸入無誤，程式將跳出當田是星期幾，以及當月月曆
 * 自評分數：100 
 * 可以正常執行，並且列印出正確的日曆及答案；輸入時也會抓錯並告知。
 */




import java.util.Scanner;

public class H4_111016041 {
    public static void main(String [] args)
    {
        int year = 0;
        int month = 0;
        int day = 0;
        int tempday = 0;
        int week = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入年份, 輸入年分需大於1900：");
        try
        {
            year = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("輸入格式錯誤，將退出程式");
            return;
        }
        if(year < 1900)
        {
            System.out.println("輸入年份小於1900，將退出程式");
            return;
        }

        System.out.print("請輸入月份：");
        try
        {
            month = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("輸入格式錯誤，將退出程式");
            return;
        }

        if(month > 12 || month < 1)
        {
            System.out.println("輸入月份錯誤，將退出程式");
            return;
        }
        System.out.print("請輸入日期：");
        try
        {
            tempday = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("輸入格式錯誤，將退出程式");
            return;
        }
        if(month == 2)
        {
            if(tempday > 29)
            {
                System.out.println("日期輸入錯誤，將退出程式");
                return;
            }
        }
        //檢查日有沒有輸入錯誤
        switch(month)
        {
            case 2:
                if(day > 29)
                {
                    System.out.println("日期輸入錯誤，將退出程式");
                    return;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:    
                if(tempday > 31)
                {
                    System.out.println("日期輸入錯誤，將退出程式");
                    return;
                }
                break;
            default:
                if( tempday > 30)
                {
                    System.out.println("日期輸入錯誤，將退出程式");
                    return;
                }
                break;
        }


        // 求出輸入年了跟1900年相差幾天
        for(int i = 1900; i < year; i++)
        {
            if( (i % 4 ==0 && i % 100 != 0) || i % 400 ==0 )
            {
                day += 366;
            }            
            else 
            {
                day += 365;
            }
        }

        // 求出輸入月份的1 / 1跟1900的1 / 1相差幾天
        for(int i = 1; i < month; i++)
        {
            if(i == 2)
            {
                if( (i % 4 ==0 && i % 100 != 0) || i % 400 ==0 )
                {
                    day += 29;
                }            
                else 
                {
                    day += 28;
                }
            }
            else if(i == 1 || i == 3 || i == 5 || i == 7|| i == 8 || i == 10 || i ==12)
            {
                day += 31;
            }
            else 
            {
                day += 30;
            }
        }

        int calendarday = 0;    //calendarday 是當月有幾天
        switch (month) {
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 
                {
                    calendarday += 29;
                }
                else 
                {
                    calendarday += 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                calendarday  = 30;
                break;
            default:
                calendarday = 31;
                break;
        }

        // 當月1號星期幾
        week = day % 7; // 全部天數除以每週有幾天

        System.out.println("一\t二\t三\t四\t五\t六\t日");
        // 透過當月一號星期幾去空格
        for (int i = 1; i <= week; i++) 
        {
            System.out.print(" \t");
        }
        // 印出日曆
        for (int i = 1; i <= calendarday; i++) 
        {
            System.out.print(i + "\t");
            // 每七天換行繼續印
            if ( ( i + week ) % 7 == 0 ) 
            {
                System.out.println();
            }
        }
    
        //輸出當天星期幾
        System.out.println();
        System.out.println("當天星期：" + (week + tempday) % 7);
    }
}


