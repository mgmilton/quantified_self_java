package quantified_self.repository;

import org.springframework.stereotype.Repository;

import quantified_self.domain.Meal;

@Repository
public class MealRepository extends InMemoryRepository<Meal> {

      protected void updateIfExists(Meal original, Meal updated){
            original.setName(updated.getName());
      }
}
