package com.cinema.entity;

import com.cinema.enums.MovieState;
import com.cinema.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Entity

@NoArgsConstructor
@Data
public class Movie extends BaseEntity{
    private Integer duration;
    private String name;
    private BigDecimal price;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Column(columnDefinition = "text")
    private String summary;



    @ManyToMany
    @JoinTable(
            name = "MovieGenreRel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

}
