package bigmlApi;

import java.util.Scanner;

public class BigmlTest {

	public static void main(String[] args) throws Throwable {
		Scanner scanner=new Scanner(System.in);
		String input=null,source, dataset;
		Requests requests =new Requests();
		System.out.println("Veri Dosyasının Yolunu Veriniz:\n Çıkmak için exit yazınız\n");
		
		while (scanner.hasNext()) {		
			input=scanner.nextLine();
			if (input == "exit") {
				break;
			}
			else {
				source=requests.getSource();
				if (source != null) {
					System.out.println("Kaynak Oluşturuldu\n Kaynak ID= " +source);
					dataset=requests.getDataset(source);
					if (dataset != null) {
						System.out.println("Kaynak id'si ile dataset oluşturuldu\n dataset ID= "+dataset);				
					}
					
				}
				else {
					System.out.println("hata");
				}
			}
			System.out.println("Veri Dosyasının Yolunu Veriniz:\n Çıkmak için exit yazınız");
		}
	
		
		
		
	}

}
