package unit1;

import java.awt.Color;

public abstract class AbstractCat {
		//Data field
		private String name; 
		private double age;//in years
		private Color color;// we will limit color choice
		private String type;// domestic/feral
		private static int numberofcats;
		private DOB birthdate; //for immutable 
			
		public abstract boolean useLitterBox();
		
		public DOB getBirthDate() {//for immutable 
			return birthdate;
		}
			
		//constructor
		public AbstractCat() {
			
		}
		public AbstractCat(String name, double age, Color color, String type, DOB birthdate ) {
			this.name=name;
			this.age=age;
			this.color=color;
			this.type=type;
			this.birthdate=birthdate;
		}
		//getter and setter
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getAge() {
			return age;
		}
		public void setAge(double age) {
			this.age = age;
		}
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public static int getNumberofcats() {
			return numberofcats;
		}
		public static void setNumberofcats(int numberofcats) {
			AbstractCat.numberofcats = numberofcats;
		}
		//custom method
		String eat () {
			return "Favorite food";
		}
		boolean play(String toy) {
			return false;
		}
		//toString  (will print out info)
		@Override
		public String toString() {
			return "AbstractCAT [name=" + name + ", age=" + age + ", color=" + color + ", type=" + type + "]";
		}		
		
	}
class DOB{
	private int year;
	private int month;
	private int day;
	
	public DOB(int Newyear, int Newmonth, int Newday) {
		year=Newyear;
		month=Newmonth;
		day=Newday;
		
	}
	public void setYear(int Newyear) {
		year=Newyear;
	}
	@Override //MUTABLE
	public String toString() {
		return "DOB [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	
	
	
}

