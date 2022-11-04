package TinhTien;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.math.BigInteger;
import java.util.*;

public class GiaoHang {

   
    public GiaoHang() {
    }

    /**
     * Tìm đường ngắn nhất từ start tới target
     * Phương thức nhận 2 tham số
     *
     * @param start  đỉnh bắt đầu
     * @param target đỉnh đích
     */
    public BigInteger dijkstra(int start, int target) {
        BigInteger a = new BigInteger("0");
        Vert vAnGiang = new Vert("AnGiang");
        Vert vBaRiaVungTau = new Vert("BaRiaVungTau");
        Vert vBacGiang = new Vert("BacGiang");
        Vert vBacKan = new Vert("BacKan");
        Vert vBacLieu = new Vert("BacLieu");
        Vert vBacNinh = new Vert("BacNinh");
        Vert vBenTre = new Vert("BenTre");
        Vert vBinhDinh = new Vert("BinhDinh");
        Vert vBinhDuong = new Vert("BinhDuong");
        Vert vBinhPhuoc = new Vert("BinhPhuoc");
        Vert vBinhThuan = new Vert("BinhThuan");
        Vert vCaMau = new Vert("CaMau");
        Vert vCanTho = new Vert("CanTho");
        Vert vCaoBang = new Vert("CaoBang");
        Vert vDaNang = new Vert("DaNang");
        Vert vDakLak = new Vert("DakLak");
        Vert vDakNong = new Vert("DakNong");
        Vert vDienBien = new Vert("DienBien");
        Vert vDongNai = new Vert("DongNai");
        Vert vDongThap = new Vert("DongThap");
        Vert vGiaLai = new Vert("GiaLai");
        Vert vHaGiang = new Vert("HaGiang");
        Vert vHaNam = new Vert("HaNam");
        Vert vHaNoi = new Vert("HaNoi");
        Vert vHaTinh = new Vert("HaTinh");
        Vert vHaiDuong = new Vert("HaiDuong");
        Vert vHaiPhong = new Vert("HaiPhong");
        Vert vHauGiang = new Vert("HauGiang");
        Vert vHoaBinh = new Vert("HoaBinh");
        Vert vHungYen = new Vert("HungYen");
        Vert vKhanhHoa = new Vert("KhanhHoa");
        Vert vKienGiang = new Vert("KienGiang");
        Vert vKonTum = new Vert("KonTum");
        Vert vLaiChau = new Vert("LaiChau");
        Vert vLamDong = new Vert("LamDong");
        Vert vLangSon = new Vert("LangSon");
        Vert vLaoCai = new Vert("LaoCai");
        Vert vLongAn = new Vert("LongAn");
        Vert vNamDinh = new Vert("NamDinh");
        Vert vNgheAn = new Vert("NgheAn");
        Vert vNinhBinh = new Vert("NinhBinh");
        Vert vNinhThuan = new Vert("NinhThuan");
        Vert vPhuTho = new Vert("PhuTho");
        Vert vPhuYen = new Vert("PhuYen");
        Vert vQuangBinh = new Vert("QuangBinh");
        Vert vQuangNam = new Vert("QuangNam");
        Vert vQuangNgai = new Vert("QuangNgai");
        Vert vQuangNinh = new Vert("QuangNinh");
        Vert vQuangTri = new Vert("QuangTri");
        Vert vSocTrang = new Vert("SocTrang");
        Vert vSonLa = new Vert("SonLa");
        Vert vTayNinh = new Vert("TayNinh");
        Vert vThaiBinh = new Vert("ThaiBinh");
        Vert vThaiNguyen = new Vert("ThaiNguyen");
        Vert vThanhHoa = new Vert("ThanhHoa");
        Vert vThuaThienHue = new Vert("ThuaThienHue");
        Vert vTienGiang = new Vert("TienGiang");
        Vert vThanhphoHoChiMinh = new Vert("ThanhphoHoChiMinh");
        Vert vTraVinh = new Vert("TraVinh");
        Vert vTuyenQuang = new Vert("TuyenQuang");
        Vert vVinhLong = new Vert("VinhLong");
        Vert vVinhPhuc = new Vert("VinhPhuc");
        Vert vYenBai = new Vert("YenBai");

        
        vAnGiang.addNeighbour(new Edge(1, vAnGiang, vKienGiang));
        vAnGiang.addNeighbour(new Edge(1, vAnGiang, vCanTho));
        vAnGiang.addNeighbour(new Edge(1, vAnGiang, vDongThap));
        vBaRiaVungTau.addNeighbour(new Edge(1, vBaRiaVungTau, vThanhphoHoChiMinh));
        vBaRiaVungTau.addNeighbour(new Edge(1, vBaRiaVungTau, vDongNai));
        vBaRiaVungTau.addNeighbour(new Edge(1, vBaRiaVungTau, vBinhThuan));
        vBacGiang.addNeighbour(new Edge(1, vBacGiang, vLangSon));
        vBacGiang.addNeighbour(new Edge(1, vBacGiang, vQuangNinh));
        vBacGiang.addNeighbour(new Edge(1, vBacGiang, vHaiDuong));
        vBacGiang.addNeighbour(new Edge(1, vBacGiang, vBacNinh));
        vBacGiang.addNeighbour(new Edge(1, vBacGiang, vHaNoi));
        vBacGiang.addNeighbour(new Edge(1, vBacGiang, vThaiNguyen));
        vBacKan.addNeighbour(new Edge(1, vBacKan, vCaoBang));
        vBacKan.addNeighbour(new Edge(1, vBacKan, vTuyenQuang));
        vBacKan.addNeighbour(new Edge(1, vBacKan, vThaiNguyen));
        vBacKan.addNeighbour(new Edge(1, vBacKan, vLangSon));
        vBacLieu.addNeighbour(new Edge(1, vBacLieu, vKienGiang));
        vBacLieu.addNeighbour(new Edge(1, vBacLieu, vHauGiang));
        vBacLieu.addNeighbour(new Edge(1, vBacLieu, vSocTrang));
        vBacLieu.addNeighbour(new Edge(1, vBacLieu, vCaMau));
        vBacNinh.addNeighbour(new Edge(1, vBacNinh, vHaNoi));
        vBacNinh.addNeighbour(new Edge(1, vBacNinh, vBacGiang));
        vBacNinh.addNeighbour(new Edge(1, vBacNinh, vHaiDuong));
        vBacNinh.addNeighbour(new Edge(1, vBacNinh, vHungYen));
        vBenTre.addNeighbour(new Edge(1, vBenTre, vTienGiang));
        vBenTre.addNeighbour(new Edge(1, vBenTre, vVinhLong));
        vBenTre.addNeighbour(new Edge(1, vBenTre, vTraVinh));
        vBinhDinh.addNeighbour(new Edge(1, vBinhDinh, vPhuYen));
        vBinhDinh.addNeighbour(new Edge(1, vBinhDinh, vGiaLai));
        vBinhDinh.addNeighbour(new Edge(1, vBinhDinh, vQuangNgai));
        vBinhDuong.addNeighbour(new Edge(1, vBinhDuong, vTayNinh));
        vBinhDuong.addNeighbour(new Edge(1, vBinhDuong, vBinhPhuoc));
        vBinhDuong.addNeighbour(new Edge(1, vBinhDuong, vThanhphoHoChiMinh));
        vBinhDuong.addNeighbour(new Edge(1, vBinhDuong, vDongNai));
        vBinhPhuoc.addNeighbour(new Edge(1, vBinhPhuoc, vDongNai));
        vBinhPhuoc.addNeighbour(new Edge(1, vBinhPhuoc, vTayNinh));
        vBinhPhuoc.addNeighbour(new Edge(1, vBinhPhuoc, vBinhDuong));
        vBinhPhuoc.addNeighbour(new Edge(1, vBinhPhuoc, vLamDong));
        vBinhPhuoc.addNeighbour(new Edge(1, vBinhPhuoc, vDakNong));
        vBinhThuan.addNeighbour(new Edge(1, vBinhThuan, vBaRiaVungTau));
        vBinhThuan.addNeighbour(new Edge(1, vBinhThuan, vDongNai));
        vBinhThuan.addNeighbour(new Edge(1, vBinhThuan, vNinhThuan));
        vBinhThuan.addNeighbour(new Edge(1, vBinhThuan, vLamDong));
        vCaMau.addNeighbour(new Edge(1, vCaMau, vBacLieu));
        vCaMau.addNeighbour(new Edge(1, vCaMau, vKienGiang));
        vCanTho.addNeighbour(new Edge(1, vCanTho, vKienGiang));
        vCanTho.addNeighbour(new Edge(1, vCanTho, vHauGiang));
        vCanTho.addNeighbour(new Edge(1, vCanTho, vAnGiang));
        vCanTho.addNeighbour(new Edge(1, vCanTho, vDongThap));
        vCanTho.addNeighbour(new Edge(1, vCanTho, vVinhLong));
        vCaoBang.addNeighbour(new Edge(1, vCaoBang, vHaGiang));
        vCaoBang.addNeighbour(new Edge(1, vCaoBang, vBacKan));
        vCaoBang.addNeighbour(new Edge(1, vCaoBang, vLangSon));
        vDaNang.addNeighbour(new Edge(1, vDaNang, vQuangNam));
        vDaNang.addNeighbour(new Edge(1, vDaNang, vThuaThienHue));
        vDakLak.addNeighbour(new Edge(1, vDakLak, vDakNong));
        vDakLak.addNeighbour(new Edge(1, vDakLak, vGiaLai));
        vDakLak.addNeighbour(new Edge(1, vDakLak, vPhuYen));
        vDakLak.addNeighbour(new Edge(1, vDakLak, vKhanhHoa));
        vDakLak.addNeighbour(new Edge(1, vDakLak, vLamDong));
        vDakNong.addNeighbour(new Edge(1, vDakNong, vDakLak));
        vDakNong.addNeighbour(new Edge(1, vDakNong, vBinhPhuoc));
        vDakNong.addNeighbour(new Edge(1, vDakNong, vLamDong));
        vDienBien.addNeighbour(new Edge(1, vDienBien, vLaiChau));
        vDienBien.addNeighbour(new Edge(1, vDienBien, vSonLa));
        vDongNai.addNeighbour(new Edge(1, vDongNai, vTayNinh));
        vDongNai.addNeighbour(new Edge(1, vDongNai, vBinhPhuoc));
        vDongNai.addNeighbour(new Edge(1, vDongNai, vThanhphoHoChiMinh));
        vDongNai.addNeighbour(new Edge(1, vDongNai, vBaRiaVungTau));
        vDongThap.addNeighbour(new Edge(1, vDongThap, vLongAn));
        vDongThap.addNeighbour(new Edge(1, vDongThap, vTienGiang));
        vDongThap.addNeighbour(new Edge(1, vDongThap, vVinhLong));
        vDongThap.addNeighbour(new Edge(1, vDongThap, vCanTho));
        vGiaLai.addNeighbour(new Edge(1, vGiaLai, vDakLak));
        vGiaLai.addNeighbour(new Edge(1, vGiaLai, vKonTum));
        vGiaLai.addNeighbour(new Edge(1, vGiaLai, vPhuYen));
        vGiaLai.addNeighbour(new Edge(1, vGiaLai, vBinhDinh));
        vHaGiang.addNeighbour(new Edge(1, vHaGiang, vLaoCai));
        vHaGiang.addNeighbour(new Edge(1, vHaGiang, vYenBai));
        vHaGiang.addNeighbour(new Edge(1, vHaGiang, vTuyenQuang));
        vHaGiang.addNeighbour(new Edge(1, vHaGiang, vCaoBang));
        vHaNam.addNeighbour(new Edge(1, vHaNam, vHaNoi));
        vHaNam.addNeighbour(new Edge(1, vHaNam, vHoaBinh));
        vHaNam.addNeighbour(new Edge(1, vHaNam, vNinhBinh));
        vHaNam.addNeighbour(new Edge(1, vHaNam, vNamDinh));
        vHaNam.addNeighbour(new Edge(1, vHaNam, vThaiBinh));
        vHaNam.addNeighbour(new Edge(1, vHaNam, vHaiDuong));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vHoaBinh));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vPhuTho));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vThaiNguyen));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vVinhPhuc));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vBacGiang));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vBacNinh));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vHungYen));
        vHaNoi.addNeighbour(new Edge(1, vHaNoi, vHaNam));
        vHaTinh.addNeighbour(new Edge(1, vHaTinh, vQuangBinh));
        vHaTinh.addNeighbour(new Edge(1, vHaTinh, vNgheAn));
        vHaiDuong.addNeighbour(new Edge(1, vHaiDuong, vQuangNinh));
        vHaiDuong.addNeighbour(new Edge(1, vHaiDuong, vBacGiang));
        vHaiDuong.addNeighbour(new Edge(1, vHaiDuong, vBacNinh));
        vHaiDuong.addNeighbour(new Edge(1, vHaiDuong, vHungYen));
        vHaiDuong.addNeighbour(new Edge(1, vHaiDuong, vThaiBinh));
        vHaiDuong.addNeighbour(new Edge(1, vHaiDuong, vHaiPhong));
        vHaiPhong.addNeighbour(new Edge(1, vHaiPhong, vThaiBinh));
        vHaiPhong.addNeighbour(new Edge(1, vHaiPhong, vQuangNinh));
        vHaiPhong.addNeighbour(new Edge(1, vHaiPhong, vHaiDuong));
        vHauGiang.addNeighbour(new Edge(1, vHauGiang, vBacLieu));
        vHauGiang.addNeighbour(new Edge(1, vHauGiang, vKienGiang));
        vHauGiang.addNeighbour(new Edge(1, vHauGiang, vCanTho));
        vHauGiang.addNeighbour(new Edge(1, vHauGiang, vSocTrang));
        vHoaBinh.addNeighbour(new Edge(1, vHoaBinh, vThanhHoa));
        vHoaBinh.addNeighbour(new Edge(1, vHoaBinh, vHaNoi));
        vHoaBinh.addNeighbour(new Edge(1, vHoaBinh, vSonLa));
        vHoaBinh.addNeighbour(new Edge(1, vHoaBinh, vPhuTho));
        vHoaBinh.addNeighbour(new Edge(1, vHoaBinh, vHaNam));
        vHoaBinh.addNeighbour(new Edge(1, vHoaBinh, vNinhBinh));
        vHungYen.addNeighbour(new Edge(1, vHungYen, vHaNoi));
        vHungYen.addNeighbour(new Edge(1, vHungYen, vHaNam));
        vHungYen.addNeighbour(new Edge(1, vHungYen, vHaiDuong));
        vHungYen.addNeighbour(new Edge(1, vHungYen, vThaiBinh));
        vKhanhHoa.addNeighbour(new Edge(1, vKhanhHoa, vPhuYen));
        vKhanhHoa.addNeighbour(new Edge(1, vKhanhHoa, vNinhThuan));
        vKhanhHoa.addNeighbour(new Edge(1, vKhanhHoa, vLamDong));
        vKhanhHoa.addNeighbour(new Edge(1, vKhanhHoa, vDakLak));
        vKienGiang.addNeighbour(new Edge(1, vKienGiang, vAnGiang));
        vKienGiang.addNeighbour(new Edge(1, vKienGiang, vCanTho));
        vKienGiang.addNeighbour(new Edge(1, vKienGiang, vHauGiang));
        vKienGiang.addNeighbour(new Edge(1, vKienGiang, vBacLieu));
        vKienGiang.addNeighbour(new Edge(1, vKienGiang, vCaMau));
        vKonTum.addNeighbour(new Edge(1, vKonTum, vQuangNam));
        vKonTum.addNeighbour(new Edge(1, vKonTum, vQuangNgai));
        vKonTum.addNeighbour(new Edge(1, vKonTum, vGiaLai));
        vLaiChau.addNeighbour(new Edge(1, vLaiChau, vDienBien));
        vLaiChau.addNeighbour(new Edge(1, vLaiChau, vSonLa));
        vLaiChau.addNeighbour(new Edge(1, vLaiChau, vLaoCai));
        vLaiChau.addNeighbour(new Edge(1, vLaiChau, vYenBai));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vBinhPhuoc));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vDakNong));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vDakLak));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vKhanhHoa));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vNinhThuan));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vBinhThuan));
        vLamDong.addNeighbour(new Edge(1, vLamDong, vDongNai));
        vLangSon.addNeighbour(new Edge(1, vLangSon, vQuangNinh));
        vLangSon.addNeighbour(new Edge(1, vLangSon, vBacGiang));
        vLangSon.addNeighbour(new Edge(1, vLangSon, vThaiNguyen));
        vLangSon.addNeighbour(new Edge(1, vLangSon, vBacKan));
        vLangSon.addNeighbour(new Edge(1, vLangSon, vCaoBang));
        vLaoCai.addNeighbour(new Edge(1, vLaoCai, vLaiChau));
        vLaoCai.addNeighbour(new Edge(1, vLaoCai, vYenBai));
        vLaoCai.addNeighbour(new Edge(1, vLaoCai, vHaGiang));
        vLongAn.addNeighbour(new Edge(1, vLongAn, vTienGiang));
        vLongAn.addNeighbour(new Edge(1, vLongAn, vDongThap));
        vLongAn.addNeighbour(new Edge(1, vLongAn, vTayNinh));
        vLongAn.addNeighbour(new Edge(1, vLongAn, vThanhphoHoChiMinh));
        vNamDinh.addNeighbour(new Edge(1, vNamDinh, vNinhBinh));
        vNamDinh.addNeighbour(new Edge(1, vNamDinh, vThaiBinh));
        vNamDinh.addNeighbour(new Edge(1, vNamDinh, vHaNam));
        vNgheAn.addNeighbour(new Edge(1, vNgheAn, vThanhHoa));
        vNgheAn.addNeighbour(new Edge(1, vNgheAn, vHaTinh));
        vNinhBinh.addNeighbour(new Edge(1, vNinhBinh, vThanhHoa));
        vNinhBinh.addNeighbour(new Edge(1, vNinhBinh, vHoaBinh));
        vNinhBinh.addNeighbour(new Edge(1, vNinhBinh, vNamDinh));
        vNinhBinh.addNeighbour(new Edge(1, vNinhBinh, vHaNam));
        vNinhThuan.addNeighbour(new Edge(1, vNinhThuan, vLamDong));
        vNinhThuan.addNeighbour(new Edge(1, vNinhThuan, vKhanhHoa));
        vNinhThuan.addNeighbour(new Edge(1, vNinhThuan, vBinhThuan));
        vPhuTho.addNeighbour(new Edge(1, vPhuTho, vVinhPhuc));
        vPhuTho.addNeighbour(new Edge(1, vPhuTho, vTuyenQuang));
        vPhuTho.addNeighbour(new Edge(1, vPhuTho, vYenBai));
        vPhuTho.addNeighbour(new Edge(1, vPhuTho, vSonLa));
        vPhuTho.addNeighbour(new Edge(1, vPhuTho, vHoaBinh));
        vPhuTho.addNeighbour(new Edge(1, vPhuTho, vHaNoi));
        vPhuYen.addNeighbour(new Edge(1, vPhuYen, vDakLak));
        vPhuYen.addNeighbour(new Edge(1, vPhuYen, vKhanhHoa));
        vPhuYen.addNeighbour(new Edge(1, vPhuYen, vBinhDinh));
        vPhuYen.addNeighbour(new Edge(1, vPhuYen, vGiaLai));
        vQuangBinh.addNeighbour(new Edge(1, vQuangBinh, vQuangTri));
        vQuangBinh.addNeighbour(new Edge(1, vQuangBinh, vHaTinh));
        vQuangNam.addNeighbour(new Edge(1, vQuangNam, vQuangNgai));
        vQuangNam.addNeighbour(new Edge(1, vQuangNam, vKonTum));
        vQuangNam.addNeighbour(new Edge(1, vQuangNam, vDaNang));
        vQuangNam.addNeighbour(new Edge(1, vQuangNam, vThuaThienHue));
        vQuangNgai.addNeighbour(new Edge(1, vQuangNgai, vQuangNam));
        vQuangNgai.addNeighbour(new Edge(1, vQuangNgai, vKonTum));
        vQuangNgai.addNeighbour(new Edge(1, vQuangNgai, vBinhDinh));
        vQuangNinh.addNeighbour(new Edge(1, vQuangNinh, vLangSon));
        vQuangNinh.addNeighbour(new Edge(1, vQuangNinh, vBacGiang));
        vQuangNinh.addNeighbour(new Edge(1, vQuangNinh, vHaiPhong));
        vQuangNinh.addNeighbour(new Edge(1, vQuangNinh, vHaiDuong));
        vQuangTri.addNeighbour(new Edge(1, vQuangTri, vThuaThienHue));
        vQuangTri.addNeighbour(new Edge(1, vQuangTri, vQuangBinh));
        vSocTrang.addNeighbour(new Edge(1, vSocTrang, vBacLieu));
        vSocTrang.addNeighbour(new Edge(1, vSocTrang, vHauGiang));
        vSocTrang.addNeighbour(new Edge(1, vSocTrang, vTraVinh));
        vSonLa.addNeighbour(new Edge(1, vSonLa, vDienBien));
        vSonLa.addNeighbour(new Edge(1, vSonLa, vLaiChau));
        vSonLa.addNeighbour(new Edge(1, vSonLa, vYenBai));
        vSonLa.addNeighbour(new Edge(1, vSonLa, vPhuTho));
        vSonLa.addNeighbour(new Edge(1, vSonLa, vHoaBinh));
        vSonLa.addNeighbour(new Edge(1, vSonLa, vThanhHoa));
        vTayNinh.addNeighbour(new Edge(1, vTayNinh, vBinhDuong));
        vTayNinh.addNeighbour(new Edge(1, vTayNinh, vThanhphoHoChiMinh));
        vTayNinh.addNeighbour(new Edge(1, vTayNinh, vLongAn));
        vTayNinh.addNeighbour(new Edge(1, vTayNinh, vBinhPhuoc));
        vThaiBinh.addNeighbour(new Edge(1, vThaiBinh, vNamDinh));
        vThaiBinh.addNeighbour(new Edge(1, vThaiBinh, vHaiPhong));
        vThaiBinh.addNeighbour(new Edge(1, vThaiBinh, vHungYen));
        vThaiBinh.addNeighbour(new Edge(1, vThaiBinh, vHaiDuong));
        vThaiBinh.addNeighbour(new Edge(1, vThaiBinh, vHaNam));
        vThaiNguyen.addNeighbour(new Edge(1, vThaiNguyen, vVinhPhuc));
        vThaiNguyen.addNeighbour(new Edge(1, vThaiNguyen, vBacGiang));
        vThaiNguyen.addNeighbour(new Edge(1, vThaiNguyen, vHaNoi));
        vThaiNguyen.addNeighbour(new Edge(1, vThaiNguyen, vLangSon));
        vThaiNguyen.addNeighbour(new Edge(1, vThaiNguyen, vBacKan));
        vThaiNguyen.addNeighbour(new Edge(1, vThaiNguyen, vTuyenQuang));
        vThanhHoa.addNeighbour(new Edge(1, vThanhHoa, vNgheAn));
        vThanhHoa.addNeighbour(new Edge(1, vThanhHoa, vSonLa));
        vThanhHoa.addNeighbour(new Edge(1, vThanhHoa, vHoaBinh));
        vThanhHoa.addNeighbour(new Edge(1, vThanhHoa, vNinhBinh));
        vThuaThienHue.addNeighbour(new Edge(1, vThuaThienHue, vDaNang));
        vThuaThienHue.addNeighbour(new Edge(1, vThuaThienHue, vQuangNam));
        vThuaThienHue.addNeighbour(new Edge(1, vThuaThienHue, vQuangTri));
        vThanhphoHoChiMinh.addNeighbour(new Edge(1, vThanhphoHoChiMinh, vTayNinh));
        vThanhphoHoChiMinh.addNeighbour(new Edge(1, vThanhphoHoChiMinh, vLongAn));
        vThanhphoHoChiMinh.addNeighbour(new Edge(1, vThanhphoHoChiMinh, vBinhDuong));
        vThanhphoHoChiMinh.addNeighbour(new Edge(1, vThanhphoHoChiMinh, vDongNai));
        vThanhphoHoChiMinh.addNeighbour(new Edge(1, vThanhphoHoChiMinh, vBaRiaVungTau));
        vTienGiang.addNeighbour(new Edge(1, vTienGiang, vDongThap));
        vTienGiang.addNeighbour(new Edge(1, vTienGiang, vBenTre));
        vTienGiang.addNeighbour(new Edge(1, vTienGiang, vLongAn));
        vTraVinh.addNeighbour(new Edge(1, vTraVinh, vSocTrang));
        vTraVinh.addNeighbour(new Edge(1, vTraVinh, vBenTre));
        vTraVinh.addNeighbour(new Edge(1, vTraVinh, vVinhLong));
        vTuyenQuang.addNeighbour(new Edge(1, vTuyenQuang, vVinhPhuc));
        vTuyenQuang.addNeighbour(new Edge(1, vTuyenQuang, vPhuTho));
        vTuyenQuang.addNeighbour(new Edge(1, vTuyenQuang, vYenBai));
        vTuyenQuang.addNeighbour(new Edge(1, vTuyenQuang, vHaGiang));
        vTuyenQuang.addNeighbour(new Edge(1, vTuyenQuang, vBacKan));
        vTuyenQuang.addNeighbour(new Edge(1, vTuyenQuang, vThaiNguyen));
        vVinhLong.addNeighbour(new Edge(1, vVinhLong, vDongThap));
        vVinhLong.addNeighbour(new Edge(1, vVinhLong, vCanTho));
        vVinhLong.addNeighbour(new Edge(1, vVinhLong, vBenTre));
        vVinhLong.addNeighbour(new Edge(1, vVinhLong, vTraVinh));
        vVinhPhuc.addNeighbour(new Edge(1, vVinhPhuc, vHaNoi));
        vVinhPhuc.addNeighbour(new Edge(1, vVinhPhuc, vPhuTho));
        vVinhPhuc.addNeighbour(new Edge(1, vVinhPhuc, vTuyenQuang));
        vVinhPhuc.addNeighbour(new Edge(1, vVinhPhuc, vThaiNguyen));
        vYenBai.addNeighbour(new Edge(1, vYenBai, vLaiChau));
        vYenBai.addNeighbour(new Edge(1, vYenBai, vLaoCai));
        vYenBai.addNeighbour(new Edge(1, vYenBai, vHaGiang));
        vYenBai.addNeighbour(new Edge(1, vYenBai, vTuyenQuang));
        vYenBai.addNeighbour(new Edge(1, vYenBai, vPhuTho));
        vYenBai.addNeighbour(new Edge(1, vYenBai, vSonLa));
        
        
        
        PathFinder shortestPath = new PathFinder();
        switch (start) {
            case 1:
                shortestPath.ShortestP(vAnGiang);
                break;
            case 2:
                shortestPath.ShortestP(vBaRiaVungTau);
                break;
            case 3:
                shortestPath.ShortestP(vBacGiang);
                break;
            case 4:
                shortestPath.ShortestP(vBacKan);
                break;
            case 5:
                shortestPath.ShortestP(vBacLieu);
                break;
            case 6:
                shortestPath.ShortestP(vBacNinh);
                break;
            case 7:
                shortestPath.ShortestP(vBenTre);
                break;
            case 8:
                shortestPath.ShortestP(vBinhDinh);
                break;
            case 9:
                shortestPath.ShortestP(vBinhDuong);
                break;
            case 10:
                shortestPath.ShortestP(vBinhPhuoc);
                break;
            case 11:
                shortestPath.ShortestP(vBinhThuan);
                break;
            case 12:
                shortestPath.ShortestP(vCaMau);
                break;
            case 13:
                shortestPath.ShortestP(vCanTho);
                break;
            case 14:
                shortestPath.ShortestP(vCaoBang);
                break;
            case 15:
                shortestPath.ShortestP(vDaNang);
                break;
            case 16:
                shortestPath.ShortestP(vDakLak);
                break;
            case 17:
                shortestPath.ShortestP(vDakNong);
                break;
            case 18:
                shortestPath.ShortestP(vDienBien);
                break;
            case 19:
                shortestPath.ShortestP(vDongNai);
                break;
            case 20:
                shortestPath.ShortestP(vDongThap);
                break;
            case 21:
                shortestPath.ShortestP(vGiaLai);
                break;
            case 22:
                shortestPath.ShortestP(vHaGiang);
                break;
            case 23:
                shortestPath.ShortestP(vHaNam);
                break;
            case 24:
                shortestPath.ShortestP(vHaNoi);
                break;
            case 25:
                shortestPath.ShortestP(vHaTinh);
                break;
            case 26:
                shortestPath.ShortestP(vHaiDuong);
                break;
            case 27:
                shortestPath.ShortestP(vHaiPhong);
                break;
            case 28:
                shortestPath.ShortestP(vHauGiang);
                break;
            case 29:
                shortestPath.ShortestP(vHoaBinh);
                break;
            case 30:
                shortestPath.ShortestP(vHungYen);
                break;
            case 31:
                shortestPath.ShortestP(vKhanhHoa);
                break;
            case 32:
                shortestPath.ShortestP(vKienGiang);
                break;
            case 33:
                shortestPath.ShortestP(vKonTum);
                break;
            case 34:
                shortestPath.ShortestP(vLaiChau);
                break;
            case 35:
                shortestPath.ShortestP(vLamDong);
                break;
            case 36:
                shortestPath.ShortestP(vLangSon);
                break;
            case 37:
                shortestPath.ShortestP(vLaoCai);
                break;
            case 38:
                shortestPath.ShortestP(vLongAn);
                break;
            case 39:
                shortestPath.ShortestP(vNamDinh);
                break;
            case 40:
                shortestPath.ShortestP(vNgheAn);
                break;
            case 41:
                shortestPath.ShortestP(vNinhBinh);
                break;
            case 42:
                shortestPath.ShortestP(vNinhThuan);
                break;
            case 43:
                shortestPath.ShortestP(vPhuTho);
                break;
            case 44:
                shortestPath.ShortestP(vPhuYen);
                break;
            case 45:
                shortestPath.ShortestP(vQuangBinh);
                break;
            case 46:
                shortestPath.ShortestP(vQuangNam);
                break;
            case 47:
                shortestPath.ShortestP(vQuangNgai);
                break;
            case 48:
                shortestPath.ShortestP(vQuangNinh);
                break;
            case 49:
                shortestPath.ShortestP(vQuangTri);
                break;
            case 50:
                shortestPath.ShortestP(vSocTrang);
                break;
            case 51:
                shortestPath.ShortestP(vSonLa);
                break;
            case 52:
                shortestPath.ShortestP(vTayNinh);
                break;
            case 53:
                shortestPath.ShortestP(vThaiBinh);
                break;
            case 54:
                shortestPath.ShortestP(vThaiNguyen);
                break;
            case 55:
                shortestPath.ShortestP(vThanhHoa);
                break;
            case 56:
                shortestPath.ShortestP(vThuaThienHue);
                break;
            case 57:
                shortestPath.ShortestP(vTienGiang);
                break;
            case 58:
                shortestPath.ShortestP(vThanhphoHoChiMinh);
                break;
            case 59:
                shortestPath.ShortestP(vTraVinh);
                break;
            case 60:
                shortestPath.ShortestP(vTuyenQuang);
                break;
            case 61:
                shortestPath.ShortestP(vVinhLong);
                break;
            case 62:
              shortestPath.ShortestP(vVinhPhuc);
                break;
            case 63:
                shortestPath.ShortestP(vYenBai);
                break;
            default:
                break;
        }
        switch (target) {
            case 1:
                return BigInteger.valueOf((long) (vAnGiang.getDist()*5000));
            case 2:
                return BigInteger.valueOf((long) (vBaRiaVungTau.getDist()*5000));
            case 3:
                return BigInteger.valueOf((long) (vBacGiang.getDist()*5000));
            case 4:
                return BigInteger.valueOf((long) (vBacKan.getDist()*5000));
            case 5:
                return BigInteger.valueOf((long) (vBacLieu.getDist()*5000));
            case 6:
                return BigInteger.valueOf((long) (vBacNinh.getDist()*5000));
            case 7:
                return BigInteger.valueOf((long) (vBenTre.getDist()*5000));
            case 8:
                return BigInteger.valueOf((long) (vBinhDinh.getDist()*5000));
            case 9:
                return BigInteger.valueOf((long) (vBinhDuong.getDist()*5000));
            case 10:
                return BigInteger.valueOf((long) (vBinhPhuoc.getDist()*5000));
            case 11:
                return BigInteger.valueOf((long) (vBinhThuan.getDist()*5000));
            case 12:
                return BigInteger.valueOf((long) (vCaMau.getDist()*5000));
            case 13:
                return BigInteger.valueOf((long) (vCanTho.getDist()*5000));
            case 14:
                return BigInteger.valueOf((long) (vCaoBang.getDist()*5000));
            case 15:
                return BigInteger.valueOf((long) (vCaoBang.getDist()*5000));
            case 16:
                return BigInteger.valueOf((long) (vDakLak.getDist()*5000));
            case 17:
                return BigInteger.valueOf((long) (vDakNong.getDist()*5000));
            case 18:
                return BigInteger.valueOf((long) (vDienBien.getDist()*5000));
            case 19:
                return BigInteger.valueOf((long) (vDongNai.getDist()*5000));
            case 20:
                return BigInteger.valueOf((long) (vDongThap.getDist()*5000));
            case 21:
                return BigInteger.valueOf((long) (vGiaLai.getDist()*5000));
            case 22:
                return BigInteger.valueOf((long) (vHaGiang.getDist()*5000));
            case 23:
                return BigInteger.valueOf((long) (vHaNam.getDist()*5000));
            case 24:
                return BigInteger.valueOf((long) (vHaNoi.getDist()*5000));
            case 25:
                return BigInteger.valueOf((long) (vHaTinh.getDist()*5000));
            case 26:
                return BigInteger.valueOf((long) (vHaiDuong.getDist()*5000));
            case 27:
                return BigInteger.valueOf((long) (vHaiPhong.getDist()*5000));
            case 28:
                return BigInteger.valueOf((long) (vHauGiang.getDist()*5000));
            case 29:
                return BigInteger.valueOf((long) (vHoaBinh.getDist()*5000));
            case 30:
                return BigInteger.valueOf((long) (vHungYen.getDist()*5000));
            case 31:
                return BigInteger.valueOf((long) (vKhanhHoa.getDist()*5000));
            case 32:
                return BigInteger.valueOf((long) (vKienGiang.getDist()*5000));
            case 33:
                return BigInteger.valueOf((long) (vKonTum.getDist()*5000));
            case 34:
                return BigInteger.valueOf((long) (vLaiChau.getDist()*5000));
            case 35:
                return BigInteger.valueOf((long) (vLamDong.getDist()*5000));
            case 36:
                return BigInteger.valueOf((long) (vLangSon.getDist()*5000));
            case 37:
                return BigInteger.valueOf((long) (vLaoCai.getDist()*5000));
            case 38:
                return BigInteger.valueOf((long) (vLongAn.getDist()*5000));
            case 39:
                return BigInteger.valueOf((long) (vNamDinh.getDist()*5000));
            case 40:
                return BigInteger.valueOf((long) (vNgheAn.getDist()*5000));
            case 41:
                return BigInteger.valueOf((long) (vNinhBinh.getDist()*5000));
            case 42:
                return BigInteger.valueOf((long) (vNinhThuan.getDist()*5000));
            case 43:
                return BigInteger.valueOf((long) (vPhuTho.getDist()*5000));

            case 44:
                return BigInteger.valueOf((long) (vPhuYen.getDist()*5000));
            case 45:
                return BigInteger.valueOf((long) (vQuangBinh.getDist()*5000));
            case 46:
                return BigInteger.valueOf((long) (vQuangNam.getDist()*5000));
            case 47:
                return BigInteger.valueOf((long) (vQuangNgai.getDist()*5000));
            case 48:
                return BigInteger.valueOf((long) (vQuangNinh.getDist()*5000));

            case 49:
                return BigInteger.valueOf((long) (vQuangTri.getDist()*5000));
            case 50:
                return BigInteger.valueOf((long) (vSocTrang.getDist()*5000));
            case 51:
                return BigInteger.valueOf((long) (vSonLa.getDist()*5000));
            case 52:
                return BigInteger.valueOf((long) (vTayNinh.getDist()*5000));
            case 53:
                return BigInteger.valueOf((long) (vThaiBinh.getDist()*5000));
            case 54:
                return BigInteger.valueOf((long) (vThaiNguyen.getDist()*5000));
            case 55:
                return BigInteger.valueOf((long) (vThanhHoa.getDist()*5000));
            case 56:
                return BigInteger.valueOf((long) (vThuaThienHue.getDist()*5000));
            case 57:
                return BigInteger.valueOf((long) (vTienGiang.getDist()*5000));
            case 58:
                return BigInteger.valueOf((long) (vThanhphoHoChiMinh.getDist()*5000));
            case 59:
                return BigInteger.valueOf((long) (vTraVinh.getDist()*5000));
            case 60:
                return BigInteger.valueOf((long) (vTuyenQuang.getDist()*5000));

            case 61:
                return BigInteger.valueOf((long) (vVinhLong.getDist()*5000));
            case 62:
                return BigInteger.valueOf((long) (vVinhPhuc.getDist()*5000));
            case 63:
                return BigInteger.valueOf((long) (vYenBai.getDist()*5000));
            default:
                break;
        }
        return a;



    }

    public static void main(String[] args) {
        GiaoHang giaoHang = new GiaoHang();
        System.out.println("A đến E: " + giaoHang.dijkstra(24, 58).toString());
        ;
    }
}