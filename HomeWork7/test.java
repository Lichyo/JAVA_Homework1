import java.awt.*;
import java.awt.event.*;

import javax.swing.Action;

import org.w3c.dom.events.Event;


public class test {
    static Frame frm = new Frame("Test Frame");
    static TextArea textAreaInput = new TextArea();
    static TextArea textAreaCopy = new TextArea();

    static class MyListener implements ActionListener, TextListener{
        public void actionPerformed(ActionEvent event)
        {
            frm.setBackground(Color.blue);
        }
        public void textValueChanged(TextEvent textEvent)
        {
            textAreaCopy.setText(textAreaInput.getText());
        }
    }



    public static void main(String [] args) {
        frm.setSize(500, 500);
        frm.setLayout(new GridLayout());
        frm.add(textAreaInput);
        frm.add(textAreaCopy);
        textAreaCopy.setEditable(false);
        textAreaInput.addTextListener(new MyListener());
        textAreaCopy.setBackground(Color.yellow);
        frm.setVisible(true);
        

        // btn.setBounds(250, 250, 100, 100);
        // btn.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent event){
        //         frm.setBackground(Color.yellow);
        //     }
        // } );
    }
}