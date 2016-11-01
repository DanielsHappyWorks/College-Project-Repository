<?php

require('../../model/database.php');
require('../../model/anime_db.php');
require('../../model/studio_db.php');
require('../../model/contact_db.php');

$action = filter_input(INPUT_POST, 'action');
if ($action == NULL) {
    $action = filter_input(INPUT_GET, 'action');
    if ($action == NULL) {
        $action = 'list_anime';
    }
}

if ($action == 'list_anime') {
    $studio_id = filter_input(INPUT_GET, 'studio_id', FILTER_VALIDATE_INT);
    if ($studio_id == NULL || $studio_id == FALSE) {
        $studio_id = 1;
    }
    $studio = get_studio();
    $studio_name = get_studio_name($studio_id);
    $anime = get_anime_by_studio($studio_id);
    include('Anime_list.php');
} else if ($action == 'view_anime') {
    $anime_id = filter_input(INPUT_GET, 'anime_id', FILTER_VALIDATE_INT);
    if ($anime_id == NULL || $anime_id == FALSE) {
        $error = 'Missing or incorrect product id.';
        include('../error.php');
    } else {
        $studio = get_studio();
        $anime = get_anime($anime_id);

        // Get product data
        $code = $anime['code'];
        $name = $anime['name'];
        $price = $anime['price'];
        $image_filename = '../../images/anime/' . $code . '.jpg';
        $image_alt = 'Image: ' . $code . '.jpg';

        // Calculate discounts
        $discount_percent = 15;  // 30% off for all web orders
        $discount_amount = round($price * ($discount_percent / 100.0), 2);
        $unit_price = $price - $discount_amount;

        // Format the calculations
        $discount_amount_f = number_format($discount_amount, 2);
        $unit_price_f = number_format($unit_price, 2);

        include('Anime_view.php');
    }
} else if ($action == 'contact_us') {
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_STRING);
    $message = filter_input(INPUT_POST, 'message', FILTER_SANITIZE_STRING);

    if ($message == NULL || $message == FALSE ||
            $email == NULL || $email == FALSE ||
            $name == NULL || $name == FALSE) {
        $error = "Invalid Contact data. Check all fields and try again.";
        include('../error.php');
    } else {
        add_contact($name, $email, $message);
        include('contact_us.php');
    }
}
?>
