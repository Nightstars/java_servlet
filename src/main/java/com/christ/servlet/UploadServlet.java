package com.christ.servlet;

import javafx.application.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    String name=request.getParameter("username");
    Part part=request.getPart("filename");
    String uuid=UUID.randomUUID().toString().replaceAll("-","");
    String type=part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
    String path=new File(request.getServletContext().getRealPath("/")).getParent();
    String filepath=path.replaceAll("\\\\","/")+"/imgs/";
    out.println(filepath);
    part.write(filepath+uuid+type);
    out.println("username="+name+"<br>");
    out.println(part.getName()+"<br>");
    out.println(part.getSize()+"<br>");
    out.println(part.getSubmittedFileName()+"<br>");
    out.close();
    }
}
