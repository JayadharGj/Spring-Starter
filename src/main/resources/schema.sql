CREATE TABLE IF NOT EXISTS Content (
  id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    desc text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    url VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO Content(title, desc, status, content_type, date_created)
VALUES('Test Title', 'Test Description', 'IDEA', 'BLOG', CURRENT_TIMESTAMP);