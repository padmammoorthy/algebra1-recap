package com.algebra1recap.service;

import com.algebra1recap.model.LessonContent;
import com.algebra1recap.model.LessonContent.Section;
import com.algebra1recap.model.LessonContent.WorkedExample;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LessonContentService {

    private final List<LessonContent> lessons;

    public LessonContentService() {
        this.lessons = new ArrayList<>();
        initializeLessons();
    }

    public List<LessonContent> getAllLessons() { return lessons; }
    public Optional<LessonContent> getLessonBySlug(String slug) { return lessons.stream().filter(l -> l.getSlug().equals(slug)).findFirst(); }
    public Map<String, List<LessonContent>> getLessonsByChapter() {
        LinkedHashMap<String, List<LessonContent>> map = new LinkedHashMap<>();
        for (LessonContent l : lessons) map.computeIfAbsent(l.getChapter(), k -> new ArrayList<>()).add(l);
        return map;
    }

    private void initializeLessons() {
        lessons.add(new LessonContent("solving-one-variable-eq", "Solving Equations in One Variable", "1-1",
            "Solve linear equations using properties of equality.", "Chapter 1: Solving Equations and Inequalities", 1,
            Arrays.asList(new Section("Solving Equations in One Variable", "Solve linear equations using properties of equality.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving Equations in One Variable</text></svg>",
                Arrays.asList(
                new WorkedExample("Solve: 3x + 7 = 22", Arrays.asList("Subtract 7 from both sides: 3x = 15", "Divide both sides by 3: x = 5", "Check: 3(5)+7 = 22 ✓"), "x = 5"),
                new WorkedExample("Solve: 2(x - 4) = 10", Arrays.asList("Distribute: 2x - 8 = 10", "Add 8: 2x = 18", "Divide by 2: x = 9", "Check: 2(9-4) = 2(5) = 10 ✓"), "x = 9"),
                new WorkedExample("Solve: 5x - 3 = 2x + 9", Arrays.asList("Subtract 2x: 3x - 3 = 9", "Add 3: 3x = 12", "Divide by 3: x = 4"), "x = 4"),
                new WorkedExample("Solve: (x+5)/3 = 4", Arrays.asList("Multiply both sides by 3: x + 5 = 12", "Subtract 5: x = 7", "Check: (7+5)/3 = 12/3 = 4 ✓"), "x = 7"),
                new WorkedExample("Solve: 4(2x+1) = 3(x-2) + 5x", Arrays.asList("Distribute: 8x+4 = 3x-6+5x", "Simplify right: 8x+4 = 8x-6", "Subtract 8x: 4 = -6", "Contradiction: No solution"), "No solution (contradiction)")
            ))),
            Arrays.asList("Key concept from Solving Equations in One Variable", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("literal-equations", "Literal Equations and Formulas", "1-2",
            "Rearrange formulas to solve for any variable.", "Chapter 1: Solving Equations and Inequalities", 2,
            Arrays.asList(new Section("Literal Equations and Formulas", "Rearrange formulas to solve for any variable.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Literal Equations and Formulas</text></svg>",
                Arrays.asList(
                new WorkedExample("Solve for h: A = (1/2)bh", Arrays.asList("Multiply both sides by 2: 2A = bh", "Divide by b: h = 2A/b"), "h = 2A/b"),
                new WorkedExample("Solve for r: C = 2πr", Arrays.asList("Divide both sides by 2π: r = C/(2π)"), "r = C/(2π)"),
                new WorkedExample("Solve for y: 3x + 2y = 12", Arrays.asList("Subtract 3x: 2y = 12 - 3x", "Divide by 2: y = (12-3x)/2 = 6 - (3/2)x"), "y = 6 - (3/2)x"),
                new WorkedExample("Solve for F: C = (5/9)(F-32)", Arrays.asList("Multiply by 9/5: (9/5)C = F - 32", "Add 32: F = (9/5)C + 32"), "F = (9/5)C + 32"),
                new WorkedExample("Solve for t: d = rt + s", Arrays.asList("Subtract s: d - s = rt", "Divide by r: t = (d-s)/r"), "t = (d-s)/r")
            ))),
            Arrays.asList("Key concept from Literal Equations and Formulas", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-inequalities", "Solving Inequalities in One Variable", "1-3",
            "Solve and graph linear inequalities on a number line.", "Chapter 1: Solving Equations and Inequalities", 3,
            Arrays.asList(new Section("Solving Inequalities in One Variable", "Solve and graph linear inequalities on a number line.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving Inequalities in One Variable</text></svg>",
                Arrays.asList(
                new WorkedExample("Solve: -2x + 5 > 11", Arrays.asList("Subtract 5: -2x > 6", "Divide by -2 (FLIP): x < -3", "Graph: open circle at -3, shade left"), "x < -3"),
                new WorkedExample("Solve: 3(x-1) >= 2x + 4", Arrays.asList("Distribute: 3x-3 >= 2x+4", "Subtract 2x: x-3 >= 4", "Add 3: x >= 7"), "x >= 7"),
                new WorkedExample("Solve: 4x + 1 < 13", Arrays.asList("Subtract 1: 4x < 12", "Divide by 4: x < 3"), "x < 3"),
                new WorkedExample("Solve: -x/2 >= 4", Arrays.asList("Multiply by -2 (FLIP): x <= -8"), "x <= -8"),
                new WorkedExample("Solve: 5 - 2x < 11", Arrays.asList("Subtract 5: -2x < 6", "Divide by -2 (FLIP): x > -3"), "x > -3")
            ))),
            Arrays.asList("Key concept from Solving Inequalities in One Variable", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("compound-inequalities", "Compound Inequalities", "1-4",
            "Solve AND and OR compound inequalities.", "Chapter 1: Solving Equations and Inequalities", 4,
            Arrays.asList(new Section("Compound Inequalities", "Solve AND and OR compound inequalities.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Compound Inequalities</text></svg>",
                Arrays.asList(
                new WorkedExample("Solve: -1 < 2x+3 <= 9", Arrays.asList("Subtract 3 from all: -4 < 2x <= 6", "Divide by 2: -2 < x <= 3"), "(-2, 3]"),
                new WorkedExample("Solve: x > 2 AND x < 7", Arrays.asList("Both must be true", "Intersection: 2 < x < 7"), "(2, 7)"),
                new WorkedExample("Solve: x < -1 OR x > 5", Arrays.asList("Either can be true", "Union of both regions"), "{x | x<-1 or x>5}"),
                new WorkedExample("Solve: 3 <= 2x-1 < 7", Arrays.asList("Add 1: 4 <= 2x < 8", "Divide by 2: 2 <= x < 4"), "[2, 4)"),
                new WorkedExample("Solve: 2x < -4 OR 3x > 12", Arrays.asList("First: x < -2", "Second: x > 4", "Union"), "{x | x<-2 or x>4}")
            ))),
            Arrays.asList("Key concept from Compound Inequalities", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("absolute-value-equations", "Absolute Value Equations", "1-5",
            "Solve equations involving absolute value expressions.", "Chapter 1: Solving Equations and Inequalities", 5,
            Arrays.asList(new Section("Absolute Value Equations", "Solve equations involving absolute value expressions.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#333\" stroke-width=\"2\"/><polygon points=\"300,45 310,50 300,55\" fill=\"#333\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Absolute Value Equations</text></svg>",
                Arrays.asList(
                new WorkedExample("Solve: |x-3| = 7", Arrays.asList("Case 1: x-3 = 7, x = 10", "Case 2: x-3 = -7, x = -4"), "x = 10 or x = -4"),
                new WorkedExample("Solve: |2x+1| = 5", Arrays.asList("Case 1: 2x+1=5, x=2", "Case 2: 2x+1=-5, x=-3"), "x = 2 or x = -3"),
                new WorkedExample("Solve: |x+5| = -2", Arrays.asList("Absolute value cannot be negative", "No solution exists"), "No solution"),
                new WorkedExample("Solve: 3|x-2| = 12", Arrays.asList("Divide by 3: |x-2| = 4", "Case 1: x-2=4, x=6", "Case 2: x-2=-4, x=-2"), "x = 6 or x = -2"),
                new WorkedExample("Solve: |4x-8| = 0", Arrays.asList("Expression inside must equal 0", "4x-8 = 0, x = 2"), "x = 2")
            ))),
            Arrays.asList("Key concept from Absolute Value Equations", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("absolute-value-inequalities", "Absolute Value Inequalities", "1-6",
            "Solve and graph absolute value inequalities.", "Chapter 1: Solving Equations and Inequalities", 6,
            Arrays.asList(new Section("Absolute Value Inequalities", "Solve and graph absolute value inequalities.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#333\" stroke-width=\"2\"/><polygon points=\"300,45 310,50 300,55\" fill=\"#333\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Absolute Value Inequalities</text></svg>",
                Arrays.asList(
                new WorkedExample("Solve: |x-2| < 5", Arrays.asList("Rewrite: -5 < x-2 < 5", "Add 2: -3 < x < 7"), "(-3, 7)"),
                new WorkedExample("Solve: |2x+1| >= 3", Arrays.asList("Case 1: 2x+1>=3, x>=1", "Case 2: 2x+1<=-3, x<=-2"), "{x|x<=-2 or x>=1}"),
                new WorkedExample("Solve: |x| < 4", Arrays.asList("Means: -4 < x < 4"), "(-4, 4)"),
                new WorkedExample("Solve: |x+3| > 2", Arrays.asList("x+3>2 OR x+3<-2", "x>-1 OR x<-5"), "{x|x<-5 or x>-1}"),
                new WorkedExample("Solve: |3x-6| <= 9", Arrays.asList("-9<=3x-6<=9", "Add 6: -3<=3x<=15", "Divide: -1<=x<=5"), "[-1, 5]")
            ))),
            Arrays.asList("Key concept from Absolute Value Inequalities", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("slope-and-rate-of-change", "Slope and Rate of Change", "2-1",
            "Calculate slope and interpret rate of change.", "Chapter 2: Linear Equations", 7,
            Arrays.asList(new Section("Slope and Rate of Change", "Calculate slope and interpret rate of change.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Slope and Rate of Change</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Slope and Rate of Change", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Slope and Rate of Change", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Slope and Rate of Change", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Slope and Rate of Change", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Slope and Rate of Change", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Slope and Rate of Change", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("slope-intercept-form", "Slope-Intercept Form", "2-2",
            "Write and graph equations in y=mx+b form.", "Chapter 2: Linear Equations", 8,
            Arrays.asList(new Section("Slope-Intercept Form", "Write and graph equations in y=mx+b form.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Slope-Intercept Form</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Slope-Intercept Form", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Slope-Intercept Form", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Slope-Intercept Form", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Slope-Intercept Form", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Slope-Intercept Form", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Slope-Intercept Form", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("point-slope-form", "Point-Slope Form", "2-3",
            "Write equations using point-slope form.", "Chapter 2: Linear Equations", 9,
            Arrays.asList(new Section("Point-Slope Form", "Write equations using point-slope form.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Point-Slope Form</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Point-Slope Form", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Point-Slope Form", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Point-Slope Form", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Point-Slope Form", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Point-Slope Form", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Point-Slope Form", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("standard-form", "Standard Form", "2-4",
            "Convert between forms and use Ax+By=C.", "Chapter 2: Linear Equations", 10,
            Arrays.asList(new Section("Standard Form", "Convert between forms and use Ax+By=C.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Standard Form</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Standard Form", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Standard Form", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Standard Form", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Standard Form", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Standard Form", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Standard Form", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("parallel-perpendicular", "Parallel and Perpendicular Lines", "2-5",
            "Write equations of parallel and perpendicular lines.", "Chapter 2: Linear Equations", 11,
            Arrays.asList(new Section("Parallel and Perpendicular Lines", "Write equations of parallel and perpendicular lines.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Parallel and Perpendicular Lines</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Parallel and Perpendicular Lines", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Parallel and Perpendicular Lines", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Parallel and Perpendicular Lines", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Parallel and Perpendicular Lines", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Parallel and Perpendicular Lines", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Parallel and Perpendicular Lines", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("relations-and-functions", "Relations and Functions", "3-1",
            "Identify functions using the vertical line test.", "Chapter 3: Linear Functions", 12,
            Arrays.asList(new Section("Relations and Functions", "Identify functions using the vertical line test.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Relations and Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Relations and Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Relations and Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Relations and Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Relations and Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Relations and Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Relations and Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("linear-functions", "Linear Functions", "3-2",
            "Evaluate and graph linear functions.", "Chapter 3: Linear Functions", 13,
            Arrays.asList(new Section("Linear Functions", "Evaluate and graph linear functions.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Linear Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Linear Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Linear Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Linear Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Linear Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Linear Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Linear Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("transforming-linear-functions", "Transforming Linear Functions", "3-3",
            "Apply shifts, reflections, and stretches.", "Chapter 3: Linear Functions", 14,
            Arrays.asList(new Section("Transforming Linear Functions", "Apply shifts, reflections, and stretches.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Transforming Linear Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Transforming Linear Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Transforming Linear Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Transforming Linear Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Transforming Linear Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Transforming Linear Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Transforming Linear Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("arithmetic-sequences", "Arithmetic Sequences", "3-4",
            "Find terms and write rules for arithmetic sequences.", "Chapter 3: Linear Functions", 15,
            Arrays.asList(new Section("Arithmetic Sequences", "Find terms and write rules for arithmetic sequences.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Arithmetic Sequences</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Arithmetic Sequences", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Arithmetic Sequences", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Arithmetic Sequences", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Arithmetic Sequences", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Arithmetic Sequences", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Arithmetic Sequences", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("scatter-plots-trend-lines", "Scatter Plots and Lines of Fit", "3-5",
            "Draw and interpret scatter plots and trend lines.", "Chapter 3: Linear Functions", 16,
            Arrays.asList(new Section("Scatter Plots and Lines of Fit", "Draw and interpret scatter plots and trend lines.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Scatter Plots and Lines of Fit</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Scatter Plots and Lines of Fit", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Scatter Plots and Lines of Fit", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Scatter Plots and Lines of Fit", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Scatter Plots and Lines of Fit", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Scatter Plots and Lines of Fit", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Scatter Plots and Lines of Fit", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-systems-graphing", "Solving Systems by Graphing", "4-1",
            "Solve systems by graphing intersections.", "Chapter 4: Systems of Linear Equations", 17,
            Arrays.asList(new Section("Solving Systems by Graphing", "Solve systems by graphing intersections.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving Systems by Graphing</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Solving Systems by Graphing", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Solving Systems by Graphing", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Solving Systems by Graphing", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Solving Systems by Graphing", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Solving Systems by Graphing", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Solving Systems by Graphing", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-systems-substitution", "Solving Systems by Substitution", "4-2",
            "Use substitution to solve systems.", "Chapter 4: Systems of Linear Equations", 18,
            Arrays.asList(new Section("Solving Systems by Substitution", "Use substitution to solve systems.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving Systems by Substitution</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Solving Systems by Substitution", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Solving Systems by Substitution", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Solving Systems by Substitution", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Solving Systems by Substitution", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Solving Systems by Substitution", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Solving Systems by Substitution", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-systems-elimination", "Solving Systems by Elimination", "4-3",
            "Use elimination to solve systems.", "Chapter 4: Systems of Linear Equations", 19,
            Arrays.asList(new Section("Solving Systems by Elimination", "Use elimination to solve systems.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving Systems by Elimination</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Solving Systems by Elimination", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Solving Systems by Elimination", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Solving Systems by Elimination", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Solving Systems by Elimination", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Solving Systems by Elimination", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Solving Systems by Elimination", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("linear-inequalities-two-var", "Linear Inequalities in Two Variables", "4-4",
            "Graph linear inequalities in two variables.", "Chapter 4: Systems of Linear Equations", 20,
            Arrays.asList(new Section("Linear Inequalities in Two Variables", "Graph linear inequalities in two variables.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Linear Inequalities in Two Variables</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Linear Inequalities in Two Variables", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Linear Inequalities in Two Variables", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Linear Inequalities in Two Variables", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Linear Inequalities in Two Variables", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Linear Inequalities in Two Variables", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Linear Inequalities in Two Variables", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("systems-of-inequalities", "Systems of Linear Inequalities", "4-5",
            "Graph systems of inequalities.", "Chapter 4: Systems of Linear Equations", 21,
            Arrays.asList(new Section("Systems of Linear Inequalities", "Graph systems of inequalities.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Systems of Linear Inequalities</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Systems of Linear Inequalities", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Systems of Linear Inequalities", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Systems of Linear Inequalities", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Systems of Linear Inequalities", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Systems of Linear Inequalities", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Systems of Linear Inequalities", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("piecewise-functions", "Piecewise-Defined Functions", "5-1",
            "Evaluate and graph piecewise functions.", "Chapter 5: Piecewise Functions", 22,
            Arrays.asList(new Section("Piecewise-Defined Functions", "Evaluate and graph piecewise functions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Piecewise-Defined Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Piecewise-Defined Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Piecewise-Defined Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Piecewise-Defined Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Piecewise-Defined Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Piecewise-Defined Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Piecewise-Defined Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("step-functions", "Step Functions", "5-2",
            "Graph and interpret step functions.", "Chapter 5: Piecewise Functions", 23,
            Arrays.asList(new Section("Step Functions", "Graph and interpret step functions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Step Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Step Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Step Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Step Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Step Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Step Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Step Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("absolute-value-functions", "Absolute Value Functions", "5-3",
            "Graph and transform absolute value functions.", "Chapter 5: Piecewise Functions", 24,
            Arrays.asList(new Section("Absolute Value Functions", "Graph and transform absolute value functions.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#333\" stroke-width=\"2\"/><polygon points=\"300,45 310,50 300,55\" fill=\"#333\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Absolute Value Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Absolute Value Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Absolute Value Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Absolute Value Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Absolute Value Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Absolute Value Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Absolute Value Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("exponential-growth", "Exponential Growth", "6-1",
            "Model and graph exponential growth.", "Chapter 6: Exponential Functions", 25,
            Arrays.asList(new Section("Exponential Growth", "Model and graph exponential growth.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 170 Q 150 165 200 100 Q 250 40 280 25\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Exponential Growth</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Exponential Growth", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Exponential Growth", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Exponential Growth", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Exponential Growth", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Exponential Growth", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Exponential Growth", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("exponential-decay", "Exponential Decay", "6-2",
            "Model and graph exponential decay.", "Chapter 6: Exponential Functions", 26,
            Arrays.asList(new Section("Exponential Decay", "Model and graph exponential decay.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 170 Q 150 165 200 100 Q 250 40 280 25\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Exponential Decay</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Exponential Decay", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Exponential Decay", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Exponential Decay", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Exponential Decay", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Exponential Decay", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Exponential Decay", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("geometric-sequences", "Geometric Sequences", "6-3",
            "Find terms and common ratios.", "Chapter 6: Exponential Functions", 27,
            Arrays.asList(new Section("Geometric Sequences", "Find terms and common ratios.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Geometric Sequences</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Geometric Sequences", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Geometric Sequences", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Geometric Sequences", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Geometric Sequences", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Geometric Sequences", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Geometric Sequences", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("exponential-models", "Exponential Function Models", "6-4",
            "Write exponential models from data.", "Chapter 6: Exponential Functions", 28,
            Arrays.asList(new Section("Exponential Function Models", "Write exponential models from data.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 170 Q 150 165 200 100 Q 250 40 280 25\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Exponential Function Models</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Exponential Function Models", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Exponential Function Models", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Exponential Function Models", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Exponential Function Models", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Exponential Function Models", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Exponential Function Models", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("adding-subtracting-poly", "Adding and Subtracting Polynomials", "7-1",
            "Combine like terms in polynomials.", "Chapter 7: Polynomials and Factoring", 29,
            Arrays.asList(new Section("Adding and Subtracting Polynomials", "Combine like terms in polynomials.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Adding and Subtracting Polynomials</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Adding and Subtracting Polynomials", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Adding and Subtracting Polynomials", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Adding and Subtracting Polynomials", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Adding and Subtracting Polynomials", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Adding and Subtracting Polynomials", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Adding and Subtracting Polynomials", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("multiplying-polynomials", "Multiplying Polynomials", "7-2",
            "Distribute and FOIL to multiply.", "Chapter 7: Polynomials and Factoring", 30,
            Arrays.asList(new Section("Multiplying Polynomials", "Distribute and FOIL to multiply.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Multiplying Polynomials</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Multiplying Polynomials", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Multiplying Polynomials", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Multiplying Polynomials", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Multiplying Polynomials", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Multiplying Polynomials", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Multiplying Polynomials", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("special-products", "Special Products of Binomials", "7-3",
            "Apply patterns for squares and differences.", "Chapter 7: Polynomials and Factoring", 31,
            Arrays.asList(new Section("Special Products of Binomials", "Apply patterns for squares and differences.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Special Products of Binomials</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Special Products of Binomials", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Special Products of Binomials", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Special Products of Binomials", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Special Products of Binomials", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Special Products of Binomials", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Special Products of Binomials", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("factoring-gcf", "Factoring Using the GCF", "7-4",
            "Factor out the greatest common factor.", "Chapter 7: Polynomials and Factoring", 32,
            Arrays.asList(new Section("Factoring Using the GCF", "Factor out the greatest common factor.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Factoring Using the GCF</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Factoring Using the GCF", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Factoring Using the GCF", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Factoring Using the GCF", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Factoring Using the GCF", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Factoring Using the GCF", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Factoring Using the GCF", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("factoring-trinomials-1", "Factoring Trinomials (a=1)", "7-5",
            "Factor trinomials with leading coefficient 1.", "Chapter 7: Polynomials and Factoring", 33,
            Arrays.asList(new Section("Factoring Trinomials (a=1)", "Factor trinomials with leading coefficient 1.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Factoring Trinomials (a=1)</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Factoring Trinomials (a=1)", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Factoring Trinomials (a=1)", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Factoring Trinomials (a=1)", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Factoring Trinomials (a=1)", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Factoring Trinomials (a=1)", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Factoring Trinomials (a=1)", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("factoring-trinomials-a", "Factoring Trinomials (a not 1)", "7-6",
            "Factor trinomials with any leading coefficient.", "Chapter 7: Polynomials and Factoring", 34,
            Arrays.asList(new Section("Factoring Trinomials (a not 1)", "Factor trinomials with any leading coefficient.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Factoring Trinomials (a not 1)</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Factoring Trinomials (a not 1)", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Factoring Trinomials (a not 1)", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Factoring Trinomials (a not 1)", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Factoring Trinomials (a not 1)", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Factoring Trinomials (a not 1)", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Factoring Trinomials (a not 1)", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("factoring-special-cases", "Factoring Special Cases", "7-7",
            "Factor perfect squares and difference of squares.", "Chapter 7: Polynomials and Factoring", 35,
            Arrays.asList(new Section("Factoring Special Cases", "Factor perfect squares and difference of squares.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Factoring Special Cases</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Factoring Special Cases", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Factoring Special Cases", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Factoring Special Cases", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Factoring Special Cases", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Factoring Special Cases", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Factoring Special Cases", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("graphing-standard-form", "Graphing Quadratics (Standard)", "8-1",
            "Graph quadratics finding vertex and axis.", "Chapter 8: Quadratic Functions", 36,
            Arrays.asList(new Section("Graphing Quadratics (Standard)", "Graph quadratics finding vertex and axis.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 60 30 Q 160 190 260 30\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Graphing Quadratics (Standard)</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Graphing Quadratics (Standard)", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Graphing Quadratics (Standard)", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Graphing Quadratics (Standard)", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Graphing Quadratics (Standard)", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Graphing Quadratics (Standard)", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Graphing Quadratics (Standard)", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("graphing-vertex-form", "Graphing Quadratics (Vertex Form)", "8-2",
            "Graph using transformations of vertex form.", "Chapter 8: Quadratic Functions", 37,
            Arrays.asList(new Section("Graphing Quadratics (Vertex Form)", "Graph using transformations of vertex form.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Graphing Quadratics (Vertex Form)</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Graphing Quadratics (Vertex Form)", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Graphing Quadratics (Vertex Form)", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Graphing Quadratics (Vertex Form)", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Graphing Quadratics (Vertex Form)", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Graphing Quadratics (Vertex Form)", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Graphing Quadratics (Vertex Form)", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("modeling-quadratics", "Modeling With Quadratics", "8-3",
            "Write quadratic models for real situations.", "Chapter 8: Quadratic Functions", 38,
            Arrays.asList(new Section("Modeling With Quadratics", "Write quadratic models for real situations.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 60 30 Q 160 190 260 30\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">Modeling With Quadratics</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Modeling With Quadratics", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Modeling With Quadratics", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Modeling With Quadratics", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Modeling With Quadratics", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Modeling With Quadratics", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Modeling With Quadratics", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-quadratics-graphing", "Solving by Graphing", "9-1",
            "Find solutions as x-intercepts.", "Chapter 9: Solving Quadratic Equations", 39,
            Arrays.asList(new Section("Solving by Graphing", "Find solutions as x-intercepts.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving by Graphing</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Solving by Graphing", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Solving by Graphing", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Solving by Graphing", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Solving by Graphing", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Solving by Graphing", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Solving by Graphing", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-quadratics-factoring", "Solving by Factoring", "9-2",
            "Apply zero-product property.", "Chapter 9: Solving Quadratic Equations", 40,
            Arrays.asList(new Section("Solving by Factoring", "Apply zero-product property.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving by Factoring</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Solving by Factoring", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Solving by Factoring", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Solving by Factoring", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Solving by Factoring", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Solving by Factoring", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Solving by Factoring", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("completing-the-square", "Completing the Square", "9-3",
            "Solve by completing the square.", "Chapter 9: Solving Quadratic Equations", 41,
            Arrays.asList(new Section("Completing the Square", "Solve by completing the square.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Completing the Square</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Completing the Square", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Completing the Square", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Completing the Square", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Completing the Square", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Completing the Square", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Completing the Square", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("quadratic-formula", "The Quadratic Formula", "9-4",
            "Apply the quadratic formula.", "Chapter 9: Solving Quadratic Equations", 42,
            Arrays.asList(new Section("The Quadratic Formula", "Apply the quadratic formula.",
                "<svg viewBox=\"0 0 320 200\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"200\" fill=\"#f8f9fa\" rx=\"8\"/><line x1=\"40\" y1=\"180\" x2=\"300\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"180\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"160\" x2=\"280\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"12\" fill=\"#6c5ce7\">The Quadratic Formula</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for The Quadratic Formula", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for The Quadratic Formula", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for The Quadratic Formula", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for The Quadratic Formula", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for The Quadratic Formula", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from The Quadratic Formula", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("choosing-a-method", "Choosing a Method", "9-5",
            "Select the best solving method.", "Chapter 9: Solving Quadratic Equations", 43,
            Arrays.asList(new Section("Choosing a Method", "Select the best solving method.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Choosing a Method</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Choosing a Method", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Choosing a Method", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Choosing a Method", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Choosing a Method", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Choosing a Method", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Choosing a Method", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("square-root-functions", "Square Root Functions", "10-1",
            "Graph and transform square root functions.", "Chapter 10: Radical Expressions", 44,
            Arrays.asList(new Section("Square Root Functions", "Graph and transform square root functions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Square Root Functions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Square Root Functions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Square Root Functions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Square Root Functions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Square Root Functions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Square Root Functions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Square Root Functions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("simplifying-radicals", "Simplifying Radicals", "10-2",
            "Simplify radical expressions.", "Chapter 10: Radical Expressions", 45,
            Arrays.asList(new Section("Simplifying Radicals", "Simplify radical expressions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Simplifying Radicals</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Simplifying Radicals", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Simplifying Radicals", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Simplifying Radicals", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Simplifying Radicals", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Simplifying Radicals", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Simplifying Radicals", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("operations-with-radicals", "Operations With Radicals", "10-3",
            "Add, subtract, multiply radicals.", "Chapter 10: Radical Expressions", 46,
            Arrays.asList(new Section("Operations With Radicals", "Add, subtract, multiply radicals.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Operations With Radicals</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Operations With Radicals", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Operations With Radicals", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Operations With Radicals", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Operations With Radicals", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Operations With Radicals", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Operations With Radicals", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("solving-radical-equations", "Solving Radical Equations", "10-4",
            "Solve equations containing radicals.", "Chapter 10: Radical Expressions", 47,
            Arrays.asList(new Section("Solving Radical Equations", "Solve equations containing radicals.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Solving Radical Equations</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Solving Radical Equations", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Solving Radical Equations", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Solving Radical Equations", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Solving Radical Equations", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Solving Radical Equations", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Solving Radical Equations", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("measures-of-center", "Measures of Center and Spread", "11-1",
            "Calculate mean, median, mode, range, SD.", "Chapter 11: Data Analysis", 48,
            Arrays.asList(new Section("Measures of Center and Spread", "Calculate mean, median, mode, range, SD.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Measures of Center and Spread</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Measures of Center and Spread", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Measures of Center and Spread", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Measures of Center and Spread", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Measures of Center and Spread", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Measures of Center and Spread", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Measures of Center and Spread", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("box-plots", "Box Plots and Distributions", "11-2",
            "Create box plots and describe distributions.", "Chapter 11: Data Analysis", 49,
            Arrays.asList(new Section("Box Plots and Distributions", "Create box plots and describe distributions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Box Plots and Distributions</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Box Plots and Distributions", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Box Plots and Distributions", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Box Plots and Distributions", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Box Plots and Distributions", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Box Plots and Distributions", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Box Plots and Distributions", "Always check your work", "Practice with multiple examples")
        ));
        lessons.add(new LessonContent("two-way-tables", "Two-Way Frequency Tables", "11-3",
            "Organize and analyze categorical data.", "Chapter 11: Data Analysis", 50,
            Arrays.asList(new Section("Two-Way Frequency Tables", "Organize and analyze categorical data.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f8f9fa\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"18\" font-family=\"monospace\" fill=\"#6c5ce7\">Two-Way Frequency Tables</text></svg>",
                Arrays.asList(
                new WorkedExample("Example 1 for Two-Way Frequency Tables", Arrays.asList("Step 1: Identify given information", "Step 2: Apply the relevant formula or method", "Step 3: Simplify the expression", "Step 4: State the solution"), "Solution demonstrated"),
                new WorkedExample("Example 2 for Two-Way Frequency Tables", Arrays.asList("Step 1: Set up the problem", "Step 2: Perform operations on both sides", "Step 3: Isolate the variable", "Step 4: Verify the answer"), "Solution verified"),
                new WorkedExample("Example 3 for Two-Way Frequency Tables", Arrays.asList("Step 1: Read and understand the problem", "Step 2: Translate to mathematical expression", "Step 3: Solve using appropriate technique", "Step 4: Interpret the result"), "Answer interpreted"),
                new WorkedExample("Example 4 for Two-Way Frequency Tables", Arrays.asList("Step 1: Identify the pattern or structure", "Step 2: Apply the pattern", "Step 3: Calculate", "Step 4: Check reasonableness"), "Pattern applied correctly"),
                new WorkedExample("Example 5 for Two-Way Frequency Tables", Arrays.asList("Step 1: Consider special cases", "Step 2: Apply method to special case", "Step 3: Generalize if needed", "Step 4: State final answer"), "Special case resolved")
            ))),
            Arrays.asList("Key concept from Two-Way Frequency Tables", "Always check your work", "Practice with multiple examples")
        ));
    }
}