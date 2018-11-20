package wednesdayfoodie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wednesdayfoodie.domain.Restaurant;
import wednesdayfoodie.repository.RestaurantRepository;
import wednesdayfoodie.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> list() {
		return restaurantRepository.restaurantList();
	}
}
