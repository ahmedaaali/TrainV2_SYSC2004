/**
 * Car models a car in a passenger train.
 *
 * @author Ahmed Ali (101181126)
 * @version 1.0 February 7, 2022
 */
public class Car
{
    /** This car's identifier. */
    private int id;
   
    /**
     * true == this car is a business-class car,
     * false == this car is an economy-class car.
     */
    private boolean businessClass;
    
    /** The cost of a business class seat, in dollars. */
    public static final double BUSINESS_SEAT_COST = 125.0;
    
    /** The cost of an economy class seat, in dollars. */
    public static final double ECONOMY_SEAT_COST = 50.0;    
  
    /** The number of seats in a business class car. */
    public static final int BUSINESS_SEATS = 30;   
    
    /** The number of seats in an economy class car. */
    public static final int ECONOMY_SEATS = 40;   
   
    /** The list of this car's seats. */
    private Seat[] seats;
   
    /**
     * Constructs a new Car object with the specified id.
     * If parameter isBusinessClass is true, the car is a business-class
     * car. If parameter isBusinessClass is false, the car is an
     * economy-class car.
     * 
     * @param carId The Id number of the car.
     * @param isBusinessClass True for buisness class, false for economy.
     */
    public Car(int carId, boolean isBusinessClass)
    {
        id = carId;
        businessClass = isBusinessClass;
        if (businessClass){
            seats = new Seat[BUSINESS_SEATS];
            for (int i = 0; i < BUSINESS_SEATS; i++){
            seats[i] = new Seat(i + 1, BUSINESS_SEAT_COST);
            }
        } else{
            seats = new Seat[ECONOMY_SEATS];
            for (int i = 0; i < ECONOMY_SEATS; i++){
            seats[i] = new Seat(i + 1, ECONOMY_SEAT_COST);
            }
        }
    }

    /**
     * Returns this car's list of seats. This method is intended for 
     * testing purposes only, and should not be called by other objects,
     * as it may be removed from the final version of this class.
     * 
     * @return The seats in this car, an array of Seat objects.
     */
    public Seat[] seats()
    {
        return seats;
    }
 
    /** 
     * Returns true if this is a business-class car,
     * false if this is an economy-class car.
     * 
     * @return True if car is a Buisness Class, false otherwise.
     */
    public boolean isBusinessClass()
    {
        return businessClass;
    }
 
    /**
     * Returns the id of this car.
     * 
     * @return the id of this car.
     */
    public int id()
    {
        return id;
    }
  
    /**
     * This method is called when the specified seat has been booked,
     * to print a ticket for that seat.
     * 
     * @param seatNo The integer identifier of the seat.
     */
    private void printTicket(int seatNo)
    {
        System.out.println("Car ID: " + id);
        System.out.println("Seat number: " + seatNo);
        System.out.println("Price: ");
        if (businessClass) {
            System.out.println(BUSINESS_SEAT_COST);
        } else {
            System.out.println(ECONOMY_SEAT_COST);
        }
    }   
 
    /**
     * Attempts to book a seat. If successful, this method prints a 
     * ticket and returns true.
     * If no seats are available, this method returns false.
     * 
     * @return True if the next seat has been booked, false otherwise.
     */
    public boolean bookNextSeat()
    {
        // After booking an available seat, print the ticket by calling
        // private method printTicket(); e.g.,
        // printTicket(seats[i].number());
        for (int i = 0; i < seats.length; i++){
            if (!seats[i].isBooked()){
                seats[i].book();
                printTicket(i + 1);
                return true;
            }
        }
        return false;
    }

    /** 
     * Cancels the booking for the specified seat, which must be between
     * 1 and the maximum number of seats in the car.
     * If the seat number is valid and if the seat has been reserved, this
     * method cancels the booking for that seat and returns true. 
     * If the seat number is not valid, this method returns false. 
     * If the seat number is valid, but the seat has not been reserved, 
     * this method returns false.
     * 
     * @param seatNo The number of the seat.
     * @return True if the seat has been cancelled, false otherwise.
     */
    public boolean cancelSeat(int seatNo)
    {
        seatNo -= 1;
        if (seatNo >= 0 && seatNo < seats.length && seats[seatNo].isBooked()){
            seats[seatNo].cancelBooking();
            return true;
        }
        return false;
    }    
}
