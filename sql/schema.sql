-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE DATABASE "mobilegift" ----------------------------
CREATE DATABASE IF NOT EXISTS `mobilegift` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mobilegift`;
-- ---------------------------------------------------------


-- CREATE TABLE "address" --------------------------------------
CREATE TABLE `address`( 
	`id` BigInt( 0 ) NOT NULL,
	`city` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`created_date` DateTime NULL,
	`modified_date` DateTime NULL,
	`state` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`street1` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`street2` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`zipcode` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "box" ------------------------------------------
CREATE TABLE `box`( 
	`id` Int( 0 ) NOT NULL,
	`height` Double( 22, 0 ) NULL,
	`image` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`length` Double( 22, 0 ) NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`width` Double( 22, 0 ) NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "gift_wrap" ------------------------------------
CREATE TABLE `gift_wrap`( 
	`id` BigInt( 0 ) NOT NULL,
	`amount` Decimal( 19, 2 ) NULL,
	`box_id` Int( 0 ) NULL,
	`created_date` DateTime NULL,
	`modified_date` DateTime NULL,
	`ribon_id` Int( 0 ) NULL,
	`style` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`wrapping_paper_id` Int( 0 ) NULL,
	`order_id` BigInt( 0 ) NULL,
	`pre_designed_gift_wrap_id` BigInt( 0 ) NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "hibernate_sequence" ---------------------------
CREATE TABLE `hibernate_sequence`( 
	`next_val` BigInt( 0 ) NULL )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "orders" ---------------------------------------
CREATE TABLE `orders`( 
	`id` BigInt( 0 ) NOT NULL,
	`amount` Decimal( 19, 2 ) NULL,
	`created_date` DateTime NULL,
	`modified_date` DateTime NULL,
	`notes` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`wrap_date_end` DateTime NULL,
	`wrap_date_start` DateTime NULL,
	`address_id` BigInt( 0 ) NULL,
	`users_id` BigInt( 0 ) NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "pre_designed_gift_wrap" -----------------------
CREATE TABLE `pre_designed_gift_wrap`( 
	`id` BigInt( 0 ) NOT NULL,
	`height` Double( 22, 0 ) NULL,
	`image` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`length` Double( 22, 0 ) NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`price` Double( 22, 0 ) NULL,
	`quantity` Int( 0 ) NULL,
	`size` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`width` Double( 22, 0 ) NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "ribon" ----------------------------------------
CREATE TABLE `ribon`( 
	`id` Int( 0 ) NOT NULL,
	`image` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "users" ----------------------------------------
CREATE TABLE `users`( 
	`id` BigInt( 0 ) NOT NULL,
	`created_date` DateTime NULL,
	`email` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`firstname` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`lastname` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`modified_date` DateTime NULL,
	`phone` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "wrapping_paper" -------------------------------
CREATE TABLE `wrapping_paper`( 
	`id` Int( 0 ) NOT NULL,
	`image` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	PRIMARY KEY ( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- Dump data of "address" ----------------------------------
-- ---------------------------------------------------------


-- Dump data of "box" --------------------------------------
-- ---------------------------------------------------------


-- Dump data of "gift_wrap" --------------------------------
-- ---------------------------------------------------------


-- Dump data of "hibernate_sequence" -----------------------
BEGIN;

INSERT INTO `hibernate_sequence`(`next_val`) VALUES 
( '1' ),
( '1' ),
( '1' ),
( '1' ),
( '1' ),
( '1' ),
( '1' ),
( '1' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "orders" -----------------------------------
-- ---------------------------------------------------------


-- Dump data of "pre_designed_gift_wrap" -------------------
-- ---------------------------------------------------------


-- Dump data of "ribon" ------------------------------------
-- ---------------------------------------------------------


-- Dump data of "users" ------------------------------------
-- ---------------------------------------------------------


-- Dump data of "wrapping_paper" ---------------------------
-- ---------------------------------------------------------


-- CREATE INDEX "FK3of762f2bfii7s0242o9iq2ns" ------------------
CREATE INDEX `FK3of762f2bfii7s0242o9iq2ns` USING BTREE ON `gift_wrap`( `order_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKa1vc34f3b1d96nk6gijskdsjf" ------------------
CREATE INDEX `FKa1vc34f3b1d96nk6gijskdsjf` USING BTREE ON `gift_wrap`( `pre_designed_gift_wrap_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKe6k45xxoin4fylnwg2jkehwjf" ------------------
CREATE INDEX `FKe6k45xxoin4fylnwg2jkehwjf` USING BTREE ON `orders`( `users_id` );
-- -------------------------------------------------------------


-- CREATE INDEX "FKf5464gxwc32ongdvka2rtvw96" ------------------
CREATE INDEX `FKf5464gxwc32ongdvka2rtvw96` USING BTREE ON `orders`( `address_id` );
-- -------------------------------------------------------------


-- CREATE LINK "FK3of762f2bfii7s0242o9iq2ns" -------------------
ALTER TABLE `gift_wrap`
	ADD CONSTRAINT `FK3of762f2bfii7s0242o9iq2ns` FOREIGN KEY ( `order_id` )
	REFERENCES `orders`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKa1vc34f3b1d96nk6gijskdsjf" -------------------
ALTER TABLE `gift_wrap`
	ADD CONSTRAINT `FKa1vc34f3b1d96nk6gijskdsjf` FOREIGN KEY ( `pre_designed_gift_wrap_id` )
	REFERENCES `pre_designed_gift_wrap`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKf5464gxwc32ongdvka2rtvw96" -------------------
ALTER TABLE `orders`
	ADD CONSTRAINT `FKf5464gxwc32ongdvka2rtvw96` FOREIGN KEY ( `address_id` )
	REFERENCES `address`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


-- CREATE LINK "FKe6k45xxoin4fylnwg2jkehwjf" -------------------
ALTER TABLE `orders`
	ADD CONSTRAINT `FKe6k45xxoin4fylnwg2jkehwjf` FOREIGN KEY ( `users_id` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE No Action;
-- -------------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


