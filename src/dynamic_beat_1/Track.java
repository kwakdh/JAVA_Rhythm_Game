package dynamic_beat_1;

public class Track {
 //하나의 곡에 대한 정보 담기 --- 앨범, 이름 , 음악 
	private String titleImage ; // 타이틀 사진  
	private String startImage ; // 게임 선택 창 표지 이미지 
	private String gameImage ;  // 해당곡 실행시 표지 이미지 
	private String startMusic ; // 게임 선택 했을 때  창 음악
	private String gameMusic ;  // 해당곡 음악 플레이 재생 
	private String titleName;   // 곡제목 
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	//생성자 
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName) {
		
		super();
		
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage  = gameImage;
		this.startMusic = startMusic;
		this.gameMusic  = gameMusic;
		this.titleName  = titleName;
	
	}	
}
