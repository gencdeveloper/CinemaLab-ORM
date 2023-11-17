package com.cinema.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Cinema extends BaseEntity{

    private String name;
    private String sponsoredName;

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", sponsoredName='" + sponsoredName + '\'' +
                '}';
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
