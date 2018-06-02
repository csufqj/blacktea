package fqj.csu.service;

import fqj.csu.dao.ImageDAO;
import fqj.csu.dao.UserDAO;
import fqj.csu.model.HostHolder;
import fqj.csu.model.Image;
import fqj.csu.model.User;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageService {
    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    ImageDAO imageDAO;

    @Autowired
    HostHolder hostHolder;

    public Image addImage(String name, String path){
        User user = hostHolder.getUser();
        Image image = new Image();
        image.setUserId(user.getId());
        image.setUserId(user.getId());
        image.setName(name);
        image.setPath(path);
        image.setPredict(0);
        image.setCreatedDate(new Date());
        imageDAO.addImage(image);
        return image;
    }

}
