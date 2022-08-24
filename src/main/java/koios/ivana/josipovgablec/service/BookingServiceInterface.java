package koios.ivana.josipovgablec.service;

import koios.ivana.josipovgablec.model.Booking;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookingServiceInterface /*extends PagingAndSortingRepository<Booking, Long>*/ {
    Booking registerNewBooking(Booking booking) throws Exception;

    List<Booking> getAllBookings();


//    List<Booking> getAllBookings(Booking booking) ;
    
}