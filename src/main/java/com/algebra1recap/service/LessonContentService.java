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
    public LessonContentService() { this.lessons = new ArrayList<>(); initializeLessons(); }
    public List<LessonContent> getAllLessons() { return lessons; }
    public Optional<LessonContent> getLessonBySlug(String slug) { return lessons.stream().filter(l -> l.getSlug().equals(slug)).findFirst(); }
    public Map<String, List<LessonContent>> getLessonsByChapter() {
        LinkedHashMap<String, List<LessonContent>> map = new LinkedHashMap<>();
        for (LessonContent l : lessons) map.computeIfAbsent(l.getChapter(), k -> new ArrayList<>()).add(l);
        return map;
    }
    private void initializeLessons() {
        lessons.add(new LessonContent("solving-one-variable-eq", "Solving Equations in One Variable", "1-1", "Solve linear equations using properties of equality.", "Chapter 1: Solving Equations and Inequalities", 1,
            Arrays.asList(new Section("Concepts and Examples", "Solve linear equations using properties of equality.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving Equations in One Variable</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: 3x + 7 = 22", Arrays.asList("Subtract 7: 3x = 15", "Divide by 3: x = 5", "Check: 3(5)+7=22"), "x = 5"),
            new WorkedExample("Solve: 2(x-4) = 10", Arrays.asList("Distribute: 2x-8=10", "Add 8: 2x=18", "Divide: x=9"), "x = 9"),
            new WorkedExample("Solve: 5x-3 = 2x+9", Arrays.asList("Subtract 2x: 3x-3=9", "Add 3: 3x=12", "x=4"), "x = 4"),
            new WorkedExample("Solve: (x+5)/3 = 4", Arrays.asList("Multiply by 3: x+5=12", "Subtract 5: x=7"), "x = 7"),
            new WorkedExample("Solve: 4(2x+1)=3(x-2)+5x", Arrays.asList("8x+4=3x-6+5x", "8x+4=8x-6", "4=-6 contradiction"), "No solution")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("literal-equations", "Literal Equations and Formulas", "1-2", "Rearrange formulas to solve for any variable.", "Chapter 1: Solving Equations and Inequalities", 2,
            Arrays.asList(new Section("Concepts and Examples", "Rearrange formulas to solve for any variable.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Literal Equations and Formulas</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve for h: A=(1/2)bh", Arrays.asList("Multiply by 2: 2A=bh", "Divide by b: h=2A/b"), "h = 2A/b"),
            new WorkedExample("Solve for r: C=2*pi*r", Arrays.asList("Divide by 2*pi: r=C/(2*pi)"), "r = C/(2pi)"),
            new WorkedExample("Solve for y: 3x+2y=12", Arrays.asList("Subtract 3x: 2y=12-3x", "Divide by 2: y=6-(3/2)x"), "y = 6-(3/2)x"),
            new WorkedExample("Solve for F: C=(5/9)(F-32)", Arrays.asList("Multiply by 9/5: (9/5)C=F-32", "Add 32: F=(9/5)C+32"), "F = (9/5)C+32"),
            new WorkedExample("Solve for t: d=rt+s", Arrays.asList("Subtract s: d-s=rt", "Divide by r: t=(d-s)/r"), "t = (d-s)/r")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-inequalities", "Solving Inequalities in One Variable", "1-3", "Solve and graph linear inequalities on a number line.", "Chapter 1: Solving Equations and Inequalities", 3,
            Arrays.asList(new Section("Concepts and Examples", "Solve and graph linear inequalities on a number line.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving Inequalities in One Variable</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: -2x+5 > 11", Arrays.asList("Subtract 5: -2x>6", "Divide by -2 (FLIP): x<-3"), "x < -3"),
            new WorkedExample("Solve: 3(x-1) >= 2x+4", Arrays.asList("3x-3>=2x+4", "x-3>=4", "x>=7"), "x >= 7"),
            new WorkedExample("Solve: 4x+1 < 13", Arrays.asList("4x<12", "x<3"), "x < 3"),
            new WorkedExample("Solve: -x/2 >= 4", Arrays.asList("Multiply by -2 (FLIP): x<=-8"), "x <= -8"),
            new WorkedExample("Solve: 5-2x < 11", Arrays.asList("Subtract 5: -2x<6", "Divide -2 (FLIP): x>-3"), "x > -3")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("compound-inequalities", "Compound Inequalities", "1-4", "Solve AND and OR compound inequalities.", "Chapter 1: Solving Equations and Inequalities", 4,
            Arrays.asList(new Section("Concepts and Examples", "Solve AND and OR compound inequalities.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Compound Inequalities</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: -1<2x+3<=9", Arrays.asList("Subtract 3: -4<2x<=6", "Divide 2: -2<x<=3"), "(-2, 3]"),
            new WorkedExample("Solve: x>2 AND x<7", Arrays.asList("Intersection of both", "2<x<7"), "(2, 7)"),
            new WorkedExample("Solve: x<-1 OR x>5", Arrays.asList("Union of both regions"), "(-inf,-1) U (5,inf)"),
            new WorkedExample("Solve: 3<=2x-1<7", Arrays.asList("Add 1: 4<=2x<8", "Divide 2: 2<=x<4"), "[2, 4)"),
            new WorkedExample("Solve: 2x<-4 OR 3x>12", Arrays.asList("x<-2 OR x>4"), "(-inf,-2) U (4,inf)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("absolute-value-equations", "Absolute Value Equations", "1-5", "Solve equations involving absolute value expressions.", "Chapter 1: Solving Equations and Inequalities", 5,
            Arrays.asList(new Section("Concepts and Examples", "Solve equations involving absolute value expressions.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Absolute Value Equations</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: |x-3|=7", Arrays.asList("x-3=7 gives x=10", "x-3=-7 gives x=-4"), "x=10 or x=-4"),
            new WorkedExample("Solve: |2x+1|=5", Arrays.asList("2x+1=5 gives x=2", "2x+1=-5 gives x=-3"), "x=2 or x=-3"),
            new WorkedExample("Solve: |x+5|=-2", Arrays.asList("Absolute value cannot be negative"), "No solution"),
            new WorkedExample("Solve: 3|x-2|=12", Arrays.asList("Divide: |x-2|=4", "x=6 or x=-2"), "x=6 or x=-2"),
            new WorkedExample("Solve: |4x-8|=0", Arrays.asList("4x-8=0", "x=2"), "x = 2")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("absolute-value-inequalities", "Absolute Value Inequalities", "1-6", "Solve and graph absolute value inequalities.", "Chapter 1: Solving Equations and Inequalities", 6,
            Arrays.asList(new Section("Concepts and Examples", "Solve and graph absolute value inequalities.",
                "<svg viewBox=\"0 0 320 80\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"80\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"20\" y1=\"50\" x2=\"300\" y2=\"50\" stroke=\"#6c5ce7\" stroke-width=\"2\"/><circle cx=\"160\" cy=\"50\" r=\"5\" fill=\"#6c5ce7\"/><text x=\"160\" y=\"30\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Absolute Value Inequalities</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: |x-2|<5", Arrays.asList("-5<x-2<5", "Add 2: -3<x<7"), "(-3, 7)"),
            new WorkedExample("Solve: |2x+1|>=3", Arrays.asList("2x+1>=3: x>=1", "2x+1<=-3: x<=-2"), "(-inf,-2] U [1,inf)"),
            new WorkedExample("Solve: |x|<4", Arrays.asList("-4<x<4"), "(-4, 4)"),
            new WorkedExample("Solve: |x+3|>2", Arrays.asList("x+3>2: x>-1", "x+3<-2: x<-5"), "(-inf,-5) U (-1,inf)"),
            new WorkedExample("Solve: |3x-6|<=9", Arrays.asList("-9<=3x-6<=9", "Add 6: -3<=3x<=15", "-1<=x<=5"), "[-1, 5]")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("slope-and-rate-of-change", "Slope and Rate of Change", "2-1", "Calculate slope and interpret rate of change.", "Chapter 2: Linear Equations", 7,
            Arrays.asList(new Section("Concepts and Examples", "Calculate slope and interpret rate of change.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Slope and Rate of Change</text></svg>",
                Arrays.asList(
            new WorkedExample("Find slope through (2,5) and (4,9)", Arrays.asList("m=(9-5)/(4-2)", "m=4/2=2"), "m = 2"),
            new WorkedExample("Find slope through (-1,4) and (3,-2)", Arrays.asList("m=(-2-4)/(3-(-1))", "m=-6/4=-3/2"), "m = -3/2"),
            new WorkedExample("Find slope of y=3x-7", Arrays.asList("In y=mx+b, m is the coefficient of x"), "m = 3"),
            new WorkedExample("Find slope of 2x+4y=8", Arrays.asList("Solve for y: 4y=-2x+8", "y=(-1/2)x+2"), "m = -1/2"),
            new WorkedExample("A line rises 6 units over 3 horizontal units. Slope?", Arrays.asList("slope=rise/run=6/3"), "m = 2")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("slope-intercept-form", "Slope-Intercept Form", "2-2", "Write and graph equations in y=mx+b form.", "Chapter 2: Linear Equations", 8,
            Arrays.asList(new Section("Concepts and Examples", "Write and graph equations in y=mx+b form.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Slope-Intercept Form</text></svg>",
                Arrays.asList(
            new WorkedExample("Write equation: slope 3, y-intercept -2", Arrays.asList("Use y=mx+b", "m=3, b=-2"), "y = 3x-2"),
            new WorkedExample("Find slope and y-int of y=-2x+5", Arrays.asList("m=-2 (coefficient of x)", "b=5 (constant)"), "slope=-2, y-int=5"),
            new WorkedExample("Write equation through (0,4) with slope -1", Arrays.asList("b=4 (passes through y-axis)", "y=-x+4"), "y = -x+4"),
            new WorkedExample("Convert 2x+y=6 to slope-intercept", Arrays.asList("Subtract 2x: y=-2x+6"), "y = -2x+6"),
            new WorkedExample("Graph y=(3/4)x+1: find two points", Arrays.asList("x=0: y=1, point (0,1)", "x=4: y=4, point (4,4)"), "Points: (0,1) and (4,4)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("point-slope-form", "Point-Slope Form", "2-3", "Write equations using point-slope form.", "Chapter 2: Linear Equations", 9,
            Arrays.asList(new Section("Concepts and Examples", "Write equations using point-slope form.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Point-Slope Form</text></svg>",
                Arrays.asList(
            new WorkedExample("Write equation: m=3, through (2,5)", Arrays.asList("y-5=3(x-2)", "y-5=3x-6", "y=3x-1"), "y-5=3(x-2) or y=3x-1"),
            new WorkedExample("Write equation through (1,2) and (3,8)", Arrays.asList("m=(8-2)/(3-1)=3", "y-2=3(x-1)"), "y-2=3(x-1)"),
            new WorkedExample("Convert y-3=2(x-1) to slope-intercept", Arrays.asList("y-3=2x-2", "y=2x+1"), "y = 2x+1"),
            new WorkedExample("Write equation: m=-1, through (4,0)", Arrays.asList("y-0=-1(x-4)", "y=-(x-4)=-x+4"), "y = -x+4"),
            new WorkedExample("Write equation: m=1/2, through (-2,4)", Arrays.asList("y-4=(1/2)(x-(-2))", "y-4=(1/2)(x+2)", "y=(1/2)x+5"), "y = (1/2)x+5")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("standard-form", "Standard Form", "2-4", "Convert between forms and use Ax+By=C.", "Chapter 2: Linear Equations", 10,
            Arrays.asList(new Section("Concepts and Examples", "Convert between forms and use Ax+By=C.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Standard Form</text></svg>",
                Arrays.asList(
            new WorkedExample("Convert y=2x-3 to standard form", Arrays.asList("Subtract 2x: -2x+y=-3", "Multiply by -1: 2x-y=3"), "2x-y = 3"),
            new WorkedExample("Find intercepts of 3x+4y=12", Arrays.asList("x-int: set y=0, x=4", "y-int: set x=0, y=3"), "(4,0) and (0,3)"),
            new WorkedExample("Find slope from 4x-2y=8", Arrays.asList("Solve for y: -2y=-4x+8", "y=2x-4, slope=2"), "m = 2"),
            new WorkedExample("Write in standard form: through (2,1) and (4,5)", Arrays.asList("m=(5-1)/(4-2)=2", "y-1=2(x-2), y=2x-3", "2x-y=3"), "2x-y = 3"),
            new WorkedExample("Is 5x-y=10 satisfied by (2,0)?", Arrays.asList("5(2)-0=10", "10=10, yes"), "Yes")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("parallel-perpendicular", "Parallel and Perpendicular Lines", "2-5", "Write equations of parallel and perpendicular lines.", "Chapter 2: Linear Equations", 11,
            Arrays.asList(new Section("Concepts and Examples", "Write equations of parallel and perpendicular lines.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Parallel and Perpendicular Lines</text></svg>",
                Arrays.asList(
            new WorkedExample("Line parallel to y=3x+1 through (0,5)", Arrays.asList("Same slope m=3", "y=3x+5"), "y = 3x+5"),
            new WorkedExample("Perpendicular to y=2x-1: find slope", Arrays.asList("Negative reciprocal of 2", "m=-1/2"), "m = -1/2"),
            new WorkedExample("Perp to y=-4x+3 through (8,1)", Arrays.asList("m=1/4", "y-1=(1/4)(x-8)", "y=(1/4)x-1"), "y = (1/4)x-1"),
            new WorkedExample("Are y=2x+1 and y=2x-3 parallel?", Arrays.asList("Same slope (m=2)", "Yes, parallel"), "Yes"),
            new WorkedExample("Are y=3x and y=(-1/3)x perpendicular?", Arrays.asList("3*(-1/3)=-1", "Product is -1, yes"), "Yes")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("relations-and-functions", "Relations and Functions", "3-1", "Identify functions using the vertical line test.", "Chapter 3: Linear Functions", 12,
            Arrays.asList(new Section("Concepts and Examples", "Identify functions using the vertical line test.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Relations and Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("Is {(1,2),(1,3)} a function?", Arrays.asList("Input 1 maps to 2 AND 3", "Two outputs for same input"), "No"),
            new WorkedExample("Is {(2,4),(3,5),(4,6)} a function?", Arrays.asList("Each input has exactly one output"), "Yes"),
            new WorkedExample("Find domain of {(1,5),(2,7),(3,9)}", Arrays.asList("List all input values"), "Domain: {1,2,3}"),
            new WorkedExample("f(x)=2x+1. Find f(3)", Arrays.asList("f(3)=2(3)+1=7"), "f(3) = 7"),
            new WorkedExample("Does x=3 pass vertical line test?", Arrays.asList("Vertical line x=3 hits every y", "Not a function"), "No, not a function")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("linear-functions", "Linear Functions", "3-2", "Evaluate and graph linear functions.", "Chapter 3: Linear Functions", 13,
            Arrays.asList(new Section("Concepts and Examples", "Evaluate and graph linear functions.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Linear Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("f(x)=4x-3. Find f(2)", Arrays.asList("f(2)=4(2)-3=5"), "f(2) = 5"),
            new WorkedExample("f(x)=-x+7. Find f(0)", Arrays.asList("f(0)=-(0)+7=7"), "f(0) = 7"),
            new WorkedExample("f(x)=2x+1. Find x when f(x)=9", Arrays.asList("2x+1=9", "2x=8, x=4"), "x = 4"),
            new WorkedExample("f(x)=-3x+6. x-intercept?", Arrays.asList("Set f(x)=0: -3x+6=0", "x=2"), "(2, 0)"),
            new WorkedExample("Is f(x)=x^2 a linear function?", Arrays.asList("Degree is 2, not 1"), "No, it is quadratic")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("transforming-linear-functions", "Transforming Linear Functions", "3-3", "Apply shifts, reflections, and stretches.", "Chapter 3: Linear Functions", 14,
            Arrays.asList(new Section("Concepts and Examples", "Apply shifts, reflections, and stretches.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Transforming Linear Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("g(x)=f(x)+3 does what to f(x)=x?", Arrays.asList("Adds 3 to every output", "Shifts graph up 3"), "Shifts up 3"),
            new WorkedExample("g(x)=f(x-2) does what to f(x)=x?", Arrays.asList("Replaces x with x-2", "Shifts right 2"), "Shifts right 2"),
            new WorkedExample("g(x)=-f(x) does what to f(x)=x?", Arrays.asList("Negates output", "Reflects over x-axis"), "Reflects over x-axis"),
            new WorkedExample("g(x)=2f(x) does what to f(x)=x?", Arrays.asList("Multiplies output by 2", "Vertical stretch by 2"), "Vertical stretch by 2"),
            new WorkedExample("f(x)=x becomes g(x)=x+4. Describe.", Arrays.asList("Output increases by 4", "Vertical shift up 4"), "Shift up 4")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("arithmetic-sequences", "Arithmetic Sequences", "3-4", "Find terms and write rules for arithmetic sequences.", "Chapter 3: Linear Functions", 15,
            Arrays.asList(new Section("Concepts and Examples", "Find terms and write rules for arithmetic sequences.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Arithmetic Sequences</text></svg>",
                Arrays.asList(
            new WorkedExample("Find a10: a1=3, d=4", Arrays.asList("an=a1+(n-1)d", "a10=3+9(4)=39"), "a10 = 39"),
            new WorkedExample("Find d: sequence 2,5,8,11", Arrays.asList("d=5-2=3"), "d = 3"),
            new WorkedExample("Find a20: a1=2, d=3", Arrays.asList("a20=2+19(3)=59"), "a20 = 59"),
            new WorkedExample("Write rule: 5,8,11,14...", Arrays.asList("a1=5, d=3", "an=5+(n-1)(3)=3n+2"), "an = 3n+2"),
            new WorkedExample("Find S10: a1=2, d=3", Arrays.asList("a10=2+9(3)=29", "S10=10/2*(2+29)=155"), "S10 = 155")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("scatter-plots-trend-lines", "Scatter Plots and Lines of Fit", "3-5", "Draw and interpret scatter plots and trend lines.", "Chapter 3: Linear Functions", 16,
            Arrays.asList(new Section("Concepts and Examples", "Draw and interpret scatter plots and trend lines.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"140\" x2=\"260\" y2=\"40\" stroke=\"#6c5ce7\" stroke-width=\"3\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Scatter Plots and Lines of Fit</text></svg>",
                Arrays.asList(
            new WorkedExample("Describe correlation: as x increases, y increases", Arrays.asList("Both go up together"), "Positive correlation"),
            new WorkedExample("r=0.95 indicates what?", Arrays.asList("Close to 1"), "Strong positive correlation"),
            new WorkedExample("r=-0.87 indicates what?", Arrays.asList("Close to -1"), "Strong negative correlation"),
            new WorkedExample("What is an outlier?", Arrays.asList("Point far from the trend line"), "Data point far from pattern"),
            new WorkedExample("Line of best fit passes through (0,2) slope 3", Arrays.asList("y=3x+2"), "y = 3x+2")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-systems-graphing", "Solving Systems by Graphing", "4-1", "Solve systems by graphing intersections.", "Chapter 4: Systems of Linear Equations", 17,
            Arrays.asList(new Section("Concepts and Examples", "Solve systems by graphing intersections.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving Systems by Graphing</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve by graphing: y=x+1, y=-x+5", Arrays.asList("Lines cross where x+1=-x+5", "2x=4, x=2, y=3"), "(2, 3)"),
            new WorkedExample("Solve: y=2x, y=-x+6", Arrays.asList("2x=-x+6", "3x=6, x=2, y=4"), "(2, 4)"),
            new WorkedExample("y=3x-1 and y=3x+2 have how many solutions?", Arrays.asList("Same slope, different y-int", "Parallel lines"), "No solution"),
            new WorkedExample("y=2x+1 and 2y=4x+2 solutions?", Arrays.asList("Second: y=2x+1, same line"), "Infinite solutions"),
            new WorkedExample("Solve: y=x and y=5", Arrays.asList("x=5, y=5"), "(5, 5)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-systems-substitution", "Solving Systems by Substitution", "4-2", "Use substitution to solve systems.", "Chapter 4: Systems of Linear Equations", 18,
            Arrays.asList(new Section("Concepts and Examples", "Use substitution to solve systems.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving Systems by Substitution</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: x=y+1, 2x+y=8", Arrays.asList("Substitute: 2(y+1)+y=8", "3y+2=8, y=2, x=3"), "(3, 2)"),
            new WorkedExample("Solve: y=3x, x+y=12", Arrays.asList("x+3x=12", "4x=12, x=3, y=9"), "(3, 9)"),
            new WorkedExample("Solve: y=x-3, 3x-y=9", Arrays.asList("3x-(x-3)=9", "2x+3=9, x=3, y=0"), "(3, 0)"),
            new WorkedExample("Solve: x=5, 2x+3y=16", Arrays.asList("2(5)+3y=16", "3y=6, y=2"), "(5, 2)"),
            new WorkedExample("Solve: y=2x+1, 3x+2y=12", Arrays.asList("3x+2(2x+1)=12", "7x+2=12, x=10/7"), "(10/7, 27/7)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-systems-elimination", "Solving Systems by Elimination", "4-3", "Use elimination to solve systems.", "Chapter 4: Systems of Linear Equations", 19,
            Arrays.asList(new Section("Concepts and Examples", "Use elimination to solve systems.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving Systems by Elimination</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: x+y=7, x-y=3", Arrays.asList("Add: 2x=10, x=5", "y=7-5=2"), "(5, 2)"),
            new WorkedExample("Solve: 2x+3y=12, 4x-3y=6", Arrays.asList("Add: 6x=18, x=3", "2(3)+3y=12, y=2"), "(3, 2)"),
            new WorkedExample("Solve: 3x+y=10, x+y=4", Arrays.asList("Subtract: 2x=6, x=3", "y=4-3=1"), "(3, 1)"),
            new WorkedExample("Solve: 5x-2y=1, 3x+4y=24", Arrays.asList("Multiply 1st by 2: 10x-4y=2", "Add: 13x=26, x=2"), "(2, 4.5)"),
            new WorkedExample("Solve: x+y=5, 2x+2y=10", Arrays.asList("Second is 2x first", "Same line, infinite solutions"), "Infinite solutions")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("linear-inequalities-two-var", "Linear Inequalities in Two Variables", "4-4", "Graph linear inequalities in two variables.", "Chapter 4: Systems of Linear Equations", 20,
            Arrays.asList(new Section("Concepts and Examples", "Graph linear inequalities in two variables.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Linear Inequalities in Two Variables</text></svg>",
                Arrays.asList(
            new WorkedExample("Is (0,0) in y>2x-1?", Arrays.asList("Test: 0>2(0)-1", "0>-1, TRUE"), "Yes"),
            new WorkedExample("Is (3,1) in y<x+2?", Arrays.asList("Test: 1<3+2", "1<5, TRUE"), "Yes"),
            new WorkedExample("Graph y>x: boundary type?", Arrays.asList("Strict inequality", "Dashed line, shade above"), "Dashed line"),
            new WorkedExample("Graph y<=2x+1: boundary type?", Arrays.asList("Non-strict inequality", "Solid line, shade below"), "Solid line"),
            new WorkedExample("Shade above or below for y<-x+4?", Arrays.asList("Less than: shade below the line"), "Below")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("systems-of-inequalities", "Systems of Linear Inequalities", "4-5", "Graph systems of inequalities.", "Chapter 4: Systems of Linear Equations", 21,
            Arrays.asList(new Section("Concepts and Examples", "Graph systems of inequalities.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Systems of Linear Inequalities</text></svg>",
                Arrays.asList(
            new WorkedExample("System y>=x, y<=4, x>=0: feasible?", Arrays.asList("Triangle in Q1"), "Triangular region"),
            new WorkedExample("Vertices of x>=0, y>=0, x+y<=5?", Arrays.asList("(0,0), (5,0), (0,5)"), "3 vertices"),
            new WorkedExample("Max P=3x+2y subject to x+y<=6, x>=0, y>=0", Arrays.asList("Test vertices: (0,0),(6,0),(0,6)", "P(6,0)=18, P(0,6)=12"), "Max=18 at (6,0)"),
            new WorkedExample("Is (2,3) in x+y<=6 and x>=0 and y>=0?", Arrays.asList("2+3=5<=6, 2>=0, 3>=0, all true"), "Yes"),
            new WorkedExample("Is (4,4) in x+y<=6?", Arrays.asList("4+4=8>6, FALSE"), "No")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("piecewise-functions", "Piecewise-Defined Functions", "5-1", "Evaluate and graph piecewise functions.", "Chapter 5: Piecewise Functions", 22,
            Arrays.asList(new Section("Concepts and Examples", "Evaluate and graph piecewise functions.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Piecewise-Defined Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("f(x)={2x if x<0; x+1 if x>=0}. f(-3)?", Arrays.asList("x=-3<0, use 2x piece", "f(-3)=2(-3)=-6"), "f(-3) = -6"),
            new WorkedExample("f(x)={2x if x<0; x+1 if x>=0}. f(2)?", Arrays.asList("x=2>=0, use x+1 piece", "f(2)=2+1=3"), "f(2) = 3"),
            new WorkedExample("f(x)={x^2 if x<=1; 3 if x>1}. f(1)?", Arrays.asList("x=1<=1, use x^2", "f(1)=1"), "f(1) = 1"),
            new WorkedExample("f(x)={5 if x<2; 2x if x>=2}. f(2)?", Arrays.asList("x=2>=2, use 2x", "f(2)=4"), "f(2) = 4"),
            new WorkedExample("f(x)={-x if x<0; x if x>=0} is what function?", Arrays.asList("Negative becomes positive", "This is |x|"), "Absolute value function")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("step-functions", "Step Functions", "5-2", "Graph and interpret step functions.", "Chapter 5: Piecewise Functions", 23,
            Arrays.asList(new Section("Concepts and Examples", "Graph and interpret step functions.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Step Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("Find [3.7] (greatest integer)", Arrays.asList("Floor: largest integer <= 3.7"), "[3.7] = 3"),
            new WorkedExample("Find [-2.3]", Arrays.asList("Floor: largest integer <= -2.3"), "[-2.3] = -3"),
            new WorkedExample("Find [4]", Arrays.asList("Already an integer"), "[4] = 4"),
            new WorkedExample("Find [0.99]", Arrays.asList("Largest integer <= 0.99"), "[0.99] = 0"),
            new WorkedExample("Find [-0.1]", Arrays.asList("Largest integer <= -0.1"), "[-0.1] = -1")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("absolute-value-functions", "Absolute Value Functions", "5-3", "Graph and transform absolute value functions.", "Chapter 5: Piecewise Functions", 24,
            Arrays.asList(new Section("Concepts and Examples", "Graph and transform absolute value functions.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Absolute Value Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("Vertex of y=|x-3|+2?", Arrays.asList("Form y=|x-h|+k", "h=3, k=2"), "Vertex: (3, 2)"),
            new WorkedExample("y=|x| reflected over x-axis?", Arrays.asList("Negate the output"), "y = -|x|"),
            new WorkedExample("y=|x+4| shifts |x| how?", Arrays.asList("x+4 means left 4"), "Left 4 units"),
            new WorkedExample("y=2|x| compared to y=|x|?", Arrays.asList("Multiply output by 2"), "Vertical stretch by 2"),
            new WorkedExample("Vertex of y=-|x+1|-3?", Arrays.asList("h=-1, k=-3"), "Vertex: (-1, -3)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("exponential-growth", "Exponential Growth", "6-1", "Model and graph exponential growth.", "Chapter 6: Exponential Functions", 25,
            Arrays.asList(new Section("Concepts and Examples", "Model and graph exponential growth.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Exponential Growth</text></svg>",
                Arrays.asList(
            new WorkedExample("y=2^x. Find y when x=3", Arrays.asList("2^3=8"), "y = 8"),
            new WorkedExample("y=5*2^x. Find y when x=0", Arrays.asList("5*2^0=5*1=5"), "y = 5"),
            new WorkedExample("Population: 1000*1.05^t. Growth rate?", Arrays.asList("1.05-1=0.05=5%"), "5% per year"),
            new WorkedExample("y=3^x passes through what y-int?", Arrays.asList("3^0=1, point (0,1)"), "(0, 1)"),
            new WorkedExample("Double time: P=100*2^(t/5). Doubles every?", Arrays.asList("When t=5: 2^1=2"), "Every 5 units")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("exponential-decay", "Exponential Decay", "6-2", "Model and graph exponential decay.", "Chapter 6: Exponential Functions", 26,
            Arrays.asList(new Section("Concepts and Examples", "Model and graph exponential decay.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Exponential Decay</text></svg>",
                Arrays.asList(
            new WorkedExample("y=(1/2)^x. Growth or decay?", Arrays.asList("Base 1/2 is between 0 and 1"), "Decay"),
            new WorkedExample("y=500*(0.8)^t. After t=2?", Arrays.asList("500*0.64=320"), "y = 320"),
            new WorkedExample("Half-life: 100*(1/2)^(t/4). After 12 units?", Arrays.asList("(1/2)^3=1/8", "100/8=12.5"), "12.5"),
            new WorkedExample("Car: $20000, depreciates 15%/yr. Model?", Arrays.asList("Multiply by (1-0.15)=0.85 each year"), "y = 20000*(0.85)^t"),
            new WorkedExample("Decay rate if factor is 0.92?", Arrays.asList("1-0.92=0.08=8%"), "8% decay rate")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("geometric-sequences", "Geometric Sequences", "6-3", "Find terms and common ratios.", "Chapter 6: Exponential Functions", 27,
            Arrays.asList(new Section("Concepts and Examples", "Find terms and common ratios.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Geometric Sequences</text></svg>",
                Arrays.asList(
            new WorkedExample("Ratio of 2,6,18,54?", Arrays.asList("6/2=3"), "r = 3"),
            new WorkedExample("a1=5, r=2. Find a4?", Arrays.asList("5*2^3=40"), "a4 = 40"),
            new WorkedExample("a1=100, r=1/2. Find a5?", Arrays.asList("100*(1/2)^4=6.25"), "a5 = 6.25"),
            new WorkedExample("Is 1,4,9,16 geometric?", Arrays.asList("4/1=4, 9/4=2.25, not constant"), "No"),
            new WorkedExample("a1=3, r=4. Find a3?", Arrays.asList("3*4^2=48"), "a3 = 48")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("exponential-models", "Exponential Function Models", "6-4", "Write exponential models from data.", "Chapter 6: Exponential Functions", 28,
            Arrays.asList(new Section("Concepts and Examples", "Write exponential models from data.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"40\" y1=\"20\" x2=\"40\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><path d=\"M 50 155 Q 140 150 200 90 Q 260 30 280 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Exponential Function Models</text></svg>",
                Arrays.asList(
            new WorkedExample("Points (0,3)(1,6)(2,12). Model?", Arrays.asList("Doubles: r=2, a=3"), "y = 3*2^x"),
            new WorkedExample("y=a*b^x and y(0)=5. Find a.", Arrays.asList("At x=0: a*1=5"), "a = 5"),
            new WorkedExample("Growth factor 1.08 means?", Arrays.asList("1+r=1.08, r=0.08"), "8% growth"),
            new WorkedExample("Decay factor 0.95 means?", Arrays.asList("1-r=0.95, r=0.05"), "5% decay"),
            new WorkedExample("$1000 at 6% yearly for 5 years?", Arrays.asList("1000*1.06^5=1338.23"), "$1338.23")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("adding-subtracting-poly", "Adding and Subtracting Polynomials", "7-1", "Combine like terms in polynomials.", "Chapter 7: Polynomials and Factoring", 29,
            Arrays.asList(new Section("Concepts and Examples", "Combine like terms in polynomials.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Adding and Subtracting Polynomials</text></svg>",
                Arrays.asList(
            new WorkedExample("(3x^2+2x)+(x^2-4x)", Arrays.asList("Combine: 4x^2-2x"), "4x^2-2x"),
            new WorkedExample("(5x^2-x+3)-(2x^2+4x-1)", Arrays.asList("5x^2-x+3-2x^2-4x+1", "3x^2-5x+4"), "3x^2-5x+4"),
            new WorkedExample("Degree of 4x^3-x^2+7?", Arrays.asList("Highest power is 3"), "Degree 3"),
            new WorkedExample("(x^2+3)+(2x^2-1)", Arrays.asList("3x^2+2"), "3x^2+2"),
            new WorkedExample("(4x-2)-(x+5)", Arrays.asList("4x-2-x-5=3x-7"), "3x-7")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("multiplying-polynomials", "Multiplying Polynomials", "7-2", "Distribute and FOIL to multiply.", "Chapter 7: Polynomials and Factoring", 30,
            Arrays.asList(new Section("Concepts and Examples", "Distribute and FOIL to multiply.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Multiplying Polynomials</text></svg>",
                Arrays.asList(
            new WorkedExample("(x+3)(x-5)", Arrays.asList("x^2-5x+3x-15"), "x^2-2x-15"),
            new WorkedExample("(2x+1)(x-4)", Arrays.asList("2x^2-8x+x-4"), "2x^2-7x-4"),
            new WorkedExample("x(x^2+3x-2)", Arrays.asList("x^3+3x^2-2x"), "x^3+3x^2-2x"),
            new WorkedExample("(x+1)(x+1)", Arrays.asList("x^2+x+x+1"), "x^2+2x+1"),
            new WorkedExample("(x-2)(x+2)", Arrays.asList("x^2+2x-2x-4"), "x^2-4")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("special-products", "Special Products of Binomials", "7-3", "Apply patterns for squares and differences.", "Chapter 7: Polynomials and Factoring", 31,
            Arrays.asList(new Section("Concepts and Examples", "Apply patterns for squares and differences.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Special Products of Binomials</text></svg>",
                Arrays.asList(
            new WorkedExample("(x+5)^2", Arrays.asList("x^2+10x+25"), "x^2+10x+25"),
            new WorkedExample("(x-4)^2", Arrays.asList("x^2-8x+16"), "x^2-8x+16"),
            new WorkedExample("(x+3)(x-3)", Arrays.asList("x^2-9"), "x^2-9"),
            new WorkedExample("(2x+1)^2", Arrays.asList("4x^2+4x+1"), "4x^2+4x+1"),
            new WorkedExample("(3x-2)(3x+2)", Arrays.asList("9x^2-4"), "9x^2-4")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("factoring-gcf", "Factoring Using the GCF", "7-4", "Factor out the greatest common factor.", "Chapter 7: Polynomials and Factoring", 32,
            Arrays.asList(new Section("Concepts and Examples", "Factor out the greatest common factor.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Factoring Using the GCF</text></svg>",
                Arrays.asList(
            new WorkedExample("Factor: 6x^2+9x", Arrays.asList("GCF=3x", "3x(2x+3)"), "3x(2x+3)"),
            new WorkedExample("Factor: 4x^3-8x^2", Arrays.asList("GCF=4x^2", "4x^2(x-2)"), "4x^2(x-2)"),
            new WorkedExample("Factor: 5x+15", Arrays.asList("GCF=5", "5(x+3)"), "5(x+3)"),
            new WorkedExample("Factor: 12x^2y-8xy^2", Arrays.asList("GCF=4xy", "4xy(3x-2y)"), "4xy(3x-2y)"),
            new WorkedExample("Factor: x^3+x^2+x", Arrays.asList("GCF=x", "x(x^2+x+1)"), "x(x^2+x+1)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("factoring-trinomials-1", "Factoring Trinomials (a=1)", "7-5", "Factor trinomials with leading coefficient 1.", "Chapter 7: Polynomials and Factoring", 33,
            Arrays.asList(new Section("Concepts and Examples", "Factor trinomials with leading coefficient 1.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Factoring Trinomials (a=1)</text></svg>",
                Arrays.asList(
            new WorkedExample("Factor: x^2+5x+6", Arrays.asList("Find: multiply to 6, add to 5", "2 and 3"), "(x+2)(x+3)"),
            new WorkedExample("Factor: x^2-7x+12", Arrays.asList("Multiply to 12, add to -7", "-3 and -4"), "(x-3)(x-4)"),
            new WorkedExample("Factor: x^2+x-12", Arrays.asList("Multiply to -12, add to 1", "4 and -3"), "(x+4)(x-3)"),
            new WorkedExample("Factor: x^2-x-6", Arrays.asList("Multiply to -6, add to -1", "-3 and 2"), "(x-3)(x+2)"),
            new WorkedExample("Factor: x^2+8x+15", Arrays.asList("Multiply to 15, add to 8", "3 and 5"), "(x+3)(x+5)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("factoring-trinomials-a", "Factoring Trinomials (a not 1)", "7-6", "Factor trinomials with any leading coefficient.", "Chapter 7: Polynomials and Factoring", 34,
            Arrays.asList(new Section("Concepts and Examples", "Factor trinomials with any leading coefficient.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Factoring Trinomials (a not 1)</text></svg>",
                Arrays.asList(
            new WorkedExample("Factor: 2x^2+7x+3", Arrays.asList("ac=6, factors 6,1", "2x^2+6x+x+3"), "(2x+1)(x+3)"),
            new WorkedExample("Factor: 3x^2+10x+3", Arrays.asList("ac=9, factors 9,1"), "(3x+1)(x+3)"),
            new WorkedExample("Factor: 5x^2-7x+2", Arrays.asList("ac=10, factors -5,-2"), "(5x-2)(x-1)"),
            new WorkedExample("Factor: 2x^2-5x-3", Arrays.asList("ac=-6, factors -6,1"), "(2x+1)(x-3)"),
            new WorkedExample("Factor: 6x^2+x-2", Arrays.asList("ac=-12, factors 4,-3"), "(2x-1)(3x+2)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("factoring-special-cases", "Factoring Special Cases", "7-7", "Factor perfect squares and difference of squares.", "Chapter 7: Polynomials and Factoring", 35,
            Arrays.asList(new Section("Concepts and Examples", "Factor perfect squares and difference of squares.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Factoring Special Cases</text></svg>",
                Arrays.asList(
            new WorkedExample("Factor: x^2-25", Arrays.asList("Difference of squares", "a=x, b=5"), "(x+5)(x-5)"),
            new WorkedExample("Factor: 4x^2-9", Arrays.asList("(2x)^2-3^2"), "(2x+3)(2x-3)"),
            new WorkedExample("Factor: x^2+10x+25", Arrays.asList("Perfect square: (x+5)^2"), "(x+5)^2"),
            new WorkedExample("Factor: x^2-6x+9", Arrays.asList("Perfect square: (x-3)^2"), "(x-3)^2"),
            new WorkedExample("Factor: 16x^2-1", Arrays.asList("(4x)^2-1^2"), "(4x+1)(4x-1)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("graphing-standard-form", "Graphing Quadratics (Standard)", "8-1", "Graph quadratics finding vertex and axis.", "Chapter 8: Quadratic Functions", 36,
            Arrays.asList(new Section("Concepts and Examples", "Graph quadratics finding vertex and axis.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Graphing Quadratics (Standard)</text></svg>",
                Arrays.asList(
            new WorkedExample("Vertex of y=x^2-4x+3?", Arrays.asList("x=-b/2a=4/2=2", "y=4-8+3=-1"), "Vertex: (2,-1)"),
            new WorkedExample("Axis of symmetry of y=2x^2-8x+1?", Arrays.asList("x=-b/2a=8/4=2"), "x = 2"),
            new WorkedExample("y-intercept of y=x^2+3x-5?", Arrays.asList("f(0)=-5"), "(0, -5)"),
            new WorkedExample("Does y=-x^2+4x open up or down?", Arrays.asList("a=-1<0"), "Opens down"),
            new WorkedExample("Max or min of y=3x^2-6x+1?", Arrays.asList("a=3>0, opens up"), "Minimum")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("graphing-vertex-form", "Graphing Quadratics (Vertex Form)", "8-2", "Graph using transformations of vertex form.", "Chapter 8: Quadratic Functions", 37,
            Arrays.asList(new Section("Concepts and Examples", "Graph using transformations of vertex form.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Graphing Quadratics (Vertex Form)</text></svg>",
                Arrays.asList(
            new WorkedExample("Vertex of y=2(x-3)^2+1?", Arrays.asList("Read from form: h=3, k=1"), "(3, 1)"),
            new WorkedExample("Vertex of y=-(x+2)^2-4?", Arrays.asList("h=-2, k=-4"), "(-2, -4)"),
            new WorkedExample("y=(x-1)^2 shifts y=x^2 how?", Arrays.asList("Right 1 unit"), "Right 1"),
            new WorkedExample("y=x^2+5 shifts y=x^2 how?", Arrays.asList("Up 5 units"), "Up 5"),
            new WorkedExample("Convert y=x^2-6x+5 to vertex form", Arrays.asList("Complete: (x-3)^2-4"), "y = (x-3)^2-4")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("modeling-quadratics", "Modeling With Quadratics", "8-3", "Write quadratic models for real situations.", "Chapter 8: Quadratic Functions", 38,
            Arrays.asList(new Section("Concepts and Examples", "Write quadratic models for real situations.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Modeling With Quadratics</text></svg>",
                Arrays.asList(
            new WorkedExample("Ball: h=-16t^2+64t+5. Max height?", Arrays.asList("t=-64/-32=2", "h=64+128+5... h=-64+128+5=69"), "69 feet"),
            new WorkedExample("Revenue R=-2x^2+40x. Max?", Arrays.asList("x=-40/-4=10", "R=-200+400=200"), "$200"),
            new WorkedExample("y=-x^2+6x-5. x at max?", Arrays.asList("x=-6/-2=3"), "x = 3"),
            new WorkedExample("Area A=x(100-2x). Max?", Arrays.asList("x=100/4=25", "A=25*50=1250"), "1250 sq units"),
            new WorkedExample("Discriminant>0 means?", Arrays.asList("Two x-intercepts"), "2 real solutions")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-quadratics-graphing", "Solving by Graphing", "9-1", "Find solutions as x-intercepts.", "Chapter 9: Solving Quadratic Equations", 39,
            Arrays.asList(new Section("Concepts and Examples", "Find solutions as x-intercepts.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving by Graphing</text></svg>",
                Arrays.asList(
            new WorkedExample("x-intercepts of y=x^2-4?", Arrays.asList("Set y=0: x^2=4", "x=2,-2"), "x=2, x=-2"),
            new WorkedExample("y=x^2-5x+6 zeros?", Arrays.asList("Where graph crosses x-axis", "Factor: (x-2)(x-3)"), "x=2, x=3"),
            new WorkedExample("y=x^2+1 zeros?", Arrays.asList("x^2=-1, impossible"), "No real zeros"),
            new WorkedExample("y=(x-4)^2 zeros?", Arrays.asList("Touches at x=4"), "x=4 (double root)"),
            new WorkedExample("y=-(x-1)(x-5) zeros?", Arrays.asList("Set factors=0"), "x=1, x=5")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-quadratics-factoring", "Solving by Factoring", "9-2", "Apply zero-product property.", "Chapter 9: Solving Quadratic Equations", 40,
            Arrays.asList(new Section("Concepts and Examples", "Apply zero-product property.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Solving by Factoring</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: x^2+5x+6=0", Arrays.asList("(x+2)(x+3)=0"), "x=-2, x=-3"),
            new WorkedExample("Solve: x^2-x-12=0", Arrays.asList("(x-4)(x+3)=0"), "x=4, x=-3"),
            new WorkedExample("Solve: x^2-16=0", Arrays.asList("(x+4)(x-4)=0"), "x=4, x=-4"),
            new WorkedExample("Solve: x^2+6x=0", Arrays.asList("x(x+6)=0"), "x=0, x=-6"),
            new WorkedExample("Solve: 2x^2+x-6=0", Arrays.asList("(2x-3)(x+2)=0"), "x=3/2, x=-2")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("completing-the-square", "Completing the Square", "9-3", "Solve by completing the square.", "Chapter 9: Solving Quadratic Equations", 41,
            Arrays.asList(new Section("Concepts and Examples", "Solve by completing the square.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Completing the Square</text></svg>",
                Arrays.asList(
            new WorkedExample("Complete: x^2+8x+__", Arrays.asList("(8/2)^2=16"), "16"),
            new WorkedExample("Solve: x^2+6x-7=0", Arrays.asList("x^2+6x=7", "(x+3)^2=16", "x=-3+/-4"), "x=1, x=-7"),
            new WorkedExample("Solve: x^2-4x=5", Arrays.asList("(x-2)^2=9", "x=2+/-3"), "x=5, x=-1"),
            new WorkedExample("Solve: x^2+2x-8=0", Arrays.asList("(x+1)^2=9", "x=-1+/-3"), "x=2, x=-4"),
            new WorkedExample("Convert x^2-6x+5 to vertex form", Arrays.asList("(x-3)^2-4"), "y=(x-3)^2-4")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("quadratic-formula", "The Quadratic Formula", "9-4", "Apply the quadratic formula.", "Chapter 9: Solving Quadratic Equations", 42,
            Arrays.asList(new Section("Concepts and Examples", "Apply the quadratic formula.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">The Quadratic Formula</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: x^2+5x+3=0", Arrays.asList("x=(-5+/-sqrt(13))/2"), "x=(-5+/-sqrt13)/2"),
            new WorkedExample("Discriminant of x^2-4x+4?", Arrays.asList("16-16=0"), "D=0, one repeated root"),
            new WorkedExample("Solve: 2x^2-x-3=0", Arrays.asList("x=(1+/-sqrt(25))/4", "x=(1+/-5)/4"), "x=3/2, x=-1"),
            new WorkedExample("D of 3x^2+x+1?", Arrays.asList("1-12=-11<0"), "No real solutions"),
            new WorkedExample("Solve: x^2-6x+9=0", Arrays.asList("D=0", "x=6/2=3"), "x=3 (repeated)")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("choosing-a-method", "Choosing a Method", "9-5", "Select the best solving method.", "Chapter 9: Solving Quadratic Equations", 43,
            Arrays.asList(new Section("Concepts and Examples", "Select the best solving method.",
                "<svg viewBox=\"0 0 320 180\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"180\" fill=\"#f0edff\" rx=\"8\"/><line x1=\"40\" y1=\"160\" x2=\"290\" y2=\"160\" stroke=\"#333\" stroke-width=\"2\"/><line x1=\"160\" y1=\"20\" x2=\"160\" y2=\"160\" stroke=\"#333\" stroke-width=\"1\"/><path d=\"M 60 20 Q 160 170 260 20\" stroke=\"#6c5ce7\" stroke-width=\"3\" fill=\"none\"/><text x=\"160\" y=\"15\" text-anchor=\"middle\" font-size=\"11\" fill=\"#6c5ce7\">Choosing a Method</text></svg>",
                Arrays.asList(
            new WorkedExample("x^2-9=0: best method?", Arrays.asList("Already isolated, take sqrt"), "Square roots"),
            new WorkedExample("x^2+5x+6=0: best?", Arrays.asList("Easy integers"), "Factoring"),
            new WorkedExample("x^2+3x+1=0: best?", Arrays.asList("Not factorable easily"), "Quadratic formula"),
            new WorkedExample("(x-2)^2=7: best?", Arrays.asList("Already perfect square"), "Square roots"),
            new WorkedExample("3x^2-7x+2=0: approach?", Arrays.asList("Try factoring first, else formula"), "Factor or formula")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("square-root-functions", "Square Root Functions", "10-1", "Graph and transform square root functions.", "Chapter 10: Radical Expressions", 44,
            Arrays.asList(new Section("Concepts and Examples", "Graph and transform square root functions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Square Root Functions</text></svg>",
                Arrays.asList(
            new WorkedExample("Domain of y=sqrt(x)?", Arrays.asList("x must be >= 0"), "[0, inf)"),
            new WorkedExample("Domain of y=sqrt(x-3)?", Arrays.asList("x-3>=0, x>=3"), "[3, inf)"),
            new WorkedExample("y=sqrt(x)+2 shifts sqrt(x)?", Arrays.asList("Up 2"), "Up 2 units"),
            new WorkedExample("y=sqrt(x-4) shifts?", Arrays.asList("Right 4"), "Right 4 units"),
            new WorkedExample("y=sqrt(x) at x=9?", Arrays.asList("sqrt(9)=3"), "y = 3")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("simplifying-radicals", "Simplifying Radicals", "10-2", "Simplify radical expressions.", "Chapter 10: Radical Expressions", 45,
            Arrays.asList(new Section("Concepts and Examples", "Simplify radical expressions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Simplifying Radicals</text></svg>",
                Arrays.asList(
            new WorkedExample("Simplify sqrt(50)", Arrays.asList("25*2, sqrt(25)*sqrt(2)"), "5sqrt(2)"),
            new WorkedExample("Simplify sqrt(72)", Arrays.asList("36*2"), "6sqrt(2)"),
            new WorkedExample("Simplify sqrt(48)", Arrays.asList("16*3"), "4sqrt(3)"),
            new WorkedExample("Simplify sqrt(200)", Arrays.asList("100*2"), "10sqrt(2)"),
            new WorkedExample("sqrt(x^2) = ?", Arrays.asList("Absolute value of x"), "| x |")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("operations-with-radicals", "Operations With Radicals", "10-3", "Add, subtract, multiply radicals.", "Chapter 10: Radical Expressions", 46,
            Arrays.asList(new Section("Concepts and Examples", "Add, subtract, multiply radicals.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Operations With Radicals</text></svg>",
                Arrays.asList(
            new WorkedExample("3sqrt(5)+2sqrt(5)", Arrays.asList("Like terms: 5sqrt(5)"), "5sqrt(5)"),
            new WorkedExample("sqrt(12)-sqrt(3)", Arrays.asList("2sqrt(3)-sqrt(3)=sqrt(3)"), "sqrt(3)"),
            new WorkedExample("sqrt(2)*sqrt(8)", Arrays.asList("sqrt(16)=4"), "4"),
            new WorkedExample("Rationalize: 1/sqrt(5)", Arrays.asList("Multiply by sqrt(5)/sqrt(5)"), "sqrt(5)/5"),
            new WorkedExample("(2+sqrt(3))(2-sqrt(3))", Arrays.asList("4-3=1"), "1")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("solving-radical-equations", "Solving Radical Equations", "10-4", "Solve equations containing radicals.", "Chapter 10: Radical Expressions", 47,
            Arrays.asList(new Section("Concepts and Examples", "Solve equations containing radicals.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Solving Radical Equations</text></svg>",
                Arrays.asList(
            new WorkedExample("Solve: sqrt(x)=5", Arrays.asList("Square both: x=25"), "x = 25"),
            new WorkedExample("Solve: sqrt(x+3)=4", Arrays.asList("x+3=16, x=13"), "x = 13"),
            new WorkedExample("Solve: sqrt(2x-1)=3", Arrays.asList("2x-1=9, x=5"), "x = 5"),
            new WorkedExample("Solve: sqrt(x)=-3", Arrays.asList("Sqrt cant be negative"), "No solution"),
            new WorkedExample("Solve: 2sqrt(x)=8", Arrays.asList("sqrt(x)=4, x=16"), "x = 16")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("measures-of-center", "Measures of Center and Spread", "11-1", "Calculate mean, median, mode, range, SD.", "Chapter 11: Data Analysis", 48,
            Arrays.asList(new Section("Concepts and Examples", "Calculate mean, median, mode, range, SD.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Measures of Center and Spread</text></svg>",
                Arrays.asList(
            new WorkedExample("Mean of 3,5,7,9,11?", Arrays.asList("Sum=35, count=5", "35/5=7"), "Mean = 7"),
            new WorkedExample("Median of 2,4,6,8,10?", Arrays.asList("Middle value (3rd of 5)"), "Median = 6"),
            new WorkedExample("Mode of 3,5,5,7,9?", Arrays.asList("Most frequent"), "Mode = 5"),
            new WorkedExample("Range of 2,5,8,12,15?", Arrays.asList("15-2=13"), "Range = 13"),
            new WorkedExample("Median of 1,3,5,7?", Arrays.asList("Average of middle two: (3+5)/2"), "Median = 4")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("box-plots", "Box Plots and Distributions", "11-2", "Create box plots and describe distributions.", "Chapter 11: Data Analysis", 49,
            Arrays.asList(new Section("Concepts and Examples", "Create box plots and describe distributions.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Box Plots and Distributions</text></svg>",
                Arrays.asList(
            new WorkedExample("Box plot shows which 5 values?", Arrays.asList("Min, Q1, Median, Q3, Max"), "Five-number summary"),
            new WorkedExample("Q1 represents?", Arrays.asList("25th percentile"), "25th percentile"),
            new WorkedExample("IQR formula?", Arrays.asList("Q3-Q1"), "IQR = Q3-Q1"),
            new WorkedExample("Outlier rule?", Arrays.asList("Beyond 1.5*IQR from Q1 or Q3"), "1.5*IQR from quartiles"),
            new WorkedExample("Skewed right means?", Arrays.asList("Long tail to the right", "Mean > Median"), "Tail extends right")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
        lessons.add(new LessonContent("two-way-tables", "Two-Way Frequency Tables", "11-3", "Organize and analyze categorical data.", "Chapter 11: Data Analysis", 50,
            Arrays.asList(new Section("Concepts and Examples", "Organize and analyze categorical data.",
                "<svg viewBox=\"0 0 320 100\" xmlns=\"http://www.w3.org/2000/svg\"><rect width=\"320\" height=\"100\" fill=\"#f0edff\" rx=\"8\"/><text x=\"160\" y=\"55\" text-anchor=\"middle\" font-size=\"13\" fill=\"#6c5ce7\">Two-Way Frequency Tables</text></svg>",
                Arrays.asList(
            new WorkedExample("Two-way table organizes?", Arrays.asList("Categorical data in rows and columns"), "Two categories"),
            new WorkedExample("Joint frequency is?", Arrays.asList("Count in a specific cell"), "Cell count"),
            new WorkedExample("Marginal frequency?", Arrays.asList("Row or column total"), "Totals"),
            new WorkedExample("Relative frequency formula?", Arrays.asList("Cell count / grand total"), "Frequency/Total"),
            new WorkedExample("Independence means?", Arrays.asList("No association between variables"), "Variables unrelated")
            ))),
            Arrays.asList("Master this skill with practice", "Check your work by substituting back", "Look for patterns to simplify")
        ));
    }
}