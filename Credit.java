import java.awt.Color;    // <-- Tambah Library yang dibutuhkan
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;

public class Credit implements ActionListener {

  //Deklarasi Button, label, dan frame
  JLabel background;
  JFrame frame = new JFrame();
  JButton Play = new JButton("Lets PLAY !!!");
  JButton Exit = new JButton("Back");

  //Deklarasi sound
  public Sound button = new Sound("file:audio/button.wav");

  Credit() {
    frame.setTitle("Credit"); // Buat title di frame

    //Set Frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1300, 750);
    frame.setResizable(false);
    frame.setLayout(null);
    frame.setVisible(true);

    Play.setBounds(1040, 650, 200, 40); //Set tata letak button play
    Play.setFocusable(false);
    Play.addActionListener(this);       // tambah Actionlistener

    Exit.setBounds(40, 650, 200, 40);   //Set tata letak button exit
    Exit.setFocusable(false);
    Exit.addActionListener(this);       // tambah Action Listener

    frame.add(Play); // tampilkan button
    frame.add(Exit);

    // icon frame
    frame.getContentPane().setBackground(new Color(0x123456)); // ganti warna background
    ImageIcon image = new ImageIcon("image/snake.png");        // buat ImageIcon
    frame.setIconImage(image.getImage());                      // set icon

    /*
     * Tambah Gambar/GIF 
     */

    // Image joget
    ImageIcon img = new ImageIcon("image/Joget.gif");
    background = new JLabel(img);
    background.setSize(1300, 750);
    background.setBounds(500, -250, 1300, 750);
    background.setVisible(true);
    frame.add(background);

    // xancave
    JLabel background2;
    ImageIcon img2 = new ImageIcon("image/F1.jpg");
    background2 = new JLabel(img2);
    background2.setSize(1300, 750);
    background2.setBounds(-550, -70, 1300, 750);
    background2.setVisible(true);
    frame.add(background2);

    // xancave
    JLabel background3;
    ImageIcon img3 = new ImageIcon("image/Y2.jpg");
    background3 = new JLabel(img3);
    background3.setSize(1300, 750);
    background3.setBounds(-550, -250, 1300, 750);
    background3.setVisible(true);
    frame.add(background3);

    // xancave
    JLabel background4;
    ImageIcon img4 = new ImageIcon("image/B1.jpg");
    background4 = new JLabel(img4);
    background4.setSize(1300, 750);
    background4.setBounds(-550, 110, 1300, 750);
    background4.setVisible(true);
    frame.add(background4);

    /*
     * Tambah TEXT
     */

    // Kelompok 5
    JLabel tutorText = new JLabel();                          // Buat label
    tutorText.setText("KELOMPOK 5");                          // Set text dari label
    tutorText.setForeground(new Color(0, 0, 0));              // Set warna
    tutorText.setFont(new Font("STXingkai", Font.PLAIN, 50)); // set font dan ukuran
    tutorText.setSize(1300, 750);                             // Set ukuran frame label
    tutorText.setBounds(450, -350, 1300, 750);                // set tata letak label
    frame.add(tutorText);                                     // tampilkan label

    // Yusran
    JLabel tutorText2 = new JLabel(); 
    tutorText2.setText("NIM : 3411201101"); 
    tutorText2.setForeground(new Color(0, 0, 0)); 
    tutorText2.setFont(new Font("Broadway", Font.PLAIN, 35)); 
    tutorText2.setSize(1300, 750);
    tutorText2.setBounds(200, -290, 1300, 750);
    frame.add(tutorText2);

    JLabel tutorText22 = new JLabel(); 
    tutorText22.setText("Nama : Yusran Wisnu Nasrullah Syarifudin "); 
    tutorText22.setForeground(new Color(0, 0, 0));
    tutorText22.setFont(new Font("Broadway", Font.PLAIN, 35)); 
    tutorText22.setSize(1300, 750);
    tutorText22.setBounds(200, -240, 1300, 750);
    frame.add(tutorText22);

    // Norick
    JLabel tutorText3 = new JLabel(); 
    tutorText3.setText("NIM : 3411201129"); 
    tutorText3.setForeground(new Color(0, 0, 0)); 
    tutorText3.setFont(new Font("Broadway", Font.PLAIN, 35));
    tutorText3.setSize(1300, 750);
    tutorText3.setBounds(200, -90, 1300, 750);
    frame.add(tutorText3);

    JLabel tutorText33 = new JLabel(); 
    tutorText33.setText("Nama : Maulidina Norick Eriyadi "); 
    tutorText33.setForeground(new Color(0, 0, 0)); 
    tutorText33.setFont(new Font("Broadway", Font.PLAIN, 35)); 
    tutorText33.setSize(1300, 750);
    tutorText33.setBounds(200, -40, 1300, 750);
    frame.add(tutorText33);

    // Yudha
    JLabel tutorText4 = new JLabel(); 
    tutorText4.setText("NIM : 3411201052"); 
    tutorText4.setForeground(new Color(0, 0, 0)); 
    tutorText4.setFont(new Font("Broadway", Font.PLAIN, 35));
    tutorText4.setSize(1300, 750);
    tutorText4.setBounds(200, 100, 1300, 750);
    frame.add(tutorText4);

    JLabel tutorText44 = new JLabel(); 
    tutorText44.setText("Nama : Bakti Yudha Wiradhika Utama"); 
    tutorText44.setForeground(new Color(0, 0, 0)); 
    tutorText44.setFont(new Font("Broadway", Font.PLAIN, 35));
    tutorText44.setSize(1300, 750);
    tutorText44.setBounds(200, 140, 1300, 750);
    frame.add(tutorText44);

    // Text Mari bang
    JLabel tutorTextM = new JLabel(); 
    tutorTextM.setText("Mari Bermain dengan GEMBIRA!!!");
    tutorTextM.setForeground(new Color(104, 67, 99));
    tutorTextM.setFont(new Font("MV Boli", Font.PLAIN, 20));
    tutorTextM.setSize(1300, 750);
    tutorTextM.setBounds(700, 300, 1300, 750);
    frame.add(tutorTextM);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == Play) {  //Jika menekan Button Play maka akan mengeksekusi perintah dibawah
      button.play();              // Putar Suara
      frame.dispose();            //Frame ditutup
        new GameFrame();            //Buat class GameFrame Baru

    }
    if (e.getSource() == Exit) { //Jika menekan Button Exit maka akan mengeksekusi perintah dibawah
      button.play();
      frame.dispose();
      new LaunchPage();         //Buat class LaunchPage baru

    }

  }

}