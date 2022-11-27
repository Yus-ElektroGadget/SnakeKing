import javax.swing.JFrame;

// Class membuat frame Gamepanel
public class GameFrame{
  
  JFrame frame = new JFrame(); // Buat Frame
  GameFrame(){
    
    frame.add(new GamePanel()); // tampilan class GameFrame
    frame.setTitle("Snake");    // tambah title pada frame 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Jika frame di close maka sistem akan keluar
    frame.setResizable(false);  // tidak dapat mengubah ukuran
    frame.pack();
    frame.setVisible(true);     // agar frame dapat dilihat
    
    
  }

}
