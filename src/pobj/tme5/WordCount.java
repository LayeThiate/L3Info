package pobj.tme5;

import pobj.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class WordCount {

	public static void wordcount(MultiSet<String> ms){
		String file ="WarAndPeace.txt";
		BufferedReader br = null;
		try {
			/*lecture du fichier*/
			 br = new BufferedReader(new FileReader(file));
			 String line;
			try {
				/*parcours ligne par ligne*/
				while((line = br.readLine()) != null){
					/*ajouter les mots de chaque ligne dans ms*/
					 for(String word : line.split("\\P{L}+")){
						 ms.add(word, 1);
					 }
				 }
				List<String> list = ms.elements();
				
				class MultiSetComparator implements Comparator<String> {
					MultiSet<String> ms;
					
					public MultiSetComparator(MultiSet<String> ms) {
						this.ms = ms;
					}
					
					public int compare(String o1, String o2) {
						return Integer.compare(ms.count(o2), ms.count(o1));
					}
				}
				
				Comparator<String> c = new MultiSetComparator(ms);
				
				list.sort(c);
				/*affiche les 10 1er elements*/
				/*for(int i=0; i<10; i++){
					System.out.println(list.get(i) +" : "+ms.count(list.get(i)));
				}*/
				//System.out.println(ms.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Chrono ch = new Chrono();
		MultiSetDecorator<String> dec = new MultiSetDecorator<String>( new NaiveMultiSet<String>());
		wordcount(dec);
		System.out.println(dec.toString());
		//dec.remove("the",31952);
		ch.stop();
	}

}
