
ALTER TABLE TWSS_USERS ADD ABOUT VARCHAR2(500);
ALTER TABLE TWSS_USERS ADD COUNTRY_ID NUMBER;

UPDATE TWSS_USERS SET COUNTRY_ID = '52';

CREATE TABLE TWSS_COUNTRIES(
    ID NUMBER NOT NULL,
    NAME VARCHAR2(250 BYTE) NOT NULL,
    CODE VARCHAR2(250 BYTE) NOT NULL,
    CREATED TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    MODIFIED TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT TWSS_COUNTRIES_PK PRIMARY KEY (ID) ENABLE
);

INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (1,'Afganistán','AF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (2,'Islas Gland','AX');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (3,'Albania','AL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (4,'Alemania','DE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (5,'Andorra','AD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (6,'Angola','AO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (7,'Anguilla','AI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (8,'Antártida','AQ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (9,'Antigua y Barbuda','AG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (10,'Antillas Holandesas','AN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (11,'Arabia Saudí','SA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (12,'Argelia','DZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (13,'Argentina','AR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (14,'Armenia','AM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (15,'Aruba','AW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (16,'Australia','AU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (17,'Austria','AT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (18,'Azerbaiyán','AZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (19,'Bahamas','BS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (20,'Bahréin','BH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (21,'Bangladesh','BD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (22,'Barbados','BB');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (23,'Bielorrusia','BY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (24,'Bélgica','BE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (25,'Belice','BZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (26,'Benin','BJ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (27,'Bermudas','BM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (28,'Bhután','BT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (29,'Bolivia','BO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (30,'Bosnia y Herzegovina','BA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (31,'Botsuana','BW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (32,'Isla Bouvet','BV');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (33,'Brasil','BR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (34,'Brunéi','BN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (35,'Bulgaria','BG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (36,'Burkina Faso','BF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (37,'Burundi','BI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (38,'Cabo Verde','CV');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (39,'Islas Caimán','KY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (40,'Camboya','KH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (41,'Camerún','CM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (42,'Canadá','CA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (43,'República Centroafricana','CF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (44,'Chad','TD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (45,'República Checa','CZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (46,'Chile','CL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (47,'China','CN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (48,'Chipre','CY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (49,'Isla de Navidad','CX');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (50,'Ciudad del Vaticano','VA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (51,'Islas Cocos','CC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (52,'Colombia','CO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (53,'Comoras','KM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (54,'República Democrática del Congo','CD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (55,'Congo','CG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (56,'Islas Cook','CK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (57,'Corea del Norte','KP');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (58,'Corea del Sur','KR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (59,'Costa de Marfil','CI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (60,'Costa Rica','CR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (61,'Croacia','HR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (62,'Cuba','CU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (63,'Dinamarca','DK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (64,'Dominica','DM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (65,'República Dominicana','DO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (66,'Ecuador','EC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (67,'Egipto','EG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (68,'El Salvador','SV');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (69,'Emiratos Árabes Unidos','AE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (70,'Eritrea','ER');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (71,'Eslovaquia','SK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (72,'Eslovenia','SI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (73,'España','ES');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (74,'Islas ultramarinas de Estados Unidos','UM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (75,'Estados Unidos','US');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (76,'Estonia','EE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (77,'Etiopía','ET');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (78,'Islas Feroe','FO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (79,'Filipinas','PH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (80,'Finlandia','FI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (81,'Fiyi','FJ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (82,'Francia','FR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (83,'Gabón','GA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (84,'Gambia','GM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (85,'Georgia','GE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (86,'Islas Georgias del Sur y Sandwich del Sur','GS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (87,'Ghana','GH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (88,'Gibraltar','GI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (89,'Granada','GD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (90,'Grecia','GR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (91,'Groenlandia','GL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (92,'Guadalupe','GP');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (93,'Guam','GU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (94,'Guatemala','GT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (95,'Guayana Francesa','GF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (96,'Guinea','GN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (97,'Guinea Ecuatorial','GQ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (98,'Guinea-Bissau','GW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (99,'Guyana','GY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (100,'Haití','HT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (101,'Islas Heard y McDonald','HM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (102,'Honduras','HN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (103,'Hong Kong','HK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (104,'Hungría','HU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (105,'India','IN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (106,'Indonesia','ID');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (107,'Irán','IR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (108,'Iraq','IQ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (109,'Irlanda','IE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (110,'Islandia','IS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (111,'Israel','IL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (112,'Italia','IT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (113,'Jamaica','JM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (114,'Japón','JP');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (115,'Jordania','JO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (116,'Kazajstán','KZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (117,'Kenia','KE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (118,'Kirguistán','KG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (119,'Kiribati','KI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (120,'Kuwait','KW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (121,'Laos','LA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (122,'Lesotho','LS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (123,'Letonia','LV');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (124,'Líbano','LB');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (125,'Liberia','LR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (126,'Libia','LY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (127,'Liechtenstein','LI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (128,'Lituania','LT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (129,'Luxemburgo','LU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (130,'Macao','MO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (131,'ARY Macedonia','MK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (132,'Madagascar','MG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (133,'Malasia','MY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (134,'Malawi','MW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (135,'Maldivas','MV');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (136,'Malí','ML');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (137,'Malta','MT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (138,'Islas Malvinas','FK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (139,'Islas Marianas del Norte','MP');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (140,'Marruecos','MA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (141,'Islas Marshall','MH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (142,'Martinica','MQ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (143,'Mauricio','MU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (144,'Mauritania','MR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (145,'Mayotte','YT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (146,'México','MX');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (147,'Micronesia','FM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (148,'Moldavia','MD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (149,'Mónaco','MC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (150,'Mongolia','MN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (151,'Montserrat','MS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (152,'Mozambique','MZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (153,'Myanmar','MM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (154,'Namibia','NA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (155,'Nauru','NR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (156,'Nepal','NP');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (157,'Nicaragua','NI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (158,'Níger','NE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (159,'Nigeria','NG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (160,'Niue','NU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (161,'Isla Norfolk','NF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (162,'Noruega','NO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (163,'Nueva Caledonia','NC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (164,'Nueva Zelanda','NZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (165,'Omán','OM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (166,'Países Bajos','NL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (167,'Pakistán','PK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (168,'Palau','PW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (169,'Palestina','PS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (170,'Panamá','PA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (171,'Papúa Nueva Guinea','PG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (172,'Paraguay','PY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (173,'Perú','PE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (174,'Islas Pitcairn','PN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (175,'Polinesia Francesa','PF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (176,'Polonia','PL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (177,'Portugal','PT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (178,'Puerto Rico','PR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (179,'Qatar','QA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (180,'Reino Unido','GB');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (181,'Reunión','RE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (182,'Ruanda','RW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (183,'Rumania','RO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (184,'Rusia','RU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (185,'Sahara Occidental','EH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (186,'Islas Salomón','SB');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (187,'Samoa','WS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (188,'Samoa Americana','AS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (189,'San Cristóbal y Nevis','KN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (190,'San Marino','SM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (191,'San Pedro y Miquelón','PM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (192,'San Vicente y las Granadinas','VC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (193,'Santa Helena','SH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (194,'Santa Lucía','LC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (195,'Santo Tomé y Príncipe','ST');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (196,'Senegal','SN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (197,'Serbia y Montenegro','CS');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (198,'Seychelles','SC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (199,'Sierra Leona','SL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (200,'Singapur','SG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (201,'Siria','SY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (202,'Somalia','SO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (203,'Sri Lanka','LK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (204,'Suazilandia','SZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (205,'Sudáfrica','ZA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (206,'Sudán','SD');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (207,'Suecia','SE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (208,'Suiza','CH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (209,'Surinam','SR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (210,'Svalbard y Jan Mayen','SJ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (211,'Tailandia','TH');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (212,'Taiwán','TW');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (213,'Tanzania','TZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (214,'Tayikistán','TJ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (215,'Territorio Británico del Océano Índico','IO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (216,'Territorios Australes Franceses','TF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (217,'Timor Oriental','TL');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (218,'Togo','TG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (219,'Tokelau','TK');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (220,'Tonga','TO');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (221,'Trinidad y Tobago','TT');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (222,'Túnez','TN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (223,'Islas Turcas y Caicos','TC');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (224,'Turkmenistán','TM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (225,'Turquía','TR');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (226,'Tuvalu','TV');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (227,'Ucrania','UA');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (228,'Uganda','UG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (229,'Uruguay','UY');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (230,'Uzbekistán','UZ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (231,'Vanuatu','VU');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (232,'Venezuela','VE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (233,'Vietnam','VN');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (234,'Islas Vírgenes Británicas','VG');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (235,'Islas Vírgenes de los Estados Unidos','VI');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (236,'Wallis y Futuna','WF');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (237,'Yemen','YE');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (238,'Yibuti','DJ');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (239,'Zambia','ZM');
INSERT INTO TWSS_COUNTRIES (ID, NAME, CODE) VALUES (240,'Zimbabue','ZW');

ALTER TABLE TWSS_USERS ADD CONSTRAINT FK_COUNTRY FOREIGN KEY (COUNTRY_ID) REFERENCES TWSS_COUNTRIES (ID) ;