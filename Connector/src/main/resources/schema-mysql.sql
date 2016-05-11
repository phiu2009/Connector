ALTER TABLE `inventory` 
ADD COLUMN `wsSync` TINYINT(1) NULL DEFAULT 0 AFTER `refurbishDetail`;

ALTER TABLE `stock` 
CHANGE COLUMN `createdDateTime` `createdDateTime` TIMESTAMP NOT NULL DEFAULT 0 ;

CREATE DEFINER=`root`@`::1` TRIGGER `stock_createdDateTime` BEFORE INSERT ON `stock` FOR EACH ROW SET NEW.createdDateTime = NOW();

ALTER TABLE `stock` 
ADD COLUMN `wsSync` TINYINT(1) NULL DEFAULT 0 AFTER `notes`,
ADD COLUMN `modifiedDateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP AFTER `createdDateTime`;

ALTER TABLE `settings` 
ADD COLUMN `plSupplierId` INT(11) NOT NULL DEFAULT 0 AFTER `plSupplierCode`;

ALTER TABLE `inventoryimages` 
ADD COLUMN `wsSync` TINYINT(1) NULL DEFAULT 0 AFTER `data`;

CREATE TABLE IF NOT EXISTS `connector_sync` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `lastInventorySync` timestamp NULL DEFAULT NULL,
  `lastStockSync` timestamp NULL DEFAULT NULL,
  `lastInventoryWSSync` timestamp NULL DEFAULT NULL,
  `lastPartImageWSSync` timestamp NULL DEFAULT NULL,
  `lastStockImageWSSync` timestamp NULL DEFAULT NULL,
  `version` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
