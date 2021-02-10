﻿DROP DATABASE IF EXISTS `service_user`;
CREATE DATABASE `service_user` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin;

USE `service_user`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id          BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '用户编号',
    username    VARCHAR(50)  NOT NULL COMMENT '用户名',
    password    VARCHAR(255) NOT NULL COMMENT '密码',
    phone       VARCHAR(18)  NOT NULL COMMENT '手机号码',
    email       VARCHAR(100) NOT NULL COMMENT '邮箱',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '更新时间',
    is_deleted  BOOLEAN      NOT NULL DEFAULT FALSE COMMENT '是否已删除',
    CONSTRAINT uk_username UNIQUE (username) COMMENT '用户名是唯一的',
    CONSTRAINT uk_phone UNIQUE (phone) COMMENT '手机号码是唯一的',
    CONSTRAINT uk_email UNIQUE (email) COMMENT '邮箱是唯一的'
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_bin COMMENT '用户表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    id            BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '角色编号',
    user_id       BIGINT UNSIGNED NOT NULL COMMENT '用户编号',
    permission_id BIGINT UNSIGNED NOT NULL COMMENT '权限编号',
    create_time   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
    update_time   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '更新时间',
    is_deleted    BOOLEAN         NOT NULL DEFAULT FALSE COMMENT '是否已删除',
    CONSTRAINT uk_user_permission_id UNIQUE (user_id, permission_id) COMMENT '一个用户对同一个权限只允许出现一次'
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_bin COMMENT '角色表';

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`
(
    id          BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '权限编号',
    name        VARCHAR(50) NOT NULL COMMENT '权限名称',
    resource    VARCHAR(50) NOT NULL COMMENT '资源',
    action      VARCHAR(8)  NOT NULL COMMENT '动作',
    create_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
    update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '更新时间',
    is_deleted  BOOLEAN     NOT NULL DEFAULT FALSE COMMENT '是否已删除',
    CONSTRAINT uk_name UNIQUE (name) COMMENT '权限名称是唯一的'
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_bin COMMENT '权限表';

COMMIT;