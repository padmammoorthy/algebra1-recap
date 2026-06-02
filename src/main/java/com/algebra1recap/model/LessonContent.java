package com.algebra1recap.model;

import java.util.List;

public class LessonContent {

    private String slug;
    private String title;
    private String sectionNum;
    private String description;
    private String chapter;
    private int lessonNumber;
    private List<Section> sections;
    private List<String> keyTakeaways;

    public LessonContent() {}

    public LessonContent(String slug, String title, String sectionNum, String description, String chapter, int lessonNumber, List<Section> sections, List<String> keyTakeaways) {
        this.slug = slug;
        this.title = title;
        this.sectionNum = sectionNum;
        this.description = description;
        this.chapter = chapter;
        this.lessonNumber = lessonNumber;
        this.sections = sections;
        this.keyTakeaways = keyTakeaways;
    }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSectionNum() { return sectionNum; }
    public void setSectionNum(String sectionNum) { this.sectionNum = sectionNum; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getChapter() { return chapter; }
    public void setChapter(String chapter) { this.chapter = chapter; }
    public int getLessonNumber() { return lessonNumber; }
    public void setLessonNumber(int lessonNumber) { this.lessonNumber = lessonNumber; }
    public List<Section> getSections() { return sections; }
    public void setSections(List<Section> sections) { this.sections = sections; }
    public List<String> getKeyTakeaways() { return keyTakeaways; }
    public void setKeyTakeaways(List<String> keyTakeaways) { this.keyTakeaways = keyTakeaways; }

    // For template compatibility with existing TOC
    public String getIcon() { return sectionNum; }

    public static class Section {
        private String heading;
        private String explanation;
        private String illustration; // SVG string
        private List<WorkedExample> examples;

        public Section() {}
        public Section(String heading, String explanation, List<WorkedExample> examples) {
            this.heading = heading;
            this.explanation = explanation;
            this.examples = examples;
        }
        public Section(String heading, String explanation, String illustration, List<WorkedExample> examples) {
            this.heading = heading;
            this.explanation = explanation;
            this.illustration = illustration;
            this.examples = examples;
        }

        public String getHeading() { return heading; }
        public void setHeading(String heading) { this.heading = heading; }
        public String getExplanation() { return explanation; }
        public void setExplanation(String explanation) { this.explanation = explanation; }
        public String getIllustration() { return illustration; }
        public void setIllustration(String illustration) { this.illustration = illustration; }
        public List<WorkedExample> getExamples() { return examples; }
        public void setExamples(List<WorkedExample> examples) { this.examples = examples; }
    }

    public static class WorkedExample {
        private String problem;
        private List<String> steps;
        private String answer;

        public WorkedExample() {}
        public WorkedExample(String problem, List<String> steps, String answer) {
            this.problem = problem;
            this.steps = steps;
            this.answer = answer;
        }

        public String getProblem() { return problem; }
        public void setProblem(String problem) { this.problem = problem; }
        public List<String> getSteps() { return steps; }
        public void setSteps(List<String> steps) { this.steps = steps; }
        public String getAnswer() { return answer; }
        public void setAnswer(String answer) { this.answer = answer; }
    }
}
