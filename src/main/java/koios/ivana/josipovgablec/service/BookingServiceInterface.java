package koios.ivana.josipovgablec.service;

import koios.ivana.josipovgablec.model.Booking;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookingServiceInterface extends PagingAndSortingRepository<Booking, Long> {
//    Booking registerNewBooking(Booking booking) throws Exception;
}