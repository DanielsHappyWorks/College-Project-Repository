<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>LogIn</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="../logo.png">
        <link href="./index.css" rel="stylesheet" type="text/css"/>
    </head>


    <body>
        <div class="container">
            <div class="top">
                <header>
                    <!--logo-->
                    <div class="logo">
                        <img src="./images/logo.png" class="logo_img" alt="logo">
                    </div>

                    <!--banner-->
                    <div class="banner">
                        <img src="./images/banners/home_banner.png" alt="home banner" id="home_banner">
                    </div>
                </header>
            </div>
            <div class="middle">
                <main class="main">
                    <div class="heading">
                        <h1>Log In</h1>
                    </div>
                    <div class="main_text">
                        <?php
                        $dbHost = "localhost";
                        $dbUsername = "root";
                        $dbPassword = "";
                        $dbName = "mathsdata";

                        $db_handle = mysql_connect($dbHost, $dbUsername, $dbPassword);
                        $db_found = mysql_select_db($dbName, $db_handle);

                        $username = $_POST["username"];

                        if ($db_found) {

                            $sql = "SELECT * FROM registery where username = '$username'";
                            $result = mysql_query($sql);
                        }
                        ?>

                        </head>

                        <body>

                            <div id="container">
                                <div id="header1">
                                    <p>Header</p>
                                </div>

                                <div id="header2">
                                    <?php
                                    while ($db_field = mysql_fetch_assoc($result)) {
                                        if ($_POST["password"] == $db_field['password']) {
                                            echo "Welcome! " . $db_field['username'];
                                            ?> 
                                        </div>


                                        <div id="content">
                                            <?php
                                            echo "<table border='1'>
                                 <tr>
                                 <th>ID</th>
                                 <th>Name</th>
                                 <th>Username</th>
                                 <th>Password</th>
                                 <th>Email</th>
                                 </tr>";

                                            echo "<tr>";
                                            echo "<td>" . $db_field['id'] . "</td>";
                                            echo "<td>" . $db_field['name'] . "</td>";
                                            echo "<td>" . $db_field['username'] . "</td>";
                                            echo "<td>" . $db_field['password'] . "</td>";
                                            echo "<td>" . $db_field['email'] . "</td>";
                                            echo "</tr>";
                                            echo "</table>";
                                            header("Location: ./home/home.html");
                                            die();
                                        } else {
                                           
                                            $message = "Invalaid input";
                                             echo "<script type='text/javascript'>alert('$message');</script>";
                                            header('Location: index.html' );
                                        }
                                    }
                                    ?>
                                </div>



                                </main>
                            </div>

                            <div class="footer">
                                <!--footer at the bottom-->
                                <footer>
                                    <div class="facebook">
                                        <iframe src="//www.facebook.com/plugins/like.php?href=https%3A%2F%2Fwww.facebook.com%2FDkiller2204&amp;width&amp;layout=button&amp;action=like&amp;show_faces=true&amp;share=true&amp;height=80" scrolling="no" frameborder="0" style="border:none; overflow:hidden; height:80px;" allowTransparency="true"></iframe>
                                    </div>

                                    <div class="copyright"><p>GO TEAM ACTIMEL</p></div>
                                </footer>
                            </div>
                    </div>
                    </body>
                    </html>