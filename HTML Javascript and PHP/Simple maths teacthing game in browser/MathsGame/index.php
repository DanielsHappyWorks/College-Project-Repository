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
                        <form action="login.php" method="post"> 
                            <label for="username">Username: </label>
                            <input type="text" id = "username" name = "username" required><br>
                            <label for="password">Password: </label>
                            <input type="password" id = "password" name = "password" required><br> 
                            <input type="submit" value="Submit">
                            <button onclick="window.location.href='./registration.html'">Register</button>
                        </form>
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
