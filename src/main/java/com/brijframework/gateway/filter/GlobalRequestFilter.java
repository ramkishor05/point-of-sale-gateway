package com.brijframework.gateway.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;

import com.brijframework.gateway.dto.UserDetailResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Component
public class GlobalRequestFilter implements GlobalFilter, Ordered {
	
	private final static String USER_ENDPOINT="http://localhost:3333/api/authentication/userdetail";
	
	@Autowired
	private RestTemplate restTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    	System.out.println(exchange.getRequest().getPath());
        ServerHttpRequest request = exchange.getRequest();
        List<String> list = request.getHeaders().get("Authorization");
        if(!CollectionUtils.isEmpty(list)) {
        	  try {
	        	HttpMethod method=HttpMethod.GET;
	        	HttpHeaders  headers=new HttpHeaders();
	        	headers.set("Authorization", list.get(0));
	        	HttpEntity<String> entity = new HttpEntity<>("body", headers);
	        	UserDetailResponse forObject = restTemplate.exchange(USER_ENDPOINT,method, entity, UserDetailResponse.class).getBody();
	            ObjectMapper mapper=new ObjectMapper();
				System.out.println("shh="+mapper.writeValueAsString(forObject));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }
}