import json

questions = []

# Lesson structure: 50 lessons × 10 questions each = 500
lessons = [
    (1, "Solving Equations in One Variable", "Equations", "ALGEBRA"),
    (2, "Literal Equations and Formulas", "Equations", "ALGEBRA"),
    (3, "Solving Inequalities in One Variable", "Inequalities", "ALGEBRA"),
    (4, "Compound Inequalities", "Inequalities", "ALGEBRA"),
    (5, "Absolute Value Equations", "Equations", "ALGEBRA"),
    (6, "Absolute Value Inequalities", "Inequalities", "ALGEBRA"),
    (7, "Slope and Rate of Change", "Linear Functions", "ALGEBRA"),
    (8, "Slope-Intercept Form", "Linear Functions", "ALGEBRA"),
    (9, "Point-Slope Form", "Linear Functions", "ALGEBRA"),
    (10, "Standard Form", "Linear Functions", "ALGEBRA"),
    (11, "Parallel and Perpendicular Lines", "Linear Functions", "ALGEBRA"),
    (12, "Relations and Functions", "Functions", "ALGEBRA"),
    (13, "Linear Functions", "Functions", "ALGEBRA"),
    (14, "Transforming Linear Functions", "Functions", "ALGEBRA"),
    (15, "Arithmetic Sequences", "Sequences", "ALGEBRA"),
    (16, "Scatter Plots and Lines of Fit", "Data Analysis", "ALGEBRA"),
    (17, "Solving Systems by Graphing", "Systems", "ALGEBRA"),
    (18, "Solving Systems by Substitution", "Systems", "ALGEBRA"),
    (19, "Solving Systems by Elimination", "Systems", "ALGEBRA"),
    (20, "Linear Inequalities in Two Variables", "Systems", "ALGEBRA"),
    (21, "Systems of Linear Inequalities", "Systems", "ALGEBRA"),
    (22, "Piecewise-Defined Functions", "Functions", "ALGEBRA"),
    (23, "Step Functions", "Functions", "ALGEBRA"),
    (24, "Absolute Value Functions", "Functions", "ALGEBRA"),
    (25, "Exponential Growth", "Exponential", "ALGEBRA"),
    (26, "Exponential Decay", "Exponential", "ALGEBRA"),
    (27, "Geometric Sequences", "Sequences", "ALGEBRA"),
    (28, "Exponential Function Models", "Exponential", "ALGEBRA"),
    (29, "Adding and Subtracting Polynomials", "Polynomials", "ALGEBRA"),
    (30, "Multiplying Polynomials", "Polynomials", "ALGEBRA"),
    (31, "Special Products of Binomials", "Polynomials", "ALGEBRA"),
    (32, "Factoring Using the GCF", "Polynomials", "ALGEBRA"),
    (33, "Factoring x^2+bx+c", "Polynomials", "ALGEBRA"),
    (34, "Factoring ax^2+bx+c", "Polynomials", "ALGEBRA"),
    (35, "Factoring Special Cases", "Polynomials", "ALGEBRA"),
    (36, "Graphing f(x)=ax^2+bx+c", "Quadratics", "ALGEBRA"),
    (37, "Graphing f(x)=a(x-h)^2+k", "Quadratics", "ALGEBRA"),
    (38, "Modeling With Quadratic Functions", "Quadratics", "ALGEBRA"),
    (39, "Solving Quadratics by Graphing", "Quadratics", "ALGEBRA"),
    (40, "Solving Quadratics by Factoring", "Quadratics", "ALGEBRA"),
    (41, "Completing the Square", "Quadratics", "ALGEBRA"),
    (42, "The Quadratic Formula", "Quadratics", "ALGEBRA"),
    (43, "Choosing a Method for Solving", "Quadratics", "ALGEBRA"),
    (44, "Square Root Functions", "Radicals", "ALGEBRA"),
    (45, "Simplifying Radicals", "Radicals", "ALGEBRA"),
    (46, "Operations With Radical Expressions", "Radicals", "ALGEBRA"),
    (47, "Solving Radical Equations", "Radicals", "ALGEBRA"),
    (48, "Measures of Center and Spread", "Data Analysis", "ALGEBRA"),
    (49, "Box Plots and Distributions", "Data Analysis", "ALGEBRA"),
    (50, "Two-Way Frequency Tables", "Data Analysis", "ALGEBRA"),
]

# Lesson 1: Solving Equations in One Variable
q1 = [
    ("A gym charges $50 plus $30/month. How many months until total is $260?", "7 months", "8 months", "6 months", "9 months", "A", "50+30m=260"),
    ("Solve: 3(2x-5)+4=2(x+3)-6", "x=2.75", "x=3.25", "x=1.5", "x=4", "A", "Distribute, combine, isolate"),
    ("Rectangle perimeter is 56 cm. Length is 4 more than twice width. Find width.", "8 cm", "12 cm", "10 cm", "20 cm", "A", "2(2w+4)+2w=56"),
    ("Solve: 4(x+2)-3=5(x-1)+2", "x=6", "x=4", "x=-6", "x=8", "A", "4x+5=5x-3"),
    ("Two consecutive even integers sum to 54. Find smaller.", "26", "27", "28", "24", "A", "n+(n+2)=54"),
    ("Solve: 0.25(8x-12)=0.5(3x+4)", "x=11", "x=5", "x=7", "x=3", "A", "2x-3=1.5x+2"),
    ("Cell plan: $45/month + $0.10/text. Bill was $61. How many texts?", "160", "150", "61", "45", "A", "45+0.10t=61"),
    ("Solve: (2x+5)/3=(x+7)/2", "x=11", "x=9", "x=7", "x=13", "A", "Cross multiply"),
    ("Sum of three consecutive integers is 84. Find largest.", "29", "28", "27", "30", "A", "n+(n+1)+(n+2)=84"),
    ("A number increased by 15% equals 69. Find the number.", "60", "54", "58.65", "79.35", "A", "1.15n=69"),
]

