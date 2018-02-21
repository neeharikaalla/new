package com.code.springboot.service

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DistanceService {
    private RestTemplate rest
    static private String API_KEY = 'AIzaSyAlftCr2npVtQXLIc2LFLj5h91NdsBIeI4'
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
        def weather
        def weatherMap = ImmutableMap.builder()

        try {
            res = rest.getForObject("https://www.metaweather.com/api/location/search/?query=${destination}", String)
        } catch (Exception e) {
            throw e
        }
        jsonObject = (JSONObject) parser.parse(res)


        try {
            weather = rest.getForObject("https://www.metaweather.com/api/location/${jsonObject.woeid}", Object)
        } catch (Exception e) {
            throw e
        }


        weatherMap.put('sunSet',weather.sun_set)
        weatherMap.put('sun_rise',weather.sun_rise)

        weatherMap.put('time',weather.time)
        weatherMap.put('timezone',weather.timezone)
        def consolidated_weatherList = ImmutableList.builder()
        weatherMap.put('consolidated_weather',consolidated_weatherList.add(weather.consolidated_weather))
        weatherMap.build()
    }
}
