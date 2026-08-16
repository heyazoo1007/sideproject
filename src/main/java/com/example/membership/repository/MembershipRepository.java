package com.example.membership.repository;

import com.example.membership.dto.Memberships;
import com.example.membership.dto.UserMemberships;
import com.example.membership.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Users, Long> {

    void save(UserMemberships userMemberships);

    Optional<Memberships> getMembershipsByMembershipId(long id);

    Optional<UserMemberships> getUserMembershipsByUserIdAndMembershipId(long userId, long membershipId);


}
