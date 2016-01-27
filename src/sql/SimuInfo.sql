create table `SimuInfo` (
  `ID` int primary key auto_increment,
  `title` varchar(200) not null default "",
  `type` varchar(200) not null default "",
  `nav` varchar(200) not null default "",
  `earnings` varchar(6000) not null default "",
  `detailTitle` varchar(6000) not null default "",
  `detailData` text(60000) not null,
  `url` varchar(5000) not null default ""
) default charset 'utf8' ENGINE='innodb';