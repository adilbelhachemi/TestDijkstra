import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Main {
	static Scanner s;

	public static void main(String[] args){

		Detail detail = new Detail();

		try {			
			
			s = new Scanner(new BufferedReader(new FileReader("Vendeur.txt")));	

			String nbrSommets = s.next();
			String sommetDep = s.next();
			
			System.out.println("nbr sommet :"+nbrSommets+" sommet de depart :"+sommetDep);

			String tmp = "";
			
			
			while(s.hasNext()){
				
				String source = s.next();	
				if(source.equals("$"))
					break;
				
				/*tmp = source;
					if(tmp.equals(source)){
						System.out.println("source ="+source);
						
					}*/
				
				
				String destination = s.next();
				String poid = s.next();
	
				
				
				System.out.println("source :"+source+" dest :"+destination+" poid :"+poid);

			}

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 



	}

}
