package base.file_upload_download;


import base.file_upload_download.entity.FileMessage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/base/file_upload_download/fileDownLoadServlet")
public class FileDownLoadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String fileName = req.getParameter("fileName");
        String realPath = req.getServletContext().getRealPath("/jsp/file/images");
        File file = new File(realPath+"/"+fileName);
        // 从服务器中读取问及那
        InputStream input = new FileInputStream(file);

        // 设置文本的类型
        resp.setContentType(req.getParameter("filetype"));
        resp.setContentLength((int)file.length());
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        // 写入到本地硬盘中
        OutputStream output  = resp.getOutputStream();
        IOUtils.copy(input,output);

        output.close();
        input.close();



    }
}
