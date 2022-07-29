package spring.data.jpa.docker;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository) {
        return args -> {
            Faker faker = new Faker();

            /**
             * Create a student with fake data
             */
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 30));

            /**
             * Add books to the student
             */
            student.addBook(new Book("Spring boot in action", LocalDateTime.now().minusDays(4)));
            student.addBook(new Book("Master Docker", LocalDateTime.now()));
            student.addBook(new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

            /**
             * Add an IdCart to the student
             */
            StudentIdCard studentIdCard = new StudentIdCard("123456789",student);
            student.setStudentIdCard(studentIdCard);

            /**
             * Add subscription to a courses
             */
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 1L),
                    student,
                    new Course("Computer Science Course", "IT"),
                    LocalDateTime.now()
            ));
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    student,
                    new Course("Spring Data JPA Course", "IT"),
                    LocalDateTime.now().minusDays(18)
            ));
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    student,
                    new Course("Docker Course", "IT"),
                    LocalDateTime.now().minusDays(18)
            ));

            /**
             * Save a student in the database
             */
            studentRepository.save(student);
             
            studentRepository.findById(1L)
                    .ifPresent(s -> {
                        System.out.println("fetch book lazy...");
                        List<Book> books = student.getBooks();
                        books.forEach(book -> {
                            System.out.println(
                                    s.getFirstName() + " borrowed " + book.getBookName());
                        });
                    });

        };
    }
}
