<?php
$ROOT = "../../";
include '../header.php';
include '../navi.php';
?>
<main>
    <h1>Update Anime</h1>
    <form action="index.php" method="post" id="update_anime_form">
        <input type="hidden" name="action" value="update_anime">

        <label>Studio:</label>
        <select name="studio_id" >
            <option value="<?php echo htmlspecialchars($anime['studio_id']); ?>">Same As before</option>
            <?php foreach ($studio as $category) : ?>
            <option value="<?php echo htmlspecialchars($category['studio_id']); ?>" >
                    <?php echo htmlspecialchars($category['studio_name']); ?>
                </option>
            <?php endforeach; ?>
        </select>
        <br>
        
        <input type="hidden" name="anime_id" value="<?php echo htmlspecialchars($anime['anime_id']); ?>"/>
        
        <label>Code:</label>
        <input type="text" name="code" required pattern="^[a-zA-Z0-9]{1}[a-zA-Z0-9\s_]{1,29}$" title="Format: Numbers and Letters and _ only!" value="<?php echo htmlspecialchars($anime['code']); ?>"/>
        <br>

        <label>Name:</label>
        <input type="text" name="name" required pattern="^[a-zA-Z0-9]{1}[a-zA-Z0-9\s;._]{1,50}$" title="Format: Numbers and Letters and ; . _ only!" value="<?php echo htmlspecialchars($anime['name']); ?>"/>
        <br>

        <label>Price:</label>
        <input type="text" name="price" required pattern="^[1-9]{1}[0-9]{0,2}[.]{1}[0-9]{2}$" title="Format: 10.00 or 69.99!" value="<?php echo htmlspecialchars($anime['price']); ?>"/>
        <br>

        <label>&nbsp;</label>
        <input type="submit" value="Update Anime" />
        <br>
    </form>
    <p class="last_paragraph">
        <a href="index.php?action=list_anime">View Anime List</a>
    </p>

</main>
<?php include '../footer.php'; ?>