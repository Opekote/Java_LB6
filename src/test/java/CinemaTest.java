import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.university.Cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaTest {
    Cinema cinema;

    @BeforeEach
    void setUp(){
        cinema= new Cinema(5,10,20);
    }

    @Test
    void bookSeatsTest(){
        Assertions.assertTrue(cinema.bookSeats(5,10,new int[]{5,6,7}));
    }
    @Test
    void bookInvalidSeatsTest(){
        cinema.bookSeats(5,10,new int[]{5,6,7});
        Assertions.assertFalse(cinema.bookSeats(5,10,new int[]{5,6,7}));
    }

    @Test
    void cancelBookingTest(){
        cinema.bookSeats(5,10,new int[]{5,6,7});
        Assertions.assertTrue(cinema.cancelBooking(5,10,new int[]{5,6,7}));
    }

    @Test
    void invalidCancelBookingTest(){
        Assertions.assertFalse(cinema.cancelBooking(5,10,new int[]{5,6,7}));
    }

    @Test
    void checkAvailabilityTest(){
        Assertions.assertTrue(cinema.checkAvailability(1,2));
    }

    @Test
    void printSeatingArrangement(){
        cinema.bookSeats(1, 2, new int[]{5, 6, 7});
        cinema.printSeatingArrangement(1);
    }

//    @Test
//    void findBestAvailableTest(){
//
//
//        List<int[]> given = cinema.findBestAvailable(1,3);
//
//        List<int[]> expected = new ArrayList<>();
//        expected.add(new int[]{0,0,1,2});
//        Assertions.assertArrayEquals(expected.get(0),given.get(0));
//    }


    @Test
    void autoBookTest(){
        Assertions.assertTrue(cinema.autoBook(1,3));
    }

}
