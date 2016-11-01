-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2015 at 12:38 AM
-- Server version: 5.6.26
-- PHP Version: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `animeorganiser`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CountCompletedStatusByUsers`()
BEGIN
   SELECT  User_name, count(completion_status='Competed') as Completed
   FROM user_watched_anime, users
   WHERE user_watched_anime.User_id = users.User_id
   Group By User_name;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllAnime`()
BEGIN
   SELECT *  FROM anime;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllAnimeByRating`(IN rating int(11))
BEGIN
   SELECT Anime_name,user_rating
   FROM anime, user_watched_anime
   WHERE anime.Anime_id = user_watched_anime.Anime_id
   AND User_rating = rating;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllStudios`()
BEGIN
   SELECT *  FROM studio;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllUsers`()
BEGIN
   SELECT *  FROM users;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllVoiceActors`()
BEGIN
   SELECT *  FROM voice_actors;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserComments`(IN userName VARCHAR(30))
BEGIN
   SELECT Anime_name,Anime_comments,User_name
   FROM user_watched_anime,anime,users 
   WHERE user_watched_anime.User_id = users.User_id
   AND user_watched_anime.Anime_id = anime.Anime_id
   AND users.User_name = userName;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserCompletionStatus`(IN userName VARCHAR(30))
BEGIN
   SELECT completion_status,Anime_name
   FROM user_watched_anime,anime,users 
   WHERE user_watched_anime.User_id = users.User_id
   AND user_watched_anime.Anime_id = anime.Anime_id
   AND users.User_name = userName;
   END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SearchForAnimeByGenre`(IN genreName VARCHAR(50))
BEGIN
SELECT Genre,Anime_name,Episode_count
FROM anime
WHERE anime.Genre = genreName ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SearchForAnimeByName`(IN animeName VARCHAR(50))
BEGIN
SELECT Anime_name,Anime_description,Episode_count,Genre,Studio_name
FROM anime, studio
WHERE anime.Studio_id = studio.Studio_id
AND anime.Anime_name = animeName ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SearchForAnimeByStudio`(IN studioName VARCHAR(50))
BEGIN
SELECT Anime_name,Anime_description,Episode_count,Genre,Studio_name
FROM anime, studio
WHERE anime.Studio_id = studio.Studio_id
AND studio.Studio_name = studioName ;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `action_genre`
--
CREATE TABLE IF NOT EXISTS `action_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `allanimewithcomments`
--
CREATE TABLE IF NOT EXISTS `allanimewithcomments` (
`Anime_name` varchar(124)
,`Anime_comments` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `allanimewithratings`
--
CREATE TABLE IF NOT EXISTS `allanimewithratings` (
`Anime_name` varchar(124)
,`avg(user_watched_anime.User_rating)` decimal(14,4)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `allanimewithstudio`
--
CREATE TABLE IF NOT EXISTS `allanimewithstudio` (
`Anime_name` varchar(124)
,`Studio_name` varchar(52)
);

-- --------------------------------------------------------

--
-- Table structure for table `anime`
--

CREATE TABLE IF NOT EXISTS `anime` (
  `Anime_id` int(11) NOT NULL,
  `Studio_id` int(11) NOT NULL,
  `Anime_name` varchar(124) NOT NULL,
  `Anime_Description` varchar(1100) NOT NULL,
  `Episode_count` int(11) NOT NULL,
  `Genre` varchar(32) NOT NULL,
  `Anime_release_date` date NOT NULL,
  `Anime_completion_date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anime`
--

INSERT INTO `anime` (`Anime_id`, `Studio_id`, `Anime_name`, `Anime_Description`, `Episode_count`, `Genre`, `Anime_release_date`, `Anime_completion_date`) VALUES
(1, 1, 'Spirited Away', 'On the way to their new home, 10-year-old Chihiro Ogino''s family stumbles upon a deserted theme park. Intrigued, the family investigates the park, though unbeknownst to them, it is secretly inhabited by spirits who sleep by day and appear at night. When Chihiro''s mother and father eat food from a restaurant in the street, angry spirits turn them into pigs. Furthermore, a wide sea has appeared between the spirit world and the human one, trapping Chihiro, the sole human, in a land of spirits. Luckily for her though, a mysterious boy named Haku appears, claiming to know her from the past. Under his instructions, Chihiro secures a job in the bathhouse where Haku works. With only her courage and some new found friends to aid her, Chihiro embarks on a journey to turn her parents back to their original forms and return home.', 1, 'Fantasy', '2001-07-20', '2001-07-20'),
(2, 2, 'Death Parade', 'After death, humans are either sent to the void or reincarnated. But for some, at the instant of their death, they arrive at Quindecim, a bar attended by the mysterious white-haired Decim. Since guests do not initially remember their deaths, Decim tricks them into playing games with their "lives" on the line, with the secret intention of drawing out their true character to judge them. His job is the same, day by day and guest by guest—until a mysterious black-haired woman shows up and begins to change his world.', 12, 'Psychological', '2015-01-10', '2015-03-28'),
(3, 3, 'Sword Art Online', 'In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of "NerveGear" technology, players can control their avatars within the game using nothing but their own thoughts.\r\n\r\nKazuto Kirigaya, nicknamed "Kirito," is among the lucky few enthusiasts who get their hands on the first shipment of the game. He logs in to find himself, with ten-thousand others, in the scenic and elaborate world of Aincrad, one full of fantastic medieval weapons and gruesome monsters. However, in a cruel turn of events, the players soon realize they cannot log out; the game’s creator has trapped them in his new world until they complete all one hundred levels of the game.\r\n\r\nIn order to escape Aincrad, Kirito will now have to interact and cooperate with his fellow players. Some are allies, while others are foes, like Asuna Yuuki, who commands the leading group attempting to escape from the ruthless game. IF YOU DIE IN THE GAME YOU DIE FOR REAL.', 25, 'Action', '2012-07-08', '2012-12-23'),
(4, 4, 'Zero no tsukaima', 'Louise is a magician at the Tristein Academy, dubbed with the nickname "Zero Louise" due to her inability to effectively use her magic properly, resulting in zero successes. An upcoming test at her academy requires her to summon a familiar, a servant and partner to support her as a magician. Despite desiring a familiar that would be superior to her constantly mocking classmates, Louise ends up summoning Hiraga Saito, your average Japanese boy. Even with Louise and Saito both unwilling to accept each other, they have no choice. Louise cannot attempt another summoning and Saito cannot return to Japan, and so their life together begins. Based on the novel by Noboru Yamaguchi.', 13, 'Romance', '2006-07-03', '2006-09-25'),
(5, 7, 'Angel Beats', 'Otonashi awakens only to learn he is dead. A rifle-toting girl named Yuri explains that they are in the afterlife, and Otonashi realizes the only thing he can remember about himself is his name. Yuri tells him that she leads the Shinda Sekai Sensen (Afterlife Battlefront) and wages war against a girl named Tenshi. Unable to believe Yuri''s claims that Tenshi is evil, Otonashi attempts to speak with her, but the encounter doesn''t go as he intended.\r\n\r\nOtonashi decides to join the SSS and battle Tenshi, but he finds himself oddly drawn to her. While trying to regain his memories and understand Tenshi, he gradually unravels the mysteries of the afterlife.', 13, 'Drama', '2010-04-03', '2010-06-26'),
(6, 8, 'Attack on Titan', 'Centuries ago, mankind was slaughtered to near extinction by monstrous humanoid creatures called Titans, forcing humans to hide in fear behind enormous concentric walls. What makes these giants truly terrifying is that their taste for human flesh is not born out of hunger but what appears to be out of pleasure. To ensure their survival, the remnants of humanity began living within defensive barriers, resulting in one hundred years without a single Titan encounter. However, this fragile calm is soon shattered when a colossal Titan manages to breach the supposedly impregnable outer wall, reigniting the fight for survival against the man-eating abominations.', 25, 'Action', '2013-04-27', '2013-09-29'),
(7, 6, 'Lucky Star', 'Having fun in school, doing homework together, cooking and eating, playing videogames, watching anime. All those little things make up the daily life of the anime—and chocolate-loving—Izumi Konata and her friends. Sometimes relaxing but more than often simply funny!', 24, 'Comedy', '2007-04-08', '2007-09-17'),
(8, 2, 'Kamisama no Inai Nichiyoubi  ', 'God abandoned the world on Sunday. As a result, nobody in the world can die or reproduce. A little girl, Ai, is the gravekeeper for a village. She has prepared 47 graves for the eventual deaths of every member of the village. Later, a man who identifies himself as "Hampnie Hambart, the ''Man-eating Toy''," which is coincidentally the name that Ai''s mother left behind as the name of her father, arrives in the village and slaughters everybody. Just what is going on?\r\n', 12, 'Fantasy', '2013-07-07', '2013-09-22'),
(9, 5, 'Nisekoi', 'Raku Ichijou is an average high school student. He also happens to be the sole heir to the head of a Yakuza Family called the Shuei-gumi. Ten years ago, Raku made a promise... a secret promise with a girl he met. They promised one another that they will "get married when they reunite." Since then, Raku never let go of the pendant the girl gave him.\r\n\r\nThen one day, a beautiful girl named Chitoge Kirisaki transfers into Raku''s class. Their chemistry was more than off. There was not a moment where they were not fighting. But by a weird turn of events, Raku and Chitoge agree to become fake lovers. Although his heart is really interested in his classmate Kosaki Onodera, Raku must continue pretending to be Chitoge''s boyfriend.', 20, 'Romance', '2014-01-11', '2014-03-24'),
(10, 2, 'No Game No Life', 'No Game No Life is a surreal comedy that follows Sora and Shiro, shut-in NEET siblings and the online gamer duo behind the legendary username "Kuuhaku." They view the real world as just another lousy game; however, a strange e-mail challenging them to a chess match changes everything—the brother and sister are plunged into an otherworldly realm where they meet Tet, the God of Games.\r\n\r\nThe mysterious god welcomes Sora and Shiro to Disboard, a world where all forms of conflict—from petty squabbles to the fate of whole countries—are settled not through war, but by way of high-stake games. This system works thanks to a fundamental rule wherein each party must wager something they deem to be of equal value to the other party''s wager. In this strange land where the very idea of humanity is reduced to child’s play, the indifferent genius gamer duo of Sora and Shiro have finally found a real reason to keep playing games: to unite the sixteen races of Disboard, defeat Tet, and become the gods of this new, gaming-is-everything world.\r\n', 12, 'Game', '2014-04-09', '2014-06-25'),
(11, 8, ' psycho pass\r\n', 'The series takes place in the near future, when it is possible to instantaneously measure and quantify a person''s state of mind and personality. This information is recorded and processed, and the term "Psycho-Pass" refers to a standard used to measure an individual''s being. The story centers around the "enforcement officer" Shinya Kougami, who is tasked with managing crime in such a world.\r\n\r\nIn the future, it is possible to quantitatively measure a person''s emotions, desires, and every inclination. In this way, it is also possible to measure a person''s criminal tendency factor, which is used to judge criminals.\r\n\r\nThis is the story of a team of policemen dedicated to maintaining public order. Some of them work in the Enforcement Division, responsible for the apprehension of criminals, while others belong to the Supervisory Division which oversees their colleagues in Enforcement.\r\n', 22, 'Psychological', '2012-10-12', '2013-03-22'),
(12, 5, 'Mekakucity Actors', 'The incidents which occurred on August 14th and 15th bring a group of young boys and girls together... They are members of a group they call themselves the "Mekakushi Dan" (Blindfold Organization) and each member possesses a strange power involving their eyes. Will the members of this peculiar organization be able to solve the mysteries behind these incidents and see the truth?\r\n', 12, 'Supernatural', '2014-04-13', '2014-06-24'),
(13, 4, 'Yumekui Merry', 'Sometimes daydreaming can get you into trouble, but what do you do when it''s other people''s dreams that you have to watch out for? Yumeji Fujiwara has the unique ability to predict what kind of dreams other people will have, but lately, his own dreams have taken a bizarre turn in which he''s being pursued by armies of cats. Stranger yet, Yumeji learns that the leader of the dream cats needs his body to access the Real World. \r\n\r\nFinally, the strange becomes downright weird when a beautiful girl suddenly drops on top of him and announces that she''s a Dream Demon looking for a way back to the Dream World! The fabric that separates reality and fantasy is torn to shreds, and Yumeji has a lot of sleepless nights ahead of him as he has to deal with both the dream stalking and a dream walking! ', 13, 'Supernatural', '2011-01-07', '2011-04-08'),
(14, 6, 'Kyokai No Kanata', 'The dark fantasy follows a high school sophomore named Akihito Kanbara. Although the boy appears human, he is half youmu and invulnerable to wounds because he can heal quickly. One day, Akihito meets freshman Mirai Kuriyama when it seems she is about to jump from the school rooftop. Mirai is isolated because of her ability to manipulate blood, which is unique even among members of the spirit world. Disturbing events begin to unfold after Akihito saves Mirai.', 12, 'Slice of life', '2013-10-03', '2013-12-19'),
(15, 8, 'Ghost in the Shell (2015)', 'In the year 2027, a year following the end of the non-nuclear World War IV, a bomb has gone off in Newport City, killing a major arms dealer who may have ties with the mysterious 501 Organization. Public Security official Daisuke Aramaki hires full-body cyber prosthesis user and hacker extraordinaire, Motoko Kusanagi, to investigate.', 1, 'Mecha', '2015-06-20', '2015-06-20'),
(16, 5, 'Dance in the Vampire Bund', 'After millennia in hiding, Mina Tepes, the Princess of the ancient covenant and ruler of all vampires, wants change. Using the vast wealth of the Tepes line, she has paid off the entire gross national debt of Japan and in so doing, gained the authority to create a "special district" off the coast of Japan that is to become the future haven to vampires the world over!\r\n\r\nNow, on the eve of the landmark press conference announcing the existence of vampires to the world, terrorists and rival factions are plotting to assassinate Mina Tepes before she has a chance to make her world-changing announcement.\r\n', 12, 'Vampire', '2010-01-07', '2010-04-01'),
(17, 6, 'Amagi Brilliant Park ', 'Kanie Seiya, a smart and extremely narcissistic high school student, believes that the beautiful but reserved Sento Isuzu has invited him on a date at an amusement park called Amagi Brilliant Park. Much to his chagrin, not only is the location a run-down facility, the supposed date is merely a recruitment tour where Sento and Princess Latifa Fleuranza, the owner of the theme park, ask him to become the park''s new manager. Their cause for desperation? As stipulated in a land-use contract, Amagi has less than three months to meet a quota of 500,000 guests, or the park will be closed for good and the land redeveloped by a greedy real-estate company.\r\n\r\nSeiya is won over by the revelation that Amagi is no ordinary amusement park; many of its employees are Maple Landers—mysterious magical beings who live in the human world and are nourished by the energy created by people having fun. Entrusted with the hopes and dreams of this far-off enchanted land, Seiya must now use his many skills to bring Amagi back on its feet, or watch it crumble before his eyes.\r\n', 12, 'Comedy', '2014-08-07', '2014-12-26'),
(18, 1, 'My Neighbour Totoro', 'Follow the adventures of Satsuki and her four-year-old sister Mei when they move into a new home in the countryside. To their delight they discover that their new neighbor is a mysterious forest spirit named Totoro who can be seen only through the eyes of a child. Totoro introduces them to extraordinary characters, including a cat that doubles as a bus, and takes them on a journey through the wonders of nature.\r\n', 1, 'Fantasy', '1988-04-16', '1988-04-16');

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE IF NOT EXISTS `characters` (
  `Anime_id` int(11) NOT NULL,
  `Actor_id` int(11) NOT NULL,
  `Character_name` varchar(52) NOT NULL,
  `Character_gender` varchar(12) NOT NULL,
  `Character_description` varchar(1200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `characters`
--

INSERT INTO `characters` (`Anime_id`, `Actor_id`, `Character_name`, `Character_gender`, `Character_description`) VALUES
(1, 3, 'Chihiro Ogino', 'Female', 'Chihiro is a shy, pessimistic, 10 year old girl. At the beginning of the movie, she and her parents are in the process of moving to a new town. When her father takes the wrong turn, they end up near what her father thinks is "an abandoned amusement park." In reality, it is a bath house for spirits which operates at night time.'),
(2, 4, 'Decim', 'Male', 'Decim is the bartender of Quindecim and an acting arbiter for the dead. He always puts up a serious face and is very cool and professional. His hobby is putting dummies together and dressing them up. He has a lot of respect for people who lived fulfilled lives.'),
(2, 12, 'Kurakami no Onna', 'Female', 'She does not know her name and has no memories of her past whatsoever.\r\nShe is Decim''s assistant in the Quindecim bar. She displays her human emotions openly, voices her opinion and is slightly short-tempered.\r\n'),
(3, 5, 'Kazuto Kirigaya ', 'Male', 'Kirito is the protagonist of Sword Art Online. He is a "solo" player, a player who hasn''t joined a guild and usually works alone. He is also one of the very few people to have had the privilege to play in the beta testing period of Sword Art Online. His game alias, Kirito, is created by taking the syllables of the first and last Kanji of his real last and first names respectively: (Kirigaya Kazuto). In the real world, he lives with his aunt and younger cousin in a family of 3.'),
(3, 13, 'Asuna Yuuki', 'Female', 'Asuna is a friend of Kirito and is a sub-leader of the guild Knights of the Blood (KoB), a medium-sized guild of about thirty players, also called the strongest guild in Aincrad. Being one of the few girls that are in SAO, and even more so that she''s extremely pretty, she receives many invitations and proposals. She is a skilled player earning the title "Flash" for her extraordinary sword skill that is lightning fast. Her game alias is the same as her real world name.\r\n\r\nYui (actor : Kanae Itou  Dob : 1986-11-26)\r\nA young and cheerful girl with long black hair who looks no older than 10 years old. Kirito and Asuna found her in a forest in the 22nd floor of Aincrad. After taking care of her, she appears to have lost her memory. She calls Kirito and Asuna "Papa" and "Mama" due to having trouble pronouncing their names which is a side effect of the memory loss. They decided that they would go and search for her friends in the Starting City.\r\n'),
(3, 23, 'Midori Kirigaya', 'Female', 'Kirito and Suguha''s mother in the real world. After Kazuto got trapped she went to the hospital two months prior to lean by Kazuto''s side, eyes brimming with tears and smile bright with gladness that he was still alive. '),
(4, 14, 'Saito Hiraga', 'Male', 'Saito Hiraga, the main male character, is from Earth (specifically Tokyo, Japan). At the time of the summoning, he had just picked up his laptop after attempting to get it repaired in Akihabara. A portal of some kind opened in front of him; and Saito''s curiosity getting the better of him, he touched it and was sucked through. At first, Saito had no idea where he was, and was thoroughly disoriented. When he arrives on the other side however he is made to sit and obey like a normal household dog. When the bond of him being her familiar, involves having a kiss with the familiar, he is quite shocked at why they do it. In the anime, he also could not identify nor understand the language the students were speaking, but after Louise attempts to cast a silence spell on him that fails, he could understand and communicate with others as though they were speaking Japanese.\r\n'),
(4, 15, 'Charlotte Hélène d''Orléans', 'Female', 'The soft-spoken, book-reading best friend of Kirche Zerbst and classmate of Louise de La Vallière.\r\n\r\nThough commonly known under her alias "Tabitha," she is, in fact, a princess and the rightful heir to the throne of Gallia, which had been usurped by her uncle.\r\n\r\nShe specializes in wind magic.'),
(4, 30, 'Vittorio Serevare', 'Male', 'Vittorio Serevare is the current Pope of Romalia, and holding the title of "St. Aegis the 32nd," the "Shield of the Founder," and took the throne three years prior to Saito''s summoning.\r\n\r\nHe is kind-hearted in that he cares for orphans and trying to increase the welfare of the commoners, but has to deal with politicking with the nobles in the process. Despite his kindness, he has his ruthless streak in doing anything and everything that is necessary for Helkeginia. Even with his ruthless streak, Vittorio is not a heartless monster.'),
(5, 6, 'Kanade Tachibana', 'Female', 'Tenshi is the nickname the SSS gives her based on Yuri''s belief that she must be a representative of god. Her name means "Angel," though she has stated she isn''t one. The main plot of the anime revolves around her rivalry with Yuri, as Tenshi is believed to be the enemy of the Afterlife.\r\n\r\nShe never admits her name as "Angel." Instead, she calls herself the Student Council President of the school, who oversees the process of the afterlife'),
(5, 16, 'Otonashi Yuzuru', 'Male', 'Otonashi lost his memory in an accident and thus thinks his life has no meaning. Things start to change for him as the story progresses. He is the main male protagonist of Angel Beats!\r\n'),
(5, 17, 'Nakamura Yuri ', 'Female', 'Yuri, the leader of the Shinda Sekai Sensen or SSS, the rebellious faction against the god who destined her to have an unreasonable life. She is determined to fight against the evil of the afterlife and is one of the strongest minded. She is one of the two main protagonist of the anime. She has a very strong personality and is the main rival of Angel.\r\n'),
(5, 18, 'T.K. ', 'Male', '"TK" is a mysterious character. He likes to speak nonsensical English phrases, depending on the situation of the scene, even though he does not know English fluently. He saves the team many times and knows some Japanese but rarely speaks it. Regardless, he seems to understand what the others say to him. He is talented in almost anything (his forte, dancing). He is usually always dancing even while in a fight with his enemies. His real identity and his name is unknown, even to the SSS. Therefore they identify him as by a nickname he gives himself, "TK."\r\n\r\nOne particular trait of his is his inability to remain still, as he is in constant movement whenever he is not doing anything at all (although at times he can be seen not in constant movement).\r\n\r\nAlso, his catchphrase appears to be "I kiss you!", or "Wild heaven".'),
(5, 21, 'Shiori Sekine', 'Female', 'Sekine and Irie are best friends and both are in the same band formed by Iwasawa and Hisako. She is the bassist. She is not a gifted musician like the rest of the band members but gives her best. Despite that, Hisako always acts as her senpai and teaches her ''dos and don''ts'' in a band.'),
(5, 28, 'Miyuki Irie', 'Female', 'Irie is fond of ghost stories but has the worst of it when it comes to anything about ghosts. She is cute and enjoys everything as much as she can. She plays drums in Iwasawa and Hisako''s band. She enjoys her time the most when Sekine is around. \r\n'),
(6, 1, 'Mikasa Ackerman', 'Female', 'Mikasa is Eren''s adoptive sister and mutual childhood friend of Armin. Mikasa shares an unbreakable bond with Eren following events in their past, and rushes to protect him whenever he is in danger. Mikasa possesses impressive fighting skill and strength even as a child.\r\n\r\nAs a teen, Mikasa is considered a genius among all the army trainees and is incredibly skilled at combat and agility. She constantly worries for Eren''s well-being and lives to protect him.'),
(6, 18, 'Levi ', 'Male', 'Levi is known as humanity''s most powerful soldier. His rank is a Captain in the Scouting Legion division. Levi is also the leader of the Special Operations Squad, an elite team that he hand-picked in order to protect Eren Yeager. While it is said that he is blunt and unapproachable, it is noted that he has a strong respect for structure and discipline. There are rumors that he was originally part of underground crime before he became a soldier. Although he often appears to be unfriendly, he cares deeply for his team and has never undervalued human life. He is also a notorious clean-freak.\r\n'),
(6, 19, 'Eren Yeager', 'Male', 'Eren is Shingeki no Kyojin''s protagonist. His adoptive sister, Mikasa, notes on numerous occasions that he acts on impulse without thinking things through, and she often pulls/carries/throws him when he starts fighting with others to protect him from himself. Along with Mikasa, he tends to spend his free time with their mutual friend, Armin.\r\n\r\nHis father is a doctor (whom is well respected by Hannes and potentially many more) whilst his mother is a housewife.\r\n'),
(7, 20, 'Izumi Kinata', 'Female', 'Konata Izumi is, more by default than anything else, the "leader" of the main characters. Nicknamed "Kona-chan" by her friends, she is an eccentric but friendly and outgoing girl, with a mischeivous but good-natured sense of humor. She can be smart, but she hates studying, thus her grades are a bit uneasy. However, she is an expert in pulling an "all-nighter." In contrast to her studying habits, she loves video games, to the extent that she can compete against Kagami Hiiragi on trivia games (by remembering the question orders, not by knowing the actual answers). In addition, she loves anime, which is also due to her father, S?jir? Izumi''s influence, along with the games. He buys ero-games for himself, so she is able to play and enjoy them. In fact, when she became eighteen, Konata was overjoyed, since she could now go buy and play ero-games legally. In the anime, Konata constantly refers to or parodies several popular games, anime, and manga (much to the annoyance of Kagami), but her favorite franchise seems to be the Haruhi series.\r\n'),
(7, 21, 'Kagami Hiiragi', 'Female', 'Kagami is the older fraternal twin sister of Tsukasa. In school, her grades are excellent and she studies very hard. She was even the class president of her class in her first year. She is in a different class than Konata and Tsukasa, but she frequently comes to their class during lunch time to eat with them. Additionally, Kagami chose the humanities course in her second year so that she could be with Konata, but she was the only one separated into a different classroom; the same occurred in her third year. Kagami, seldom referred to as "Kagamin", is a bit egotistic, but is somewhat weak in cooking. \r\n'),
(7, 22, 'Tsukasa Hiiragi', 'Female', 'Tsukasa is the younger fraternal twin sister of Kagami and lives in a six-member family household with her parents. She is in the same class as Konata though isn''t good at studying or at sports, but excels in cooking.\r\n\r\nTsukasa''s physique is a little smaller than average. She has short, light-purple hair, and wears a ribbon like a head band in it, and her droopy eyes are light violet. She is portrayed as a stereotypical klutz and as a "healing-type" character. She spends a lot of time sleeping.\r\n'),
(7, 23, 'Miyuki Takara ', 'Female', 'Miyuki is a "young lady" from a wealthy family who is also beautiful, smart, and well-mannered. She was the president for her grade level in her first year when she became great friends with Kagami. Now Miyuki is the same class as Konata and Tsukasa. Miyuki is more relied on by her classmates in helping their studies than Nanako.\r\n\r\nMiyuki''s physique is average, but she has excellent proportions; she has large breasts that Konata analogies her to a cow. Her appearance is as follow: has long light pink hair, and her eyes, covered by the glasses she wears, are light bluish-purple. She is a stereotypical "healing-type" meganekko. Her vision is less than 0.1, though used to be good until elementary school when she started reading books in the dark after her mother dozed off in the midst of reading them to her in her bed. She likes to read books, but does not read light novels.\r\n\r\nMiyuki loves to sleep, however, she hates going to the dentist, but she frequently has to go there to fix a loose crown or because of tooth decays. On the rare occasion that she plays video games, her personality seems to change.\r\n'),
(8, 2, 'Alice Color', 'Male', 'One of Dee''s classmates in Goran Academy. He acts slightly like a delinquent and is usually calm and composed. Both he and Ai had the same objective—saving the world—though he states his plan is to do it by destroying it.\r\n\r\nDespite the slightly similar hair style and color, he is different from the man in a lion mask earlier encountered by Ai in Ortus.\r\n\r\nHe has an ability named "Buzzer Beater" which allows him to never miss on any kind of aimed shot - whether it is throwing basketballs or shooting with guns.'),
(8, 24, 'Ai Astin', 'Female', 'A 12-year-old gravekeeper. She is quite naive, but cares a lot about others. She calls Hampnie Hambart her "father" due to something her supposed mother had told her when she was younger, and decides to follow him on his journey. She can get very emotional at times which could lead to her being put in dangerous situations.'),
(8, 25, 'Hampnie Hambert', 'Male', 'A man who suddenly appeared in Ai''s village and killed all the villagers. He calls himself the "Man-eating Toy", and describes himself as a cruel person. He also claims to be immortal and unable to age.\r\n\r\nHe is searching for mysterious woman named Hana who he was close with and who left him dozen of years ago.\r\n\r\nWhen he was younger his skin was very weak and he couldn''t go in the sun a lot.\r\n'),
(9, 2, 'Raku Ichijou', 'Male', 'Son of a Yakuza family. He''s intelligent but not an adept fighter. He likes sweet things, wants to marry a Yamato Nadeshiko and says he''s the kind of person who has to do it absolutely correctly when he puts his mind into something otherwise he can''t be satisfied.'),
(9, 6, 'Kosaki Onodera', 'Female', 'She is one of the main characters in the manga series Nisekoi. She is shown to have a crush on Raku Ichijou, the male protagonist of Nisekoi, and is also the only girl that Ichijou openly has feelings for. \r\n\r\nOnodera is discreet, innocent, and slightly timid. She is very kind, she takes care of Ichijou when he is wounded or ill. Generally, she opts to think carefully before acting, as seen when she stalls her confession to Ichijou in consideration that he may have feelings for Kirisaki.'),
(9, 28, 'Marika Tachibana', 'Female', 'Marika transfers to Raku''s class and is introduced as his fiancée; she bears a key that she thinks will unlock Raku''s pendant, and is the most vocal about expressing her love to Raku. She is the daughter of the police chief, and has been in love with Raku for the past ten years. She does not get along with Chitoge; she states she hates girls with long hair despite the fact that she also has long hair. She has a frail constitution; ten years prior, she was frequently visited by a young Raku, who brought her gifts and sparked a friendship with her. She used to speak in a rather vulgar manner but has attempted to correct her language after Raku had told her that he likes girly girls with long hair. However, when flustered, she reverts to her old speaking habits.'),
(9, 32, 'Haru Onodera', 'Female', 'Kosaki''s sister who is a school year younger. On her way to school, she is saved from some delinquents by a mysterious prince (actually Raku Ichijou) and ends up with his locket. Her first impression of Raku is negative as she observes that he is a womanizer who is trying to trick her sister and he is a pervert for looking at her panties. She also refuses to return his locket until Raku convinces her that he is helping the "prince." Unlike her sister, she is a good cook. She later reveals that she was helped by a guy in a mascot costume (also Raku) who treats her to ice cream.'),
(10, 5, 'Sora', 'Male', 'Abandoned by his parents, Sora is a brilliant NEET (Not in Education, Employment, or Training) hikikomori (shut-in) gamer along with his stepsister, Shiro. He does not take life very seriously and is pretty much a good-for-nothing gamer. One day, he and his sister are called into an alternate world.\r\nSora is extroverted and has no problems dealing with people. While not as intelligent as Shiro, he is shown to have a brilliant IQ. Rather than computing numbers like Shiro, Sora can rapidly compute what his opponents are going to do based on observing their behavior and motivations. He is also slightly perverted and desires a girlfriend for himself. His lust leads to a linguistic mistake that causes Stephanie to fall in love with him and causes him to receive a scolding from Shiro.\r\n'),
(10, 9, 'Shiro', 'Female', 'Shiro is described as a genius in logic and problems, but has difficulty understanding emotions or behaviour, relying on Sora to help her defeat human opponents such as Tet in their chess match. She also rarely shows much emotion at all on her face and, despite her genius intellect, speaks in short terse sentences. Shiro is extremely close to her brother, to the point of needing him by her side at all times to be comfortable. She is also shown to have a dry and somewhat twisted sense of humour, and displays signs of jealousy if Sora pays serious attention to other girls, showing she has a brother complex. \r\n'),
(11, 6, 'Akane Tsunemori ', 'Female', 'The main female protagonist and the newly assigned Inspector of Unit 1. Considered a model citizen due to her ever calm demeanor and for passing the exams with the highest score for employment on several public sectors and private corporations. She decided to join the police due to being the only place where no one obtained a score as high as hers, thus she believes to be able to do something there that no one else can.\r\n\r\nShougo Makishima (Actor  Takahiro Sakurai  DOB- 1974-06-13)\r\nA humanist who is hopelessly in love with cruelty, savagery, and all the worst aspects of human nature, Makishima is a manipulative anarchist who is just as ruthless in his schemes as he is in physical combat. A born evangelist, he possesses both an uncommon charisma and a true gift for narrative. Makishima is fond of books, as shown in his tendency to quote from famous literature. His weapon of choice is a barber''s razor with engravings on its handle.\r\n'),
(11, 26, 'Shougo Makishima ', 'Male', 'A humanist who is hopelessly in love with cruelty, savagery, and all the worst aspects of human nature, Makishima is a manipulative anarchist who is just as ruthless in his schemes as he is in physical combat. A born evangelist, he possesses both an uncommon charisma and a true gift for narrative. Makishima is fond of books, as shown in his tendency to quote from famous literature. His weapon of choice is a barber''s razor with engravings on its handle.'),
(11, 27, 'Shinya Kougami', 'Male', 'Shinya Kougami is an enforcement officer who is tasked with managing crime. Shinya has a high criminal mentality, but because of his skills as a detective, he was released under the condition that he becomes an Enforcer for the Public Safety Bureau, Unit 1.\r\n\r\nDespite his natural grudge towards Makishima, they are actually somewhat alike, as shown in Shinya''s ability to foresee Makishima''s actions.\r\n'),
(11, 32, 'Mika Shimotsuki', 'Female', 'She is a student of Oso Girl''s Academy who seems to be aware of what''s going on around campus. She is Kagami''s friend and classmate.'),
(12, 28, 'Takane Enomoto', 'Female', 'A strange program taking the shape of a young girl which has taken up residence inside Shintaro''s computer. She calls him "Master," and yet adores bothering him.\r\n\r\nFirst appeared in Artifical Enemy. A naive cyber girl who lives in Shintaro''s computer. She can possibly invade anything that uses electricity and gives her all in doing things that Shintaro hates.\r\n'),
(12, 29, 'Shintarou Kisaragi', 'Male', 'The main protagonist of the manga and brother of Momo Kisaragi, Shintaro is a hikikomori and as such, he has a hard time dealing with people. He seems to be constantly bothered by Ene.\r\n\r\nFirst appeared in Jinzou Enemy. A hikikomori (recluse/shut-in) young man with an IQ of 168. In middle school and high school, before he was a hikikomori, he performed at the top of his class in National Mock Examinations. He is no longer in school. After dropping out, a mysterious software enters into his computer named "Ene," and, being unable to control her actions, his lifestyle is at a loss. Due to one of Ene''s pranks, his computer breaks down, so both Ene and him go to the department store for shopping where they happen upon a group of terrorists. They end up stopping them together with the Mekakushi Dan. After this, he and Ene come to join the Mekakushi Dan.'),
(12, 30, 'Shuuya Kano ', 'Male', 'First appeared in Kisaragi Attention. A young man who belongs to Mekakushi Dan. Has an unfocused, aloof personality, and always has a smile on his face. Because he teases Mary and Momo a lot, he''s often considered to be a flirt and careless, but when it counts, he''s worth relying on. He possesses the power to "deceive one''s eyes," to be able to manipulate what people around him see and show them something different.\r\n'),
(12, 31, 'Tsubomi Kido', 'Female', 'A mysterious girl who has appeared before Shintaro in a shopping center. She''s seemingly the leader of the Mekakushi Dan.\r\n\r\nFirst appeared in Blindfold Code. A girl that plays the role of the leader of the Mekakushi Dan. She''s essentially good-natured, but struggles to keep the individual members, like Kano and Seto, in line. Using her "eye concealing" ability, she can erase the perception towards objects within a certain distance of herself or her surroundings. She is most always seen listening to music through her earphones.\r\n'),
(13, 23, 'Engi Threepiece', 'Female', 'Dream demon who live together peacefully with her vessel instead of taking over. \r\nShe came to human world looking for Pharos Elcres who killed her twin sister and killed every dream demon she met. Her field is a garden which became deserted after her sister died. Strong and had very good swordsmanship.'),
(13, 30, 'Takateru Akiyanagi', 'Male', 'Another friend of Yumeji, and member of the writing club. He loves writing poems and is often seen with a pen and a piece of paper to write on it.'),
(13, 32, 'Merry Nightmare ', 'Female', 'Her design motif is a sheep. The name''s origin comes from the song that everyone knows. \r\n\r\nMerry is a girl from the Dreamworld searching for a door back home. Unlike the other dream demons coming into the human world, she doesn''t need a vessel, instead she has a physical human-like body, she is stronger and faster than a normal human even in the real world.\r\n\r\nShe can''t drink soda or eat spicy foods.\r\n'),
(13, 33, 'Yumeji Fujuwara', 'Male', 'Yumeji is the main character of Yumekui Merry. Student in high school, he received 10 years ago the ability to perceive the aura of people''s dreams, which allows him to predict what kind of dreams they are going to have.\r\n\r\nHe is a lazy, yet strong-willed and determined person with a heart of gold, who is always ready to help others. He is also a member of a writing club at his high school, and is a big fan of the superhero called Guricho. He meets Merry when she falls on top of him as he comes back from his errands, and together, they enter a daydream - basically, a dream that occurs in full daylight. He has firmly decided to help Merry to come back in the Dreamworld, even if she is not convinced at the beginning, but they soon end up becoming very good friends.\r\n'),
(14, 32, 'Hiroomi Nase', 'Male', 'Hiroomi Nase is the eldest son of the famous "spiritwolders" Nase family and Mitsuki''s elder brother. He is a third year high school student.\r\n\r\nIt appears that something happened between Hiroomi and Akihito in the past, but now they are on such good terms that they can joke around with each other.\r\n\r\nHe loves his sister a lot and tries to protect her from harm. Although the siblings may bicker with each other, they always reconcile. He has a huge sister complex.\r\n\r\nDue to his barrier powers, he is extremely sensitive to cold, and is almost always seen wearing a muffler or scarf.'),
(14, 34, 'Akihito Kanbara ', 'Male', 'Akihito is a second-year high school student who is half-human and half-youmu who heals quickly from any wound he receives. At school, he is known for his attraction over glasses, to the point of giving himself the nickname "Meganest." He is a member of the Literary Club.\r\n'),
(14, 35, 'Mirai Kuriyama', 'Female', 'Mirai is a first-year high school student with the ability to manipulate blood, an ability that is unique even in the spirit world. This ability causes her to be isolated, leading her to jump off the roof of the high school until she is saved by Akihito.\r\n\r\nClumsy and a bit aloof, Mirai rarely stands out in school. In fact, she struggles pretty much in life; she has to earn her own money to make ends meet, but her constant fear of actually encountering a youmu prevents her from earning an income from slaying youmu, which most spirit world warriors take on as part of their profession. To make things worse, her hobby of writing blog articles about bonsai is often ridiculed on the Internet.\r\n	\r\n'),
(17, 2, 'Kanie Seiya', 'Male', 'Seiya is the protagonist. He is a perfectionist high school student who has mental sharpness, intelligence, excellent reflexes, and acts like a prince. He used to be involved in the entertainment industry during his childhood and his stage name was Seiya Kodama. According to Isuzu, he was a child who would have made every adult proud; however, Seiya has told her that he died a long time ago. He receives from Latifah the magical power of listening to a person''s heart, although this power only wor'),
(17, 7, 'Sento  Isuzu', 'Female', 'Isuzu Sento is the main female protagonist of Amagi Brilliant Park series who has a stoic personality. She is very quick to point her magical muzzleloader into your face which is demonstrated in the first episode as she did with Seiya. She is usually expressionless, rarely shows emotions and so her voice is monotone. She comes across as cold and blunt occasionally. Despite that facade, she is also very sensitive. Her name originates from 50 Cent.\r\n'),
(18, 10, 'Totoro', 'Male', 'There are three totoros in the movie (O Totoro, Chu Totoro and Chibi Totoro) and even though they look different they are all considered totoros. Although O Totoro looks a cross between a raccoon and an owl, totoros are not a specific type of animal. They are fictional creatures created by Hayao Miyazaki. I have even seen some sources that say totoros are mythical Japanese critters. However, I do not see any supporting evidence of that, other than the fact the "O Totoro" is translated as "King of the Forest" (or something similar) in the English dub of the movie and that "totoro" is Mei''s mispronunciation of "tororu" (troll). (In the ending credits, you can see the girls'' mother reading the story of the Billy Goats Gruff and there''s a creature on the cover that looks like O Totoro.)\r\n'),
(18, 11, 'Satsuki Kusakabe', 'Female', 'A 10-year-old girl. Satsuki is Mei''s older sister. Satsuki is the traditional name of the fifth month of the Japanese calendar, the equivalent of the English May.\r\n\r\nAs they wait, Mei eventually falls asleep on Satsuki''s back and Totoro appears beside them, allowing Satsuki to see him for the first time. He only has a leaf on his head for protection against the rain, so Satsuki offers him the umbrella she had taken along for her father. In return he gives her a bundle of nuts and seeds.');

-- --------------------------------------------------------

--
-- Stand-in structure for view `comedy_genre`
--
CREATE TABLE IF NOT EXISTS `comedy_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `drama_genre`
--
CREATE TABLE IF NOT EXISTS `drama_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `fantasy_genre`
--
CREATE TABLE IF NOT EXISTS `fantasy_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `game_genre`
--
CREATE TABLE IF NOT EXISTS `game_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `mecha_genre`
--
CREATE TABLE IF NOT EXISTS `mecha_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `psychological_genre`
--
CREATE TABLE IF NOT EXISTS `psychological_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `romance_genre`
--
CREATE TABLE IF NOT EXISTS `romance_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `sol_genre`
--
CREATE TABLE IF NOT EXISTS `sol_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE IF NOT EXISTS `studio` (
  `Studio_id` int(11) NOT NULL,
  `Studio_name` varchar(52) NOT NULL,
  `Studio_founding_year` int(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`Studio_id`, `Studio_name`, `Studio_founding_year`) VALUES
(1, 'Studio Ghibli', 1985),
(2, 'Mad House', 1972),
(3, 'A1 Pictures', 2005),
(4, 'JC Staff', 1986),
(5, 'Shaft', 1975),
(6, 'Kyoto Animation', 1981),
(7, 'PA Works', 2000),
(8, 'Production I.G', 1987);

-- --------------------------------------------------------

--
-- Stand-in structure for view `supernatural_genre`
--
CREATE TABLE IF NOT EXISTS `supernatural_genre` (
`Anime_id` int(11)
,`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `User_id` int(11) NOT NULL,
  `User_name` varchar(32) NOT NULL,
  `User_password` varchar(32) NOT NULL,
  `User_email` varchar(42) NOT NULL,
  `Profile_description` varchar(500) NOT NULL,
  `User_dob` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_id`, `User_name`, `User_password`, `User_email`, `Profile_description`, `User_dob`) VALUES
(1, 'Daniel', 'Denny123', 'sorax2204@hotmail.com', 'Hi My name is Daniel nice too meet you!', '1997-09-08'),
(2, 'Sarah', 'jrpgs95', 'moomoo94572@gmail.com', 'Final Fantasy is the best', '1995-12-25'),
(3, 'Peter', '360NoScope', 'killersmurf93@gmail.com', 'Monkey In My Brain!', '1996-06-29'),
(4, 'Sean', 'pizza964', 'sbehan0@gmail.com', 'I LOVE BEEEZ!', '1996-12-04');

--
-- Triggers `users`
--
DELIMITER $$
CREATE TRIGGER `DELETE_USER_DATA` BEFORE DELETE ON `users`
 FOR EACH ROW DELETE FROM user_watched_anime WHERE user_watched_anime.User_id=OLD.User_id
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user_watched_anime`
--

CREATE TABLE IF NOT EXISTS `user_watched_anime` (
  `User_id` int(11) NOT NULL,
  `Anime_id` int(11) NOT NULL,
  `User_rating` int(11) NOT NULL,
  `completion_status` varchar(15) NOT NULL,
  `Anime_comments` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_watched_anime`
--

INSERT INTO `user_watched_anime` (`User_id`, `Anime_id`, `User_rating`, `completion_status`, `Anime_comments`) VALUES
(1, 1, 10, 'Completed', 'Amazing movie, As expected from Ghibli'),
(1, 3, 7, 'Completed', 'The abridged version on youtube is better xD'),
(1, 5, 10, 'Completed', 'This is a funny comedy with a great story, gimmie more'),
(1, 6, 4, 'Dropped', 'Oh god the art is so annoying'),
(1, 7, 7, 'Completed', 'Fun anime fandom jokes'),
(1, 9, 8, 'Dropped', 'Nope i just cant'),
(1, 10, 10, 'Completed', 'Great characters and plot, deserves a seciond season'),
(1, 12, 10, 'Completed', 'The songs are amazing'),
(1, 13, 10, 'Completed', 'The main protagonist is the best character ever'),
(1, 14, 4, 'Dropped', 'It was boring'),
(1, 16, 0, 'Plan To Watch', 'Looks Interesting'),
(1, 17, 10, 'Completed', '10/10 best show of the season'),
(2, 1, 9, 'Completed', 'Cool Beans'),
(2, 3, 9, 'Completed', 'I preffered log horizon better'),
(2, 4, 6, 'On Hold', 'So many explosions'),
(2, 5, 10, 'Completed', 'Aww'),
(2, 6, 10, 'Completed', 'Oh no the titans are attacking :)'),
(2, 7, 8, 'Completed', 'So fluffy and light hearted'),
(2, 8, 9, 'Completed', 'Needs a second season'),
(2, 10, 8, 'On Hold', 'Need to get back to it soon'),
(2, 11, 7, 'Watching', 'Its cool'),
(2, 13, 0, 'Plan To Watch', 'The art looks interesting'),
(2, 14, 10, 'Completed', 'I need more'),
(2, 16, 7, 'Watching', 'Cool vampires'),
(2, 17, 10, 'Watching', 'I love the park'),
(2, 18, 10, 'Completed', 'Amazing movie, As expected from Ghibli'),
(3, 1, 10, 'Completed', 'The pig scene is the best'),
(3, 2, 9, 'Completed', 'Amazing movie, As expected from Ghibli'),
(3, 3, 8, 'Completed', 'First Arc was better then the fairies'),
(3, 5, 7, 'On Hold', 'Need to get back to this one'),
(3, 6, 10, 'Completed', 'Best show of the year'),
(3, 7, 10, 'On Hold', 'Amazing movie, As expected from Ghibli'),
(3, 9, 10, 'Completed', '10/10 would watch for the plot again'),
(3, 10, 10, 'Completed', 'Amazing movie, As expected from Ghibli'),
(3, 12, 9, 'Watching', 'cool Animation'),
(3, 14, 6, 'On Hold', 'Might get back to it soon'),
(3, 15, 8, 'Completed', 'Good Movie'),
(3, 16, 9, 'Completed', 'Good show but could have been better'),
(3, 17, 0, 'Plan To Watch', 'The characters sound interesting'),
(3, 18, 9, 'Completed', 'Old but cool'),
(4, 1, 8, 'Completed', 'Not Enough beez'),
(4, 2, 4, 'Dropped', 'I got lost part way because it was too complicated'),
(4, 3, 0, 'Plan To Watch', 'Sounds interesting'),
(4, 6, 10, 'Completed', 'Gimmie more'),
(4, 7, 0, 'Plan To Watch', 'Looks Interesting'),
(4, 10, 7, 'Watching', 'The PLOT is amazing'),
(4, 13, 6, 'Dropped', 'Its good but not for me'),
(4, 16, 4, 'Dropped', 'Not interesting');

-- --------------------------------------------------------

--
-- Stand-in structure for view `vampire_genre`
--
CREATE TABLE IF NOT EXISTS `vampire_genre` (
`Anime_name` varchar(124)
,`Anime_Description` varchar(1100)
,`Episode_count` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `voice_actors`
--

CREATE TABLE IF NOT EXISTS `voice_actors` (
  `Actor_id` int(11) NOT NULL,
  `Actor_name` varchar(64) NOT NULL,
  `Actor_dob` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voice_actors`
--

INSERT INTO `voice_actors` (`Actor_id`, `Actor_name`, `Actor_dob`) VALUES
(1, 'Ishikawa Yui', '1989-05-30'),
(2, 'Uchiyama Kouki', '1990-06-16'),
(3, 'Rumi Hiiragi', '1987-08-01'),
(4, 'Tomoaki Maeno', '1982-05-26'),
(5, 'Matsuoka Yoshitsugu', '1986-09-17'),
(6, 'Hanazawa Kana', '1989-02-25'),
(7, 'Kakuma Ai', '1988-09-09'),
(8, 'Matsuoka Yoshitsugu ', '1986-09-17'),
(9, 'Kayano  Ai ', '1987-09-13'),
(10, 'Takagi Hitoshi', '1925-12-26'),
(11, 'Hidaka Noriko', '1962-05-31'),
(12, 'Seto Asami', '1993-04-02'),
(13, 'Tomatsu Haruka', '1990-02-04'),
(14, 'Satoshi hino', '1978-08-04'),
(15, 'Yuka Inokuchi', '1975-07-05'),
(16, 'Hiroshi Kamiya', '1975-01-28'),
(17, 'Harumi Sakirai', '1982-10-31'),
(18, 'Michael Rivas', '1985-02-02'),
(19, 'Yuuki Kaji', '1989-09-03'),
(20, 'Aya Hirano', '1987-10-08'),
(21, 'Emiri katou', '1983-11-26'),
(22, 'Kaori Fukahara', '1986-08-27'),
(23, 'Endou Aya', '1980-02-17'),
(24, 'Aki Toyosaki', '1986-10-28'),
(25, 'Daisuke Namikawa', '1978-03-29'),
(26, 'Takahiro Sakurai', '1974-06-13'),
(27, 'Tomokazu Seki', '1972-09-08'),
(28, 'Kana Asumi', '1986-08-12'),
(29, 'Takuma Terashima', '1983-12-20'),
(30, 'Shinnosuke Tachibana', '1972-04-26'),
(31, 'Yuuko Kaida', '1980-01-14'),
(32, 'Ayane Sakura', '1994-01-29'),
(33, 'Nobuhiko Okamoto', '1986-10-24'),
(34, 'KENN', '1982-03-24'),
(35, 'Risa Taneda', '1988-07-12');

--
-- Triggers `voice_actors`
--
DELIMITER $$
CREATE TRIGGER `DELETE_CHARACTER_DETAILS` BEFORE DELETE ON `voice_actors`
 FOR EACH ROW DELETE FROM characters WHERE characters.Actor_id=OLD.Actor_id
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure for view `action_genre`
--
DROP TABLE IF EXISTS `action_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `action_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Action') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `allanimewithcomments`
--
DROP TABLE IF EXISTS `allanimewithcomments`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allanimewithcomments` AS select `anime`.`Anime_name` AS `Anime_name`,`user_watched_anime`.`Anime_comments` AS `Anime_comments` from (`anime` join `user_watched_anime`) where (`anime`.`Anime_id` = `user_watched_anime`.`Anime_id`) order by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `allanimewithratings`
--
DROP TABLE IF EXISTS `allanimewithratings`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allanimewithratings` AS select `anime`.`Anime_name` AS `Anime_name`,avg(`user_watched_anime`.`User_rating`) AS `avg(user_watched_anime.User_rating)` from (`anime` join `user_watched_anime`) where (`anime`.`Anime_id` = `user_watched_anime`.`Anime_id`) group by `anime`.`Anime_name` order by avg(`user_watched_anime`.`User_rating`) desc;

-- --------------------------------------------------------

--
-- Structure for view `allanimewithstudio`
--
DROP TABLE IF EXISTS `allanimewithstudio`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allanimewithstudio` AS select `anime`.`Anime_name` AS `Anime_name`,`studio`.`Studio_name` AS `Studio_name` from (`anime` join `studio`) where (`anime`.`Studio_id` = `studio`.`Studio_id`) order by `studio`.`Studio_id`;

-- --------------------------------------------------------

--
-- Structure for view `comedy_genre`
--
DROP TABLE IF EXISTS `comedy_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `comedy_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Comedy') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `drama_genre`
--
DROP TABLE IF EXISTS `drama_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `drama_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Drama') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `fantasy_genre`
--
DROP TABLE IF EXISTS `fantasy_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fantasy_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Fantasy') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `game_genre`
--
DROP TABLE IF EXISTS `game_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `game_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Game') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `mecha_genre`
--
DROP TABLE IF EXISTS `mecha_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mecha_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Mecha') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `psychological_genre`
--
DROP TABLE IF EXISTS `psychological_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `psychological_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Psychological') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `romance_genre`
--
DROP TABLE IF EXISTS `romance_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `romance_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Romance') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `sol_genre`
--
DROP TABLE IF EXISTS `sol_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sol_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Slice Of Life') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `supernatural_genre`
--
DROP TABLE IF EXISTS `supernatural_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `supernatural_genre` AS select `anime`.`Anime_id` AS `Anime_id`,`anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Supernatural') group by `anime`.`Anime_name`;

-- --------------------------------------------------------

--
-- Structure for view `vampire_genre`
--
DROP TABLE IF EXISTS `vampire_genre`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vampire_genre` AS select `anime`.`Anime_name` AS `Anime_name`,`anime`.`Anime_Description` AS `Anime_Description`,`anime`.`Episode_count` AS `Episode_count` from `anime` where (`anime`.`Genre` = 'Vampire') group by `anime`.`Anime_name`;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anime`
--
ALTER TABLE `anime`
  ADD PRIMARY KEY (`Anime_id`),
  ADD UNIQUE KEY `Anime_name` (`Anime_name`),
  ADD KEY `Studio_id` (`Studio_id`);

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`Anime_id`,`Actor_id`),
  ADD KEY `Actor_id` (`Actor_id`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`Studio_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User_id`),
  ADD UNIQUE KEY `User_name` (`User_name`),
  ADD UNIQUE KEY `User_email` (`User_email`);

--
-- Indexes for table `user_watched_anime`
--
ALTER TABLE `user_watched_anime`
  ADD PRIMARY KEY (`User_id`,`Anime_id`),
  ADD UNIQUE KEY `Anime_id_2` (`User_id`,`Anime_id`),
  ADD KEY `Anime_id` (`User_id`),
  ADD KEY `User_id` (`Anime_id`),
  ADD KEY `User_id_2` (`User_id`),
  ADD KEY `Anime_id_3` (`Anime_id`);

--
-- Indexes for table `voice_actors`
--
ALTER TABLE `voice_actors`
  ADD PRIMARY KEY (`Actor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anime`
--
ALTER TABLE `anime`
  MODIFY `Anime_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `studio`
--
ALTER TABLE `studio`
  MODIFY `Studio_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `voice_actors`
--
ALTER TABLE `voice_actors`
  MODIFY `Actor_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `anime`
--
ALTER TABLE `anime`
  ADD CONSTRAINT `anime_ibfk_1` FOREIGN KEY (`Studio_id`) REFERENCES `studio` (`Studio_id`);

--
-- Constraints for table `characters`
--
ALTER TABLE `characters`
  ADD CONSTRAINT `character_ibfk_1` FOREIGN KEY (`Anime_id`) REFERENCES `anime` (`Anime_id`),
  ADD CONSTRAINT `character_ibfk_2` FOREIGN KEY (`Actor_id`) REFERENCES `voice_actors` (`Actor_id`);

--
-- Constraints for table `user_watched_anime`
--
ALTER TABLE `user_watched_anime`
  ADD CONSTRAINT `user_watched_anime_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `users` (`User_id`),
  ADD CONSTRAINT `user_watched_anime_ibfk_2` FOREIGN KEY (`Anime_id`) REFERENCES `anime` (`Anime_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