# Lesson 2: Literal Equations and Formulas
q2 = [
    ("Solve d=rt for t", "t=d/r", "t=dr", "t=r/d", "t=d-r", "A", "Divide by r"),
    ("Solve A=½bh for h", "h=2A/b", "h=A/2b", "h=Ab/2", "h=2Ab", "A", "Multiply by 2, divide by b"),
    ("Solve P=2l+2w for w", "w=(P-2l)/2", "w=P-2l", "w=(P-l)/2", "w=P/2-l", "A", "Subtract 2l, divide by 2"),
    ("Solve F=9C/5+32 for C", "C=5(F-32)/9", "C=9(F-32)/5", "C=(F-32)/9", "C=5F/9-32", "A", "Subtract 32, multiply by 5/9"),
    ("Solve ax+by=c for y", "y=(c-ax)/b", "y=c-ax-b", "y=(c+ax)/b", "y=c/b-a", "A", "Subtract ax, divide by b"),
    ("Solve S=2πr²+2πrh for h", "h=(S-2πr²)/(2πr)", "h=S/(2πr)-r", "h=(S-2πr)/r²", "h=S-2πr²-2πr", "A", "Subtract 2πr², divide by 2πr"),
    ("Solve V=⅓πr²h for h", "h=3V/(πr²)", "h=V/(3πr²)", "h=3Vπ/r²", "h=V/πr²", "A", "Multiply by 3, divide by πr²"),
    ("Solve y=mx+b for x", "x=(y-b)/m", "x=y/m-b", "x=(y+b)/m", "x=ym-b", "A", "Subtract b, divide by m"),
    ("Solve A=P(1+rt) for r", "r=(A-P)/(Pt)", "r=A/(Pt)-1", "r=(A-P)/t", "r=A/P-t", "A", "Divide by P, subtract 1, divide by t"),
    ("Solve A=½(b₁+b₂)h for b₁", "b₁=2A/h-b₂", "b₁=A/(2h)-b₂", "b₁=2Ah-b₂", "b₁=(A-b₂)/2h", "A", "Multiply by 2/h, subtract b₂"),
]

# Lesson 3: Solving Inequalities
q3 = [
    ("Solve: 5x-3>12", "x>3", "x>5", "x<3", "x>15", "A", "Add 3, divide by 5"),
    ("Solve: -2x+7≤15", "x≥-4", "x≤-4", "x≥4", "x≤4", "A", "Subtract 7, divide by -2 (flip)"),
    ("Student needs ≥360 on 4 tests. Scored 85,92,88. Min on 4th?", "95", "90", "93", "100", "A", "85+92+88+x≥360"),
    ("Solve: 3(x-4)+2>5x-8", "x<-1", "x>-1", "x<1", "x>1", "A", "3x-10>5x-8, -2x>2"),
    ("Solve: -4(2x+1)≥3(x-5)", "x≤1", "x≥1", "x≤-1", "x≥-1", "A", "-8x-4≥3x-15"),
    ("Taxi: $3.50+$2.25/mile. Have $20. Max whole miles?", "7 miles", "8 miles", "6 miles", "9 miles", "A", "3.50+2.25m≤20"),
    ("Solve: 7-2x≥3x+22", "x≤-3", "x≥-3", "x≤3", "x≥3", "A", "-5x≥15"),
    ("Pool: 12000 gal capacity, filling 500/hr, has 2000. Hours for ≥8500?", "13 hours", "17 hours", "10 hours", "21 hours", "A", "2000+500h≥8500"),
    ("Which means 'x is at most 5'?", "x≤5", "x<5", "x≥5", "x>5", "A", "'At most' = ≤"),
    ("Solve: (2x-1)/4<(x+3)/2", "x<7", "x>7", "x<-7", "x>-7", "A", "Multiply by 4, solve"),
]

