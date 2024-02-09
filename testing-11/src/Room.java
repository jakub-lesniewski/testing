public class Room {
    boolean hasBathroom;
    int capacity;
    double price;
    boolean isBooked;

    public Room(boolean hasBathroom, int capacity, double price) {
        this.hasBathroom = hasBathroom;
        this.capacity = capacity;
        this.price = price;
        this.isBooked = false;
    }
}