package fqj.csu.controller;

import fqj.csu.dao.ImageDAO;
import fqj.csu.model.Image;
import fqj.csu.service.ImageService;
import fqj.csu.util.CopyFiles;
import fqj.csu.util.DeleteFiles;
import fqj.csu.util.GetPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


@Controller
public class UploadController {

    public static String str1 = "发酵1.5小时图片";
    public static String str2 = "发酵2.5小时图片";
    public static String str3 = "发酵3.5小时图片";

    @Autowired
    ImageService imageService;

    @Autowired
    ImageDAO imageDAO;

    @RequestMapping("/uploadImg")
    public String uploadImg(HttpServletRequest request,Model model) throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        String predict = "";
        String name = "";
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    String temp[] = file.getOriginalFilename().replace("\\\\","/").split("/");
                    if (temp.length >= 1) {
                        name = temp[temp.length - 1];
                    }
                    String path = "C:/Users/Administrator/Desktop/blacktea/prediction/"+name;
                    file.transferTo(new File(path));
                    predict = GetPredict.getPredict();
                    Image image = imageService.addImage(name,"E:/JetBrains/blacktea/upload/"+name);
                    imageDAO.updatePredict(Integer.parseInt(predict)+1,image.getId());
                    model.addAttribute("image",image);
                }
            }
        }
        CopyFiles.copyFileOrDir("C:/Users/Administrator/Desktop/blacktea/prediction","E:/JetBrains/blacktea/upload");
        DeleteFiles.delAllFile("C:/Users/Administrator/Desktop/blacktea/prediction");
        //根据预测结果输出相应的字符串
        String msg = "";
        if(predict.equals("0"))
            msg = str1;
        if(predict.equals("1"))
            msg = str2;
        if(predict.equals("2"))
            msg = str3;
        model.addAttribute("msg",msg); //将预测结果送到前端
        model.addAttribute("msg",msg);
        return "/predict";
    }
}