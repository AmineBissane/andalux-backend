DELETE FROM users WHERE username = 'Anas';
INSERT INTO users (username, email, password, first_name, last_name)
VALUES (
    'Anas',
    'anas@example.com',
    '$2a$12$h1JzD9SGLl5BQL8tnXqlxOQfs672Y/02bi8W44CaYDJffGcbFyp7O',
    'Anas',
    'Anas'
); 