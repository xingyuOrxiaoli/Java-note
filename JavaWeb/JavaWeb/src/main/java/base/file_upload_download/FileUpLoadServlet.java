package base.file_upload_download;


import base.file_upload_download.entity.FileMessage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/base/file_upload_download/fileUpLoadServlet")
//文件注解,maxFileSize单个文件上传空间大小,maxRequestSize多个文件总共上传空间大小
@MultipartConfig(maxFileSize = 1024*1024*100,maxRequestSize = 1024*1024*200)
public class FileUpLoadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        List<FileMessage> fileMessages = new ArrayList<>();

        String realPath = req.getServletContext().getRealPath("/jsp/file/images");

        try {
            // 创建文件上传的工厂对象
            FileItemFactory factory = new DiskFileItemFactory();
            // 创建文件上传的组建
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            upload.setFileSizeMax(1024 * 1024 * 1024);

            // 获得提交过来的内容值
            List<FileItem> list = upload.parseRequest(req);
            // System.out.println(list.size());
            FileMessage fileMessage = new FileMessage();
            fileMessage.setUsername(req.getParameter("username"));

            for (FileItem fileItem : list) {
                 System.out.println(fileItem.getName() +"---" + fileItem.getFieldName() +"---" + fileItem.getSize() +"---" + fileItem.getContentType()+"---"+fileItem.isFormField());
                if (!fileItem.isFormField()){
                    // 证明是文件表单项
                    if (fileItem.getSize() > 1024 * 1024 * 1024){
                        // 文件太大
                        return;
                    }
                    String uuid = UUID.randomUUID().toString();
                    String substring = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                    String fileName = uuid+substring;

//                    System.out.println(req.getServletPath().toString());
//                    String realPath = req.getServletContext().getRealPath("jsp/file/images");
//                    System.out.println(realPath);
                    File file = new File(realPath);
                    if (!file.exists()){
                        file.mkdirs();
                    }

                    // System.out.println(file.getAbsoluteFile());
//                    System.out.println(file.getPath());
//                    System.out.println(new File(file, fileName).getAbsoluteFile());

                    fileItem.write(new File(file,fileName));
                    fileMessage.setFilePath("/jsp/file/images/"+fileName);
                }else {
                    fileMessage.setUsername(req.getParameter(fileItem.getName()));
                }
            }
            fileMessages.add(fileMessage);
            session.setAttribute("fileMessage",fileMessages);
            resp.sendRedirect("/jsp/file/file_download.jsp");
//            req.getRequestDispatcher("/jsp/file/file_download.jsp").forward(req,resp);
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
