package com.learning.java.samples.level2;

class Rectangle extends Figure {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width  = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
