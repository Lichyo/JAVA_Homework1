public interface Expression 
{
    String add = "+";
    String sub = "-";
    String mul = "*";
    String div = "/";

    public int setPriority(String input);
}
