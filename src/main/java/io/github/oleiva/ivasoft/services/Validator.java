package io.github.oleiva.ivasoft.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class Validator {
//    private static final Logger logger = Logger.getLogger("Validator");

    public  String validateGroup(String group) {

        List<Integer> list = (Arrays.asList(192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255));




        String index ="";

        for (int x = 0; x < group.length(); x++) {
            char a_char = group.charAt(x);

            if(list.contains((int) a_char)){
                index = index +a_char;
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