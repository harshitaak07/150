// time limit exceed
/*
class FoodRatings {
     private String[] foods;
    private String[] cuisines;
    private int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }
    

    public void changeRating(String food, int newRating) {
        for(int i=0; i<foods.length; i++){
            if(foods[i].equals(food)){
                ratings[i] = newRating;
                break;
            }
        }
    }
    
    public String highestRated(String cuisine) {
        int greatest = 0;
        String food = "";
        int k =0;
        for(int i=0; i<cuisines.length; i++){
            if(cuisines[i].equals(cuisine)){
                if(ratings[i] > greatest){
                    greatest = ratings[i];
                    food = foods[i];
                }
                else if(ratings[i] == greatest && foods[i].compareTo(food)<0){
                    food = foods[i];
                }
            }
        }
        return food;
    }
}
*/

// My Hashmap; idek why wrong
/* 
import java.util.HashMap;
import java.util.Map;

class FoodRatings {
    private String[] foods;
    private String[] cuisines;
    private int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }
    
    private Map<String, String> foodsToCuisines = new HashMap<>();
    private Map<String, Integer> foodsToRatings = new HashMap<>();

    public void changeRating(String food, int newRating) {
        if(foodsToRatings.containsKey(food)){
            foodsToRatings.put(food,newRating);
        }
    }
    
    public String highestRated(String cuisine) {
       int greatest = 0;
       String fin = null ;
       for (Map.Entry<String, Integer> entry : foodsToRatings.entrySet()){
           String foodrn = entry.getKey();
           int ratingrn = entry.getValue();
           String cuisinern = foodsToCuisines.get(foodrn);
        if(cuisinern.equals(cuisine)){
            if( ratingrn > greatest){
                greatest = ratingrn ;
                fin = foodrn;
            }
            else if(ratingrn == greatest && foodrn.compareTo(fin) < 0 ){
                fin = foodrn;
            }
        }
       }
       return fin;
    }
}
*/

// chatgpt hashmap; lol time exceeded
import java.util.HashMap;
import java.util.Map;

public class foodRatings {
    private Map<String, Integer> foodToRating;
    private Map<String, String> foodToCuisine;

    public foodRatings(String[] foods, String[] cuisines, int[] ratings) {
        if (foods.length != cuisines.length || cuisines.length != ratings.length) {
            throw new IllegalArgumentException("Input arrays must have the same length.");
        }

        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        if (foodToRating.containsKey(food)) {
            foodToRating.put(food, newRating);
        }
    }

    public String highestRated(String cuisine) {
        int greatest = Integer.MIN_VALUE;
        String highestRatedFood = null;

        for (Map.Entry<String, Integer> entry : foodToRating.entrySet()) {
            String food = entry.getKey();
            int rating = entry.getValue();
            String foodCuisine = foodToCuisine.get(food);

            if (foodCuisine.equals(cuisine)) {
                if (rating > greatest || (rating == greatest && food.compareTo(highestRatedFood) < 0)) {
                    greatest = rating;
                    highestRatedFood = food;
                }
            }
        }

        return highestRatedFood;
    }
}
