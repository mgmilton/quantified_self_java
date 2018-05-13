package quantified_self;

import org.springframework.hateoas.ResourceSupport;

import quantified_self.domain.Food;
import com.fasterxml.jackson.annotation.JsonProperty;


public class FoodResource extends ResourceSupport {

      private final long id;
      private final String name;
      private final long calories;


      public FoodResource(Food food) {
            id = food.getId();
            name = food.getName();
            calories = food.getCalories();
      }

      @JsonProperty("id")
      public Long getResourceId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public long getCalories() {
            return calories;
      }
}
