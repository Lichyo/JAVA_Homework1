package HW5;

class Operator
{
    String [] operator = new String [6];
    operator [0] = "+";
    operator [1] = "-";
    operator [2] = "*";
    operator [3] = "/";
    operator [4] = "(";
    operator [5] = ")";

    int priority [] = new int [6];
    priority [0] = 3;
    priority [1] = 3;
    priority [2] = 2;
    priority [3] = 2;
    priority [4] = 1;
    priority [5] = 1;
}