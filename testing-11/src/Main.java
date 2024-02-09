public class Main {
    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        while (true) {
            displayMenu();
            int choice = hotelManager.scanner.nextInt();
            switch (choice) {
                case 1:
                    hotelManager.displayAvailableRooms();
                    break;
                case 2:
                    hotelManager.makeReservation();
                    break;
                case 3:
                    hotelManager.calculatePayment();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    private static void displayMenu() {
        System.out.println("Welcome to our hotel:");
        System.out.println("1. Available rooms");
        System.out.println("2. Make a reservation");
        System.out.println("3. Calculate payment");
        System.out.println("6. Exit");
    }
}