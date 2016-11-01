<?php

require('../../model/database.php');
require('../../model/anime_db.php');
require('../../model/studio_db.php');
require('../../model/contact_db.php');

$action = filter_input(INPUT_POST, 'action' , FILTER_SANITIZE_STRING);
if ($action == NULL) {
    $action = filter_input(INPUT_GET, 'action' , FILTER_SANITIZE_STRING);
    if ($action == NULL) {
        $action = 'list_anime';
    }
}

if ($action == 'list_anime') {
    $studio_id = filter_input(INPUT_GET, 'studio_id', FILTER_VALIDATE_INT);
    if ($studio_id == NULL || $studio_id == FALSE) {
        $studio_id = 2;
    }
    $studio_name = get_studio_name($studio_id);
    $studio = get_studio();
    $anime = get_anime_by_studio($studio_id);
    include('anime_list.php');
} else if ($action == 'delete_anime') {
    $anime_id = filter_input(INPUT_POST, 'anime_id', FILTER_VALIDATE_INT);
    $studio_id = filter_input(INPUT_POST, 'studio_id', FILTER_VALIDATE_INT);
    if ($studio_id == NULL || $studio_id == FALSE ||
            $anime_id == NULL || $anime_id == FALSE) {
        $error = "Missing or incorrect anime id or studio id.";
        include('../error.php');
    } else {
        delete_anime($anime_id);
        header("Location: .?studio_id=$studio_id");
    }
} else if ($action == 'delete_studio') {
    $studio_id = filter_input(INPUT_POST, 'studio_id', FILTER_VALIDATE_INT);
    if ($studio_id == NULL || $studio_id == FALSE) {
        $error = "Missing or incorrect anime id or studio id.";
        include('../error.php');
    } else {
        delete_studio($studio_id);
        header("Location: .?list_anime");
    }
} else if ($action == 'show_add_form') {
    $studio = get_studio();
    include('anime_add.php');
} else if ($action == 'show_studio_form') {
    include('studio_add.php');
} else if ($action == 'show_delete_form') {
    $studio = get_studio();
    include('studio_delete.php');
} else if ($action == 'show_messages_form') {
    $studio = get_studio();
    $messages = get_contacts();
    include('view_messages.php');
} else if ($action == 'update_anime_form') {
    $anime_id = filter_input(INPUT_POST, 'anime_id', FILTER_VALIDATE_INT);
    $anime = get_anime($anime_id);
    $studio = get_studio();
    include('anime_update.php');
} else if ($action == 'update_studio_form') {
    $studio = get_studio();
    include('studio_update.php');
}else if ($action == 'add_anime') {
    $studio_id = filter_input(INPUT_POST, 'studio_id', FILTER_VALIDATE_INT);
    $code = filter_input(INPUT_POST, 'code' , FILTER_SANITIZE_STRING);
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    $price = filter_input(INPUT_POST, 'price', FILTER_VALIDATE_FLOAT);

    if ($studio_id == NULL || $studio_id == FALSE || $code == NULL ||
            $name == NULL || $price == NULL || $price == FALSE) {
        $error = "Invalid anime data. Check all fields and try again.";
        include('../error.php');
    } else {
        add_anime($studio_id, $code, $name, $price);
        header("Location: .?studio_id=$studio_id");
    }
} else if ($action == 'update_anime') {
    $anime_id = filter_input(INPUT_POST, 'anime_id', FILTER_VALIDATE_INT);
    $studio_id = filter_input(INPUT_POST, 'studio_id', FILTER_VALIDATE_INT);
    $code = filter_input(INPUT_POST, 'code' , FILTER_SANITIZE_STRING);
    $name = filter_input(INPUT_POST, 'name' , FILTER_SANITIZE_STRING);
    $price = filter_input(INPUT_POST, 'price', FILTER_VALIDATE_FLOAT);


    if ($anime_id == NULL || $anime_id == FALSE || $studio_id == NULL ||
            $studio_id == FALSE || $code == NULL ||
            $name == NULL || $price == NULL || $price == FALSE) {
        $error = "Invalid anime data. Check all fields and try again.";
        include('../error.php');
    }else {
        update_anime($anime_id, $studio_id, $code, $name, $price);
        header("Location: .?studio_id=$studio_id");
    }
} else if ($action == 'add_studio') {
    $studio_id = filter_input(INPUT_POST, 'studio_id', FILTER_VALIDATE_INT);
    $studio_name = filter_input(INPUT_POST, 'studio_name' , FILTER_SANITIZE_STRING);
    $founding_date = filter_input(INPUT_POST, 'founding_date');
    $website = filter_input(INPUT_POST, 'website' , FILTER_SANITIZE_STRING);

    if ($studio_name == NULL || $studio_name == FALSE ||
            $founding_date == NULL || $website== NULL ||
            $website == FALSE || $founding_date== FALSE) {
        $error = "Invalid studio data. Check all fields and try again.";
        include('../error.php');
    } else {
        add_studio($studio_id, $studio_name,$founding_date,$website);
        header("Location: .?studio_id=$studio_id");
    }
}else if ($action == 'delete_message') {
    $contact_id = filter_input(INPUT_POST, 'contact_id', FILTER_VALIDATE_INT);
    if ($contact_id == NULL || $contact_id == FALSE ) {
        $error = "Missing or incorrect contact_id.";
        include('../error.php');
    } else {
        delete_contact($contact_id);
        header("Location: .?action=show_messages_form");
    }
}
else if ($action == 'update_studio') {
    $studio_id = filter_input(INPUT_POST, 'studio_id', FILTER_VALIDATE_INT);
    $studio_name = filter_input(INPUT_POST, 'studio_name' , FILTER_SANITIZE_STRING);
    $founding_date = filter_input(INPUT_POST, 'founding_date');
    $website = filter_input(INPUT_POST, 'website' , FILTER_SANITIZE_STRING);

    if ($studio_name == NULL || $studio_name == FALSE ||
            $studio_id == NULL || $studio_id == FALSE ||
            $founding_date == NULL || $website== NULL ||
            $website == FALSE || $founding_date== FALSE) {
        $error = "Invalid studio data. Check all fields and try again.";
        include('../error.php');
    } else {
        update_studio($studio_id, $studio_name,$founding_date,$website);
        header("Location: .?studio_id=$studio_id");
    }
}
else if ($action == 'list_studio') {
    $studios = get_studio();
    $studio = get_studio();
    include('studio_display.php');
}
?>
