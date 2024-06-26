package mvwish;

public class VO {
	// 유저 테이블
	private String mid;
	private String password;
	private String name;
	private int age;
	private String gender;
	
	// 영화 테이블
	private int idx;
	private String movieName;
	private String runningTime;
	private String genre;
	private double score;
	private String img;
	
	// 위시 테이블
	private String wishMid;
	private int wishIdx;
	private boolean toggle;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getWishMid() {
		return wishMid;
	}
	public void setWishMid(String wishMid) {
		this.wishMid = wishMid;
	}
	public int getWishIdx() {
		return wishIdx;
	}
	public void setWishIdx(int wishIdx) {
		this.wishIdx = wishIdx;
	}
	public boolean isToggle() {
		return toggle;
	}
	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}
	@Override
	public String toString() {
		return "VO [mid=" + mid + ", password=" + password + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", idx=" + idx + ", movieName=" + movieName + ", runningTime=" + runningTime + ", genre=" + genre
				+ ", score=" + score + ", img=" + img + ", wishMid=" + wishMid + ", wishIdx=" + wishIdx + ", toggle="
				+ toggle + "]";
	}
	
	
}
