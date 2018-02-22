package com.code.springboot.service

import com.google.common.collect.ImmutableMap
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DistanceService {
    private RestTemplate rest
    static private String API_KEY = 'AIzaSyAlftCr2npVtQXLIc2LFLj5h91NdsBIeI4'
    static private String Flags_Api_key = 'yk0X46EOgOfQ657Deu8Qv0RrvKDBGpqkCtPgKWso'
    private String url
    JSONObject jsonObject = new JSONObject()
    JSONParser parser = new JSONParser()

    DistanceService(RestTemplate rest, String url) {
        this.rest = rest
        this.url = url
    }

    Map<Object, Object> getDistance(String origins, String destinations) {

        def response
        def distanceMap = ImmutableMap.builder()
        try {
            response =
                    rest.getForObject(url + "/json?units=imperial&origins=${origins},WA&destinations=${destinations}&key=${API_KEY}", Object)

        } catch (final Exception e) {
            throw e
        }
        if (response != null) {
            distanceMap.put('destination_addresses', response.destination_addresses as String)
            distanceMap.put('origin_addresses', response.origin_addresses as String)
            distanceMap.put('distance', response.rows.elements.distance.text)
            distanceMap.put('duration', response.rows.elements.duration.text as String)
        }

        distanceMap.build()

    }

    Map<Object, Object> getWeather(String destination) {
        def res
        def weatherMap = ImmutableMap.builder()

        try {
            res = rest.getForObject("https://www.metaweather.com/api/location/search/?query=${destination}", String)
        } catch (Exception e) {
            throw e
        }
        jsonObject = (JSONObject) parser.parse(res)

        ResponseEntity<String> response
        try {
            HttpHeaders headers = new HttpHeaders()
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE)

            HttpEntity entity = new HttpEntity(headers)


            response = rest.exchange(
                    "https://www.metaweather.com/api/location/${jsonObject.woeid}", HttpMethod.GET, entity, String.class, "")

        } catch (Exception e) {
            throw e
        }

        weatherMap.put('consolidated_weather', response.getBody().toString()).build()

    }

    Map<String, Object> get9FlatsApi(def destination) {
       def response
        def responseMap = ImmutableMap.builder()
        try {
            HttpHeaders headers = new HttpHeaders()
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE)



            response = rest.getForObject(
                    "https://www.9flats.com/api/v4/places?client_id=${Flags_Api_key}&search[query]=${destination}",Object)

        } catch (Exception e) {
            throw e
        }
        responseMap.put("9flats", response).build()

    }

}
