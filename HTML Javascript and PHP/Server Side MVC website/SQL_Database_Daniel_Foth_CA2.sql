-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2015 at 11:14 PM
-- Server version: 5.6.26
-- PHP Version: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anime_heaven`
--

-- --------------------------------------------------------

--
-- Table structure for table `anime`
--

CREATE TABLE IF NOT EXISTS `anime` (
  `anime_id` int(11) NOT NULL,
  `studio_id` int(11) NOT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anime`
--

INSERT INTO `anime` (`anime_id`, `studio_id`, `code`, `name`, `price`) VALUES
(22, 2, 'Fairy_Tail', 'Fairy Tail', '69.99'),
(23, 2, 'Fractale', 'Fractale', '56.99'),
(24, 2, 'Blue Exorc', 'Blue Exorcist', '79.99'),
(25, 2, 'Servant_Se', 'Servant x Service', '39.99'),
(26, 2, 'Magi_KM', 'Magi: The Kingdom of Magic', '49.99'),
(27, 2, 'Aldnoah_Ze', 'Aldnoah.Zero', '39.99'),
(69, 1, 'Death_Parade', 'Death Parade', '49.99'),
(31, 1, 'Summer_Wars', 'Summer Wars', '29.99'),
(32, 1, 'Chaos;Head', 'Chaos;Head', '39.99'),
(33, 1, 'Casshern_Sins', 'Casshern Sins', '29.99'),
(34, 1, 'DMC', 'Devil May Cry', '29.99'),
(35, 4, 'K_On', 'K-On!', '39.99'),
(36, 4, 'Clannad', 'Clannad', '49.99'),
(37, 4, 'Amagi_Brilliant_Park', 'Amagi Brilliant Park', '69.99'),
(38, 4, 'Tamako_Market', 'Tamako Market', '39.99'),
(39, 4, 'Free', 'Free!', '79.99'),
(40, 4, 'Nichijou', 'Nichijou', '99.99'),
(41, 3, 'Mekakucity_Actors', 'Mekakucity Actors', '49.99'),
(42, 3, 'Nisekoi', 'Nisekoi', '59.99'),
(43, 3, 'Madoka_Magica', 'Puella Magi Madoka Magica', '69.99'),
(67, 2, 'YourLieInApril', 'Your Lie in April', '49.99');

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `contact_id` int(11) NOT NULL,
  `contact_name` varchar(50) NOT NULL,
  `contact_email` varchar(50) NOT NULL,
  `contact_message` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`contact_id`, `contact_name`, `contact_email`, `contact_message`) VALUES
(11, 'Daniel Foth', 'sorax2204@gmail.com', 'Good Job!');

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE IF NOT EXISTS `studio` (
  `studio_id` int(11) NOT NULL,
  `studio_name` varchar(30) NOT NULL,
  `founding_date` date NOT NULL,
  `website` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`studio_id`, `studio_name`, `founding_date`, `website`) VALUES
(1, 'Mad House', '1972-10-17', 'http://www.madhouse.co.jp/'),
(2, 'A1 Pictures', '2005-05-09', 'http://a1p.jp/'),
(3, 'Shaft', '1975-01-09', 'http://www.shaft-web.co.jp/'),
(4, 'Kyoto Animation', '1981-01-01', 'http://www.kyotoanimation.co.jp/'),
(6, 'lel', '2015-12-21', 'http://www.lol.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anime`
--
ALTER TABLE `anime`
  ADD PRIMARY KEY (`anime_id`),
  ADD UNIQUE KEY `anime_id` (`anime_id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `studio_id` (`studio_id`),
  ADD KEY `studio_id_2` (`studio_id`),
  ADD KEY `studio_id_3` (`studio_id`);

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`studio_id`),
  ADD UNIQUE KEY `studio_name` (`studio_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anime`
--
ALTER TABLE `anime`
  MODIFY `anime_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=73;
--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `studio`
--
ALTER TABLE `studio`
  MODIFY `studio_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
