package io.github.oleiva.ivasoft.jpa;

import io.github.oleiva.ivasoft.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;


public interface MarksJpa  extends JpaRepository<MarksEntity, Long> {

//    String lastIssueByIssueID = "SELECT h.* FROM history AS h , ( " +
//            "    SELECT MAX(id) AS ID " +
//            "    FROM history as h2 " +
//            "    WHERE issue_id = :issueId " +
//            "    GROUP BY issue_id " +
//            ") AS hMaxId " +
//            "WHERE h.id = hMaxId.ID";

//    String lastIssueByIssueID = "SELECT * FROM marks INNER JOIN subjects ON marks.subjectid =subjects.id WHERE stud_id=:student_id";
//    @Query(value = lastIssueByIssueID, nativeQuery = true)
//    MarksEntity getMarksEntitiesBySTUD_ID(@Param("student_id") long student);
//
//    List<MarksEntity> findByGroupid (long group_id);


    String lastIssue = "SELECT studid FROM marks WHERE groupid=:group_Id";
    @Query(value = lastIssue, nativeQuery = true)
    Set<BigInteger> getStudents(@Param("group_Id") long issueId);

    List<MarksEntity> getByStudid (long studId);


    String lastmarks = "SELECT subjectid FROM marks WHERE groupid=:group_Id";
    @Query(value = lastmarks, nativeQuery = true)
    Set<BigInteger> getMarks(@Param("group_Id") long issueId);



}
