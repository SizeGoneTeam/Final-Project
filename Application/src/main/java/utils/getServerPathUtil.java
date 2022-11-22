package utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getServerPathUtil extends HttpServlet {
    public static String ServerPath;
    public static String getServerPath(HttpServletRequest req, HttpServletResponse resp) throws MalformedURLException {
        if(ServerPath == null) {
            String requestURL = req.getRequestURL().toString();
            ServerPath = requestURL;
            String servletPath = req.getServletPath();
            System.out.println(requestURL.indexOf(servletPath));
            if(requestURL.contains(servletPath)) {
                String serverPath = requestURL.substring(0,requestURL.indexOf(servletPath));
                ServerPath = serverPath +"/";
            }
            
        }
        return ServerPath;
    }
}
