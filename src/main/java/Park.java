package main.java;

class Park {
	private String address;
	private String designation;
	
	protected Park(String address, String designation) {
		this.address = address;
		this.designation = designation;
	}
	
	class Attraction {
		private String info;
		private String schedule;
		private String priceList;
		
		
		Attraction(String info, String schedule, String priceList) {
			this.info = info;
			this.schedule = schedule;
			this.priceList = priceList;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			return sb
					.append("\nDesignation: ")
					.append(designation) 
					.append("\nAddress: ")
					.append(address) 
					.append("\nInfo: ")
					.append(info)
					.append("\nSchedule: ")
					.append(schedule)
					.append("\nPricelist: ")
					.append(priceList).toString();
		}
	}
}
