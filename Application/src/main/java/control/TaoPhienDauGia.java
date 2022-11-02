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
import java.util.Calendar;
import java.util.Date;
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

import TimerTask.MyTask;
import entity.TbAccount;
import entity.TbPhienDauGia;
import entity.TbSach;
import model.BookDao;
import model.PhienDauGiaDao;
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
            
            PhienDauGiaDao dao = new PhienDauGiaDao();
            UserDao dao1 = new UserDao();
            TbPhienDauGia phien = new TbPhienDauGia(GiaKhoiDiem, LoaiPhien, new Timestamp(end.getTime().getTime()), NowTime, ThoiGian, GiaGiam, GiaThapNhat, ThoiGianGiam);
            /*
             * MyTask myTask = new MyTask(end.getTime());
             * Timer timer = new Timer();
             * timer.schedule(myTask, 1000, ThoiGianGiam * 1000);
             */
            TbSach sach = new TbSach(Anh, GiaKhoiDiem, Mota, TenSach);
            phien.setMaSach(sach);
            dao.insert(phien);
            acc = dao1.findById(acc.getMaTK());
            acc.add(phien);
            dao1.update(acc);
            url = "loadSach";
        }
        
        else {
            url = "login";
        }
       
        response.sendRedirect(url);

    }
    
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime no2w = LocalDateTime.now();
        Timestamp a = Timestamp.valueOf(dtf.format(no2w));
        Calendar now = Calendar.getInstance();
        now.setTime(a);
        Calendar end = Calendar.getInstance();
        end.setTime(a);
        end.add(Calendar.SECOND, 20);
        
        Timestamp Now = new Timestamp(now.getTime().getTime());
        Timestamp End = new Timestamp(end.getTime().getTime());
        System.out.println(Now);
        System.out.println(End);
    }

}
