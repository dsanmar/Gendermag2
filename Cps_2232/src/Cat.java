

enum Color{
	WHITE, CREAM, FAWN, CINNAMON, CHOCOLATE, RED, LILAC, BLUE, BLACK, LAVENDAR
}

public class Cat {
	//Data field
	 String name; 
	 double age;//in years
	 Color color;// we will limit color choice
	 String type;// domestic/feral
	 static int numberofcats;
	
	//Constructor 
	Cat( ){
		
	}
	Cat (String name){
		this.name=name;
	}
	Cat(String name, double age, Color color, String type){
		this.name=name;
		this.age=age;
		this.color=color;
		this.type=type;
	}
	Cat (String name, String breed){
		this.name=name;
		System.out.println(breed);
		
	}
	//methods
	public static int getNumberofcats() {
		return numberofcats;
	}
	String eat () {
		return "Favorite food";
	}
	boolean play(String toy) {
		return false;
	}
	





}
