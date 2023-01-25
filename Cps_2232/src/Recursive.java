
public class Recursive {
	
	public static void thefunction(int i) {
		if (i>0) {
			System.out.println("Before recursive call: "+ i +" ");
		thefunction (i-1);
		System.out.println("After recursive call "+i+ " ");
		}
		else {
			System.out.println("In else");//base case
		}
	}

	public static void main(String[] args) {
		
		//call function 
		thefunction (3);
		
		
		
		
	}

}
