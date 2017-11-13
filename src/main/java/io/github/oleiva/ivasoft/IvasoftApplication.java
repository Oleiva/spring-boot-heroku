//package io.github.oleiva.ivasoft;
//
//import io.github.oleiva.ivasoft.entity.MarksEntity;
//import io.github.oleiva.ivasoft.entity.StudentEntity;
//import io.github.oleiva.ivasoft.jpa.MarksJpa;
//import io.github.oleiva.ivasoft.jpa.StudentJpa;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.ArrayList;
//
//@SpringBootApplication
//public class IvasoftApplication implements CommandLineRunner {
//
//	@Autowired
//	private UserServiceImpl userService;
//
//
//	public static void main(String[] args) {
//		SpringApplication.run(IvasoftApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		ApachePOIExcelRead poiExcelRead = new ApachePOIExcelRead();
//		ArrayList <String> xmlList = new ArrayList<>();
//		xmlList.add("data/1.xlsx");
//		xmlList.add("data/2.xlsx");
//		xmlList.add("data/3.xlsx");
//		xmlList.add("data/4.xlsx");
//		xmlList.add("data/5.xlsx");
//		xmlList.add("data/6.xlsx");
//		xmlList.add("data/7.xlsx");
//		xmlList.add("data/8.xlsx");
//		xmlList.add("data/9.xlsx");
//		xmlList.add("data/47.xlsx");
//		xmlList.add("data/48.xlsx");
//
//		xmlList.forEach( xml->{
//			ArrayList<Student> list = poiExcelRead.transformation(xml);
//			userService.setStudent(list);
//		});
//
//
//	}
//
//
//
//}
