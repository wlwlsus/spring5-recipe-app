package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findByDescription(String description);

	@Query("select m from Category m")
	Optional<List<Category>> findByDescriptionQuery(@Param("description") String description);

}
