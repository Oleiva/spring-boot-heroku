package io.github.oleiva.ivasoft.entity;//package io.github.Oleiva.entity;
// https://dba.stackexchange.com/questions/116580/student-who-got-max-marks-in-subject

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studid;

//    @NotNull
//    @Column(name = "studname")
//    private String studname;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;


    @Column(name = "fiohash", unique = true)
    private String fiohash;

    public StudentEntity(String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.fiohash = makeFioHash(name, surname, patronymic);
    }

    public StudentEntity() {

    }

    @Column(name = "nopp")
    private String nopp;                              //	"№ п/п"

    @Column(name = "codeinthesite")
    private String codeInTheSITE;                     //	Код в ЄДЕБО

    @Column(name = "studentname")
    private String studentName;                       //	ПІБ студента

    @Column(name = "nameoftheenglish")
    private String nameOfTheEnglish;                  //	ПІБ англ.

    @Column(name = "addressofresidence")
    private String addressOfResidence;                //	Адреса проживання

    @Column(name = "typeofstateofemergency")
    private String typeOfStateOfEmergency;            //	Тип НП *

    @Column(name = "passportnumberbirthbertificate")
    private String passportNumberBirthBertificate;    //	Серія,№ паспорту (свідоцтва про народження)

    @Column(name = "dateofbirth")
    private String dateOFbirth;                       //	"Дата народження

    @Column(name = "sex")
    private String Sex;                               //	Стать

    @Column(name = "gu")
    private String gu;                                //	ГУ *

    @Column(name = "country")
    private String country;                           //	Країна

