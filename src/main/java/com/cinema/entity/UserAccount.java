package com.cinema.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity

@NoArgsConstructor

@Getter
@Setter
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;

    @Override
    public String toString() {
        return "UserAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
