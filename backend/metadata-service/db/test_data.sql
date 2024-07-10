-- Заполнение таблицы Genres
INSERT INTO Genres (name) VALUES
                              ('Rock'),
                              ('Pop'),
                              ('Jazz'),
                              ('Hip Hop'),
                              ('Classical');

-- Заполнение таблицы Artists
INSERT INTO Artists (id, name, genre_id) VALUES
                                             ('d290f1ee-6c54-4b01-90e6-d701748f0851', 'The Beatles', 1),
                                             ('d290f1ee-6c54-4b01-90e6-d701748f0852', 'Madonna', 2),
                                             ('d290f1ee-6c54-4b01-90e6-d701748f0853', 'Miles Davis', 3),
                                             ('d290f1ee-6c54-4b01-90e6-d701748f0854', 'Kendrick Lamar', 4),
                                             ('d290f1ee-6c54-4b01-90e6-d701748f0855', 'Ludwig van Beethoven', 5);

-- Заполнение таблицы Albums
INSERT INTO Albums (id, title, type, genre_id, release_date) VALUES
                                                                 ('6a4a5f9b-27b4-4b1e-b1ee-5d5c1ffcae21', 'Abbey Road', 'ALBUM', 1, '1969-09-26'),
                                                                 ('d56b6998-3fcd-4f26-9e87-247ed00e93f9', 'Like a Virgin', 'ALBUM', 2, '1984-11-12'),
                                                                 ('6a9b2b33-9c7a-40f7-8722-d4d5edac36c1', 'Kind of Blue', 'ALBUM', 3, '1959-08-17'),
                                                                 ('ad3b2f9c-5b9b-4a6e-b3d6-e4d5fddc98f1', 'To Pimp a Butterfly', 'ALBUM', 4, '2015-03-15'),
                                                                 ('c3a3bfc5-7b4d-49f3-b6d7-f4d5c9ec3ae1', 'Symphony No. 9', 'COMPILATION', 5, '1824-05-07'),
                                                                 ('a3a7bfc9-8b6d-48f3-b2d3-d4d6c7ec9ae2', 'Revolution', 'SINGLE', 1, '1968-08-26'),
                                                                 ('d4b8aebc-9f8d-4f37-8726-f7d7d1e39c8e', 'Vogue', 'SINGLE', 2, '1990-03-27'),
                                                                 ('6a1a4f7b-3b2e-41f8-8c2a-d4d8c3e6a9ae', 'Round About Midnight', 'COMPILATION', 3, '1957-03-18'),
                                                                 ('e3a2bf1b-6a4d-41b6-93d3-e5d5c9ef3d1f', 'DAMN.', 'ALBUM', 4, '2017-04-14'),
                                                                 ('b3a7bf6b-8b6d-41d3-b2f4-f4d5c6e2a1e3', 'Symphony No. 5', 'COMPILATION', 5, '1808-12-22');