//    @Column(name = "placeOfBirth")
//    private String placeOfBirth;                      //	Місце народження
//
//    @Column(name = "contacts")
//    private String contacts;                          //	Контакти
//
//    @Column(name = "parents_guardians_Name_and_contact")
//    private String parents_guardians_Name_and_contact;//	Батьки (опікуни): ПІБ та контакти
//
//    @Column(name = "ipn")
//    private String IPN;                               //	ІПН *
//
//    @Column(name = "dock_type_that_reason_of_debris")
//    private String docktypethatreasonofdebris;   //	Тип док-ту, що є основою зарах.
//
//    @Column(name = "docSeriesForEntry")
//    private String docSeriesForEntry;                 //	Серія док-ту (для вступу)
//
//    @Column(name = "numberofofocsreasonofdebris")
//    private String number_of_docs_reason_of_debris;   //	"Номер док-ту, що є основою зарах.
//
//    @Column(name = "dateofdocthatreasonofdebris")
//    private String date_of_doc_that_reason_of_debris; //	Дата док-ту, що є основою зарах.
//
//    @Column(name = "issued_by")
//    private String issued_by;                         //	Ким видано
//
//    @Column(name = "theaveragescoreisdock")
//    private String theAverage_score_is_dock;          //	Середній бал док-ту
//
//    @Column(name = "ballForEntry")
//    private String ballForEntry;                      //	Бал для вступу
//
//    @Column(name = "inosLanguageStudied")
//    private String inosLanguageStudied;               //	Іноз. мова, що вивчалася
//
//    @Column(name = "privilegeForEntry")
//    private String privilegeForEntry;                 //	Пільга для вступу
//
//    @Column(name = "basisForIF")
//    private String basisForIF;                        //	Підстава для ПЧ *
//
//    @Column(name = "targetIntakeQuota")
//    private String targetIntakeQuota;                 //	Квота цільового прийому
//
//    @Column(name = "dDYear")
//    private String dDYear;                            //	Рік ДЗ *
//
//    @Column(name = "startDateOfStudy")
//    private String startDateOfStudy;                  //	Дата початку навчання
//
//    @Column(name = "graduationDate")
//    private String graduationDate;                    //	Дата закінчення навчання
//
//    @Column(name = "structuralUnit")
//    private String structuralUnit;                    //	Структурний підрозділ
//
//    @Column(name = "group")
//    private String group;                             //	Група
//
//    @Column(name = "swiftGroupName")
//    private String swiftGroupName;                    //	Скор. назва групи
//
//    @Column(name = "course")
//    private String course;                            //	Курс
//
//    @Column(name = "formOfStudy")
//    private String formOfStudy;                       //	Форма навчання
//
//    @Column(name = "oCRUnit")
//    private String oCRUnit;                           //	ОКР заг.
//
//    @Column(name = "oKRDetailed")
//    private String oKRDetailed;                       //	ОКР детальний
//
//    @Column(name = "financing")
//    private String financing;                         //	Фінансування
//
//    @Column(name = "codeDirect")
//    private String codeDirect;                        //	Код напряму
//
//    @Column(name = "direction")
//    private String direction;                         //	Напрям
//
//    @Column(name = "specialtyCode")
//    private String specialtyCode;                     //	Код  спеціальності
//
//    @Column(name = "specialty")
//    private String specialty;                         //	Спеціальність
//
//    @Column(name = "specialization")
//    private String specialization;                    //	Спеціалізація
//
//    @Column(name = "orderNo")
//    private String orderNo;                           //	№ наказу
//
//    @Column(name = "orderDate")
//    private String orderDate;                         //	Дата наказу
//
//    @Column(name = "typeOfOrder")
//    private String typeOfOrder;                       //	Тип наказу
//
//    @Column(name = "reason")
//    private String reason;                            //	"Причина
//
//    @Column(name = "comment")
//    private String comment;                           //	Коментар
//
//    @Column(name = "studentTicket_series_number")
//    private String studentTicket_series_number;       //	Студ. / учн. квиток (серія,  номер)
//
//    @Column(name = "studentTicket_valid_from_date")
//    private String studentTicket_valid_from_date;     //	Студ. / учн. квиток (діє з дати)
//
//    @Column(name = "studentTicket_valid_until_the_date")
//    private String studentTicket_valid_until_the_date;//	Студ. / учн. квиток (діє до дати)
//
//    @Column(name = "codePref")
//    private String codePref;                          //	Код  попер.  НЗ
//
//    @Column(name = "thenameisforemost")
//    private String thenameisforemost;                 //	Назва попер. НЗ
//
//    @Column(name = "categoryofforeigners")
//    private String categoryOffOreigners;              //	Категорія іноземців
//
//    @Column(name = "software")
//    private String software;                          //	ПО *


    public long getStudid() {
        return studid;
    }

    public void setStudid(long studid) {
        this.studid = studid;
    }

    public String getFiohash() {
        return fiohash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String makeFioHash(String name, String surname, String patronymic) {
        String text = surname + name.substring(0, 1) + patronymic.substring(0, 1);
        System.out.println("## " + text);
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(text);
        return sha256hex;
    }

    public void setFiohash(String fiohash) {
        this.fiohash = fiohash;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studid=" + studid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", fiohash='" + fiohash + '\'' +
                '}';
    }

    public String getNopp() {
        return nopp;
    }

    public void setNopp(String nopp) {
        this.nopp = nopp;
    }

    public String getCodeInTheSITE() {
        return codeInTheSITE;
    }

    public void setCodeInTheSITE(String codeInTheSITE) {
        this.codeInTheSITE = codeInTheSITE;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getNameOfTheEnglish() {
        return nameOfTheEnglish;
    }

    public void setNameOfTheEnglish(String nameOfTheEnglish) {
        this.nameOfTheEnglish = nameOfTheEnglish;
    }

    public String getAddressOfResidence() {
        return addressOfResidence;
    }

    public void setAddressOfResidence(String addressOfResidence) {
        this.addressOfResidence = addressOfResidence;
    }

    public String getTypeOfStateOfEmergency() {
        return typeOfStateOfEmergency;
    }

    public void setTypeOfStateOfEmergency(String typeOfStateOfEmergency) {
        this.typeOfStateOfEmergency = typeOfStateOfEmergency;
    }

    public String getPassportNumberBirthBertificate() {
        return passportNumberBirthBertificate;
    }

    public void setPassportNumberBirthBertificate(String passportNumberBirthBertificate) {
        this.passportNumberBirthBertificate = passportNumberBirthBertificate;
    }

    public String getDateOFbirth() {
        return dateOFbirth;
    }

    public void setDateOFbirth(String dateOFbirth) {
        this.dateOFbirth = dateOFbirth;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
