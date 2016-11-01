<!DOCTYPE html>
<html>
    <head>
        <title>register</title>
        <meta http-equiv = "refresh" content="5; url=./index.html">
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
                        <h1>Register</h1>
                    </div>
                    <div class="main_text">
                        <?php
                        /* read posted data */
                        $name = mysql_real_escape_string($_POST["name"]);
                        $username = mysql_real_escape_string($_POST["username"]);
                        $password = mysql_real_escape_string($_POST["password"]);
                        $email = mysql_real_escape_string($_POST["email"]);

                        if (($name == false) ||
                                ($username == false) ||
                                ($password == false) ||
                                ($email == false)) {
                            die("bad input");
                        }

                        include 'configuration.php';
                        $dbConnection = mysqli_connect($dbHost, $dbUsername, $dbPassword, $dbName);

                        /* Check connection */
                        if (mysqli_connect_errno()) {
                            echo "Failed to connect to MySQL: " . mysqli_connect_error();
                        }

                        $query = "INSERT INTO registery (name, username, password, email) VALUES ('$name', '$username', '$password', '$email')";

                        if (($queryResult = mysqli_query($dbConnection, $query)) != false) {
                            echo "Record successfully added to database";
                            header("Location: index.php");
                            die();
                        } else {
                            echo "ERROR: Record not added";
                            header("Location: registration.html");
                            die();
                        }

                        /* free result set */
                        mysqli_free_result($queryResult);

                        /* close the database */
                        mysqli_close($dbConnection);
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