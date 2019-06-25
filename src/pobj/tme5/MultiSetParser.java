package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiSetParser {
	
	public static MultiSet<String> parse(String fileName) throws InvalidMultiSetFormat {
		BufferedReader br = null;
		MultiSet<String> mult = new MultiSetDecorator(new HashMultiSet<String>());
		try {
			String line;
			br = new BufferedReader(new FileReader(fileName));
			while((line = br.readLine()) != null){
				/*ajouter les mots de chaque ligne dans ms*/
				String [] mot = line.split(":");
				String key = mot[0].replaceAll(" ", "");
				/*remplacer les espaces par rien*/
				int value = Integer.decode(mot[1].replaceAll(" ", ""));
				if(value<0)
					throw new InvalidMultiSetFormat(value +" est negative");
				//System.out.println("key : "+key+" value : "+value);
				mult.add(key, value);
			}
		} catch(NumberFormatException e){
			System.out.println(new InvalidMultiSetFormat("value not int"));
		}
		  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mult;
	}
}
