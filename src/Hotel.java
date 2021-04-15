import java.util.ArrayList;

public class Hotel
{
    private Reservation[] rooms;
    //each element corresponds to a room in the hotel;
    //if rooms[index] is null, the room is empty;
    //otherwise, it contains a reference to the Reservation
    //for that room, such that
    //rooms[index].getRoomNumber() returns index
    
    private ArrayList<String> waitList;
    //contains names of guests who have not yet been
    //assigned a room because all rooms are full
    
    
    //if there are any empty rooms (rooms with no reservation),
    //then create a reservation for an empty room for the
    //specified guest and return the new Reservation;
    //otherwise, add the guest to the end of the waitList and return null
    public Reservation requestRoom(String guestName)
    {
        Reservation r;
        for(int x = 0; x < rooms.length; x += 1) {
            if (rooms[x] == null) {
                r = new Reservation(guestName, x);
                rooms[x] = r;
                return r;

            }
        }

        waitList.add(guestName);
        return null;
    }
    
    
    //release the room associated with parameter res, effectively
    //canceling the reservation;
    //if any names are stored in waitList, remove the first name
    //and create a Reservation for this person in the room
    //reserved by res; return that new Reservation;
    //if waitList is empty, mark the room specified by res as empty and
    //return null
    //precondition: res is a valid Reservation for some room
    //              in this hotel
    public Reservation cancelAndReassign(Reservation res)
    {
        Reservation r;
        String name = "";
        if (waitList.size() != 0) {
            name = waitList.get(0);
            waitList.remove(0);
            r = new Reservation(name, res.getRoomNumber());
            rooms[res.getRoomNumber()] = r;
            return r;


        } else {

            rooms[res.getRoomNumber()] = null;
            return null;
        }

    }


    //constructors and other methods not shown

    public Hotel(int numberOfRooms) {
        rooms=new Reservation[numberOfRooms];
        waitList = new ArrayList();
    }
    
	public String report(){
		String output = "Rooms:\n";
		for (int i=0; i<rooms.length;i++){
			if (rooms[i]==null)
				output += "Room "+i+": empty\n";
			else
				output += rooms[i] + "\n";
		}
		output += "\n\nWaiting List:\n";
		if (waitList.size()==0){
			output += "empty";
		} else for (Object n:waitList){
			output += (String)n + "\n";
		}

		return output;
	}

	public Reservation findByRoomNumber(int roomNumber)
    {
        return rooms[roomNumber];
    }

    public ArrayList<String> getWaitList() {
        return waitList;
    }
}
