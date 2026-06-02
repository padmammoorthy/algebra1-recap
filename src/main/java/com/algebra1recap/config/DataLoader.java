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
        if (questionRepository.count() > 0) return;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/questions.json").getInputStream();
            List<Question> questions = mapper.readValue(is, new TypeReference<List<Question>>() {});
            questionRepository.saveAll(questions);
            System.out.println("Loaded " + questions.size() + " practice questions");
        } catch (Exception e) {
            System.err.println("Failed to load questions: " + e.getMessage());
        }
    }
}
