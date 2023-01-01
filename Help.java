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
    public Sound button = new Sound("file:audio/button.wav");

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
        
        //Tambah gambar
              ImageIcon img = new ImageIcon("image/arrow.png");
              arrows = new JLabel(img);
              arrows.setSize(1300, 750);
              arrows.setBounds(-500, -200, 1300, 750);
              arrows.setVisible(true);
              frame.add(arrows);
      
              //Tambah gambar
              ImageIcon img2 = new ImageIcon("image/tutors.png");
              daftarMakanan = new JLabel(img2);
              daftarMakanan.setSize(1300, 750);
              daftarMakanan.setBounds(-510, 30, 1300, 750);
              daftarMakanan.setVisible(true);
              frame.add(daftarMakanan);

        //Tambah Header Help
        JLabel header = new JLabel(); // create a label
        header.setText("---Help---"); // set text of label
        header.setForeground(new Color(0, 0, 0)); // set font color of text
        header.setFont(new Font("Roboto", Font.PLAIN, 60)); // set font of text
        header.setSize(1300, 750);
        header.setBounds(580, -290, 1300, 750);

        frame.add(header);
        
        //Tambah Text Arrow
        JLabel tutorText = new JLabel(); //create a label
        tutorText.setText("Gunakan arrow pada keybord untuk mengontrol arah ular"); //set text of label
        tutorText.setForeground(new Color(0, 0, 0)); //set font color of text
        tutorText.setFont(new Font("Roboto", Font.PLAIN, 35)); //set font of text
        tutorText.setSize(1300, 750);
        tutorText.setBounds(300, -180, 1300, 750);
        
        frame.add(tutorText);

        //Deklarasi Text Makanan
        String str1, str2, str3, str4, str5, str6;

        str1 = "Makanan apel akan mendapatkan 1 point";
        str2 = "Makanan pisang akan mendapatkan 2 point";
        str3 = "Makanan jeruk akan mengurangi 1 point";
        str4 = "Makanan chery akan menambah kecepatan gerak ular";
        str5 = "Makanan mangga akan mengubah kecepatan gerak ular menjadi normal";
        str6 = "Makanan tengkorak akan membuat ular menjadi mati dan game selesai";

        //Tambah Text Makanan satu-persatu
        JLabel tutorEat1 = new JLabel();
        JLabel tutorEat2 = new JLabel();
        JLabel tutorEat3 = new JLabel();
        JLabel tutorEat4 = new JLabel();
        JLabel tutorEat5 = new JLabel();
        JLabel tutorEat6 = new JLabel();

        tutorEat1.setForeground(new Color(254, 0, 0)); // set font color of text
        tutorEat1.setFont(new Font("Roboto", Font.PLAIN, 30)); // set font of text
        tutorEat1.setSize(1300, 750);
        tutorEat1.setBounds(300, -50, 1300, 750);
        tutorEat1.setText(str1);
        frame.add(tutorEat1);

        tutorEat2.setForeground(new Color(254, 255, 0)); // set font color of text
        tutorEat2.setFont(new Font("Roboto", Font.PLAIN, 30)); // set font of text
        tutorEat2.setSize(1300, 750);
        tutorEat2.setBounds(300, -10, 1300, 750);
        tutorEat2.setText(str2);
        frame.add(tutorEat2);

        tutorEat3.setForeground(new Color(0, 0, 254)); // set font color of text
        tutorEat3.setFont(new Font("Roboto", Font.PLAIN, 30)); // set font of text
        tutorEat3.setSize(1300, 750);
        tutorEat3.setBounds(300, 30, 1300, 750);
        tutorEat3.setText(str3);
        frame.add(tutorEat3);

        tutorEat4.setForeground(new Color(255, 255, 255)); // set font color of text
        tutorEat4.setFont(new Font("Roboto", Font.PLAIN, 30)); // set font of text
        tutorEat4.setSize(1300, 750);
        tutorEat4.setBounds(300, 70, 1300, 750);
        tutorEat4.setText(str4);
        frame.add(tutorEat4);

        tutorEat5.setForeground(new Color(128, 128, 128)); // set font color of text
        tutorEat5.setFont(new Font("Roboto", Font.PLAIN, 30)); // set font of text
        tutorEat5.setSize(1300, 750);
        tutorEat5.setBounds(300, 110, 1300, 750);
        tutorEat5.setText(str5);
        frame.add(tutorEat5);

        tutorEat6.setForeground(new Color(255, 0, 254)); // set font color of text
        tutorEat6.setFont(new Font("Roboto", Font.PLAIN, 30)); // set font of text
        tutorEat6.setSize(1300, 750);
        tutorEat6.setBounds(300, 150, 1300, 750);
        tutorEat6.setText(str6);
        frame.add(tutorEat6);

    }

    //Tambah ActionListener Work
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Exit) {
            button.play();
            frame.dispose();
            new LaunchPage();
        }
    }

}
           
        
        
        
