package dynamic_beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
  
  private Image sreenImage; //������۸��� ���� 
  private Graphics screenGraphic; 
  
  //��ư ��ü ����
  private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));	 //�������ư 
  private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));	 //�������ư 

  private JButton exitButton = new JButton(exitButtonBasicImage);	 //�����ڽ���ư 

  //ùȭ�� ��ư�� (����, ���� )��ü ����
  private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));	 //���۹�ư 
  private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));	 //���۹�ư-ȣ�� 
  
  private ImageIcon endButtonBasicImage = new ImageIcon(Main.class.getResource("../images/endButtonBasic.png"));	 //�����ư 
  private ImageIcon endButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/endButtonEntered.png"));	 //�����ư-ȣ�� 
 
  private JButton startButton = new JButton(startButtonBasicImage);	 //ȭ����۹�ư 
  private JButton endButton = new JButton(endButtonBasicImage);	 //ȭ�������ư 
  
  //���� ������ ��ư ��ü ���� 
  private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));	 //���ʹ�ư 
  private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));	 //���ʹ�ư-ȣ�� 
  
  private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));	 //�����ʹ�ư 
  private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));	 //�����ʹ�ư-ȣ�� 
 
  private JButton leftButton = new JButton(leftButtonBasicImage);	 //���ʹ�ư 
  private JButton rightButton = new JButton(rightButtonBasicImage);	 //�����ʹ�ư 
  
  //easy , hard ��ư ��ü ���� 
  private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));	 //���ʹ�ư 
  private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));	 //���ʹ�ư-ȣ�� 
  
  private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));	 //�����ʹ�ư 
  private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));	 //�����ʹ�ư-ȣ�� 
 
  private JButton easyButton = new JButton(easyButtonBasicImage);	 //easy��ư 
  private JButton hardButton = new JButton(hardButtonBasicImage);	 //hard��ư 
  
  //back ��ư ��ü ���� 
  private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/back.png"));	 //�����ʹ�ư 
  private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backEntered.png"));	 //�����ʹ�ư-ȣ�� 
 
  private JButton backButton = new JButton(backButtonBasicImage);	 //easy��ư 
 

  
  //�� �����ȿ� �ʱ�ȭ ���ְڴٴ� ��� --> ���ȭ�� 
  private Image  background = new ImageIcon(Main.class.getResource("../images/intro_background.jpg")).getImage();
  
  private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
  private int mouseX,mouseY;
 
  private boolean isMainScreen = false; //ó���� ����ȭ���� �ƴϱ� ������ false
  private boolean isGameScreen = false; //����ȭ������ �Ѿ�Դ°� 
  
  ArrayList<Track> trackList = new ArrayList<Track>(); //arrayList ���׸� �̿� -- ������� ���� 
  
  //Ÿ��Ʋ �� ���� �̹��� ��������  
  
  private Image titleImage; 
  private Image  selectedImage; 
  //���� ���� ���� ����
  private Music selectedMusic; 
  //�ε�� ���� ���� ���� �� ��ü ���� 
  private Music introMusic = new Music("intro_music.mp3",true); // true ->> â ���� ������ ��� �ݺ� 
 
  private int nowSelected =0; //���� �� Ʈ�� ��ȣ 
  
  public static Game game;
  
  //������
  public DynamicBeat() {
	  
      //�� ����Ʈ ���� 
      trackList.add(new Track("tt.png","tt_title.png","black_background.jpg","tt.mp3","tt.mp3","TWICE - TT")); 
      trackList.add(new Track("loser.png","loser_title.png","black_background.jpg","loser.mp3","loser.mp3","ڷ������ - loser")); 
      trackList.add(new Track("hanabi.png","hanabi_title.png","black_background.jpg","hanabi.mp3","hanabi.mp3","ڷ������ - ��߾����")); 
     
	  setUndecorated(true); 
	  setTitle("Dynamic Beat") ;
	  setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); //������ ����
	  setResizable(false);
	  setLocationRelativeTo(null); //���߾ӿ� �߰� �ϱ� 
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  setVisible(true); //���ü� ����
	  setBackground(new Color(0,0,0,0));  
	  setLayout(null); //���̾ƿ� ���� 
	  
	  addKeyListener(new KeyListener()); // Ű ������ �۵� �Ǵ� �� 
	  introMusic.start(); //���� ��� 
      
       
	  //<---------------------- ������ ���� ��ư  --------------------------->
	  exitButton.setBounds(1145,0,30,30);
	  exitButton.setBorderPainted(false);
	  exitButton.setContentAreaFilled(false);
	  exitButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  exitButton.addMouseListener(new MouseAdapter() {
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			exitButton.setIcon(exitButtonEnteredImage);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			exitButton.setIcon(exitButtonBasicImage);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			  System.exit(0); //�ý��� ���� 
		  }
	  });
	 
	  add(exitButton); //��ư �߰� 
	  
	  //<---------------------- ��ŸƮ ��ư  --------------------------->
	  startButton.setBounds(40,250,400,100);
	  startButton.setBorderPainted(false);
	  startButton.setContentAreaFilled(false);
	  startButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  startButton.addMouseListener(new MouseAdapter() {
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  startButton.setIcon(startButtonEnteredImage);
			  startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  startButton.setIcon(startButtonBasicImage);
			  startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			//���ӽ��� �̺�Ʈ 
			  enterMain();        
		  }
	  });
	 
	  add(startButton); //��ư �߰� 
	  
	  
	  
	  //<---------------------- ���� ��ư  --------------------------->
	  endButton.setBounds(40,380,400,100);
	  endButton.setBorderPainted(false);
	  endButton.setContentAreaFilled(false);
	  endButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  endButton.addMouseListener(new MouseAdapter() {
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  endButton.setIcon(endButtonEnteredImage);
			  endButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  
		   
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  endButton.setIcon(endButtonBasicImage);
			  endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			  System.exit(0); //�ý��� ���� 
		  }
	  });
	 
	  add(endButton); //��ư �߰� 
	  
	  
	  //<---------------------- ���� ��ư  --------------------------->
	  leftButton.setVisible(false);
	  leftButton.setBounds(140,310,60,60);
	  leftButton.setBorderPainted(false);
	  leftButton.setContentAreaFilled(false);
	  leftButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  leftButton.addMouseListener(new MouseAdapter() {
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  leftButton.setIcon(leftButtonEnteredImage);
			  leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  leftButton.setIcon(leftButtonBasicImage);
			  leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			 //���ʹ�ư �̺�Ʈ 
			  selectLeft();
		  }
	  });
	 
	  add(leftButton); //��ư �߰� 
	  
	  
	  //<---------------------- ������ ��ư  --------------------------->
	  rightButton.setVisible(false);
	  rightButton.setBounds(1080,310,60,60);
	  rightButton.setBorderPainted(false);
	  rightButton.setContentAreaFilled(false);
	  rightButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  rightButton.addMouseListener(new MouseAdapter() { 
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  rightButton.setIcon(rightButtonEnteredImage);
			  rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  rightButton.setIcon(rightButtonBasicImage);
			  rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			 //�����ʹ�ư �̺�Ʈ
			  selectRight();
		  }
	  });
	 
	  add(rightButton); //��ư �߰� 
	  
	//<---------------------- easy ��ư  --------------------------->
	  easyButton.setVisible(false);
	  easyButton.setBounds(375,580,250,87);
	  easyButton.setBorderPainted(false);
	  easyButton.setContentAreaFilled(false);
	  easyButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  easyButton.addMouseListener(new MouseAdapter() { 
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  easyButton.setIcon(easyButtonEnteredImage);
			  easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  easyButton.setIcon(easyButtonBasicImage);
			  easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			 //���� ���̵� �̺�Ʈ ���� 
			  gameStart(nowSelected,"Easy");
		  }
	  });
	 
	  add(easyButton); //��ư �߰� 
	  
	//<---------------------- hard ��ư  --------------------------->
	  hardButton.setVisible(false);
	  hardButton.setBounds(655,580,250,87);
	  hardButton.setBorderPainted(false);
	  hardButton.setContentAreaFilled(false);
	  hardButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  hardButton.addMouseListener(new MouseAdapter() { 
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  hardButton.setIcon(hardButtonEnteredImage);
			  hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  hardButton.setIcon(hardButtonBasicImage);
			  hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			 //����� ���̵� �̺�Ʈ ���� 
			  gameStart(nowSelected,"Hard");
		  }
	  });
	 
	  add(hardButton); //��ư �߰� 
	  
	//<---------------------- back ( �ڷΰ��� )��ư  --------------------------->
	  backButton.setVisible(false);
	  backButton.setBounds(20,50,60,60);
	  backButton.setBorderPainted(false);
	  backButton.setContentAreaFilled(false);
	  backButton.setFocusPainted(false);
	  
	  //������ ��ư ���콺 �̺�Ʈ ���� 
	  backButton.addMouseListener(new MouseAdapter() { 
		  //�������̵� - ���콺�� ��ư�� �ö� ���� ��� 
		  public void mouseEntered(MouseEvent e){
			  backButton.setIcon(hardButtonEnteredImage);
			  backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Ŀ�� �ո������ �ٲ�� �� 
		  }
		  //�������̵� - ���콺�� ��ư�� ���� ���� ��� 
		  public void mouseExited(MouseEvent e){
			  backButton.setIcon(hardButtonBasicImage);
			  backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //�������̵� - ���콺�� ��ư�� Ŭ�� �� ��� 
		  public void mousePressed(MouseEvent e){
			 //����ȭ������ ���ư��� �̺�Ʈ 
			  backMain();
		  }
	  });
	 
	  add(backButton); //��ư �߰� 
	  
	  
	  menuBar.setBounds(0,0,1200,30); //��ġ ���ϱ� 
	  menuBar.addMouseListener(new MouseAdapter() {
		  //�������̵�
		  public void mousePressed(MouseEvent e){
			  mouseX = e.getX(); //���콺 x ��ǥ
			  mouseY = e.getY(); //���콺 y ��ǥ
		  }
	  });
	  menuBar.addMouseMotionListener(new MouseMotionAdapter() {
		  //�������̵�
		  public void mouseDragged(MouseEvent e) {
			  int x = e.getXOnScreen();
			  int y = e.getYOnScreen();
			  
			  setLocation(x - mouseX, y - mouseY);
		  }
	  });
	  add(menuBar); //�޴��� �߰� 
	    
  }
  
  //�⺻ ���� �޼���  
  public void paint(Graphics g) {
	  sreenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
	  screenGraphic = sreenImage.getGraphics();
	  screenDraw((Graphics2D)screenGraphic);
	  g.drawImage(sreenImage, 0, 0, null);
  }
  
  // �̹��� �׷��ִ� �޼��� 
  public void screenDraw(Graphics2D g){
	  g.drawImage(background, 0, 0, null); //��׶���� �ܼ�ȭ �� �� 
	  if(isMainScreen) {
		  g.drawImage(selectedImage, 340, 100, null); //���� �̹��� ��� -- ���� Ŀ�� ���� 
		  g.drawImage(titleImage, 340, 70, null); //���� �̹��� ��� -- Ÿ��Ʋ��, ���� �� 
	  }
	  if(isGameScreen) {
          game.screenDraw(g); //Ŭ����ȭ �ؼ� ����  
	  }
	  paintComponents(g); // �̹����� �׷��ִ� ��  --�Ŵ��ٴ� �׻� �����ϴ� �����̹����� ������ ����Ʈ ������Ʈ �̿��ϱ� 
	  try {
		  Thread.sleep(5);
	  }
	  catch(Exception e) {
             e.printStackTrace();		  
	  }
	  this.repaint(); // JFrame ��ӹ޾� �׸� �׷��ִ� �� -- ��ü �̹����� �� �������� �׷��ִ� �� 
  }
  
  //Ʈ�� ���� 
  public void selectTrack(int nowSelected) {
	  if(selectedMusic != null) 
		  selectedMusic.close();
	  
	  titleImage =  new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleImage())).getImage();	
	  selectedImage =  new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getStartImage())).getImage();	
      selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);	
      selectedMusic.start();
	
  }
  
  //���� ��ư ������ ��� �̺�Ʈ ó�� 
  public void selectLeft() {
	  if(nowSelected ==0) 
		  nowSelected = trackList.size() -1;
	  else 
		  nowSelected--;
	  selectTrack(nowSelected);	  
  }
  
  //������ ��ư ������ ��� �̺�Ʈ ó�� 
  public void selectRight() {
	  if(nowSelected ==trackList.size()-1) 
		  nowSelected=0;
	  else 
		  nowSelected++;
	  selectTrack(nowSelected);	  
  }
  
  //<------------------------ ���� ���� �޼��� ------------------------> 
  public void gameStart(int nowSelected, String difficulty) {
	  if(selectedMusic != null) {
		 selectedMusic.close();
		 isMainScreen  = false; 
		 leftButton.setVisible(false);
		 rightButton.setVisible(false);
		 easyButton.setVisible(false);
		 hardButton.setVisible(false);
		 background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage())).getImage();
		 backButton.setVisible(true);
		 isGameScreen = true;
		
		 game = new Game(trackList.get(nowSelected).getTitleName(),difficulty,trackList.get(nowSelected).getGameMusic()); //���̵� 
	     game.start();
	     setFocusable(true);
	  }
  }
  
  //back��ư�� ���� �� �ڷε��ư��� �޼��� 
  public void backMain() {
	  isMainScreen  = true; 
	  leftButton.setVisible(true);
	  rightButton.setVisible(true);
	  easyButton.setVisible(true);
	  hardButton.setVisible(true);
	  background = new ImageIcon(Main.class.getResource("../images/main_background.jpg")).getImage();
	  backButton.setVisible(false);
	  selectTrack(nowSelected);
	  isGameScreen = false;
	  game.close(); // �� ���ӿ� �ش�Ǵ� �뷡 ����  
	  
  }
  
  // ���� ȸ�� ���� �޼��� 
  public void enterMain() {
	  background = new ImageIcon(Main.class.getResource("../images/main_background.jpg")).getImage();
	  isMainScreen = true;
	  
	  startButton.setVisible(false);
	  endButton.setVisible(false);
	  leftButton.setVisible(true);
	  rightButton.setVisible(true);
	  easyButton.setVisible(true);
	  hardButton.setVisible(true);
	    
	  selectTrack(0); //ù��° ���� ����Ƕ� 
	  introMusic.close();  // ��Ʈ�� ���� ����
  }
}
