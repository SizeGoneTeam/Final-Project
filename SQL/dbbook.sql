/*
 Navicat Premium Data Transfer

 Source Server         : aws
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : database-2.cuhigonpnglj.ap-southeast-1.rds.amazonaws.com:3306
 Source Schema         : dbbook

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 21/11/2022 10:42:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbAccount
-- ----------------------------
DROP TABLE IF EXISTS `tbAccount`;
CREATE TABLE `tbAccount`  (
  `MaTK` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `UName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `PWord` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Tien` double(15, 2) NULL DEFAULT 0.00,
  `Sao` float(2, 1) NULL DEFAULT NULL,
  `DateOfBirth` date NULL DEFAULT NULL,
  `NgayTao` timestamp(0) NULL ,
  `isAdmin` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`MaTK`) USING BTREE,
  UNIQUE INDEX `UName`(`UName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbAnh
-- ----------------------------
DROP TABLE IF EXISTS `tbAnh`;
CREATE TABLE `tbAnh`  (
  `MaAnh` int NOT NULL AUTO_INCREMENT,
  `MaSach` int NULL DEFAULT NULL,
  `Anh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaAnh`) USING BTREE,
  INDEX `MaSach`(`MaSach`) USING BTREE,
  CONSTRAINT `tbAnh_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbChiTietHD
-- ----------------------------
DROP TABLE IF EXISTS `tbChiTietHD`;
CREATE TABLE `tbChiTietHD`  (
  `MaCT` int NOT NULL AUTO_INCREMENT,
  `MaHD` int NOT NULL,
  `MaGD` int NULL DEFAULT NULL,
  `MaSach` int NULL DEFAULT NULL,
  `GiaVC` double(15, 2) NULL DEFAULT 0.00,
  PRIMARY KEY (`MaCT`) USING BTREE,
  INDEX `MaSach`(`MaSach`) USING BTREE,
  INDEX `MaHD`(`MaHD`) USING BTREE,
  INDEX `MaGD`(`MaGD`) USING BTREE,
  CONSTRAINT `tbChiTietHD_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbChiTietHD_ibfk_2` FOREIGN KEY (`MaHD`) REFERENCES `tbHoaDon` (`MaHD`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbChiTietHD_ibfk_3` FOREIGN KEY (`MaGD`) REFERENCES `tbGiaoDich` (`MaGD`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbDiaChiKH
-- ----------------------------
DROP TABLE IF EXISTS `tbDiaChiKH`;
CREATE TABLE `tbDiaChiKH`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MaTK` int NULL DEFAULT NULL,
  `HoVaTen` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `SDT` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TenPhuong` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TenQuan` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TenTP` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `IDTinh` int NULL DEFAULT NULL,
  `MacDinh` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `MaTK`(`MaTK`) USING BTREE,
  INDEX `IDTinh`(`IDTinh`) USING BTREE,
  CONSTRAINT `tbDiaChiKH_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tbDiaChiKH_ibfk_2` FOREIGN KEY (`IDTinh`) REFERENCES `tbTinhThanh` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbGiaoDich
-- ----------------------------
DROP TABLE IF EXISTS `tbGiaoDich`;
CREATE TABLE `tbGiaoDich`  (
  `MaGD` int NOT NULL AUTO_INCREMENT,
  `NguoiGui` int NOT NULL,
  `NguoiNhan` int NOT NULL,
  `LoaiGD` int NOT NULL,
  `TienGD` double(15, 2) NULL DEFAULT 0.00,
  `TienHoaHong` double(15, 2) NULL DEFAULT 0.00,
  `NgayTao` timestamp(0) NULL,
  PRIMARY KEY (`MaGD`) USING BTREE,
  INDEX `NguoiGui`(`NguoiGui`) USING BTREE,
  INDEX `NguoiNhan`(`NguoiNhan`) USING BTREE,
  CONSTRAINT `tbGiaoDich_ibfk_1` FOREIGN KEY (`NguoiGui`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbGiaoDich_ibfk_2` FOREIGN KEY (`NguoiNhan`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbGioHang
-- ----------------------------
DROP TABLE IF EXISTS `tbGioHang`;
CREATE TABLE `tbGioHang`  (
  `MaTK` int NOT NULL,
  `MaSach` int NOT NULL,
  `TrangThaiThanhToan` int NULL DEFAULT NULL,
  `NgayThem` timestamp(0) NULL,
  PRIMARY KEY (`MaTK`, `MaSach`) USING BTREE,
  INDEX `MaSach`(`MaSach`) USING BTREE,
  CONSTRAINT `tbGioHang_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbGioHang_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbHoaDon
-- ----------------------------
DROP TABLE IF EXISTS `tbHoaDon`;
CREATE TABLE `tbHoaDon`  (
  `MaHD` int NOT NULL AUTO_INCREMENT,
  `MaTK` int NULL DEFAULT NULL,
  `NgayTao` timestamp(0) NULL ,
  PRIMARY KEY (`MaHD`) USING BTREE,
  INDEX `MaTK`(`MaTK`) USING BTREE,
  CONSTRAINT `tbHoaDon_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbLichSuBid
-- ----------------------------
DROP TABLE IF EXISTS `tbLichSuBid`;
CREATE TABLE `tbLichSuBid`  (
  `MaBid` int NOT NULL AUTO_INCREMENT,
  `MaTK` int NULL DEFAULT NULL,
  `MaPhien` int NULL DEFAULT NULL,
  `Bid` double(15, 2) NULL DEFAULT NULL,
  `NgayTao` timestamp(0) NULL ,
  PRIMARY KEY (`MaBid`) USING BTREE,
  INDEX `MaPhien`(`MaPhien`) USING BTREE,
  INDEX `MaTK`(`MaTK`) USING BTREE,
  CONSTRAINT `tbLichSuBid_ibfk_1` FOREIGN KEY (`MaPhien`) REFERENCES `tbPhienDauGia` (`MaPhien`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbLichSuBid_ibfk_2` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 212 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbLichSuXem
-- ----------------------------
DROP TABLE IF EXISTS `tbLichSuXem`;
CREATE TABLE `tbLichSuXem`  (
  `MaTK` int NOT NULL,
  `MaSach` int NOT NULL,
  `NgayXem` timestamp(0) NULL ,
  PRIMARY KEY (`MaTK`, `MaSach`) USING BTREE,
  INDEX `MaSach`(`MaSach`) USING BTREE,
  CONSTRAINT `tbLichSuXem_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbLichSuXem_ibfk_2` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbPhienDauGia
-- ----------------------------
DROP TABLE IF EXISTS `tbPhienDauGia`;
CREATE TABLE `tbPhienDauGia`  (
  `MaPhien` int NOT NULL AUTO_INCREMENT,
  `MaTK` int NULL DEFAULT NULL,
  `LoaiPhien` int NULL DEFAULT NULL,
  `MaSach` int NULL DEFAULT NULL,
  `GiaKhoiDiem` double(15, 2) NULL DEFAULT NULL,
  `GiaChot` double(15, 2) NULL DEFAULT NULL,
  `NgayTao` timestamp(0) NULL ,
  `NgayKetThuc` timestamp(0) NULL DEFAULT NULL,
  `ThoiGian` int NULL DEFAULT NULL,
  `GiaGiam` double(15, 2) NULL DEFAULT NULL,
  `ThoiGianGiam` int NULL DEFAULT NULL,
  `GiaThapNhat` double(15, 2) NULL DEFAULT NULL,
  `IsEnd` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`MaPhien`) USING BTREE,
  INDEX `MaTK`(`MaTK`) USING BTREE,
  CONSTRAINT `tbPhienDauGia_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbSach
-- ----------------------------
DROP TABLE IF EXISTS `tbSach`;
CREATE TABLE `tbSach`  (
  `MaSach` int NOT NULL AUTO_INCREMENT,
  `TenSach` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Anh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `DonGia` double(15, 2) NULL DEFAULT NULL,
  `TinhTrang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `MoTa` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `NguoiSoHuu` int NULL DEFAULT NULL,
  PRIMARY KEY (`MaSach`) USING BTREE,
  INDEX `NguoiSoHuu`(`NguoiSoHuu`) USING BTREE,
  CONSTRAINT `tbSach_ibfk_1` FOREIGN KEY (`NguoiSoHuu`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbTacGia
-- ----------------------------
DROP TABLE IF EXISTS `tbTacGia`;
CREATE TABLE `tbTacGia`  (
  `MaTacGia` int NOT NULL AUTO_INCREMENT,
  `TenTacGia` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaTacGia`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbTheLoai
-- ----------------------------
DROP TABLE IF EXISTS `tbTheLoai`;
CREATE TABLE `tbTheLoai`  (
  `MaTheLoai` int NOT NULL AUTO_INCREMENT,
  `TenTheLoai` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaTheLoai`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbThuocTheLoai
-- ----------------------------
DROP TABLE IF EXISTS `tbThuocTheLoai`;
CREATE TABLE `tbThuocTheLoai`  (
  `MaSach` int NOT NULL,
  `MaTheLoai` int NOT NULL,
  PRIMARY KEY (`MaSach`, `MaTheLoai`) USING BTREE,
  INDEX `MaTheLoai`(`MaTheLoai`) USING BTREE,
  CONSTRAINT `tbThuocTheLoai_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbThuocTheLoai_ibfk_2` FOREIGN KEY (`MaTheLoai`) REFERENCES `tbTheLoai` (`MaTheLoai`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbTinhThanh
-- ----------------------------
DROP TABLE IF EXISTS `tbTinhThanh`;
CREATE TABLE `tbTinhThanh`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TinhThanh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbViet
-- ----------------------------
DROP TABLE IF EXISTS `tbViet`;
CREATE TABLE `tbViet`  (
  `MaTacGia` int NOT NULL,
  `MaSach` int NOT NULL,
  PRIMARY KEY (`MaTacGia`, `MaSach`) USING BTREE,
  INDEX `MaSach`(`MaSach`) USING BTREE,
  CONSTRAINT `tbViet_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbViet_ibfk_2` FOREIGN KEY (`MaTacGia`) REFERENCES `tbTacGia` (`MaTacGia`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbYeuThich
-- ----------------------------
DROP TABLE IF EXISTS `tbYeuThich`;
CREATE TABLE `tbYeuThich`  (
  `MaTK` int NOT NULL,
  `MaSach` int NOT NULL,
  PRIMARY KEY (`MaTK`, `MaSach`) USING BTREE,
  INDEX `MaSach`(`MaSach`) USING BTREE,
  CONSTRAINT `tbYeuThich_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `tbSach` (`MaSach`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbYeuThich_ibfk_2` FOREIGN KEY (`MaTK`) REFERENCES `tbAccount` (`MaTK`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
