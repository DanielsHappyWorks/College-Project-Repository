<?php
$ROOT = "../../";
include '../header.php';
?>
<main>
    <h1>Add Studio</h1>
    <form action="index.php" method="post" id="add_studio_form">
        <input type="hidden" name="action" value="add_studio">
        
        <label></label>
        <input type="hidden" name="studio_id" value=""/>
        <br>
        
        <label>Studio Name:</label>
        <input type="text" name="studio_name" required pattern="^[a-zA-Z0-9]{3}[a-zA-Z0-9\s]{0,50}$" title="Format: Numbers and Letters only!"/>
        <br>
        <label>Founding Date:</label>
        <input type="date" name="founding_date" required/>
        <br>
        <label>Website Link:</label>
        <input type="text" name="website" required pattern="^[h][t][t][p][:][/][/][w][w][w][.][a-zA-Z0-9]{1,20}[.][a-zA-Z0-9]{1,5}$" title="Format: http://www.a1p.jp only!"/>
        <br>
        <label>&nbsp;</label>
        <input type="submit" value="Add Studio" />
        <br>
    </form>
    <p class="last_paragraph">
        <a href="index.php?action=list_anime">View Anime List</a>
    </p>

</main>