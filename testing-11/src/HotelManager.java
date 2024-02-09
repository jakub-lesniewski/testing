import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelManager {
    private List<Room> rooms;
    private List<Map<String, Map<Integer, Integer>>> bookings;
    Scanner scanner;

    public HotelManager() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeRooms();
    }

    private void initializeRooms() {
        boolean[] bathrooms = {true, true, true, true, true, false, false, true, false, false};
        int[] capacities = {1, 2, 1, 3, 2, 1, 2, 3, 4, 1};
        double[] prices = {90.0, 150.5, 88.6, 202.2, 149.99, 49.99, 88.0, 201.1, 149.99, 42};

        for (int i = 0; i < bathrooms.length; i++) {
            rooms.add(new Room(bathrooms[i], capacities[i], prices[i]));
        }
    }

    public void displayAvailableRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (!room.isBooked) {
                System.out.print("Room " + i + " ");
                System.out.print(room.hasBathroom ? "with bathroom " : "without bathroom ");
                System.out.print("for " + room.capacity + " ");
                System.out.print(room.capacity == 1 ? "person " : "people ");
                System.out.println("Price: " + room.price + "zl");
            }
        }
    }

    public void makeReservation() {
        System.out.print("First name: ");
        String firstName = scanner.next();
        System.out.print("Last name: ");
        String lastName = scanner.next();
        String fullName = firstName + lastName;
        System.out.print("Number of people: ");
        int numberOfPeople = scanner.nextInt();
        System.out.print("Bathroom (y/n): ");
        char bathroomChoice = scanner.next().charAt(0);
        boolean wantsBathroom = bathroomChoice == 'y';
        System.out.print("Number of days: ");
        int days = scanner.nextInt();

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (!room.isBooked && room.capacity >= numberOfPeople && room.hasBathroom == wantsBathroom) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            selectedRoom.isBooked = true;
            int roomId = rooms.indexOf(selectedRoom);
            System.out.println("Your room number is " + roomId + " price per night: " + selectedRoom.price);

            Map<Integer, Integer> daysMap = new HashMap<>();
            daysMap.put(roomId, days);
            Map<String, Map<Integer, Integer>> booking = new HashMap<>();
            booking.put(fullName, daysMap);
            bookings.add(booking);
        } else {
            System.out.println("No rooms available that meet your criteria.");
        }
    }

    public void calculatePayment() {
        System.out.print("Room number: ");
        int roomNumber = scanner.nextInt();
        for (Map<String, Map<Integer, Integer>> booking : bookings) {
            for (Map.Entry<String, Map<Integer, Integer>> entry : booking.entrySet()) {
                String customer = entry.getKey();
                Map<Integer, Integer> roomInfo = entry.getValue();
                if (roomInfo.containsKey(roomNumber)) {
                    int daysBooked = roomInfo.get(roomNumber);
                    double totalCost = rooms.get(roomNumber).price * daysBooked;
                    System.out.println(customer + ", you need to pay: " + totalCost);
                    rooms.get(roomNumber).isBooked = false;
                    return;
                }
            }
        }
        System.out.println("Room not found or not booked.");
    }
}
