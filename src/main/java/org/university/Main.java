package org.university;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5,10,20);
        cinema.bookSeats(1, 2, new int[]{5, 6, 7});
        cinema.bookSeats(1, 2, new int[]{5, 6, 7});
        cinema.cancelBooking(1, 2, new int[]{6, 7, 8});
        cinema.checkAvailability(1, 3);
        cinema.printSeatingArrangement(1);
        cinema.findBestAvailable(1,2);
        cinema.autoBook(1,2);

    }
}