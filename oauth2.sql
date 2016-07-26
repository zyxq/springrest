-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: 2016-07-26 07:05:53
-- 服务器版本： 5.5.49
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oauth2`
--

-- --------------------------------------------------------

--
-- 表的结构 `oauth_access_token`
--

CREATE TABLE `oauth_access_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_client_details`
--

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` text,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `archived` tinyint(1) DEFAULT '0',
  `trusted` tinyint(1) DEFAULT '0',
  `autoapprove` varchar(255) DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `oauth_client_details`
--

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `create_time`, `archived`, `trusted`, `autoapprove`) VALUES
('mobile-client', 'mobile-resource', 'mobile', 'read,write', 'password,refresh_token', NULL, 'ROLE_CLIENT', NULL, NULL, NULL, '2016-07-26 07:05:22', 0, 0, 'false'),
('unity-client', 'unity-resource', 'unity', 'read,write', 'authorization_code,refresh_token,implicit', NULL, 'ROLE_CLIENT', NULL, NULL, NULL, '2016-07-26 07:05:22', 0, 0, 'false');

-- --------------------------------------------------------

--
-- 表的结构 `oauth_code`
--

CREATE TABLE `oauth_code` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `code` varchar(255) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_refresh_token`
--

CREATE TABLE `oauth_refresh_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `user_`
--

CREATE TABLE `user_` (
  `id` int(11) NOT NULL,
  `guid` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `archived` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `default_user` tinyint(1) DEFAULT '0',
  `last_login_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_`
--

INSERT INTO `user_` (`id`, `guid`, `create_time`, `archived`, `email`, `password`, `phone`, `username`, `default_user`, `last_login_time`) VALUES
(21, '29f6004fb1b0466f9572b02bf2ac1be8', '2016-07-26 07:05:22', 0, 'admin@wdcy.cc', '21232f297a57a5a743894a0e4a801fc3', '028-1234567', 'admin', 1, NULL),
(22, '55b713df1c6f423e842ad68668523c49', '2016-07-26 07:05:22', 0, 'unity@wdcy.cc', '439b3a25b555b3bc8667a09a036ae70c', '', 'unity', 0, NULL),
(23, '612025cb3f964a64a48bbdf77e53c2c1', '2016-07-26 07:05:22', 0, 'mobile@wdcy.cc', '532c28d5412dd75bf975fb951c740a30', '', 'mobile', 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `user_privilege`
--

CREATE TABLE `user_privilege` (
  `user_id` int(11) DEFAULT NULL,
  `privilege` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_privilege`
--

INSERT INTO `user_privilege` (`user_id`, `privilege`) VALUES
(22, 'UNITY'),
(23, 'MOBILE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `oauth_access_token`
--
ALTER TABLE `oauth_access_token`
  ADD KEY `token_id_index` (`token_id`),
  ADD KEY `authentication_id_index` (`authentication_id`),
  ADD KEY `user_name_index` (`user_name`),
  ADD KEY `client_id_index` (`client_id`),
  ADD KEY `refresh_token_index` (`refresh_token`);

--
-- Indexes for table `oauth_client_details`
--
ALTER TABLE `oauth_client_details`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `oauth_code`
--
ALTER TABLE `oauth_code`
  ADD KEY `code_index` (`code`);

--
-- Indexes for table `oauth_refresh_token`
--
ALTER TABLE `oauth_refresh_token`
  ADD KEY `token_id_index` (`token_id`);

--
-- Indexes for table `user_`
--
ALTER TABLE `user_`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `guid` (`guid`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `user_privilege`
--
ALTER TABLE `user_privilege`
  ADD KEY `user_id_index` (`user_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `user_`
--
ALTER TABLE `user_`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
