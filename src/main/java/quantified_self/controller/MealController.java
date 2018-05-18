package quantified_self.controller;
ssssss
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import quantified_self.domain.Meal;
import quantified_self.repository.MealRepository;
import quantified_self.resource.MealResource;
import quantified_self.resource.MealResourceAssembler;


@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Meal.class)
@RequestMapping(value = "api/v1/meals", produces = "application/json")
public class MealController {
      @Autowired
      private MealRepository repository;

      @Autowired
      private MealResourceAssembler assembler;

      @RequestMapping(method = RequestMethod.GET)
      public ResponseEntity<Collection<MealResource>> findAllMeals() {
        List<Meal> meals = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(meals), HttpStatus.OK);
      }

      @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
      public ResponseEntity<MealResource> createMeal(@RequestBody Meal meal) {
        Meal createdMeal = repository.create(meal);
        return new ResponseEntity<>(assembler.toResource(createdMeal), HttpStatus.CREATED);
      }

      @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public ResponseEntity<MealResource> findMealById(@PathVariable Long id) {
        Optional<Meal> meal = repository.findById(id);

        if (meal.isPresent()) {
          return new ResponseEntity<>(assembler.toResource(meal.get()), HttpStatus.OK);
        }
        else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      }
}
