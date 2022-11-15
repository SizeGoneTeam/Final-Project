CREATE DATABASE IF NOT EXISTS dbbook;
use dbbook;

create table tbAccount(
MaTK int auto_increment primary key,
HoTen varchar(40),
Phone varchar(10),
Email varchar(50),
UName varchar(15) unique,
PWord varchar(20),
Tien double(15,2) default 0,
Sao float(2,1),
DateOfBirth date DEFAULT NULL,
NgayTao timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
isAdmin bit
);
create table tbPhienDauGia(
MaPhien int auto_increment primary key,
MaTK int,
LoaiPhien int,
MaSach int,
GiaKhoiDiem bigint,
GiaChot bigint,
NgayTao timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
NgayKetThuc timestamp default null,
ThoiGian int,
GiaGiam bigint,
ThoiGianGiam int,
GiaThapNhat bigint,
IsEnd bit default 0,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);
create table tbSach(
MaSach int auto_increment primary key,
TenSach varchar(120),
Anh varchar(200),
DonGia bigint,
TinhTrang VARCHAR(50),
MoTa text,
NguoiSoHuu int,
foreign key(NguoiSoHuu) references tbAccount(MaTK) ON DELETE CASCADE
);
-- Tạo thực thể Thể loại
create table tbTheLoai(
MaTheLoai int auto_increment primary key,
TenTheLoai varchar(50)
);

-- Tạo thực thể Thuộc thể loại
create table tbThuocTheLoai(
MaSach int,
MaTheLoai int,
primary key(MaSach,MaTheLoai),
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
foreign key(MaTheLoai) references tbTheLoai(MaTheLoai) ON DELETE CASCADE
);

-- Tạo thực thể Tác giả
create table tbTacGia(
MaTacGia int auto_increment primary key,
TenTacGia varchar(50)
);

-- Tạo thực thể Viết ( Tác Giả - Cuốn Sách)
create table tbViet(
MaTacGia int,
MaSach int,
primary key(MaTacGia,MaSach),
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
foreign key(MaTacGia) references tbTacGia(MaTacGia) ON DELETE CASCADE
);

CREATE TABLE tbTinhThanh  (
  ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  TinhThanh varchar(50) NOT NULL
);

create table tbDiaChiKH(
ID int NOT NULL AUTO_INCREMENT primary key,
MaTK int,
HoVaTen varchar(100),
SDT varchar(15),
DiaChi varchar(50),
TenPhuong varchar(50),
TenQuan varchar(50),
IDTinh int NULL DEFAULT NULL,
foreign key(MaTK) references tbAccount(MaTK),
foreign key(IDTinh) references tbTinhThanh(ID)
);

create table tbLichSuBid(
MaBid int auto_increment primary key,
MaTK int,
MaPhien int,
Bid bigint,
NgayTao timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
foreign key(MaPhien) references tbPhienDauGia(MaPhien) ON DELETE CASCADE,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);

create table tbLichSuXem(
MaTK int,
MaSach int,
NgayXem timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
primary key(MaTK,MaSach),
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);

create table tbYeuThich(
MaTK int,
MaSach int,
primary key(MaTK,MaSach),
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);

create table tbGiaoDich (
MaGD int auto_increment primary key,
NguoiGui INT NOT NULL,
NguoiNhan int not null,
-- 1. Nap | 2.Chuyen Tien |3. Rut
LoaiGD int not null,
TienGD double(15,2) default 0,
TienHoaHong double(15,2) default 0,
NgayTao timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
foreign key(NguoiGui) references tbAccount(MaTK) ON DELETE CASCADE,
foreign key(NguoiNhan) references tbAccount(MaTK) ON DELETE CASCADE
);

create table tbHoaDon(
MaHD int auto_increment primary key,
MaTK int,
MaGD int,
TienVC double(15,2) default 0,
TienSach double(15,2) default 0,
TienHD double(15,2) default 0,
foreign key(MaGD) references tbGiaoDich(MaGD) ON DELETE CASCADE,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);

create table tbChiTietHD(
MaCT int auto_increment,
MaHD int,
MaSach int,
GiaVC double(15,2) default 0,
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
foreign key(MaHD) references tbHoaDon(MaHD) ON DELETE CASCADE,
PRIMARY KEY(MaCT,MaHD)
);

