import java.util.ArrayList;

public class SqEquation {
    enum SolutionCases {NO_SOLUTIONS, ONE_SOLUTION, TWO_EQUAL_REAL_SOLUTIONS, TWO_DISTINCT_REAL_SOLUTIONS, TWO_DISTINCT_COMPLEX_SOLUTIONS}

    private final SolutionCases howMuchSolutions;
    private final double a;
    private final double b;
    private final double c;
    private final ArrayList<ComplexNumber> solutions = new ArrayList<>();

    public SqEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        double discrim = Math.pow(b, 2) - 4 * a * c;
        if (a == 0d && b == 0d) {
            // некорректное уравнение
            this.howMuchSolutions = SolutionCases.NO_SOLUTIONS;

        } else if (a == 0d) {
            // неквадратное уравнение - один действительный корень
            this.howMuchSolutions = SolutionCases.ONE_SOLUTION;
            this.solutions.add(new ComplexNumber((-c / b), 0d));
        } else if (discrim == 0d) {
            // дискриминант = 0 - два совпадающих действительных корня.
            this.howMuchSolutions = SolutionCases.TWO_EQUAL_REAL_SOLUTIONS;
            this.solutions.add(new ComplexNumber(-b / (2 * a), 0d));
        } else if (discrim > 0d) {
            // дискриминант > 0 - два различных действительных корня.
            this.howMuchSolutions = SolutionCases.TWO_DISTINCT_REAL_SOLUTIONS;
            this.solutions.add(new ComplexNumber((-b + Math.sqrt(discrim)) / (2 * a), 0d));
            this.solutions.add(new ComplexNumber((-b - Math.sqrt(discrim)) / (2 * a), 0d));

        } else {
            // дискриминант < 0 - два различных комплексных корня.
            this.howMuchSolutions = SolutionCases.TWO_DISTINCT_COMPLEX_SOLUTIONS;
            this.solutions.add(new ComplexNumber((-b) / (2 * a), 0 + Math.sqrt(Math.abs(discrim)) / (2 * a)));
            this.solutions.add(new ComplexNumber((-b) / (2 * a), 0 - Math.sqrt(Math.abs(discrim)) / (2 * a)));

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Уравнение ");
        if (a != 0d) sb.append(a + "x^2 ");
        if (b != 0d) sb.append(((b > 0) ? "+" : "") + b + "x ");
        if (c != 0d) sb.append(((c > 0) ? "+" : "") + c + " ");
        sb.append(" = 0\n");
        switch (this.howMuchSolutions) {
            case NO_SOLUTIONS:
                sb.append("Некорректное уравнение, решений нет");
                break;
            case ONE_SOLUTION:
                sb.append("Это не квадратное уравнение, а линейное; 1 решение"); break;
            case TWO_EQUAL_REAL_SOLUTIONS:
                sb.append("2 совпадающих действительных решения"); break;
            case TWO_DISTINCT_REAL_SOLUTIONS:
                sb.append("2 различных действительных решения"); break;
            case TWO_DISTINCT_COMPLEX_SOLUTIONS:
                sb.append("2 различных комплексных решения"); break;
        }
        sb.append("\n");
        if (this.howMuchSolutions != SolutionCases.NO_SOLUTIONS) sb.append("Решения: "+solutions.toString());
        sb.append("\n");
        return sb.toString();
    }
}
