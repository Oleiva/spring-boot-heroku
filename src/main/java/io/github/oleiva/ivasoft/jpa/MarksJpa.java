package io.github.oleiva.ivasoft.jpa;

import io.github.oleiva.ivasoft.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MarksJpa  extends JpaRepository<MarksEntity, Long> {

//    String lastIssueByIssueID = "SELECT h.* FROM history AS h , ( " +
//            "    SELECT MAX(id) AS ID " +
//            "    FROM history as h2 " +
//            "    WHERE issue_id = :issueId " +
//            "    GROUP BY issue_id " +
//            ") AS hMaxId " +
//            "WHERE h.id = hMaxId.ID";

    String lastIssueByIssueID = "SELECT * FROM marks INNER JOIN subjects ON marks.subjectid =subjects.id WHERE stud_id =7284";
    @Query(value = lastIssueByIssueID, nativeQuery = true)
    MarksEntity getMarksEntitiesBySTUD_ID(@Param("issueId") long issueId);
}
