/**
 * Created by student2 on 5/6/16.
 */
public class Reservation {
    private String guestName;
    private int roomNumber;

    public Reservation(String guestName, int roomNumber){
        this.setGuestName(guestName);
        this.setRoomNumber(roomNumber);
    }
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    public String getGuestName() {
        return guestName;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String toString(){
        return "Room "+this.getRoomNumber() + " Guest: "+this.getGuestName();
    }
}
