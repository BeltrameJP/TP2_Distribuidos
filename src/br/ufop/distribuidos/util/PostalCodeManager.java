package br.ufop.distribuidos.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class PostalCodeManager {
	
	private ArrayList<PostalCode> postalCodeList;

	
	public PostalCodeManager(){
		postalCodeList = new ArrayList<PostalCode>();
	}
	
	public void ReadCsvFromFile(){

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\br_postal_codes.csv"), "ISO-8859-1"));
			
			String linha = null;
	        linha = reader.readLine();//le a primeira linha	 
	        while (linha != null) {
	        	linha = reader.readLine();
	        	if(linha!= null){
	        		String [] obj = linha.split(",");	        	
	        		if(obj.length < 5){//latitude == null
	        			postalCodeList.add(new PostalCode(obj[0], obj[1], obj[2]));
					}else{
						postalCodeList.add(new PostalCode(obj[0], obj[1], obj[2], Double.parseDouble(obj[3]), Double.parseDouble(obj[4])));
					}
	        	}
	           
	        }
	        reader.close();
	        
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado. Verificar se o arquivo encontra-se na pasta\n Ou se o caminho está certo.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	public String CitySearch(String placeName){
		for(PostalCode pc : postalCodeList){
			if(pc.getPlaceName().equals(placeName)){
				return pc.getPostalCode();
			}
		}
		return "00000-000";
	}
	
	public String LatLongSearch(double latitude, double longitude){
		int flag = 0;
		for(int i=1;i<postalCodeList.size();i++){
			if (Math.abs(postalCodeList.get(i).getLatitude() - latitude) + Math.abs(postalCodeList.get(i).getLongitude() - longitude)
					< 
				Math.abs(postalCodeList.get(flag).getLatitude() - latitude) + Math.abs(postalCodeList.get(flag).getLongitude() - longitude)){
				flag = i;
			}
		}
		return postalCodeList.get(flag).getPostalCode() == null ? "00000-000" : postalCodeList.get(flag).getPostalCode();
	}
	
}
