-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Nov 24, 2024 at 09:25 PM
-- Server version: 8.0.40
-- PHP Version: 8.2.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nasa`
--

-- --------------------------------------------------------

--
-- Table structure for table `aproach`
--

CREATE DATABASE nasa;

use nasa;

CREATE TABLE `aproach` (
                           `id` int NOT NULL,
                           `aproachDate` date NOT NULL,
                           `velocity` double NOT NULL,
                           `distance` double NOT NULL,
                           `orbitingBody` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                           `id_asteroid` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `asteroid`
--

CREATE TABLE `asteroid` (
                            `id` int NOT NULL,
                            `name` varchar(100) DEFAULT NULL,
                            `magnitude` double DEFAULT NULL,
                            `diameter` double DEFAULT NULL,
                            `dangerous` varchar(100) DEFAULT NULL,
                            `nasaAsteroid` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
                       `id` int NOT NULL,
                       `rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`id`, `rol`) VALUES
                                    (1, 'astronomer'),
                                    (2, 'observer');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
                        `id` int NOT NULL,
                        `name` varchar(100) NOT NULL,
                        `password` varchar(100) NOT NULL,
                        `id_rol` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aproach`
--
ALTER TABLE `aproach`
    ADD PRIMARY KEY (`id`),
  ADD KEY `id_asteroid` (`id_asteroid`);

--
-- Indexes for table `asteroid`
--
ALTER TABLE `asteroid`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id`),
  ADD KEY `id_rol` (`id_rol`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aproach`
--
ALTER TABLE `aproach`
    MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `asteroid`
--
ALTER TABLE `asteroid`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=492;

--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aproach`
--
ALTER TABLE `aproach`
    ADD CONSTRAINT `aproach_ibfk_1` FOREIGN KEY (`id_asteroid`) REFERENCES `asteroid` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
    ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
