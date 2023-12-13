-- data.sql
INSERT INTO Videojuegos (id, title, description, url_video) VALUES
('card1', 'BTS Island: In the Seom', 'Juego de rompecabezas con los siete miembros del grupo como protagonistas.', 'https://www.youtube.com/embed/dyhMYSGIxpk?si=KASUj3Pq5nwNfp9f'),
('card2', 'Mortal Kombat', 'La travesía de Liu Kang para salvar al mundo del malvado hechicero Shang Tsung, travesía que acaba con su enfrentamiento en el torneo llamado Mortal Kombat', 'https://www.youtube.com/embed/7zkHyCh0pjE?si=P3zOiifK9BGzhdx6'),
('card3', 'Resident Evil', 'Sigue a Chris Redfield y Jill Valentine, miembros de una fuerza de élite conocida como S.T.A.R.S., mientras investigan las afueras de Raccoon City tras la desaparición de los miembros de su equipo', 'https://www.youtube.com/embed/sudvB8_iYUE?si=BGi5D4w8LoLrmVwO'),
('card4', 'Overwatch', 'Juego de acción en equipo gratuito ambientado en un futuro optimista en el que todas las partidas presentan una refriega definitiva 5c5.', 'https://www.youtube.com/embed/U8mBEZlMOKc?si=X6k-8F2dXYxRec1d'),
('card5', 'Super Mario Odyssey', 'Únete a Mario y su compañero Cappy en esta monumental aventura en 3D al mejor estilo trotamundos con Super Mario Odyssey para Nintendo Switch.', 'https://www.youtube.com/embed/A5zPmAKlPds?si=LCwiX8bOshbzXkOZ'),
('card6', 'Splatoon', 'Serie de videojuegos de disparos en tercera persona de Nintendo.', 'https://www.youtube.com/embed/M3lA45J2bFY?si=7XB0mtUSKtwwuJqk'),
('card7', 'Bungou Stray dogs #1', 'TOP: Muertes de bungou Stray dogs', 'https://www.youtube.com/embed/XjbAr1GgKBc?si=OQHdJ8BN7DaT-1lb'),
('card8', 'Bungou Stray dogs #2', '¿Quién es chuya Nakamahara?', 'https://www.youtube.com/embed/n5-5Bi7_Tc4?si=rMG0Af8uqhoMX47R'),
('card9', 'Netflix anime', 'Top los mejores animes en Netflix', 'https://www.youtube.com/embed/Y5Uz-PyojYA?si=f2_hQjWQC7TdZ1k_'),
('card10', 'Dibujar Anime #1', 'Aprende a dibujar anime siguiendo estos consejos.', 'https://www.youtube.com/embed/C0_IgbfmkmA?si=5Y3QNxT7noLi5y-7'),
('card11', 'Dibujar Anime #2', 'Aprende a dibujar rostro de anime siguiendo estos consejos.', 'https://www.youtube.com/embed/h1BOqVohhnM?si=Cvyj9PmDCtnf6uJe'),
('card12', 'Dibujar Anime #3', 'Aprende a dibujar anime siguiendo estos consejos.', 'https://www.youtube.com/embed/hJtvT98ZhjY?si=q_-I0WvweAcaE4Dr'),
('card13', 'Especial mascota #1', 'Dia especial de las mascotas', 'https://www.youtube.com/embed/eJaSZF8rZoE?si=SRY5-S4UlRIweoZw'),
('card14', 'Cuidados de tu mascota #1', 'Ten en cuenta los siguientes pasos', 'https://www.youtube.com/embed/LZ9AKsUCcTI?si=DcnrZAInCrNQC1_C'),
('card15', 'Cuidados de tu mascota #2', 'Ten en cuenta los siguientes pasos', 'https://www.youtube.com/embed/z6qn2YzE54M?si=NcJ8qZkxh4zYMYsB'),
('card16', 'Cuidados de tu mascota #3', 'Ten en cuenta los siguientes pasos', 'https://www.youtube.com/embed/1aXIiXUCZVU?si=LneFutOIbdNA4O7A'),
('card17', 'Cuidados de tu mascota #4', 'Ten en cuenta los siguientes pasos', 'https://www.youtube.com/embed/TbgB5zH8_3E?si=cPR6UBciSJYFKVoc'),
('card18', 'Cuidados de tu mascota #5', 'Ten en cuenta los siguientes pasos', 'https://www.youtube.com/embed/NL0A7a8fYvc?si=rX0NoPQH9jg--XIW'),
('card19', 'TOP LIBROS #1', 'Conocelos', 'https://www.youtube.com/embed/V_rpUUPrDaA?si=T4XLmXejqTmC5aZh'),
('card20', 'TOP LIBROS #2', 'Conocelos', 'https://www.youtube.com/embed/JP1aN7UlB24?si=fPOPFLOb9JcF7gAc'),
('card21', 'TOP LIBROS #3', 'Conocelos', 'https://www.youtube.com/embed/xxHH10n0k4o?si=6RRuWJpC5KKCT1z_'),
('card22', 'TOP LIBROS #4', 'Conocelos', 'https://www.youtube.com/embed/xky-sIkQ4Ys?si=FvfnENKk6Al47_B4');

INSERT INTO usuarios (id, nombre, apellido, email, password, rol) VALUES
    (1, 'Juan', 'Pérez', 'juan.perez@example.com', '123456', 'USUARIO'),
    (2, 'María', 'García', 'maria.garcia@example.com', '654321', 'USUARIO'),
    (3, 'Pedro', 'López', 'pedro.lopez@example.com', 'qwerty', 'USUARIO'),
    (4, 'Ana', 'González', 'ana.gonzalez@example.com', 'asdfgh', 'USUARIO');
