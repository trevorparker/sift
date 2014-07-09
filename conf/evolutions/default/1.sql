# Submissions schema

# --- !Ups
CREATE TABLE Submissions (
    id LONG NOT NULL AUTO_INCREMENT,
    title VARCHAR NOT NULL,
    url VARCHAR NOT NULL
);

# --- !Downs
DROP TABLE Submission

