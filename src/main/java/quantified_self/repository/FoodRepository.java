package quantified_self.repository;

import org.springframework.stereotype.Repository;

import quantified_self.domain.Food;

@Repository
public class FoodRepository extends InMemoryRepository<Food> {

      protected void updateIfExists(Food original, Food updated){
            original.setName(updated.getName());
            original.setCalories(updated.getCalories());
      }
}
