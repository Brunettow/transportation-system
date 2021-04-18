
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;
import locations.*;
import vehicles.*;

import java.io.PrintStream;

import interfaces.*;

	public class Passenger implements ownCar, usePublicTransport{
	
	protected int ID;
	protected boolean hasDriversLicense;
	protected double cardBalance​;  
	protected Car car = new Car(this.ID,0);
	protected Location currentLocation;
	
	/**
	 * Creates a passenger with a car
	 * 
	 * @param ID Passenger's ID
	 * @param l Passenger's current location
	 * @param fuelConsumption Passenger's car's fuel consumption rate
	 */

		public Passenger(int ID, Location l, double fuelConsumption) {   // for the passengers who have car	
			
			this.ID =ID;
			this.currentLocation = l;
			this.hasDriversLicense = true;
			car.setFuelConsumption(fuelConsumption);
		}
		
		/**
		 * Creates a passenger who doesn't have a car
		 * 
		 * @param ID Passenger's ID
		 * @param hasDriversLicense Passenger's driver license statues
		 * @param l Passenger's current location
		 */
		
		public Passenger(int ID, boolean hasDriversLicense, Location l) {
				
			this.ID =ID;
			this.hasDriversLicense = hasDriversLicense;
			this.currentLocation = l;
		}
		
		/**
		 *{@inheritDoc}
		 */

		public void ride(PublicTransport p, Location l) {   //for the passengers to travel using public transport
			
			double price = p.getPrice(this, this.currentLocation, l);
			if(this.cardBalance​ >= price) {
				this.cardBalance​ -= price;
				
				this.getLocation().outgoingPassenger(this);
				l.incomingPassenger(this);
				this.currentLocation=l;				
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
			
		@Override
		public void drive(Location l) {    //for the passengers who use car
				
			if(this.car.getFuelConsumption()!=0) {
			double distance = currentLocation.getDistance(l);
			double consumption = distance*this.car.getFuelConsumption();
			if(this.car.getFuelAmount()>=consumption) {
				this.car.refuel(-consumption);
				this.getLocation().outgoingPassenger(this);
				l.incomingPassenger(this);
				this.currentLocation=l;
				}
			}	
		}
		
		/**
		 *{@inheritDoc}
		 */
		@Override
		public void refillCard(double amount) {
			this.cardBalance​ += amount;	
		}
		
		/**
		 *{@inheritDoc}
		 */
	
		@Override
		public void refuel(double amount) {
			
			if(this.hasDriversLicense) {
			this.car.refuel(amount);
			}
		}
		
		/**
		 *{@inheritDoc}
		 */
	
		@Override
		public void purchaseCar(double fuelConsumption) {
			
			this.hasDriversLicense=true;
			this.car.setFuelConsumption(fuelConsumption);	
		}
		
		/**
		 * Returns ID of this passenger
		 * 
		 * @return ID of this passenger
		 */
		
		public int getID() {
			return ID;
		}
		
		/**
		 * Returns current location of this passenger
		 * 
		 * @return location of this passenger
		 */
		
		public Location getLocation () {
			return this.currentLocation;
		}	
		
		/**
		 * Checks whether this passenger has a car or not. If it has, returns fuel amount of this passenger; if it hasn't,
		 * returns the card balance of this passenger
		 *   
		 * @return card balance of this passenger who does not have a car
		 * @return fuel amount of this passenger who has a car
		 */
		public void printMoreInfo (PrintStream output) {
			
			if(this.car.getFuelConsumption()==0) {
				output.printf("Passenger %d: %.2f\n",this.ID,(double)((int)(this.cardBalance​*100))/100);
			} else {
				output.printf("Passenger %d: %.2f\n",this.ID,(double)((int)(this.car.getFuelAmount()*100))/100);
			}
		}
}
	
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

