package com.rali;

import com.rali.item.NutritionFacts;

public class Main {
    public static void main(String[] args) {

        // item-2
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();


    }
}
