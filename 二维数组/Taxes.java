package workStudy;

public class Taxes {
    static final int a = 0, b = 500, c = 2000, d = 5000, e = 20000, f = 40000, g = 60000, h = 80000, i = 100000;
    static final double FiveHundred = b * 0.05;
    static final double TwoThousand = FiveHundred + (c - b) * 0.1 - 25;
    static final double FiveThousand = TwoThousand + (d - c) * 0.15 - 125;
    static final double TwentyThousand = FiveThousand + (e - d) * 0.2 - 375;
    static final double FortyThousand = TwentyThousand + (f - e) * 0.25 - 1375;
    static final double SixtyThousand = FortyThousand + (g - f) * 0.3 - 3375;
    static final double EightyThousand = SixtyThousand + (h - g) * 0.35 - 6375;
    static final double HundredThousand = EightyThousand + (i - h) * 0.40 - 10375;

    public double TaxDeduction(double p) {
        if (p - i > 0) {
            p = p - (p - i) * 0.45 - 15375 - HundredThousand;
        } else if (p - h > 0) {
            p = p - (p - h) * 0.4 - 10375 - EightyThousand;
        } else if (p - g > 0) {
            p = p - (p - g) * 0.35 - 6375 - SixtyThousand;
        } else if (p - f > 0) {
            p = p - (p - f) * 0.3 - 3375 - FortyThousand;
        } else if (p - e > 0) {
            p = p - (p - e) * 0.25 - 1375 - TwentyThousand;
        } else if (p - d > 0) {
            p = p - (p - d) * 0.2 - 375 - FiveThousand;
        } else if (p - c > 0) {
            p = p - (p - c) * 0.15 - 125 - TwoThousand;
        } else if (p - b > 0) {
            p = p - (p - b) * 0.1 - 25 - FiveHundred;
        } else {
            p = p - p * 0.05;
        }
        return p;
    }
}
