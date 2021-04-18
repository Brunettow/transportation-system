
package interfaces;

import locations.*;
import vehicles.*;

public interface usePublicTransport {
	
	/**
	 * Used for traveling via public transportation. Checks whether the passenger has enough card balance then changes the card balance and
	 * the location of the passenger. Also removes the passenger from the ArrayList current and adds it to the another ArrayList called history
	 * 
	 * @param p Traveler
	 * @param l Target location that will be traveled
	 */
	
	public void ride(PublicTransport p, Location l);
	
	/**
	 * Refills the card balance of this passenger
	 * 
	 * @param amount the amount that will be added to the card balance
	 */
	
	public void refillCard(double amount);
}

