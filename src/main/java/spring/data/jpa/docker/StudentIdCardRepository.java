package spring.data.jpa.docker;

import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository
        extends CrudRepository<StudentIdCard, Long> {
}
