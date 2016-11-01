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
        <h2>Messages</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>&nbsp;</th>
            </tr>
            
            <?php foreach ($messages as $message) : ?>
                <tr>
                    <td><?php echo htmlspecialchars($message['contact_name']); ?></td>
                    <td><?php echo htmlspecialchars($message['contact_email']); ?></td>
                    <td><?php echo htmlspecialchars($message['contact_message']); ?></td>
                    <td><form action="." method="post">
                            <input type="hidden" name="action"
                                   value="delete_message">
                            <input type="hidden" name="contact_id"
                                   value="<?php echo htmlspecialchars($message['contact_id']); ?>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            <?php endforeach; ?>
        </table>
        <p class="last_paragraph">
            <a href="index.php?action=list_anime">View Anime List</a>
        </p>
    </section>
</main>
<?php include '../footer.php'; ?>