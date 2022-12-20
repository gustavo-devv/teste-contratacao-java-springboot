-- CREATE TABLE `library` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `address` varchar(255) NOT NULL,
--   `name` varchar(255) NOT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- CREATE TABLE `book` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `author` varchar(255) NOT NULL,
--   `name` varchar(255) NOT NULL,
--   `status` varchar(255) DEFAULT NULL,
--   `library_id` int(11) DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FKaojxagnfmppd09k35kye5eph5` (`library_id`),
--   CONSTRAINT `FKaojxagnfmppd09k35kye5eph5` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- INSERT INTO `library` (`name`, `address`) VALUES (`Coletanea Gustavo`, `Rua 01 - Brasilia-DF`) ;

-- INSERT INTO `book` (`author`, `name`, `status`, `library_id`) VALUES (`Dan brown`, `O Codigo da vinci`, `AVAILABLE`, 1);
