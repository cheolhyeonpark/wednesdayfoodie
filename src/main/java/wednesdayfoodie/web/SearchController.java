package wednesdayfoodie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import wednesdayfoodie.service.SearchService;

@Controller
public class SearchController {

	@Autowired SearchService searchService;
	
	@GetMapping("/search")
	public String search(Model model) throws Exception {
		System.out.println("=*=*= search controller start =*=*=");
		model.addAttribute("blogList", searchService.searchBlog());
		// searchService.searchBlog();
		return "search";
	}
	
}
