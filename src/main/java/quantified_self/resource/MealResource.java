package quantified_self.resource;

import org.springframework.hateoas.ResourceSupport;

import quantified_self.domain.Meal;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MealResource extends ResourceSupport {

      private final long id;
      private final String name;


      public MealResource(Meal meal) {
            id = meal.getId();
            name = meal.getName();
      }

      @JsonProperty("id")
      public Long getResourceId() {
            return id;
      }

      public String getName() {
            return name;
      }
}
