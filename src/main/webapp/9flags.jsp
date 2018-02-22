<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>9flags </title>
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
.data-col:first-child {
    width: 25%;
}
.head-col:first-child {
    width: 25%
}
</style>
</head>
<body style="background-color:powderblue;">


<input id="destination" type="hidden" value="${destination}"/>
<script>
 $(document).ready(function(){
     $("button").click(function(){
     var destination = document.getElementById("destination").value;
         $.ajax({url: "http://localhost:8080/9flags/api?name="+destination, success: function(result){


         var places;
         var place;
         var name, city, bedCount, price;

          if (!result["9flats"]) {
                        return;
          }
            places = result["9flats"].places;


            var domFragment = $('<ul>');

            var heading = $('<li>');
             heading.append('<div class="head-col">name</div>');
             heading.append('<div class="head-col">city</div>');
             heading.append('<div class="head-col">bed count</div>');
             heading.append('<div class="head-col">price</div>');

                domFragment.append(heading);

             for (var i = 0; i < places.length; i++) {
                 place = places[i];
                 name = place.place.place_details.name;
                 city = place.place.place_details.city;
                 bedCount = place.place.place_details.number_of_beds;
                 price = place.place.pricing.price;

                 var line = $('<li>');
                 col0 = $('<div class="data-col"></div>');
                 col0.text(name);
                 col1 = $('<div class="data-col"></div>');
                 col1.text(city);
                 col2 = $('<div class="data-col"></div>');
                 col2.text(bedCount);
                 col3 = $('<div class="data-col"></div>');
                 col3.text(price);

                 line.append(col0, col1, col2, col3);

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
