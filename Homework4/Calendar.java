import java.util.Scanner;

public class Calendar {
  public static void main(String[] args){

     Scanner input=new Scanner(System.in);
     System.out.println("請輸入年份");
     int year=input.nextInt();
     System.out.println("請輸入月份");
     int month=input.nextInt();
     System.out.println("請輸入日期");
     int day3 = input.nextInt();
     int day=0;
     //第二步：求输入的年份月份与1900年1月1日相隔的总天数
     for (int i = 1900; i < year; i++) {
       if ((i % 4 == 0 && i % 100 != 0)||(i % 400 == 0)) {
        day+=366;
      }else {
        day+=365;
      }
     }
      //求相隔月份的天数
     for (int i = 1; i < month; i++) {
      if (i==2) {
        if ( ( year % 4 == 0 && year % 100 != 0) || ( year % 400 == 0 ) ) {
          day+=29;
        }else {
          day+=28;
        }
      }else if (i==4||i==6||i==9||i==11) {
        day+=30;
      }else {
        day+=31;
      }
     }
     //第三步：计算上个月最后一天是星期几
    int weeks = day % 7;
    int day2 = 0;
    switch (month) {
      case 2:
        if (year%4==0&&year%100!=0||year%400==0) {
          day2+=29;
        }else {
          day2+=28;
        }
          break;
      case 4:
      case 6:
      case 9:
      case 11:
        day2=30;
                break;
      default:
        day2=31;
          break;
    }
    //第四部：打印日历
    System.out.println("一\t二\t三\t四\t五\t六\t日");
    for (int i = 1; i <= weeks; i++) {
      System.out.print(" \t");
    }
    for (int i = 1; i <= day2; i++) {
      System.out.print(i+"\t");
      if ((i+weeks)%7==0) {
        System.out.println();
      }
    }
    System.out.println();
    System.out.println("當天星期：" + (weeks + day3) % 7 );
  }
}
