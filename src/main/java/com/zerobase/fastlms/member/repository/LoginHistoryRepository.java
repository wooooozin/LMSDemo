package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

    LoginHistory findByUserIdOrderByLoginTimeDesc(String userId);

    List<LoginHistory> findAllByUserIdOrderByLoginTimeDesc(String userId);
}
