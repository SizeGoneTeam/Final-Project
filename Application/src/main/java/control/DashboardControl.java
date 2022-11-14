package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import model.GiaodichDao;

/**
 * Servlet implementation class DashboardControl
 */
@WebServlet("/adminpage/DashboardControl")
public class DashboardControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp NowTime = Timestamp.valueOf(dtf.format(LocalDateTime.now()));
        Calendar now = Calendar.getInstance();
        GiaodichDao dao= new GiaodichDao();

        now.setTime(NowTime);
        now.add(Calendar.YEAR, 1900);
        Double doanhthuhientai = dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear()));
        Long taikhoan = dao.taikhoadangkymoi(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear()));
        now.add(Calendar.MONTH, -11);
        
        Double trungbinh = (double) 0;
        List<Chart> charts = new ArrayList<>();
        String chart = "";
        List<String> nam = new ArrayList<>();
        for(int i=0; i<12;i++ ) {
            try {
                chart = chart + "{ x: new Date("+now.getTime().getYear()+", "+(now.getTime().getMonth())+" ), y: "+dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear()))+" },\r\n";
                trungbinh += dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear()));
                
                //System.out.println((now.getTime().getMonth()+1) + "/"+now.getTime().getYear()+ " :"+dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear())));
                
            } catch (Exception e) {
               //System.out.println(e);
            }
            now.add(Calendar.MONTH, 1);
        }
        
        trungbinh = trungbinh/12;
     // System.out.println(chart);
        String tempHTML = "animationEnabled: true,  \r\n"
                + "    title:{\r\n"
                + "        text: \"Doanh thu theo tháng\"\r\n"
                + "    },\r\n"
                + "    axisX: {\r\n"
                + "        valueFormatString: \"MM-YY\"\r\n"
                + "    },\r\n"
                + "    axisY: {\r\n"
                + "        title: \"Doanh thu (VNĐ)\",\r\n"
                + "        prefix: \"\"\r\n"
                + "    },\r\n"
                + "    data: [{\r\n"
                + "        yValueFormatString: \"#.### VNĐ\",\r\n"
                + "        xValueFormatString: \"MM-YY\",\r\n"
                + "        type: \"spline\",\r\n"
                + "        dataPoints: [\r\n"
                +  chart        

                + "        ]\r\n"
                + "    }]";
        request.setAttribute("trungbinh", trungbinh);
        request.setAttribute("taikhoan", taikhoan);
        request.setAttribute("doanhthuhientai", doanhthuhientai);
        request.setAttribute("charts", tempHTML);
        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

