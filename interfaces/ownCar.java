
package interfaces;

import locations.*;

public interface ownCar {
	
	/**
	 * Refuels the car of this passenger
	 * 
	 * @amount the amount of the fuel that will be added to the car
	 */
	
	public void refuel(double amount);
	
	/**
	 * Used for traveling via personal car. Checks whether there is enough fuel inside the car. Then changes the fuel amount and changes the
	 * location of the passenger. Also removes the passenger from the ArrayList current and adds it to the another ArrayList called history
	 * 
	 * @param l Target location that will be traveled
	 */
	
	public void drive(Location l);
	
	/**
	 * Gives this passenger a new car and a drivers license
	 * 
	 * @param fuelConsumption the rate of the fuel consumption of the new car that will be created
	 */
	
	public void purchaseCar(double fuelConsumption);
}

