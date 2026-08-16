package com.example.membership.service;

import com.example.membership.dto.Memberships;
import com.example.membership.dto.UserMemberships;
import com.example.membership.dto.Users;
import com.example.membership.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private MembershipRepository membershipRepository;

    public void registerUser(Users userDto, Memberships membershipDto) {

        // 1. 멤버십 등록된 사용자인지 확인(중복 등록 방지)
        Optional<UserMemberships> userMembership = membershipRepository.getUserMembershipsByUserIdAndMembershipId(userDto.getUserId(), membershipDto.getMembershipId());

        if (!userMembership.isEmpty()) {
            // you registered this membership already.
            return;
        }

        // 2. 멤버십 인원 마감전인지
        Optional<Memberships> membership = membershipRepository.getMembershipsByMembershipId(membershipDto.getMembershipId());
        if (membership.get().getTotalLimit() < membership.get().getCurrentCount()) {
            // membership is out of occupation.
            return;
        }

        // 3. 멤버십 증가
        UserMemberships userMembershipVO = new UserMemberships();
        userMembershipVO.setUserId(userDto.getUserId());
        userMembershipVO.setMembershipId(membershipDto.getMembershipId());
        membershipRepository.save(userMembershipVO);
    }
}
