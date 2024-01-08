# Cinema Application
This Java application simulates a cinema with multiple halls, rows, and seats. It provides functionality for booking and canceling seats, 
checking seat availability, printing seating arrangements, finding the best available seats, and automatically booking them.

## Cinema Class

### Methods

- bookSeats(int hallNumber, int row, int[] seats): boolean Books the specified seats in the given hall and row. Returns true if booking is successful, false otherwise.
- cancelBooking(int hallNumber, int row, int[] seats): boolean Cancels the booking for the specified seats in the given hall and row. Returns true if cancellation is successful, false otherwise.
- checkAvailability(int hallNumber, int numSeats): boolean Checks if the specified number of consecutive seats is available in any row of the given hall. Returns true if seats are available, false otherwise.
- printSeatingArrangement(int hallNumber): void Prints the seating arrangement for the specified hall, indicating booked and available seats.
- findBestAvailable(int hallNumber, int numSeats): int[] Finds and returns the best available consecutive seats for the specified number in the given hall. Returns an array with seat information if available, or an array with a single element {0} if no seats are found.
- autoBook(int hallNumber, int numSeats): boolean Automatically books the best available consecutive seats for the specified number in the given hall. Returns true if booking is successful, false otherwise.

## CinemaTest Class

### Methods

- setUp(): void Initializes the Cinema object before each test.
- bookSeatsTest(): void Tests the bookSeats method.
- bookInvalidSeatsTest(): void Tests booking invalid seats after some seats have already been booked.
- cancelBookingTest(): void Tests the cancelBooking method.
- invalidCancelBookingTest(): void Tests canceling invalid bookings.
- checkAvailabilityTest(): void Tests the checkAvailability method.
- printSeatingArrangement(): void Tests the printSeatingArrangement method.
- findBestAvailableTest(): void Tests the findBestAvailable method.
- autoBookTest(): void Tests the autoBook method.
