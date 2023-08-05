package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class LoginHistoryServiceImpl {
    private final LoginHistoryRepository loginHistoryRepository;

    public LoginHistory saveLoginHistory(
            String userId,
            String ipAddress,
            String userAgent
    ) {
        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .loginTime(LocalDateTime.now())
                .build();
        return loginHistoryRepository.save(loginHistory);
    }
}
