<?php
function add_contact($name, $email, $message) {
    global $db;
    $query = 'INSERT INTO contacts
                 (contact_name,contact_email,contact_message)
              VALUES
                 (:name,:email,:message)';
    $statement = $db->prepare($query);
    $statement->bindValue(':name', $name);
    $statement->bindValue(':email', $email);
    $statement->bindValue(':message', $message);
    $statement->execute();
    $statement->closeCursor();
}
function get_contacts() {
    global $db;
    $query = 'SELECT * FROM contacts';
    $statement = $db->prepare($query);
    $statement->execute();
    $messages = $statement->fetchAll();
    $statement->closeCursor();
    return $messages;
}
function delete_contact($contact_id) {
    global $db;
    $query = 'DELETE FROM contacts
              WHERE contact_id = :contact_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':contact_id', $contact_id);
    $statement->execute();
    $statement->closeCursor();
}
?>

