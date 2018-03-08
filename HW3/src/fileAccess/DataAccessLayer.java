/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package fileAccess;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

import domain.Company;
import domain.TransType;
import domain.Vehicle;

public class DataAccessLayer {
	public DataAccessLayer() {

	}

	public void readVehicles(Company company) throws FileNotFoundException, ParseException {
		Vehicle vehicle = new Vehicle();
		Scanner input = new Scanner(new File("vehicles.dat"));

		while (input.hasNextLine()) {
			String fileInput = input.nextLine();
			StringTokenizer wordFinder = new StringTokenizer(fileInput, ",");
			vehicle.setId(wordFinder.nextToken().trim());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			vehicle.setDepartureDate(formatter.parse(wordFinder.nextToken().trim()));
			vehicle.setType(TransType.valueOf(wordFinder.nextToken().trim()));
			vehicle.setUpperLimit(Integer.parseInt(wordFinder.nextToken().trim()));
			company.addVehicle(vehicle);
			vehicle = new Vehicle();
		}
	}
	
	public void  saveToDat(Company company) throws FileNotFoundException{
		String string = new String();
		Format formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		String string1 = new String(company.getCargo(0).getDate().toString().replace(":","."));
		PrintWriter outputStream = new PrintWriter(new FileOutputStream(string1 + "_cargoesInfo.dat",true));
		for(int index = 0 ; index < company.getSizeCargoes() ; index ++){
			string = Integer.toString(company.getCargo(index).getCargoID()) + "," + Double.toString(company.getCargo(index).getWeight()) + "," + Double.toString(company.getCargo(index).getPrice()) + "," + formatter1.format(company.getCargo(index).getDate()) + "," + Integer.toString(company.getCargo(index).getSender().getNationalID()) + "," + Integer.toString(company.getCargo(index).getReceiver().getNationalID()) + "," + Integer.toString(company.getCargo(index).getPayer().getNationalID()) + "\n";
			outputStream.println(string);
		}
		outputStream.close();
	}
}
