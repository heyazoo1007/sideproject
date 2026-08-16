package com.example.membership.controller;

import com.example.membership.dto.Memberships;
import com.example.membership.dto.UserMemberships;
import com.example.membership.dto.Users;
import com.example.membership.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MembershipController {

    private MembershipService membershipService;

    @PostMapping("/api/memberships/register")
    public void registerUser(Users userDto, Memberships membershipDto) {
        membershipService.registerUser(userDto, membershipDto);
    }
}
