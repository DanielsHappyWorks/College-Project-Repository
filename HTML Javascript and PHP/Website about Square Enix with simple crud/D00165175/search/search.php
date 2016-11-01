<!DOCTYPE html>
<html>
<head>
<title>PHP Insert Example</title>
</head>
<body>

<?php
/* read posted data */
$tag = mysql_real_escape_string($_POST["tag"]);
$link = mysql_real_escape_string($_POST["link"]);
if (($tag == false) ||
        ($link == false))
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



$query = "INSERT INTO search (tag, link) VALUES ('$tag', '$link')";

if (($queryResult = mysqli_query($dbConnection, $query)) != false)
{
    echo "Record successfully added to database";
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