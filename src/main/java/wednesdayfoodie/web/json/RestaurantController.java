package wednesdayfoodie.web.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import wednesdayfoodie.domain.Restaurant;
import wednesdayfoodie.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired RestaurantService restaurantService;
	
	@GetMapping("/list")
	public Object list() throws Exception {
		System.out.println("=*=*= controller start =*=*=");
		
		HashMap<String, Object> result = new HashMap<>();
		List<Restaurant> list = restaurantService.list();
		
		result.put("status", "success");
		result.put("list", list);
		
		for (Restaurant rest : list) {
			System.out.println(rest.getTitl());
		}
		
		return result;
	}
}
