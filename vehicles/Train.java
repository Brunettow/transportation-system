
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import locations.*;
import passengers.*;

	public class Train extends PublicTransport {
		
		/**
		 * Creates a train with given ranges
		 * 
		 * @param ID Train's ID
		 * @param x1 Range element of the bus
		 * @param y1 Range element of the bus
		 * @param x2 Range element of the bus
		 * @param y2 Range element of the bus
		 */
	
		public Train(int ID,double x1,double y1, double x2, double y2) {
			super(ID,x1,y1,x2,y2);
		}
		
		/**
		 * {@inheritDoc}
		 */
			@Override
		public boolean canRide(Location departure, Location arival) {
				
			return  (this.x1<=departure.getX()&& this.x2>=departure.getX() || this.x1>=departure.getX()&& this.x2<=departure.getX())&&
					(this.y1<=departure.getY()&&this.y2>=departure.getY()||this.y1>departure.getY()&&this.y2<=departure.getY())
					&& (this.x1<=arival.getX()&& this.x2>=arival.getX() || this.x1>=arival.getX()&& this.x2<=arival.getX())&&
					(this.y1<=arival.getY()&&this.y2>=arival.getY()||this.y1>arival.getY()&&this.y2<=arival.getY());
			}
		
		/**
		 * {@inheritDoc}
		 */
		
			@Override
		public double getPrice(Passenger p, Location departure, Location arival) {
				
			double distance = departure.getDistance(arival);

			double afterComma = distance/15-Math.floor(distance/15) ;
			
			int station;
			if(distance>=15) {
				if(afterComma>=0.5) {
					station = (int)(distance/15)+1;
				} else {
					station = (int)(distance/15);
				}
				
			} else {
				station=1;
			}
			
			if(p instanceof DiscountedPassenger) {
				
				return (station*5)*80/100;
				
			} else {
				
				return (station*5);
			}		
		}
			
		/**
		 * {@inheritDoc}
		 */
		
		public int getID () {
			
			return ID;
		}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

