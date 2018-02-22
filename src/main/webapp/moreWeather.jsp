<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>More weather</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
             $("#div1").html(result.consolidated_weather);
             alert(result.consolidated_weather);
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
