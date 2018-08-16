package dynamic_beat_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	  
	//��Ʈ �̹��� ���� 
	  private Image  gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	  private Image  judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	  private Image  noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	  
	  // �� Ű�� �ش��ϴ� ��Ʈ �̹��� ��üȭ 
	  private Image  noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	  private Image  noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	  private Image  blueFlareImage;
	  private Image  judgeImage;
	  
	  //Ű�е� ��ŭ �̹��� ��üȭ - basic
	  private Image  keyPadSImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadDImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadFImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadSpace1Image= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadSpace2Image= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadJImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadKImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	  private Image  keyPadLImage= new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		
	  private String titleName;
	  private String difficulty; 
	  private String musicTitle;
	  private Music  gameMusic; 
	  
	  ArrayList<Note> noteList = new ArrayList<Note>();
	  
	  //������ 
	  public Game(String titleName, String difficulty , String musicTitle) {
		  this.titleName  = titleName;
		  this.difficulty = difficulty;
		  this.musicTitle = musicTitle;
		  gameMusic       = new Music(this.musicTitle,false);
		  
	  }
	  
      public void screenDraw(Graphics2D g) {
	   
	      g.drawImage(noteRouteSImage, 228, 30, null); //��Ʈ��
		  g.drawImage(noteRouteDImage, 332, 30, null); //��Ʈ��
		  g.drawImage(noteRouteFImage, 436, 30, null); //��Ʈ��
		  g.drawImage(noteRouteSpace1Image, 540, 30, null); //��Ʈ��
		  g.drawImage(noteRouteSpace2Image, 640, 30, null); //��Ʈ��
		  g.drawImage(noteRouteJImage, 744, 30, null); //��Ʈ��
		  g.drawImage(noteRouteKImage, 848, 30, null); //��Ʈ��
		  g.drawImage(noteRouteLImage, 952, 30, null); //��Ʈ��
		  
		  g.drawImage(noteRouteLineImage, 224, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 328, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 432, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 536, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 740, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 844, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 948, 30, null); //��Ʈ����   
		  g.drawImage(noteRouteLineImage, 1052, 30, null); //��Ʈ����   
		  
	      g.drawImage(gameInfoImage, 0, 660, null); //���� ��ũ�� ȭ��   
		  g.drawImage(judgementLineImage, 0, 580, null); //���� ��ũ�� ȭ��   
			  
			
   		 //�������鼭 ��Ʈ Ŭ���� ���� 
		  for(int i = 0; i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(note.getY()>620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
			}
			if(!note.isProcessed()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		  }
		   
		  g.setColor(Color.white);
		  g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		  g.setFont(new Font("Arial",Font.BOLD,30));
		  g.drawString(titleName, 20, 702); //�뷡 ����  
		  g.drawString(difficulty,1190,702); //���̵� 
		  
		  g.setFont(new Font("Arial",Font.PLAIN,26));
		  g.setColor(Color.black);
		  g.drawString("S",270,609); 
		  g.drawString("D",374,609); 
		  g.drawString("F",478,609); 
		  g.drawString("Space Bar",580,609); 
		  g.drawString("J",784,609); 
		  g.drawString("K",889,609); 
		  g.drawString("L",993,609); 
		  g.setColor(Color.LIGHT_GRAY);
		  g.setFont(new Font("Elephant",Font.BOLD,30));
		  g.drawString("000000",565,702); 
		  g.drawImage(blueFlareImage, 320, 430, null);
		  g.drawImage(judgeImage, 460, 420, null);
		  g.drawImage(keyPadSImage, 228, 580, null);
		  g.drawImage(keyPadDImage, 332, 580, null);
		  g.drawImage(keyPadFImage, 436, 580, null);
		  g.drawImage(keyPadSpace1Image, 540, 580, null);
		  g.drawImage(keyPadSpace2Image, 640, 580, null);
		  g.drawImage(keyPadJImage, 744, 580, null);
		  g.drawImage(keyPadKImage, 848, 580, null);
		  g.drawImage(keyPadLImage, 952, 580, null);
		  
		  
		 	 
   }
   //<------------ sŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressS() {
	   judge("S");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	   new Music("soundEffect.mp3",false).start();   
   }
   //sŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseS() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
   
   }
   
   //<------------ dŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressD() {
	   judge("D");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();

	   new Music("soundEffect.mp3",false).start();    
   }
   //dŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseD() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	      
   }
   
   //<------------ FŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressF() {
	   judge("F");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	   new Music("soundEffect.mp3",false).start();    
   }
   //fŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseF() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	      
   }
   
   //<------------ spaceŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressSpace() {
	   judge("Space");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	  

	   keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	   keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
	   new Music("soundEffect2.mp3",false).start();     
   }
   //sŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseSpace() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   
	   keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	   keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	    
   }
   
   //<------------ jŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressJ() {
	   
	   judge("J");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		  
	   new Music("soundEffect.mp3",false).start();   
   }
   //sŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseJ() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		    
   }
   
   //<------------ KŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressK() {
	   judge("K");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		
	   new Music("soundEffect.mp3",false).start();    
   }
   //KŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseK() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		   
   }
   
   //<------------ lŰ�� ���� ��� ó���Ǵ� �޼��� -----------------> 
   public void pressL() {
	   judge("L");
	   //��� ���� �Ķ������� �ٲ� 
	   noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	   keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		
	   new Music("soundEffect.mp3",false).start();     
   }
   //sŰ�� ���� ���� ������ �� ó���Ǵ� �޼��� 
   public void releaseL() {
	   //��� ���� ȸ������ �ٲ� 
	   noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	   keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		   
   }
 
   //������ �ȿ����� run �޼��� �ȿ��� �����
   public void run() {
		dropNotes(this.titleName);
   }
   
   public void close() {
	   gameMusic.close();
	   this.isInterrupted(); //������ ���� 
   }
   
   //������ ��Ʈ���� ������ �� ����Ǵ� �޼���
   public void dropNotes(String titleName) {
	   
	   Beat[] beats = null;
	   if(titleName.equals("TWICE - TT")&&difficulty.equals("Easy")) {
		   int startTime = 4460- Main.REACH_TIME *1000;
		   int gap = 125;
		   // ��Ʈ ��ü ���� �� ��Ʈ ��� 
		   beats = new Beat[] {			
				new Beat(startTime,"S") ,
				new Beat(startTime+gap * 2 ,"D"),
				new Beat(startTime+gap * 4 ,"S"),
				new Beat(startTime+gap * 6 ,"D"),
				new Beat(startTime+gap * 8 ,"S"),
				new Beat(startTime+gap * 10,"D"),
				new Beat(startTime+gap * 12,"J"),
				new Beat(startTime+gap * 14,"K"),
				new Beat(startTime+gap * 16,"J"),
				new Beat(startTime+gap * 18,"K"),
				new Beat(startTime+gap * 20,"J"),
				new Beat(startTime+gap * 22,"K"),
				new Beat(startTime+gap * 24,"L"),
				new Beat(startTime+gap * 26,"D"),
				new Beat(startTime+gap * 28,"S"),	
				new Beat(startTime+gap * 30,"L"),
				new Beat(startTime+gap * 32,"K"),
				new Beat(startTime+gap * 36,"J"), 
				new Beat(startTime+gap * 38,"S"),
				new Beat(startTime+gap * 40,"D"),	
				new Beat(startTime+gap * 42,"S"),
				new Beat(startTime+gap * 44,"K"),
				new Beat(startTime+gap * 46,"F"), 
				new Beat(startTime+gap * 48,"F"),
				new Beat(startTime+gap * 49,"K"),	
				new Beat(startTime+gap * 50,"S"),
				new Beat(startTime+gap * 52,"F"),
				new Beat(startTime+gap * 52,"Space"), 
				new Beat(startTime+gap * 52,"j"), 
				new Beat(startTime+gap * 54,"S"),
				new Beat(startTime+gap * 56,"D"),	
				new Beat(startTime+gap * 58,"S"),
				new Beat(startTime+gap * 60,"K"),
				new Beat(startTime+gap * 62,"F"), 
				new Beat(startTime+gap * 64,"F"),
				new Beat(startTime+gap * 66,"K"),	
				new Beat(startTime+gap * 68,"S"),
				new Beat(startTime+gap * 70,"F"),
				new Beat(startTime+gap * 72,"Space"), 
				new Beat(startTime+gap * 74,"j"), 
				new Beat(startTime+gap * 76,"D"),
				new Beat(startTime+gap * 78,"J"),
				new Beat(startTime+gap * 80,"K"),
				new Beat(startTime+gap * 82,"J"),
				new Beat(startTime+gap * 84,"K"),
				new Beat(startTime+gap * 86,"J"),
				new Beat(startTime+gap * 88,"K"),
				new Beat(startTime+gap * 90,"L"),
				new Beat(startTime+gap * 92,"D"),
				new Beat(startTime+gap * 94,"S"),	
				new Beat(startTime+gap * 96,"L"),
				new Beat(startTime+gap * 98,"K"),
				new Beat(startTime+gap * 100,"S"),
				new Beat(startTime+gap * 102,"D"),	
				new Beat(startTime+gap * 104,"S"),
				new Beat(startTime+gap * 106,"K"),
				new Beat(startTime+gap * 108,"F"), 
				new Beat(startTime+gap * 110,"F"),
				new Beat(startTime+gap * 112,"K"),	
				new Beat(startTime+gap * 114,"S"),
				new Beat(startTime+gap * 116,"F"),
				new Beat(startTime+gap * 116,"Space"), 
				new Beat(startTime+gap * 116,"j"), 
				new Beat(startTime+gap * 118,"j"), 
				new Beat(startTime+gap * 120,"D"),
				new Beat(startTime+gap * 122,"J"),
				new Beat(startTime+gap * 124,"K"),
				new Beat(startTime+gap * 126,"J"),
				new Beat(startTime+gap * 128,"K"),
				new Beat(startTime+gap * 130,"J"),
				new Beat(startTime+gap * 132,"K"),
				new Beat(startTime+gap * 134,"L"),
				new Beat(startTime+gap * 136,"D"),
				new Beat(startTime+gap * 138,"S"),	
				new Beat(startTime+gap * 140,"L"),
				new Beat(startTime+gap * 142,"K"),
				new Beat(startTime+gap * 144,"S"),
				new Beat(startTime+gap * 146,"D"),	
				new Beat(startTime+gap * 148,"S"),
				new Beat(startTime+gap * 150,"K"),
				new Beat(startTime+gap * 152,"F"), 
				new Beat(startTime+gap * 154,"F"),
				new Beat(startTime+gap * 156,"K"),	
				new Beat(startTime+gap * 158,"S"),
				new Beat(startTime+gap * 160,"F"),
				new Beat(startTime+gap * 162,"Space"), 
				new Beat(startTime+gap * 164,"j"), 
				new Beat(startTime+gap * 166,"j"), 
				new Beat(startTime+gap * 168,"S"),
				new Beat(startTime+gap * 170,"D"),	
				new Beat(startTime+gap * 172,"S"),
				new Beat(startTime+gap * 174,"K"),
				new Beat(startTime+gap * 176,"F"), 
				new Beat(startTime+gap * 178,"F"),
				new Beat(startTime+gap * 180,"K"),	
				new Beat(startTime+gap * 182,"S"),
				new Beat(startTime+gap * 184,"F"),
				new Beat(startTime+gap * 186,"Space"), 
				new Beat(startTime+gap * 188,"j"), 
				new Beat(startTime+gap * 190,"D"),
		   };
				 
	   }
	   else if(titleName.equals("TWICE - TT")&&difficulty.equals("Hard")) {
		   int startTime = 4460- Main.REACH_TIME *1000;
		   int gap = 125;
		   // ��Ʈ ��ü ���� �� ��Ʈ ��� 
		   beats = new Beat[] {			
				new Beat(startTime,"S") ,
				new Beat(startTime+gap * 2 ,"D"),
				new Beat(startTime+gap * 4 ,"S"),
				new Beat(startTime+gap * 6 ,"D"),
				new Beat(startTime+gap * 8 ,"S"),
				new Beat(startTime+gap * 10,"D"),
				new Beat(startTime+gap * 12,"J"),
				new Beat(startTime+gap * 14,"K"),
				new Beat(startTime+gap * 16,"J"),
				new Beat(startTime+gap * 18,"K"),
				new Beat(startTime+gap * 20,"J"),
				new Beat(startTime+gap * 22,"K"),
				new Beat(startTime+gap * 24,"L"),
				new Beat(startTime+gap * 26,"D"),
				new Beat(startTime+gap * 28,"S"),	
				new Beat(startTime+gap * 30,"L"),
				new Beat(startTime+gap * 32,"K"),
				new Beat(startTime+gap * 36,"J"), 
				new Beat(startTime+gap * 38,"S"),
				new Beat(startTime+gap * 40,"D"),	
				new Beat(startTime+gap * 42,"S"),
				new Beat(startTime+gap * 44,"K"),
				new Beat(startTime+gap * 46,"F"), 
				new Beat(startTime+gap * 48,"F"),
				new Beat(startTime+gap * 49,"K"),	
				new Beat(startTime+gap * 50,"S"),
				new Beat(startTime+gap * 52,"F"),
				new Beat(startTime+gap * 52,"Space"), 
				new Beat(startTime+gap * 52,"j"), 
				new Beat(startTime+gap * 54,"S"),
				new Beat(startTime+gap * 56,"D"),	
				new Beat(startTime+gap * 58,"S"),
				new Beat(startTime+gap * 60,"K"),
				new Beat(startTime+gap * 62,"F"), 
				new Beat(startTime+gap * 64,"F"),
				new Beat(startTime+gap * 66,"K"),	
				new Beat(startTime+gap * 68,"S"),
				new Beat(startTime+gap * 70,"F"),
				new Beat(startTime+gap * 72,"Space"), 
				new Beat(startTime+gap * 74,"j"), 
				new Beat(startTime+gap * 76,"D"),
				new Beat(startTime+gap * 78,"J"),
				new Beat(startTime+gap * 80,"K"),
				new Beat(startTime+gap * 82,"J"),
				new Beat(startTime+gap * 84,"K"),
				new Beat(startTime+gap * 86,"J"),
				new Beat(startTime+gap * 88,"K"),
				new Beat(startTime+gap * 90,"L"),
				new Beat(startTime+gap * 92,"D"),
				new Beat(startTime+gap * 94,"S"),	
				new Beat(startTime+gap * 96,"L"),
				new Beat(startTime+gap * 98,"K"),
				new Beat(startTime+gap * 100,"S"),
				new Beat(startTime+gap * 102,"D"),	
				new Beat(startTime+gap * 104,"S"),
				new Beat(startTime+gap * 106,"K"),
				new Beat(startTime+gap * 108,"F"), 
				new Beat(startTime+gap * 110,"F"),
				new Beat(startTime+gap * 112,"K"),	
				new Beat(startTime+gap * 114,"S"),
				new Beat(startTime+gap * 116,"F"),
				new Beat(startTime+gap * 116,"Space"), 
				new Beat(startTime+gap * 116,"j"), 
				new Beat(startTime+gap * 118,"j"), 
				new Beat(startTime+gap * 120,"D"),
				new Beat(startTime+gap * 122,"J"),
				new Beat(startTime+gap * 124,"K"),
				new Beat(startTime+gap * 126,"J"),
				new Beat(startTime+gap * 128,"K"),
				new Beat(startTime+gap * 130,"J"),
				new Beat(startTime+gap * 132,"K"),
				new Beat(startTime+gap * 134,"L"),
				new Beat(startTime+gap * 136,"D"),
				new Beat(startTime+gap * 138,"S"),	
				new Beat(startTime+gap * 140,"L"),
				new Beat(startTime+gap * 142,"K"),
				new Beat(startTime+gap * 144,"S"),
				new Beat(startTime+gap * 146,"D"),	
				new Beat(startTime+gap * 148,"S"),
				new Beat(startTime+gap * 150,"K"),
				new Beat(startTime+gap * 152,"F"), 
				new Beat(startTime+gap * 154,"F"),
				new Beat(startTime+gap * 156,"K"),	
				new Beat(startTime+gap * 158,"S"),
				new Beat(startTime+gap * 160,"F"),
				new Beat(startTime+gap * 162,"Space"), 
				new Beat(startTime+gap * 164,"j"), 
				new Beat(startTime+gap * 166,"j"), 
				new Beat(startTime+gap * 168,"S"),
				new Beat(startTime+gap * 170,"D"),	
				new Beat(startTime+gap * 172,"S"),
				new Beat(startTime+gap * 174,"K"),
				new Beat(startTime+gap * 176,"F"), 
				new Beat(startTime+gap * 178,"F"),
				new Beat(startTime+gap * 180,"K"),	
				new Beat(startTime+gap * 182,"S"),
				new Beat(startTime+gap * 184,"F"),
				new Beat(startTime+gap * 186,"Space"), 
				new Beat(startTime+gap * 188,"j"), 
				new Beat(startTime+gap * 190,"D"),
		   };
				 
	   }
	   else if(titleName.equals("ڷ������ - loser")&&difficulty.equals("Easy")) {
		   int startTime = 4460- Main.REACH_TIME *1000;
		   int gap = 125;
		   // ��Ʈ ��ü ���� �� ��Ʈ ��� 
		   beats = new Beat[] {			
				new Beat(startTime,"S") ,
				new Beat(startTime+gap * 2 ,"D"),
				new Beat(startTime+gap * 4 ,"S"),
				new Beat(startTime+gap * 6 ,"D"),
				new Beat(startTime+gap * 8 ,"S"),
				new Beat(startTime+gap * 10,"D"),
				new Beat(startTime+gap * 12,"J"),
				new Beat(startTime+gap * 14,"K"),
				new Beat(startTime+gap * 16,"J"),
				new Beat(startTime+gap * 18,"K"),
				new Beat(startTime+gap * 20,"J"),
				new Beat(startTime+gap * 22,"K"),
				new Beat(startTime+gap * 24,"L"),
				new Beat(startTime+gap * 26,"D"),
				new Beat(startTime+gap * 28,"S"),	
				new Beat(startTime+gap * 30,"L"),
				new Beat(startTime+gap * 32,"K"),
				new Beat(startTime+gap * 36,"J"), 
				new Beat(startTime+gap * 38,"S"),
				new Beat(startTime+gap * 40,"D"),	
				new Beat(startTime+gap * 42,"S"),
				new Beat(startTime+gap * 44,"K"),
				new Beat(startTime+gap * 46,"F"), 
				new Beat(startTime+gap * 48,"F"),
				new Beat(startTime+gap * 49,"K"),	
				new Beat(startTime+gap * 50,"S"),
				new Beat(startTime+gap * 52,"F"),
				new Beat(startTime+gap * 52,"Space"), 
				new Beat(startTime+gap * 52,"j"), 
				new Beat(startTime+gap * 54,"S"),
				new Beat(startTime+gap * 56,"D"),	
				new Beat(startTime+gap * 58,"S"),
				new Beat(startTime+gap * 60,"K"),
				new Beat(startTime+gap * 62,"F"), 
				new Beat(startTime+gap * 64,"F"),
				new Beat(startTime+gap * 66,"K"),	
				new Beat(startTime+gap * 68,"S"),
				new Beat(startTime+gap * 70,"F"),
				new Beat(startTime+gap * 72,"Space"), 
				new Beat(startTime+gap * 74,"j"), 
				new Beat(startTime+gap * 76,"D"),
				new Beat(startTime+gap * 78,"J"),
				new Beat(startTime+gap * 80,"K"),
				new Beat(startTime+gap * 82,"J"),
				new Beat(startTime+gap * 84,"K"),
				new Beat(startTime+gap * 86,"J"),
				new Beat(startTime+gap * 88,"K"),
				new Beat(startTime+gap * 90,"L"),
				new Beat(startTime+gap * 92,"D"),
				new Beat(startTime+gap * 94,"S"),	
				new Beat(startTime+gap * 96,"L"),
				new Beat(startTime+gap * 98,"K"),
				new Beat(startTime+gap * 100,"S"),
				new Beat(startTime+gap * 102,"D"),	
				new Beat(startTime+gap * 104,"S"),
				new Beat(startTime+gap * 106,"K"),
				new Beat(startTime+gap * 108,"F"), 
				new Beat(startTime+gap * 110,"F"),
				new Beat(startTime+gap * 112,"K"),	
				new Beat(startTime+gap * 114,"S"),
				new Beat(startTime+gap * 116,"F"),
				new Beat(startTime+gap * 116,"Space"), 
				new Beat(startTime+gap * 116,"j"), 
				new Beat(startTime+gap * 118,"j"), 
				new Beat(startTime+gap * 120,"D"),
				new Beat(startTime+gap * 122,"J"),
				new Beat(startTime+gap * 124,"K"),
				new Beat(startTime+gap * 126,"J"),
				new Beat(startTime+gap * 128,"K"),
				new Beat(startTime+gap * 130,"J"),
				new Beat(startTime+gap * 132,"K"),
				new Beat(startTime+gap * 134,"L"),
				new Beat(startTime+gap * 136,"D"),
				new Beat(startTime+gap * 138,"S"),	
				new Beat(startTime+gap * 140,"L"),
				new Beat(startTime+gap * 142,"K"),
				new Beat(startTime+gap * 144,"S"),
				new Beat(startTime+gap * 146,"D"),	
				new Beat(startTime+gap * 148,"S"),
				new Beat(startTime+gap * 150,"K"),
				new Beat(startTime+gap * 152,"F"), 
				new Beat(startTime+gap * 154,"F"),
				new Beat(startTime+gap * 156,"K"),	
				new Beat(startTime+gap * 158,"S"),
				new Beat(startTime+gap * 160,"F"),
				new Beat(startTime+gap * 162,"Space"), 
				new Beat(startTime+gap * 164,"j"), 
				new Beat(startTime+gap * 166,"j"), 
				new Beat(startTime+gap * 168,"S"),
				new Beat(startTime+gap * 170,"D"),	
				new Beat(startTime+gap * 172,"S"),
				new Beat(startTime+gap * 174,"K"),
				new Beat(startTime+gap * 176,"F"), 
				new Beat(startTime+gap * 178,"F"),
				new Beat(startTime+gap * 180,"K"),	
				new Beat(startTime+gap * 182,"S"),
				new Beat(startTime+gap * 184,"F"),
				new Beat(startTime+gap * 186,"Space"), 
				new Beat(startTime+gap * 188,"j"), 
				new Beat(startTime+gap * 190,"D"),
		   };
	   }
	   else if(titleName.equals("ڷ������ - loser")&&difficulty.equals("Hard")) {
		   int startTime = 4460- Main.REACH_TIME *1000;
		   int gap = 125;
		   // ��Ʈ ��ü ���� �� ��Ʈ ��� 
		   beats = new Beat[] {			
				new Beat(startTime,"S") ,
				new Beat(startTime+gap * 2 ,"D"),
				new Beat(startTime+gap * 4 ,"S"),
				new Beat(startTime+gap * 6 ,"D"),
				new Beat(startTime+gap * 8 ,"S"),
				new Beat(startTime+gap * 10,"D"),
				new Beat(startTime+gap * 12,"J"),
				new Beat(startTime+gap * 14,"K"),
				new Beat(startTime+gap * 16,"J"),
				new Beat(startTime+gap * 18,"K"),
				new Beat(startTime+gap * 20,"J"),
				new Beat(startTime+gap * 22,"K"),
				new Beat(startTime+gap * 24,"L"),
				new Beat(startTime+gap * 26,"D"),
				new Beat(startTime+gap * 28,"S"),	
				new Beat(startTime+gap * 30,"L"),
				new Beat(startTime+gap * 32,"K"),
				new Beat(startTime+gap * 36,"J"), 
				new Beat(startTime+gap * 38,"S"),
				new Beat(startTime+gap * 40,"D"),	
				new Beat(startTime+gap * 42,"S"),
				new Beat(startTime+gap * 44,"K"),
				new Beat(startTime+gap * 46,"F"), 
				new Beat(startTime+gap * 48,"F"),
				new Beat(startTime+gap * 49,"K"),	
				new Beat(startTime+gap * 50,"S"),
				new Beat(startTime+gap * 52,"F"),
				new Beat(startTime+gap * 52,"Space"), 
				new Beat(startTime+gap * 52,"j"), 
				new Beat(startTime+gap * 54,"S"),
				new Beat(startTime+gap * 56,"D"),	
				new Beat(startTime+gap * 58,"S"),
				new Beat(startTime+gap * 60,"K"),
				new Beat(startTime+gap * 62,"F"), 
				new Beat(startTime+gap * 64,"F"),
				new Beat(startTime+gap * 66,"K"),	
				new Beat(startTime+gap * 68,"S"),
				new Beat(startTime+gap * 70,"F"),
				new Beat(startTime+gap * 72,"Space"), 
				new Beat(startTime+gap * 74,"j"), 
				new Beat(startTime+gap * 76,"D"),
				new Beat(startTime+gap * 78,"J"),
				new Beat(startTime+gap * 80,"K"),
				new Beat(startTime+gap * 82,"J"),
				new Beat(startTime+gap * 84,"K"),
				new Beat(startTime+gap * 86,"J"),
				new Beat(startTime+gap * 88,"K"),
				new Beat(startTime+gap * 90,"L"),
				new Beat(startTime+gap * 92,"D"),
				new Beat(startTime+gap * 94,"S"),	
				new Beat(startTime+gap * 96,"L"),
				new Beat(startTime+gap * 98,"K"),
				new Beat(startTime+gap * 100,"S"),
				new Beat(startTime+gap * 102,"D"),	
				new Beat(startTime+gap * 104,"S"),
				new Beat(startTime+gap * 106,"K"),
				new Beat(startTime+gap * 108,"F"), 
				new Beat(startTime+gap * 110,"F"),
				new Beat(startTime+gap * 112,"K"),	
				new Beat(startTime+gap * 114,"S"),
				new Beat(startTime+gap * 116,"F"),
				new Beat(startTime+gap * 116,"Space"), 
				new Beat(startTime+gap * 116,"j"), 
				new Beat(startTime+gap * 118,"j"), 
				new Beat(startTime+gap * 120,"D"),
				new Beat(startTime+gap * 122,"J"),
				new Beat(startTime+gap * 124,"K"),
				new Beat(startTime+gap * 126,"J"),
				new Beat(startTime+gap * 128,"K"),
				new Beat(startTime+gap * 130,"J"),
				new Beat(startTime+gap * 132,"K"),
				new Beat(startTime+gap * 134,"L"),
				new Beat(startTime+gap * 136,"D"),
				new Beat(startTime+gap * 138,"S"),	
				new Beat(startTime+gap * 140,"L"),
				new Beat(startTime+gap * 142,"K"),
				new Beat(startTime+gap * 144,"S"),
				new Beat(startTime+gap * 146,"D"),	
				new Beat(startTime+gap * 148,"S"),
				new Beat(startTime+gap * 150,"K"),
				new Beat(startTime+gap * 152,"F"), 
				new Beat(startTime+gap * 154,"F"),
				new Beat(startTime+gap * 156,"K"),	
				new Beat(startTime+gap * 158,"S"),
				new Beat(startTime+gap * 160,"F"),
				new Beat(startTime+gap * 162,"Space"), 
				new Beat(startTime+gap * 164,"j"), 
				new Beat(startTime+gap * 166,"j"), 
				new Beat(startTime+gap * 168,"S"),
				new Beat(startTime+gap * 170,"D"),	
				new Beat(startTime+gap * 172,"S"),
				new Beat(startTime+gap * 174,"K"),
				new Beat(startTime+gap * 176,"F"), 
				new Beat(startTime+gap * 178,"F"),
				new Beat(startTime+gap * 180,"K"),	
				new Beat(startTime+gap * 182,"S"),
				new Beat(startTime+gap * 184,"F"),
				new Beat(startTime+gap * 186,"Space"), 
				new Beat(startTime+gap * 188,"j"), 
				new Beat(startTime+gap * 190,"D"),
		   };
				 
	   }
	   else if(titleName.equals("ڷ������ - ��߾����")&&difficulty.equals("Easy")) {
		   int startTime = 4460- Main.REACH_TIME *1000;
		   int gap = 125;
		   // ��Ʈ ��ü ���� �� ��Ʈ ��� 
		   beats = new Beat[] {			
				new Beat(startTime,"S") ,
				new Beat(startTime+gap * 2 ,"D"),
				new Beat(startTime+gap * 4 ,"S"),
				new Beat(startTime+gap * 6 ,"D"),
				new Beat(startTime+gap * 8 ,"S"),
				new Beat(startTime+gap * 10,"D"),
				new Beat(startTime+gap * 12,"J"),
				new Beat(startTime+gap * 14,"K"),
				new Beat(startTime+gap * 16,"J"),
				new Beat(startTime+gap * 18,"K"),
				new Beat(startTime+gap * 20,"J"),
				new Beat(startTime+gap * 22,"K"),
				new Beat(startTime+gap * 24,"L"),
				new Beat(startTime+gap * 26,"D"),
				new Beat(startTime+gap * 28,"S"),	
				new Beat(startTime+gap * 30,"L"),
				new Beat(startTime+gap * 32,"K"),
				new Beat(startTime+gap * 36,"J"), 
				new Beat(startTime+gap * 38,"S"),
				new Beat(startTime+gap * 40,"D"),	
				new Beat(startTime+gap * 42,"S"),
				new Beat(startTime+gap * 44,"K"),
				new Beat(startTime+gap * 46,"F"), 
				new Beat(startTime+gap * 48,"F"),
				new Beat(startTime+gap * 49,"K"),	
				new Beat(startTime+gap * 50,"S"),
				new Beat(startTime+gap * 52,"F"),
				new Beat(startTime+gap * 52,"Space"), 
				new Beat(startTime+gap * 52,"j"), 
				new Beat(startTime+gap * 54,"S"),
				new Beat(startTime+gap * 56,"D"),	
				new Beat(startTime+gap * 58,"S"),
				new Beat(startTime+gap * 60,"K"),
				new Beat(startTime+gap * 62,"F"), 
				new Beat(startTime+gap * 64,"F"),
				new Beat(startTime+gap * 66,"K"),	
				new Beat(startTime+gap * 68,"S"),
				new Beat(startTime+gap * 70,"F"),
				new Beat(startTime+gap * 72,"Space"), 
				new Beat(startTime+gap * 74,"j"), 
				new Beat(startTime+gap * 76,"D"),
				new Beat(startTime+gap * 78,"J"),
				new Beat(startTime+gap * 80,"K"),
				new Beat(startTime+gap * 82,"J"),
				new Beat(startTime+gap * 84,"K"),
				new Beat(startTime+gap * 86,"J"),
				new Beat(startTime+gap * 88,"K"),
				new Beat(startTime+gap * 90,"L"),
				new Beat(startTime+gap * 92,"D"),
				new Beat(startTime+gap * 94,"S"),	
				new Beat(startTime+gap * 96,"L"),
				new Beat(startTime+gap * 98,"K"),
				new Beat(startTime+gap * 100,"S"),
				new Beat(startTime+gap * 102,"D"),	
				new Beat(startTime+gap * 104,"S"),
				new Beat(startTime+gap * 106,"K"),
				new Beat(startTime+gap * 108,"F"), 
				new Beat(startTime+gap * 110,"F"),
				new Beat(startTime+gap * 112,"K"),	
				new Beat(startTime+gap * 114,"S"),
				new Beat(startTime+gap * 116,"F"),
				new Beat(startTime+gap * 116,"Space"), 
				new Beat(startTime+gap * 116,"j"), 
				new Beat(startTime+gap * 118,"j"), 
				new Beat(startTime+gap * 120,"D"),
				new Beat(startTime+gap * 122,"J"),
				new Beat(startTime+gap * 124,"K"),
				new Beat(startTime+gap * 126,"J"),
				new Beat(startTime+gap * 128,"K"),
				new Beat(startTime+gap * 130,"J"),
				new Beat(startTime+gap * 132,"K"),
				new Beat(startTime+gap * 134,"L"),
				new Beat(startTime+gap * 136,"D"),
				new Beat(startTime+gap * 138,"S"),	
				new Beat(startTime+gap * 140,"L"),
				new Beat(startTime+gap * 142,"K"),
				new Beat(startTime+gap * 144,"S"),
				new Beat(startTime+gap * 146,"D"),	
				new Beat(startTime+gap * 148,"S"),
				new Beat(startTime+gap * 150,"K"),
				new Beat(startTime+gap * 152,"F"), 
				new Beat(startTime+gap * 154,"F"),
				new Beat(startTime+gap * 156,"K"),	
				new Beat(startTime+gap * 158,"S"),
				new Beat(startTime+gap * 160,"F"),
				new Beat(startTime+gap * 162,"Space"), 
				new Beat(startTime+gap * 164,"j"), 
				new Beat(startTime+gap * 166,"j"), 
				new Beat(startTime+gap * 168,"S"),
				new Beat(startTime+gap * 170,"D"),	
				new Beat(startTime+gap * 172,"S"),
				new Beat(startTime+gap * 174,"K"),
				new Beat(startTime+gap * 176,"F"), 
				new Beat(startTime+gap * 178,"F"),
				new Beat(startTime+gap * 180,"K"),	
				new Beat(startTime+gap * 182,"S"),
				new Beat(startTime+gap * 184,"F"),
				new Beat(startTime+gap * 186,"Space"), 
				new Beat(startTime+gap * 188,"j"), 
				new Beat(startTime+gap * 190,"D"),
		   };
				 
	   }
	   else if(titleName.equals("ڷ������ - ��߾����")&&difficulty.equals("Hard")) {
		   int startTime = 4460- Main.REACH_TIME *1000;
		   int gap = 125;
		   // ��Ʈ ��ü ���� �� ��Ʈ ��� 
		   beats = new Beat[] {			
				new Beat(startTime,"S") ,
				new Beat(startTime+gap * 2 ,"D"),
				new Beat(startTime+gap * 4 ,"S"),
				new Beat(startTime+gap * 6 ,"D"),
				new Beat(startTime+gap * 8 ,"S"),
				new Beat(startTime+gap * 10,"D"),
				new Beat(startTime+gap * 12,"J"),
				new Beat(startTime+gap * 14,"K"),
				new Beat(startTime+gap * 16,"J"),
				new Beat(startTime+gap * 18,"K"),
				new Beat(startTime+gap * 20,"J"),
				new Beat(startTime+gap * 22,"K"),
				new Beat(startTime+gap * 24,"L"),
				new Beat(startTime+gap * 26,"D"),
				new Beat(startTime+gap * 28,"S"),	
				new Beat(startTime+gap * 30,"L"),
				new Beat(startTime+gap * 32,"K"),
				new Beat(startTime+gap * 36,"J"), 
				new Beat(startTime+gap * 38,"S"),
				new Beat(startTime+gap * 40,"D"),	
				new Beat(startTime+gap * 42,"S"),
				new Beat(startTime+gap * 44,"K"),
				new Beat(startTime+gap * 46,"F"), 
				new Beat(startTime+gap * 48,"F"),
				new Beat(startTime+gap * 49,"K"),	
				new Beat(startTime+gap * 50,"S"),
				new Beat(startTime+gap * 52,"F"),
				new Beat(startTime+gap * 52,"Space"), 
				new Beat(startTime+gap * 52,"j"), 
				new Beat(startTime+gap * 54,"S"),
				new Beat(startTime+gap * 56,"D"),	
				new Beat(startTime+gap * 58,"S"),
				new Beat(startTime+gap * 60,"K"),
				new Beat(startTime+gap * 62,"F"), 
				new Beat(startTime+gap * 64,"F"),
				new Beat(startTime+gap * 66,"K"),	
				new Beat(startTime+gap * 68,"S"),
				new Beat(startTime+gap * 70,"F"),
				new Beat(startTime+gap * 72,"Space"), 
				new Beat(startTime+gap * 74,"j"), 
				new Beat(startTime+gap * 76,"D"),
				new Beat(startTime+gap * 78,"J"),
				new Beat(startTime+gap * 80,"K"),
				new Beat(startTime+gap * 82,"J"),
				new Beat(startTime+gap * 84,"K"),
				new Beat(startTime+gap * 86,"J"),
				new Beat(startTime+gap * 88,"K"),
				new Beat(startTime+gap * 90,"L"),
				new Beat(startTime+gap * 92,"D"),
				new Beat(startTime+gap * 94,"S"),	
				new Beat(startTime+gap * 96,"L"),
				new Beat(startTime+gap * 98,"K"),
				new Beat(startTime+gap * 100,"S"),
				new Beat(startTime+gap * 102,"D"),	
				new Beat(startTime+gap * 104,"S"),
				new Beat(startTime+gap * 106,"K"),
				new Beat(startTime+gap * 108,"F"), 
				new Beat(startTime+gap * 110,"F"),
				new Beat(startTime+gap * 112,"K"),	
				new Beat(startTime+gap * 114,"S"),
				new Beat(startTime+gap * 116,"F"),
				new Beat(startTime+gap * 116,"Space"), 
				new Beat(startTime+gap * 116,"j"), 
				new Beat(startTime+gap * 118,"j"), 
				new Beat(startTime+gap * 120,"D"),
				new Beat(startTime+gap * 122,"J"),
				new Beat(startTime+gap * 124,"K"),
				new Beat(startTime+gap * 126,"J"),
				new Beat(startTime+gap * 128,"K"),
				new Beat(startTime+gap * 130,"J"),
				new Beat(startTime+gap * 132,"K"),
				new Beat(startTime+gap * 134,"L"),
				new Beat(startTime+gap * 136,"D"),
				new Beat(startTime+gap * 138,"S"),	
				new Beat(startTime+gap * 140,"L"),
				new Beat(startTime+gap * 142,"K"),
				new Beat(startTime+gap * 144,"S"),
				new Beat(startTime+gap * 146,"D"),	
				new Beat(startTime+gap * 148,"S"),
				new Beat(startTime+gap * 150,"K"),
				new Beat(startTime+gap * 152,"F"), 
				new Beat(startTime+gap * 154,"F"),
				new Beat(startTime+gap * 156,"K"),	
				new Beat(startTime+gap * 158,"S"),
				new Beat(startTime+gap * 160,"F"),
				new Beat(startTime+gap * 162,"Space"), 
				new Beat(startTime+gap * 164,"j"), 
				new Beat(startTime+gap * 166,"j"), 
				new Beat(startTime+gap * 168,"S"),
				new Beat(startTime+gap * 170,"D"),	
				new Beat(startTime+gap * 172,"S"),
				new Beat(startTime+gap * 174,"K"),
				new Beat(startTime+gap * 176,"F"), 
				new Beat(startTime+gap * 178,"F"),
				new Beat(startTime+gap * 180,"K"),	
				new Beat(startTime+gap * 182,"S"),
				new Beat(startTime+gap * 184,"F"),
				new Beat(startTime+gap * 186,"Space"), 
				new Beat(startTime+gap * 188,"j"), 
				new Beat(startTime+gap * 190,"D"),
		   };
				 
	   }
	   int i = 0;
	   
	   gameMusic.start();
	   //���� ��ġ�� �ɸ´� ��Ʈ�� ����Ʈ���� 
	   while(i< beats.length && !isInterrupted()) {
		   boolean dropped = false; 
		   if(beats[i].getTime()<=gameMusic.getTime()) {
			   Note note = new Note(beats[i].getNoteName());
			   note.start();
			   noteList.add(note);
			   i++;
			   dropped = true;
		   }
		   if(!dropped) {
			   try {
				   Thread.sleep(5);
			   }catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
	   }
	   
	   }
      public void judge(String input) {
		for(int i = 0; i<noteList.size();i++ ) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}   
	  }
      public void judgeEvent(String judge) {
    	  if(!judge.equals("None")) {
    		  blueFlareImage = new ImageIcon(Main.class.getResource("../images/flare.png")).getImage();
    	  }
    	  if(judge.equals("Miss")) {
    		  judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
    	  }
    	  else if(judge.equals("Late")) {
    		  judgeImage = new ImageIcon(Main.class.getResource("../images/late.png")).getImage();
    	  }
    	  else if(judge.equals("Good")) {
    		  judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();
    	  }
    	  else if(judge.equals("Great")) {
    		  judgeImage = new ImageIcon(Main.class.getResource("../images/great.png")).getImage();
    	  }
    	  else if(judge.equals("Perfect")) {
    		  judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();
    	  }
    	  else if(judge.equals("Early")) {
    		  judgeImage = new ImageIcon(Main.class.getResource("../images/early.png")).getImage();
    	  }
      }
}
