package com.example.membership.dto;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserMemberships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userMembershipId;

    @Nonnull
    private long userId;

    @Nonnull
    private long membershipId;

    @CreatedDate
    private String registeredAt;

}
