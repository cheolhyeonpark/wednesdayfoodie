package wednesdayfoodie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import wednesdayfoodie.domain.Blog;
import wednesdayfoodie.service.SearchService;

@Controller
public class SearchController {

	@Autowired SearchService searchService;
	
	@GetMapping("/search")
	public String search(String query, int page, Model model) throws Exception {
		System.out.println("=*=*= search controller start =*=*=");
		model.addAttribute("titl", query);
		
		List<Blog> blogList = searchService.searchBlog(query, page);
		System.out.println(blogList.size());
		int total = Integer.parseInt(blogList.get(blogList.size()-1).getTitl());
		model.addAttribute("total", total);
		
		blogList.remove(blogList.get(blogList.size()-1));
		model.addAttribute("blogList", blogList);
		
		int start = page%10==0 ? ((page-1)/10)*10+1 : (page/10)*10+1;
		int end = start+9 <= total ? start+9 : total;
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		return "search";
	}
	
}
