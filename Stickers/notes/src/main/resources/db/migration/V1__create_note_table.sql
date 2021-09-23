CREATE TABLE record
(
    id         BIGINT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    user_id    BIGINT,
    question   VARCHAR(255),
    answer     VARCHAR(255),
    CONSTRAINT pk_record PRIMARY KEY (id)
);


CREATE SEQUENCE hibernate_sequence;