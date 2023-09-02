package main.java;

class Employee {
	String fullName;
	String position;
	String email;
	String tel;
	int salary;
	int age;
	
	Employee(String fullName, String position, String email, String tel, int salary, int age) {
		this.fullName = fullName;
		this.position = position;
		this.email = email;
		this.tel = tel;
		this.salary = salary;
		this.age = age;
	}
		
	/*
	 * Хотя поля типа "Сотрудник" и видны в пределах пакета, 
	 * я взял на себя инициативу переопределить метод toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb
				.append("\nFull name: ")
				.append(fullName)
				.append("\nAge: ")
				.append(age)
				.append("\nPosition: ")
				.append(position)
				.append("\nEmail: ")
				.append(email)
				.append("\nTelephone: ")
				.append(tel)
				.append("\nSalary: ")
				.append(salary)
				.toString();
	}
}
