package uk.ashvince.hotelapi.repository;

import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import uk.ashvince.hotelapi.model.Hotel;

@EnableScan
public interface HotelRepository extends CrudRepository<Hotel, String> {
  List<Hotel> findAll();
}
