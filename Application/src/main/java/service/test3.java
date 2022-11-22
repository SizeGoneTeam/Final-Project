package service;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.uuid.Generators;
import com.google.gson.Gson;

import entity.GioHangPK;
import entity.TbAccount;
import entity.TbGioHang;
import entity.TbSach;
import model.BookDao;
import model.GioHangDao;
import model.UserDao;
import utils.CloudinaryUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import java.util.UUID;

public class test3 {
    public static void main(String[] args) throws IOException, AuthenticationException {
        UserDao dao = new UserDao();
        TbAccount acc = dao.findById(Long.valueOf(18));
        System.out.println(acc.getDiaChiMacDinh());
    }
}