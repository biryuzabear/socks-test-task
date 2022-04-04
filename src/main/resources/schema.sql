CREATE TABLE `socks`
(
    `color`       VARCHAR(45) NOT NULL,
    `cotton_part` INT         NOT NULL,
    `quantity`    INT         NOT NULL,
    PRIMARY KEY (`color`, `cotton_part`)
);
