package com.blog.service;

import com.blog.convert.JsonConverter;
import com.blog.domain.Post;
import com.blog.domain.Rank;
import com.blog.dto.BlogSearchResponse;
import com.blog.persistence.RankRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

@Service
public class BlogSearchServiceImpl implements BlogSearchService{

    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private JsonConverter jsonConverter;
    @Autowired
    private RedissonClient redissonClient;
    @Value("${apiKey}")
    private String apiKey;

    public List<BlogSearchResponse> blogSearch(String keyword, Integer page) throws UnsupportedEncodingException, URISyntaxException, ParseException, InterruptedException {
        RLock rLock = redissonClient.getLock("RedissonLock");

        try {
            boolean available = rLock.tryLock(5, 3, TimeUnit.SECONDS);
            if (!available) {
                return null;
            }

            // API 호출
            RestTemplate rest = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String apikey = "KakaoAK "+apiKey;
            headers.set("Authorization",apikey);

            HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
            String encode = URLEncoder.encode(keyword,"UTF-8");
            String rawURI = "https://dapi.kakao.com/v2/search/blog?query="+encode+"?page="+page.toString();

            URI uri = new URI(rawURI);

            ResponseEntity<String> res = rest.exchange(uri, HttpMethod.GET, entity, String.class);

            JSONParser jsonParser = new JSONParser();
            JSONObject body = (JSONObject) jsonParser.parse(res.getBody().toString());
            JSONArray docu = (JSONArray) body.get("documents");

            if(docu.size() != 0){
                BlogSearchResponse post = new BlogSearchResponse();
                List<BlogSearchResponse> postList = new ArrayList<>();

                for(int i=0; i<docu.size(); i++){
                    post = jsonConverter.convertToEntityAttribute(String.valueOf(docu.get(i)));
                    postList.add(post);
                }
                return postList;
            }

            // add Keyword Count
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new InterruptedException();
        } finally {
            rLock.unlock();
        }
        return null;
    }

    public List<Rank> getRank() {
        List<Rank> ranks = rankRepository.getRank();
        return ranks;
    }
}
