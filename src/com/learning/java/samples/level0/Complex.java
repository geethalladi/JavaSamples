package com.learning.java.samples.level0;

// Immutable complex number class

public final class Complex {
  private final double re;
  private final double im;

  public static final Complex ZERO = new Complex(0, 0);
  public static final Complex ONE  = new Complex(1, 0);
  public static final Complex I    = new Complex(0, 1);

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public double realPart()      { return re; }
  public double imaginaryPart() { return im; }

  public Complex plus(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  // Static factory, used in conjunction with private constructor (Page 85)
  public static Complex valueOf(double re, double im) {
    return new Complex(re, im);
  }

  public Complex minus(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  public Complex times(Complex c) {
    return new Complex(re * c.re - im * c.im,
        re * c.im + im * c.re);
  }

  public Complex dividedBy(Complex c) {
    double tmp = c.re * c.re + c.im * c.im;
    return new Complex((re * c.re + im * c.im) / tmp,
        (im * c.re - re * c.im) / tmp);
  }

  @Override public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Complex))
      return false;
    Complex c = (Complex) o;

    // Using compare instead of ==
    return Double.compare(c.re, re) == 0
        && Double.compare(c.im, im) == 0;
  }
  @Override public int hashCode() {
    return 31 * Double.hashCode(re) + Double.hashCode(im);
  }

  @Override public String toString() {
    return "(" + re + " + " + im + "i)";
  }

  public static void main(String[] args) {
    Complex c1 = new Complex(1, 1);
    Complex c2 = Complex.valueOf(1, -1);

    System.out.println(c1.toString());
    System.out.println(c1.plus(c2));
    System.out.println(c2.minus(c1));
    System.out.println(c1.plus(I));
  }

}
