# EFFECTIVE-JAVA-NOTES

## Item 1: Consider static factory methods instead of constructors

### Pros: 
    - Unlike constructors, they have names
    - Unlike constructors, they are not required to create a new object each time they’re invoked
    - Unlike constructors, they can return an object of any subtype of their return type.
    - The class of the returned object can vary from call to call as a function of the input parameters
    - That the class of the returned objec need not to exist when the class containing the method is written

### Cons: 
    - Classes without public or protected constructors cannot be subclassed
    - They are hard for programmers to find

## Naming Cnvensions for static factory method 
- from —A type-conversion method that takes a single parameter and returns a corresponding instance of this type, for example:
        ```sh
        Date d = Date.from(instant);
        ```
- of —An aggregation method that takes multiple parameters and returns an instance of this type that incorporates them, for example
    ```sh
        Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
    ```
- valueOf —A more verbose alternative to from and of , for example:
    ```sh
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
    ```
- instance or getInstance —Returns an instance that is described by its parameters (if any) but cannot be said to have the same value, for example:
    ```sh
        StackWalker luke = StackWalker.getInstance(options);
    ```
- create or newInstance —Like instance or getInstance , except that the method guarantees that each call returns a new instance, for example:
    ```sh
        Object newArray = Array.newInstance(classObject, arrayLen);
    ```
- get Type—Like getInstance , but used if the factory method is in a different class. Type is the type of object returned by the factory method, for example:
    ```sh
        FileStore fs = Files.getFileStore(path);
    ```
- new Type—Like newInstance , but used if the factory method is in a different class. Type is the type of object returned by the factory method, for example:
    ```sh
        BufferedReader br = Files.newBufferedReader(path);
    ```
- type—A concise alternative to get Type and new Type, for example:
    ```sh
        List<Complaint> litany = Collections.list(legacyLitany);
    ```

## Item 2: Consider a builder when faced with many constructor parameters
 ```sh
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int   calories = 0;
        private int   fat = 0;
        private int   sodium = 0;
        private int  carbohydrate = 0;
        
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val) { 
            calories = val;
            return this;
        }
        public Builder fat(int val)  { 
            fat = val;
            return this;
        }
        public Builder sodium(int val) { 
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) { 
            carbohydrate = val; 
            return this;
        }
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories  = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
```

