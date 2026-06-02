package com.algebra1recap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class Test {

    public enum Difficulty { EASY, MEDIUM, HARD }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String category;

    @Column(length = 500)
    private String description;

    public Test() {}

    public Test(String name, Difficulty difficulty, String category, String description) {
        this.name = name;
        this.difficulty = difficulty;
        this.category = category;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
