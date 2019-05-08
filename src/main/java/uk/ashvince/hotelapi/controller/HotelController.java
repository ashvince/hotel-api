package uk.ashvince.hotelapi.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ashvince.hotelapi.exception.HotelNotFoundException;
import uk.ashvince.hotelapi.model.Hotel;
import uk.ashvince.hotelapi.repository.HotelRepository;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class HotelController {

  private final HotelRepository hotelRepository;

  @GetMapping
  public List<Hotel> findAll() {
    return hotelRepository.findAll();
  }

  @PostMapping
  public Hotel createHotel(
      @RequestBody Hotel hotel
  ) {
    return hotelRepository.save(hotel);
  }

  @GetMapping("/{hotelId}")
  public Hotel findById(
      @PathVariable("hotelId") String id
  ) {
    return hotelRepository.findById(id).orElseThrow(HotelNotFoundException::new);
  }

}
