package koios.ivana.josipovgablec.service;

import koios.ivana.josipovgablec.model.Booking;
import koios.ivana.josipovgablec.repository.BookingRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BookingService implements BookingServiceInterface { //ctor;

    @Autowired
    private final BookingRepository bookingRepository;
    public BookingService(BookingRepository bookingRepository) {  //ctor
        this.bookingRepository = bookingRepository;// todo: treba li ovo dvoje biti u istom ctoru? ili ne?
    }

    public String saveBooking(Booking booking) {
        bookingRepository.save(new Booking(0L, "Ivana", "ivana.bubalo@gmail.com",
                "+385995023538", LocalDateTime.of(2022, 8, 8, 14, 00), 4));
        return "Successful booking";
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public boolean availableToday(Booking booking) throws Exception {
//        if(booking.getDateTime() == null){
//            throw new Exception("You didn't provide date time");
//        }

        List<Booking> bookToday = bookingRepository.findBookingByDateTime(booking.getDateTime());
        List<Booking> bookToday_2hours = bookingRepository.findBookingByDateTime(booking.getDateTime().plusHours(2));
        return bookToday_2hours.size() - bookToday.size() >= 0 && bookToday.size() < 15;
        // ako je u odabranom vremenu bookirano <15 bukinga i u naredna 2 sata će ostati isti broj slobodnih stolova (ili će se smanjiti), stol je available

    }

    public Booking registerNewBooking(Booking booking) throws Exception {
        if (!availableToday(booking)){
            throw new Exception();
        }
        booking.setName(booking.getName());
        booking.setEmail(booking.getEmail());
        booking.setMobile(booking.getMobile());
        booking.setDateTime(booking.getDateTime());
        booking.setGuests(booking.getGuests());
        return bookingRepository.save(booking);
    }


    @Override
    public Iterable<Booking> findAll(Sort sort) {
        return null;
    }
    @Override
    public Page<Booking> findAll(Pageable pageable) {
        return null;
    }
    @Override
    public <S extends Booking> S save(S entity) { return null; }
    @Override
    public <S extends Booking> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    @Override
    public Optional<Booking> findById(Long aLong) {
        return Optional.empty();
    }
    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
    @Override
    public Iterable<Booking> findAll() {
        return null;
    }
    @Override
    public Iterable<Booking> findAllById(Iterable<Long> longs) {
        return null;
    }
    @Override
    public long count() {
        return 0;
    }
    @Override
    public void deleteById(Long aLong) {    }
    @Override
    public void delete(Booking entity) {    }
    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {    }
    @Override
    public void deleteAll(Iterable<? extends Booking> entities) {    }
    @Override
    public void deleteAll() { }


    // todo: naprwavbiti spremanje u bazu iz web app-a => getteri



}
