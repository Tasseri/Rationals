package se.academy.rationals;

/**
 * Created by Emil Båth on 2016-08-12.
 */
public class RationalNumber {
    private int numerator;
    private int denominator;

    //Constructor:
    public RationalNumber(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static int greatestCommonDivider(RationalNumber rat) {
        return MyMath.greatestCommonDivider(rat.getNumerator(), rat.getDenominator());
    }

    public static RationalNumber simplify(RationalNumber rat) {
        return new RationalNumber(rat.getNumerator() / greatestCommonDivider(rat), rat.getDenominator() / greatestCommonDivider(rat));
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public static RationalNumber add(RationalNumber a, RationalNumber b) {
        int numerator = a.getNumerator() * b.getDenominator() +
                b.getNumerator() * a.getDenominator();
        int denominator = a.getDenominator() * b.getDenominator();
        RationalNumber rat = new RationalNumber(numerator, denominator);
        return simplify(rat);
    }

    public static RationalNumber add(RationalNumber a, int b) {
        return add(a, new RationalNumber(b));
    }

    public static RationalNumber add(int a, RationalNumber b) {
        return add(new RationalNumber(a), b);
    }

    public static RationalNumber subtrakt(RationalNumber a, RationalNumber b) {
        int numerator = a.getNumerator() * b.getDenominator() -
                b.getNumerator() * a.getDenominator();
        int denominator = a.getDenominator() * b.getDenominator();
        RationalNumber rat = new RationalNumber(numerator, denominator);
        return simplify(rat);
    }

    public static RationalNumber subtrakt(RationalNumber a, int b) {
        return subtrakt(a, new RationalNumber(b));
    }

    public static RationalNumber subtrakt(int a, RationalNumber b) {
        return subtrakt(new RationalNumber(a), b);
    }

    public static RationalNumber multiply(RationalNumber a, RationalNumber b) {
        int numerator = a.getNumerator() * b.getNumerator();
        int denominator = a.getDenominator() * b.getDenominator();
        RationalNumber rat = new RationalNumber(numerator, denominator);
        return simplify(rat);
    }

    public static RationalNumber multiply(RationalNumber a, int b) {
        return multiply(a, new RationalNumber(b));
    }

    public static RationalNumber multiply(int a, RationalNumber b) {
        return multiply(new RationalNumber(a), b);
    }

    public static RationalNumber divide(RationalNumber a, RationalNumber b) {
        int numerator = a.getNumerator() * b.getDenominator();
        int denominator = a.getDenominator() * b.getNumerator();
        RationalNumber rat = new RationalNumber(numerator, denominator);
        return simplify(rat);
    }

    public static RationalNumber divide(RationalNumber a, int b) {
        return divide(a, new RationalNumber(b));
    }

    public static RationalNumber divide(int a, RationalNumber b) {
        return divide(new RationalNumber(a), b);
    }

    public static RationalNumber parseRationalNumber(String s) {
        try {
            if (s.contains("/")) {
                String[] sArray = s.split("/");
                return new RationalNumber(Integer.parseInt(sArray[0]), Integer.parseInt(sArray[1]));
            } else if (s.contains(".") && s.indexOf(".") == s.lastIndexOf(".")) {
                s = s.replace(".", "");
                int b = (int) Math.pow(10, s.length() - 1);
                int a = Integer.parseInt(s);
                return simplify(new RationalNumber(a, b));
            } else {
                throw new NumberFormatException();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return new RationalNumber(Integer.parseInt(s));
        }
    }






    public String toString() {
        if (this.denominator != 1) {
            return this.numerator + "/" + this.denominator;
        }else {
            return "" + this.numerator;
        }
    }

    public static RationalNumber fromDoubleToRationalNumber(double d) {
        String s = Double.toString(d);
        s = s.replace(".","");
        int b = (int) Math.pow(10,s.length() - 1);
        int a = Integer.parseInt(s);
        return simplify(new RationalNumber(a,b));

    }

}