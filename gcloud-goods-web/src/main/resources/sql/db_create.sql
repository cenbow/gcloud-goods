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
    `taobao_id` bigint(22) DEFAULT NULL,
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
    `created` datetime DEFAULT NULL,
    `modified` timestamp NULL DEFAULT NULL,
    `enable_status` tinyint(1) DEFAULT '1',
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
    `status` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`num_iid`),
    KEY `taobao_id` (`taobao_id`),
    KEY `taobao_id_numiid` (`taobao_id`,`num_iid`),
    KEY `taobao_id_2` (`taobao_id`,`created`),
    KEY `taobao_id_3` (`taobao_id`,`modified`),
    KEY `taobao_id_4` (`taobao_id`,`outer_id`),
    KEY `sys_item_id` (`sys_item_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  -- ----------------------------
  -- Table structure for tb_goods_sku
  -- 商品信息SKU表
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_sku`;
  CREATE TABLE `tb_goods_sku` (
    `taobao_id` bigint(22) DEFAULT NULL,
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
    `created` datetime DEFAULT NULL,
    `modified` timestamp NULL DEFAULT NULL,
    `enable_status` tinyint(1) DEFAULT '1',
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
    `status` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`sku_id`),
    KEY `taobao_id` (`taobao_id`),
    KEY `taobao_id_2` (`taobao_id`,`num_iid`),
    KEY `sys_sku_id` (`sys_sku_id`),
    KEY `sku_warehouse_id` (`sku_warehouse_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;