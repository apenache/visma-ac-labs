package com.doubletex.app.recap;

import org.springframework.context.annotation.Bean;

public class DependencyInjection {
    interface DrinkDispenser {
        String getDrink(float liters);
    }

    static class WaterDispenser implements DrinkDispenser {
        public String getDrink(float liters) {
            return "Water" + " " + liters + "L";
        }
    }

    static class WhiskyDispenser implements DrinkDispenser {
        private final float alcoholPercentage;

        public WhiskyDispenser(float alcoholPercentage) {
            this.alcoholPercentage = alcoholPercentage;
        }

        public String getDrink(float liters) {
            return "Whisky " + alcoholPercentage * 100 + "% " + Math.min(liters, 0.1F) + "L";
        }
    }

    static class SodaDispenser implements DrinkDispenser {
        private final String brand;
        private final boolean fizzy;

        public SodaDispenser(String brand, boolean fizzy) {
            this.brand = brand;
            this.fizzy = fizzy;
        }

        public String getDrink(float liters) {
            return (fizzy ? " Fizzy" : " Flat") + " Soda " + brand + " " + liters + "L";
        }
    }

    static class Shop {
        private final DrinkDispenser drinkDispenser;
        private final float maximumSample;

        public Shop(DrinkDispenser drinkDispenser, float maximumSample) {
            this.drinkDispenser = drinkDispenser;
            this.maximumSample = maximumSample;
        }

        public String giveSampleDrink() {
            return drinkDispenser.getDrink(maximumSample);
        }
    }

    public static void main(String[] args) {
//        DrinkDispenser availableDispenser = new WaterDispenser();
//        DrinkDispenser availableDispenser = new SodaDispenser("Coca-Cola", true);
        DrinkDispenser availableDispenser = new WhiskyDispenser(0.4F);
        Shop cornerStore = new Shop(availableDispenser, 0.5F);

        System.out.println(cornerStore.giveSampleDrink());
    }
}
