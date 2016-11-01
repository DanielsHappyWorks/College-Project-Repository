<?php
/* Include "configuration.php" file */
require_once "configuration.php";



/* Connect to the database */
$dbConnection = mysqli_connect($dbHost, $dbUsername, $dbPassword, $dbName);
if (mysqli_connect_errno())
{
    die("Failed to connect to the database ".$dbName);
}


/* Perform query */
$query = "SELECT name, score FROM high_scores ORDER BY score DESC";
$statement = $dbConnection->prepare($query);        
$statement->execute();


/* Manipulate the query result */
$queryResult = $statement->get_result();
$json = "[";
if(($queryResult) && (mysqli_num_rows($queryResult) > 0))
{
    /* Get field information for all fields */
    $isFirstRecord = true;
    while ($row = mysqli_fetch_object($queryResult))
    {
        if(!$isFirstRecord)
        {
            $json .= ",";
        }
        
        /* NOTE: json strings MUST have double quotes around the attribute names, as shown below */
        $json .= '{"name":"' . $row->name . '","score":"' . strval($row->score)  . '"}';
        
        $isFirstRecord = false;
    }  
}     
$json .= "]";

/* Send the $json string back to the webpage that sent the AJAX request */
echo $json;

mysqli_free_result($queryResult); /* Free memory being used by queryResult */

/* Close the database connection */
mysqli_close($dbConnection);
?>