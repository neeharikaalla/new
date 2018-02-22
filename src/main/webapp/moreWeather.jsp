<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Details </title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body style="background-color:powderblue;">
<h1>Travel Assist - Distance from to ${sunSet} is ${sun_rise}</h1><br>

<h1>Travel Assist - Distance from  to ${sunSet} is ${sun_rise}</h1><br>

<div>${sunSet}</div>
<div>${sun_rise}</div>
<div>${timezone}</div>

<input id="weather" type="hidden" value="${weather}"/>
<input id="weather_response" type="hidden" value="${weather_response}"/>
 <script>
 $(document).ready(function(){
     $("button").click(function(){
         $.ajax({url: "http://localhost:8080/weather/api?name=detroit", success: function(result){
             $("#div1").html(result.consolidated_weather);
             alert(result.consolidated_weather);
         }});
     });
 });
 </script>


<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>

<button>Get External Content</button>
<footer>
 <small>&copy; Copyright 2058, Neeharika Inc</small>
</footer>
</body>
</html>
