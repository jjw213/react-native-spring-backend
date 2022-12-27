package com.reactnativespring.rns.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommonMarketService {
//    @Autowired
//    List<MarketService> marketServiceList; // MarketService 를 상속 받는 모든 클래스들을 List 타입으로 불러옴
    @Autowired
    Map<String, MarketService> marketServices; // MarketService 를 상속 받는 모든 클래스들을 key는 String으로 해서 불러옴

    public double getPrice(String market, String coin) {
        MarketService marketService = null;


        for(String key : marketServices.keySet()) {
            if(key.substring(0, market.length()).equals(market.toLowerCase())) {
                marketService = marketServices.get(key);
                break;

            }
        }
        return marketService.getCoinCurrentPrice(coin);
    }
}