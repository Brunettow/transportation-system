
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;
import locations.Location;
import passengers.Passenger;

	public abstract class PublicTransport {
		
	protected int ID;
	protected double x1;
	protected double y1;
	protected double x2;
	protected double y2;
	
	/**
	 * Creates a public transportation which takes its ranges via parameters
	 * 
	 * @param ID Vehicle's ID
	 * @param x1 Range element of the vehicle
	 * @param y1 Range element of the vehicle
	 * @param x2 Range element of the vehicle
	 * @param y2 Range element of the vehicle
	 */

		public PublicTransport(int ID,double x1,double y1, double x2, double y2) {
			
			this.ID=ID;
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
		}
		
		/**
		 * Checks whether given locations are inside the vehicle's range
		 * 
		 * @param departure where the travel begins
		 * @param arival where the travel ends
		 * @return whether locations are inside the vehicle's range
		 */
	
		public abstract boolean canRide(Location departure, Location arival);
		
		/**
		 * Calculates and returns the price that should be paid by the passenger 
		 * 
		 * @param p Passenger that is used public transportation
		 * @param oldLoc where travel begins
		 * @param newLoc where travel ends
		 * @return price that should be paid
		 */
	
		public abstract double getPrice(Passenger p, Location oldLoc, Location newLoc);  //ben yazdım
		
		/**
		 * Returns ID of the vehicle 
		 * @return vehicle's ID
		 */
		
		public abstract int getID();
		
	}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE





