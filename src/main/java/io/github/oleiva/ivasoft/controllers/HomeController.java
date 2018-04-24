
package io.github.oleiva.ivasoft.controllers;

import io.github.oleiva.ivasoft.jpa.RecordRepository;
import io.github.oleiva.ivasoft.services.NewProcessing;
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

    @Autowired
    NewProcessing newProcessing;

//    https://stackoverflow.com/questions/12416738/how-to-use-herokus-ephemeral-filesystem?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
//    private static String UPLOADED_FOLDER = "/home/ivasoft/Documents/Owner/spring-boot-heroku/Cashe/";
//    private static String UPLOADED_FOLDER = "d:\\config\\";
    private static String UPLOADED_FOLDER = "/tmp/";

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
//            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            e.printStackTrace();
            System.out.println(e);
        }

        return "redirect:/uploadStatus";
    }


    @GetMapping("/processing")
    public String processing() {
        System.out.println("DDDDD");
        resolverService.processing();
        return "redirect:/index.html";
    }

    @GetMapping("/processing2")
    public String processing2() {
        System.out.println("processing2");
        newProcessing.doit();

        return "redirect:/index.html";
    }

}
