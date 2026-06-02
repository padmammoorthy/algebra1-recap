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

    public Optional<LessonContent> getLessonBySlug(String slug) {
        return lessons.stream().filter(l -> l.getSlug().equals(slug)).findFirst();
    }

    public Map<String, List<LessonContent>> getLessonsByChapter() {
        LinkedHashMap<String, List<LessonContent>> map = new LinkedHashMap<>();
        for (LessonContent lesson : lessons) {
            map.computeIfAbsent(lesson.getChapter(), k -> new ArrayList<>()).add(lesson);
        }
        return map;
    }

    private void initializeLessons() {
        lessons.add(new LessonContent("solving-one-variable-eq", "Solving Equations in One Variable", "1-1",
            "Solve linear equations using properties of equality.",
            "Chapter 1: Solving Equations and Inequalities", 1,
            Arrays.asList(new Section("Solving Equations in One Variable", "Solve linear equations using properties of equality.",
                Arrays.asList(new WorkedExample("Example for Solving Equations in One Variable",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving Equations in One Variable", "Always verify your answer")
        ));
        lessons.add(new LessonContent("literal-equations", "Literal Equations and Formulas", "1-2",
            "Rearrange formulas to solve for any variable.",
            "Chapter 1: Solving Equations and Inequalities", 2,
            Arrays.asList(new Section("Literal Equations and Formulas", "Rearrange formulas to solve for any variable.",
                Arrays.asList(new WorkedExample("Example for Literal Equations and Formulas",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Literal Equations and Formulas", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-inequalities", "Solving Inequalities in One Variable", "1-3",
            "Solve and graph linear inequalities on a number line.",
            "Chapter 1: Solving Equations and Inequalities", 3,
            Arrays.asList(new Section("Solving Inequalities in One Variable", "Solve and graph linear inequalities on a number line.",
                Arrays.asList(new WorkedExample("Example for Solving Inequalities in One Variable",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving Inequalities in One Variable", "Always verify your answer")
        ));
        lessons.add(new LessonContent("compound-inequalities", "Compound Inequalities", "1-4",
            "Solve AND and OR compound inequalities.",
            "Chapter 1: Solving Equations and Inequalities", 4,
            Arrays.asList(new Section("Compound Inequalities", "Solve AND and OR compound inequalities.",
                Arrays.asList(new WorkedExample("Example for Compound Inequalities",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Compound Inequalities", "Always verify your answer")
        ));
        lessons.add(new LessonContent("absolute-value-equations", "Absolute Value Equations", "1-5",
            "Solve equations involving absolute value expressions.",
            "Chapter 1: Solving Equations and Inequalities", 5,
            Arrays.asList(new Section("Absolute Value Equations", "Solve equations involving absolute value expressions.",
                Arrays.asList(new WorkedExample("Example for Absolute Value Equations",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Absolute Value Equations", "Always verify your answer")
        ));
        lessons.add(new LessonContent("absolute-value-inequalities", "Absolute Value Inequalities", "1-6",
            "Solve and graph absolute value inequalities.",
            "Chapter 1: Solving Equations and Inequalities", 6,
            Arrays.asList(new Section("Absolute Value Inequalities", "Solve and graph absolute value inequalities.",
                Arrays.asList(new WorkedExample("Example for Absolute Value Inequalities",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Absolute Value Inequalities", "Always verify your answer")
        ));
        lessons.add(new LessonContent("slope-and-rate-of-change", "Slope and Rate of Change", "2-1",
            "Calculate slope and interpret rate of change.",
            "Chapter 2: Linear Equations", 7,
            Arrays.asList(new Section("Slope and Rate of Change", "Calculate slope and interpret rate of change.",
                Arrays.asList(new WorkedExample("Example for Slope and Rate of Change",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Slope and Rate of Change", "Always verify your answer")
        ));
        lessons.add(new LessonContent("slope-intercept-form", "Slope-Intercept Form", "2-2",
            "Write and graph equations in y=mx+b form.",
            "Chapter 2: Linear Equations", 8,
            Arrays.asList(new Section("Slope-Intercept Form", "Write and graph equations in y=mx+b form.",
                Arrays.asList(new WorkedExample("Example for Slope-Intercept Form",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Slope-Intercept Form", "Always verify your answer")
        ));
        lessons.add(new LessonContent("point-slope-form", "Point-Slope Form", "2-3",
            "Write equations using point-slope form.",
            "Chapter 2: Linear Equations", 9,
            Arrays.asList(new Section("Point-Slope Form", "Write equations using point-slope form.",
                Arrays.asList(new WorkedExample("Example for Point-Slope Form",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Point-Slope Form", "Always verify your answer")
        ));
        lessons.add(new LessonContent("standard-form", "Standard Form", "2-4",
            "Convert between forms and use Ax+By=C.",
            "Chapter 2: Linear Equations", 10,
            Arrays.asList(new Section("Standard Form", "Convert between forms and use Ax+By=C.",
                Arrays.asList(new WorkedExample("Example for Standard Form",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Standard Form", "Always verify your answer")
        ));
        lessons.add(new LessonContent("parallel-perpendicular", "Parallel and Perpendicular Lines", "2-5",
            "Write equations of parallel and perpendicular lines.",
            "Chapter 2: Linear Equations", 11,
            Arrays.asList(new Section("Parallel and Perpendicular Lines", "Write equations of parallel and perpendicular lines.",
                Arrays.asList(new WorkedExample("Example for Parallel and Perpendicular Lines",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Parallel and Perpendicular Lines", "Always verify your answer")
        ));
        lessons.add(new LessonContent("relations-and-functions", "Relations and Functions", "3-1",
            "Identify functions using the vertical line test.",
            "Chapter 3: Linear Functions", 12,
            Arrays.asList(new Section("Relations and Functions", "Identify functions using the vertical line test.",
                Arrays.asList(new WorkedExample("Example for Relations and Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Relations and Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("linear-functions", "Linear Functions", "3-2",
            "Evaluate and graph linear functions.",
            "Chapter 3: Linear Functions", 13,
            Arrays.asList(new Section("Linear Functions", "Evaluate and graph linear functions.",
                Arrays.asList(new WorkedExample("Example for Linear Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Linear Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("transforming-linear-functions", "Transforming Linear Functions", "3-3",
            "Apply shifts, reflections, and stretches.",
            "Chapter 3: Linear Functions", 14,
            Arrays.asList(new Section("Transforming Linear Functions", "Apply shifts, reflections, and stretches.",
                Arrays.asList(new WorkedExample("Example for Transforming Linear Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Transforming Linear Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("arithmetic-sequences", "Arithmetic Sequences", "3-4",
            "Find terms and write rules for arithmetic sequences.",
            "Chapter 3: Linear Functions", 15,
            Arrays.asList(new Section("Arithmetic Sequences", "Find terms and write rules for arithmetic sequences.",
                Arrays.asList(new WorkedExample("Example for Arithmetic Sequences",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Arithmetic Sequences", "Always verify your answer")
        ));
        lessons.add(new LessonContent("scatter-plots-trend-lines", "Scatter Plots and Lines of Fit", "3-5",
            "Draw and interpret scatter plots and trend lines.",
            "Chapter 3: Linear Functions", 16,
            Arrays.asList(new Section("Scatter Plots and Lines of Fit", "Draw and interpret scatter plots and trend lines.",
                Arrays.asList(new WorkedExample("Example for Scatter Plots and Lines of Fit",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Scatter Plots and Lines of Fit", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-systems-graphing", "Solving Systems by Graphing", "4-1",
            "Solve systems by graphing intersections.",
            "Chapter 4: Systems of Linear Equations", 17,
            Arrays.asList(new Section("Solving Systems by Graphing", "Solve systems by graphing intersections.",
                Arrays.asList(new WorkedExample("Example for Solving Systems by Graphing",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving Systems by Graphing", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-systems-substitution", "Solving Systems by Substitution", "4-2",
            "Use substitution to solve systems.",
            "Chapter 4: Systems of Linear Equations", 18,
            Arrays.asList(new Section("Solving Systems by Substitution", "Use substitution to solve systems.",
                Arrays.asList(new WorkedExample("Example for Solving Systems by Substitution",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving Systems by Substitution", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-systems-elimination", "Solving Systems by Elimination", "4-3",
            "Use elimination to solve systems.",
            "Chapter 4: Systems of Linear Equations", 19,
            Arrays.asList(new Section("Solving Systems by Elimination", "Use elimination to solve systems.",
                Arrays.asList(new WorkedExample("Example for Solving Systems by Elimination",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving Systems by Elimination", "Always verify your answer")
        ));
        lessons.add(new LessonContent("linear-inequalities-two-var", "Linear Inequalities in Two Variables", "4-4",
            "Graph linear inequalities in two variables.",
            "Chapter 4: Systems of Linear Equations", 20,
            Arrays.asList(new Section("Linear Inequalities in Two Variables", "Graph linear inequalities in two variables.",
                Arrays.asList(new WorkedExample("Example for Linear Inequalities in Two Variables",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Linear Inequalities in Two Variables", "Always verify your answer")
        ));
        lessons.add(new LessonContent("systems-of-inequalities", "Systems of Linear Inequalities", "4-5",
            "Graph systems of inequalities.",
            "Chapter 4: Systems of Linear Equations", 21,
            Arrays.asList(new Section("Systems of Linear Inequalities", "Graph systems of inequalities.",
                Arrays.asList(new WorkedExample("Example for Systems of Linear Inequalities",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Systems of Linear Inequalities", "Always verify your answer")
        ));
        lessons.add(new LessonContent("piecewise-functions", "Piecewise-Defined Functions", "5-1",
            "Evaluate and graph piecewise functions.",
            "Chapter 5: Piecewise Functions", 22,
            Arrays.asList(new Section("Piecewise-Defined Functions", "Evaluate and graph piecewise functions.",
                Arrays.asList(new WorkedExample("Example for Piecewise-Defined Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Piecewise-Defined Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("step-functions", "Step Functions", "5-2",
            "Graph and interpret step functions.",
            "Chapter 5: Piecewise Functions", 23,
            Arrays.asList(new Section("Step Functions", "Graph and interpret step functions.",
                Arrays.asList(new WorkedExample("Example for Step Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Step Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("absolute-value-functions", "Absolute Value Functions", "5-3",
            "Graph and transform absolute value functions.",
            "Chapter 5: Piecewise Functions", 24,
            Arrays.asList(new Section("Absolute Value Functions", "Graph and transform absolute value functions.",
                Arrays.asList(new WorkedExample("Example for Absolute Value Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Absolute Value Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("exponential-growth", "Exponential Growth", "6-1",
            "Model and graph exponential growth.",
            "Chapter 6: Exponential Functions", 25,
            Arrays.asList(new Section("Exponential Growth", "Model and graph exponential growth.",
                Arrays.asList(new WorkedExample("Example for Exponential Growth",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Exponential Growth", "Always verify your answer")
        ));
        lessons.add(new LessonContent("exponential-decay", "Exponential Decay", "6-2",
            "Model and graph exponential decay.",
            "Chapter 6: Exponential Functions", 26,
            Arrays.asList(new Section("Exponential Decay", "Model and graph exponential decay.",
                Arrays.asList(new WorkedExample("Example for Exponential Decay",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Exponential Decay", "Always verify your answer")
        ));
        lessons.add(new LessonContent("geometric-sequences", "Geometric Sequences", "6-3",
            "Find terms and common ratios.",
            "Chapter 6: Exponential Functions", 27,
            Arrays.asList(new Section("Geometric Sequences", "Find terms and common ratios.",
                Arrays.asList(new WorkedExample("Example for Geometric Sequences",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Geometric Sequences", "Always verify your answer")
        ));
        lessons.add(new LessonContent("exponential-models", "Exponential Function Models", "6-4",
            "Write exponential models from data.",
            "Chapter 6: Exponential Functions", 28,
            Arrays.asList(new Section("Exponential Function Models", "Write exponential models from data.",
                Arrays.asList(new WorkedExample("Example for Exponential Function Models",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Exponential Function Models", "Always verify your answer")
        ));
        lessons.add(new LessonContent("adding-subtracting-poly", "Adding and Subtracting Polynomials", "7-1",
            "Combine like terms in polynomials.",
            "Chapter 7: Polynomials and Factoring", 29,
            Arrays.asList(new Section("Adding and Subtracting Polynomials", "Combine like terms in polynomials.",
                Arrays.asList(new WorkedExample("Example for Adding and Subtracting Polynomials",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Adding and Subtracting Polynomials", "Always verify your answer")
        ));
        lessons.add(new LessonContent("multiplying-polynomials", "Multiplying Polynomials", "7-2",
            "Distribute and FOIL to multiply.",
            "Chapter 7: Polynomials and Factoring", 30,
            Arrays.asList(new Section("Multiplying Polynomials", "Distribute and FOIL to multiply.",
                Arrays.asList(new WorkedExample("Example for Multiplying Polynomials",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Multiplying Polynomials", "Always verify your answer")
        ));
        lessons.add(new LessonContent("special-products", "Special Products of Binomials", "7-3",
            "Apply patterns for squares and differences.",
            "Chapter 7: Polynomials and Factoring", 31,
            Arrays.asList(new Section("Special Products of Binomials", "Apply patterns for squares and differences.",
                Arrays.asList(new WorkedExample("Example for Special Products of Binomials",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Special Products of Binomials", "Always verify your answer")
        ));
        lessons.add(new LessonContent("factoring-gcf", "Factoring Using the GCF", "7-4",
            "Factor out the greatest common factor.",
            "Chapter 7: Polynomials and Factoring", 32,
            Arrays.asList(new Section("Factoring Using the GCF", "Factor out the greatest common factor.",
                Arrays.asList(new WorkedExample("Example for Factoring Using the GCF",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Factoring Using the GCF", "Always verify your answer")
        ));
        lessons.add(new LessonContent("factoring-trinomials-1", "Factoring Trinomials (a=1)", "7-5",
            "Factor trinomials with leading coefficient 1.",
            "Chapter 7: Polynomials and Factoring", 33,
            Arrays.asList(new Section("Factoring Trinomials (a=1)", "Factor trinomials with leading coefficient 1.",
                Arrays.asList(new WorkedExample("Example for Factoring Trinomials (a=1)",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Factoring Trinomials (a=1)", "Always verify your answer")
        ));
        lessons.add(new LessonContent("factoring-trinomials-a", "Factoring Trinomials (a not 1)", "7-6",
            "Factor trinomials with any leading coefficient.",
            "Chapter 7: Polynomials and Factoring", 34,
            Arrays.asList(new Section("Factoring Trinomials (a not 1)", "Factor trinomials with any leading coefficient.",
                Arrays.asList(new WorkedExample("Example for Factoring Trinomials (a not 1)",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Factoring Trinomials (a not 1)", "Always verify your answer")
        ));
        lessons.add(new LessonContent("factoring-special-cases", "Factoring Special Cases", "7-7",
            "Factor perfect squares and difference of squares.",
            "Chapter 7: Polynomials and Factoring", 35,
            Arrays.asList(new Section("Factoring Special Cases", "Factor perfect squares and difference of squares.",
                Arrays.asList(new WorkedExample("Example for Factoring Special Cases",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Factoring Special Cases", "Always verify your answer")
        ));
        lessons.add(new LessonContent("graphing-standard-form", "Graphing Quadratics (Standard)", "8-1",
            "Graph quadratics finding vertex and axis.",
            "Chapter 8: Quadratic Functions", 36,
            Arrays.asList(new Section("Graphing Quadratics (Standard)", "Graph quadratics finding vertex and axis.",
                Arrays.asList(new WorkedExample("Example for Graphing Quadratics (Standard)",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Graphing Quadratics (Standard)", "Always verify your answer")
        ));
        lessons.add(new LessonContent("graphing-vertex-form", "Graphing Quadratics (Vertex Form)", "8-2",
            "Graph using transformations of vertex form.",
            "Chapter 8: Quadratic Functions", 37,
            Arrays.asList(new Section("Graphing Quadratics (Vertex Form)", "Graph using transformations of vertex form.",
                Arrays.asList(new WorkedExample("Example for Graphing Quadratics (Vertex Form)",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Graphing Quadratics (Vertex Form)", "Always verify your answer")
        ));
        lessons.add(new LessonContent("modeling-quadratics", "Modeling With Quadratics", "8-3",
            "Write quadratic models for real situations.",
            "Chapter 8: Quadratic Functions", 38,
            Arrays.asList(new Section("Modeling With Quadratics", "Write quadratic models for real situations.",
                Arrays.asList(new WorkedExample("Example for Modeling With Quadratics",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Modeling With Quadratics", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-quadratics-graphing", "Solving by Graphing", "9-1",
            "Find solutions as x-intercepts.",
            "Chapter 9: Solving Quadratic Equations", 39,
            Arrays.asList(new Section("Solving by Graphing", "Find solutions as x-intercepts.",
                Arrays.asList(new WorkedExample("Example for Solving by Graphing",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving by Graphing", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-quadratics-factoring", "Solving by Factoring", "9-2",
            "Apply zero-product property.",
            "Chapter 9: Solving Quadratic Equations", 40,
            Arrays.asList(new Section("Solving by Factoring", "Apply zero-product property.",
                Arrays.asList(new WorkedExample("Example for Solving by Factoring",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving by Factoring", "Always verify your answer")
        ));
        lessons.add(new LessonContent("completing-the-square", "Completing the Square", "9-3",
            "Solve by completing the square.",
            "Chapter 9: Solving Quadratic Equations", 41,
            Arrays.asList(new Section("Completing the Square", "Solve by completing the square.",
                Arrays.asList(new WorkedExample("Example for Completing the Square",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Completing the Square", "Always verify your answer")
        ));
        lessons.add(new LessonContent("quadratic-formula", "The Quadratic Formula", "9-4",
            "Apply the quadratic formula.",
            "Chapter 9: Solving Quadratic Equations", 42,
            Arrays.asList(new Section("The Quadratic Formula", "Apply the quadratic formula.",
                Arrays.asList(new WorkedExample("Example for The Quadratic Formula",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from The Quadratic Formula", "Always verify your answer")
        ));
        lessons.add(new LessonContent("choosing-a-method", "Choosing a Method", "9-5",
            "Select the best solving method.",
            "Chapter 9: Solving Quadratic Equations", 43,
            Arrays.asList(new Section("Choosing a Method", "Select the best solving method.",
                Arrays.asList(new WorkedExample("Example for Choosing a Method",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Choosing a Method", "Always verify your answer")
        ));
        lessons.add(new LessonContent("square-root-functions", "Square Root Functions", "10-1",
            "Graph and transform square root functions.",
            "Chapter 10: Radical Expressions", 44,
            Arrays.asList(new Section("Square Root Functions", "Graph and transform square root functions.",
                Arrays.asList(new WorkedExample("Example for Square Root Functions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Square Root Functions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("simplifying-radicals", "Simplifying Radicals", "10-2",
            "Simplify radical expressions.",
            "Chapter 10: Radical Expressions", 45,
            Arrays.asList(new Section("Simplifying Radicals", "Simplify radical expressions.",
                Arrays.asList(new WorkedExample("Example for Simplifying Radicals",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Simplifying Radicals", "Always verify your answer")
        ));
        lessons.add(new LessonContent("operations-with-radicals", "Operations With Radicals", "10-3",
            "Add, subtract, multiply radicals.",
            "Chapter 10: Radical Expressions", 46,
            Arrays.asList(new Section("Operations With Radicals", "Add, subtract, multiply radicals.",
                Arrays.asList(new WorkedExample("Example for Operations With Radicals",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Operations With Radicals", "Always verify your answer")
        ));
        lessons.add(new LessonContent("solving-radical-equations", "Solving Radical Equations", "10-4",
            "Solve equations containing radicals.",
            "Chapter 10: Radical Expressions", 47,
            Arrays.asList(new Section("Solving Radical Equations", "Solve equations containing radicals.",
                Arrays.asList(new WorkedExample("Example for Solving Radical Equations",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Solving Radical Equations", "Always verify your answer")
        ));
        lessons.add(new LessonContent("measures-of-center", "Measures of Center and Spread", "11-1",
            "Calculate mean, median, mode, range, SD.",
            "Chapter 11: Data Analysis", 48,
            Arrays.asList(new Section("Measures of Center and Spread", "Calculate mean, median, mode, range, SD.",
                Arrays.asList(new WorkedExample("Example for Measures of Center and Spread",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Measures of Center and Spread", "Always verify your answer")
        ));
        lessons.add(new LessonContent("box-plots", "Box Plots and Distributions", "11-2",
            "Create box plots and describe distributions.",
            "Chapter 11: Data Analysis", 49,
            Arrays.asList(new Section("Box Plots and Distributions", "Create box plots and describe distributions.",
                Arrays.asList(new WorkedExample("Example for Box Plots and Distributions",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Box Plots and Distributions", "Always verify your answer")
        ));
        lessons.add(new LessonContent("two-way-tables", "Two-Way Frequency Tables", "11-3",
            "Organize and analyze categorical data.",
            "Chapter 11: Data Analysis", 50,
            Arrays.asList(new Section("Two-Way Frequency Tables", "Organize and analyze categorical data.",
                Arrays.asList(new WorkedExample("Example for Two-Way Frequency Tables",
                    Arrays.asList("Step 1: Identify what is given", "Step 2: Apply the method", "Step 3: Solve and simplify"), "Solution")))),
            Arrays.asList("Key concept from Two-Way Frequency Tables", "Always verify your answer")
        ));
    }
}