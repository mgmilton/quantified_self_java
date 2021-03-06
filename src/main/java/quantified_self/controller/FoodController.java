package quantified_self.controller;

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

import quantified_self.domain.Food;
import quantified_self.repository.FoodRepository;
import quantified_self.resource.FoodResource;
import quantified_self.resource.FoodResourceAssembler;


@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Food.class)
@RequestMapping(value = "api/v1/foods", produces = "application/json")
public class FoodController {
      @Autowired
      private FoodRepository repository;

      @Autowired
      private FoodResourceAssembler assembler;

      @RequestMapping(method = RequestMethod.GET)
    	public ResponseEntity<Collection<FoodResource>> findAllFoods() {
    		List<Food> foods = repository.findAll();
    		return new ResponseEntity<>(assembler.toResourceCollection(foods), HttpStatus.OK);
    	}

    	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    	public ResponseEntity<FoodResource> createFood(@RequestBody Food food) {
    		Food createdFood = repository.create(food);
    		return new ResponseEntity<>(assembler.toResource(createdFood), HttpStatus.CREATED);
    	}

    	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    	public ResponseEntity<FoodResource> findFoodById(@PathVariable Long id) {
    		Optional<Food> food = repository.findById(id);

    		if (food.isPresent()) {
    			return new ResponseEntity<>(assembler.toResource(food.get()), HttpStatus.OK);
    		}
    		else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	}

    	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    	public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
    		boolean wasDeleted = repository.delete(id);
    		HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
    		return new ResponseEntity<>(responseStatus);
    	}

    	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    	public ResponseEntity<FoodResource> updateOrder(@PathVariable Long id, @RequestBody Food updatedFood) {
    		boolean wasUpdated = repository.update(id, updatedFood);

    		if (wasUpdated) {
    			return findFoodById(id);
    		}
    		else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	}

}
