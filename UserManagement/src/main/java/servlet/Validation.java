package servlet;

public class Validation {
	public static void main(String [] args) {
		//System.out.println(isValid("Swathi@gmail.com"));
	}

	public static boolean isValid(String email) {
//		int count = 0;
//		for(int i = 0; i <= email.length()-1; i++){
//			if(email.charAt(i) == '@') {
//				count++;
//			}		
//			
//		} if(count == 1) {
//			return true;
//		}
		char[] array = email.toCharArray();
		int count = 0;
		for(int i = 0; i < array.length; i++ ) {
			if(array[i] == '@') {
				count ++;
			}
		} if(count == 1) {
			return true;
		}
		return false;	
	}

}
