package Twitter;

import java.util.Scanner;

public class InformationMask {

	public static String maskEmail(String email){
		StringBuilder s = new StringBuilder();
		s.append(email.charAt(0));
		s.append("*****");
		s.append(email.substring(email.lastIndexOf('@') - 1));
		return s.toString();
		
	}
	
	public static String maskPhone(String phone){
		StringBuilder s = new StringBuilder();
		int numDigit = 0;
		for(char c : phone.toCharArray()){
			if(Character.isDigit(c))
				numDigit++;
		}
		if(numDigit > 10){
			s.append("+");
			while(numDigit > 10){
				numDigit--;
				s.append("*");
			}
			s.append("-");
		}
		s.append("***-***-" + phone.substring(phone.length() - 4));
		return s.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		while(in.hasNext()){
			String line = in.nextLine();
			String[] info = line.split(":");
			info[0] = info[0].replace(" ", "");
			info[1] = info[1].replace(" ", "");
						
			if(info[0].equals("E")){
				System.out.println("E:" + maskEmail(info[1]));
			}
			else if(info[0].equals("P"))
				System.out.println("P:" + maskPhone(info[1]));
		}
		in.close();
	}
	
	
	
	

}
