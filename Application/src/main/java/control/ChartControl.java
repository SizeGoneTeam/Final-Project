package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.TbSach;
import model.BookDao;
import model.GiaodichDao;

/**
 * Servlet implementation class ChartControl
 */
@WebServlet("/adminpage/ChartControl")
public class ChartControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp NowTime = Timestamp.valueOf(dtf.format(LocalDateTime.now()));
        Calendar now = Calendar.getInstance();
        now.setTime(NowTime);
        now.add(Calendar.YEAR, 1900);
        now.add(Calendar.MONTH, -11);
        
        GiaodichDao dao= new GiaodichDao();
        List<Chart> charts = new ArrayList<>();
        String chart = "";
        List<String> nam = new ArrayList<>();
        for(int i=0; i<12;i++ ) {
            try {
                chart = chart + "{ x: new Date("+now.getTime().getYear()+", "+(now.getTime().getMonth())+" ), y: "+dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear()))+" },\r\n";
                
                
                //System.out.println((now.getTime().getMonth()+1) + "/"+now.getTime().getYear()+ " :"+dao.Doanhthutheothang(Integer.valueOf(now.getTime().getMonth())+1, Integer.valueOf(now.getTime().getYear())));
                
            } catch (Exception e) {
               //System.out.println(e);
            }
            now.add(Calendar.MONTH, 1);
        }
     // System.out.println(chart);
        String tempHTML = "animationEnabled: true,  \r\n"
                + "    title:{\r\n"
                + "        text: \"Doanh thu theo tháng\"\r\n"
                + "    },\r\n"
                + "    axisX: {\r\n"
                + "        valueFormatString: \"MM-YY\"\r\n"
                + "    },\r\n"
                + "    axisY: {\r\n"
                + "        title: \"Doanh thu (USD)\",\r\n"
                + "        prefix: \"\"\r\n"
                + "    },\r\n"
                + "    data: [{\r\n"
                + "        yValueFormatString: \"#.### USD\",\r\n"
                + "        xValueFormatString: \"MM-YY\",\r\n"
                + "        type: \"spline\",\r\n"
                + "        dataPoints: [\r\n"
                +  chart        

                + "        ]\r\n"
                + "    }]";
        
        request.setAttribute("charts", tempHTML);

        request.getRequestDispatcher("Chart.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

