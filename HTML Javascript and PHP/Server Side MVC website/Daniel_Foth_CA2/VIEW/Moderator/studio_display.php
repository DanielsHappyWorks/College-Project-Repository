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
        <h2>Studio Details</h2>
        <table>
            <tr>
                <th>Studio</th>
                <th>Founding Date:</th>
                <th>Website</th>
            </tr>
            <?php foreach ($studios as $studio) : ?>
                <tr>
                    <td><?php echo htmlspecialchars($studio['studio_name']); ?></td>
                    <td><?php echo htmlspecialchars($studio['founding_date']); ?></td>
                    <td class="right"><?php echo htmlspecialchars($studio['website']); ?></td>
                </tr>
            <?php endforeach; ?>
        </table>
        <p class="last_paragraph">
            <a href="?action=show_add_form">Add Anime</a>
            <a href="?action=show_studio_form">Add Studio</a>
            <a href="?action=show_delete_form">Delete Studio</a><br>
            <a href="?action=update_studio_form">Update Studio</a>
            <a href="?action=show_messages_form">View Messages</a>
        </p>
    </section>
</main>
<?php include '../footer.php'; ?>