<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Travel Assist</title>

</head>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
#content,footer{
max-width: 700px;
margin-left: auto;
margin-right: auto;
text-align: center;
}


</style>
<body style="background-color:powderblue;">
<div id="content">
<h1 style="text-align:center;">Welcome to Your Travel Assist</h1>
<div>
<form action="distance/s" style="text-align:center;">
  Origin : <input style="text-align:center;" align="left" type="text" name="origin" path="origin" id="origin"><br>
  Destination : <input style="text-align:center;" align="left" type="text" name="destination" path="destination" id="destination"><br>
  <input type="submit" value="Submit">
</form>
</div>
</div>
<footer  style="text-align:center;">
 <small>&copy; Copyright 2058, Neeharika Inc</small>
</footer>
</body>
</html>
