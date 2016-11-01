<?php
$ROOT = "../../";
include 'header.php';
include 'navi.php';
?>
<main>
    <h1>Database Error</h1>
    <p class="first_paragraph">There was an error connecting to the database.</p>
    <p>The database must be installed correctly.</p>
    <p>MySQL must be running correctly.</p>
    <p class="last_paragraph">Error message: <?php echo $error_message; ?></p>
</main>
<?php include '../view/footer.php'; ?>