package quantified_self.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import quantified_self.domain.Food;


@Component
public class FoodResourceAssembler extends ResourceAssembler<Food, FoodResource> {

	@Autowired
	protected EntityLinks entityLinks;

	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";

	@Override
	public FoodResource toResource(Food food) {

		FoodResource resource = new FoodResource(food);

		final Link selfLink = entityLinks.linkToSingleResource(food);

		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));

		return resource;
	}
}
