
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

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://temp//";

    @Autowired
    public HomeController(RecordRepository repository) {
        this.repository = repository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String home(ModelMap model) {
//        System.out.println("home");
//        return "redirect:/index.html";
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String insertData(ModelMap model,
//                             @ModelAttribute("insertRecord") @Valid Record record,
//                             BindingResult result) {
//        if (!result.hasErrors()) {
//            repository.save(record);
//        }
//        return home(model);
//    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public ResponseEntity<String> uploadDataFile(
//            @RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
//
//        if (file != null) {
//
//            System.out.println(file.getOriginalFilename());
//
////            xmlList.forEach( xml->{
//            File xml = new File(file.getOriginalFilename());
////            try {
////                FileOutputStream fos = new FileOutputStream( convFile );
////                fos.write( file.getBytes() );
////                fos.close()
////            }catch (Exception exeption){
////
////            }
////            ParserMarks poiExcelRead = new ParserMarks();
////            ArrayList<MarksPojo> list = poiExcelRead.tr_atudents(xml);
////            userService.saveMarks(list);
////            });
//
//            return new ResponseEntity<String>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//        }
//    }


    //Save the uploaded file to this folder


    @GetMapping("/")
    public String index() {
//        return "upload";
        return "redirect:/index.html";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
            System.out.println("FIle is empty");

        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);



            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            System.out.println(file.getOriginalFilename());

            resolverService.resolve(UPLOADED_FOLDER,file.getOriginalFilename());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
//        return "redirect:/";
    }

//    @GetMapping("/uploadStatus")
//    public String uploadStatus() {
//        return "uploadStatus";
//    }

    @GetMapping("/processing")
    public String processing() {
//        return "upload";
        System.out.println("DDDDD");
        resolverService.processing();
        return "redirect:/index.html";
    }

}
