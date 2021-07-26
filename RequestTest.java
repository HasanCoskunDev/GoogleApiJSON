package googleApiTest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RequestTest {
	private static Scanner input;

	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<Character>();
		input = new Scanner(System.in);
		System.out.print("Lütfen mesaj giriniz: ");
		Character c=null;
		String mesaj = input.nextLine();
		String placeId = null;
		char[] charArray=mesaj.toCharArray();
		mesaj=null;
		
		for (int j = 0; j < charArray.length; j++) {
		
				c = charArray[j];
				if (c != ' ') {
					list.add(c);
				}
				else {
					list.add('%');
					list.add('2');
					list.add('0');
				}
				
			}
		StringBuilder sBuilder=new StringBuilder();
		for (Character ch : list) { 
            sBuilder.append(ch); 
        } 
		mesaj=sBuilder.toString();

		Requests requests = new Requests();
		
		try {
			placeId = requests.sendPlaceIdRequest(mesaj);
			TimeUnit.SECONDS.sleep(5);
			if (placeId != null) {
				requests.sendDetailsRequest(placeId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
		 
		
		

	}


