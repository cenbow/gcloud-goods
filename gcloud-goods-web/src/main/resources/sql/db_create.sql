  CREATE DATABASE IF NOT EXISTS gcloud_goods;
  USE gcloud_goods;
  SET FOREIGN_KEY_CHECKS = 0;

  -- ----------------------------
  -- Table structure for tb_goods_spu
  -- 商品信息SPU表
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_spu`;
  CREATE TABLE `tb_goods_spu` (

    `id`            BIGINT(30)   NOT NULL COMMENT '商品SPU表主键',
    `company_id`    BIGINT(30)   NOT NULL COMMENT '公司ID',
    `store_id`      BIGINT(30)   NOT NULL COMMENT '门店ID',
    `goods_spu`     BIGINT(30)   NOT NULL COMMENT '商品SPU',
    `goods_name`    VARCHAR(64)  DEFAULT '' COMMENT '商品名称',
    `short_name`    VARCHAR(64)  DEFAULT '' COMMENT '商品简称',
    `barcode`       VARCHAR(128) DEFAULT '' COMMENT '条形码',
    `pic_path`      VARCHAR(250) DEFAULT '' COMMENT '商品图片',
    `goods_out_spu` VARCHAR(30)  DEFAULT '' COMMENT '商品SPU(外部系统)',

    `cat_id`        VARCHAR(30)   DEFAULT '' COMMENT '商品类目',
    `brand`         VARCHAR(128)  DEFAULT '' COMMENT '商品品牌',
    `props_name`    VARCHAR(1024) DEFAULT '' COMMENT '商品属性',
    `props_alias`   VARCHAR(1024) DEFAULT '' COMMENT '商品属性别名',
    `sale_props`    VARCHAR(1024) DEFAULT '' COMMENT '销售属性',
    `binds_props`   VARCHAR(1024) DEFAULT '' COMMENT '商品属性(非关键)',
    `customer_props`VARCHAR(1024) DEFAULT '' COMMENT '商品属性(用户自定义)',
    `status`        TINYINT(2)    DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `on_sale`       TINYINT(2)    DEFAULT NULL COMMENT '是否在线销售 0否 1是',
    `platform`      VARCHAR(12)   DEFAULT NULL COMMENT '平台信息',
    `remark`        VARCHAR(128)  DEFAULT '' COMMENT '备注',
    `created`       TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status` TINYINT(1)  NOT NULL DEFAULT 1,
    PRIMARY KEY (`goods_spu`),
    KEY `inx_company` (`company_id`),
    KEY `inx_store` (`store_id`),
    KEY `inx_company_store` (`company_id`,`store_id`),
    KEY `inx_store_spu` (`store_id`,`goods_spu`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_goods_sku
  -- 商品信息SKU表
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_sku`;
  CREATE TABLE `tb_goods_sku` (

    `id`            BIGINT(30)   NOT NULL COMMENT '商品SKU表主键',
    `company_id`    BIGINT(30)   NOT NULL COMMENT '公司ID',
    `store_id`      BIGINT(30)   NOT NULL COMMENT '门店ID',
    `goods_spu`     BIGINT(30)   NOT NULL COMMENT '商品SPU',
    `goods_sku`     BIGINT(30)   NOT NULL   COMMENT '商品SKU',
    `goods_out_spu` VARCHAR(30)  DEFAULT '' COMMENT '商品SPU(外部系统)',
    `goods_out_sku` VARCHAR(30)  DEFAULT '' COMMENT '商品外部系统ID',
    `goods_name`    VARCHAR(64)  DEFAULT '' COMMENT '商品名称',
    `short_name`    VARCHAR(64)  DEFAULT '' COMMENT '商品简称',
    `barcode`       VARCHAR(128) DEFAULT '' COMMENT '条形码',
    `pic_path`      VARCHAR(250) DEFAULT '' COMMENT '商品图片',
    `props_name`    VARCHAR(1024) DEFAULT '' COMMENT '商品属性',
    `cost_price`    DOUBLE(12,2) DEFAULT 0 COMMENT '成本价',
    `sell_price`    DOUBLE(12,2) DEFAULT 0 COMMENT '销售价',
    `retail_price`  DOUBLE(12,2) DEFAULT 0 COMMENT '零售价',
    `member_price`  DOUBLE(12,2) DEFAULT 0 COMMENT '会员价',
    `special_price` DOUBLE(12,2) DEFAULT 0 COMMENT '特价',
    `weight`        DOUBLE(12,2) DEFAULT 0 COMMENT '重量',
    `unit`          VARCHAR(250) DEFAULT 0 COMMENT '单位',
    `remark`        VARCHAR(128) DEFAULT '' COMMENT '备注',
    `created`       TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status` TINYINT(1)  NOT NULL DEFAULT 1,
    PRIMARY KEY (`goods_sku`),
    KEY `inx_company` (`company_id`),
    KEY `inx_store` (`store_id`),
    KEY `inx_store_spu` (`store_id`,`goods_spu`),
    KEY `inx_company_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_goods_stock
  -- 商品库存信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_stock`;
  CREATE TABLE `tb_goods_stock` (

    `id`                 BIGINT(30) PRIMARY KEY AUTO_INCREMENT,
    `company_id`         BIGINT(30) DEFAULT NULL COMMENT '公司ID',
    `store_id`           BIGINT(30) DEFAULT NULL COMMENT '门店ID',
    `item_sku_id`        BIGINT(30) NOT NULL  COMMENT '商品SKU',
    `warehouse_id`       BIGINT(30) DEFAULT 0 COMMENT '仓库ID',
    `actual_stock`       BIGINT(11) DEFAULT 0 COMMENT '实际库存',
    `available_stock`    BIGINT(11) DEFAULT 0 COMMENT '闲置库存',
    `lock_stock`         BIGINT(11) DEFAULT 0 COMMENT '锁定库存',
    `defective_stock`    BIGINT(11) DEFAULT 0 COMMENT '缺陷库存',
    `alarm_stock`        BIGINT(11) DEFAULT 0 COMMENT '警告库存',
    `quantity`           BIGINT(11) DEFAULT 0 COMMENT '销售数量',
    `created`       TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status` TINYINT(1)  NOT NULL DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`),
    KEY `inx_item_sku_id` (`item_sku_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_warehouse
  -- 仓库信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_warehouse`;
  CREATE TABLE `tb_warehouse` (
    `id`             BIGINT(30)   PRIMARY KEY AUTO_INCREMENT,
    `company_id`     BIGINT(30)   DEFAULT NULL COMMENT '公司ID',
    `store_id`       BIGINT(30)   DEFAULT NULL COMMENT '门店ID',
    `warehouse_id`   BIGINT(30)   DEFAULT NULL COMMENT '仓库ID',
    `name`           VARCHAR(255) DEFAULT "默认仓储" COMMENT '默认仓储',
    `address`        VARCHAR(255) DEFAULT '' COMMENT '仓库地址',
    `location`       VARCHAR(255) DEFAULT '' COMMENT '高德地址（经纬度）',
    `created`       TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status` TINYINT(1)  NOT NULL DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;
