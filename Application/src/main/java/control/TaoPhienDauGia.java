package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import TimerTask.GiamGia;
import TimerTask.KetThucPhienAnh;
import TimerTask.KetThucPhienHaLan;
import entity.TbAccount;
import entity.TbAnh;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;
import utils.CloudinaryUtil;

/**
 * Servlet implementation class TaoPhienDauGia
 */
@WebServlet("/TaoPhienDauGia")
@MultipartConfig
public class TaoPhienDauGia extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "";
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        TbAccount acc = (TbAccount) session.getAttribute("acc");
        
        if (acc!=null)
        {
            
            PhienDauGiaDao daoPhien = new PhienDauGiaDao();
            UserDao daoUser = new UserDao();
            BookDao daoPhienBook = new BookDao();
            TacGiaDao daoTacGia = new TacGiaDao();
            
            String TenSach = request.getParameter("title");
            String Mota = request.getParameter("MoTa");
            String TinhTrang = request.getParameter("TinhTrang");
            String Anh = "image/UploadSach/";
            Integer LoaiPhien = Integer.valueOf(request.getParameter("LoaiPhien"));
            Double GiaKhoiDiem = new Double(request.getParameter("startPrice"));
            Double GiaThapNhat = Double.valueOf(0);
            if(LoaiPhien == 2) GiaThapNhat = new Double(request.getParameter("GiaThapNhat"));
            Integer ThoiGian = Integer.valueOf(request.getParameter("ThoiGian"));
            Integer ThoiGianGiam = Integer.valueOf(request.getParameter("ThoiGianGiam"));
            Double GiaGiam = new Double(request.getParameter("GiaGiam"));
            
            TbSach sach = new TbSach(GiaKhoiDiem, Mota, TenSach, TinhTrang);
            
            // Xử lý tác giả

            String name1 = request.getParameter("name1");
            String name2 = request.getParameter("name2");
            String name3 = request.getParameter("name3");
            TbTacGia tacgia1 = daoTacGia.findByName(name1);
            TbTacGia tacgia2 = daoTacGia.findByName(name2);
            TbTacGia tacgia3 = daoTacGia.findByName(name3);
            List<TbTacGia> tacGias = new ArrayList<TbTacGia>();
            if(tacgia1 != null )
            {
                System.out.println("thêm tác giả vào sách " + tacgia1.getTenTacGia());
               tacGias.add(tacgia1);
               
            }
            else if(name1.length() !=0) {
                System.out.println("tạo tác giả " + name1);
                tacgia1 = new TbTacGia();
                tacgia1.setTenTacGia(name1);
                daoTacGia.insert(tacgia1);
                tacGias.add(tacgia1);
            }
            
            if(tacgia2 != null && tacgia2!=tacgia1 )
            {
                    System.out.println("thêm tác giả vào sách " + tacgia2.getTenTacGia());
                    tacGias.add(tacgia2);
            }
            else if(name2.length() != 0 && !name2.equals(name1)) {
                    System.out.println("tạo tác giả " + name2);
                    tacgia2 = new TbTacGia();
                    tacgia2.setTenTacGia(name2);
                    daoTacGia.insert(tacgia2);
                    tacGias.add(tacgia2);
                
            }
            
            if(tacgia3 != null && tacgia3!=tacgia2 && tacgia3!=tacgia1)
            {

                    System.out.println("thêm tác giả vào sách " + tacgia3.getTenTacGia());
                    tacGias.add(tacgia3);
               
            }
            else if(name3.length() != 0 && !name3.equals(name2) && !name3.equals(name1) ) {

                    System.out.println("tạo tác giả " + name3);
                    tacgia3 = new TbTacGia();
                    tacgia3.setTenTacGia(name3);
                    daoTacGia.insert(tacgia3);
                    tacGias.add(tacgia3);

                
            }
            
            
            // lấy thể loại
            
            String theloai1 = request.getParameter("theloai1");
            String theloai2 = request.getParameter("theloai2");
            String theloai3 = request.getParameter("theloai3");
            String theloai4 = request.getParameter("theloai4");
            String theloai5 = request.getParameter("theloai5");
            String theloai6 = request.getParameter("theloai6");
            String theloai7 = request.getParameter("theloai7");
            String theloai8 = request.getParameter("theloai8");
            String theloai9 = request.getParameter("theloai9");
            String theloai10 = request.getParameter("theloai10");
            String theloai11 = request.getParameter("theloai11");
            String theloai12 = request.getParameter("theloai12");
            String theloai13 = request.getParameter("theloai13");
            String theloai14 = request.getParameter("theloai14");
            String theloai15 = request.getParameter("theloai15");
            String theloai16 = request.getParameter("theloai16");
            String theloai17 = request.getParameter("theloai17");
            String theloai18 = request.getParameter("theloai18");
            String theloai19 = request.getParameter("theloai19");
            String theloai20 = request.getParameter("theloai20");
            String theloai21 = request.getParameter("theloai21");
            String theloai22 = request.getParameter("theloai22");
            String theloai23 = request.getParameter("theloai23");
            String theloai24 = request.getParameter("theloai24");
            String theloai25 = request.getParameter("theloai25");
            String theloai26 = request.getParameter("theloai26");

            
            // Xử lý thời gian
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Timestamp NowTime = Timestamp.valueOf(dtf.format(LocalDateTime.now()));
            Timestamp EndTime = null;
            Calendar now = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            now.setTime(NowTime);
            end.add(Calendar.SECOND, ThoiGian);
            System.out.println(now.getTime());
            System.out.println(end.getTime());

            Long NguoiSoHuu = acc.getMaTK();
            System.out.println("nguoi dang:" + NguoiSoHuu);
            

            // upload ảnh
            try {
                TbAnh anh = new TbAnh();
                Collection<Part> parts = request.getParts();
                System.out.println("1");
                for (Part part : parts) {
                    System.out.println("2");
                    String realPath = request.getServletContext().getRealPath("/image/UploadSach");
                    String filename = getFileName(part);
                    System.out.println(filename);

                    if (!Files.exists(Paths.get(realPath))) {
                        Files.createDirectory(Paths.get(realPath));
                    }
                    if(filename != null) {
                        part.write(realPath + "/" + filename);
                        System.out.println(realPath + "/" + filename);
                        Cloudinary cloudinary = CloudinaryUtil.getCloudinary();
                        try {
                           Map uploadResult = cloudinary.uploader().upload(realPath + "/" + filename, ObjectUtils.emptyMap());
                           System.out.println(uploadResult.get("url"));
                           anh = new TbAnh(uploadResult.get("url").toString(),sach);
                           sach.addAnh(anh);
                           
                        } catch (Exception e) {
                           System.out.println(e.getMessage());
                           url = "ErrorPayment.jsp";
                           request.setAttribute("mess", " Up ảnh bị lỗi");
                       }
                        File file = new File(realPath + "/" + filename);
                        if(file.delete()) System.out.println("Xoá thành công");
                    }
                    
                }
                
                 
            } catch (Exception e) {
                url = "ErrorPayment.jsp";
                request.setAttribute("mess", " Up ảnh bị lỗi");
            }
            

            TbPhienDauGia phien = new TbPhienDauGia(GiaKhoiDiem, LoaiPhien, new Timestamp(end.getTime().getTime()), NowTime, ThoiGian, GiaGiam, GiaThapNhat, ThoiGianGiam);

             
            // thêm thể loại

            List<TbTheLoai> theloais = new ArrayList<TbTheLoai>();
            if (theloai1 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai1)));
            if (theloai2 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai2)));
            if (theloai3 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai3)));
            if (theloai4 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai4)));
            if (theloai5 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai5)));
            if (theloai6 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai6)));
            if (theloai7 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai7)));
            if (theloai8 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai8)));
            if (theloai9 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai9)));
            if (theloai10 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai10)));
            if (theloai11 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai11)));
            if (theloai12 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai12)));
            if (theloai13 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai13)));
            if (theloai14 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai14)));
            if (theloai15 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai15)));
            if (theloai16 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai16)));
            if (theloai17 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai17)));
            if (theloai18 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai18)));
            if (theloai19 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai19)));
            if (theloai20 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai20)));
            if (theloai21 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai21)));
            if (theloai22 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai22)));
            if (theloai23 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai23)));
            if (theloai24 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai24)));
            if (theloai25 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai25)));
            if (theloai26 != null ) theloais.add(daoPhienBook.findTheLoaiById(Integer.valueOf(theloai26)));
            
            sach.setTbTheLoais(theloais);
            sach.setTbTacGias(tacGias);
            sach.setNguoiSoHuu(acc);
            
            phien.setMaSach(sach);
            phien.setAccount(acc);
            //acc = daoUser.findById(NguoiSoHuu);
            //acc.addSach(sach);
            //acc.add(phien);
            //daoUser.update(acc);
            daoPhien.insert(phien);

            
            
            // tạo task tự đông
            
            if(LoaiPhien == 1){
                Timer timer = new Timer();
                KetThucPhienAnh ketThucPhien = new KetThucPhienAnh(phien);
                timer.schedule(ketThucPhien, (ThoiGian + 1) * 1000);
            }
            else {
                GiamGia giamGia = new GiamGia(phien,sach);
                KetThucPhienHaLan ketThucPhien = new KetThucPhienHaLan(phien);
                Timer timer = new Timer();
                timer.schedule(giamGia, ThoiGianGiam * 1000, ThoiGianGiam * 1000);
                timer.schedule(ketThucPhien, ThoiGian * 1000);
            }
            
              
             
            url = "detail?pid=" + phien.getMaSach().getMaSach();
        }
        
        else {
            url = "login";
        }
        if(url.equals("ErrorPayment.jsp")) request.getRequestDispatcher(url).forward(request, response);
        else response.sendRedirect(url);

    }
    
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if(!contentDisposition.contains("filename="))
        {
            return null;
        }
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length()-1;
        return contentDisposition.substring(beginIndex,endIndex);
    }

}
