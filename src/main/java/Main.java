package main.java;

public class Main {

	public static void main(String[] args) {
		Employee[] empls = new Employee[5];
		empls[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
		empls[1] = new Employee("Zhdanov Evgenii", "Technician", "zhdevgenii@mailbox.com", "894512345", 25500, 27);
		empls[2] = new Employee("Zaycev Boris", "Project Manager", "zaycevboris@mailbox.com", "895756491", 50000, 45);
		empls[3] = new Employee("Rusova Aleksandra", "IT Architecture Designer", "rusovaalex@mailbox.com", "892676459", 65000, 40);
		empls[4] = new Employee("Petrov Georgii", "UI/UX Designer", "petgeorgii@mailbox.com", "893143152", 45000, 41);
		
		for(Employee empl: empls) {
			if(empl.age > 40) {
				System.out.println(empl);
			}
		}
		
		//----------------------------------------
		
		Park.Attraction attraction = new Park("Кемская ул., 1А, Санкт-Петербург, Россия. \nМетро «Крестовский остров». ", "Диво-остров")
				.new Attraction("Колесо обозрения", "Открыто с 11.00", "350 \u20BD");
		System.out.println(attraction);
	}
}
