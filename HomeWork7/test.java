import java.awt.*;
import java.awt.event.*;

import javax.swing.Action;

import org.w3c.dom.events.Event;


public class test {
    static Frame frm = new Frame("Test Frame");
    static Button btn = new Button("Click Me");

    // static class MyListener implements ActionListener{
    //     public void actionPerformed(ActionEvent event)
    //     {
    //         frm.setBackground(Color.blue);
    //     }
    // }



    public static void main(String [] args) {
        frm.setSize(500, 500);
        frm.setLayout(new FlowLayout());
        frm.setVisible(true);
        frm.add(btn);
        btn.setBounds(250, 250, 100, 100);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frm.setBackground(Color.yellow);
            }
        } );
    }
}