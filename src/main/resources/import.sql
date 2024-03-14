INSERT INTO users (name, email, gender, type) VALUES ('User1', 'user1@example.com', 'MALE', 'ADULT');
INSERT INTO users (name, email, gender, type) VALUES ('User2', 'user2@example.com', 'FEMALE', 'ADULT');
INSERT INTO users (name, email, gender, type) VALUES ('User3', 'user3@example.com', 'OTHER', 'MINOR');
INSERT INTO users (name, email, gender, type) VALUES ('User4', 'user4@example.com', 'OTHER', 'MINOR');

INSERT INTO artworks (title, author, price, service_date, is_adult) VALUES ('Landscape Painting', 'Artist1', 100.00, '2024-01-01', false);
INSERT INTO artworks (title, author, price, service_date, is_adult) VALUES ('Modern Sculpture', 'Artist2', 200.00, '2024-01-02', true);
INSERT INTO artworks (title, author, price, service_date, is_adult) VALUES ('Abstract Art', 'Artist3', 150.00, '2024-01-03', false);
INSERT INTO artworks (title, author, price, service_date, is_adult) VALUES ('Portrait Painting', 'Artist4', 300.00, '2024-01-04', true);
INSERT INTO artworks (title, author, price, service_date, is_adult) VALUES ('Still Life', 'Artist5', 250.00, '2024-01-05', false);

INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (1, 1, 1, 0, 'Great artwork!');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (1, 2, 1, 0, 'Great!');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (1, 3, 1, 0, 'good!');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (2, 2, 0, 1, 'Not my style, but interesting.');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (3, 3, 1, 0, 'Love the colors and style.');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (1, 4, 1, 0, 'Truly a masterpiece.');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (2, 3, 0, 1, 'I prefer more traditional art.');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (3, 1, 0, 1, 'Interesting take on modern art.');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (4, 2, 1, 0, 'I love the details in the painting.');
INSERT INTO comments (artwork_id, user_id, good, dislike, comment) VALUES (5, 3, 0, 1, 'I prefer more color in my art.');

INSERT INTO artwork_view_histories (id, artwork_id, user_id, view_date) VALUES (1, 1, 1, '2024-03-01');
INSERT INTO artwork_view_histories (id, artwork_id, user_id, view_date) VALUES (2, 1, 1, '2024-03-02');
INSERT INTO artwork_view_histories (id, artwork_id, user_id, view_date) VALUES (3, 2, 2, '2024-03-03');
INSERT INTO artwork_view_histories (id, artwork_id, user_id, view_date) VALUES (4, 3, 3, '2024-03-04');
INSERT INTO artwork_view_histories (id, artwork_id, user_id, view_date) VALUES (5, 3, 1, '2024-03-05');
INSERT INTO artwork_view_histories (id, artwork_id, user_id, view_date) VALUES (6, 2, 2, '2024-03-06');


