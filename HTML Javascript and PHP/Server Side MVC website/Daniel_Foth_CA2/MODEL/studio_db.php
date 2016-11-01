<?php

function get_studio() {
    global $db;
    $query = 'SELECT * FROM studio
              ORDER BY studio_name ASC';
    $statement = $db->prepare($query);
    $statement->execute();
    return $statement;
}

function get_studio_name($studio_id) {
    global $db;
    $query = 'SELECT * FROM studio
              WHERE studio_id = :studio_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->execute();
    $category = $statement->fetch();
    $statement->closeCursor();
    $studio_name = $category['studio_name'];
    return $studio_name;
}
function get_studio_by_id($studio_id) {
    global $db;
    $query = 'SELECT * FROM studio
              WHERE studio_id = :studio_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->execute();
    $studio = $statement->fetch();
    $statement->closeCursor();
    return $studio;
}
function add_studio($studio_id, $studio_name,$founding_date,$website) {
    global $db;
    $query = 'INSERT INTO studio
                 (studio_id, studio_name,founding_date,website)
              VALUES
                 (:studio_id,:studio_name,:founding_date,:website)';
    $statement = $db->prepare($query);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->bindValue(':studio_name', $studio_name);
    $statement->bindValue(':founding_date', $founding_date);
    $statement->bindValue(':website', $website);
    $statement->execute();
    $statement->closeCursor();
}
function delete_studio($studio_id) {
    global $db;
    $query = 'DELETE FROM studio
              WHERE studio_id = :studio_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->execute();
    $statement->closeCursor();
}
function update_studio($studio_id, $studio_name,$founding_date,$website) {
    global $db;
    $query = 'UPDATE studio SET studio_name=:studio_name, founding_date=:founding_date, website=:website WHERE studio_id=:studio_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->bindValue(':studio_name', $studio_name);
    $statement->bindValue(':founding_date', $founding_date);
    $statement->bindValue(':website', $website);
    $statement->execute();
    $statement->closeCursor();
}
?>