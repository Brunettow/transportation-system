

//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;
import java.util.*;
import vehicles.*;
import java.io.*;
import passengers.*;
import locations.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		/** Takes input file and scans it with Scanner named input. Does necessary operations and prints the output via printStream with name output.
		 * 
		 * Has three ArrayList whose names are passengers, locations and vehicles. Those ArrayLists takes the objects related to their names
		 * when an object is generated. Scanner which has the name line takes the input line by line and help the code to take input as it required.
		 * In switch, case 1 creates a passenger, case 2 creates a location, case 3 creates a public transportation, case 4 does necessary operations 
		 * when a passenger travels to a different location, case 5 does necessary operations when a passenger purchases a car, case 6 refulls the car of
		 * determined passenger, case 7 refills the card of determined passenger. Lastly, after operations done, printStream creates a n output file and prints
		 * locations and passengers inside the locations one by one with required information.
		 * 
		 * @author BengisuTakkin
		 * @throws fileNotFoundException 
		 * @param l is the default location at (0,0) point.
		 * @param operations number of the operations that will be implemented.
		 * @param type input of switch, determines the type of the operation that is needed to be implemented.
		 */
		
		Locale.setDefault(Locale.ENGLISH);

		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));
		
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<PublicTransport> vehicles = new ArrayList<PublicTransport>();
		
		Location l = new Location(0, 0, 0);
		locations.add(l);
		int operations = input.nextInt();
		input.nextLine();
	
		for(int i = 0; i<operations ; i++) {
			
			Scanner line = new Scanner(input.nextLine());
			int type = line.nextInt();
			
				switch(type) {
	
				case 1:  //creates a passenger
				
					int ID=passengers.size();  //Passenger's ID
					String passType = line.next();  //Passenger's type (Standard or Discounted)
					int licen = line.nextInt();    //Passenger's license statue
					int hasCar = line.nextInt();  //Passenger's car statue
					
					boolean license;  //Converting the license statue to a boolean
					if(licen == 1) {
					license = true;
					} else {
					license = false;
					}
	
					if(hasCar==1) {  //Passenger who has a car
						
						double fuel = line.nextDouble(); //Fuel consumption of the passenger's car 
					
						if(passType.equalsIgnoreCase("S")) {      //Standard passenger  
							Passenger pass = new StandardPassenger(ID, l, fuel);
							passengers.add(pass);
							l.incomingPassenger(pass);
						} else {   //Discounted passenger
							Passenger pass = new DiscountedPassenger(ID, l, fuel);
							passengers.add(pass);
							l.incomingPassenger(pass);
						}
						
					} else {   //Passenger who does not have a car
						
						if(passType.equalsIgnoreCase("S")) {  //Standard passenger
							Passenger pass = new StandardPassenger(ID, license, l);
							passengers.add(pass);
							l.incomingPassenger(pass);
							
						} else {	//Discounted passenger	
							Passenger pass = new DiscountedPassenger(ID, license, l);
							passengers.add(pass);
							l.incomingPassenger(pass);
						}
					}	
					
				break;	
				
				
				case 2: //creates a location
					
					int IDloc =locations.size();  //Location's ID
					double x = line.nextDouble();  //Location's x coordinate
					double y = line.nextDouble();  //Location's y coordinate
					Location loca = new Location(IDloc,x,y);  //creating a new location with given variables
					locations.add(loca);  //adding it to the ArrayList
					 
				break;	
					
	
				case 3:  //creates a public transportation
									
					int vehicleType = line.nextInt();  //Vehicle's type
					int IDvehicle = vehicles.size();  //Vehicle's ID
					
					double x1 = line.nextDouble();  //Range rectangle's boundaries of the vehicle
					double y1 = line.nextDouble();
					double x2 = line.nextDouble();
					double y2 = line.nextDouble();
					
					if(vehicleType==1) {  //Creating a bus
						PublicTransport bus = new Bus(IDvehicle,x1,y1,x2,y2);
						vehicles.add(bus);
					} 
					if( vehicleType==2) {  //Creating a train
						PublicTransport train = new Train(IDvehicle,x1,y1,x2,y2);
						vehicles.add(train);
					} 
					
				break;	
					
				
				case 4: //does necessary operations when a passenger travels
					
					int travelerID = line.nextInt();  //Traveler's ID
					int locationID = line.nextInt();  //Target location's ID
					int vehicleTypeNumb = line.nextInt();  //Vehicle type which will be used for the travel
					
					Passenger traveler = passengers.get(travelerID);
					Location newLocation = locations.get(locationID);
					
					if(newLocation.getID()!=traveler.getLocation().getID()) {
					
					if(vehicleTypeNumb==2||vehicleTypeNumb==1) {  //Traveling with public transportation
							
							int vehicleID = line.nextInt();  //Vehicle's ID
							PublicTransport vehicle = vehicles.get(vehicleID);
						
							if(vehicle.canRide(traveler.getLocation(), newLocation)) {  //Checking whether vehicle's range is relevant for both locations 		                              
								traveler.ride(vehicle, newLocation);	//Doing necessary operations					   	                                           	
							}
						} else {  //Traveling with personal car
							traveler.drive(newLocation);  //Doing necessary operations     
						}	
					}
					
				break;
					
				
				case 5: //Does necessary operations when a passenger purchase a car
	            
					int ownerID = line.nextInt();  //Owner's ID
					double carConsump = line.nextDouble();  //Car consumption of the new car
					Passenger owner = passengers.get(ownerID);  
					owner.purchaseCar(carConsump);  //Purchasing a new car
			
				break;
					
				
				case 6: //refulls the car of the passenger
					
					int refullerID = line.nextInt();  //Passenger's ID that will refull the car
					double amount = line.nextDouble();  //Amount of the fuel
					
					Passenger refuller = passengers.get(refullerID);  
					refuller.refuel(amount);  //Refulls the car
					
				break;
				
				
				case 7: //refills the car of the passenger
					
					int refillerID = line.nextInt();  //Passenger's ID that will refill the card balance
					double amountM = line.nextDouble();  //Amount to refill
					
					Passenger refiller = passengers.get(refillerID);
					refiller.refillCard(amountM);  //Refilling the card balance
					
				break;
			
			}
		}
		
		for(int n = 0 ; n<locations.size(); n++) {   //creates an output file with required information inside
						
			locations.get(n).printInfo(output);
			
		}
		
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

