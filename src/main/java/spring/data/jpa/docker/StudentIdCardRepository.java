package spring.data.jpa.docker;

import org.springframework.data.repository.CrudRepository;

import spring.data.jpa.docker.model.StudentIdCard;

public interface StudentIdCardRepository
        extends CrudRepository<StudentIdCard, Long> {
}
