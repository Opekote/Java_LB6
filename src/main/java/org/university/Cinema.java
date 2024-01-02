package org.university;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cinema {
    // 3D array to represent the cinema halls, rows, and seats
    private final int[][][] cinemaSeats;

    // Method to initialize the array with zeros
    public Cinema (int halls,int rows,int seats){
        this.cinemaSeats = new int[halls][rows][seats];
    }

    // Method to book seats
    public boolean bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaSeats[hallNumber][row][seat] == 0) {
                cinemaSeats[hallNumber][row][seat] = 1; // 1 represents a booked seat
                System.out.println("Seat booked: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            } else {
                System.out.println("Some of requested seats are already booked.Please choose another seats!");
                return false;
            }

        }
        return true;

    }

    // Method to cancel booking
    public boolean cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaSeats[hallNumber][row][seat] == 1) {
                cinemaSeats[hallNumber][row][seat] = 0; // 0 represents an available seat
                System.out.println("Booking canceled: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            } else {
                System.out.println("No booking found for seat " + seat + " .Ensure the correctness of data for");
                return false;
            }
        }
        return true;
    }

    // Method to check availability of consecutive seats
    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int i = 0; i < cinemaSeats[hallNumber].length; i++) {
            int consecutiveSeats = 0;
            for (int j = 0; j < cinemaSeats[hallNumber][i].length; j++) {
                if (cinemaSeats[hallNumber][i][j] == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        System.out.println("Consecutive seats available in Hall " + hallNumber + ", Row " + i);
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                    System.out.println("Consecutive seats not available in Hall " + hallNumber);
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Seating arrangement for Hall " + hallNumber + ":");

        System.out.println("     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");

        for (int i = 0; i < cinemaSeats[hallNumber].length; i++) {
            // Showing number of a row
            System.out.printf("%2d | ", i+1);

            // Showing Seats in a row
            for (int j = 0; j < cinemaSeats[hallNumber][i].length; j++) {
                if (j >= 9){
                    System.out.printf("%2d ", cinemaSeats[hallNumber][i][j]);
                }
                else {
                    System.out.print(cinemaSeats[hallNumber][i][j] + " ");
                }
            }
            System.out.printf("| %2d", i);

            System.out.println();

        }
        System.out.println("     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");

    }

    public List<int[]> findBestAvailable(int hallNumber, int numSeats) {
        List<int[]> bestSeats = new ArrayList<>();

        for (int i = 0; i < cinemaSeats[hallNumber].length; i++) {
            for (int j = 0; j <= cinemaSeats[hallNumber][i].length - numSeats; j++) {
                boolean seatsAvailable = true;

                // Checking availability of seats
                for (int k = j; k < j + numSeats; k++) {
                    if (cinemaSeats[hallNumber][i][k] != 0) {
                        seatsAvailable = false;
                        break;
                    }
                }

                // If seats available, adding them to list
                if (seatsAvailable) {
                    int[] seatRange = new int[numSeats];
                    for (int k = 0; k < numSeats; k++) {
                        seatRange[k] = j + k;
                    }
                    int[] seatInfo = new int[numSeats + 1]; //Creating a new array to save there info about row and seat numbers
                    seatInfo[0] = i; // Row number
                    System.arraycopy(seatRange, 0, seatInfo, 1, numSeats); // Copying seatRange to seatInfo
                    bestSeats.add(seatInfo);
                }
            }
        }
        System.out.println("Seats was found!");
        return bestSeats;
    }

    public boolean autoBook(int hallNumber, int numSeats) {
        List<int[]> bestSeats = findBestAvailable(hallNumber, numSeats);

        if (!bestSeats.isEmpty()) {
            // Booking first best place
            int[] seatInfo = bestSeats.get(0); //Using first result as best available
            int row = seatInfo[0]; //getting info about row. (We are using first element in our array as a row number)
            int[] seats = Arrays.copyOfRange(seatInfo,1,seatInfo.length);
            System.out.println(Arrays.toString(seats));
            bookSeats(hallNumber, row, seats);



            System.out.println("Successfully booked " + numSeats + " seats in Hall " + hallNumber + " row " + row + " seats " + Arrays.toString(seats));
            return true;
        } else {
            System.out.println("Sorry, there are no available seats for " + numSeats + " in Hall " + hallNumber + ".");
            return false;
        }
    }
    }
