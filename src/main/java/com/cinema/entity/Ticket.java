package com.cinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@NoArgsConstructor
@Data
public class Ticket extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    private int rowNumber;
    private int seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;
}
