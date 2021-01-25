package com.learning.java.samples.level1;

// Builder Pattern
public class NutritionFacts
{
    // All the member variables are immutable
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // Constructor is private and cannot be called from outside
    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
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

    // Builder class to handle building the 'NutritionFact' instance
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        public NutritionFacts build() {
            // Call to the private constructor happens over here
            // Note to 'this' argument
            return new NutritionFacts(this);
        }
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
            .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);
    }
}
