<?php
/* Include "configuration.php" file */
require_once "configuration.php";



$name = ltrim(rtrim(filter_input(INPUT_POST, "name", FILTER_SANITIZE_STRING)));
if (empty($name))
{
    header("location: game.html"); // deal with invalid input
}

$score = ltrim(rtrim(filter_input(INPUT_POST, "score", FILTER_SANITIZE_NUMBER_INT)));
if ((empty($score)) || (!filter_var($score, FILTER_VALIDATE_INT))) // deal with invalid input
{
    header("location: game.html");
}


/* Connect to the database */
$dbConnection = mysqli_connect($dbHost, $dbUsername, $dbPassword, $dbName);
if (mysqli_connect_errno())
{
    die("Failed to connect to the database ".$dbName);
}


/* Perform query */
$query = "INSERT INTO high_scores (name, score) VALUES (?, ?)";
$statement = $dbConnection->prepare($query);
$statement->bind_param('si', $name, $score);         /* Valid binding types are: s = string, i = integer, d = double,  b = blob */
$statement->execute();


/* Send the $json string back to the webpage that sent the AJAX request */
echo "";


/* Close the database connection */
mysqli_close($dbConnection);
?>