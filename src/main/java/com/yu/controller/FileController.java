package com.yu.controller;

import com.yu.pojo.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class FileController {

    /**
     * 上传地址
     */
    private String path = "d:/upload";

    List<Book> bookList = new ArrayList<Book>();

    /**
     * 进入文件选择页面
     */
    @RequestMapping("/uploadFile")
    public String uploadFile() {

        return "uploadFile";
    }

    /**
     * 上传文件自动绑定到MultipartFile对象中，
     * 在这里使用处理方法的形参接收请求参数。
     *
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile myfile, String description) throws IllegalStateException, IOException {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        String oldName = myfile.getOriginalFilename();
        Path p=Paths.get(f.getAbsolutePath()+File.separator + oldName);
        myfile.transferTo(p);

        return "redirect:/showDownLoad";
    }

    /**
     * 显示要下载的文件
     */
    @RequestMapping("/showDownLoad")
    public String showDownLoad(HttpServletRequest request, Model model) {
        File[] files = new File(path).listFiles();


        model.addAttribute("filesList", files);
        return "showFile";

    }

    /**
     * 实现下载功能
     *
     * @throws IOException
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename) throws IOException {
        File file = new File(path + File.separator + filename);
        FileInputStream fin = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		byte[] b = new byte[1024];
        int n;

        while ((n= fin.read(b))!=-1 ){
        	bos.write(b,0,n);
		}
        bos.close();
        fin.close();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentDispositionFormData("attachment",filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);


		return new ResponseEntity<>(bos.toByteArray(),headers, HttpStatus.OK);
//		return  ResponseEntity.ok(bos.toByteArray());

    }
}
