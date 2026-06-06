package com.algebra1recap.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.algebra1recap.model.Question;
import com.algebra1recap.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@Order(1)
public class DataLoader implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    public DataLoader(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {
        // Only reloads practice questions (the 'question' table).
        // NEVER touches user data (app_user, test_result, user_answer, badge).
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/questions.json").getInputStream();
            List<Question> questions = mapper.readValue(is, new TypeReference<List<Question>>() {});

            long currentCount = questionRepository.count();
            if (currentCount == questions.size()) {
                System.out.println("Practice questions already up to date (" + currentCount + ")");
                return;
            }

            // Questions changed — reload only the question table (user data untouched)
            questionRepository.deleteAll();
            questionRepository.saveAll(questions);
            System.out.println("Reloaded " + questions.size() + " practice questions (was " + currentCount + "). User data preserved.");
        } catch (Exception e) {
            System.err.println("Failed to load questions: " + e.getMessage());
        }
    }
}
