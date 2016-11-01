<?php
$ROOT = "../../";
include '../header.php';
?>
<main>
    <h1>Delete Studio</h1>
    <form action="index.php" method="post" id="show_delete_form">
        <input type="hidden" name="action" value="delete_studio">
        
        <label></label>
        <br>
        <select name="studio_id">
            <?php foreach ($studio as $category) : ?>
                <option value="<?php echo htmlspecialchars($category['studio_id']); ?>">
                    <?php echo htmlspecialchars($category['studio_name']); ?>
                </option>
            <?php endforeach; ?>
        </select>
        <input type="submit" value="Delete Studio" />
        <br>
    </form>
    <p class="last_paragraph">
        <a href="index.php?action=list_anime">View Anime List</a>
    </p>

</main>