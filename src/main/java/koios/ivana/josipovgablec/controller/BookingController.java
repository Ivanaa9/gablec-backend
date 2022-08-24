package koios.ivana.josipovgablec.controller;

import koios.ivana.josipovgablec.model.Booking;
import koios.ivana.josipovgablec.repository.BookingRepository;
import koios.ivana.josipovgablec.service.BookingServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // dopustam angular frontendu spoj na ovaj kontroler
public class BookingController {
    Logger logger = LoggerFactory.getLogger(BookingController.class);

//    @Autowired
    private BookingServiceInterface bookingService;
//    @Autowired
    private BookingRepository bookingRepository;

    public BookingController(BookingServiceInterface bookingService, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }

    private ResponseEntity throwNewError(Exception e){
        logger.error(e.getMessage());
        logger.error(e.getCause().toString());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/reservations")
    public List<Booking> getAllReservations() {
        logger.info("Inside @GetMapping(reservations) of BookingController");
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking")
    public List<Booking> getAllBookings() {
        logger.info("Inside @GetMapping(booking) of BookingController");
        return bookingService.getAllBookings();
    }

    @PostMapping("/reservations")
    public ResponseEntity<Booking> createNewReservation(@RequestBody Booking booking){
        logger.info("Inside @PostMapping(reservations) of BookingController");
        try {
            return new ResponseEntity<>(bookingService.registerNewBooking(booking), HttpStatus.OK);
        } catch (Exception e) {
            return throwNewError(e);
        }
    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> createNewBooking(@RequestBody Booking booking){
        logger.info("Inside @PostMapping(booking) of BookingController");
        try {
            return new ResponseEntity<>(bookingService.registerNewBooking(booking), HttpStatus.OK);
        } catch (Exception e) {
            return throwNewError(e);
        }
    }

}
