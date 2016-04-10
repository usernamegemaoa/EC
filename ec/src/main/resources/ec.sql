-- clean database

DROP DATABASE IF EXISTS `productsdb`;

-- create database

CREATE DATABASE IF NOT EXISTS `productsdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `productsdb`;

-- add table

CREATE TABLE IF NOT EXISTS `product` (
    `product_id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(128) NOT NULL,
    `description` varchar(512) NOT NULL,
    `price` float NOT NULL,
    PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS `rbac_role` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色表ID',
    `name` VARCHAR(64) NOT NULL COMMENT '角色名',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `rbac_user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `account` VARCHAR(64) NOT NULL COMMENT '账号',
    `password` VARCHAR(64) NOT NULL COMMENT '密码',
    `salt` VARCHAR(64) NOT NULL COMMENT '盐',
    `name` VARCHAR(64) NOT NULL COMMENT '店铺名或昵称',
    `email` VARCHAR(64) NULL COMMENT '邮箱',
    `birthday` DATETIME NULL COMMENT '生日',
    `icon` VARCHAR(255) NULL COMMENT '头像',
    `score` INT(11) NOT NULL DEFAULT '0' COMMENT '分数',
    `male` INT(11) NOT NULL DEFAULT '0' COMMENT '性别',
    PRIMARY KEY (`id`),
    UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `rbac_user_role` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联id',
    `user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
    FOREIGN KEY (`role_id`) REFERENCES `rbac_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `rbac_path` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '路径id',
    `path` VARCHAR(64) NOT NULL COMMENT '网页路径',
    PRIMARY KEY (`id`),
    UNIQUE KEY `path` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网页路径表' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `rbac_role_path` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色路径关联id',
    `role_id` INT(11) NOT NULL,
    `path_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`role_id`) REFERENCES `rbac_role` (`id`),
    FOREIGN KEY (`path_id`) REFERENCES `rbac_path` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色路径关联表' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `address` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
    `user_id` INT(11) NOT NULL COMMENT '顾客id',
    `place_code` INT(11) NOT NULL COMMENT '邮编',
    `place_name` VARCHAR(64) NOT NULL COMMENT '地址',
    `people` VARCHAR(64) NOT NULL COMMENT '收件人姓名',
    `phone` VARCHAR(64) NOT NULL COMMENT '收件人电话',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址信息' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `kind` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
    `father_id` INT(11) NOT NULL COMMENT '父类id',
    `name` VARCHAR(64) COMMENT '分类名',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类信息' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `good` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `kind_id` INT(11) NOT NULL COMMENT '分类id',
    `shop_id` INT(11) NOT NULL COMMENT '店主id',
    `name` VARCHAR(64) NOT NULL COMMENT '商品名',
    `good_num` VARCHAR(64) NOT NULL COMMENT '货号',
    `description` TEXT NOT NULL COMMENT '描述',
    `price` INT(11) NOT NULL COMMENT '价格',
    `deliver_info` TEXT NOT NULL COMMENT '送货信息',
    `return_info` TEXT NOT NULL COMMENT '退款相关',
    `time` TIMESTAMP NOT NULL COMMENT '上架时间',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`kind_id`) REFERENCES `kind` (`id`),
    FOREIGN KEY (`shop_id`) REFERENCES `rbac_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `stock` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '库存id',
    `good_id` INT(11) NOT NULL COMMENT '商品id',
    `size` VARCHAR(11) NOT NULL COMMENT '尺寸',
    `color` VARCHAR(11) NOT NULL COMMENT '颜色',
    `quantity` INT(11) NOT NULL COMMENT '数量',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`good_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存信息' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `picture` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
    `good_id` INT(11) NOT NULL COMMENT '商品id',
    `name` VARCHAR(255) NOT NULL COMMENT '图片名',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`good_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='描述图片' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `comment` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
    `good_id` INT(11) NOT NULL COMMENT '商品id',
    `user_id` INT(11) NOT NULL COMMENT '顾客id',
    `score` INT(11) NOT NULL COMMENT '好中差评',
    `content` TEXT NOT NULL COMMENT '评价内容',
    `time` TIMESTAMP NOT NULL COMMENT '评论时间',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`good_id`) REFERENCES `good` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `sub_comment` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
    `comment_id` INT(11) NOT NULL COMMENT '父评论id',
    `user_id` INT(11) NOT NULL COMMENT '用户id',
    `content` TEXT NOT NULL COMMENT '评价内容',
    `time` TIMESTAMP NOT NULL COMMENT '评论时间',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
    FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价回复' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `consult` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
    `good_id` INT(11) NOT NULL COMMENT '商品id',
    `user_id` INT(11) NOT NULL COMMENT '顾客id',
    `content` TEXT NOT NULL COMMENT '评价内容',
    `time` TIMESTAMP NOT NULL COMMENT '评论时间',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`good_id`) REFERENCES `good` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨询' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `sub_consult` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '咨询id',
    `consult_id` INT(11) NOT NULL COMMENT '父咨询id',
    `user_id` INT(11) NOT NULL COMMENT '用户id',
    `content` TEXT NOT NULL COMMENT '咨询内容',
    `time` TIMESTAMP NOT NULL COMMENT '咨询时间',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
    FOREIGN KEY (`consult_id`) REFERENCES `consult` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨询回复' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `message` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '消息id',
    `type` INT(11) NOT NULL COMMENT '消息类别',
    `is_read` INT(11) NOT NULL COMMENT '已读标签',
    `content` TEXT NOT NULL COMMENT '消息内容',
    `time` TIMESTAMP NOT NULL COMMENT '时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `collect` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '收藏id',
    `good_id` INT(11) NOT NULL COMMENT '商品id',
    `user_id` INT(11) NOT NULL COMMENT '用户id',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
    FOREIGN KEY (`good_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `plan` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '进货单id',
    `stock_id` INT(11) NOT NULL COMMENT '库存id',
    `user_id` INT(11) NOT NULL COMMENT '用户id',
    `quantity` INT(11) NOT NULL COMMENT '数量',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
    FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进货单' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `order` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `user_id` INT(11) NOT NULL COMMENT '用户id',
    `shop_id` INT(11) NOT NULL COMMENT '店主id',
    `state` INT(11) NOT NULL COMMENT '订单状态',
    `is_read` INT(11) NOT NULL COMMENT '已读标签',
    `time` TIMESTAMP NOT NULL COMMENT '时间',
    `place_code` INT(11) NOT NULL COMMENT '邮编',
    `place_name` VARCHAR(64) NOT NULL COMMENT '地址',
    `people` VARCHAR(64) NOT NULL COMMENT '收件人姓名',
    `phone` VARCHAR(64) NOT NULL COMMENT '收件人电话',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
    FOREIGN KEY (`shop_id`) REFERENCES `rbac_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `order_info` (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '详情id',
    `good_id` INT(11) NOT NULL COMMENT '商品id',
    `size` VARCHAR(11) NOT NULL COMMENT '尺寸',
    `color` VARCHAR(11) NOT NULL COMMENT '颜色',
    `quantity` INT(11) NOT NULL COMMENT '数量',
    `price` INT(11) NOT NULL COMMENT '单价',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`good_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情' AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `place` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '地点id',
	`place_code` INT(11) NOT NULL COMMENT '代号',
	`place_name` VARCHAR(64) NOT NULL COMMENT '地名',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单' AUTO_INCREMENT=1 ;
