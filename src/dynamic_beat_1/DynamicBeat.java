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
  
  private Image sreenImage; //더블버퍼링을 위해 
  private Graphics screenGraphic; 
  
  //버튼 객체 생성
  private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));	 //나가기버튼 
  private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));	 //나가기버튼 

  private JButton exitButton = new JButton(exitButtonBasicImage);	 //엑스박스버튼 

  //첫화면 버튼들 (시작, 종료 )객체 생성
  private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));	 //시작버튼 
  private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));	 //시작버튼-호버 
  
  private ImageIcon endButtonBasicImage = new ImageIcon(Main.class.getResource("../images/endButtonBasic.png"));	 //종료버튼 
  private ImageIcon endButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/endButtonEntered.png"));	 //종료버튼-호버 
 
  private JButton startButton = new JButton(startButtonBasicImage);	 //화면시작버튼 
  private JButton endButton = new JButton(endButtonBasicImage);	 //화면종료버튼 
  
  //왼쪽 오른쪽 버튼 객체 생성 
  private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));	 //왼쪽버튼 
  private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));	 //왼쪽버튼-호버 
  
  private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));	 //오른쪽버튼 
  private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));	 //오른쪽버튼-호버 
 
  private JButton leftButton = new JButton(leftButtonBasicImage);	 //왼쪽버튼 
  private JButton rightButton = new JButton(rightButtonBasicImage);	 //오른쪽버튼 
  
  //easy , hard 버튼 객체 생성 
  private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));	 //왼쪽버튼 
  private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));	 //왼쪽버튼-호버 
  
  private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));	 //오른쪽버튼 
  private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));	 //오른쪽버튼-호버 
 
  private JButton easyButton = new JButton(easyButtonBasicImage);	 //easy버튼 
  private JButton hardButton = new JButton(hardButtonBasicImage);	 //hard버튼 
  
  //back 버튼 객체 생성 
  private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/back.png"));	 //오른쪽버튼 
  private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backEntered.png"));	 //오른쪽버튼-호버 
 
  private JButton backButton = new JButton(backButtonBasicImage);	 //easy버튼 
 

  
  //이 변수안에 초기화 해주겠다는 약속 --> 배경화면 
  private Image  background = new ImageIcon(Main.class.getResource("../images/intro_background.jpg")).getImage();
  
  private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
  private int mouseX,mouseY;
 
  private boolean isMainScreen = false; //처음은 메인화면이 아니기 때문에 false
  private boolean isGameScreen = false; //게임화면으로 넘어왔는가 
  
  ArrayList<Track> trackList = new ArrayList<Track>(); //arrayList 지네릭 이용 -- 순서대로 쌓임 
  
  //타이틀 및 선택 이미지 변수선언  
  
  private Image titleImage; 
  private Image  selectedImage; 
  //선택 음악 변수 선언
  private Music selectedMusic; 
  //인드로 음악 변수 선언 및 객체 생성 
  private Music introMusic = new Music("intro_music.mp3",true); // true ->> 창 끄기 전까지 계속 반복 
 
  private int nowSelected =0; //선택 된 트랙 번호 
  
  public static Game game;
  
  //생성자
  public DynamicBeat() {
	  
      //곡 리스트 관리 
      trackList.add(new Track("tt.png","tt_title.png","black_background.jpg","tt.mp3","tt.mp3","TWICE - TT")); 
      trackList.add(new Track("loser.png","loser_title.png","black_background.jpg","loser.mp3","loser.mp3","米津玄師 - loser")); 
      trackList.add(new Track("hanabi.png","hanabi_title.png","black_background.jpg","hanabi.mp3","hanabi.mp3","米津玄師 - 打上花火")); 
     
	  setUndecorated(true); 
	  setTitle("Dynamic Beat") ;
	  setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); //사이즈 설정
	  setResizable(false);
	  setLocationRelativeTo(null); //정중앙에 뜨게 하기 
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  setVisible(true); //가시성 있음
	  setBackground(new Color(0,0,0,0));  
	  setLayout(null); //레이아웃 설정 
	  
	  addKeyListener(new KeyListener()); // 키 누를때 작동 되는 것 
	  introMusic.start(); //음악 재생 
      
       
	  //<---------------------- 나가기 엑스 버튼  --------------------------->
	  exitButton.setBounds(1145,0,30,30);
	  exitButton.setBorderPainted(false);
	  exitButton.setContentAreaFilled(false);
	  exitButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  exitButton.addMouseListener(new MouseAdapter() {
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			exitButton.setIcon(exitButtonEnteredImage);
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			exitButton.setIcon(exitButtonBasicImage);
			exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			  System.exit(0); //시스템 종료 
		  }
	  });
	 
	  add(exitButton); //버튼 추가 
	  
	  //<---------------------- 스타트 버튼  --------------------------->
	  startButton.setBounds(40,250,400,100);
	  startButton.setBorderPainted(false);
	  startButton.setContentAreaFilled(false);
	  startButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  startButton.addMouseListener(new MouseAdapter() {
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  startButton.setIcon(startButtonEnteredImage);
			  startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  startButton.setIcon(startButtonBasicImage);
			  startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			//게임시작 이벤트 
			  enterMain();        
		  }
	  });
	 
	  add(startButton); //버튼 추가 
	  
	  
	  
	  //<---------------------- 종료 버튼  --------------------------->
	  endButton.setBounds(40,380,400,100);
	  endButton.setBorderPainted(false);
	  endButton.setContentAreaFilled(false);
	  endButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  endButton.addMouseListener(new MouseAdapter() {
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  endButton.setIcon(endButtonEnteredImage);
			  endButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  
		   
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  endButton.setIcon(endButtonBasicImage);
			  endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			  System.exit(0); //시스템 종료 
		  }
	  });
	 
	  add(endButton); //버튼 추가 
	  
	  
	  //<---------------------- 왼쪽 버튼  --------------------------->
	  leftButton.setVisible(false);
	  leftButton.setBounds(140,310,60,60);
	  leftButton.setBorderPainted(false);
	  leftButton.setContentAreaFilled(false);
	  leftButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  leftButton.addMouseListener(new MouseAdapter() {
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  leftButton.setIcon(leftButtonEnteredImage);
			  leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  leftButton.setIcon(leftButtonBasicImage);
			  leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			 //왼쪽버튼 이벤트 
			  selectLeft();
		  }
	  });
	 
	  add(leftButton); //버튼 추가 
	  
	  
	  //<---------------------- 오른쪽 버튼  --------------------------->
	  rightButton.setVisible(false);
	  rightButton.setBounds(1080,310,60,60);
	  rightButton.setBorderPainted(false);
	  rightButton.setContentAreaFilled(false);
	  rightButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  rightButton.addMouseListener(new MouseAdapter() { 
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  rightButton.setIcon(rightButtonEnteredImage);
			  rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  rightButton.setIcon(rightButtonBasicImage);
			  rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			 //오른쪽버튼 이벤트
			  selectRight();
		  }
	  });
	 
	  add(rightButton); //버튼 추가 
	  
	//<---------------------- easy 버튼  --------------------------->
	  easyButton.setVisible(false);
	  easyButton.setBounds(375,580,250,87);
	  easyButton.setBorderPainted(false);
	  easyButton.setContentAreaFilled(false);
	  easyButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  easyButton.addMouseListener(new MouseAdapter() { 
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  easyButton.setIcon(easyButtonEnteredImage);
			  easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  easyButton.setIcon(easyButtonBasicImage);
			  easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			 //쉬운 난이도 이벤트 설정 
			  gameStart(nowSelected,"Easy");
		  }
	  });
	 
	  add(easyButton); //버튼 추가 
	  
	//<---------------------- hard 버튼  --------------------------->
	  hardButton.setVisible(false);
	  hardButton.setBounds(655,580,250,87);
	  hardButton.setBorderPainted(false);
	  hardButton.setContentAreaFilled(false);
	  hardButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  hardButton.addMouseListener(new MouseAdapter() { 
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  hardButton.setIcon(hardButtonEnteredImage);
			  hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  hardButton.setIcon(hardButtonBasicImage);
			  hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			 //어려운 난이도 이벤트 설정 
			  gameStart(nowSelected,"Hard");
		  }
	  });
	 
	  add(hardButton); //버튼 추가 
	  
	//<---------------------- back ( 뒤로가기 )버튼  --------------------------->
	  backButton.setVisible(false);
	  backButton.setBounds(20,50,60,60);
	  backButton.setBorderPainted(false);
	  backButton.setContentAreaFilled(false);
	  backButton.setFocusPainted(false);
	  
	  //나가기 버튼 마우스 이벤트 설정 
	  backButton.addMouseListener(new MouseAdapter() { 
		  //오버라이딩 - 마우스가 버튼에 올라가 있을 경우 
		  public void mouseEntered(MouseEvent e){
			  backButton.setIcon(hardButtonEnteredImage);
			  backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //커서 손모양으로 바뀌는 거 
		  }
		  //오버라이딩 - 마우스가 버튼에 나가 있을 경우 
		  public void mouseExited(MouseEvent e){
			  backButton.setIcon(hardButtonBasicImage);
			  backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		  }
		  //오버라이딩 - 마우스가 버튼을 클릭 할 경우 
		  public void mousePressed(MouseEvent e){
			 //메인화면으로 돌아가는 이벤트 
			  backMain();
		  }
	  });
	 
	  add(backButton); //버튼 추가 
	  
	  
	  menuBar.setBounds(0,0,1200,30); //위치 정하기 
	  menuBar.addMouseListener(new MouseAdapter() {
		  //오버라이딩
		  public void mousePressed(MouseEvent e){
			  mouseX = e.getX(); //마우스 x 좌표
			  mouseY = e.getY(); //마우스 y 좌표
		  }
	  });
	  menuBar.addMouseMotionListener(new MouseMotionAdapter() {
		  //오버라이딩
		  public void mouseDragged(MouseEvent e) {
			  int x = e.getXOnScreen();
			  int y = e.getYOnScreen();
			  
			  setLocation(x - mouseX, y - mouseY);
		  }
	  });
	  add(menuBar); //메뉴바 추가 
	    
  }
  
  //기본 설정 메서드  
  public void paint(Graphics g) {
	  sreenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
	  screenGraphic = sreenImage.getGraphics();
	  screenDraw((Graphics2D)screenGraphic);
	  g.drawImage(sreenImage, 0, 0, null);
  }
  
  // 이미지 그려주는 메서드 
  public void screenDraw(Graphics2D g){
	  g.drawImage(background, 0, 0, null); //백그라운드는 단순화 한 것 
	  if(isMainScreen) {
		  g.drawImage(selectedImage, 340, 100, null); //선택 이미지 경우 -- 가수 커버 사진 
		  g.drawImage(titleImage, 340, 70, null); //선택 이미지 경우 -- 타이틀명, 가수 명 
	  }
	  if(isGameScreen) {
          game.screenDraw(g); //클래스화 해서 관리  
	  }
	  paintComponents(g); // 이미지를 그려주는 것  --매뉴바는 항상 존재하는 고정이미지기 때문에 패인트 컴포넌트 이용하기 
	  try {
		  Thread.sleep(5);
	  }
	  catch(Exception e) {
             e.printStackTrace();		  
	  }
	  this.repaint(); // JFrame 상속받아 그림 그려주는 것 -- 전체 이미지를 매 순간마다 그려주는 것 
  }
  
  //트랙 설정 
  public void selectTrack(int nowSelected) {
	  if(selectedMusic != null) 
		  selectedMusic.close();
	  
	  titleImage =  new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getTitleImage())).getImage();	
	  selectedImage =  new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getStartImage())).getImage();	
      selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);	
      selectedMusic.start();
	
  }
  
  //왼쪽 버튼 눌렀을 경우 이벤트 처리 
  public void selectLeft() {
	  if(nowSelected ==0) 
		  nowSelected = trackList.size() -1;
	  else 
		  nowSelected--;
	  selectTrack(nowSelected);	  
  }
  
  //오른쪽 버튼 눌렀을 경우 이벤트 처리 
  public void selectRight() {
	  if(nowSelected ==trackList.size()-1) 
		  nowSelected=0;
	  else 
		  nowSelected++;
	  selectTrack(nowSelected);	  
  }
  
  //<------------------------ 게임 시작 메서드 ------------------------> 
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
		
		 game = new Game(trackList.get(nowSelected).getTitleName(),difficulty,trackList.get(nowSelected).getGameMusic()); //난이도 
	     game.start();
	     setFocusable(true);
	  }
  }
  
  //back버튼을 누를 시 뒤로돌아가기 메서드 
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
	  game.close(); // 한 게임에 해당되는 노래 종료  
	  
  }
  
  // 시작 회면 들어가는 메서드 
  public void enterMain() {
	  background = new ImageIcon(Main.class.getResource("../images/main_background.jpg")).getImage();
	  isMainScreen = true;
	  
	  startButton.setVisible(false);
	  endButton.setVisible(false);
	  leftButton.setVisible(true);
	  rightButton.setVisible(true);
	  easyButton.setVisible(true);
	  hardButton.setVisible(true);
	    
	  selectTrack(0); //첫번째 곡이 실행되라 
	  introMusic.close();  // 인트로 음악 종료
  }
}
