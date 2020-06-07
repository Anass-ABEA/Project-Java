-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2020 at 08:53 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE IF NOT EXISTS `avion` (
  `ida` int(11) NOT NULL AUTO_INCREMENT,
  `companie` text NOT NULL,
  `nb_place` int(11) NOT NULL,
  PRIMARY KEY (`ida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `billet`
--

CREATE TABLE IF NOT EXISTS `billet` (
  `idb` int(11) NOT NULL AUTO_INCREMENT,
  `dateReservation` datetime NOT NULL,
  `dateVoyage` datetime NOT NULL,
  `dateArrivee` datetime NOT NULL,
  `etat` text NOT NULL,
  PRIMARY KEY (`idb`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `siege`
--

CREATE TABLE IF NOT EXISTS `siege` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` text NOT NULL,
  `pass` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vol`
--

CREATE TABLE IF NOT EXISTS `vol` (
  `idv` int(11) NOT NULL AUTO_INCREMENT,
  `ida` int(11) NOT NULL,
  `heureDepart` datetime NOT NULL,
  `heureARRIVEE` datetime NOT NULL,
  `duree` text NOT NULL,
  `aeroportDepart` text NOT NULL,
  `aeroportarrivee` text NOT NULL,
  PRIMARY KEY (`idv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `voyageur`
--

CREATE TABLE IF NOT EXISTS `voyageur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `adresse` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
