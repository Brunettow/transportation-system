
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;
import locations.*;
import passengers.*;

	public class Bus extends PublicTransport {
		
		/**
		 * Creates a bus with given ranges
		 * 
		 * @param ID Bus's ID
		 * @param x1 Range element of the bus
		 * @param y1 Range element of the bus
		 * @param x2 Range element of the bus
		 * @param y2 Range element of the bus
		 */

		public Bus(int ID,double x1,double y1, double x2, double y2) {
				
			super(ID,x1,y1,x2,y2);
		}
		
		/**
		 * {@inheritDoc}
		 */
		
		public double getPrice(Passenger p, Location departure, Location arival) {
			
			if(p instanceof DiscountedPassenger) {
				return 1;
			} else {
				return 2;
			}
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
			
		public int getID() {
			
			return this.ID;
		}
	}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