# Lesson 4: Compound Inequalities
q4 = [
    ("Solve: -3<2x+1≤9", "-2<x≤4", "-2≤x<4", "-1<x≤5", "-4<x≤2", "A", "Subtract 1, divide by 2"),
    ("Solve: x+3<-2 OR x+3>7", "x<-5 or x>4", "x<-2 or x>7", "-5<x<4", "x<-5 and x>4", "A", "Solve each separately"),
    ("Temp: 65≤2h+55≤80. Solve for h.", "5≤h≤12.5", "5<h<12.5", "10≤h≤25", "32.5≤h≤40", "A", "Subtract 55, divide by 2"),
    ("Solve: 1≤3x-5<10", "2≤x<5", "2<x≤5", "-2≤x<5", "2≤x≤5", "A", "Add 5, divide by 3"),
    ("Solve: 2x-1<-7 OR 3x+2>14", "x<-3 or x>4", "x<-4 or x>3", "-3<x<4", "x≤-3 or x≥4", "A", "Solve each part"),
    ("Bolt diameter between 1.49 and 1.51 cm. Write inequality.", "1.49≤d≤1.51", "1.49<d<1.51", "|d-1.5|≤0.02", "d≥1.49 or d≤1.51", "A", "Inclusive between"),
    ("Solve: -4≤(x-3)/2≤1", "-5≤x≤5", "-8≤x≤2", "-1≤x≤5", "-5≤x≤1", "A", "Multiply by 2, add 3"),
    ("Which has no solution: x>5 AND x<2, or x>2 OR x<5?", "x>5 AND x<2", "x>2 OR x<5", "Both have solutions", "Neither", "A", "AND requires both true"),
    ("Graph: -1<2x+3<9", "Open at -2, open at 3", "Closed at -2, closed at 3", "Open at -1, open at 9", "Arrows outward", "A", "-2<x<3"),
    ("Solve: -2≤4-3x≤10", "-2≤x≤2", "-2≤x≤6", "-6≤x≤2", "2≤x≤6", "A", "Subtract 4, divide by -3 (flip)"),
]

# Lesson 5: Absolute Value Equations
q5 = [
    ("Solve: |x-3|=7", "x=10 or x=-4", "x=10 only", "x=4 or x=-10", "x=-4 only", "A", "Two cases: x-3=±7"),
    ("Solve: |2x+5|=11", "x=3 or x=-8", "x=3 only", "x=8 or x=-3", "x=-8 only", "A", "2x+5=11 or 2x+5=-11"),
    ("Solve: |3x-1|+4=10", "x=7/3 or x=-5/3", "x=2 or x=-2", "x=3 or x=-1", "No solution", "A", "|3x-1|=6"),
    ("Solve: |4x-8|=-2", "No solution", "x=2.5", "x=1.5 or x=2.5", "x=0", "A", "Absolute value ≠ negative"),
    ("Solve: 2|x-4|-3=7", "x=9 or x=-1", "x=9 only", "x=4 or x=-4", "x=7 or x=1", "A", "|x-4|=5"),
    ("Solve: |x+2|=|3x-6|", "x=2 or x=1", "x=4 or x=-2", "x=2 only", "x=3 or x=1", "A", "Two cases"),
    ("Solve: |5-2x|=3", "x=1 or x=4", "x=-1 or x=4", "x=1 or x=-4", "x=4 only", "A", "5-2x=3 or 5-2x=-3"),
    ("Pool pH tolerance: |pH-7.4|≤0.2. Write range.", "|pH-7.4|≤0.2", "|pH-0.2|=7.4", "|pH+7.4|≤0.2", "pH=7.4±0.2", "A", "Distance from 7.4 ≤ 0.2"),
    ("How many solutions: |3x+2|=0?", "One: x=-2/3", "No solution", "Infinitely many", "Two solutions", "A", "Only 3x+2=0"),
    ("Machine tolerance: |w-16|≤0.5. Is 15.3 oz OK?", "No, |15.3-16|=0.7>0.5", "Yes", "Cannot determine", "No, too heavy", "A", "0.7>0.5 fails"),
]

# Lesson 6: Absolute Value Inequalities
q6 = [
    ("Solve: |x+4|<6", "-10<x<2", "x<2", "x>-10", "x<-10 or x>2", "A", "-6<x+4<6"),
    ("Solve: |2x-3|>5", "x>4 or x<-1", "-1<x<4", "x>4", "x<-1", "A", "Two cases"),
    ("Solve: |3x+1|≤8", "-3≤x≤7/3", "x≤7/3", "-3≤x≤3", "x≥-3", "A", "-8≤3x+1≤8"),
    ("Part tolerance: |x-5.0|≤0.02. Write inequality.", "|x-5.0|≤0.02", "|x-0.02|≤5.0", "|x+5.0|<0.02", "x≤5.02", "A", "Distance from 5 ≤ 0.02"),
    ("Solve: |x-7|≥3", "x≥10 or x≤4", "4≤x≤10", "x≥10", "x≤4", "A", "x-7≥3 or x-7≤-3"),
    ("Solve: 2|x+1|-3>5", "x>3 or x<-5", "-5<x<3", "x>5 or x<-3", "x>3", "A", "|x+1|>4"),
    ("Which values satisfy |x-2|<1?", "1<x<3", "x<3", "x>1", "-1<x<1", "A", "-1<x-2<1"),
    ("Solve: |4x-5|≤-3", "No solution", "All reals", "-2≤x≤2", "x=5/4", "A", "AV always ≥ 0"),
    ("Thermostat: within 3° of 72°F. Range?", "69≤T≤75", "72≤T≤75", "69<T<75", "T≤75", "A", "|T-72|≤3"),
    ("Solve: |x|>0", "All reals except 0", "All reals", "x>0", "No solution", "A", "Only x=0 gives |x|=0"),
]

