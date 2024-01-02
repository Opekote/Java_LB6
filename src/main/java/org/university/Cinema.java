package org.university;

import java.util.Arrays;

public class Cinema {
    // 3D array to represent the cinema halls, rows, and seats
    private final int[][][] cinemaSeats;

    // Method to initialize the array with zeros
    public Cinema (int halls,int rows,int seats){
        this.cinemaSeats = new int[halls][rows][seats];
    }

    // Method to book seats.Doing subtraction of 1 to not confuse user.
    // They probably don't know that in PC world everything starts from 0
    public boolean bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaSeats[hallNumber-1][row-1][seat-1] == 0) {
                cinemaSeats[hallNumber-1][row-1][seat-1] = 1; // 1 represents a booked seat
                System.out.println("Seat booked: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            } else {
                System.out.println("Some of requested seats are already booked.Please choose another seats!");
                return false;
            }

        }
        return true;

    }

    // Method to cancel booking.Doing subtraction of 1 to not confuse user.
    // They probably don't know that in PC world everything starts from 0
    public boolean cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaSeats[hallNumber-1][row-1][seat-1] == 1) {
                cinemaSeats[hallNumber-1][row-1][seat-1] = 0; // 0 represents an available seat
                System.out.println("Booking canceled: Hall " + hallNumber + ", Row " + row + ", Seat " + seat);
            } else {
                System.out.println("No booking found for seat." + seat + " Ensure the correctness of data");
                return false;
            }
        }
        return true;
    }

    // Method to check availability of consecutive seats
    // Doing subtraction of 1 to not confuse user.
    // They probably don't know that in PC world everything starts from 0
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

    //Doing subtraction of 1 to not confuse user.
    // They probably don't know that in PC world everything starts from 0
    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Seating arrangement for Hall " + hallNumber + ":");

        System.out.println("     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");

        for (int i = 0; i < cinemaSeats[hallNumber-1].length; i++) {
            // Showing number of a row
            System.out.printf("%2d | ", i+1);

            // Showing Seats in a row
            for (int j = 0; j < cinemaSeats[hallNumber-1][i].length; j++) {
                if (j >= 9){
                    System.out.printf("%2d ", cinemaSeats[hallNumber-1][i][j]);
                }
                else {
                    System.out.print(cinemaSeats[hallNumber-1][i][j] + " ");
                }
            }
            System.out.printf("| %2d", i);

            System.out.println();

        }
        System.out.println("     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");

    }

    // Doing subtraction of 1 to not confuse user.
    // They probably don't know that in PC world everything starts from 0
    public int[] findBestAvailable(int hallNumber, int numSeats) {
        int[] noSeatsFoundArr = new int[]{0};

        for (int i = 0; i < cinemaSeats[hallNumber-1].length; i++) {
            for (int j = 0; j <= cinemaSeats[hallNumber-1][i].length - numSeats; j++) {
                boolean seatsAvailable = true;

                // Checking availability of seats
                for (int k = j; k < j + numSeats; k++) {
                    if (cinemaSeats[hallNumber-1][i][k] != 0) {
                        seatsAvailable = false;
                        break;
                    }
                }

                // If seats available, adding them to list
                if (seatsAvailable) {
                    int[] seatRange = new int[numSeats];
                    for (int k = 0; k < numSeats; k++) {
                        seatRange[k] = j + k + 1;
                    }
                    int[] seatInfo = new int[numSeats + 1]; //Creating a new array to save there info about row and seat numbers
                    seatInfo[0] = i+1; // Row number
                    System.arraycopy(seatRange, 0, seatInfo, 1, numSeats); // Copying seatRange to seatInfo
                    System.out.println("Seats was found!" + "Row is " + seatInfo[0]
                            + " Seat numbers are " + Arrays.toString(Arrays.copyOfRange(seatInfo, 1, seatInfo.length)));
                    return seatInfo;
                }
            }
        }

        return noSeatsFoundArr;
    }

    // Doing subtraction of 1 to not confuse user.
    // They probably don't know that in PC world everything starts from 0
    public boolean autoBook(int hallNumber, int numSeats) {
        int[] bestSeats = findBestAvailable(hallNumber, numSeats);

        if (!Arrays.equals(bestSeats, new int[]{0})) {
            // Booking first best place
            int row = bestSeats[0]; //getting info about row. (We are using first element in our array as a row number)
            int[] seats = Arrays.copyOfRange(bestSeats,1,bestSeats.length);
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
