
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

	public class Car {
		
		private int ownerID;
		private double fuelAmount;
		private double fuelConsumption;
	
		/**
		 * Creates a personal car with given fuel consumption rate
		 * 
		 * @param ID Owner's ID
		 * @param fuelConsumption Fuel consumption rate of the car
		 */
		
		public Car(int ID, double fuelConsumption) {
			
			this.ownerID=ID;
			this.setFuelConsumption(fuelConsumption);
		}
		
		/**
		 * Adds fuel to car with a given amount
		 * 
		 * @param amount amount of the fuel
		 */
		
		public void refuel(double amount) {
			
			fuelAmount += amount;
		}
		
		/**
		 * Returns fuel amount inside the car
		 * 
		 * @return fuel amount
		 */
		
		public double getFuelAmount() {
			
			return this.fuelAmount;
		}
		
		/**
		 * Returns how much fuel left in the car
		 * 
		 * @return fuel left
		 */
	
		public double getFuelConsumption() {
			
			return fuelConsumption;
		}
		
		/**
		 * Sets the fuel consumption of the car
		 * 
		 * @param fuelConsumption rate of the fuel consumption
		 */
		
		public void setFuelConsumption(double fuelConsumption) {
			
			this.fuelConsumption = fuelConsumption;
		}
	}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