# Lesson 7: Slope and Rate of Change
q7 = [
    ("Slope through (-2,5) and (4,-1)?", "-1", "1", "-6", "2/3", "A", "(-1-5)/(4-(-2))"),
    ("Car: 180 miles in 3 hours. Speed?", "60 mph", "3 mph", "180 mph", "540 mph", "A", "180/3"),
    ("Slope of horizontal line?", "0", "Undefined", "1", "-1", "A", "No rise"),
    ("Bike rental: $5 + $2/hr. What does slope mean?", "Cost per hour ($2/hr)", "Initial cost ($5)", "Total cost", "Hours", "A", "Rate of change"),
    ("Points (1,4) and (1,-3). Slope?", "Undefined", "0", "7", "-7", "A", "Same x = vertical"),
    ("Slope: (0,-3) and (6,9)?", "2", "-2", "1/2", "6", "A", "12/6=2"),
    ("Population: 1200 to 1800 in 4 years. Rate?", "150/year", "600/year", "300/year", "450/year", "A", "600/4"),
    ("Which gives negative slope?", "(1,5) and (4,2)", "(1,2) and (4,5)", "(0,0) and (3,3)", "(-1,-2) and (1,2)", "A", "y decreases as x increases"),
    ("Temp: 68°F at 6PM to 50°F at 10PM. Rate?", "-4.5°F/hr", "4.5°F/hr", "-18°F/hr", "-9°F/hr", "A", "-18/4"),
    ("Are (0,1),(2,5),(4,9) collinear?", "Yes, slope=2", "No", "Cannot tell", "Yes, slope=4", "A", "Constant slope"),
]

# Lesson 8: Slope-Intercept Form
q8 = [
    ("Slope and y-int of y=-3x+7?", "m=-3, b=7", "m=7, b=-3", "m=3, b=7", "m=-3, b=-7", "A", "y=mx+b"),
    ("Equation: slope 2/3, y-int -4?", "y=(2/3)x-4", "y=-4x+2/3", "y=(2/3)x+4", "2x-3y=4", "A", "y=mx+b"),
    ("Convert 4x+2y=10 to slope-int.", "y=-2x+5", "y=2x-5", "y=-4x+10", "y=4x+5", "A", "Solve for y"),
    ("Plumber: $75 visit + $50/hr. Cost for 3 hrs?", "$225", "$275", "$150", "$375", "A", "50(3)+75"),
    ("y-intercept of line through (2,7) with slope 3?", "1", "7", "13", "-1", "A", "7=3(2)+b"),
    ("x-int 4, y-int -2. Equation?", "y=(1/2)x-2", "y=-2x+4", "y=2x-2", "y=(1/2)x+2", "A", "slope=2/4=1/2"),
    ("y=2x-1. Which point NOT on line?", "(2,5)", "(0,-1)", "(1,1)", "(3,5)", "A", "2(2)-1=3≠5"),
    ("Battery loses 8%/hr from 100%. After 5hrs?", "60%", "40%", "92%", "50%", "A", "100-8(5)"),
    ("Same slope, diff y-int. Solutions?", "No solution (parallel)", "One", "Infinitely many", "Two", "A", "Parallel never intersect"),
    ("x+2→y+6. Through (0,4). Equation?", "y=3x+4", "y=6x+4", "y=2x+4", "y=3x-4", "A", "slope=6/2=3"),
]

# Lesson 9: Point-Slope Form
q9 = [
    ("Point-slope: slope -2, through (3,5)?", "y-5=-2(x-3)", "y+5=-2(x+3)", "y-3=-2(x-5)", "y=-2x+11", "A", "y-y₁=m(x-x₁)"),
    ("Line through (1,4) and (3,10)?", "y-4=3(x-1)", "y-4=6(x-1)", "y-10=2(x-3)", "y=3x+4", "A", "m=6/2=3"),
    ("Convert y-2=4(x+1) to slope-int.", "y=4x+6", "y=4x-2", "y=4x+2", "y=4x-6", "A", "y=4x+4+2"),
    ("Candle: 12 in tall, burns 0.5 in/hr. Equation?", "y-12=-0.5(x-0)", "y-0=-0.5(x-12)", "y=12x-0.5", "y+12=0.5x", "A", "Point (0,12), slope=-0.5"),
    ("Through (-2,7) and (4,-5). Point-slope?", "Both y-7=-2(x+2) and y+5=-2(x-4)", "y-7=-2(x+2) only", "y+5=-2(x-4) only", "y-7=2(x+2)", "A", "m=-12/6=-2"),
    ("y+3=-½(x-6). Identify slope and point.", "m=-½, point (6,-3)", "m=-½, point (-6,3)", "m=½, point (6,-3)", "m=-½, point (6,3)", "A", "y-(-3)=-½(x-6)"),
    ("Through (5,1) parallel to y=3x-7?", "y-1=3(x-5)", "y-1=-⅓(x-5)", "y=3x-7", "y-5=3(x-1)", "A", "Same slope m=3"),
    ("Town: 8500 in 2020, +200/yr. Population 2025?", "9,500", "1000", "10,000", "8,700", "A", "8500+200(5)"),
    ("x-intercept of y-4=2(x-1)?", "x=-1", "x=1", "x=3", "x=-3", "A", "Set y=0: -4=2(x-1)"),
    ("Line through (0,3) and (4,3). Equation?", "y=3", "x=3", "y=3x", "y=0x+3", "A", "Horizontal, slope=0"),
]

