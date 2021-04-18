
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;
import locations.*;

	public class StandardPassenger extends Passenger {		
		
		/**
		 * Creates a standard passenger who doesn't have a car
		 * 
		 * @param ID Passenger's ID
		 * @param hasDriversLicense Passanger's drivers license statue
		 * @param l Passanger's current location
		 */
		
		public StandardPassenger(int ID,boolean hasDriversLicense,Location l) {
			super(ID, hasDriversLicense,l);
		}
		/**
		 * Creates a standard passenger who has a car
		 * 
		 * @param ID Passenger's ID
		 * @param l asDriversLicense Passanger's drivers license statue
		 * @param fuelConsumption assenger's car's fuel consumption rate
		 */
		
		public StandardPassenger(int ID, Location l,double fuelConsumption) {
			super(ID, l,fuelConsumption);	
		}
	}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

