package model;

public class DiaryDTO {
	//  다이어리 정보를 저장하는 클래스
	private int diary_index;
	private String diary_title;
	private String diary_cont;
	private String diary_date;
	private String diary_week;
	private String diary_mood;
	private String diary_weather;
	private String memeber_id; //#수정

	public DiaryDTO() {
	}

	public int getDiary_index() {
		return diary_index;
	}

	public void setDiary_index(int diary_index) {
		this.diary_index = diary_index;
	}

	public String getDiary_title() {
		return diary_title;
	}

	public void setDiary_title(String diary_title) {
		this.diary_title = diary_title;
	}

	public String getDiary_cont() {
		return diary_cont;
	}

	public void setDiary_cont(String diary_cont) {
		this.diary_cont = diary_cont;
	}

	public String getDiary_date() {
		return diary_date;
	}

	public void setDiary_date(String diary_date) {
		this.diary_date = diary_date;
	}

	public String getDiary_week() {
		return diary_week;
	}

	public void setDiary_week(String diary_week) {
		this.diary_week = diary_week;
	}

	public String getDiary_mood() {
		return diary_mood;
	}

	public void setDiary_mood(String diary_mood) {
		this.diary_mood = diary_mood;
	}

	public String getDiary_weather() {
		return diary_weather;
	}

	public void setDiary_weather(String diary_weather) {
		this.diary_weather = diary_weather;
	}

	@Override
	public String toString() {
		return "Diary [diary_index=" + diary_index + ", diary_title=" + diary_title 
				+ ", diary_cont=" + diary_cont+ ", diary_date=" + diary_date 
				+ ", diary_week=" + diary_week + ", diary_mood=" + diary_mood
				+ ", diary_weather=" + diary_weather + "]";
	}

	//#수정
	public String getMemeber_id() {
		return memeber_id;
	}

	public void setMemeber_id(String memeber_id) {
		this.memeber_id = memeber_id;
	}

	
}
