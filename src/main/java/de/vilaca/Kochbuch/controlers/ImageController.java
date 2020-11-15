package de.vilaca.Kochbuch.controlers;

import de.vilaca.Kochbuch.KochbuchApplication;
import de.vilaca.Kochbuch.domain.Image;
import de.vilaca.Kochbuch.repositories.ImageRepository;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Set;

@RestController
public class ImageController {

    private final String placeholderImg = "classpath:static/img/placeholder.jpg";

    private final ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(Model model, HttpServletResponse response,
                         @RequestParam(name = "id", required = true, defaultValue = "0") Integer id) throws IOException {
        //System.out.println(id);
        ApplicationHome home = new ApplicationHome(KochbuchApplication.class);
        Optional<Image> imageOptional = imageRepository.findById(id);
        //String subPath;
        InputStream imageStream = null;
        File file = null;
        if (imageOptional.isPresent()) {
            System.out.println("Hinterlegter Pfad:" + imageOptional.get().getPath());
            file = new File(home.getDir().getPath() + File.separator + imageOptional.get().getPath());
            System.out.println("File: " + file.getAbsolutePath());
            if (file.exists()) {
                imageStream = new FileInputStream(file);
            }
        }
        if (imageStream == null){
            Resource resource = new ClassPathResource(placeholderImg);
            imageStream = resource.getInputStream();
        }
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imageStream, response.getOutputStream());
    }

}
