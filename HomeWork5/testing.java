public class testing {

    public static void change(int [] num)
    {
        num[0] = 9;
    }

    public static void main(String [] args)
    {
        int [] num = new int[3];
        for(int i = 0; i < 3; i++)
        {
            num[i] = i;
        }
        for(int i = 0; i < 3; i++)
        {
            System.out.println(num[i]);
        }
        change(num);
        for(int i = 0; i < 3; i++)
        {
            System.out.println(num[i]);
        }
    }
    
}