-- Заполнение таблицы Tracks
INSERT INTO Tracks (id, title, genre_id, duration, s3_path, s3_cover_path) VALUES
                                                                                          ('1eae627d-9c7a-42f1-9e0f-c7d5f6c3f1a1', 'Come Together',1, '00:04:20', 's3://music/1eae627d9c7a42f19e0fc7d5f6c3f1a1.mp3', 's3://covers/1eae627d9c7a42f19e0fc7d5f6c3f1a1.jpg'),
                                                                                          ('2fbd728e-3c8b-4b2e-9f1e-d7e5f7d3e2b2', 'Material Girl', 2, '00:04:00', 's3://music/2fbd728e3c8b4b2e9f1ed7e5f7d3e2b2.mp3', 's3://covers/2fbd728e3c8b4b2e9f1ed7e5f7d3e2b2.jpg'),
                                                                                          ('3dce839f-4d9c-4c3e-9f2e-e7f6f8e3f3c3', 'So What', 3, '00:09:22', 's3://music/3dce839f4d9c4c3e9f2ee7f6f8e3f3c3.mp3', 's3://covers/3dce839f4d9c4c3e9f2ee7f6f8e3f3c3.jpg'),
                                                                                          ('4edf94b1-5eab-4d4f-9f3e-f7f7f9f4f4d4', 'Alright', 4, '00:03:39', 's3://music/4edf94b15eab4d4f9f3ef7f7f9f4f4d4.mp3', 's3://covers/4edf94b15eab4d4f9f3ef7f7f9f4f4d4.jpg'),
                                                                                          ('5fef05b2-6fbc-4e5f-9f4e-f8f8f0f5f5e5', 'Ode to Joy', 5, '00:12:15', 's3://music/5fef05b26fbc4e5f9f4ef8f8f0f5f5e5.mp3', 's3://covers/5fef05b26fbc4e5f9f4ef8f8f0f5f5e5.jpg'),
                                                                                          ('7c9723e7-4a3c-4355-8d25-9786083ca4e2', 'Revolution', 1, '00:03:25', 's3://music/6a0f16c37fcd4f6f9f5eg8g9g1g6g6f6.mp3', 's3://covers/6a0f16c37fcd4f6f9f5eg8g9g1g6g6f6.jpg'),
                                                                                          ('2cc62f23-1fd9-4ca2-b548-6f46c9637462', 'Vogue', 2, '00:05:16', 's3://music/7b1g27d48fde4g7f9f6eh9h0h2h7h7g7.mp3', 's3://covers/7b1g27d48fde4g7f9f6eh9h0h2h7h7g7.jpg'),
                                                                                          ('99d55bec-8101-4074-bd34-b4a7e1a0428a', 'Round Midnight', 3, '00:05:54', 's3://music/8c2h38e59gef4h8f9f7ei0i1i3i8i8h8.mp3', 's3://covers/8c2h38e59gef4h8f9f7ei0i1i3i8i8h8.jpg'),
                                                                                          ('6ec156c3-7608-4370-8e92-48363c8dcd85', 'HUMBLE.', 4, '00:02:57', 's3://music/9d3i49f6ajgh4i9f9f8ej1j2j4j9j9i9.mp3', 's3://covers/9d3i49f6ajgh4i9f9f8ej1j2j4j9j9i9.jpg'),
                                                                                          ('eac9ccba-1c7b-4d91-a5f6-2ccdec8b374f', 'Symphony No. 5 in C Minor',5, '00:07:05', 's3://music/0e4j5ag7bjhi4j1g9f9ek2k3k5k0k0j0.mp3', 's3://covers/0e4j5ag7bjhi4j1g9f9ek2k3k5k0k0j0.jpg');

-- Заполнение таблицы album_artist
INSERT INTO album_artist (album_id, artist_id) VALUES
                                                   ('6a4a5f9b-27b4-4b1e-b1ee-5d5c1ffcae21', 'd290f1ee-6c54-4b01-90e6-d701748f0851'),
                                                   ('d56b6998-3fcd-4f26-9e87-247ed00e93f9', 'd290f1ee-6c54-4b01-90e6-d701748f0852'),
                                                   ('6a9b2b33-9c7a-40f7-8722-d4d5edac36c1', 'd290f1ee-6c54-4b01-90e6-d701748f0853'),
                                                   ('ad3b2f9c-5b9b-4a6e-b3d6-e4d5fddc98f1', 'd290f1ee-6c54-4b01-90e6-d701748f0854'),
                                                   ('c3a3bfc5-7b4d-49f3-b6d7-f4d5c9ec3ae1', 'd290f1ee-6c54-4b01-90e6-d701748f0855'),
                                                   ('a3a7bfc9-8b6d-48f3-b2d3-d4d6c7ec9ae2', 'd290f1ee-6c54-4b01-90e6-d701748f0851'),
                                                   ('d4b8aebc-9f8d-4f37-8726-f7d7d1e39c8e', 'd290f1ee-6c54-4b01-90e6-d701748f0852'),
                                                   ('6a1a4f7b-3b2e-41f8-8c2a-d4d8c3e6a9ae', 'd290f1ee-6c54-4b01-90e6-d701748f0853'),
                                                   ('e3a2bf1b-6a4d-41b6-93d3-e5d5c9ef3d1f', 'd290f1ee-6c54-4b01-90e6-d701748f0854'),
                                                   ('b3a7bf6b-8b6d-41d3-b2f4-f4d5c6e2a1e3', 'd290f1ee-6c54-4b01-90e6-d701748f0855');

