import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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
			Vertex[] sommets = new Vertex[Integer.parseInt(nbrSommets)];
			for (int i = 0; i < sommets.length; i++) {
				sommets[i] = new Vertex("" + (i+1));
			}
			

			String tmp = "";
			
			ArrayList<Edge> edges = new ArrayList<Edge>();
			String lastSource = null;
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
				if (!source.equals(lastSource) && lastSource != null) {
					sommets[Integer.parseInt(lastSource)-1].adjacencies = edges.toArray(new Edge[edges.size()]);
					edges = new ArrayList<Edge>();
				}
				
				edges.add(new Edge(sommets[Integer.parseInt(destination)-1],Integer.parseInt(poid)));
				lastSource = source;
			}
			sommets[Integer.parseInt(lastSource)-1].adjacencies = edges.toArray(new Edge[edges.size()]);
			
			System.out.println("done!");
			
			Dijkstra.computePaths(sommets[Integer.parseInt(sommetDep)-1]);
			
			for (Vertex v : sommets)
			{
				System.out.println("Distance to " + v + ": " + v.minDistance);
				List<Vertex> path = Dijkstra.getShortestPathTo(v);
				System.out.println("Path: " + path);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		

	}

}
