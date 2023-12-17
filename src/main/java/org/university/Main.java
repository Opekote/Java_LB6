package org.university;

import static org.university.Cinema.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        initializeSeats();
        bookSeats(1, 2, new int[]{5, 6, 7});
        bookSeats(1, 2, new int[]{6, 7, 8});
        cancelBooking(1, 2, new int[]{6, 7, 8});
        checkAvailability(1, 3);
        printSeatingArrangement(1);
    }
}