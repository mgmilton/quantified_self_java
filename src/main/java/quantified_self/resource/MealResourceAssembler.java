package quantified_self.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import quantified_self.domain.Meal;


@Component
public class MealResourceAssembler extends ResourceAssembler<Meal, MealResource> {

	@Autowired
	protected EntityLinks entityLinks;

	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";

	@Override
	public MealResource toResource(Meal meal) {

		MealResource resource = new MealResource(meal);

		final Link selfLink = entityLinks.linkToSingleResource(meal);

		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));

		return resource;
	}
}
