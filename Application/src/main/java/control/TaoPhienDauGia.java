package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

import TimerTask.GiamGia;
import TimerTask.KetThucPhien;
import entity.TbAccount;
import entity.TbPhienDauGia;
import entity.TbSach;
import entity.TbTacGia;
import entity.TbTheLoai;
import model.BookDao;
import model.PhienDauGiaDao;
import model.TacGiaDao;
import model.UserDao;

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
        
        HttpSession session = request.getSession();
        TbAccount acc = (TbAccount) session.getAttribute("acc");
        
        if (acc!=null)
        {
            PhienDauGiaDao daoPhien = new PhienDauGiaDao();
            UserDao daoUser = new UserDao();
            BookDao daoPhienBook = new BookDao();
            TacGiaDao daoTacGia = new TacGiaDao();
           
            request.setCharacterEncoding("UTF-8");
            String TenSach = request.getParameter("title");
            String Mota = request.getParameter("MoTa");
            String TinhTrang = request.getParameter("TinhTrang");
            String Anh = "image/UploadSach/";
            BigInteger GiaKhoiDiem = new BigInteger(request.getParameter("startPrice"));
            BigInteger GiaThapNhat = new BigInteger(request.getParameter("GiaThapNhat"));
            Integer LoaiPhien = Integer.valueOf(request.getParameter("LoaiPhien"));
            Integer ThoiGian = Integer.valueOf(request.getParameter("ThoiGian"));
            Integer ThoiGianGiam = Integer.valueOf(request.getParameter("ThoiGianGiam"));
            BigInteger GiaGiam = new BigInteger(request.getParameter("GiaGiam"));
            
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
            else if(name1 != null && name1 != "" && name1.length() !=0) {
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
            else if(name2 != null && name2 != "" && name2.length() != 0 && tacgia2!=tacgia1) {
                System.out.println(name2 != null);
                    System.out.println("tạo tác giả " + name2);
                    tacgia2 = new TbTacGia();
                    tacgia2.setTenTacGia(name2);
                    daoTacGia.insert(tacgia2);
                    tacGias.add(tacgia2);
                
            }
            
            if(tacgia3 != null && tacgia3!=tacgia2 && tacgia3 != tacgia1   )
            {

                    System.out.println("thêm tác giả vào sách " + tacgia3.getTenTacGia());
                    tacGias.add(tacgia3);
               
            }
            else if(name3 != null && name3 != "" && name3.length() != 0 && tacgia3!=tacgia2 && tacgia3 != tacgia1 ) {

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
            

            // upload ảnh
            try {
                Part part = request.getPart("image");
                String realPath = request.getServletContext().getRealPath("/image/UploadSach");
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                while(Files.exists(Paths.get(realPath + "/" + filename)))
                {
                    // Random chuỗi
                    int leftLimit = 97; // letter 'a'
                    int rightLimit = 122; // letter 'z'
                    int targetStringLength = 2;
                    Random random = new Random();
                    StringBuilder buffer = new StringBuilder(targetStringLength);
                    for (int i = 0; i < targetStringLength; i++) {
                        int randomLimitedInt = leftLimit + (int) 
                          (random.nextFloat() * (rightLimit - leftLimit + 1));
                        buffer.append((char) randomLimitedInt);
                    }
                    String generatedString = buffer.toString();
                    
                    //Thêm chuỗi vào trước tên file
                    filename = generatedString  + filename;
                }

                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectory(Paths.get(realPath));
                }
                
                part.write(realPath + "/" + filename);
                System.out.println(realPath + "/" + filename);
                 Anh+= filename;
            } catch (Exception e) {
                e.printStackTrace();
            }
            

            TbPhienDauGia phien = new TbPhienDauGia(GiaKhoiDiem, LoaiPhien, new Timestamp(end.getTime().getTime()), NowTime, ThoiGian, GiaGiam, GiaThapNhat, ThoiGianGiam);

             
            TbSach sach = new TbSach(Anh, GiaKhoiDiem, Mota, TenSach, TinhTrang);

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
            
              GiamGia giamGia = new GiamGia(phien,sach);
              KetThucPhien ketThucPhien = new KetThucPhien(phien);
              Timer timer = new Timer();
              timer.schedule(giamGia, ThoiGianGiam * 1000, ThoiGianGiam * 1000);
              timer.schedule(ketThucPhien, ThoiGian * 1000);
             
            url = "loadSach";
        }
        
        else {
            url = "login";
        }
       
        response.sendRedirect(url);

    }
    

}
