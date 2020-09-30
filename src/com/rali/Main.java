package com.rali;

import com.rali.item.Calzone;
import com.rali.item.NutritionFacts;
import com.rali.item.NyPizza;
import com.rali.item.Pizza;

import static com.rali.item.NyPizza.Size.SMALL;

public class Main {
    public static void main(String[] args) {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();

    }
}
