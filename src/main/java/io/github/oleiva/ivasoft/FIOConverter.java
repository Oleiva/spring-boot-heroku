package io.github.oleiva.ivasoft;


public class FIOConverter {


    public  String getFIOHAshe(String fio) {

//        String fio = "Тонконог Б. А";
//        String fio ="Тонконог Б.А";
//        String fio ="Мисник Сергій Юрійович";
        String ff = fio.replaceAll("\\.", "").replaceAll("\\  ", "\\ ");
        System.out.println(ff);
        String ff_1[] = ff.split("\\ ");
        String targetName ="";

        System.out.println("Size : "+ff_1.length);
        if (ff_1.length == 3) {
            System.out.println("ff_1.length == 3");
            if (ff_1[1].length() == 1 && ff_1[2].length() == 1) {
                System.out.println("DIAL");
                targetName = ff_1[0] + ff_1[1] + ff_1[2];
                System.out.println(targetName);
            }else {
                targetName = ff_1[0] + ff_1[1].substring(0,1) + ff_1[2].substring(0,1);
                System.out.println(targetName);
            }

        }else if (ff_1.length == 2){

            if (ff_1[1].length()==2){
                targetName = ff_1[0] + ff_1[1];
            }


        }



        System.out.println(targetName);
        return targetName;

    }


}
