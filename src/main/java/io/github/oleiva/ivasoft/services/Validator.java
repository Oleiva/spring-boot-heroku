package io.github.oleiva.ivasoft.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//import org.springframework.stereotype.Service;

@Service
public class Validator {
//    private static final Logger logger = Logger.getLogger("Validator");

    public  String validateGroup(String group) {

        List<Integer> list = (Arrays.asList(65, 66, 67, 68, 69, 70, 1, 72, 73, 74, 75, 76, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071));



        String index ="";

        for (int x = 0; x < group.length(); x++) {
            char a_char = group.toUpperCase().charAt(x);

            if(list.contains((int) a_char)){
                index = index +a_char;
            }else {
                System.out.println(" :: "+a_char +" "+(int)a_char);
            };


        }
        return index;
    }

    public  String validateGroupIndex(String group) {
        List<Integer> list = (Arrays.asList(48,49,50,51,52,53,54,55,56,57));
        String index ="";

        for (int x = 0; x < group.length(); x++) {
            char a_char = group.charAt(x);
            if(list.contains((int) a_char)){
                index = index +a_char;
            }
        }
        return index;
//        System.out.println("dddd");
//        return "OK";
    }


    public static void main(String[] args) {
//        Validator vl = new Validator();
//        System.out.println( vl.validateGroupIndex("TM !W- 031"));;


    }
}