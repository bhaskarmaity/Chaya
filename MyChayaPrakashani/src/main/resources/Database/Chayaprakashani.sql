-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2020 at 07:37 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chaya`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_fee` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_teacher` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `course_fee`, `course_name`, `course_teacher`) VALUES
(100, 2000, 'JAVA', 'AD'),
(101, 9800, 'C++', 'DK'),
(102, 4100, 'C', 'IC'),
(103, 4500, 'DBMS', 'SK'),
(104, 2500, 'OS', 'RD'),
(105, 1000, 'ISAD', 'PK'),
(106, 6000, 'Data Structure', 'NP');

-- --------------------------------------------------------

--
-- Table structure for table `courseid_seq`
--

CREATE TABLE `courseid_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courseid_seq`
--

INSERT INTO `courseid_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `email`, `mobile`, `password`, `role`, `student_name`) VALUES
(1, 'b@gmail.com', '9647617149', '123', 'ROLE_ADMIN', 'Bhaskar Maity'),
(2, 'faruk@gmail.com', '9647678149', '123', 'ROLE_USER', 'Faruk sk'),
(3, 'spandan@gmail.com', '9647617188', '123', 'USER', 'Spandan Chakraborty'),
(4, 'abhishek@gmail.com', '9647678147', '125', 'USER', 'Abhishek Mandal'),
(5, 'kaustav@gmail.com', '8887678147', '125', 'USER', 'Kaustav Ghosh'),
(6, 'sourav@gmail.com', '9647885522', '123', 'USER', 'Sourav Samanta'),
(7, 'raj@gmail.com', '7787008840', '1234', 'USER', 'Raj Pal');

-- --------------------------------------------------------

--
-- Table structure for table `studentid_seq`
--

CREATE TABLE `studentid_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentid_seq`
--

INSERT INTO `studentid_seq` (`next_val`) VALUES
(8);

-- --------------------------------------------------------

--
-- Table structure for table `students_courses`
--

CREATE TABLE `students_courses` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students_courses`
--

INSERT INTO `students_courses` (`course_id`, `student_id`) VALUES
(103, 1),
(103, 4),
(103, 5),
(105, 3),
(105, 5),
(104, 2),
(104, 3),
(104, 6),
(106, 3),
(106, 6),
(101, 4),
(101, 7),
(102, 1),
(102, 2),
(102, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `students_courses`
--
ALTER TABLE `students_courses`
  ADD KEY `FKfbiw8vd6a6fxgjlqi99c977al` (`student_id`),
  ADD KEY `FKd6vd2y2gdvqap78cu28i6xki5` (`course_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students_courses`
--
ALTER TABLE `students_courses`
  ADD CONSTRAINT `FKd6vd2y2gdvqap78cu28i6xki5` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  ADD CONSTRAINT `FKfbiw8vd6a6fxgjlqi99c977al` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
