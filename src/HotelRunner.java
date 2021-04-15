public class HotelRunner
{
	public static void main(String[] args){
		Hotel hotel = new Hotel(5);
		System.out.println(hotel.report());
		System.out.println("Check: The rooms and wait list above should be empty\n");

		Reservation a = hotel.requestRoom("Alice");
		Reservation b = hotel.requestRoom("Bob");
		Reservation c = hotel.requestRoom("Clare");
		Reservation d = hotel.requestRoom("Dan");
		Reservation e = hotel.requestRoom("Ed");
		Reservation f = hotel.requestRoom("Fred");
		hotel.requestRoom("Greg");
		System.out.println(hotel.report());
		System.out.println("Check: The rooms above should be full with 2 waiting");
		if (f == null){
			System.out.println("f is null as it should be\n");
		}else{
			System.out.println("Error: f is not null as it should be\n");
		}

		Reservation g = hotel.cancelAndReassign(c);
		Reservation h = hotel.cancelAndReassign(d);
		Reservation i = hotel.cancelAndReassign(e);
        System.out.println(hotel.report());
		System.out.println("Fred should be in room 2, Clare should not be in the list");
		System.out.println("Greg should be in room 3, Dan should not be in the list");
		System.out.println("Room 4 should be empty");
		if (i == null){
			System.out.println("i is null as it should be");
		}else{
			System.out.println("Error: i is not null as it should be");
		}
	}
}
