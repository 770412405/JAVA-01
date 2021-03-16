CREATE TABLE `t_order_0`  (
                              `order_no` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
                              `user_id` int(11) NOT NULL COMMENT '下单人id',
                              `product_id` int(11) NOT NULL COMMENT '商品id',
                              `receipt_address_id` int(11) NOT NULL COMMENT '收货地址id',
                              `order_amount` decimal(10, 2) NOT NULL COMMENT '订单金额',
                              `status` varchar(16) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '订单状态(待支付、已支付、已取消、已退款、已收货)',
                              `order_pay_time` bigint(20) NOT NULL DEFAULT 0 COMMENT '支付时间',
                              `delete_status` varchar(16) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '删除状态(未删除、已删除、彻底删除)',
                              `order_snapshot` int(11) NOT NULL COMMENT '订单快照',
                              `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                              `create_person` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人',
                              `update_person` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人',
                              PRIMARY KEY (`order_no`) USING BTREE,
                              INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2000001 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

CREATE TABLE `t_order_1`  (
                              `order_no` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
                              `user_id` int(11) NOT NULL COMMENT '下单人id',
                              `product_id` int(11) NOT NULL COMMENT '商品id',
                              `receipt_address_id` int(11) NOT NULL COMMENT '收货地址id',
                              `order_amount` decimal(10, 2) NOT NULL COMMENT '订单金额',
                              `status` varchar(16) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '订单状态(待支付、已支付、已取消、已退款、已收货)',
                              `order_pay_time` bigint(20) NOT NULL DEFAULT 0 COMMENT '支付时间',
                              `delete_status` varchar(16) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '删除状态(未删除、已删除、彻底删除)',
                              `order_snapshot` int(11) NOT NULL COMMENT '订单快照',
                              `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                              `create_person` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人',
                              `update_person` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人',
                              PRIMARY KEY (`order_no`) USING BTREE,
                              INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2000001 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;