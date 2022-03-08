package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage() {

		Optional<List<Category>> categoryOptional = categoryRepository.findByDescriptionQuery("Fast Food");
//		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");
		categoryOptional.ifPresent(
						categories -> categories.forEach(category -> System.out.println("Cat id " + category.getId() + " is : " + category.getDescription()))
		);
//		System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());

		return "index";
	}
}