# Lesson 10: Standard Form
q10 = [
    ("Write 3x+5y=15. Identify A,B,C.", "A=3, B=5, C=15", "A=5, B=3, C=15", "A=3, B=5, C=-15", "A=-3, B=-5, C=-15", "A", "Ax+By=C"),
    ("Convert y=2x-4 to standard form.", "2x-y=4", "-2x+y=-4", "2x+y=4", "y-2x=-4", "A", "-2x+y=-4 → 2x-y=4"),
    ("Find x-intercept of 3x+4y=12.", "x=4", "x=3", "x=12", "x=0", "A", "Set y=0"),
    ("Find y-intercept of 2x-5y=10.", "y=-2", "y=2", "y=5", "y=-5", "A", "Set x=0"),
    ("Are 2x+3y=6 and 4x+6y=10 parallel?", "Yes", "No", "Same line", "Perpendicular", "A", "Same slope, diff intercepts"),
    ("Write equation: x-int 6, y-int -3.", "x-2y=6", "x+2y=6", "2x-y=6", "x-2y=-6", "A", "Points (6,0),(0,-3); m=1/2"),
    ("Convert 5x-2y=8 to slope-int.", "y=(5/2)x-4", "y=5x-4", "y=-(5/2)x+4", "y=(5/2)x+4", "A", "-2y=-5x+8"),
    ("Which is standard form?", "4x-3y=12", "y=4x-3", "4x-3y+12=0", "x=4y+3", "A", "Ax+By=C, A≥0"),
    ("Slope of 6x-2y=10?", "3", "-3", "6", "-2", "A", "y=3x-5"),
    ("Graph 2x+y=6 using intercepts.", "x-int=3, y-int=6", "x-int=6, y-int=2", "x-int=2, y-int=6", "x-int=3, y-int=3", "A", "(3,0) and (0,6)"),
]

# Lessons 11-50: Generate similar style questions
def gen_lesson(num, title, topic, cat, qs):
    for q in qs:
        questions.append({
            "questionText": q[0], "optionA": q[1], "optionB": q[2],
            "optionC": q[3], "optionD": q[4], "correctAnswer": q[5],
            "hint": q[6], "lessonNumber": num, "lessonTitle": title,
            "topic": topic, "category": cat
        })

gen_lesson(1, *lessons[0][1:], q1)
gen_lesson(2, *lessons[1][1:], q2)
gen_lesson(3, *lessons[2][1:], q3)
gen_lesson(4, *lessons[3][1:], q4)
gen_lesson(5, *lessons[4][1:], q5)
gen_lesson(6, *lessons[5][1:], q6)
gen_lesson(7, *lessons[6][1:], q7)
gen_lesson(8, *lessons[7][1:], q8)
gen_lesson(9, *lessons[8][1:], q9)
gen_lesson(10, *lessons[9][1:], q10)

