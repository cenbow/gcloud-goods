  CREATE DATABASE IF NOT EXISTS gcloud_demo;
  USE gcloud_demo;
  SET FOREIGN_KEY_CHECKS = 0;
  DROP TABLE IF EXISTS `ts_area`;
  CREATE TABLE `ts_area` (
    `id`        BIGINT(20) PRIMARY KEY,
    `type`      TINYINT(4)   DEFAULT NULL,
    `name`      VARCHAR(128) DEFAULT '',
    `parent_id` BIGINT(20)   DEFAULT NULL,
    `zip`       VARCHAR(128) DEFAULT ''
  ) ENGINE = InnoDB  AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

  图片保存到门店表