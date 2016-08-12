package tutorial.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorial.persistence.models.Video;

public interface VideoRepository extends CrudRepository<Video, Long> {

}