# Lessons 11-50 question banks
lesson_questions = {
    11: [
        ("Slope of line parallel to y=-5x+2?", "-5", "5", "1/5", "-1/5", "A", "Same slope"),
        ("Slope of line perpendicular to y=3x-1?", "-1/3", "-3", "1/3", "3", "A", "Negative reciprocal"),
        ("Are y=2x+1 and y=2x-5 parallel?", "Yes", "No", "Perpendicular", "Same line", "A", "Same slope m=2"),
        ("Line ⊥ to y=-4x+3 through (0,2)?", "y=(1/4)x+2", "y=-4x+2", "y=4x+2", "y=-(1/4)x+2", "A", "m=1/4"),
        ("Are y=3x+2 and y=-⅓x+5 perpendicular?", "Yes", "No", "Parallel", "Same line", "A", "3×(-1/3)=-1"),
        ("Parallel to 2x+3y=6 through (3,1)?", "y=-⅔x+3", "y=⅔x-1", "y=-⅔x+1", "y=⅔x+3", "A", "m=-2/3"),
        ("⊥ to x-axis through (4,7)?", "y=7", "x=4", "x=7", "y=4", "A", "Horizontal line"),
        ("Are y=½x+3 and 2y=x-4 parallel?", "Yes", "No", "Perpendicular", "Same line", "A", "Both slope ½"),
        ("Line parallel to y-axis through (-2,5)?", "x=-2", "y=5", "y=-2", "x=5", "A", "Vertical line"),
        ("Distance between parallel lines y=2x+1, y=2x+6?", "5/√5=√5", "5", "1", "√5", "A", "|c₂-c₁|/√(1+m²)"),
    ],
    12: [
        ("Is {(1,3),(2,5),(1,7)} a function?", "No", "Yes", "Cannot tell", "Maybe", "A", "1 maps to 3 AND 7"),
        ("Domain of f(x)=√(x-3)?", "x≥3", "x>3", "All reals", "x≥0", "A", "Radicand≥0"),
        ("f(x)=3x²-2x+1. Find f(-1).", "6", "4", "0", "2", "A", "3+2+1"),
        ("Range of y=x²?", "y≥0", "All reals", "y>0", "y≥1", "A", "Squares are non-negative"),
        ("Is y²=x a function of x?", "No", "Yes", "Sometimes", "Cannot tell", "A", "Fails vertical line test"),
        ("f(x)=|x-2|+1. f(5)?", "4", "2", "6", "8", "A", "|3|+1"),
        ("Domain of f(x)=1/(x-4)?", "All reals, x≠4", "x>4", "x≠0", "All reals", "A", "Denom≠0"),
        ("g(x)=2x-5. g(0)?", "-5", "5", "0", "-3", "A", "2(0)-5"),
        ("f(x)=x² is even, odd, or neither?", "Even", "Odd", "Neither", "Both", "A", "f(-x)=f(x)"),
        ("Evaluate f(3) if f(x)=x³-2x.", "21", "15", "27", "3", "A", "27-6"),
    ],
    13: [
        ("Is y=3x+2 linear?", "Yes", "No", "Quadratic", "Exponential", "A", "y=mx+b form"),
        ("f(x)=-2x+8. x-intercept?", "x=4", "x=-4", "x=8", "x=2", "A", "0=-2x+8"),
        ("Rate of change of f(x)=5x-3?", "5", "-3", "3", "5x", "A", "Slope=5"),
        ("f(x)=½x+1. f(6)?", "4", "7", "3", "3.5", "A", "3+1"),
        ("Zero of f(x)=4x-12?", "x=3", "x=-3", "x=12", "x=4", "A", "4x=12"),
        ("f(x)=-x+5 increasing or decreasing?", "Decreasing", "Increasing", "Constant", "Neither", "A", "Negative slope"),
        ("g(x)=2x. g(a+1)?", "2a+2", "2a+1", "2a", "a+2", "A", "2(a+1)"),
        ("y-intercept of f(x)=7x-3?", "-3", "7", "3", "-7", "A", "f(0)=-3"),
        ("If f(2)=5 and f(5)=11, find slope.", "2", "6/3", "3", "6", "A", "(11-5)/(5-2)"),
        ("f(x)=0 means...", "x-intercept", "y-intercept", "slope", "undefined", "A", "Zero of function"),
    ],
    14: [
        ("g(x)=f(x)+3 shifts f how?", "Up 3", "Down 3", "Right 3", "Left 3", "A", "Vertical shift +3"),
        ("g(x)=f(x-2) shifts f how?", "Right 2", "Left 2", "Up 2", "Down 2", "A", "Horizontal shift"),
        ("g(x)=-f(x) does what?", "Reflects over x-axis", "Reflects over y-axis", "Shifts down", "Stretches", "A", "Negation reflects"),
        ("g(x)=2f(x) is a...", "Vertical stretch by 2", "Horizontal stretch", "Shift up 2", "Reflection", "A", "Multiply output"),
        ("g(x)=f(x)-4 shifts f how?", "Down 4", "Up 4", "Left 4", "Right 4", "A", "Subtract from output"),
        ("f(x)=x. g(x)=3x+2. Describe transformation.", "Stretch by 3, up 2", "Shift right 3, up 2", "Stretch by 2, up 3", "Shift left 2", "A", "Steeper slope + shift"),
        ("g(x)=½f(x) is a...", "Vertical compression", "Horizontal stretch", "Vertical stretch", "Shift", "A", "Factor < 1 compresses"),
        ("f(x)=2x+1→g(x)=2x+5. What changed?", "y-int shifted up 4", "Slope changed", "Reflected", "Compressed", "A", "b went from 1 to 5"),
        ("g(x)=f(x+1) shifts...", "Left 1", "Right 1", "Up 1", "Down 1", "A", "x+c shifts left"),
        ("Which changes slope: shift, stretch, or reflect?", "Stretch and reflect", "Shift only", "All three", "None", "A", "Stretch/reflect change steepness"),
    ],
    15: [
        ("Sequence: 3,7,11,15,... Common diff?", "4", "3", "7", "11", "A", "7-3=4"),
        ("a₁=5, d=3. Find a₁₀.", "32", "35", "30", "27", "A", "5+9(3)=32"),
        ("Is 2,6,18,54 arithmetic?", "No", "Yes", "Cannot tell", "Geometric", "A", "Not constant difference"),
        ("a₁=100, d=-7. Find a₂₀.", "-33", "33", "-40", "240", "A", "100+19(-7)=-33"),
        ("Find d: 8,_,_,_,24", "4", "8", "16", "5.33", "A", "(24-8)/4=4"),
        ("Write rule: 2,5,8,11,...", "aₙ=3n-1", "aₙ=2n+1", "aₙ=n+3", "aₙ=3n+2", "A", "a₁=2, d=3"),
        ("Sum of first 10 terms: a₁=1, d=2?", "100", "110", "90", "55", "A", "S=10/2(2+18)=100"),
        ("Which term is 47 in 5,8,11,...?", "15th", "14th", "16th", "42nd", "A", "5+3(n-1)=47, n=15"),
        ("a₅=20, d=4. Find a₁.", "4", "8", "0", "16", "A", "a₁=20-4(4)=4"),
        ("Arithmetic mean of 8 and 22?", "15", "14", "16", "30", "A", "(8+22)/2"),
    ],
}

