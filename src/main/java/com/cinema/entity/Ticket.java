package com.cinema.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Ticket extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    private int rowNumber;
    private int seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;

    @Override
    public String toString() {
        return "Ticket{" +
                "dateTime=" + dateTime +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
