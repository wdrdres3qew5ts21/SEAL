/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.FileService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seal.FileService.model.SubjectFile;

/**
 *
 * @author wdrdr
 */
@Repository
public interface SubjectFileRepository extends JpaRepository<SubjectFile, Integer> {
    
    public List<SubjectFile> findBySubjectId(int subjectId);
    
}
