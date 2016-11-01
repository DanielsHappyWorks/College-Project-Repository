<?php
$ROOT = "../../";
include '../header.php';
include '../navi.php';
?>
<main>
    <h1>Contact us</h1>
    <form method="post" name="contact_us" action="index.php" id="contact_us">
        <input type="hidden" name="action" value="contact_us">
        <fieldset >
            <legend>Contact Us</legend>
        <label>Name:</label><br>
        <input type="text" name="name" required pattern="^[a-zA-Z]{1,20}[ ]{0,1}[a-zA-Z]{1,25}$" title="Format: Letters and one space only!"><br>

        <label>Email Address:</label><br>
        <input type="email" name="email" required pattern="^[a-zA-Z0-9]{2,15}[@]{1}[a-zA-Z0-9]{2,15}[.]{1}[a-zA-Z0-9]{1,5}$" title="Format: example1@hotmail.com only!"><br>

        <label>Message:</label><br>
        <textarea name="message" rows="10" cols="30" id="inputCon" required></textarea><br>
        
        <input type="reset" value="Reset Fields">
        <input type="submit" value="Contact Us">
        </fieldset>
    </form>  
</main>
<?php include '../footer.php'; ?>