package wednesdayfoodie.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import wednesdayfoodie.domain.Blog;
import wednesdayfoodie.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Override
	public List<Blog> searchBlog() {
		String clientId = "G6GX00SpQx4U_rawStjU";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "BnegF9PJXY";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode("그린팩토리", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text; // json 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
			
			JSONObject jsonObject = new JSONObject(response.toString());
			JSONArray array = jsonObject.getJSONArray("items");
			
			List<Blog> blogList = new ArrayList<>();
			for (int i = 0; i < array.length(); i++) {
				JSONObject data = (JSONObject) array.get(i);
				Blog blog = new Blog();
				blog.setTitl(data.getString("title"));
				blog.setLink(data.getString("link"));
				blog.setDescription(data.getString("description"));
				blog.setName(data.getString("bloggername"));
				blogList.add(blog);
			}
			
			return blogList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
