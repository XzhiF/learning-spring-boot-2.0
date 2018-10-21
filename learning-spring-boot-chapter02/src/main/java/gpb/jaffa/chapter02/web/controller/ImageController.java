package gpb.jaffa.chapter02.web.controller;

import gpb.jaffa.chapter02.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ImageController {

    private Logger log = LoggerFactory.getLogger(ImageController.class);

    @GetMapping("/chapter02/images")
    public Flux<Image> images()
    {
        return Flux.just(
                new Image("1","learning-spring-boot-cover.jpg"),
                new Image("2","learning-spring-boot-2nd-edition-cover.jpg"),
                new Image("3","bazinga.jpg")
        );
    }

    /**
     *  curl -v -H 'Content-Type:application/json' -X POST -d  '[{"id":10, "name":"foo"},{"id":20,"name":"foo2"}]' localhost:8080/chapter02/images
     */
    @PostMapping("/chapter02/images")
    public Mono<Void> create(@RequestBody Flux<Image> images)
    {
        return images.map(image->{
            log.info("We will save" + image + "to a Reactive database soon!");
            return image;
        }).then();
    }

}
