package dynamic_beat_1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	  
	  private Image  noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	  private int x, y= 580 - (1000 / Main.SLEEP_TIME*Main.NOTE_SPEED)*Main.REACH_TIME;//현재 노트 위치 
	  private String noteType;
	  private boolean processed = true; 
	  
	  public String getNoteType() {
		return noteType;
		  
	  }
	  
	  public boolean isProcessed() {
		
		  return processed;
		  
	  }
	  public void close() {
		  processed = false; 
	  }
	  
	  // 생성자 
	  public Note( String noteType) {
		  if(noteType.equals("S")) {
			  x=228;
		  }
		  else if(noteType.equals("D")) {
			  x=332;
		  }
		  else if(noteType.equals("F")) {
			  x=436;
		  }
		  else if(noteType.equals("Space")) {
			  x=540;
		  }
		  else if(noteType.equals("J")) {
			  x=744;
		  }
		  else if(noteType.equals("K")) {
			  x=848;
		  }
		  else if(noteType.equals("L")) {
			  x=952;
		  }
		  this.noteType= noteType;
		  
	  }
	  
	  public void screenDraw(Graphics2D g) {
		  
		  if(!noteType.equals("Space")) {
			  g.drawImage(noteBasicImage,x,y,null);
		  }
		  else {
			  g.drawImage(noteBasicImage,x,y,null);
			  g.drawImage(noteBasicImage,x+100,y,null); // 스페이스바 
		  }
	  }
	  
	  // 노트가 떨어질 때 불러오는 메서드 
	  public void drop(){
		y += Main.NOTE_SPEED;
		if(y>620) {
			System.out.println("Miss");
			close();
		}
	  }
	  
	  public void run() {
		  try {
			while(true){ //1초에 100번실행됨 
			  drop();
			  if(processed) {
				  Thread.sleep(Main.SLEEP_TIME);	  
			  }
			  else {
				  
				  interrupt();
				  break;
			  }
			 }
		  }catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	  }
	  
	  public String judge() {
		  if(y>=613) {
			  System.out.println("Late");
			  close();
			  
			  return "Late";
		  }
		  else if(y>=600) {
			  System.out.println("Good");
			  close();
			  return "Good";
		  }
		  else if(y>=587) {
			  System.out.println("Great");
			  close();
			  return "Great";
		  }
		  else if(y>=573) {
			  System.out.println("Perfect");
			  close();
			  return "Perfect";
		  }
		  else if(y>=565) {
			  System.out.println("Great");
			  close();
			  return "Great";
		  }
		  else if(y>=550) {
			  System.out.println("Good");
			  close();
			  return "Good";
		  }
		  else if(y>=535) {
			  System.out.println("early");
			  close();
			  return "early";
		  }
		  
		  return "None";
	  }
	  
	  public int getY() {
		  return y;
	  }
}
