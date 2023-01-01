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

//Deklarasi SFX
public Sound button = new Sound("file:audio/button.wav");

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

 //Text Mari bang
   JLabel tutorText2 = new JLabel(); //create a label
   tutorText2.setText("Mari Bermain dengan GEMBIRA!!!"); //set text of label
   tutorText2.setForeground(new Color(104, 67, 99)); //set font color of text
   tutorText2.setFont(new Font("MV Boli",Font.PLAIN,20)); //set font of text 
   tutorText2.setSize(1300,750); 
   tutorText2.setBounds(0,-285,1300,750);
   frame.add(tutorText2);
 
 
   // Text Copyright
   JLabel tutorText = new JLabel(); //create a label
   tutorText.setText("@Free Copyright By Kelompok 5"); //set text of label
   tutorText.setForeground(new Color(0x00FF00)); //set font color of text
   tutorText.setFont(new Font("MV Boli",Font.PLAIN,25)); //set font of text 
   tutorText.setSize(1300,750); 
   tutorText.setBounds(900,310,1300,750);
   frame.add(tutorText);
     frame.getContentPane().setBackground(new Color(0x123456)); //change color of background
   ImageIcon image = new ImageIcon("image/snake.png"); //create an ImageIcon
   frame.setIconImage(image.getImage()); //change icon of frame
   ImageIcon img = new ImageIcon("image/menuImage.png");
   background = new JLabel(img);
   background.setSize(1300,750);
   background.setBounds(0,-100,1300,750);
   background.setVisible(true);
   frame.add(background);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==Play) {
     //Tambah SFX
    button.play();
    frame.dispose();
    new GameFrame();
  }
  if(e.getSource()==Help) {

  }
   if(e.getSource()==Credit) {

   
   }

   if(e.getSource()==Exit) {

   //Tambah SFX
    button.play();
    frame.dispose();
    System.exit(0);

}
 }
 }