# Generate remaining lessons 16-50 with template questions
for lnum in range(16, 51):
    title = lessons[lnum-1][1]
    topic = lessons[lnum-1][2]
    cat = lessons[lnum-1][3]
    
    if lnum in lesson_questions:
        gen_lesson(lnum, title, topic, cat, lesson_questions[lnum])
    elif lnum == 16:
        qs = [
            ("Correlation of scatter plot trending down-right?", "Negative", "Positive", "None", "Strong", "A", "As x↑, y↓"),
            ("r=0.95 indicates?", "Strong positive", "Weak positive", "Strong negative", "No correlation", "A", "Close to 1"),
            ("Best fit line passes through?", "Center of data cloud", "All points", "Origin", "First point", "A", "Minimizes residuals"),
            ("Residual = ?", "Actual - Predicted", "Predicted - Actual", "Slope × x", "y-intercept", "A", "Difference from line"),
            ("r=-0.89 indicates?", "Strong negative", "Weak negative", "Strong positive", "No correlation", "A", "Close to -1"),
            ("Extrapolation is...", "Predicting beyond data", "Predicting within data", "Finding slope", "Finding r", "A", "Outside data range"),
            ("Causation vs correlation?", "Correlation ≠ causation", "Same thing", "Causation implies correlation", "Neither relates", "A", "Association ≠ cause"),
            ("Line of fit: y=2x+10. Predict y when x=8.", "26", "18", "28", "16", "A", "2(8)+10"),
            ("r²=0.81 means...", "81% variation explained", "81% of points on line", "Slope is 0.81", "r=0.81", "A", "Coefficient of determination"),
            ("Which r shows NO correlation?", "r=0.02", "r=0.95", "r=-0.88", "r=0.5", "A", "Near zero"),
        ]
        gen_lesson(lnum, title, topic, cat, qs)
    elif lnum == 17:
        qs = [
            ("Solve by graphing: y=x+1, y=-x+5", "(2,3)", "(3,2)", "(1,4)", "(4,1)", "A", "Intersection point"),
            ("Parallel lines have how many solutions?", "0", "1", "Infinite", "2", "A", "Never intersect"),
            ("Same line has how many solutions?", "Infinitely many", "0", "1", "2", "A", "All points common"),
            ("y=2x+1, y=2x-3. Solutions?", "None (parallel)", "One", "Infinite", "(0,1)", "A", "Same slope, diff y-int"),
            ("Intersection of y=x and y=-x+4?", "(2,2)", "(4,0)", "(0,4)", "(1,3)", "A", "x=-x+4, 2x=4"),
            ("System consistent if it has...", "At least one solution", "No solution", "Exactly one", "Two solutions", "A", "Consistent = solvable"),
            ("y=3x-1, y=3x-1. Type?", "Dependent (infinite)", "Independent", "Inconsistent", "Undefined", "A", "Same line"),
            ("Estimate intersection: y≈2x+1, y≈-x+7", "About (2,5)", "About (3,7)", "About (1,3)", "About (4,9)", "A", "2x+1=-x+7, x=2"),
            ("Is (1,4) a solution to y=2x+2, y=x+3?", "Yes", "No, fails 2nd", "No, fails 1st", "No, fails both", "A", "4=2+2=4✓, 4=1+3=4✓"),
            ("Inconsistent system means...", "No solution", "One solution", "Infinite solutions", "Negative slope", "A", "Lines don't meet"),
        ]
        gen_lesson(lnum, title, topic, cat, qs)
    elif lnum == 18:
        qs = [
            ("y=2x+1, x+y=10. Solve by substitution.", "(3,7)", "(7,3)", "(2,5)", "(5,5)", "A", "x+2x+1=10"),
            ("y=x-3, 2x+y=9. Solve.", "(4,1)", "(3,0)", "(5,2)", "(1,-2)", "A", "2x+x-3=9"),
            ("x=3y, x+y=16. Solve.", "(12,4)", "(4,12)", "(8,8)", "(6,10)", "A", "3y+y=16"),
            ("y=-x+5, 3x+2y=12. Solve.", "(2,3)", "(3,2)", "(4,1)", "(1,4)", "A", "3x+2(-x+5)=12"),
            ("2x+y=7, y=3x-8. Solve.", "(3,1)", "(1,5)", "(2,3)", "(5,-7)", "A", "2x+3x-8=7"),
            ("x+2y=8, x=y+2. Solve.", "(4,3)", "(3,4)", "(2,3)", "(6,1)", "A", "y+2+2y=8"),
            ("No solution indicator in substitution?", "False statement (0=5)", "x=0", "y=0", "Infinite loop", "A", "Contradiction"),
            ("y=4x, 3x-y=-2. Solve.", "(2,8)", "(-2,-8)", "(1,4)", "No solution", "A", "3x-4x=-2"),
            ("Infinite solutions indicator?", "True statement (0=0)", "x=0", "All vars cancel", "y=0", "A", "Identity"),
            ("x-y=4, 2x-2y=8. Solutions?", "Infinitely many", "One", "None", "(4,0)", "A", "Same line"),
        ]
        gen_lesson(lnum, title, topic, cat, qs)
    elif lnum == 19:
        qs = [
            ("x+y=10, x-y=4. Solve by elimination.", "(7,3)", "(3,7)", "(5,5)", "(6,4)", "A", "Add: 2x=14"),
            ("2x+3y=12, 2x-y=4. Solve.", "(3,2)", "(2,3)", "(4,4/3)", "(1,10/3)", "A", "Subtract: 4y=8"),
            ("3x+2y=16, x+2y=8. Solve.", "(4,2)", "(2,4)", "(8,0)", "(0,4)", "A", "Subtract: 2x=8"),
            ("4x-3y=10, 2x+3y=8. Solve.", "(3,2/3)", "(2,2/3)", "(3,1)", "(1,2)", "A", "Add: 6x=18"),
            ("5x+2y=13, 3x-2y=3. Solve.", "(2,3/2)", "(2,1.5)", "(1,4)", "(3,0)", "A", "Add: 8x=16"),
            ("Multiply to eliminate y: x+3y=7, 2x+y=4", "Multiply 2nd by -3", "Multiply 1st by 2", "Multiply 2nd by 3", "Add directly", "A", "To make ±3y"),
            ("x+y=5, 2x+2y=10. Solve.", "Infinitely many", "(5,0)", "(0,5)", "No solution", "A", "Same line"),
            ("x+y=5, x+y=8. Solve.", "No solution", "(5,0)", "Infinitely many", "(3,2)", "A", "Parallel lines"),
            ("3x-4y=2, 6x-8y=5. Solve.", "No solution", "Infinitely many", "(2,1)", "(1,1/4)", "A", "Parallel (same slope)"),
            ("Best method when coefficients match?", "Elimination", "Substitution", "Graphing", "Guess and check", "A", "Add/subtract directly"),
        ]
        gen_lesson(lnum, title, topic, cat, qs)
    else:
        # For remaining lessons, create template questions based on topic
        qs = []
        for i in range(10):
            seed = lnum * 10 + i
            if topic == "Systems":
                q_templates = [
                    (f"Solve system #{seed}: 2x+y={seed%10+5}, x-y={seed%5}", f"({(seed%10+5+seed%5)//3},{(seed%10+5-2*(seed%5))//3})", f"({seed%5},{seed%3})", f"({seed%7},{seed%4})", f"({seed%2},{seed%6})", "A", "Elimination or substitution"),
                ]
                qs.append(q_templates[0])
            elif topic == "Functions":
                q_templates = [
                    (f"f(x)={seed%5+1}x-{seed%8+1}. Find f({seed%4+2}).", f"{(seed%5+1)*(seed%4+2)-(seed%8+1)}", f"{(seed%5+1)*(seed%4+2)}", f"{seed%8+1}", f"{(seed%5+1)+(seed%4+2)}", "A", "Substitute x value"),
                ]
                qs.append(q_templates[0])
            elif topic == "Exponential":
                base = 2 + seed % 3
                mult = 100 + seed * 50
                q_templates = [
                    (f"y={mult}({base})^x. Find y when x=3.", f"{mult * base**3}", f"{mult * base}", f"{mult * 3}", f"{mult + base**3}", "A", f"Substitute x=3"),
                ]
                qs.append(q_templates[0])
            elif topic == "Sequences":
                a1 = 2 + seed % 8
                d = 3 + seed % 5
                q_templates = [
                    (f"Arithmetic: a₁={a1}, d={d}. Find a₁₀.", f"{a1+9*d}", f"{a1+10*d}", f"{a1*10}", f"{10*d}", "A", f"a₁+(n-1)d={a1}+9({d})"),
                ]
                qs.append(q_templates[0])
            elif topic == "Polynomials":
                a = seed % 4 + 2
                b = seed % 5 + 1
                q_templates = [
                    (f"Expand: ({a}x+{b})({a}x-{b})", f"{a*a}x²-{b*b}", f"{a*a}x²+{b*b}", f"{2*a}x²-{2*b}", f"{a*a}x²-{2*a*b}x-{b*b}", "A", "Difference of squares: (a+b)(a-b)=a²-b²"),
                ]
                qs.append(q_templates[0])
            elif topic == "Quadratics":
                r1 = seed % 5 + 1
                r2 = -(seed % 4 + 1)
                q_templates = [
                    (f"Solve: x²+{r2+r1}x+{r1*r2}=0 by factoring", f"x={-r1} or x={-r2}", f"x={r1} or x={r2}", f"x={r1+r2}", f"x={r1*r2}", "A", "Factor and set each = 0"),
                ]
                qs.append(q_templates[0])
            elif topic == "Radicals":
                n = (seed % 5 + 2) ** 2 * (seed % 3 + 2)
                outer = seed % 5 + 2
                inner = seed % 3 + 2
                q_templates = [
                    (f"Simplify: √{n}", f"{outer}√{inner}", f"{inner}√{outer}", f"√{n}", f"{outer*inner}", "A", f"√({outer}²×{inner})={outer}√{inner}"),
                ]
                qs.append(q_templates[0])
            elif topic == "Data Analysis":
                q_templates = [
                    (f"Mean of {seed%5+10},{seed%5+12},{seed%5+14},{seed%5+16},{seed%5+18}?", f"{seed%5+14}", f"{seed%5+12}", f"{seed%5+16}", f"{(seed%5+10)*5}", "A", "Sum/5"),
                ]
                qs.append(q_templates[0])
            else:
                q_templates = [
                    (f"Solve: {seed%5+2}x+{seed%7+1}={seed%20+15}", f"x={((seed%20+15)-(seed%7+1))//(seed%5+2)}", f"x={seed%10}", f"x={seed%5}", f"x={seed%3}", "A", "Subtract, divide"),
                ]
                qs.append(q_templates[0])
        gen_lesson(lnum, title, topic, cat, qs)

# Also add lesson 11-15 from the dictionary
for lnum in [11, 12, 13, 14, 15]:
    if lnum in lesson_questions:
        gen_lesson(lnum, *lessons[lnum-1][1:], lesson_questions[lnum])

print(f"Generated {len(questions)} questions across {len(set(q['lessonNumber'] for q in questions))} lessons")

with open('/Users/padmoort/algebra1recap/src/main/resources/data/questions.json', 'w') as f:
    json.dump(questions, f, indent=1)

print("Saved to questions.json")
