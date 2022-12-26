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
  	int OrangesEaten;
	int appleX;
	int appleY;
    	int OrangeX;
   	int OrangeY;
   	int PirX;
    	int PirY;
	int whiteX;
	int whiteY;
	int grayX;
	int grayY;
	int DeadX;
	int DeadY;

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

			g.drawImage(kayu, 0, 0, null);
			//timer
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
			timeLabel.setBorder(BorderFactory.createBevelBorder(1));
			timeLabel.setOpaque(true);
			this.add(timeLabel);


			//Set bentuk dan warna makanan
	
			g.drawImage(apple, appleX, appleY, this);
			g.drawImage(jeruk,OrangeX, OrangeY, this);
			g.drawImage(pisang, PirX, PirY, this);
			g.drawImage(cherry,whiteX, whiteY, this);
			g.drawImage(mangga,grayX, grayY, this);
			g.drawImage(reaper, DeadX, DeadY, this);



			//Tubuh Ular
			for(int i = 0; i< bodyParts;i++) { //selama i kurang dari bodyparts maka i bertambah +1
				if(i == 0) {
					
					g.drawImage(head,x[i], y[i], this);
				}
				else {
					g.setColor(Color.blue);
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
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
	/*******Mekanisme Collision********/

	public void checkCollisions() {
		//Jika kepala menabrak badan ular
		for(int i = bodyParts;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		//Jika kepala ular menabrak border kiri frame
		if(x[0] < 0) {
			running = false;
		}
		//Jika kepala ular menabrak border kanan frame
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		//Jika kepala ular menabrak border atas frame
		if(y[0] < 0) {
			running = false;
		}
		//Jika kepala ular menabrak border bawah frame
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		//Ular berhenti
		if(!running) {
			timer.stop();
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
	/*******Kontrol ular*******/


	public class MyKeyAdapter extends KeyAdapter{ //untuk mendengan inputan dari keyboard
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT: 			//VK_LEFT adalah tombol arrow key  left <--
				if(direction != 'R') { 		//jika arah tidak sama dengan arah R, maka arah berubah ke L
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:			//VK_RIGHT adalah tombol arrow key right -->		
				if(direction != 'L') {		//jika arah tidak sama dengan arah L, maka arah berubah ke R
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:			//VK_UP adalah tombol arrow key up
				if(direction != 'D') {		//jika arah tidak sama dengan arah D, maka arah berubah ke U
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:			//VK_DOWN adalah tombol arrow key down
				if(direction != 'U') {		//jika arah tidak sama dengan arah U, maka arah berubah ke D
					direction = 'D';
				}
				break;
			}
		}
	}
}
