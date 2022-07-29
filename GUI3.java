import java.awt.event.*;
import javax.swing.*;

public class GUI3 implements ActionListener{
    public static void main(String[] args) {
        JFrame f = new JFrame("Action Listner: ");
        JButton b = new JButton("Click Me");
        final JTextField tf = new JTextField();
        b.setBounds(50,50,50,30);
        tf.setBounds(50,100, 150, 20);
        //b.addActionListener(this);

        f.add(b);
        f.add(tf);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        //tf.setText("I was clicked");
    }
}
