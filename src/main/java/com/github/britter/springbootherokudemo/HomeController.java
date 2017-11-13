/*
 * Copyright 2015 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.britter.springbootherokudemo;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;


import io.github.oleiva.ivasoft.ApachePOIExcelRead;
import io.github.oleiva.ivasoft.Student;
import io.github.oleiva.ivasoft.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserServiceImpl userService;
    private RecordRepository repository;

    @Autowired
    public HomeController(RecordRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
//        List<Record> records = repository.findAll();
//        model.addAttribute("records", records);
//        model.addAttribute("insertRecord", new Record());
//        return "index";
        System.out.println("home");
        return "redirect:/index.html";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertData(ModelMap model,
                             @ModelAttribute("insertRecord") @Valid Record record,
                             BindingResult result) {
        if (!result.hasErrors()) {
            repository.save(record);
        }
        return home(model);
    }
//
//    @RequestMapping(value="/upload",method = RequestMethod.POST)
//    @ResponseBody
//    public String insertData( HttpServletRequest req) throws ServletException, IOException, FileUploadException {
//
//        if (req.getHeader("Content-Type") != null
//                && req.getHeader("Content-Type").startsWith("multipart/form-data")) {
//            ServletFileUpload upload = new ServletFileUpload();
//
//            FileItemIterator iterator = upload.getItemIterator(req);
//
//            System.out.println(iterator.next().getName());
//
//
//
//        } else {
////            sb.append("{\"size\":\"" + size(ipAddress, req.getInputStream()) + "\"}");
//        }
//
//
////       try {
////
////           System.out.println( request.getMimeHeaders());
////           System.out.println(request.getContentLength());;
////       }catch (Exception ex){
////           System.out.println("ES ");
////       }
//
//
//
//        System.out.println("OKKK");
//        return null;
//    }



//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
////    @Produces(MediaType.APPLICATION_JSON)
//    public Data continueFileUpload(HttpServletRequest request, HttpServletResponse response){
//        MultipartHttpServletRequest mRequest;
//        String filename = "upload.xlsx";
//        try {
//            mRequest = (MultipartHttpServletRequest) request;
//            mRequest.getParameterMap();
//
//            Iterator itr = mRequest.getFileNames();
//            while (itr.hasNext()) {
//                MultipartFile mFile = mRequest.getFile(String.valueOf(itr.next()));
//                String fileName = mFile.getOriginalFilename();
//                System.out.println(fileName);
//
//                java.nio.file.Path path = Paths.get("C:/Data/DemoUpload/" + filename);
//                Files.deleteIfExists(path);
//                InputStream in = mFile.getInputStream();
//                Files.copy(in, path);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadDataFile(
            @RequestParam(value = "file", required = true) MultipartFile file) throws IOException {

        if (file != null) {

            System.out.println(file.getOriginalFilename());

//            xmlList.forEach( xml->{
            File xml = new File( file.getOriginalFilename() );
//            try {
//                FileOutputStream fos = new FileOutputStream( convFile );
//                fos.write( file.getBytes() );
//                fos.close()
//            }catch (Exception exeption){
//
//            }
            ApachePOIExcelRead poiExcelRead = new ApachePOIExcelRead();
            ArrayList<Student> list = poiExcelRead.transformation(xml);
            userService.setStudent(list);
//            });

            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
