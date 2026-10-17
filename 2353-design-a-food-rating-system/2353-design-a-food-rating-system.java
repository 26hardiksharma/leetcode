class Food implements Comparable<Food>{
    String name;
    String cuisine;
    int rating;
    
    Food(String name,String cuisine,int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public int compareTo(Food f) {
        if(this.rating != f.rating) {
            return Integer.compare(f.rating,this.rating);
        }

        return name.compareTo(f.name);
    }
}  
class FoodRatings {
    HashMap<String,PriorityQueue<Food>> map = new HashMap<>();
    HashMap<String,String> foodMap = new HashMap<>();
    HashMap<String,Integer> ratingMap = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0;i<foods.length;i++) {
            Food food = new Food(foods[i],cuisines[i],ratings[i]);
            if(!map.containsKey(cuisines[i])) {
                map.put(cuisines[i],new PriorityQueue<>());
            }
            foodMap.put(foods[i],cuisines[i]);
            map.get(cuisines[i]).offer(food);
            ratingMap.put(foods[i],ratings[i]);
        }

    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodMap.get(food);
        Food f= new Food(food,cuisine,newRating);
        ratingMap.put(food,newRating);
        map.get(cuisine).offer(f);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = map.get(cuisine);

        while(!pq.isEmpty()) {
            Food food = pq.peek();

            if(ratingMap.get(food.name)!=food.rating) {
                pq.poll();
                continue;
            }

            return food.name;
        }

        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */