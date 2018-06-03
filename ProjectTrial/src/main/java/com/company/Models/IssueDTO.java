package com.company.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "ISSUE")
public class IssueDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBook")
    private BookDTO book;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private UserDTO user;

    //czas w formacie yyyy-MM-dd-HH-mm-ss.
    private LocalDateTime reservationDate;// data rezerwacji
    private LocalDateTime issueDate;// data wydania egzemplarza
    private LocalDateTime returnDate;//data zwrotu egzemplarza



    public IssueDTO() {
    }

    public IssueDTO(BookDTO book, UserDTO user, LocalDateTime reservationDate, LocalDateTime issueDate, LocalDateTime returnDate) {
        this.book = book;
        this.user = user;
        this.reservationDate = reservationDate;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
