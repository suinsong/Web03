package kr.bit.mem;

public class MemberVO {
	private int num; // �Ϸù�ȣ
	private String irum;
	private int age;
	private String email;
	private String intro;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", irum=" + irum + ", age=" + age + ", email=" + email + ", intro=" + intro
				+ "]";
	}

}
