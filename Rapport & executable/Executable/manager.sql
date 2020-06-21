-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2020 at 05:14 PM
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
  `ida` int(15) NOT NULL,
  `companie` text NOT NULL,
  `nb_place` int(11) DEFAULT NULL,
  PRIMARY KEY (`ida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avion`
--

INSERT INTO `avion` (`ida`, `companie`, `nb_place`) VALUES
(7, 'Scandinavian Airlines', 360),
(10, 'Scandinavian Airlines', 360),
(34, 'Scandinavian Airlines', 360),
(52, 'Scandinavian Airlines', 360),
(61, 'Scandinavian Airlines', 360),
(152, 'Scandinavian Airlines', 360),
(161, 'Scandinavian Airlines', 360),
(185, 'Scandinavian Airlines', 360),
(484, 'Scandinavian Airlines', 360),
(527, 'Scandinavian Airlines', 360),
(556, 'Scandinavian Airlines', 360),
(574, 'Scandinavian Airlines', 360),
(590, 'Scandinavian Airlines', 360),
(606, 'Scandinavian Airlines', 360),
(637, 'Scandinavian Airlines', 360),
(712, 'Scandinavian Airlines', 360),
(867, 'Scandinavian Airlines', 360),
(868, 'Scandinavian Airlines', 360),
(898, 'Scandinavian Airlines', 360),
(963, 'Scandinavian Airlines', 360),
(1016, 'JetBlue Airways', 360),
(1407, 'JetBlue Airways', 360),
(1420, 'JetBlue Airways', 360),
(1422, 'JetBlue Airways', 360),
(1492, 'JetBlue Airways', 360),
(1589, 'JetBlue Airways', 360),
(1624, 'JetBlue Airways', 360),
(2064, 'JetBlue Airways', 360),
(2111, 'JetBlue Airways', 360),
(2548, 'JetBlue Airways', 360);

-- --------------------------------------------------------

--
-- Table structure for table `billet`
--

CREATE TABLE IF NOT EXISTS `billet` (
  `idb` int(11) NOT NULL AUTO_INCREMENT,
  `dateReservation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateVoyage` datetime NOT NULL,
  `dateArrivee` datetime NOT NULL,
  `etat` varchar(5) NOT NULL DEFAULT 'NV',
  PRIMARY KEY (`idb`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `billet`
--

INSERT INTO `billet` (`idb`, `dateReservation`, `dateVoyage`, `dateArrivee`, `etat`) VALUES
(1, '2020-11-01 11:13:13', '2020-11-12 13:13:13', '2020-11-12 15:13:13', 'V'),
(3, '2020-06-13 14:57:25', '2020-11-13 11:59:00', '2020-11-13 12:56:00', 'NV'),
(4, '2020-06-13 14:58:19', '2020-11-13 15:20:00', '2020-11-13 16:10:00', 'V'),
(5, '2020-06-13 15:48:52', '2020-11-13 15:20:00', '2020-11-13 16:10:00', 'NV'),
(6, '2020-06-13 15:49:08', '2020-11-13 15:20:00', '2020-11-13 16:10:00', 'V'),
(8, '2020-06-15 12:59:35', '2020-11-13 15:20:00', '2020-11-13 16:10:00', 'V'),
(9, '2020-06-15 15:32:36', '2020-11-13 10:52:00', '2020-11-13 12:28:00', 'V');

-- --------------------------------------------------------

--
-- Stand-in structure for view `booking_list`
--
CREATE TABLE IF NOT EXISTS `booking_list` (
`idv` varchar(30)
,`aeroportDepart` text
,`heureDepart` datetime
,`aeroportarrivee` text
,`heureARRIVEE` datetime
,`restantes` bigint(22)
,`nb_place` int(11)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `gestionb`
--
CREATE TABLE IF NOT EXISTS `gestionb` (
`id_user` int(11)
,`idv` varchar(30)
,`idb` int(11)
,`ids` int(11)
,`place` varchar(5)
,`type` text
,`datereservation` datetime
,`etat` varchar(5)
);
-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE IF NOT EXISTS `logs` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `text`, `date`) VALUES
(1, 'l''admin :1 a annulé la validiation du billet dont l''idb = 6', '2020-06-15 12:53:44'),
(2, 'l''admin :1 a annulé la validiation du billet dont l''idb = 3', '2020-06-15 12:53:46'),
(3, 'l''admin :1 a annulé la validiation du billet dont l''idb = 5', '2020-06-15 12:53:47'),
(4, 'l''admin :1 a validé le billet dont l''idb = 5', '2020-06-15 12:53:57'),
(5, 'l''admin :1 a annulé la validiation du billet dont l''idb = 5', '2020-06-15 12:59:57'),
(6, 'l''admin :1 a validé le billet dont l''idb = 8', '2020-06-15 13:00:01'),
(7, 'l''admin :1 a supprimé l''utilisateur :( 4,a)', '2020-06-15 14:28:03'),
(8, 'l''admin :1 a supprimé l''utilisateur :( 1,admin)', '2020-06-15 14:29:08'),
(9, 'l''admin :1 a supprimé l''utilisateur :( 4,a)', '2020-06-15 14:29:47'),
(10, 'l''admin :1 a annulé la validiation du billet dont l''idb = 8', '2020-06-15 14:30:49'),
(11, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:22:05'),
(12, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:22:32'),
(13, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:24:20'),
(14, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:24:45'),
(15, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:25:16'),
(16, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:26:07'),
(17, 'l''admin :1 a modifié les détails de l''utilisateur de celui dont l''id  = 2', '2020-06-15 15:26:11'),
(18, 'l''admin :1 a supprimé l''utilisateur :( 5,a)', '2020-06-15 15:27:21'),
(19, 'l''admin :1 a validé le billet dont l''idb = 8', '2020-06-15 15:33:41'),
(20, 'l''admin :1 a validé le billet dont l''idb = 6', '2020-06-15 15:33:44'),
(21, 'l''admin :1 a validé le billet dont l''idb = 9', '2020-06-15 15:33:47');

-- --------------------------------------------------------

--
-- Stand-in structure for view `places`
--
CREATE TABLE IF NOT EXISTS `places` (
`idv` varchar(30)
,`nb_place - count(reservation.idv)` bigint(22)
);
-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `idv` varchar(30) NOT NULL,
  `id_user` int(11) NOT NULL,
  `ids` int(11) NOT NULL,
  `idb` int(11) NOT NULL,
  KEY `id_user` (`id_user`),
  KEY `ids` (`ids`),
  KEY `idv` (`idv`),
  KEY `reservation_ibfk_3` (`idb`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`idv`, `id_user`, `ids`, `idb`) VALUES
('JBU1407-1510381558-airline-001', 1, 1, 1),
('JBU1420-1510381558-airline-037', 1, 3, 3),
('JBU1407-1510381558-airline-001', 1, 4, 4),
('JBU1407-1510381558-airline-001', 1, 5, 5),
('JBU1407-1510381558-airline-001', 1, 6, 6),
('JBU1407-1510381558-airline-001', 2, 8, 8),
('JBU1492-1510381558-airline-028', 2, 9, 9);

-- --------------------------------------------------------

--
-- Stand-in structure for view `reservationbooked`
--
CREATE TABLE IF NOT EXISTS `reservationbooked` (
`id_user` int(11)
,`idv` varchar(30)
,`heureDepart` datetime
,`aeroportDepart` text
,`aeroportarrivee` text
,`duree` text
,`place` varchar(5)
,`etat` varchar(5)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `reservationnew`
--
CREATE TABLE IF NOT EXISTS `reservationnew` (
`idv` varchar(30)
,`heureDepart` datetime
,`heureARRIVEE` datetime
,`aeroportDepart` text
,`aeroportarrivee` text
,`duree` text
,`restantes` bigint(22)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `reservationseats`
--
CREATE TABLE IF NOT EXISTS `reservationseats` (
`idv` varchar(30)
,`place` varchar(5)
);
-- --------------------------------------------------------

--
-- Table structure for table `siege`
--

CREATE TABLE IF NOT EXISTS `siege` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  `place` varchar(5) NOT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `siege`
--

INSERT INTO `siege` (`ids`, `type`, `place`) VALUES
(1, 'E', '1A'),
(2, 'E', '16B'),
(3, 'P', '4A'),
(4, 'E', '6D'),
(5, 'P', '23B'),
(6, 'E', '60A'),
(7, 'E', '27B'),
(8, 'P', '3B'),
(9, 'P', '4A');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` text NOT NULL,
  `pass` text NOT NULL,
  `admin` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `Login`, `pass`, `admin`) VALUES
(1, 'admin', 'admin', 1),
(2, 'user', 'user', 0);

-- --------------------------------------------------------

--
-- Table structure for table `vol`
--

CREATE TABLE IF NOT EXISTS `vol` (
  `idv` varchar(30) NOT NULL,
  `ida` int(11) NOT NULL,
  `heureDepart` datetime NOT NULL,
  `heureARRIVEE` datetime NOT NULL,
  `duree` text NOT NULL,
  `aeroportDepart` text NOT NULL,
  `aeroportarrivee` text NOT NULL,
  `distance` int(11) NOT NULL,
  PRIMARY KEY (`idv`),
  KEY `ida` (`ida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vol`
--

INSERT INTO `vol` (`idv`, `ida`, `heureDepart`, `heureARRIVEE`, `duree`, `aeroportDepart`, `aeroportarrivee`, `distance`) VALUES
('JBU1016-1510381558-airline-024', 1016, '2020-11-13 14:35:00', '2020-11-13 14:35:00', '00:50:00', 'Stockholm-Arlanda, Stockholm', 'Skelleftea, Skelleftea', 340),
('JBU1407-1510381558-airline-001', 1407, '2020-11-13 15:20:00', '2020-11-13 16:10:00', '00:50:00', 'Stockholm-Arlanda, Stockholm', 'Copenhagen, Copenhagen', 340),
('JBU1420-1510381558-airline-037', 1420, '2020-11-13 11:59:00', '2020-11-13 12:56:00', '00:57:00', 'Copenhagen, Copenhagen', 'Stockholm-Arlanda, Stockholm', 340),
('JBU1422-1510381558-airline-040', 1422, '2020-11-13 13:27:00', '2020-11-13 14:27:00', '01:00:00', 'Copenhagen, Copenhagen', 'Stockholm-Arlanda, Stockholm', 340),
('JBU1492-1510381558-airline-028', 1492, '2020-11-13 10:52:00', '2020-11-13 12:28:00', '01:36:00', 'Tromso, Langnes, Tromso, Troms', 'Stockholm-Arlanda, Stockholm', 694),
('JBU1589-1510381558-airline-044', 1589, '2020-11-13 15:20:00', '2020-11-13 17:10:00', '01:50:00', 'Stockholm-Arlanda, Stockholm', 'Brussels, Brussels', 801),
('JBU1624-1510381558-airline-037', 1624, '2020-11-13 11:21:00', '2020-11-13 13:10:00', '01:49:00', 'Dusseldorf Int''l, Dusseldorf', 'Stockholm-Arlanda, Stockholm', 723),
('JBU2064-1510381558-airline-022', 2064, '2020-11-13 14:50:00', '2020-11-13 15:30:00', '00:40:00', 'Stockholm-Arlanda, Stockholm', 'Ostersund (Froson Air Base), Ostersund', 270),
('JBU2111-1510381558-airline-017', 2111, '2020-11-13 14:40:00', '2020-11-13 15:30:00', '00:50:00', 'Stockholm-Arlanda, Stockholm', 'Malmo, Malmö', 331),
('JBU2548-1510381558-airline-027', 2548, '2020-11-13 10:04:00', '2020-11-13 13:12:00', '03:08:00', 'Manchester, Manchester, England', 'Stockholm-Arlanda, Stockholm', 880),
('SAS10-1510381558-airline-0123', 10, '2020-11-13 14:15:00', '2020-11-13 15:10:00', '00:55:00', 'Stockholm-Arlanda, Stockholm', 'Lulea (Kallax Air Base), Lulea', 429),
('SAS152-1510381558-airline-0159', 152, '2020-11-13 11:03:00', '2020-11-13 11:50:00', '00:47:00', 'Goteborg, Landvetter', 'Stockholm-Arlanda, Stockholm', 245),
('SAS161-1510381558-airline-0070', 161, '2020-11-13 14:55:00', '2020-11-13 15:35:00', '00:40:00', 'Stockholm-Arlanda, Stockholm', 'Goteborg, Landvetter', 245),
('SAS185-1510381558-airline-0281', 185, '2020-11-13 14:50:00', '2020-11-13 15:35:00', '00:45:00', 'Stockholm-Arlanda, Stockholm', 'Angelholm-Helsingbor, Ängelholm', 297),
('SAS34-1510381558-airline-0279', 34, '2020-11-13 14:40:00', '2020-11-13 15:25:00', '00:45:00', 'Stockholm-Arlanda, Stockholm', 'Umea, Umea', 297),
('SAS484-1510381558-airline-0045', 484, '2020-11-13 11:06:00', '2020-11-13 11:51:00', '00:45:00', 'Oslo, Gardermoen, Oslo', 'Stockholm-Arlanda, Stockholm', 239),
('SAS52-1510381558-airline-0252', 52, '2020-11-13 15:08:00', '2020-11-13 15:41:00', '00:33:00', 'Stockholm-Arlanda, Stockholm', 'Sundsvall, Harnosand', 200),
('SAS527-1510381558-airline-0247', 527, '2020-11-13 15:30:00', '2020-11-13 16:50:00', '01:20:00', 'Stockholm-Arlanda, Stockholm', 'London Heathrow, London, England', 909),
('SAS556-1510381558-airline-0054', 556, '2020-11-13 11:46:00', '2020-11-13 13:30:00', '01:44:00', 'Amsterdam Schiphol, Amsterdam', 'Stockholm-Arlanda, Stockholm', 717),
('SAS574-1510381558-airline-0269', 574, '2020-11-13 10:46:00', '2020-11-13 13:17:00', '02:31:00', 'Charles de Gaulle/Roissy, Paris', 'Stockholm-Arlanda, Stockholm', 957),
('SAS590-1510381558-airline-0195', 590, '2020-11-13 10:17:00', '2020-11-13 12:26:00', '02:09:00', 'Brussels, Brussels', 'Stockholm-Arlanda, Stockholm', 801),
('SAS606-1510381558-airline-0258', 606, '2020-11-13 10:42:00', '2020-11-13 12:55:00', '02:13:00', 'Zurich (Kloten), Zurich', 'Stockholm-Arlanda, Stockholm', 925),
('SAS61-1510381558-airline-0044', 61, '2020-11-13 12:46:00', '2020-11-13 13:36:00', '00:50:00', 'Ostersund (Froson Air Base), Ostersund', 'Stockholm-Arlanda, Stockholm', 270),
('SAS637-1510381558-airline-0190', 637, '2020-11-13 14:50:00', '2020-11-13 16:40:00', '01:50:00', 'Stockholm-Arlanda, Stockholm', 'Frankfurt Int''l, Frankfurt am Main', 762),
('SAS7-1510381558-airline-0055', 7, '2020-11-13 11:16:00', '2020-11-13 12:23:00', '01:07:00', 'Lulea (Kallax Air Base), Lulea', 'Stockholm-Arlanda, Stockholm', 429),
('SAS712-1510381558-airline-0310', 712, '2020-11-13 14:20:00', '2020-11-13 16:05:00', '01:45:00', 'Stockholm-Arlanda, Stockholm', 'Helsinki-Vantaa, Vantaa', 248),
('SAS867-1510381558-airline-0163', 867, '2020-11-13 14:35:00', '2020-11-13 15:15:00', '00:40:00', 'Stockholm-Arlanda, Stockholm', 'Oslo, Gardermoen, Oslo', 239),
('SAS868-1510381558-airline-0012', 868, '2020-11-13 12:50:00', '2020-11-13 13:38:00', '00:48:00', 'Oslo, Gardermoen, Oslo', 'Stockholm-Arlanda, Stockholm', 239),
('SAS898-1510381558-airline-0002', 898, '2020-11-13 10:39:00', '2020-11-13 11:47:00', '01:08:00', 'Bergen, Flesland, Bergen, Hordaland', 'Stockholm-Arlanda, Stockholm', 441),
('SAS963-1510381558-airline-0005', 963, '2020-11-13 14:00:00', '2020-11-14 07:00:00', '17:00:00', 'Stockholm-Arlanda, Stockholm', 'Hong Kong Int''l, Hong Kong', 5106);

-- --------------------------------------------------------

--
-- Table structure for table `voyageur`
--

CREATE TABLE IF NOT EXISTS `voyageur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `adresse` text NOT NULL,
  `passport` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `voyageur`
--

INSERT INTO `voyageur` (`id`, `nom`, `prenom`, `adresse`, `passport`) VALUES
(1, 'admin', 'admin', '123, Rabat, Maroc', 'GO123456'),
(2, 'nom utilisateur', 'Prenom utilisateur', '123, Rabat, Maroc', 'GO123456');

-- --------------------------------------------------------

--
-- Structure for view `booking_list`
--
DROP TABLE IF EXISTS `booking_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `booking_list` AS select `reservationnew`.`idv` AS `idv`,`reservationnew`.`aeroportDepart` AS `aeroportDepart`,`reservationnew`.`heureDepart` AS `heureDepart`,`reservationnew`.`aeroportarrivee` AS `aeroportarrivee`,`reservationnew`.`heureARRIVEE` AS `heureARRIVEE`,`reservationnew`.`restantes` AS `restantes`,`avion`.`nb_place` AS `nb_place` from ((`reservationnew` join `vol` on((`vol`.`idv` = `reservationnew`.`idv`))) join `avion` on((`avion`.`ida` = `vol`.`ida`)));

-- --------------------------------------------------------

--
-- Structure for view `gestionb`
--
DROP TABLE IF EXISTS `gestionb`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gestionb` AS select `reservation`.`id_user` AS `id_user`,`reservation`.`idv` AS `idv`,`reservation`.`idb` AS `idb`,`reservation`.`ids` AS `ids`,`siege`.`place` AS `place`,`siege`.`type` AS `type`,`billet`.`dateReservation` AS `datereservation`,`billet`.`etat` AS `etat` from (((`billet` join `reservation` on((`reservation`.`idb` = `billet`.`idb`))) join `vol` on((`vol`.`idv` = `reservation`.`idv`))) join `siege` on((`siege`.`ids` = `reservation`.`ids`)));

-- --------------------------------------------------------

--
-- Structure for view `places`
--
DROP TABLE IF EXISTS `places`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `places` AS select `vol`.`idv` AS `idv`,(`avion`.`nb_place` - count(`reservation`.`idv`)) AS `nb_place - count(reservation.idv)` from ((`vol` left join `avion` on((`vol`.`ida` = `avion`.`ida`))) left join `reservation` on((`vol`.`idv` = `reservation`.`idv`))) group by `vol`.`idv`;

-- --------------------------------------------------------

--
-- Structure for view `reservationbooked`
--
DROP TABLE IF EXISTS `reservationbooked`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservationbooked` AS select `reservation`.`id_user` AS `id_user`,`vol`.`idv` AS `idv`,`vol`.`heureDepart` AS `heureDepart`,`vol`.`aeroportDepart` AS `aeroportDepart`,`vol`.`aeroportarrivee` AS `aeroportarrivee`,`vol`.`duree` AS `duree`,`siege`.`place` AS `place`,`billet`.`etat` AS `etat` from (((`vol` join `reservation` on((`vol`.`idv` = `reservation`.`idv`))) join `siege` on((`siege`.`ids` = `reservation`.`ids`))) join `billet` on((`billet`.`idb` = `reservation`.`idb`)));

-- --------------------------------------------------------

--
-- Structure for view `reservationnew`
--
DROP TABLE IF EXISTS `reservationnew`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservationnew` AS select `vol`.`idv` AS `idv`,`vol`.`heureDepart` AS `heureDepart`,`vol`.`heureARRIVEE` AS `heureARRIVEE`,`vol`.`aeroportDepart` AS `aeroportDepart`,`vol`.`aeroportarrivee` AS `aeroportarrivee`,`vol`.`duree` AS `duree`,`places`.`nb_place - count(reservation.idv)` AS `restantes` from (`vol` join `places` on((`places`.`idv` = `vol`.`idv`)));

-- --------------------------------------------------------

--
-- Structure for view `reservationseats`
--
DROP TABLE IF EXISTS `reservationseats`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservationseats` AS select `reservation`.`idv` AS `idv`,`siege`.`place` AS `place` from (`reservation` join `siege` on((`siege`.`ids` = `reservation`.`ids`))) order by `siege`.`place`;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`ids`) REFERENCES `siege` (`ids`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`idb`) REFERENCES `billet` (`idb`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`idv`) REFERENCES `vol` (`idv`);

--
-- Constraints for table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `vol_ibfk_1` FOREIGN KEY (`ida`) REFERENCES `avion` (`ida`);

--
-- Constraints for table `voyageur`
--
ALTER TABLE `voyageur`
  ADD CONSTRAINT `voyageur_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
