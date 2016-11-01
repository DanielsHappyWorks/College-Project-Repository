<?php
$ROOT = "../../";
include '../header.php';
include '../navi.php';
?>
<main>
    <aside>
        <h1>Categories</h1>
        <nav>
            <ul>
                <!-- display links for all categories -->
                <?php foreach ($studio as $category) : ?>
                    <li>
                        <a href="?studio_id=<?php echo htmlspecialchars($category['studio_id']); ?>">
                            <?php echo $category['studio_name']; ?>
                        </a>
                    </li>
                <?php endforeach; ?>
            </ul>
        </nav>
    </aside>
    <section>
        <h1><?php echo htmlspecialchars($name); ?></h1>
        <div id="left_column">
            <p>
                <img src="<?php echo $image_filename; ?>"
                     alt="<?php echo $image_alt; ?>" width="163" height="163"/>
            </p>
        </div>

        <div id="right_column">
            <p><b>List Price:</b> $<?php echo htmlspecialchars($price); ?></p>
            <p><b>Discount:</b> <?php echo htmlspecialchars($discount_percent); ?>%</p>
            <p><b>Your Price:</b> $<?php echo htmlspecialchars($unit_price_f); ?>
                (You save $<?php echo htmlspecialchars($discount_amount_f); ?>)</p>
            <form action="<?php echo '../cart' ?>" method="post">
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="anime_id"
                       value="<?php echo htmlspecialchars($anime_id); ?>">
                <b>Quantity:</b>
                <input id="quantity" type="text" name="quantity" 
                       value="1" size="2" required pattern="^[1-9]{1}[0-9]{0,2}$" title="Format: Numbers greater then 0 and less then 1000!">
                <br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>
    </section>
</main>
<?php include '../facebook_comments.php'; ?>
<?php include '../footer.php'; ?>