package io.github.oleiva.ivasoft.entity;//package io.github.Oleiva.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Ivasoft on 25.09.2017.
 */

@Entity
@Table(name = "MARKS")
public class MarksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private long studid;

    @NotNull
    private long SUBJECTID;

    @NotNull
    private long MARKS;

//    @NotNull
    private long groupid;

    @NotNull
    private String GROUP_INDEX;

    private String nopp;                              //	"№ п/п"
    private String codeInTheSITE;                     //	Код в ЄДЕБО
    private String studentName;                       //	ПІБ студента
    private String nameOfTheEnglish;                  //	ПІБ англ.
    private String addressOfResidence;                //	Адреса проживання
    private String typeOfStateOfEmergency;            //	Тип НП *
    private String passportNumberBirthBertificate;    //	Серія,№ паспорту (свідоцтва про народження)
    private String dateOFbirth;                       //	"Дата народження
    private String Sex;                               //	Стать
    private String gu;                                //	ГУ *
    private String country;                           //	Країна
    private String placeOfBirth;                      //	Місце народження
    private String contacts;                          //	Контакти
    private String parents_guardians_Name_and_contact;//	Батьки (опікуни): ПІБ та контакти
    private String IPN;                               //	ІПН *
    private String dock_type_that_reason_of_debris;   //	Тип док-ту, що є основою зарах.
    private String docSeriesForEntry;                 //	Серія док-ту (для вступу)
    private String number_of_docs_reason_of_debris;   //	"Номер док-ту, що є основою зарах.
    private String date_of_doc_that_reason_of_debris; //	Дата док-ту, що є основою зарах.
    private String issued_by;                         //	Ким видано
    private String theAverage_score_is_dock;          //	Середній бал док-ту
    private String ballForEntry;                      //	Бал для вступу
    private String inosLanguageStudied;               //	Іноз. мова, що вивчалася
    private String privilegeForEntry;                 //	Пільга для вступу
    private String basisForIF;                        //	Підстава для ПЧ *
    private String targetIntakeQuota;                 //	Квота цільового прийому
    private String dDYear;                            //	Рік ДЗ *
    private String startDateOfStudy;                  //	Дата початку навчання
    private String graduationDate;                    //	Дата закінчення навчання
    private String structuralUnit;                    //	Структурний підрозділ
    private String group;                             //	Група
    private String swiftGroupName;                    //	Скор. назва групи
    private String course;                            //	Курс
    private String formOfStudy;                       //	Форма навчання
    private String oCRUnit;                           //	ОКР заг.
    private String oKRDetailed;                       //	ОКР детальний
    private String financing;                         //	Фінансування
    private String codeDirect;                        //	Код напряму
    private String direction;                         //	Напрям
    private String specialtyCode;                     //	Код  спеціальності
    private String specialty;                         //	Спеціальність
    private String specialization;                    //	Спеціалізація
    private String orderNo;                           //	№ наказу
    private String orderDate;                         //	Дата наказу
    private String typeOfOrder;                       //	Тип наказу
    private String reason;                            //	"Причина
    private String comment;                           //	Коментар
    private String studentTicket_series_number;       //	Студ. / учн. квиток (серія,  номер)
    private String studentTicket_valid_from_date;     //	Студ. / учн. квиток (діє з дати)
    private String studentTicket_valid_until_the_date;//	Студ. / учн. квиток (діє до дати)
    private String codePref;                          //	Код  попер.  НЗ
    private String thenameisforemost;                 //	Назва попер. НЗ
    private String categoryOffOreigners;              //	Категорія іноземців
    private String software;                          //	ПО *

    
    public MarksEntity(){

    }


    public MarksEntity(long studid, long SUBJECTID, long MARKS, long groupid, String GROUP_INDEX) {
        this.studid = studid;
        this.SUBJECTID = SUBJECTID;
        this.MARKS = MARKS;
        this.groupid = groupid;
        this.GROUP_INDEX = GROUP_INDEX;
    }



    public long getSUBJECTID() {
        return SUBJECTID;
    }

    public void setSUBJECTID(long SUBJECTID) {
        this.SUBJECTID = SUBJECTID;
    }

//    public String getMARKS() {
//        return MARKS;
//    }
//
//    public void setMARKS(String MARKS) {
//        this.MARKS = MARKS;
//    }


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getMARKS() {
        return MARKS;
    }

    public void setMARKS(long MARKS) {
        this.MARKS = MARKS;
    }

    public long getGroupid() {
        return groupid;
    }

    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }

    public String getGROUP_INDEX() {
        return GROUP_INDEX;
    }

    public void setGROUP_INDEX(String GROUP_INDEX) {
        this.GROUP_INDEX = GROUP_INDEX;
    }

    public long getStudid() {
        return studid;
    }

    public void setStudid(long studid) {
        this.studid = studid;
    }

    @Override
    public String toString() {
        return "MarksEntity{" +
                "ID=" + ID +
                ", studid=" + studid +
                ", SUBJECTID=" + SUBJECTID +
                ", MARKS=" + MARKS +
                ", groupid=" + groupid +
                ", GROUP_INDEX='" + GROUP_INDEX + '\'' +
                '}';
    }
}
