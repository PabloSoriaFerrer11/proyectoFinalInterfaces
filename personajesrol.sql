-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2022 a las 12:45:14
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `personajesrol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objetospersonajes`
--

CREATE TABLE `objetospersonajes` (
  `idpersonaje` int(4) NOT NULL,
  `idobjeto` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `objetospersonajes`
--

INSERT INTO `objetospersonajes` (`idpersonaje`, `idobjeto`) VALUES
(4, 5),
(4, 6),
(4, 5),
(4, 8),
(4, 9),
(4, 8),
(4, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `clase` varchar(50) NOT NULL,
  `puntosvida` int(4) NOT NULL,
  `puntosmana` int(4) NOT NULL,
  `puntosarmadura` int(4) NOT NULL,
  `puntosdaño` int(4) NOT NULL,
  `dinerototal` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`id`, `nombre`, `clase`, `puntosvida`, `puntosmana`, `puntosarmadura`, `puntosdaño`, `dinerototal`) VALUES
(4, 'Pablo Soria Ferrer', 'Arquero', 14, 2, 4, 6, 125),
(8, 'Ramux Maximus', 'Guerrero', 6, 3, 4, 4, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablaobjetos`
--

CREATE TABLE `tablaobjetos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` int(4) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `daño` int(4) DEFAULT NULL,
  `armadura` int(4) DEFAULT NULL,
  `tipoobjeto` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tablaobjetos`
--

INSERT INTO `tablaobjetos` (`id`, `nombre`, `precio`, `descripcion`, `daño`, `armadura`, `tipoobjeto`) VALUES
(4, 'Pocion Vida', 15, NULL, 0, 0, 'Miscelaneo'),
(5, 'Espada 2 manos', 30, NULL, 7, 0, 'Arma CuerpoCuerpo'),
(6, 'Pocion de Mana', 15, NULL, 0, 0, 'Miscelaneo'),
(7, 'Baston del Fenix', 60, NULL, 0, 0, 'Arma Mago'),
(8, '8 Monedas', 0, NULL, 0, 0, 'Miscelaneo'),
(9, '12 Monedas', 0, NULL, 0, 0, 'Miscelaneo'),
(10, 'Prueba', 56, NULL, 0, 0, 'Miscelaneo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `objetospersonajes`
--
ALTER TABLE `objetospersonajes`
  ADD KEY `idpersonaje` (`idpersonaje`),
  ADD KEY `idobjeto` (`idobjeto`);

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tablaobjetos`
--
ALTER TABLE `tablaobjetos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tablaobjetos`
--
ALTER TABLE `tablaobjetos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `objetospersonajes`
--
ALTER TABLE `objetospersonajes`
  ADD CONSTRAINT `objetospersonajes_ibfk_1` FOREIGN KEY (`idpersonaje`) REFERENCES `personajes` (`id`),
  ADD CONSTRAINT `objetospersonajes_ibfk_2` FOREIGN KEY (`idobjeto`) REFERENCES `tablaobjetos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
