package koios.ivana.josipovgablec.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity

public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long booking_id;  //todo: prebaciti int id u LONG
        @NotNull
        private String name;
        @NotNull
        private String email;
        @NotNull
        private String mobile;
        @NotNull
        private LocalDateTime dateTime;
        @NotNull
        private int guests;



        // Napravim 2 ctora da mi je lakše dohvaćati podatke u klasi Servis.java
        // Jedan prima sve, a drugi ništa zbog Springa
        public Booking(Long booking_id, String name, String email, String mobile, LocalDateTime dateTime, int guests) {
            this.booking_id = booking_id;
            this.name = name;
            this.email = email;
            this.dateTime = dateTime;
            this.mobile = mobile;
            this.guests = guests;
        }

        public Booking() {
        }

        public Long getBooking_id() {return booking_id;}
        public void setBooking_id(Long booking_id) {this.booking_id = booking_id;}

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public String getEmail() {return email;}
        public void setEmail(String email) {this.email = email;}

        public String getMobile() {return mobile;}
        public void setMobile(String mobile) {this.mobile = mobile;}

        @JsonGetter
        public LocalDateTime getDateTime() {return dateTime;}
        @Autowired
        public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}

        public int getGuests() {return guests;}
        public void setGuests(int guests) {this.guests = guests;}

}