import java.awt.*;
import java.awt.event.*;

public class H7_111016041 {
    static String inputHead ="";
    static String inputRear ="";
    static String inputTemp = "";
    static double input_1 = 0;
    static double input_2 = 0;
    static int calculateFlag = 0;
    static String calculateOperator = "";
    static int inputFlag = 0;
    static public void inputting()
    {
        if(calculateFlag < 2)
            calculateFlag++;

        else if(calculateFlag == 2)
            calculateFlag = 0;
    }
    static class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String btn = e.getActionCommand();
            if(calculateFlag == 2)
            {
                switch(calculateOperator)
                {
                    case "+":
                        inputHead = Double.toString(Double.parseDouble(inputHead) + Double.parseDouble(inputTemp));
                        calculateFlag = inputFlag = 0;
                    break;
                    
                    case "-":
                        inputHead = Double.toString(Double.parseDouble(inputHead) - Double.parseDouble(inputTemp));
                        calculateFlag = inputFlag = 0;
                    break;

                    case "*":
                        inputHead = Double.toString(Double.parseDouble(inputHead) * Double.parseDouble(inputTemp));
                        calculateFlag = inputFlag = 0;
                    break;

                    case "/":
                        inputHead = Double.toString(Double.parseDouble(inputHead) / Double.parseDouble(inputTemp));
                        calculateFlag = inputFlag = 0;
                    break;
                }
            }
            switch( btn ) {
                case "0": 
                    inputRear = "0";
                    break;
                case "1": 
                    inputRear = "1"; 
                    break;    
                case "2": 
                    inputRear = "2";
                    break;
                case "3": 
                    inputRear = "3";
                    break;
                case "4": 
                    inputRear = "4";
                    break;
                case "5": 
                    inputRear = "5";
                    break;
                case "6": 
                    inputRear = "6";
                    break;
                case "7": 
                    inputRear = "7";
                    break;
                case "8": 
                    inputRear = "8";
                    break;
                case "9": 
                    inputRear = "9";
                    break;
                case "+":
                    calculateOperator = "+";
                    inputting();
                    return;
                case "-":
                    calculateOperator = "-";
                    inputting();
                    return;
                case "*":
                    calculateOperator = "*";
                    inputting();
                    return;
                case "/":
                    calculateOperator = "/";
                    inputting();
                    return;

                case "%":
                    double i = 0;
                    i = Double.parseDouble(inputHead);
                    i = i / 100;
                    inputHead = Double.toString(i);
                    lab.setText(inputHead);
                    return;

                case "=":
                    switch(calculateOperator)
                    {
                        case "+":
                            inputHead = Double.toString(Double.parseDouble(inputHead) + Double.parseDouble(inputTemp));
                            calculateFlag = inputFlag = 0;
                        break;
                        
                        case "-":
                            inputHead = Double.toString(Double.parseDouble(inputHead) - Double.parseDouble(inputTemp));
                            calculateFlag = inputFlag = 0;
                        break;

                        case "*":
                            inputHead = Double.toString(Double.parseDouble(inputHead) * Double.parseDouble(inputTemp));
                            calculateFlag = inputFlag = 0;
                        break;

                        case "/":
                            inputHead = Double.toString(Double.parseDouble(inputHead) / Double.parseDouble(inputTemp));
                            calculateFlag = inputFlag = 0;
                        break;
                    }
                    System.out.println("inputHead = " + inputHead);
                    lab.setText(inputHead);
                    calculateFlag = 0;
                    return;
                case ".":
                    inputRear = ".";
                    break;
                case "C":
                    calculateFlag = 0;
                    inputHead = "";
                    inputRear = "";
                    lab.setText("input : " + "0");
                    return;

                case "delete":
                    inputHead = inputHead.substring(0, inputHead.length()-1 );
                    break;

                default: 
                    break;
            }
            
