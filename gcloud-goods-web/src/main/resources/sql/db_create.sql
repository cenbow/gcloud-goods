  CREATE DATABASE IF NOT EXISTS gcloud_goods;
  USE gcloud_goods;
  SET FOREIGN_KEY_CHECKS = 0;

  -- ----------------------------
  -- Table structure for tb_goods_spu
  -- 商品信息SPU表
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_spu`;
  CREATE TABLE `tb_goods_spu` (
    `id` bigint(22) DEFAULT NULL,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `num_iid` bigint(22) NOT NULL DEFAULT '0',
    `on_sale` tinyint(1) DEFAULT NULL,
    `short_title` varchar(64) DEFAULT '',
    `market` varchar(64) DEFAULT '',
    `factory` varchar(64) DEFAULT '',
    `goods_allocation` varchar(64) DEFAULT '',
    `actual_stock` bigint(11) DEFAULT NULL,
    `available_in_stock` bigint(11) DEFAULT NULL,
    `lock_stock` bigint(11) DEFAULT NULL,
    `defective_stock` bigint(11) DEFAULT NULL,
    `alarm_stock` bigint(11) DEFAULT NULL,
    `cost_price` double(11,0) DEFAULT NULL,
    `weight` double(11,0) DEFAULT NULL,
    `barcode` varchar(128) DEFAULT NULL,
    `pic_path` varchar(1024) DEFAULT '',
    `title` varchar(64) DEFAULT '',
    `outer_id` varchar(64) DEFAULT '',
    `num` bigint(11) DEFAULT NULL,
    `alarm` int(11) DEFAULT NULL,
    `remark` varchar(128) DEFAULT '',
    `type` varchar(32) DEFAULT '',
    `cat_id` varchar(128) DEFAULT '',
    `brand` varchar(128) DEFAULT '',
    `seller_cids` varchar(1024) DEFAULT '',
    `platform` varchar(12) DEFAULT NULL,
    `props_name` varchar(1024) DEFAULT NULL,
    `unit` varchar(1024) DEFAULT NULL,
    `purchase_price` double(12,2) DEFAULT NULL,
    `selling_price` double(12,2) DEFAULT NULL,
    `x` double(6,2) DEFAULT NULL,
    `y` double(6,2) DEFAULT NULL,
    `z` double(6,2) DEFAULT NULL,
    `period_cast` int(6) DEFAULT NULL,
    `place` varchar(128) DEFAULT NULL,
    `age` int(12) DEFAULT NULL,
    `sys_item_id` bigint(18) DEFAULT NULL,
    `defined_1` varchar(1024) DEFAULT '',
    `defined_2` varchar(1024) DEFAULT '',
    `defined_3` varchar(1024) DEFAULT '',
    `merge_type` tinyint(1) DEFAULT '0',
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    PRIMARY KEY (`num_iid`),
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_store_id_numiid` (`store_id`,`num_iid`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_sys_item_id` (`sys_item_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  -- ----------------------------
  -- Table structure for tb_goods_sku
  -- 商品信息SKU表
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_sku`;
  CREATE TABLE `tb_goods_sku` (
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `sku_id` bigint(23) NOT NULL,
    `properties_name` varchar(1024) DEFAULT '',
    `num_iid` bigint(22) DEFAULT NULL,
    `short_title` varchar(64) DEFAULT '',
    `market` varchar(64) DEFAULT '',
    `factory` varchar(64) DEFAULT '',
    `goods_allocation` varchar(64) DEFAULT '',
    `actual_stock` bigint(11) DEFAULT NULL,
    `available_in_stock` bigint(11) DEFAULT NULL,
    `lock_stock` bigint(11) DEFAULT NULL,
    `defective_stock` bigint(11) DEFAULT NULL,
    `alarm_stock` bigint(11) DEFAULT NULL,
    `cost_price` double(11,0) DEFAULT NULL,
    `weight` double(11,0) DEFAULT NULL,
    `barcode` varchar(128) DEFAULT '',
    `pic_path` varchar(1024) DEFAULT '',
    `title` varchar(64) DEFAULT '',
    `outer_id` varchar(64) DEFAULT '',
    `num` bigint(11) DEFAULT NULL,
    `alarm` int(11) DEFAULT NULL,
    `remark` varchar(128) DEFAULT '',
    `type` varchar(128) DEFAULT '',
    `cat_id` varchar(2048) DEFAULT '',
    `sys_sku_id` bigint(18) DEFAULT NULL,
    `sku_warehouse_id` bigint(18) DEFAULT NULL,
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    PRIMARY KEY (`sku_id`),
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_store_id_numiid` (`store_id`,`num_iid`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_sys_sku_id` (`sys_sku_id`),
    KEY `inx_sku_warehouse_id` (`sku_warehouse_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  DROP TABLE IF EXISTS `tb_item_allocation`;
  CREATE TABLE `tb_item_allocation` (
    `id`                 BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `item_sku_id`        BIGINT(22) NOT NULL,
    `allocation_id`      DOUBLE(11, 2)          DEFAULT 0,
    `actual_stock`       BIGINT(11)             DEFAULT 0,
    `available_in_stock` BIGINT(11)             DEFAULT 0,
    `lock_stock`         BIGINT(11)             DEFAULT 0,
    `defective_stock`    BIGINT(11)             DEFAULT 0,
    `alarm_stock`        BIGINT(11)             DEFAULT 0,
    `alarm`              TINYINT(1)             DEFAULT 0,
    `quantity`           BIGINT(11)             DEFAULT 0,
    `goods_allocation`   VARCHAR(64)            DEFAULT "",
    `factory`            VARCHAR(64)            DEFAULT "",
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_item_sku_id` (`item_sku_id`),
    KEY `inx_allocation_id` (`allocation_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

  DROP TABLE IF EXISTS `tb_allocation`;
  CREATE TABLE `tb_allocation` (
    `id`            BIGINT(18) PRIMARY KEY AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `name`          VARCHAR(255)           DEFAULT "默认货位",
    `warehouse_id`  BIGINT(18) NOT NULL,
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

  DROP TABLE IF EXISTS `tb_warehouse`;
  CREATE TABLE `tb_warehouse` (
    `id`        BIGINT(18) PRIMARY KEY AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `name`      VARCHAR(255)           DEFAULT "默认仓储",
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

  DROP TABLE IF EXISTS `tb_item_supplier`;
  CREATE TABLE `tb_item_supplier` (
    `id`             BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `item_sku_id`    BIGINT(22) NOT NULL,
    `supplier_id`    DOUBLE(11, 2)          DEFAULT 0,
    `purchase_price` DOUBLE(11, 2)          DEFAULT 0,
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,

    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_supplier_id` (`supplier_id`),
    KEY `inx_item_sku_id`(`item_sku_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
  ALTER TABLE tb_item_supplier ADD `supplier_name` VARCHAR(128) DEFAULT "";
  ALTER TABLE tb_item_supplier ADD `type` TINYINT(1) NOT NULL;

  DROP TABLE IF EXISTS `tb_seller_cat`;
  CREATE TABLE `tb_seller_cat` (
    `id`                BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `pid`               BIGINT(20)    NOT NULL,
    `cid`               BIGINT(20)    NOT NULL,
    `parent_cid`        BIGINT(20)    NOT NULL,
    `type`              VARCHAR(32)   NULL,
    `name`              VARCHAR(128)  NOT NULL,
    `pic_url`           VARCHAR(2048) NOT NULL,
    `sort_order`        INT(10)       NOT NULL DEFAULT 1,
    `source_sort_order` INT(10)       NOT NULL DEFAULT 1,
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,

    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_store_id_cid` (`store_id`, `parent_cid`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 2  DEFAULT CHARSET = utf8;

  DROP TABLE IF EXISTS `tb_shop_seller_cat`;
  CREATE TABLE `tb_shop_seller_cat` (
    `id`             BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `association_id` BIGINT(20)             DEFAULT '-1',
    `source`         VARCHAR(32) NOT NULL   DEFAULT 'taobao',
    `is_local`       TINYINT     NOT NULL   DEFAULT 0,
    `sort_order`     INT(10)     NOT NULL   DEFAULT 1,
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_association_id` (`association_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8;

  -- ----------------------------
  -- Table structure for trade_trace
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_trade_trace`;
  CREATE TABLE `tb_trade_trace` (
    `id`            BIGINT(18) NOT NULL AUTO_INCREMENT,
    `company_id` bigint(22) DEFAULT NULL COMMENT '公司ID',
    `store_id` bigint(22) DEFAULT NULL COMMENT '门店ID',
    `tid`           BIGINT(20)          DEFAULT NULL,
    `action`        VARCHAR(64)         DEFAULT NULL,
    `operator`      VARCHAR(64)         DEFAULT NULL,
    `operate_time`  DATETIME            DEFAULT NULL,
    `content`       VARCHAR(128)        DEFAULT NULL,
    `created`        TIMESTAMP   NOT NULL   DEFAULT '2000-01-01 00:00:00',
    `modified`       TIMESTAMP   NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`  TINYINT(1)             DEFAULT 1,
    PRIMARY KEY (`id`),
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;