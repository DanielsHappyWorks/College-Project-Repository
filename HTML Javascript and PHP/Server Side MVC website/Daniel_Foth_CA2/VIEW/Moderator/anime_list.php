<?php
$ROOT = "../../";
include '../header.php';
include '../navi.php';
?>
<main>
    <h1>Anime List</h1>

    <aside>
        <!-- display a list of categories -->
        <h2>Studio</h2>
        <nav>
            <ul>
                <?php foreach ($studio as $category) : ?>
                    <li>
                        <a href="?studio_id=<?php echo htmlspecialchars($category['studio_id']); ?>">
                            <?php echo htmlspecialchars($category['studio_name']); ?>
                        </a>
                    </li>
                <?php endforeach; ?>
            </ul>
        </nav>
    </aside>

    <section>
        <!-- display a table of anime -->
        <h2><?php echo $studio_name; ?></h2>
        <table>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th class="right">Price</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <?php foreach ($anime as $product) : ?>
                <tr>
                    <td><?php echo htmlspecialchars($product['code']); ?></td>
                    <td><?php echo htmlspecialchars($product['name']); ?></td>
                    <td class="right"><?php echo htmlspecialchars($product['price']); ?></td>
                    <td><form action="." method="post">
                            <input type="hidden" name="action"
                                   value="delete_anime">
                            <input type="hidden" name="anime_id"
                                   value="<?php echo htmlspecialchars($product['anime_id']); ?>">
                            <input type="hidden" name="studio_id"
                                   value="<?php echo htmlspecialchars($product['studio_id']); ?>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    <td><form action="." method="post">
                            <input type="hidden" name="action"
                                   value="update_anime_form">
                            <input type="hidden" name="anime_id"
                                   value="<?php echo htmlspecialchars($product['anime_id']); ?>">
                            <input type="hidden" name="studio_id"
                                   value="<?php echo htmlspecialchars($product['studio_id']); ?>">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            <?php endforeach; ?>
        </table>
        <p class="last_paragraph">
            <a href="?action=show_add_form">Add Anime</a>
            <a href="?action=list_studio">Display Studio Details</a>
            <a href="?action=show_studio_form">Add Studio</a>
            <a href="?action=show_delete_form">Delete Studio</a><br>
            <a href="?action=update_studio_form">Update Studio</a>
            <a href="?action=show_messages_form">View Messages</a>
        </p>
    </section>
</main>
<?php include '../footer.php'; ?>