CREATE TABLE tbGioHang(
MaTK int ,
MaSach int,
TrangThaiThanhToan int ,
NgayThem TIMESTAMP default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE,
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
PRIMARY KEY(MaTK,MaSach)
);


-- Nhập dữ liệu
SET FOREIGN_KEY_CHECKS = 0;

insert into tbAccount(UName,PWord)
values ("hai","hai123");
insert into tbAccount(UName,PWord)
values ("a","b");

insert into tbTheLoai(TenTheLoai) 
values
	("Sách Tiếng Việt"),("Sách văn học"),("Sách kinh tế"),("Sách thiếu nhi "),("Sách kỹ năng sống"),
    ("Sách Bà mẹ - Em bé"),("Sách Giáo Khoa - Giáo Trình"),("Sách Học Ngoại Ngữ"),("Sách Tham Khảo"),
    ("Từ Điển"),("Sách Kiến Thức Tổng Hợp"),("Sách Khoa Học - Kỹ Thuật"),("Sách Lịch sử"),("Điện Ảnh - Nhạc - Họa"),
    ("Truyện Tranh, Manga, Comic"),("Sách Tôn Giáo - Tâm Linh"),("Sách Văn Hóa - Địa Lý - Du Lịch"),
    ("Sách Chính Trị - Pháp Lý"),("Sách Nông - Lâm - Ngư Nghiệp"),("Sách Công Nghệ Thông Tin"),("Sách Y Học"),("Tạp Chí - Catalogue"),
    ("Sách Tâm lý - Giới tính"),("Sách Thường Thức - Gia Đình"),("Thể Dục - Thể Thao"),("Sách Tiếng Anh"),
    ("Art & Photography"),("Biographies & Memoirs"),("Business & Economics"),("How-to - Self Help"),("Children's Books"),
    ("Dictionary"),("Education - Teaching"),("Fiction - Literature"),("Magazines"),("Medical Books"),("Parenting & Relationships"),("Reference"),
    ("Science - Technology"),("History, Politics & Social Sciences"),("Travel & Holiday"),("Cookbooks, Food & Wine");
	
insert into tbThuocTheLoai(MaSach,MaTheLoai)
values
	(1,1),(1,2),
    (2,1),(2,2),
    (3,1),(3,2),
    (4,1),(4,3),
    (5,1),(5,3),
    (6,1),(6,3),
    (7,1),(7,4),
    (8,1),(8,4),
    (9,1),(9,4);
    
insert into tbTacGia(TenTacGia)
values
	("Frank Herbert"),("Paulo Coelho"),("Vladimir Nabokov"),("Morgan Housel"),("Napoleon Hill"),("Yann Martel"),("Luis Sepulveda"),("Antoine De Saint-Exupéry"),
    ("Kate DiCamillo");

insert into tbViet(MaTacGia,MaSach)
values
	(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9);

