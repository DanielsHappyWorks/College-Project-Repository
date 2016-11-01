<?php
$ROOT = "../../";
include '../header.php';
include '../navi.php';
?>
<main>
    <aside>
        <h1>Studio's</h1>
        <nav>
            <ul>
                <!-- display links for all categories -->
                <?php foreach ($studio as $category) : ?>
                    <li>
                        <a href="?studio_id=<?php echo $category['studio_id']; ?>">
                            <?php echo $category['studio_name']; ?>
                        </a>
                    </li>
                <?php endforeach; ?>
            </ul>
        </nav>
    </aside>
    <section>
        <h1><?php echo $studio_name; ?></h1>
        <nav>
            <ul>
                <!-- display links for products in selected category -->
                <?php foreach ($anime as $product) : ?>
                    <li>
                        <a href="?action=view_anime&amp;anime_id=<?php echo $product['anime_id']; ?>">
                            <?php echo $product['name']; ?>
                        </a>
                    </li>
                <?php endforeach; ?>
            </ul>
        </nav>
    </section>
</main>
<?php include '../footer.php'; ?>