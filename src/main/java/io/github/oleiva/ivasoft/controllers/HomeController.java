
package io.github.oleiva.ivasoft.controllers;

import io.github.oleiva.ivasoft.jpa.RecordRepository;
import io.github.oleiva.ivasoft.services.ResolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RecordRepository repository;

    @Autowired
    ResolverService resolverService;


    private static String UPLOADED_FOLDER = "/home/ivasoft/Documents/Owner/spring-boot-heroku/Cashe/";

    @Autowired
    public HomeController(RecordRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public String index() {
        return "redirect:/index.html";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            System.out.println("FIle is empty");
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);


            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            System.out.println(file.getOriginalFilename());

            resolverService.resolve(UPLOADED_FOLDER,file.getOriginalFilename());


        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }


    @GetMapping("/processing")
    public String processing() {
        System.out.println("DDDDD");
        resolverService.processing();
        return "redirect:/index.html";
    }

}
