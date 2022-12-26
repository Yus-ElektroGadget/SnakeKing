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
        
