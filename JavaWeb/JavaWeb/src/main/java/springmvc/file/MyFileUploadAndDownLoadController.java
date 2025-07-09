package springmvc.file;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/mvc")
public class MyFileUploadAndDownLoadController {


    /**
     *
     * @param photo  接受DispatchServlet解析request对象后存储了二进制数据的对象 形参的名字必须是上传请求的文件的健名
     * @param response
     * @return
     */
    @RequestMapping(value = "mvc_file_upload")
    public void mvc_file_upload(MultipartFile photo , HttpServletResponse response, HttpServletRequest request) throws IOException {

        String path = request.getServletContext().getRealPath("/mvc/file/upload");
        System.out.println(path);

        String oldName = photo.getOriginalFilename();

        String suffix = oldName.substring(oldName.lastIndexOf("."));

        String newName = UUID.randomUUID()+""+suffix;

        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        photo.transferTo(new File(file,newName));


        String jsonStr = null ; // new Gson().toJson(obj);

        response.getWriter().write(jsonStr);
    }



     @RequestMapping(value = "mvc_file_download")
    public void mvc_file_download(HttpServletRequest request ,String fileName , HttpServletResponse response) throws IOException {


        response.setHeader("Content-Dispostion","attachment;fileName="+fileName);
        String path  =  request.getServletContext().getRealPath("/");
        byte[] bytes = FileUtils.readFileToByteArray(new File(path, fileName));

         ServletOutputStream outputStream = response.getOutputStream();
         outputStream.write(bytes);
    }
}
