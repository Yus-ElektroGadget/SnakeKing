import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;

//Menu Help
public class Help implements ActionListener {

    //Deklarasi 
    JLabel arrows, daftarMakanan;
    JFrame frame = new JFrame();
    JButton Exit = new JButton("Comeback");
    

    Help() {

        //Buat Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setSize(1300, 750);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Help Menu");
        frame.getContentPane().setBackground(new Color(0x123456)); // change color of background
        ImageIcon image = new ImageIcon("image/snake.png"); // create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of frame
        
        //Tambah Button Kembali
        Exit.setBounds(40, 650, 200, 40);
        Exit.setFocusable(false);
        Exit.addActionListener(this);
        frame.add(Exit);
        
        //Tambah Text Arrow
        JLabel tutorText = new JLabel(); //create a label
        tutorText.setText("Gunakan arrow pada keybord untuk mengontrol arah ular"); //set text of label
        tutorText.setForeground(new Color(0, 0, 0)); //set font color of text
        tutorText.setFont(new Font("Roboto", Font.PLAIN, 35)); //set font of text
        tutorText.setSize(1300, 750);
        tutorText.setBounds(300, -180, 1300, 750);
           
        
        
        