-- Заполнение таблицы track_artist
INSERT INTO track_artist (track_id, artist_id) VALUES
                                                   ('1eae627d-9c7a-42f1-9e0f-c7d5f6c3f1a1', 'd290f1ee-6c54-4b01-90e6-d701748f0851'),
                                                   ('2fbd728e-3c8b-4b2e-9f1e-d7e5f7d3e2b2', 'd290f1ee-6c54-4b01-90e6-d701748f0852'),
                                                   ('3dce839f-4d9c-4c3e-9f2e-e7f6f8e3f3c3', 'd290f1ee-6c54-4b01-90e6-d701748f0853'),
                                                   ('4edf94b1-5eab-4d4f-9f3e-f7f7f9f4f4d4', 'd290f1ee-6c54-4b01-90e6-d701748f0854'),
                                                   ('5fef05b2-6fbc-4e5f-9f4e-f8f8f0f5f5e5', 'd290f1ee-6c54-4b01-90e6-d701748f0855'),
                                                   ('7c9723e7-4a3c-4355-8d25-9786083ca4e2', 'd290f1ee-6c54-4b01-90e6-d701748f0851'),
                                                   ('2cc62f23-1fd9-4ca2-b548-6f46c9637462', 'd290f1ee-6c54-4b01-90e6-d701748f0852'),
                                                   ('99d55bec-8101-4074-bd34-b4a7e1a0428a', 'd290f1ee-6c54-4b01-90e6-d701748f0853'),
                                                   ('6ec156c3-7608-4370-8e92-48363c8dcd85', 'd290f1ee-6c54-4b01-90e6-d701748f0854'),
                                                   ('eac9ccba-1c7b-4d91-a5f6-2ccdec8b374f', 'd290f1ee-6c54-4b01-90e6-d701748f0855');

-- Заполнение таблицы track_album
INSERT INTO track_album (track_id, album_id) VALUES
                                                 ('1eae627d-9c7a-42f1-9e0f-c7d5f6c3f1a1', '6a4a5f9b-27b4-4b1e-b1ee-5d5c1ffcae21'),
                                                 ('2fbd728e-3c8b-4b2e-9f1e-d7e5f7d3e2b2', 'd56b6998-3fcd-4f26-9e87-247ed00e93f9'),
                                                 ('3dce839f-4d9c-4c3e-9f2e-e7f6f8e3f3c3', '6a9b2b33-9c7a-40f7-8722-d4d5edac36c1'),
                                                 ('4edf94b1-5eab-4d4f-9f3e-f7f7f9f4f4d4', 'ad3b2f9c-5b9b-4a6e-b3d6-e4d5fddc98f1'),
                                                 ('5fef05b2-6fbc-4e5f-9f4e-f8f8f0f5f5e5', 'c3a3bfc5-7b4d-49f3-b6d7-f4d5c9ec3ae1'),
                                                 ('7c9723e7-4a3c-4355-8d25-9786083ca4e2', 'a3a7bfc9-8b6d-48f3-b2d3-d4d6c7ec9ae2'),
                                                 ('2cc62f23-1fd9-4ca2-b548-6f46c9637462', 'd4b8aebc-9f8d-4f37-8726-f7d7d1e39c8e'),
                                                 ('99d55bec-8101-4074-bd34-b4a7e1a0428a', '6a1a4f7b-3b2e-41f8-8c2a-d4d8c3e6a9ae'),
                                                 ('6ec156c3-7608-4370-8e92-48363c8dcd85', 'e3a2bf1b-6a4d-41b6-93d3-e5d5c9ef3d1f'),
                                                 ('eac9ccba-1c7b-4d91-a5f6-2ccdec8b374f', 'b3a7bf6b-8b6d-41d3-b2f4-f4d5c6e2a1e3');
