<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>More weather</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
ul {
    list-style-type: none;
    }
.data-col {
    display: inline-block;
    width: 10%;
}
.head-col {
    display: inline-block;
    width: 10%;
    font-weight: bold;
}
</style>
</head>
<body style="background-color:powderblue;">
<h1>Travel Assist - Distance from to ${sunSet} is ${sun_rise}</h1><br>


<div>${sunSet}</div>
<div>${sun_rise}</div>
<div>${timezone}</div>

<input id="destination" type="hidden" value="${destination}"/>
<script>
 $(document).ready(function(){
     $("button").click(function(){
     var destination = document.getElementById("destination").value;
     alert(destination);
         $.ajax({url: "http://localhost:8080/weather/api?name="+destination, success: function(result){
//console.log(result.consolidated_weather);

            var weatherData;
            var domFragment = $('<ul>');
            var weatherObj;
            var today, state, direction, maxTemp, minTemp, currTemp;
            var col0, col1, col2, col3, col4, col5;

            if (!result.consolidated_weather) {
               return;
            }
            var response = JSON.parse(result.consolidated_weather);

            weatherData = response.consolidated_weather;

            var heading = $('<li>');
            heading.append('<div class="head-col">Date</div>');
            heading.append('<div class="head-col">State</div>');
            heading.append('<div class="head-col">Direction</div>');
            heading.append('<div class="head-col">Max Temp</div>');
            heading.append('<div class="head-col">Min Temp</div>');
            heading.append('<div class="head-col">Current Temp</div>');

            domFragment.append(heading);

            for (var i = 0; i < weatherData.length; i++) {
                weatherObj = weatherData[i];
                today = weatherObj["applicable_date"];
                state = weatherObj["weather_state_name"];
                direction = weatherObj["wind_direction_compass"];
                maxTemp = weatherObj["max_temp"];
                minTemp = weatherObj["min_temp"];
                currTemp = weatherObj["the_temp"];

                maxTemp = maxTemp.toFixed(3);
                minTemp = minTemp.toFixed(3);
                currTemp = currTemp.toFixed(3);

                var line = $('<li>');
                col0 = $('<div class="data-col"></div>');
                col0.text(today);
                col1 = $('<div class="data-col"></div>');
                col1.text(state);
                col2 = $('<div class="data-col"></div>');
                col2.text(direction);
                col3 = $('<div class="data-col"></div>');
                col3.text(maxTemp);
                col4 = $('<div class="data-col"></div>');
                col4.text(minTemp);
                col5 = $('<div class="data-col"></div>');
                col5.text(currTemp);

                line.append(col0, col1, col2, col3, col4, col5);

                domFragment.append(line);
            }

            $("#div1").append(domFragment);
         }});
     });
 });
</script>


<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>

<button>Get more weather details</button>
<footer>
 <small>&copy; Copyright 2058, Neeharika Inc</small>
</footer>
</body>
</html>
