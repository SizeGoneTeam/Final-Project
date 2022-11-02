use dbbook;

create table tbAccount(
MaTK int auto_increment primary key,
HoTen varchar(40),
Phone varchar(10),
Email varchar(20),
UName varchar(15) unique,
PWord varchar(20),
Tien double(10,3) default 0,
Sao float(2,1),
DateOfBirth date DEFAULT NULL,
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
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);
create table tbSach(
MaSach int auto_increment primary key,
TenSach varchar(120),
Anh varchar(200),
DonGia bigint,
MoTa text,
NguoiSoHuu int,
MaPhien_id int,
foreign key(NguoiSoHuu) references tbAccount(MaTK) ON DELETE CASCADE,
foreign key(MaPhien_id) references tbPhienDauGia(MaPhien) ON DELETE CASCADE
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

-- Tạo thực thể Nhà xuất bản
create table tbNXB(
MaNXB int auto_increment primary key,
TenNXB varchar(30)
);

-- Tạo thực thể Hợp tác (NXB - Tác Giả)
create table tbSanXuat(
MaSach int ,
MaNXB int,
primary key(MaSach,MaNXB),
foreign key(MaNXB) references tbNXB(MaNXB) ON DELETE CASCADE,
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE
);

create table tbDiaChiKH(
ID int NOT NULL AUTO_INCREMENT primary key,
MaTK int,
HoVaTen varchar(100),
SDT varchar(15),
DiaChi varchar(50),
TenPhuong varchar(50),
TenQuan varchar(50),
TenTP varchar(50),
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE
);

create table tbDiaDiem(
MaDD int auto_increment primary key,
TenQuan varchar(50)
);

Create table tbBangGia(
MaVC int auto_increment primary key,
MaGiao int,
MaNhan	int,
foreign key(MaGiao) references tbDiaDiem(MaDD) ON DELETE CASCADE,
foreign key(MaNhan) references tbDiaDiem(MaDD) ON DELETE CASCADE
);

create table tbThanhToan(
MaTT int auto_increment primary key,
PhuongThuc varchar(20),
NgayTT timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00'))
);

-- Tạo thực thể Hoá đơn
create table tbHoaDon(
MaHD int auto_increment primary key,
MaTK int,
MaSach int,
MaPhien int,
MaVC int,
MaTT int,
Gia double(10,3),
NgayTao timestamp default (CONVERT_TZ(NOW(),'+00:00','+7:00')),
foreign key(MaSach) references tbSach(MaSach) ON DELETE CASCADE,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE,
foreign key(MaPhien) references tbPhienDauGia(MaPhien) ON DELETE CASCADE,
foreign key(MaVC) references tbBangGia(MaVC) ON DELETE CASCADE,
foreign key(MaTT) references tbThanhToan(MaTT) ON DELETE CASCADE
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

create table tbNhanXet (
MaNX int auto_increment primary key,
MaTK INT NOT NULL,
TKbiDG int not null,
Sao float(2,1) NOT NULL,
NhanXet text,
foreign key(MaTK) references tbAccount(MaTK) ON DELETE CASCADE,
foreign key(TKbiDG) references tbAccount(MaTK) ON DELETE CASCADE
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
insert into tbSach(TenSach,Anh,DonGia,MoTa)
values
-- Sách văn học
	("Xứ Cát","https://salt.tikicdn.com/cache/750x750/ts/product/b4/f0/81/5d5e4a26cb029fdecd04e0c30cbef17a.jpg.webp",249000,"Sơ lược về tác phẩm

Một thời điểm rất xa trong tương lai…

Từ đời này sang đời khác, người Fremen trên hành tinh sa mạc lưu truyền lời tiên tri về một đấng cứu tinh sẽ dẫn dắt họ giành lấy tự do đích thực…

Từ thế hệ này sang thế hệ khác, những nữ phù thủy Bene Gesserit mỏi mòn chờ đợi sự xuất hiện của một B.G. nam giới duy nhất, người có thể vượt qua mọi giới hạn không gian - thời gian…

Là Lisal al-Gaib của người Fremen, là Kwisatz Haderach của học viện Bene Gesserit, chàng công tước trẻ tuổi Paul Atreides đã làm tất cả những gì có thể để thay đổi định mệnh đó. Cha bị giết chết, mẹ bị cho là kẻ phản bội, gia tộc bị tàn sát, bản thân bị săn đuổi đến đường cùng, Paul đơn độc dấn thân vào một cuộc phiêu lưu sinh tử, không hề biết rằng mỗi hành động của mình sẽ góp phần quyết định vận mệnh của cả thiên hà. Sa mạc Arrakis khắc nghiệt tưởng như sẽ là nơi chôn vùi vĩnh viễn vinh quang của gia tộc Atreides, nhưng hóa ra lại thành điểm khởi đầu cho một huyền thoại mới…

Là một trong những cuốn tiểu thuyết khoa học giả tưởng bán chạy nhất mọi thời đại, Xứ Cát không chỉ là lựa chọn đối với những tín đồ của Chúa nhẫn, Chiến tranh giữa các vì sao… mà còn chinh phục độc giả đủ mọi lứa tuổi, mọi tầng lớp và sở thích bởi sự đa dạng và phức tạp của con người và không gian trong truyện, bởi sự tinh tế trong xây dựng tâm lý, bởi sự hấp dẫn, căng thẳng và bất ngờ của cốt truyện, bởi sự độc đáo và thú vị của khối lượng kiến thức khổng lồ cũng như bởi sự hấp dẫn trong những tư tưởng về tôn giáo, về tự do, về tình yêu, về sự sống và cái chết…"),
    ("Nhà Giả Kim (Tái Bản 2020)","https://salt.tikicdn.com/cache/750x750/ts/product/45/3b/fc/aa81d0a534b45706ae1eee1e344e80d9.jpg.webp",79000,"Sơ lược về tác phẩm

Tất cả những trải nghiệm trong chuyến phiêu du theo đuổi vận mệnh của mình đã giúp Santiago thấu hiểu được ý nghĩa sâu xa nhất của hạnh phúc, hòa hợp với vũ trụ và con người.

Tiểu thuyết Nhà giả kim của Paulo Coelho như một câu chuyện cổ tích giản dị, nhân ái, giàu chất thơ, thấm đẫm những minh triết huyền bí của phương Đông. Trong lần xuất bản đầu tiên tại Brazil vào năm 1988, sách chỉ bán được 900 bản. Nhưng, với số phận đặc biệt của cuốn sách dành cho toàn nhân loại, vượt ra ngoài biên giới quốc gia, Nhà giả kim đã làm rung động hàng triệu tâm hồn, trở thành một trong những cuốn sách bán chạy nhất mọi thời đại, và có thể làm thay đổi cuộc đời người đọc.

“Nhưng nhà luyện kim đan không quan tâm mấy đến những điều ấy. Ông đã từng thấy nhiều người đến rồi đi, trong khi ốc đảo và sa mạc vẫn là ốc đảo và sa mạc. Ông đã thấy vua chúa và kẻ ăn xin đi qua biển cát này, cái biển cát thường xuyên thay hình đổi dạng vì gió thổi nhưng vẫn mãi mãi là biển cát mà ông đã biết từ thuở nhỏ. Tuy vậy, tự đáy lòng mình, ông không thể không cảm thấy vui trước hạnh phúc của mỗi người lữ khách, sau bao ngày chỉ có cát vàng với trời xanh nay được thấy chà là xanh tươi hiện ra trước mắt. ‘Có thể Thượng đế tạo ra sa mạc chỉ để cho con người biết quý trọng cây chà là,’ ông nghĩ.”"),
    ("Lolita (Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/4f/f1/1c/ceef76f6047793edc7bc122c3138189a.jpg.webp",128000,"“Lolita, ánh sáng của đời tôi, ngọn lửa nơi hạ bộ của tôi. Tội lỗi của tôi, tâm hồn của tôi. Lo-lee-ta: đầu lưỡi lướt xuống ba bước nhỏ dọc vòm miệng, khẽ đập vào răng ba tiếng. Lo. Li. Ta.
Buổi sáng, em là Lo, ngắn gọn là Lo thôi, đứng thẳng cao một mét bốn mươi sáu, chân đi độc một chiếc tất. Mặc quần thụng trong nhà, em là Lola. Ở trường học, em là Dolly. Trên dòng kẻ bằng những dấu chấm, em là Dolores. Nhưng trong vòng tay tôi, bao giờ em cũng là Lolita.”
Lolita, hiện tượng bất thường bậc nhất của văn chương thế kỷ 20, được xuất bản lần đầu vào năm 1955 tại Paris, mặc dù viết bằng tiếng Mĩ. Cũng như mọi tác phẩm kỳ vĩ và có độ lệch chuẩn lớn, như tiểu thuyết của D. H. Lawrence hay của Anthony Burgess, khởi đầu của Lolita không hề suôn sẻ.
Giờ đây khi thực sự được đọc Lolita, ta hiểu tại sao Vladimir Nabokov nâng niu nó đến vậy. Thoạt tiên bị nhìn nhận một cách giản đơn quá mức, Lolita dần thoát khỏi cái định kiến coi nó là tác phẩm thuần túy gợi dục, bởi Lolita chứa đựng nhiều, rất nhiều hơn thế: nó tinh vi dò xét tâm lý con người (dù không cần viện tới tâm phân học, mà thậm chí Nabokov còn luôn luôn tìm cách bài xích Sigmund Freud), và nó còn là những nước cờ ngôn từ kiệt xuất của một trong những thiên tài văn chương lớn nhất.
Đến giờ, dù cho bao năm tháng đã qua đi, Lolita vẫn cứ là một hiện tượng bất thường, và cô bé Lolita, “ánh sáng của đời tôi, tội lỗi của tôi, tâm hồn của tôi” trong trí tưởng của Humbert Humbert, vẫn bất tử trong dáng đứng thẳng cao chưa đầy một mét rưỡi và toàn bộ đặc tính của một “tiểu nữ thần” vĩnh viễn bất kham."),
-- Sách kinh tế
	("Tâm Lý Học Về Tiền","https://salt.tikicdn.com/cache/750x750/ts/product/83/23/b7/14a42ae4f66c9b8b298aaef4b9671442.jpg.webp",189000,"Tiền bạc có ở khắp mọi nơi, nó ảnh hưởng đến tất cả chúng ta, và khiến phần lớn chúng ta bối rối. Mọi người nghĩ về nó theo những cách hơi khác nhau một chút. Nó mang lại những bài học có thể được áp dụng tới rất nhiều lĩnh vực trong cuộc sống, như rủi ro, sự tự tin, và hạnh phúc. Rất ít chủ đề cung cấp một lăng kính phóng to đầy quyền lực giúp giải thích vì sao mọi người lại hành xử theo cách họ làm hơn là về tiền bạc. Đó mới là một trong những chương trình hoành tráng nhất trên thế giới.

Chúng ta hiếm khi lâm vào hoàn cảnh nợ ngập đầu ư? Biết tiết kiệm để dành cho lúc khốn khó hơn ư? Chuẩn bị sẵn sàng cho việc nghỉ hưu? Có những cái nhìn thiết thực về mối quan hệ giữa tiền và hạnh phúc của chúng ta hơn phải không?

Chúng ta đều làm những điều điên rồ với tiền bạc, bởi vì chúng ta đều còn khá mới mẻ với trò chơi này và điều có vẻ điên rồ với bạn lại có khi hợp lý với tôi. Nhưng không ai là điên rồ cả – chúng ta đều đưa ra các quyết định dựa trên những trải nghiệm độc đáo riêng có mang vẻ hợp lý với mình ở bất cứ thời điểm nào.

Mục đích của cuốn sách này là sử dụng những câu chuyện ngắn để thuyết phục bạn rằng những kỹ năng mềm còn quan trọng hơn khía cạnh lý thuyết của đồng tiền. Thông qua một tập hợp những thử nghiệm và sai lầm của nhiều năm chúng ta đã học được cách trở thành những nông dân giỏi giang hơn, những thợ sửa ống nước nhiều kỹ năng hơn, và những nhà hóa học tiên tiến hơn. Nhưng liệu việc thử nghiệm và sai lầm có dạy chúng ta trở nên giỏi hơn trong cách quản lý tài chính cá nhân của chính mình không?

Nhiều tiền không liên quan nhiều đến việc bạn thông minh như thế nào mà lại liên quan lớn đến cách bạn hành xử. Và cách hành xử thì rất khó để uốn nắn, ngay cả đối với những người thực sự thông minh.

Một thiên tài không kiểm soát được cảm xúc của anh ta có thể dẫn tới một thảm họa tài chính. Điều ngược lại cũng đúng. Những người bình thường không có kiến thức về tài chính có thể trở nên giàu có nếu họ nắm trong tay những kỹ năng hành xử không liên quan đến những thước đo chính thống về trí thông minh.

Sự thành công trong tài chính không phải là một lĩnh vực khoa học khó nhằn. Nó là một kỹ năng mềm, nơi mà cách bạn hành xử quan trọng hơn điều mà bạn biết. Trong “Tâm lý học về tiền”, tác giả từng đoạt giải thưởng Morgan Housel chia sẻ 19 câu chuyện ngắn khám phá những cách kỳ lạ mà mọi người nghĩ về tiền bạc và dạy bạn cách hiểu rõ hơn về một trong những chủ đề quan trọng nhất của cuộc sống."),
    ("Think And Grow Rich - Nghĩ Giàu Và Làm Giàu","https://salt.tikicdn.com/cache/750x750/ts/product/99/10/67/aa71f851071fc05bec537bec76dc4234.jpg.webp",110000,'"Think and Grow Rich –Nghĩ giàu và Làm giàu là một trong những cuốn sách bán chạy nhất mọi thời đại. Đã hơn 60 triệu bản được phát hành với gần trăm ngôn ngữ trên toàn thế giới và được công nhận là cuốn sách tạo ra nhiều triệu phú, một cuốn sách truyền cảm hứng thành công nhiều hơn bất cứ cuốn sách kinh doanh nào trong lịch sử.

Tác phẩm này đã giúp tác giả của nó, Napoleon Hill, được tôn vinh bằng danh hiệu “người tạo ra những nhà triệu phú”. Đây cũng là cuốn sách hiếm hoi được đứng trong top của rất nhiều bình chọn theo nhiều tiêu chí khác nhau - bình chọn của độc giả, của giới chuyên môn, của báo chí. Lý do để Think and Grow Rich - Nghĩ giàu và làm giàu có được vinh quang này thật hiển nhiên và dễ hiểu: Bằng việc đọc và áp dụng những phương pháp đơn giản, cô đọng này vào đời sống của mỗi cá nhân mà đã có hàng ngàn người trên thế giới trở thành triệu phú và thành công bền vững.

Điều thú vị nhất là các bí quyết này có thể được hiểu và áp dụng bởi bất kỳ một người bình thường nào, hoạt động trong bất cứ lĩnh vực nào. Qua hơn 70 năm tồn tại, những đúc kết về thành công của Napoleon Hill đến nay vẫn không hề bị lỗi thời, ngược lại, thời gian chính là minh chứng sống động cho tính đúng đắn của những bí quyết mà ông chia sẻ.

Sinh ra trong một gia đình nghèo vùng Tây Virginia, con đường thành công của Napoleon Hill cũng trải qua nhiều thăng trầm. Khởi đầu bằng chân cộng tác viên cho một tờ báo địa phương lúc 15 tuổi, đến năm 19 tuổi Hill trở thành nhà quản lý mỏ than trẻ tuổi nhất, sau đó bỏ ngang để theo đuổi ngành luật. Napoleon Hill còn kinh qua nhiều nghề như kinh doanh gỗ, xe hơi, viết báo về kinh doanh…

Đó là những công việc ông từng nếm trải trước khi 25 tuổi! Song khác với những người thành đạt khác, ông cẩn thận phân tích từng sự kiện trọng đại trong đời mình, rút ra những bài học, rồi tiếp tục rút gọn chúng thành các nguyên tắc căn bản, tổ chức các nguyên tắc ấy thành triết lý sống và rèn luyệ

Cơ hội đặc biệt đã đến với Hill trong một lần phỏng vấn để viết về chân dung Andrew Carnegie - ông “vua thép” huyền thoại của Mỹ đã đi lên từ hai bàn tay trắng. Từ lần phỏng vấn đó, Napoleon Hill có dịp tiếp cận với những con người thành đạt và có quyền lực nhất tại Mỹ để tìm hiểu và học hỏi những bí quyết thành công của họ, trong thế so sánh và kiểm chứng với những công thức thành công của Andrew Carnegie. Ông muốn qua đó có thể đúc kết và viết nên một cuốn sách ghi lại những bí quyết giúp các cá nhân bình thường thành những người thành công trong xã hội.

Để thực hiện cuốn sách này, Napoleon Hill dành hầu như toàn bộ thời gian và công sức trong suốt gần ba mươi năm để phỏng vấn hơn 500 người nổi tiếng và thành công nhất trong nhiều lĩnh vực khác nhau, cùng hàng ngàn doanh nhân khác - cả những kẻ thất bại và những người thành công. Kết quả của những nghiên cứu không mệt mỏi đó là Think and Grow Rich - Nghĩ giàu và làm giàu - công thức, hay “cẩm nang” để trở thành vượt trội và được xã hội nể trọng.

Cuốn sách cũng đưa Napoleon Hill vào danh sách một trong những tác giả có tác phẩm bán chạy nhất thế giới từ trước đến nay. Được viết ra từ vô số những câu chuyện có thật, tác phẩm có một sức thuyết phục và lay động rất lớn. Bạn không chỉ được biết bí quyết về sự thành công của các tên tuổi như Edison - nhà phát minh lỗi lạc mà thời gian rèn luyện trong trường học chỉ… vỏn vẹn 3 tháng; như Henry Ford - người bị coi là không có học vấn nhưng đã trở thành ông trùm trong nền công nghiệp xe hơi với một gia tài kếch xù… mà còn của rất nhiều cá nhân trong nhiều lĩnh vực khác nhau đã đi lên từ con số không.

Think and Grow Rich - Nghĩ giàu và làm giàu là cuốn sách đầu tiên đưa ra triết lý thành đạt - một triết lý đầy đủ và toàn diện về thành công của cá nhân, đồng thời cung cấp cho bạn phương pháp để tạo một ý thức thành công cũng như đưa ra kế hoạch sơ bộ và chi tiết để đạt được thành công đó. Các bí quyết thành công được đề cập đến trong cuốn sách này có thể được đúc kết ngắn gọn: tất cả bắt nguồn từ cách nghĩ.

Do đó, cuốn sách này không chỉ thay đổi những điều bạn nghĩ mà còn có thể thay đổi cả cách nghĩ của bạn; không dừng lại ở việc chỉ ra cho bạn thấy bạn phải làm gì mà còn vạch cho bạn biết phải làm điều đó như thế nào để đạt được khát vọng của mình. Ra mắt bạn đọc với phiên bản cao cấp lần này, cuốn sách thay đổi nhiều về hình thức thiết kế bìa cứng, màu nâu đen, chữ vàng ánh kim dập nổi sang trọng, tinh tế.'),
   ("Cuộc Đời Của Pi ( Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/68/d6/6f/ef7298bf99e9dc6de5f7162666d6e972.jpg.webp",110000,'"Mọi việc ở đời có bao giờ diễn ra như ta vẫn tưởng, nhưng biết làm sao. Cuộc đời đem cho ta cái gì thì ta phải nhận cái đó và chỉ còn cách làm cho chúng tốt đẹp nhất mà thôi."

Cuộc đời của Pi mở đầu với lời chào ấn tượng của tác giả, Yan Martel và hành trình tưởng như bế tắc khi ông mò mẫm đi tìm một câu chuyện cho sự nghiệp của mình. Lời chào ngắn ngủi ấy giúp người đọc hình dung được hoàn cảnh ra đời của cuốn sách và chẳng cần thắc mắc gì nhiều đến bối cảnh của câu chuyện. Và như thế, một Ấn Độ từ những năm 60, 70 của thế kỷ trước sống dậy cùng Pi, cùng vườn thú Poddicherry và cùng những ngày thơ ấu rối rắm và kỳ lạ.

Piscine Molitor Patel, hay bị gọi nhầm thành Pissing cho đến khi cậu tự đặt cho mình biệt danh Pi - con số 3,14 huyền thoại. Ngẫu nhiên thay, cái tên ấy cùng những biến cố sau này đã biến cuộc đời Pi trở thành huyền thoại. Mà ngay cả nếu không phải huyền thoại thì Pi đã là một cậu bé kỳ lạ, đứa trẻ lớn lên cùng những người bạn trong vườn thú và có niềm tin mạnh mẽ vào Thượng đế. Chắc hẳn trên thế giới này, Pi là cậu bé duy nhất theo đến ba tôn giáo: Hindu, đạo Hồi và đạo Cơ đốc. Trong con người Pi, tôn giáo cũng như dân tộc, như quốc tịch và nếu như chúng ta đều tôn thờ Thượng đế thì tại sao lại không thể tin theo nhiều đạo.

Gandhi đã dạy, mọi tín ngưỡng đều là chân lý. Tôn giáo là để giúp chúng ta giữ được nhân phẩm của mình chứ không phải để hạ nhục nó.

Sự thật đã chứng minh rằng chính niềm tin tôn giáo có phần kỳ dị trong mắt người khác ấy của Pi đã giúp cậu sống sót và tồn tại mà vẫn giữ được sự tỉnh táo, thông minh và cứng rắn sau biến cố tưởng như có thể vắt kiệt mọi sinh mạng sống.

Piscine Molitor Patel, tên thường gọi là Pi, quốc tịch Ấn Độ, là người sống sót duy nhất trong vụ đắm tàu Tsimtsum ngày 2 tháng 7 năm 1977, đã lênh đênh trên biển suốt 227 ngày với xuồng cứu hộ và một con hổ Bengal tên là Richard Parker. Nói như Ravi - anh trai của Pi, thì là "Phiêu lưu đang vẫy gọi", chỉ có điều 227 ngày phiêu lưu này cũng là 227 ngày đấu tranh và giành giật sự sống trên bề mặt mênh mông của Thái Bình Dương.

Cuộc Đời Của Pi là một cuốn sách nhỏ, không quá dày và không nổi bật với bìa sách màu xanh biển mênh mông có đàn cá làm nền cho chiếc xuồng cứu hộ. Pi và Richard Parker nằm trên hai đầu của chiếc xuồng ấy, lặng lẽ và tuyệt vọng với cái chết rình rập quanh mình.

"Lí do sự chết cứ bám riết lấy sự sống như vậy ko phải là vì nhu cầu sinh học - đó là sự ghen tị. Sự sống đẹp đến nỗi sự chết đã phải lòng nó, một mối tình tư vị đầy ghen tuông quắp chặt lấy bất cứ thứ gì nó có thể động đến."

Pi và Richard Parker tồn tại bên nhau, duy trì sự sống cho nhau và khuất phục nhau. Pi cho Richard Parker đồ ăn, thức uống để sống. Richard Parker cho Pi lý do để không buông mình tuyệt vọng nhưng cũng chẳng hề hi vọng (thật khó để giữ cho mình hy vọng sau chuỗi ngày dài cô đơn trên biển cả mờ mịt). Cứ thế, cặp đôi đồng hành lăn qua lăn lại giữa lằn ranh sống chết, quật qua quăng lại giữa bão biển và những cơn đói mặn chát... để trở về và chia ly không một lời từ biệt.

Cuộc Đời Của Pi, hay đúng hơn, là câu chuyện Pi Patel tự thuật về cuộc đời mình và Yan Martel là người ghi lại cảm xúc, hành động, khát vọng sống,... Trong câu chuyện ấy không có phép lạ, không có điều kỳ diệu, Pi chỉ có đức tin và lời cầu nguyện để giữ lại cái phần người cho chính mình.

"Khi chính cuộc sống của ta bị đe dọa, ý thức thương cảm bị cùn đi bởi một thèm khát sống đầy ích kỷ". Và, trong một phiên bản nhân hóa đáng tin hơn thì câu chuyện của Pi kỳ lạ, hoang đường, trần trụi đến tàn khốc khi mô tả bản năng của con người qua hình ảnh những con vật. Nhân hóa ấy hợp nhất Pi - một cậu bé ăn chay 16 tuổi với đức tin vào Thượng đế, cầu nguyện ba lần một ngày - với Richard Parker - một con hổ Bengal nặng 450 pound mạnh mẽ, tàn bạo và hoang dã.

Khi trang sách khép lại, những gì còn lại cho người đọc hẳn không nhiều, bởi, câu chuyện về sinh tồn trong tuyệt vọng vốn không còn xa lạ trong phim ảnh, sách báo nữa. Yan Martel đã hoàn thành trọng trách của một người kể chuyện, còn Pi - đã trưởng thành và sống hạnh phúc cùng gia đình nhỏ của mình - không còn là huyền thoại xa vời mà chỉ như một dấu ấn mờ mịt trong muôn ngàn sinh mạng đang tồn tại trên thế giới này. Đến cuối cùng, đâu là thực, đâu là ảo giác? - Chắc chẳng quan trọng nữa rồi. Pi vẫn sống cùng niềm tin đa tôn giáo, cùng triết lý kỳ lạ về con người và sự sống, cùng gia đình nhỏ bên người vợ xinh đẹp và hai đứa con - Một cái kết có hậu cho người đã mất đi tất cả trong cuộc phiêu lưu đáng sợ nhất đời mình.

Giải thưởng: Giải Man Booker năm 2002. Giải thưởng văn học dịch Hội Nhà văn Hà Nội. Giải thưởng văn học dịch Hội Nhà văn Việt Nam

Sau vụ đắm tàu bi thảm, Pi, cậu bé 16 tuổi con một giám đốc sở thú cùng gia đình đi Canada, thấy mình là kẻ sống sót duy nhất trên một chiếc xuồng cứu nạn nhỏ bé dập dềnh giữa Thái Bình Dương. Cùng với một con ngựa vằn đau khổ (gẫy một chân), một con linh cẩu lông đốm độc ác liên tục kêu yip yip, một con đười ươi cái nôn ọe vì say sóng  và đặc biệt một con hổ Bengal nặng 450 pound, Pi đã lang thang trên đại dương suốt 227 ngày, hy vọng rồi tuyệt vọng, trải qua những điều hài hước nhất, kinh khủng nhất, hoang tưởng nhất, đáng sợ nhất...mà một con người có thể gặp trong đời. Trí tưởng tượng không giới hạn, vốn hiểu biết dày dặn, sự trải nghiệm sâu rộng, nghệ thuật kể chuyện bậc thầy, đó là những yếu tố đã giúp Yann Martel viết nên một trong những cuốn sách đáng đọc nhất của  văn học thế giới đương đại.

"Cuộc đời của Pi là hắc ảo thuật song hành cùng hiện thực, một ngụ ngôn tinh tế và công phu  về đức tin dưới nhiều tầng lớp" - Irish Time

"Nếu thế kỷ này sản sinh ra một tác phẩm kinh điển để lại cho hậu thế, Martel là một ứng cử viên nặng ký" - The Nation

"Những người nào tin rằng nghệ thuật hư cấu đang hấp hối hãy để họ đọc  Yann Martel cho họ mở rõ con mắt" - Canongate

"Có một chút gì như là truyện biển, lướt nhẹ qua chủ nghĩa hiện thực huyền ảo, còn lại tràn đầy là thiên tài kể chuyện đã làm nên tiểu thuyết của Martel"

Giá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Bên cạnh đó, tuỳ vào loại sản phẩm, hình thức và địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, thuế nhập khẩu (đối với đơn hàng giao từ nước ngoài có giá trị trên 1 triệu đồng).....'),
-- Sách thiếu nhi
	("Chuyện Con Mèo Dạy Hải Âu Bay (Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/ac/80/ef/2f8c27f60797dfc4c729b03b1272403b.jpg.webp",49000,'Cô hải âu Kengah bị nhấn chìm trong váng dầu – thứ chất thải nguy hiểm mà những con người xấu xa bí mật đổ ra đại dương. Với nỗ lực đầy tuyệt vọng, cô bay vào bến cảng Hamburg và rơi xuống ban công của con mèo mun, to đùng, mập ú Zorba. Trong phút cuối cuộc đời, cô sinh ra một quả trứng và con mèo mun hứa với cô sẽ thực hiện ba lời hứa chừng như không tưởng với loài mèo:
Không ăn quả trứng.
Chăm sóc cho tới khi nó nở.
Dạy cho con hải âu bay.
Lời hứa của một con mèo cũng là trách nhiệm của toàn bộ mèo trên bến cảng, bởi vậy bè bạn của Zorba bao gồm ngài mèo Đại Tá đầy uy tín, mèo Secretario nhanh nhảu, mèo Einstein uyên bác, mèo Bốn Biển đầy kinh nghiệm đã chung sức giúp nó hoàn thành trách nhiệm. Tuy nhiên, việc chăm sóc, dạy dỗ một con hải âu đâu phải chuyện đùa, sẽ có hàng trăm rắc rối nảy sinh và cần có những kế hoạch đầy linh hoạt được bàn bạc kỹ càng…
Chuyện con mèo dạy hải âu bay là kiệt tác dành cho thiếu nhi của nhà văn Chi Lê nổi tiếng Luis Sepúlveda – tác giả của cuốn Lão già mê đọc truyện tình đã bán được 18 triệu bản khắp thế giới. Tác phẩm không chỉ là một câu chuyện ấm áp, trong sáng, dễ thương về loài vật mà còn chuyển tải thông điệp về trách nhiệm với môi trường, về sự sẻ chia và yêu thương cũng như ý nghĩa của những nỗ lực – “Chỉ những kẻ dám mới có thể bay”.
Cuốn sách mở đầu cho mùa hè với minh họa dễ thương, hài hước là món quà dành cho mọi trẻ em và người lớn.'),
    ("Hoàng Tử Bé (Tái Bản 2019)","https://salt.tikicdn.com/cache/750x750/ts/product/5c/e7/68/26838e18d7f96d562d828980520019d2.jpg.webp",75000,'Hoàng tử bé được viết ở New York trong những ngày tác giả sống lưu vong và được xuất bản lần đầu tiên tại New York vào năm 1943, rồi đến năm 1946 mới được xuất bản tại Pháp. Không nghi ngờ gì, đây là tác phẩm nổi tiếng nhất, được đọc nhiều nhất và cũng được yêu mến nhất của Saint-Exupéry. Cuốn sách được bình chọn là tác phẩm hay nhất thế kỉ 20 ở Pháp, đồng thời cũng là cuốn sách Pháp được dịch và được đọc nhiều nhất trên thế giới. Với 250 ngôn ngữ dịch khác nhau kể cả phương ngữ cùng hơn 200 triệu bản in trên toàn thế giới, Hoàng tử bé được coi là một trong những tác phẩm bán chạy nhất của nhân loại.

Ở Việt Nam, Hoàng tử bé được dịch và xuất bản khá sớm. Từ năm 1966 đã có đồng thời hai bản dịch: Hoàng tử bé của Bùi Giáng do An Tiêm xuất bản và Cậu hoàng con của Trần Thiện Đạo do Khai Trí xuất bản. Từ đó đến nay đã có thêm nhiều bản dịch Hoàng tử bé mới của các dịch giả khác nhau. Bản dịch Hoàng tử bé lần này, xuất bản nhân dịp kỷ niệm 70 năm Hoàng tử bé ra đời, cũng là ấn bản đầu tiên được Gallimard chính thức chuyển nhượng bản quyền tại Việt Nam, hy vọng sẽ góp phần làm phong phú thêm việc dịch và tiếp nhận tác phẩm quan trọng này với các thế hệ độc giả.

Tôi cứ sống cô độc như vậy, chẳng có một ai để chuyện trò thật sự, cho tới một lần gặp nạn ở sa mạc Sahara cách đây sáu năm. Có thứ gì đó bị vỡ trong động cơ máy bay. Và vì ở bên cạnh chẳng có thợ máy cũng như hành khách nào nên một mình tôi sẽ phải cố mà sửa cho bằng được vụ hỏng hóc nan giải này. Với tôi đó thật là một việc sống còn. Tôi chỉ có vừa đủ nước để uống trong tám ngày.

Thế là đêm đầu tiên tôi ngủ trên cát, cách mọi chốn có người ở cả nghìn dặm xa. Tôi cô đơn hơn cả một kẻ đắm tàu sống sót trên bè giữa đại dương. Thế nên các bạn cứ tưởng tượng tôi đã ngạc nhiên làm sao, khi ánh ngày vừa rạng, thì một giọng nói nhỏ nhẹ lạ lùng đã đánh thức tôi. Giọng ấy nói:
“Ông làm ơn… vẽ cho tôi một con cừu!”
- Trích "Hoàng tử bé"'),
	("Chuyến Phiêu Lưu Diệu Kỳ Của Edward Tulane (Tái Bản 2019)","https://salt.tikicdn.com/cache/w1200/ts/product/7a/84/df/a39d0c6791709883529a84c688eed944.jpg",80000,'Ngày xưa, trong ngôi nhà trên phố Ai Cập, có một chú thỏ bằng sứ tên là Edward Tulane. Chú được làm ra bởi một người chế tác đồ chơi bậc thầy, được mặc trên người những bộ quần áo tuyệt hảo đặt may riêng.Chú vô cùng ngưỡng mộ và đề cao bản thân, không màng tới cô chủ Abilene đang vô cùng nâng niu chú. Thế nhưng, trên chuyến đi lênh đênh vượt đại dương, một thằng bé đã vô tình quăng chú khỏi mạn tàu. Và từ đó, hành trình lưu lạc của Edward bắt đầu. 

Một chú thỏ bằng sứ có thể đi tới những đâu?

Một chú thỏ bằng sứ có thể sống và yêu như thế nào?

Tình yêu mang vị gì?

Nếu là vị đau, chú có còn nên tiếp tục thương yêu?

Tất cả đã được trả lời với một bút pháp đầy chất thơ trong Chuyến phiêu lưu diệu kỳ của Edward Tulane. Có thể nói rằng, kể từ Bởi vì Winn-Dixie cho tới câu chuyện về thỏ sứ Edward Tulane, Kate Di Camillo cũng vượt qua một hành trình phi thường để giành trọn say mê và mở rộng trái tim cho độc giả.tbSach');
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
    
insert into tbAccount(UName,PWord)
values ("hai","hai123");
insert into tbAccount(UName,PWord)
values ("a","b");