INSERT INTO `tbTinhThanh` VALUES (1, 'An Giang');
INSERT INTO `tbTinhThanh` VALUES (2, 'Bà Rịa - Vũng Tàu');
INSERT INTO `tbTinhThanh` VALUES (3, 'Bắc Giang');
INSERT INTO `tbTinhThanh` VALUES (4, 'Bắc Kạn');
INSERT INTO `tbTinhThanh` VALUES (5, 'Bạc Liêu');
INSERT INTO `tbTinhThanh` VALUES (6, 'Bắc Ninh');
INSERT INTO `tbTinhThanh` VALUES (7, 'Bến Tre');
INSERT INTO `tbTinhThanh` VALUES (8, 'Bình Định');
INSERT INTO `tbTinhThanh` VALUES (9, 'Bình Dương');
INSERT INTO `tbTinhThanh` VALUES (10, 'Bình Phước');
INSERT INTO `tbTinhThanh` VALUES (11, 'Bình Thuận');
INSERT INTO `tbTinhThanh` VALUES (12, 'Cà Mau');
INSERT INTO `tbTinhThanh` VALUES (13, 'Cần Thơ');
INSERT INTO `tbTinhThanh` VALUES (14, 'Cao Bằng');
INSERT INTO `tbTinhThanh` VALUES (15, 'Đà Nẵng');
INSERT INTO `tbTinhThanh` VALUES (16, 'Đắk Lắk');
INSERT INTO `tbTinhThanh` VALUES (17, 'Đắk Nông');
INSERT INTO `tbTinhThanh` VALUES (18, 'Điện Biên');
INSERT INTO `tbTinhThanh` VALUES (19, 'Đồng Nai');
INSERT INTO `tbTinhThanh` VALUES (20, 'Đồng Tháp');
INSERT INTO `tbTinhThanh` VALUES (21, 'Gia Lai');
INSERT INTO `tbTinhThanh` VALUES (22, 'Hà Giang');
INSERT INTO `tbTinhThanh` VALUES (23, 'Hà Nam');
INSERT INTO `tbTinhThanh` VALUES (24, 'Hà Nội');
INSERT INTO `tbTinhThanh` VALUES (25, 'Hà Tĩnh');
INSERT INTO `tbTinhThanh` VALUES (26, 'Hải Dương');
INSERT INTO `tbTinhThanh` VALUES (27, 'Hải Phòng');
INSERT INTO `tbTinhThanh` VALUES (28, 'Hậu Giang');
INSERT INTO `tbTinhThanh` VALUES (29, 'Hòa Bình');
INSERT INTO `tbTinhThanh` VALUES (30, 'Hưng Yên');
INSERT INTO `tbTinhThanh` VALUES (31, 'Khánh Hòa');
INSERT INTO `tbTinhThanh` VALUES (32, 'Kiên Giang');
INSERT INTO `tbTinhThanh` VALUES (33, 'Kon Tum');
INSERT INTO `tbTinhThanh` VALUES (34, 'Lai Châu');
INSERT INTO `tbTinhThanh` VALUES (35, 'Lâm Đồng');
INSERT INTO `tbTinhThanh` VALUES (36, 'Lạng Sơn');
INSERT INTO `tbTinhThanh` VALUES (37, 'Lào Cai');
INSERT INTO `tbTinhThanh` VALUES (38, 'Long An');
INSERT INTO `tbTinhThanh` VALUES (39, 'Nam Định');
INSERT INTO `tbTinhThanh` VALUES (40, 'Nghệ An');
INSERT INTO `tbTinhThanh` VALUES (41, 'Ninh Bình');
INSERT INTO `tbTinhThanh` VALUES (42, 'Ninh Thuận');
INSERT INTO `tbTinhThanh` VALUES (43, 'Phú Thọ');
INSERT INTO `tbTinhThanh` VALUES (44, 'Phú Yên');
INSERT INTO `tbTinhThanh` VALUES (45, 'Quảng Bình');
INSERT INTO `tbTinhThanh` VALUES (46, 'Quảng Nam');
INSERT INTO `tbTinhThanh` VALUES (47, 'Quảng Ngãi');
INSERT INTO `tbTinhThanh` VALUES (48, 'Quảng Ninh');
INSERT INTO `tbTinhThanh` VALUES (49, 'Quảng Trị');
INSERT INTO `tbTinhThanh` VALUES (50, 'Sóc Trăng');
INSERT INTO `tbTinhThanh` VALUES (51, 'Sơn La');
INSERT INTO `tbTinhThanh` VALUES (52, 'Tây Ninh');
INSERT INTO `tbTinhThanh` VALUES (53, 'Thái Bình');
INSERT INTO `tbTinhThanh` VALUES (54, 'Thái Nguyên');
INSERT INTO `tbTinhThanh` VALUES (55, 'Thanh Hóa');
INSERT INTO `tbTinhThanh` VALUES (56, 'Thừa Thiên Huế');
INSERT INTO `tbTinhThanh` VALUES (57, 'Tiền Giang');
INSERT INTO `tbTinhThanh` VALUES (58, 'Thành phố Hồ Chí Minh');
INSERT INTO `tbTinhThanh` VALUES (59, 'Trà Vinh');
INSERT INTO `tbTinhThanh` VALUES (60, 'Tuyên Quang');
INSERT INTO `tbTinhThanh` VALUES (61, 'Vĩnh Long');
INSERT INTO `tbTinhThanh` VALUES (62, 'Vĩnh Phúc');
INSERT INTO `tbTinhThanh` VALUES (63, 'Yên Bái');
    
    
SET FOREIGN_KEY_CHECKS = 1;

