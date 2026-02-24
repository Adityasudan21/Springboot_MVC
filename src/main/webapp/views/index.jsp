<%@page language="java" %>
<!-- We also need to add this in the webapp folder at ViewResolver only goes to see in this Folder -->
<!-- If we want to add in another folders in webapp then we need to give full path in Controller return
    This could also be removed if we use Suffix and prefix properyy of MVC in Application.properties so that
    We not need to write the full path and .jsp everytime. -->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>Telusko Calculator</h2>

        <!-- this will call the /add request -->
         <form action="add">
                <label for="num1">Enter 1st Number :</label>
                <input type="text" id="num1" name="num1"><br>
                <label for="num2">Enter 2nd Number :</label>
                <input type="text" id="num2" name="num2"><br>
                <input type="submit" value="Submit">
            </form>
            <br><br>
            <form action="alien">
                <input type="submit" value="Go to Alien Page">
            </form>
    </body>
</html>