package com.algebra1recap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "badge")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String badgeName;
    private String badgeEmoji;

    @Column(length = 500)
    private String badgeDescription;

    private LocalDateTime earnedAt;

    public Badge() {}

    public Badge(Long userId, String badgeName, String badgeEmoji, String badgeDescription) {
        this.userId = userId;
        this.badgeName = badgeName;
        this.badgeEmoji = badgeEmoji;
        this.badgeDescription = badgeDescription;
        this.earnedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getBadgeName() { return badgeName; }
    public void setBadgeName(String badgeName) { this.badgeName = badgeName; }
    public String getBadgeEmoji() { return badgeEmoji; }
    public void setBadgeEmoji(String badgeEmoji) { this.badgeEmoji = badgeEmoji; }
    public String getBadgeDescription() { return badgeDescription; }
    public void setBadgeDescription(String badgeDescription) { this.badgeDescription = badgeDescription; }
    public LocalDateTime getEarnedAt() { return earnedAt; }
    public void setEarnedAt(LocalDateTime earnedAt) { this.earnedAt = earnedAt; }
}
