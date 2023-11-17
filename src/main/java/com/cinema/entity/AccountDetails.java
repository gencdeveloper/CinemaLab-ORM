package com.cinema.entity;

import com.cinema.enums.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class AccountDetails extends BaseEntity{
    private String address;
    private int age;
    private String city;
    private String country;
    private String name;
    private String postalCode;
    @Enumerated(value = EnumType.STRING)
    private UserRole role = UserRole.USER;
    private String state;




    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;


    @Override
    public String toString() {
        return "AccountDetails{" +
                "address='" + address + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                ", state='" + state + '\'' +
                '}';
    }
}
