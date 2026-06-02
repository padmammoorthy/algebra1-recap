# Algebra 1 Recap

An interactive Algebra 1 quiz application based on the **Envision Algebra 1** textbook. Built with Spring Boot, Thymeleaf, and H2/PostgreSQL.

---

## Features

- **Student Portal** — Lessons, practice tests, timed tests, and badges
- **Parent Portal** — Monitor student activity, scores, and progress
- **50 Lessons** across 11 chapters with worked examples and SVG illustrations
- **500 Practice Test Questions** — paginated with numbered page navigation
- **9 Timed Tests** — Easy, Medium, Hard with 50 questions each
- **Badge System** — 9 achievements for encouragement
- **Persistent Data** — User accounts and scores survive restarts and redeployments

---

## Table of Contents

1. [Getting Started](#getting-started)
2. [Student Guide](#student-guide)
3. [Parent Guide](#parent-guide)
4. [Chapters and Lessons](#chapters-and-lessons)
5. [Deployment](#deployment)
6. [Configuration](#configuration)
7. [Adding Content](#adding-content)

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Run Locally

```bash
mvn clean package -DskipTests
java -jar target/algebra1-recap-0.0.1-SNAPSHOT.jar
```

Open http://localhost:8080

### Build JAR

```bash
mvn clean package -DskipTests
```

Output: `target/algebra1-recap-0.0.1-SNAPSHOT.jar`

---

## Student Guide

### Sign Up and Login

1. Open the app — you'll see the Portal Selection page
2. Click the **Student Portal** card
3. Click "Sign up" to create an account
   - Choose a username and password (min 4 characters)
   - Pick a display name
   - Select an emoji avatar or provide an image URL
4. Log in with your credentials

### Navigation

The left sidebar has four sections:

| Icon | Section | Description |
|------|---------|-------------|
| 🎓 | Lessons | Study material organized by chapter |
| ✏️ | Practice Test | 500 questions with instant feedback |
| 📝 | Tests | Timed tests scored for progress |
| 🏆 | Badges | Achievements you've earned |

### Lessons

- Lessons are organized into 11 chapters
- The **Table of Contents** sidebar lets you jump to any lesson directly
- Each lesson includes:
  - Description of the concept
  - SVG illustration
  - 5 worked examples with step-by-step solutions
  - Key takeaways

### Practice Test

- 500 questions covering all 50 lessons
- 5 questions per page with numbered page navigation
- Click an answer to check immediately
- ✅ Correct answers highlighted in green
- ❌ Wrong answers show the correct answer and a hint
- Progress bar shows your position
- Questions labeled with their lesson name

### Tests

- 9 tests organized by difficulty:
  - **Easy** (3 tests) — Foundational concepts
  - **Medium** (3 tests) — Intermediate problem solving
  - **Hard** (3 tests) — Advanced multi-step problems
- Each test has 50 questions, paginated 5 per page
- Submit when done — scores are calculated automatically
- 70% required to pass
- Solution explanations shown for incorrect answers

### Badges

Earn badges for milestones:

| Badge | Name | How to Earn |
|-------|------|-------------|
| 🌟 | First Steps | Complete your first test |
| ⚡ | Quick Learner | 80%+ on an easy test |
| ⚔️ | Math Warrior | 80%+ on a medium test |
| 🧠 | Math Genius | 80%+ on a hard test |
| 💯 | Perfect Score | 100% on any test |
| 🎩 | Hat Trick | Complete 3 tests |
| 🔥 | Unstoppable | Complete 5 tests |
| 📚 | Dedicated Scholar | Complete 10 tests |
| ⭐ | Perfectionist | Get 3 perfect scores |

### Sign Out

Click your profile name (top-right) → "Sign Out" → returns to portal page.

---

## Parent Guide

### Sign Up and Login

1. Click the **Parent Portal** card on the portal page
2. Sign up with a parent account (separate from student accounts)
3. Log in to access the dashboard

### Dashboard

The parent dashboard shows:

- **Total Students** — Number of registered student accounts
- **Tests Taken** — Total tests completed by all students
- **Average Score** — Overall average percentage across all tests
- **Pass Rate** — Percentage of tests passed (70%+ threshold)

### Student Cards

Each student displayed with:
- Display name and avatar
- Number of tests completed
- Average score
- Last activity timestamp
- Badge count

### Recent Activity Feed

- Chronological list of test completions
- Shows: student name, test name, difficulty, score, pass/fail

### Access Control

- Parents cannot log in via the Student Portal
- Students cannot log in via the Parent Portal
- Parent and student usernames must be different

---

## Chapters and Lessons

| Chapter | Lessons |
|---------|---------|
| **Ch 1: Solving Equations and Inequalities** | 1-1 Solving Equations, 1-2 Literal Equations, 1-3 Inequalities, 1-4 Compound Inequalities, 1-5 Absolute Value Equations, 1-6 Absolute Value Inequalities |
| **Ch 2: Linear Equations** | 2-1 Slope and Rate of Change, 2-2 Slope-Intercept Form, 2-3 Point-Slope Form, 2-4 Standard Form, 2-5 Parallel and Perpendicular Lines |
| **Ch 3: Linear Functions** | 3-1 Relations and Functions, 3-2 Linear Functions, 3-3 Transforming Linear Functions, 3-4 Arithmetic Sequences, 3-5 Scatter Plots |
| **Ch 4: Systems of Linear Equations** | 4-1 Solving by Graphing, 4-2 Solving by Substitution, 4-3 Solving by Elimination, 4-4 Linear Inequalities (2 var), 4-5 Systems of Inequalities |
| **Ch 5: Piecewise Functions** | 5-1 Piecewise Functions, 5-2 Step Functions, 5-3 Absolute Value Functions |
| **Ch 6: Exponential Functions** | 6-1 Exponential Growth, 6-2 Exponential Decay, 6-3 Geometric Sequences, 6-4 Exponential Models |
| **Ch 7: Polynomials and Factoring** | 7-1 Adding/Subtracting, 7-2 Multiplying, 7-3 Special Products, 7-4 Factoring GCF, 7-5 Factoring (a=1), 7-6 Factoring (a≠1), 7-7 Special Cases |
| **Ch 8: Quadratic Functions** | 8-1 Graphing Standard Form, 8-2 Graphing Vertex Form, 8-3 Modeling |
| **Ch 9: Solving Quadratic Equations** | 9-1 By Graphing, 9-2 By Factoring, 9-3 Completing the Square, 9-4 Quadratic Formula, 9-5 Choosing a Method |
| **Ch 10: Radical Expressions** | 10-1 Square Root Functions, 10-2 Simplifying Radicals, 10-3 Operations, 10-4 Solving Radical Equations |
| **Ch 11: Data Analysis** | 11-1 Measures of Center/Spread, 11-2 Box Plots, 11-3 Two-Way Tables |

---

## Deployment

### AWS Elastic Beanstalk

1. Build: `mvn clean package -DskipTests`
2. Upload `target/algebra1-recap-0.0.1-SNAPSHOT.jar` to EB
3. Platform: **Corretto 17 running on 64bit Amazon Linux 2023**
4. Configuration → Software → Environment properties:

| Name | Value |
|------|-------|
| `SERVER_PORT` | `5000` |

That's the only required setting. Without it you'll get a 502 error.

### Optional Environment Variables

| Name | Value | Purpose |
|------|-------|---------|
| `DB_PATH` | `/var/app/data/algebra1db` | Persist data on EB |
| `SPRING_PROFILES_ACTIVE` | `prod` | Use PostgreSQL instead of H2 |
| `DB_HOST` | your RDS endpoint | PostgreSQL host |
| `DB_PORT` | `5432` | PostgreSQL port |
| `DB_NAME` | `algebra1db` | Database name |
| `DB_USERNAME` | your username | DB credentials |
| `DB_PASSWORD` | your password | DB credentials |

### Data Persistence

- Default: H2 file-based database (persists across restarts)
- `spring.jpa.hibernate.ddl-auto=update` — never drops tables
- DataLoader only seeds questions if database is empty
- User accounts persist across redeployments

---

## Configuration

### application.properties (Development)

```properties
spring.datasource.url=jdbc:h2:file:${DB_PATH:./data/algebra1db};DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
server.port=${PORT:8080}
```

### application-prod.properties (Production)

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT:5432}/${DB_NAME}
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

---

## Adding Content

### Add Practice Questions

Edit `src/main/resources/data/questions.json`:

```json
{
  "questionText": "Solve: 2x + 5 = 13",
  "optionA": "x = 4",
  "optionB": "x = 9",
  "optionC": "x = 3",
  "optionD": "x = 6",
  "correctAnswer": "A",
  "hint": "Subtract 5, then divide by 2.",
  "lessonNumber": 1,
  "lessonTitle": "Solving Equations in One Variable",
  "topic": "Equations",
  "category": "ALGEBRA"
}
```

Delete the database file and restart to reload questions.

### Add Lessons

Edit `LessonContentService.java` — add entries in the `initializeLessons()` method.

### Add Tests

Edit `TestDataLoader.java` — add new `Test` objects and their `TestQuestion` entries.

---

## Tech Stack

| Component | Technology |
|-----------|-----------|
| Backend | Spring Boot 3.2.5 |
| Frontend | Thymeleaf + vanilla CSS |
| Security | Spring Security (BCrypt) |
| Database | H2 (dev) / PostgreSQL (prod) |
| Build | Maven |
| Java | 17 |
| Deployment | AWS Elastic Beanstalk |

---

## Repository

https://github.com/padmammoorthy/algebra1-recap
