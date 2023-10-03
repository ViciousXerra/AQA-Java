package main.java;

class Person {
	private String secondName;
	private String tel;
	
	protected Person(String secondName, String tel) {
		this.secondName = secondName;
		this.tel = tel;
	}
	
	protected String getSecondName() {
		return secondName;
	}
	
	protected String getTel() {
		return tel;
	}
}
