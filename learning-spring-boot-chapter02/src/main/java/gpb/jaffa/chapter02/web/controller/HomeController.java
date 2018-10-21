package gpb.jaffa.chapter02.web.controller;

import gpb.jaffa.chapter02.service.ImageService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    private static final String BASE_PATH = "/images";
    private static final String FILENAME = "{filename:.+}";

    private final ImageService imageService;


    public HomeController(ImageService imageService) {
        this.imageService = imageService;
    }

    // TODO
}
