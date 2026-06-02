package com.algebra1recap.repository;

import com.algebra1recap.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    List<Badge> findByUserIdOrderByEarnedAtDesc(Long userId);
    boolean existsByUserIdAndBadgeName(Long userId, String badgeName);
}
