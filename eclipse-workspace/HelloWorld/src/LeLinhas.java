import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeLinhas {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\gcfle\\Desktop\\testes.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		System.out.println("Fim de execução");
		
	}

}