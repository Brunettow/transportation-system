
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package locations;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import passengers.*;

	public class Location{
		
		private int ID;
		private double locationX;
		private double locationY;
		private ArrayList<Passenger> history = new ArrayList<Passenger>();
		private ArrayList<Passenger> current = new ArrayList<Passenger>();
	
		/**
		 * Creates a location with variables ID, x and y coordinates
		 * 
		 * @param ID ID number of this
		 * @param locationX x coordinate of this
		 * @param locationY y coordinate of this
		 */
		public Location(int ID, double locationX, double locationY) {
			
			this.ID = ID;
			this.locationX = locationX;
			this.locationY = locationY;			
		}
		
		/**
		 * Returns ID of the location
		 * 
		 * @return this ID
		 */
		
		public int getID () {
			
			return this.ID;
		}
		
		/**
		 * Calculates and returns the distance between this location and other location that is given
		 * 
		 * @param other the input location 
		 * @return distance between two locations
		 */
	
		public double getDistance(Location other) {  
		
			return Math.sqrt(Math.pow((other.locationX-this.locationX),2)+ Math.pow((other.locationY-this.locationY),2));
		}
		
		/**
		 * Adds the input passenger to an ArrayList called current which represents the passengers that are currently at this
		 * 
		 * @param p passengers that came to this location 
		 */
		
		public void incomingPassenger(Passenger p) {
			
			this.current.add(p);			
		}
		
		/**
		 * Removes the input passenger from an ArrayList called current which means passenger is leaving this location
		 * Adds passenger to another ArrayList called history which represents passengers who left this location.
		 *  
		 * @param p passengers that leaving this location
		 */
		
		public void outgoingPassenger(Passenger p) {
			
			this.current.remove(p);
			this.history.add(p);
		}
		
		/**
		 * Returns x variable of this location
		 * 
		 * @return x variable of this location
		 */
		
		public double getX () {
			
			return this.locationX;
		}
		
		/**
		 * Returns y variable of this location
		 * 
		 * @return y variable of this location
		 */
		
		public double getY () {
			
			return this.locationY;
		}
		
		
		/**
		 * Prints location with its ID, sends PrintStream to another method to print Passenger info
		 * 
		 * @param output name of the PrintStream
		 */
	
		public void printInfo (PrintStream output) {
			
			Collections.sort(current, new Comparator<Passenger>(){
				
			public int compare(Passenger p1, Passenger p2) {
					return Integer.valueOf(p1.getID()).compareTo(p2.getID());
				}
			});
				
		output.printf("Location %d: (%.2f, %.2f)\n",this.ID,this.locationX,this.locationY);
				
		for(int i=0;i<current.size();i++) {
			current.get(i).printMoreInfo(output);
		}
	}
}
	
	


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

