CREATE TABLE lesson (
    id BIGINT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    title VARCHAR(255) UNIQUE NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);