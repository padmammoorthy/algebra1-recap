package com.algebra1recap.config;

import com.algebra1recap.model.Test;
import com.algebra1recap.model.TestQuestion;
import com.algebra1recap.repository.TestRepository;
import com.algebra1recap.repository.TestQuestionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Order(2)
public class TestDataLoader implements CommandLineRunner {

    private final TestRepository testRepository;
    private final TestQuestionRepository testQuestionRepository;

    public TestDataLoader(TestRepository testRepository, TestQuestionRepository testQuestionRepository) {
        this.testRepository = testRepository;
        this.testQuestionRepository = testQuestionRepository;
    }

    @Override
    public void run(String... args) {
        // Only reload tests/test questions if none exist.
        // User data (app_user, test_result, user_answer, badge) is NEVER touched.
        if (testRepository.count() > 0) {
            System.out.println("Tests already loaded, skipping. User data preserved.");
            return;
        }

        // Create 9 tests: 3 easy, 3 medium, 3 hard + 1 olympiad
        List<Test> tests = new ArrayList<>(List.of(
            new Test("Algebra Basics - Easy 1", Test.Difficulty.EASY, "algebra", "Solving equations, inequalities, and linear functions"),
            new Test("Algebra Basics - Easy 2", Test.Difficulty.EASY, "algebra", "Functions, systems, and exponential models"),
            new Test("Algebra Basics - Easy 3", Test.Difficulty.EASY, "algebra", "Polynomials, quadratics, and data analysis"),
            new Test("Intermediate Algebra 1", Test.Difficulty.MEDIUM, "algebra", "Systems, quadratics, and functions"),
            new Test("Intermediate Algebra 2", Test.Difficulty.MEDIUM, "algebra", "Exponential models and sequences"),
            new Test("Intermediate Algebra 3", Test.Difficulty.MEDIUM, "algebra", "Polynomials and factoring mastery"),
            new Test("Advanced Algebra 1", Test.Difficulty.HARD, "algebra", "Complex quadratics and radicals"),
            new Test("Advanced Algebra 2", Test.Difficulty.HARD, "algebra", "Multi-step problem solving"),
            new Test("Advanced Algebra 3", Test.Difficulty.HARD, "algebra", "Comprehensive challenge"),
            new Test("Olympiad: Solving Linear Equations", Test.Difficulty.HARD, "olympiad", "50 problems: one-step through advanced multi-step equations and word problems"),
            new Test("Olympiad: Variables on Both Sides", Test.Difficulty.HARD, "olympiad", "25 problems: equations with variables on both sides, special cases, and applications"),
            new Test("Olympiad: Literal Equations & Formulas", Test.Difficulty.HARD, "olympiad", "20 problems: rearranging formulas, factoring for variable, multi-step literal equations"),
            new Test("Olympiad: Solving Inequalities", Test.Difficulty.HARD, "olympiad", "42 problems: one-step through multi-step inequalities and special cases")
        ));
        testRepository.saveAll(tests);

        // Load easy test questions from JSON file
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/test_questions.json").getInputStream();
            List<Map<String, Object>> jsonQuestions = mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});

            Long[] easyTestIds = {tests.get(0).getId(), tests.get(1).getId(), tests.get(2).getId()};
            int perTest = jsonQuestions.size() / 3; // 50 per test

            for (int i = 0; i < jsonQuestions.size(); i++) {
                Map<String, Object> jq = jsonQuestions.get(i);
                int testIdx = i / perTest;
                if (testIdx >= 3) testIdx = 2;

                TestQuestion tq = new TestQuestion();
                tq.setTestId(easyTestIds[testIdx]);
                tq.setQuestionText((String) jq.get("questionText"));
                tq.setOptionA((String) jq.get("optionA"));
                tq.setOptionB((String) jq.get("optionB"));
                tq.setOptionC((String) jq.get("optionC"));
                tq.setOptionD((String) jq.get("optionD"));
                tq.setCorrectAnswer((String) jq.get("correctAnswer"));
                tq.setHint((String) jq.get("hint"));
                tq.setSolutionExplanation((String) jq.get("solutionExplanation"));
                String svgType = (String) jq.get("svgType");
                if (svgType != null && !svgType.isEmpty()) {
                    tq.setIllustration(getSvg(svgType));
                } else {
                    tq.setIllustration(getSvg(tq.getQuestionText()));
                }
                testQuestionRepository.save(tq);
            }
            System.out.println("Loaded " + jsonQuestions.size() + " easy test questions from JSON");
        } catch (Exception e) {
            System.err.println("Could not load easy test JSON: " + e.getMessage());
        }

        // Load hard test questions from JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/hard_test_questions.json").getInputStream();
            List<Map<String, Object>> hardJson = mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});

            Long[] hardTestIds = {tests.get(6).getId(), tests.get(7).getId(), tests.get(8).getId()};
            int perTest = hardJson.size() / 3; // 50 per test

            for (int i = 0; i < hardJson.size(); i++) {
                Map<String, Object> jq = hardJson.get(i);
                int testIdx = i / perTest;
                if (testIdx >= 3) testIdx = 2;

                TestQuestion tq = new TestQuestion();
                tq.setTestId(hardTestIds[testIdx]);
                tq.setQuestionText((String) jq.get("questionText"));
                tq.setOptionA((String) jq.get("optionA"));
                tq.setOptionB((String) jq.get("optionB"));
                tq.setOptionC((String) jq.get("optionC"));
                tq.setOptionD((String) jq.get("optionD"));
                tq.setCorrectAnswer((String) jq.get("correctAnswer"));
                tq.setHint((String) jq.get("hint"));
                tq.setSolutionExplanation((String) jq.get("solutionExplanation"));
                String svgType = (String) jq.get("svgType");
                if (svgType != null && !svgType.isEmpty()) {
                    tq.setIllustration(getSvg(svgType));
                } else {
                    tq.setIllustration(getSvg(tq.getQuestionText()));
                }
                testQuestionRepository.save(tq);
            }
            System.out.println("Loaded " + hardJson.size() + " hard test questions from JSON");
        } catch (Exception e) {
            System.err.println("Could not load hard test JSON: " + e.getMessage());
        }

        // Generate questions for medium tests (indices 3, 4, 5)
        for (int t = 3; t <= 5; t++) {
            Test test = tests.get(t);
            List<TestQuestion> questions = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                questions.add(generateMediumQuestion(test.getId(), t, i));
            }
            testQuestionRepository.saveAll(questions);
        }

        // Load Olympiad test questions from JSON (index 9)
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/olympiad_questions.json").getInputStream();
            List<Map<String, Object>> olympiadJson = mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});

            Long olympiadTestId = tests.get(9).getId();
            java.util.Random rand = new java.util.Random(42);

            for (Map<String, Object> jq : olympiadJson) {
                TestQuestion tq = createShuffledQuestion(olympiadTestId, jq, rand);
                testQuestionRepository.save(tq);
            }
            System.out.println("Loaded " + olympiadJson.size() + " Olympiad test 1 questions from JSON");
        } catch (Exception e) {
            System.err.println("Could not load Olympiad test JSON: " + e.getMessage());
        }

        // Load Olympiad test 2 questions from JSON (index 10)
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/olympiad2_questions.json").getInputStream();
            List<Map<String, Object>> olympiad2Json = mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});

            Long olympiad2TestId = tests.get(10).getId();
            java.util.Random rand = new java.util.Random(77);

            for (Map<String, Object> jq : olympiad2Json) {
                TestQuestion tq = createShuffledQuestion(olympiad2TestId, jq, rand);
                testQuestionRepository.save(tq);
            }
            System.out.println("Loaded " + olympiad2Json.size() + " Olympiad test 2 questions from JSON");
        } catch (Exception e) {
            System.err.println("Could not load Olympiad test 2 JSON: " + e.getMessage());
        }

        // Load Olympiad test 3 questions from JSON (index 11)
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/olympiad3_questions.json").getInputStream();
            List<Map<String, Object>> olympiad3Json = mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});

            Long olympiad3TestId = tests.get(11).getId();
            java.util.Random rand = new java.util.Random(99);

            for (Map<String, Object> jq : olympiad3Json) {
                TestQuestion tq = createShuffledQuestion(olympiad3TestId, jq, rand);
                testQuestionRepository.save(tq);
            }
            System.out.println("Loaded " + olympiad3Json.size() + " Olympiad test 3 questions from JSON");
        } catch (Exception e) {
            System.err.println("Could not load Olympiad test 3 JSON: " + e.getMessage());
        }

        // Load Olympiad test 4 questions from JSON (index 12)
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new ClassPathResource("data/olympiad4_questions.json").getInputStream();
            List<Map<String, Object>> olympiad4Json = mapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});

            Long olympiad4TestId = tests.get(12).getId();
            java.util.Random rand = new java.util.Random(123);

            for (Map<String, Object> jq : olympiad4Json) {
                TestQuestion tq = createShuffledQuestion(olympiad4TestId, jq, rand);
                testQuestionRepository.save(tq);
            }
            System.out.println("Loaded " + olympiad4Json.size() + " Olympiad test 4 questions from JSON");
        } catch (Exception e) {
            System.err.println("Could not load Olympiad test 4 JSON: " + e.getMessage());
        }

        System.out.println("Loaded " + tests.size() + " tests");
    }

    private TestQuestion createShuffledQuestion(Long testId, Map<String, Object> jq, java.util.Random rand) {
        TestQuestion tq = new TestQuestion();
        tq.setTestId(testId);
        tq.setQuestionText((String) jq.get("questionText"));

        // Shuffle answer options
        String correctAns = (String) jq.get("correctAnswer");
        String[] options = {
            (String) jq.get("optionA"),
            (String) jq.get("optionB"),
            (String) jq.get("optionC"),
            (String) jq.get("optionD")
        };
        String correctText = options[correctAns.charAt(0) - 'A'];

        // Fisher-Yates shuffle
        for (int i = options.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = options[i];
            options[i] = options[j];
            options[j] = temp;
        }

        tq.setOptionA(options[0]);
        tq.setOptionB(options[1]);
        tq.setOptionC(options[2]);
        tq.setOptionD(options[3]);

        // Find where correct answer ended up
        for (int i = 0; i < 4; i++) {
            if (options[i].equals(correctText)) {
                tq.setCorrectAnswer(String.valueOf((char)('A' + i)));
                break;
            }
        }

        tq.setHint((String) jq.get("hint"));
        tq.setSolutionExplanation((String) jq.get("solutionExplanation"));
        tq.setIllustration(getSvg(tq.getQuestionText()));
        return tq;
    }

    private TestQuestion generateMediumQuestion(Long testId, int testIdx, int qIdx) {
        int seed = testIdx * 53 + qIdx * 7;
        String[] q = mediumQuestion(seed);
        TestQuestion tq = new TestQuestion();
        tq.setTestId(testId);
        tq.setQuestionText(q[0]);
        tq.setOptionA(q[1]);
        tq.setOptionB(q[2]);
        tq.setOptionC(q[3]);
        tq.setOptionD(q[4]);
        tq.setCorrectAnswer("A");
        tq.setHint(q[5]);
        tq.setSolutionExplanation(q[6]);
        tq.setIllustration(getSvg(q[0]));
        return tq;
    }

    private String[] mediumQuestion(int seed) {
        int a, b, c;
        switch (seed % 20) {
            case 0: a=3+seed%5; b=7+seed%6; return s("Solve: "+a+"(x-"+b+")="+(a*(12+seed%5-b)), "x="+(12+seed%5), "x="+(b+1), "x="+a, "x="+(12+seed%5+a), "Distribute then solve", a+"x-"+a*b+"="+(a*(12+seed%5-b))+", x="+(12+seed%5));
            case 1: a=2+seed%4; b=5+seed%4; return s("Factor: "+a+"x²+"+(a*b+a)+"x+"+b, "("+a+"x+"+b+")(x+1)", "("+a+"x+1)(x+"+b+")", "(x+"+b+")("+a+"x-1)", a+"(x+"+b+")", "Find factors that multiply to "+a*b, "Group and factor");
            case 2: a=4+seed%6; b=2+seed%4; c=a+b; return s("System: x+y="+c+", "+a+"x-y="+(a*a-b), "("+(a*a-b+c)/(a+1)+","+(c-(a*a-b+c)/(a+1))+")", "("+a+","+b+")", "("+c+",0)", "("+b+","+a+")", "Add equations to eliminate y", "("+(a+1)+"x)="+(c+a*a-b));
            case 3: a=3+seed%4; b=seed%8+2; return s("Vertex of y="+a+"x²-"+(2*a*b)+"x+"+(a*b*b-seed%5)+"?", "("+b+","+(-(seed%5))+")", "("+(-b)+","+(seed%5)+")", "("+b+","+(seed%5)+")", "("+(2*b)+",0)", "x=-b/(2a)="+b, "f("+b+")="+a+"("+b+")²-"+(2*a*b)+"("+b+")+"+(a*b*b-seed%5));
            case 4: a=2+seed%5; b=3+seed%4; return s("Simplify: √("+(a*a*b)+")", a+"√"+b, (a*b)+"", (a+b)+"", a+"√"+(b+1), "Find perfect square factor", a+"²×"+b+"="+(a*a*b)+", √="+a+"√"+b);
            case 5: a=5+seed%8; b=a+3+seed%5; return s("Arithmetic sequence: a₁="+a+", d=3. Find a₁₀", ""+(a+27), ""+(a+30), ""+(a+9), ""+(10*a), "aₙ=a₁+(n-1)d", a+"+9(3)="+(a+27));
            case 6: a=3+seed%4; b=2+seed%3; return s("Solve: "+a+"x²-"+(a*b*b)+"=0", "x=±"+b, "x="+b+" only", "x=±"+(b+1), "x=0", a+"x²="+(a*b*b)+", x²="+b*b, "x=±√("+b*b+")=±"+b);
            case 7: a=4+seed%5; return s("Slope perpendicular to y="+a+"x-3?", "-1/"+a, ""+a, "1/"+a, "-"+a, "Negative reciprocal", "m₁×m₂=-1");
            case 8: a=500+seed*100; b=80+seed%10; return s("Exponential decay: y="+a+"(0."+b+")^t. Value at t=2?", ""+((int)(a*(b/100.0)*(b/100.0))), ""+a, ""+(a*2), ""+((int)(a*b/100.0)), "Substitute t=2", a+"×(0."+b+")²");
            case 9: a=2+seed%4; b=7+seed%5; return s("Factor: x²-"+(a+b)+"x+"+(a*b), "(x-"+a+")(x-"+b+")", "(x+"+a+")(x+"+b+")", "(x-"+a+")(x+"+b+")", "(x+"+(a*b)+")(x-1)", "Product="+a*b+", sum="+(a+b), "Factors: "+a+" and "+b);
            case 10: a=2+seed%3; b=3+seed%4; c=a*b; return s("f(x)="+a+"x+"+b+". Find x when f(x)="+(c+b), "x="+c/a, "x="+(c+b), "x="+b, "x="+a, a+"x+"+b+"="+(c+b), a+"x="+c+", x="+c/a);
            case 11: a=3+seed%5; b=a+2; return s("Solve: |"+a+"x-"+(a*2)+"|="+(b*a), "x="+(2+b)+",x="+(2-b), "x="+(a+b), "x="+(2+b)+" only", "x=0", "|"+a+"x-"+(a*2)+"|="+(b*a)+", two cases", a+"x-"+(a*2)+"=±"+(b*a));
            case 12: a=3+seed%4; b=seed%6+2; return s("Geometric: a₁="+a+", r="+b+". Find a₅", ""+(a*(int)Math.pow(b,4)), ""+(a*5*b), ""+(a+4*b), ""+(a*(int)Math.pow(b,5)), "aₙ=a₁×rⁿ⁻¹", a+"×"+b+"⁴="+(a*(int)Math.pow(b,4)));
            case 13: a=2+seed%4; b=5+seed%5; return s("Solve: √("+a+"x+"+b+")="+(seed%4+3), "x="+((seed%4+3)*(seed%4+3)-b)/a, "x="+(seed%4+3), "x="+b, "x="+a, "Square both sides", a+"x+"+b+"="+(seed%4+3)*(seed%4+3));
            case 14: a=6+seed%8; b=a/2; return s("Solve system: 2x+3y="+a+", x-y="+b, "("+((a+3*b)/5)+","+((a-2*b)/5)+")", "("+a+","+b+")", "("+b+",0)", "(0,"+a/3+")", "Substitution or elimination", "x="+b+"+y, substitute");
            case 15: a=4+seed%5; b=3+seed%4; return s("Simplify: ("+a+"x³)("+b+"x²)", (a*b)+"x⁵", (a*b)+"x⁶", (a+b)+"x⁵", (a*b)+"x", "Multiply coefficients, add exponents", a+"×"+b+"="+(a*b)+", x^(3+2)=x⁵");
            case 16: a=3+seed%5; b=2+seed%4; return s("Discriminant of "+a+"x²+"+b+"x+1?", ""+(b*b-4*a), ""+b*b, ""+(4*a), ""+(b*b+4*a), "b²-4ac", b+"²-4("+a+")(1)="+(b*b-4*a));
            case 17: a=10+seed%10; b=a*3; return s("30% of "+b+" equals what?", ""+a*3*30/100, ""+b, ""+a, ""+(b/3), "0.30×"+b, "30/100×"+b+"="+(b*30/100));
            case 18: a=5+seed%6; b=a+4; return s("Distance between (0,0) and ("+a+","+b+")?", "√"+(a*a+b*b), ""+(a+b), "√"+(a*b), ""+(a*a+b*b), "d=√(x²+y²)", "√("+a+"²+"+b+"²)=√"+(a*a+b*b));
            default: a=6+seed%6; b=8+seed%6; return s("Trapezoid: bases "+a+","+b+", height "+(4+seed%4)+". Area?", ""+((a+b)*(4+seed%4)/2), ""+(a*b), ""+(a+b), ""+((a+b)*(4+seed%4)), "(b₁+b₂)/2×h", "("+a+"+"+b+")/2×"+(4+seed%4)+"="+((a+b)*(4+seed%4)/2));
        }
    }

    private String[] s(String q, String a, String b, String c, String d, String hint, String solution) {
        return new String[]{q, a, b, c, d, hint, solution};
    }

    private String getSvg(String input) {
        if (input == null) return null;
        String t = input.toLowerCase();
        if (t.contains("right triangle") || t.contains("legs") || t.contains("hypotenuse") || t.contains("pythagorean")) {
            return "<svg viewBox=\"0 0 200 120\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"120\" fill=\"#f8f7ff\" rx=\"6\"/><polygon points=\"30,100 30,30 150,100\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><rect x=\"30\" y=\"90\" width=\"10\" height=\"10\" fill=\"none\" stroke=\"#6c5ce7\"/><text x=\"20\" y=\"70\" font-size=\"10\" fill=\"#e17055\">a</text><text x=\"85\" y=\"115\" font-size=\"10\" fill=\"#00b894\">b</text><text x=\"85\" y=\"55\" font-size=\"10\" fill=\"#6c5ce7\">c</text></svg>";
        } else if (t.contains("triangle") && (t.contains("angle") || t.contains("isosceles") || t.contains("equilateral"))) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><polygon points=\"30,85 100,15 170,85\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><path d=\"M 50 85 A 20 20 0 0 0 45 70\" stroke=\"#e17055\" stroke-width=\"1.5\" fill=\"none\"/></svg>";
        } else if (t.contains("vertex") || t.contains("parabola") || t.contains("quadratic") && t.contains("graph")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"85\" x2=\"180\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"100\" y1=\"10\" x2=\"100\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 40 20 Q 100 90 160 20\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2.5\"/><circle cx=\"100\" cy=\"85\" r=\"3\" fill=\"#e17055\"/></svg>";
        } else if (t.contains("slope") || t.contains("linear") && t.contains("graph")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"85\" x2=\"180\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"20\" y1=\"10\" x2=\"20\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"40\" y1=\"70\" x2=\"160\" y2=\"25\" stroke=\"#6c5ce7\" stroke-width=\"2.5\"/><circle cx=\"40\" cy=\"70\" r=\"3\" fill=\"#e17055\"/><circle cx=\"160\" cy=\"25\" r=\"3\" fill=\"#e17055\"/></svg>";
        } else if (t.contains("circle") || t.contains("circumference") || t.contains("radius") || t.contains("sector")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><circle cx=\"100\" cy=\"50\" r=\"35\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><line x1=\"100\" y1=\"50\" x2=\"135\" y2=\"50\" stroke=\"#e17055\" stroke-width=\"1.5\"/><text x=\"115\" y=\"45\" font-size=\"9\" fill=\"#e17055\">r</text></svg>";
        } else if (t.contains("rectangle") && (t.contains("area") || t.contains("perimeter"))) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><rect x=\"30\" y=\"20\" width=\"120\" height=\"60\" fill=\"#a29bfe\" fill-opacity=\"0.15\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><text x=\"90\" y=\"15\" text-anchor=\"middle\" font-size=\"10\" fill=\"#6c5ce7\">l</text><text x=\"20\" y=\"55\" font-size=\"10\" fill=\"#6c5ce7\">w</text></svg>";
        } else if (t.contains("volume") || t.contains("cube") || t.contains("box") || t.contains("prism")) {
            return "<svg viewBox=\"0 0 200 120\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"120\" fill=\"#f8f7ff\" rx=\"6\"/><polygon points=\"40,90 120,90 135,65 55,65\" fill=\"#a29bfe\" fill-opacity=\"0.15\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><polygon points=\"120,90 135,65 135,35 120,60\" fill=\"#a29bfe\" fill-opacity=\"0.1\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><polygon points=\"55,65 135,65 135,35 55,35\" fill=\"#a29bfe\" fill-opacity=\"0.05\" stroke=\"#6c5ce7\" stroke-width=\"2\"/></svg>";
        } else if (t.contains("trapezoid")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><polygon points=\"50,80 30,30 150,30 170,80\" fill=\"#55efc4\" fill-opacity=\"0.15\" stroke=\"#00b894\" stroke-width=\"2\"/><text x=\"90\" y=\"25\" font-size=\"9\" fill=\"#00b894\">b₁</text><text x=\"100\" y=\"95\" font-size=\"9\" fill=\"#00b894\">b₂</text></svg>";
        } else if (t.contains("angle") || t.contains("supplement") || t.contains("complement") || t.contains("exterior") || t.contains("interior")) {
            return "<svg viewBox=\"0 0 200 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"80\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"30\" y1=\"60\" x2=\"170\" y2=\"60\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><line x1=\"30\" y1=\"60\" x2=\"120\" y2=\"20\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><path d=\"M 55 60 A 25 25 0 0 0 48 45\" stroke=\"#e17055\" stroke-width=\"2\" fill=\"none\"/></svg>";
        } else if (t.contains("cylinder")) {
            return "<svg viewBox=\"0 0 200 120\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"120\" fill=\"#f8f7ff\" rx=\"6\"/><ellipse cx=\"100\" cy=\"30\" rx=\"40\" ry=\"12\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><line x1=\"60\" y1=\"30\" x2=\"60\" y2=\"90\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><line x1=\"140\" y1=\"30\" x2=\"140\" y2=\"90\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><ellipse cx=\"100\" cy=\"90\" rx=\"40\" ry=\"12\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2\"/></svg>";
        } else if (t.contains("sphere")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><circle cx=\"100\" cy=\"50\" r=\"35\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><ellipse cx=\"100\" cy=\"50\" rx=\"35\" ry=\"12\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"1\" stroke-dasharray=\"3,3\"/></svg>";
        } else if (t.contains("distance") && t.contains("(")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"50\" x2=\"180\" y2=\"50\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"100\" y1=\"10\" x2=\"100\" y2=\"90\" stroke=\"#333\" stroke-width=\"1\"/><circle cx=\"60\" cy=\"30\" r=\"4\" fill=\"#e17055\"/><circle cx=\"150\" cy=\"70\" r=\"4\" fill=\"#00b894\"/><line x1=\"60\" y1=\"30\" x2=\"150\" y2=\"70\" stroke=\"#6c5ce7\" stroke-width=\"2\" stroke-dasharray=\"4,3\"/></svg>";
        } else if (t.contains("midpoint")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"50\" x2=\"180\" y2=\"50\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"100\" y1=\"10\" x2=\"100\" y2=\"90\" stroke=\"#333\" stroke-width=\"1\"/><circle cx=\"50\" cy=\"30\" r=\"4\" fill=\"#e17055\"/><circle cx=\"150\" cy=\"70\" r=\"4\" fill=\"#e17055\"/><circle cx=\"100\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/></svg>";
        } else if (t.contains("number line") || t.contains("inequality") && t.contains("graph")) {
            return "<svg viewBox=\"0 0 200 50\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"50\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"25\" x2=\"180\" y2=\"25\" stroke=\"#333\" stroke-width=\"2\"/><polygon points=\"180,20 190,25 180,30\" fill=\"#333\"/><circle cx=\"100\" cy=\"25\" r=\"4\" fill=\"#6c5ce7\"/></svg>";
        } else if (t.contains("exponential") || t.contains("decay") || t.contains("growth")) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"85\" x2=\"180\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"20\" y1=\"10\" x2=\"20\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 25 80 Q 60 78 90 60 Q 120 35 160 15\" fill=\"none\" stroke=\"#6c5ce7\" stroke-width=\"2.5\"/></svg>";
        } else if (t.contains("system") && (t.contains("solve") || t.contains("intersection"))) {
            return "<svg viewBox=\"0 0 200 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"100\" fill=\"#f8f7ff\" rx=\"6\"/><line x1=\"20\" y1=\"85\" x2=\"180\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"100\" y1=\"10\" x2=\"100\" y2=\"85\" stroke=\"#333\" stroke-width=\"1\"/><line x1=\"30\" y1=\"75\" x2=\"170\" y2=\"20\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><line x1=\"30\" y1=\"30\" x2=\"170\" y2=\"70\" stroke=\"#e17055\" stroke-width=\"2\"/><circle cx=\"100\" cy=\"50\" r=\"4\" fill=\"#00b894\"/></svg>";
        } else if (t.contains("surface area")) {
            return "<svg viewBox=\"0 0 200 120\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"200\" height=\"120\" fill=\"#f8f7ff\" rx=\"6\"/><polygon points=\"40,90 120,90 135,65 55,65\" fill=\"#a29bfe\" fill-opacity=\"0.15\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><polygon points=\"120,90 135,65 135,35 120,60\" fill=\"#a29bfe\" fill-opacity=\"0.1\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><polygon points=\"55,65 135,65 135,35 55,35\" fill=\"#a29bfe\" fill-opacity=\"0.05\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><text x=\"85\" y=\"105\" font-size=\"9\" fill=\"#6c5ce7\">SA=2(lw+lh+wh)</text></svg>";
        }
        return null;
    }
}
