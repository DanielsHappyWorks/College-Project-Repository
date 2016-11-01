<!DOCTYPE html>
<html>
<head>
<title>Contact Us</title>
<meta http-equiv = "refresh" content="3; url=contact_us.html">
<link href = "../css/my_css.css" rel = "stylesheet" type = "text/css">
</head>
<body>

<?php
/* read posted data */
$name = mysql_real_escape_string($_POST["name"]);
$email = mysql_real_escape_string($_POST["email"]);
$message = mysql_real_escape_string($_POST["message"]);

if (($name == false) ||
        ($email == false) ||
        ($message == false))
{
    die("bad input");
}

include '../configuration.php';
$dbConnection = mysqli_connect($dbHost, $dbUsername, $dbPassword, $dbName);

/* Check connection */
if (mysqli_connect_errno())
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}



$query = "INSERT INTO message (name, email, message) VALUES ('$name', '$email', '$message')";

if (($queryResult = mysqli_query($dbConnection, $query)) != false)
{
    echo "Record was added successfully";
}
else
{
    echo "ERROR: Record not added";
}

/* free result set */
mysqli_free_result($queryResult);

/* close the database */
mysqli_close($dbConnection);
?>        

</body>
</html>        