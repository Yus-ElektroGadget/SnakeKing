import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class LaunchPage implements ActionListener{
 JLabel background;

 JLabel label = new JLabel(); //create a label

 JFrame frame   = new JFrame();
 JButton Play   = new JButton("Play");
 JButton Exit   = new JButton("Exit");
 JButton Credit = new JButton("Credit");
 JButton Help   = new JButton("Help");



 LaunchPage(){
  frame.setTitle("Main Menu");
  
 Border border = BorderFactory.createLineBorder(Color.green,3);
 

 JLabel label = new JLabel(); //create a label
 label.setText("Snake King"); //set text of label
 label.setForeground(new Color(0x00FF00)); //set font color of text
 label.setFont(new Font("Courier new",Font.PLAIN,50)); //set font of text

 label.setBorder(border); //sets border of label (not image+text)
 

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(500,500);
  
  frame.setVisible(true);	 
  frame.add(label);
  frame.pack();
  Play.setBounds(540,460,200,40);
  Play.setFocusable(false);
  Play.addActionListener(this);

  Help.setBounds(540,510,200,40);
  Help.setFocusable(false);
  Help.addActionListener(this);

  Credit.setBounds(540,560,200,40);
  Credit.setFocusable(false);
  Credit.addActionListener(this);

  Exit.setBounds(540,610,200,40);
  Exit.setFocusable(false);
  Exit.addActionListener(this);
  
  frame.add(Play);
  frame.add(Credit);
  frame.add(Help);
  frame.add(Exit);
  
  frame.setBackground(Color.BLACK);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(1300,750);
  frame.setResizable(false);
  frame.setLayout(null);
  frame.setVisible(true);

 
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==Play) {
    frame.dispose();
    new GameFrame();
  }
  if(e.getSource()==Help) {

  }
   if(e.getSource()==Credit) {

   
   }

   if(e.getSource()==Exit) {

   
    frame.dispose();
    System.exit(0);

}
 }
 }