            if(calculateFlag == 0)
            {
                inputHead = inputHead + inputRear;  // accumulate inputNumber
            }   
            else if(calculateFlag == 1)
            {
                inputTemp = inputRear;
            }
            System.out.println(inputHead);
            lab.setText("input : " + inputHead);
        }
    }
    static Frame frm = new Frame();
    static int result = 0;
    static Button num_1 = new Button("1");
    static Button num_0 = new Button("0");
    static Button num_2 = new Button("2");
    static Button num_3 = new Button("3");
    static Button num_4 = new Button("4");
    static Button num_5 = new Button("5");
    static Button num_6 = new Button("6");
    static Button num_7 = new Button("7");
    static Button num_8 = new Button("8");
    static Button num_9 = new Button("9");
    static Button addBtn = new Button("+");
    static Button subBtn = new Button("-");
    static Button divBtn = new Button("/");
    static Button mulBtn = new Button("*");
    static Button clearBtn = new Button("C");
    static Button deleteBtn = new Button("delete");
    static Button equalBtn = new Button("=");
    static Button pointBtn = new Button(".");
    static Button PAndN = new Button("+/-");    // un add
    static Button CE = new Button("CE");    // un add
    static Button percent = new Button("%"); // un add 
    static Button under = new Button("1/x");    // un add
    static Button square = new Button("square");    // un add
    static Label lab = new Label (inputHead);
    static Label labOutput = new Label();
    static Label output = new Label("Result : ");
    

    public static void main(String [] args) {
       
       
        frm.setTitle("Calculator");
        frm.setVisible(true);
        frm.setLayout(null);
        frm.setLocation(300, 0);
        frm.setSize(400, 800);  // Screen 300, Calculator 500.
        frm.add(lab);
        frm.add(num_1);
        frm.add(num_2);
        frm.add(num_3);
        frm.add(num_4);
        frm.add(num_5);
        frm.add(num_6);
        frm.add(num_7);
        frm.add(num_8);
        frm.add(num_9);
        frm.add(num_0);
        frm.add(addBtn);
        frm.add(subBtn);
        frm.add(mulBtn);
        frm.add(divBtn);
        frm.add(equalBtn);
        frm.add(deleteBtn);
        frm.add(pointBtn);
        frm.add(clearBtn);
        frm.add(lab);
        frm.add(percent);
        frm.add(CE);

        // label
        frm.add(labOutput);
        frm.add(output);
        lab.setBackground(Color.yellow);
        
        num_1.addActionListener(new MyListener());
        num_2.addActionListener(new MyListener());
        num_3.addActionListener(new MyListener());
        num_4.addActionListener(new MyListener());
        num_5.addActionListener(new MyListener());
        num_6.addActionListener(new MyListener());
        num_7.addActionListener(new MyListener());
        num_8.addActionListener(new MyListener());
        num_9.addActionListener(new MyListener());
        num_0.addActionListener(new MyListener());
        addBtn.addActionListener(new MyListener());
        subBtn.addActionListener(new MyListener());
        mulBtn.addActionListener(new MyListener());
        divBtn.addActionListener(new MyListener());
        equalBtn.addActionListener(new MyListener());
        clearBtn.addActionListener(new MyListener());
        pointBtn.addActionListener(new MyListener());
        deleteBtn.addActionListener(new MyListener());
        percent.addActionListener(new MyListener());
        CE.addActionListener(new MyListener());
        // .addActionListener(new MyListener());

        
        num_0.setBounds(0, 700, 100, 100);
        num_1.setBounds(0, 400, 100, 100);
        num_2.setBounds(100, 400, 100, 100);
        num_3.setBounds(200, 400, 100, 100);
        num_4.setBounds(0, 500, 100, 100);
        num_5.setBounds(100, 500, 100, 100);
        num_6.setBounds(200, 500, 100, 100);
        num_7.setBounds(0, 600, 100, 100);
        num_8.setBounds(100, 600, 100, 100);
        num_9.setBounds(200, 600, 100, 100);
        addBtn.setBounds(300, 400, 100, 100);
        subBtn.setBounds(300, 500, 100, 100);
        mulBtn.setBounds(300, 600, 100, 100);
        divBtn.setBounds(300, 700, 100, 100);
        equalBtn.setBounds(200, 700, 100, 100);
        pointBtn.setBounds(100, 700, 100, 100);
        clearBtn.setBounds(0, 300, 100, 100);
        deleteBtn.setBounds(100, 300, 100, 100);
        percent.setBounds(200, 300, 100, 100);
        CE.setBounds(300, 300, 100, 100);
        lab.setBounds(0, 0, 400, 150);
        output.setBounds(0, 150, 400, 50);

    }
}