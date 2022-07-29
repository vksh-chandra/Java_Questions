import javax.swing.*;
import java.awt.event.*;

class GUI4 extends JFrame implements ActionListener{
    JTextField jt;
	JButton jb;
	JLabel jl1, jl2;
	GUI4(){
		jt = new JTextField();
		jt.setBounds(80,50,100,30);
		add(jt);
		
		jl1 = new JLabel("Enter ->");
		jl1.setBounds(50,80,150,30);
		add(jl1);
		
		jl2 = new JLabel("Reverse");
		jl2.setBounds(110, 150, 250,60);
		add(jl2);
		
		jb = new JButton("Submit");
		jb.setBounds(150, 100, 150, 50);
		add(jb);
		
		jb.addActionListener(this);
		
		setLayout(null);
		setSize(800,800);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int a = Integer.parseInt(jt.getText());
		int b =0;
		if(e.getSource().equals(jb)){
			while(a>0){
				int rem = a%10;
				b = b*10+rem;
				a /=10;
			}
			jl2.setText(String.valueOf(b));
		}
	}
	
	public static void main(String[] args){
		GUI4 t = new GUI4();
	}
	
}
