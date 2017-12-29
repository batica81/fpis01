-- Adminer 4.3.1 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE `fpis01` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fpis01`;

DROP TABLE IF EXISTS `ARTIKAL`;
CREATE TABLE `ARTIKAL` (
  `SIFRAARTIKLA` int(11) NOT NULL,
  `NAZIVARTIKLA` varchar(200) NOT NULL,
  `JEDINICAMERE` varchar(20) DEFAULT NULL,
  `OPISARTIKLA` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SIFRAARTIKLA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `ARTIKAL` (`SIFRAARTIKLA`, `NAZIVARTIKLA`, `JEDINICAMERE`, `OPISARTIKLA`) VALUES
(1,	'Pasta - Lasagna Noodle, Frozen',	'kom',	'quisque id justo sit amet'),
(2,	'Yogurt - Raspberry, 175 Gr',	'kom',	'est lacinia'),
(3,	'Towel - Roll White',	'kom',	'interdum mauris'),
(4,	'Wine - Sawmill Creek Autumn',	'kom',	'morbi vel lectus in'),
(5,	'Chicken - Base, Ultimate',	'kom',	'venenatis tristique fusce congue diam'),
(6,	'Broom - Corn',	'kom',	'tristique in tempus sit amet'),
(7,	'Broom - Push',	'kom',	'faucibus orci'),
(8,	'Chicken - Whole Fryers',	'kom',	'rutrum ac lobortis vel dapibus'),
(9,	'Turnip - Wax',	'kom',	'velit nec nisi'),
(10,	'Lemon Tarts',	'kom',	'integer ac neque'),
(11,	'Noodles - Steamed Chow Mein',	'kom',	'tristique fusce'),
(12,	'Horseradish Root',	'kom',	'massa id'),
(13,	'Gelatine Powder',	'kom',	'id massa id nisl'),
(14,	'Halibut - Fletches',	'kom',	'viverra eget'),
(15,	'Sorrel - Fresh',	'kom',	'est risus auctor sed tristique'),
(16,	'Ham - Procutinni',	'kom',	'donec semper');

-- 2017-12-29 16:35:05
