import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RoomTest {

    @Test
    public void testRoomCreation() {
        boolean hasBathroom = true;
        int capacity = 2;
        double price = 100.0;

        Room room = new Room(hasBathroom, capacity, price);

        assertEquals(hasBathroom, room.hasBathroom, "Bathroom status should match");
        assertEquals(capacity, room.capacity, "Capacity should match");
        assertEquals(price, room.price, "Price should match");
        assertEquals(false, room.isBooked, "New room should not be booked");
    }

    @Test
    public void testRoomBooking() {
        Room room = new Room(true, 2, 100.0);
        assertEquals(false, room.isBooked, "New room should not be booked");
        room.isBooked = true;
        assertEquals(true, room.isBooked, "Room should be booked after setting isBooked to true");
    }
}