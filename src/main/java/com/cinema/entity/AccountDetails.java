package com.cinema.entity;

import com.cinema.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
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
}
