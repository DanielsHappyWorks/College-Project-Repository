<?php

function get_anime_by_studio($studio_id) {
    global $db;
    $query = 'SELECT * FROM anime
              WHERE anime.studio_id = :studio_id
              ORDER BY anime_id';
    $statement = $db->prepare($query);
    $statement->bindValue(":studio_id", $studio_id);
    $statement->execute();
    $anime = $statement->fetchAll();
    $statement->closeCursor();
    return $anime;
}

function get_anime($anime_id) {
    global $db;
    $query = 'SELECT * FROM anime
              WHERE anime_id = :anime_id';
    $statement = $db->prepare($query);
    $statement->bindValue(":anime_id", $anime_id);
    $statement->execute();
    $anime = $statement->fetch();
    $statement->closeCursor();
    return $anime;
}

function delete_anime($anime_id) {
    global $db;
    $query = 'DELETE FROM anime
              WHERE anime_id = :anime_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':anime_id', $anime_id);
    $statement->execute();
    $statement->closeCursor();
}

function add_anime($studio_id, $code, $name, $price) {
    global $db;
    $query = 'INSERT INTO anime
                 (studio_id, code, name, price)
              VALUES
                 (:studio_id, :code, :name, :price)';
    $statement = $db->prepare($query);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->bindValue(':code', $code);
    $statement->bindValue(':name', $name);
    $statement->bindValue(':price', $price);
    $statement->execute();
    $statement->closeCursor();
}

function update_anime($anime_id, $studio_id, $code, $name, $price) {
    global $db;
    $query = 'UPDATE anime SET studio_id=:studio_id, code=:code, name=:name, price=:price WHERE anime_id=:anime_id';
    $statement = $db->prepare($query);
    $statement->bindValue(':anime_id', $anime_id);
    $statement->bindValue(':studio_id', $studio_id);
    $statement->bindValue(':code', $code);
    $statement->bindValue(':name', $name);
    $statement->bindValue(':price', $price);
    $statement->execute();
    $statement->closeCursor();
}
function get_anime_by_code($code) {
    global $db;
    $query = 'SELECT anime_id FROM anime
              WHERE code = :code';
    $statement = $db->prepare($query);
    $statement->bindValue(":code", $code);
    $statement->execute();
    $anime = $statement->fetch();
    $statement->closeCursor();
    return $anime;
}
?>