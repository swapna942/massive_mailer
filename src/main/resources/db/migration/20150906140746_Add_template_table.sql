DROP TABLE IF EXISTS Template;

CREATE TABLE Template (
    Id              INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    TemplateName    VARCHAR(255) NOT NULL,
    Subject         VARCHAR(255),
    Content         NVARCHAR(5000)
);