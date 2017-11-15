
package io.github.oleiva.ivasoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private RecordRepository repository;
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
////            ApachePOIExcelRead poiExcelRead = new ApachePOIExcelRead();
////            ArrayList<Student> list = poiExcelRead.transformation(xml);
////            userService.setStudent(list);
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
            

        } catch (IOException e) {
            e.printStackTrace();
        }

//        return "redirect:/uploadStatus";
        return "redirect:/";
    }

//    @GetMapping("/uploadStatus")
//    public String uploadStatus() {
//        return "uploadStatus";
//    }


}
