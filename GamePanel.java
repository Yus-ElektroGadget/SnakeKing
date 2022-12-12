import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

//Mekanisme ular

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 1300; //set width frame
	static final int SCREEN_HEIGHT = 750; //set height frame
	static final int UNIT_SIZE = 50; //set ukuran unit game
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE); //set unit game
	int DELAY = 175;
	final int x[] = new int[GAME_UNITS]; //deklarasi array sesuai dengan ukuran game unit
	final int y[] = new int[GAME_UNITS];

	int bodyParts = 5; //set badan ular menjadi 5 blok
	boolean running = false;
	
	//Deklarasi Makanan
	int applesEaten;
	int appleX;
	int appleY;
	int OrangeX;
	int OrangeY;
	int PirX;
	int PirY;

	Random random;
	
	GamePanel(){
		random = new Random(); //set random
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		startGame();
	}
	public void startGame() {
		running = true;
			newApple();
	}
	public void paintComponent(Graphics g) { //deklarasi Graphics2D
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		
		if(running) { //jika berjalan true

			//Set bentuk dan warna makanan
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
            		g.setColor(Color.blue);
			g.fillRect(OrangeX, OrangeY, UNIT_SIZE, UNIT_SIZE);

           		g.setColor(Color.yellow);
			g.fillOval(PirX, PirY, UNIT_SIZE, UNIT_SIZE);

			g.setColor(Color.yellow);
			g.fillOval(PirX, PirY, UNIT_SIZE, UNIT_SIZE);


			//Tubuh Ular
			for(int i = 0; i< bodyParts;i++) { //selama i kurang dari bodyparts maka i bertambah +1
				if(i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
			//Tampilan score
			g.setColor(Color.red); //set warna
			g.setFont( new Font("Ink Free",Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());

			//tampilkan score
			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		}
		else { //jika running false
			gameOver(g); //tampilkan gameOver
		}
		
	}
	
		public void newApple(){
			appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE; //set random array x yang dimana (W x H) * Unit size
			appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE; //set random array y
		}
		public void newOrange(){
			OrangeX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
			OrangeY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		}
		public void newPir(){
			PirX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
			PirY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		}
		//makanan 1 warna merah
		public void checkApple() { 
			if((x[0] == appleX) && (y[0] == appleY)) { //jika koordinat makanan dan kepala ular sama
				bodyParts++;  //badan ular +1
				applesEaten++; //tambah point +1
				//Random Makanan
				int ListMakanan = (int)(Math.random() * 2); //Generate random makanan
				if(ListMakanan == 0){
					newPir(); 			//new adalah fungsi spawn
					newApple();

				}
				else if(ListMakanan == 1){
					newOrange();
					newApple();


				}
			}
		}
				//Makanan 2 Kuning bulat
				public void checkPir() {
					if((x[0] == PirX) && (y[0] == PirY)) { //jika koordinat makanan dan kepala ular sama
						bodyParts++; //badan ular +1
						bodyParts++; 
						applesEaten++; //tambah point +1
						applesEaten++;

						newApple();

					}
				}
				
				//Makanan 3 biru kotak
				public void checkOrange() {
					if((x[0] == OrangeX) && (y[0] == OrangeY)) {
						bodyParts--;	//badan ular -1
						applesEaten--;	//kurangi point -1
			
						newApple(); //spawn apple
			
						
					}
				}
	
	public void gameOver(Graphics g) {

		//Tampilkan Score akhir
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(running) { //jika running true maka akan menampilkan perintah dibawah
		
			checkApple();
            checkOrange();
            checkPir();

		}
		repaint();
	}
}
