package ogzkaras.predictApi.BigmlIO;

import java.util.HashMap;
import java.util.Scanner;

import org.bigml.binding.AuthenticationException;
import org.json.simple.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner;

	public static void main(String[] args) throws AuthenticationException {
		scanner = new Scanner(System.in);
		HashMap<Object, Object> inputData=new HashMap<Object, Object>();
		String input = null, source, dataset,model;
		Requests requests = new Requests();
		System.out.println("Model oluşturmak için 1'i tuşlayınız:\nHazır modele veri gönermek için 2'i tuşlayınız\n");
		input = scanner.next();
		if (input.equals("1")) {
			System.out.println("Modeli eğitmek için kullanacağınız dosya yolunu veriniz:");
			input=scanner.next();
			source = requests.getSource(input);
			if (source != null) {
				System.out.println("Kaynak Oluşturuldu\n Kaynak ID= " + source);
				dataset = requests.getDataset(source);
				if (dataset != null) {
					System.out.println("Kaynak id'si ile dataset oluşturuldu\n dataset ID= " + dataset);
					model=requests.createModel(dataset);
					if (model != null) {
						System.out.println("Dataset Id ile model oluşturuldu\n modelId= "+model);
						System.out.println("Modelden tahmin almak için parametrelerinizi giriniz: (Çıkış yapma için \"exit\" yazınız)");
						int i=0;
						while (true) {
							System.out.println(i+". parametreyi giriniz");
							input=scanner.next();
							if (input.equals("exit")) {
								break;
							}
							else {
								inputData.put(i,input);
								i++;
							}
						}
						JSONObject inputDataObject=new JSONObject(inputData);
						requests.getPredict(model, inputDataObject);
					}
				}

			} else {
				System.out.println("hata");
			}
		} else if (input.equals("2")) {
			System.out.println("Çalıştırmak istediğiniz model Id'ni giriniz");
			model=scanner.next();
			System.out.println("Modelden tahmin almak için parametrelerinizi giriniz: (Çıkış yapma için \"exit\" yazınız)");
			int i=0;
			while (true) {
				System.out.println(i+". parametreyi giriniz");
				input=scanner.next();
				if (input.equals("exit")) {
					break;
				}
				else {
					inputData.put(i,input);
					i++;
				}
			}
			JSONObject inputDataObject=new JSONObject(inputData);
			requests.getPredict(model, inputDataObject);
		}

	}

}
