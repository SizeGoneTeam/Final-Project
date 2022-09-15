
create table tbSach(
MaSach int auto_increment primary key,
TenSach nvarchar(120),
Anh nvarchar(200),
DonGia int,
SoLuong int
);
-- Tạo thực thể Thể loại
create table tbTheLoai(
MaTheLoai int auto_increment primary key,
TenTheLoai nvarchar(50)
);

-- Tạo thực thể Thuộc thể loại
create table tbThuocTheLoai(
MaSach int,
MaTheLoai int,
primary key(MaSach,MaTheLoai),
foreign key(MaSach) references tbSach(MaSach),
foreign key(MaTheLoai) references tbTheLoai(MaTheLoai)
);

-- Tạo thực thể Tác giả
create table tbTacGia(
MaTacGia int auto_increment primary key,
TenTacGia nvarchar(50)
);

-- Tạo thực thể Viết ( Tác Giả - Cuốn Sách)
create table tbViet(
MaTacGia int,
MaSach int,
primary key(MaTacGia,MaSach),
foreign key(MaSach) references tbSach(MaSach),
foreign key(MaTacGia) references tbTacGia(MaTacGia)
);

-- Tạo thực thể Nhà xuất bản
create table tbNXB(
MaNXB int auto_increment primary key,
TenNXB nvarchar(30)
);

-- Tạo thực thể Hợp tác (NXB - Tác Giả)
create table tbSanXuat(
MaSach int ,
MaNXB int,
primary key(MaSach,MaNXB),
foreign key(MaNXB) references tbNXB(MaNXB),
foreign key(MaSach) references tbSach(MaSach)
);
-- Tạo thực thể Khách hàng
create table tbAccount(
MaKH int auto_increment primary key,
TenKH nvarchar(20),
DiaChi nvarchar(50),
Phone nvarchar(10),
Email nvarchar(20),
TK nvarchar(15),
MK nvarchar(20),
isAdmin int
);
-- Tạo thực thể Hoá đơn
create table tbHoaDon(
MaHD int auto_increment primary key,
NgayTao datetime,
MaKH int,
TongTien int,
foreign key(MaKH) references tbAccount(MaKH)
);

-- Tạo thực thể Chi tiết hoá đơn
create table tbChiTietHD(
MaHD int auto_increment,
MaSach int,
SoLuong int,
DonGia int,
primary key (MaHD,MaSach),
foreign key(MaHD) references tbHoaDon(MaHD),
foreign key(MaSach) references tbSach(MaSach)
);

-- Tạo thực thể Giỏ hàng
create table tbGioHang(
MaGioHang int auto_increment primary key,
MaSach int,
DonGia int,
SoLuong int,
foreign key(MaSach) references tbSach(MaSach)
);

-- Nhập dữ liệu
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
insert into tbSach(TenSach,Anh,DonGia,SoLuong)
values
-- Sách văn học
	("Xứ Cát","https://salt.tikicdn.com/cache/750x750/ts/product/b4/f0/81/5d5e4a26cb029fdecd04e0c30cbef17a.jpg.webp",249000,10),
    ("Nhà Giả Kim (Tái Bản 2020)","https://salt.tikicdn.com/cache/750x750/ts/product/45/3b/fc/aa81d0a534b45706ae1eee1e344e80d9.jpg.webp",79000,10),
    ("Lolita (Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/4f/f1/1c/ceef76f6047793edc7bc122c3138189a.jpg.webp",128000,10),
-- Sách kinh tế
	("Tâm Lý Học Về Tiền","https://salt.tikicdn.com/cache/750x750/ts/product/83/23/b7/14a42ae4f66c9b8b298aaef4b9671442.jpg.webp",189000,10),
    ("Think And Grow Rich - Nghĩ Giàu Và Làm Giàu","https://salt.tikicdn.com/cache/750x750/ts/product/99/10/67/aa71f851071fc05bec537bec76dc4234.jpg.webp",110000,10),
    ("Cuộc Đời Của Pi ( Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/68/d6/6f/ef7298bf99e9dc6de5f7162666d6e972.jpg.webp",110000,10),
-- Sách thiếu nhi
	("Chuyện Con Mèo Dạy Hải Âu Bay (Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/ac/80/ef/2f8c27f60797dfc4c729b03b1272403b.jpg.webp",49000,10),
    ("Hoàng Tử Bé (Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/5c/e7/68/26838e18d7f96d562d828980520019d2.jpg.webp",75000,10),
	("Chuyến Phiêu Lưu Diệu Kỳ Của Edward Tulane (Tái Bản 2019)","https://salt.tikicdn.com/cache/w1200/ts/product/7a/84/df/a39d0c6791709883529a84c688eed944.jpg",80000,10);

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
    
insert into tbNXB(TenNXB)
values
	("Nhà Xuất Bản Hội Nhà Văn"),("Nhà Xuất Bản Hà Nội"),("	Nhà Xuất Bản Dân Trí"),("Nhà Xuất Bản Tổng hợp TP.HCM"),("Nhà Xuất Bản Văn Học"),
    ("Nhà Xuất Bản Mỹ Thuật");
    
insert into tbSanXuat(MaSach,MaNXB)
values
	(1,1),(2,2),(3,1),(4,3),(5,4),(6,5),(7,1),(8,1),(9,6);