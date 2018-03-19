SET NAMES 'utf8mb4';
SET CHARACTER SET utf8mb4;

show variables like '%colla%';
show variables like '%charac%';

ALTER DATABASE fpis01 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

ALTER TABLE ARTIKAL CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Ponuda CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE StavkaPonude CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


