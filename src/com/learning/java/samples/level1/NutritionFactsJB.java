package com.learning.java.samples.level1;

// Java Bean style
public class NutritionFactsJB {

    // All the member variables are private
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    // JavaBeans Pattern - allows inconsistency, mandates mutability
    public NutritionFactsJB() { }

    // Setters
    public void setServingSize(int val) {
        servingSize = val;
    }

    public void setServings(int val) {
        servings = val;
    }

    public void setCalories(int val) {
        calories = val;
    }

    public void setFat(int val) {
        fat = val;
    }

    public void setSodium(int val) {
        sodium = val;
    }

    public void setCarbohydrate(int val) {
        carbohydrate = val;
    }

    // Defines the string representation of the object
    @Override
    public String toString() {
        return String.format("NutritionFact: %s,%s,%s,%s,%s,%s",
                             servingSize,
                             servings,
                             calories,
                             fat,
                             sodium,
                             carbohydrate);
    }

    public static void main(String[] args) {
        // JavaBeans Pattern - allows inconsistency, mandates mutability
        NutritionFactsJB cocaCola = new NutritionFactsJB();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        System.out.println(cocaCola);
    }
}
