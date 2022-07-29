import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class GUI2{
    public static void main(String[] args) {
        JFrame f = new JFrame();
        final JTextField txt = new JTextField();
        txt.setBounds(130,50,100,40);

        JButton b = new JButton("Click");
        b.setBounds(130,100,100,40);

        f.add(b);
        f.add(txt);
        //f.setShape(shape);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);

        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        txt.setText("Welcome to Javatpoint.");  
                    }  
                });  
    }

}
