-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-01-2025 a las 09:29:11
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE `ejemplar` (
  `id` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `estado` enum('Disponible','Prestado','Dañado') DEFAULT 'Disponible'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id`, `isbn`, `estado`) VALUES
(1, '9781234567890', 'Prestado'),
(2, '9781234567890', 'Disponible'),
(3, '9781234567890', 'Prestado'),
(4, '9789876543210', 'Disponible'),
(5, '9789876543210', 'Dañado'),
(6, '9781111111111', 'Disponible'),
(7, '9781111111111', 'Prestado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `isbn` varchar(20) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `autor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `titulo`, `autor`) VALUES
('9781111111111', '1984', 'George Orwell'),
('9781234567890', 'El Quijote', 'Miguel de Cervantes'),
('9782222222222', 'Nacidos de la Bruma', 'Brandon Sanderson'),
('9789876543210', 'Cien Años de Soledad', 'Gabriel García Márquez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `ejemplar_id` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaDevolucion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id`, `usuario_id`, `ejemplar_id`, `fechaInicio`, `fechaDevolucion`) VALUES
(1, 1, 3, '2024-11-01', NULL),
(2, 2, 4, '2024-11-05', '2024-11-20'),
(3, 4, 7, '2024-12-10', NULL),
(4, 4, 1, '2024-12-11', NULL),
(5, 4, 7, '2024-12-11', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo` enum('normal','administrador') NOT NULL,
  `penalizacionHasta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `dni`, `nombre`, `email`, `password`, `tipo`, `penalizacionHasta`) VALUES
(1, '12345678A', 'Juan Pérez', 'juan.perez@example.com', 'password123', 'normal', NULL),
(2, '87654321B', 'Ana García', 'ana.garcia@example.com', 'password123', 'normal', NULL),
(3, '11223344C', 'Luis López', 'luis.lopez@example.com', 'adminpass123', 'administrador', NULL),
(4, '49149509G', 'David', 'David@gmail.com', '123', 'normal', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKil41embjke7axloslhd82vlv8` (`isbn`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiq1nrc3dah91m2ug85kjk950g` (`ejemplar_id`),
  ADD KEY `FKqxhq6d4w6fuv27c7j3af28wdu` (`usuario_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `FKil41embjke7axloslhd82vlv8` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`) ON DELETE CASCADE,
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`) ON DELETE CASCADE;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `FKiq1nrc3dah91m2ug85kjk950g` FOREIGN KEY (`ejemplar_id`) REFERENCES `ejemplar` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKqxhq6d4w6fuv27c7j3af28wdu` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`ejemplar_id`) REFERENCES `ejemplar` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
