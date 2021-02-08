
DROP DATABASE IF EXISTS ``;
CREATE DATABASE `` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin;

DROP TABLE IF EXISTS ``;
CREATE TABLE ``
(
  id          BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '编号',

  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '更新时间',
  is_deleted  BOOLEAN      NOT NULL DEFAULT FALSE COMMENT '是否已删除',
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_bin COMMENT '表';

SET PERSIST autocommit = 0;
SET PERSIST TRANSACTION ISOLATION LEVEL READ COMMITTED;