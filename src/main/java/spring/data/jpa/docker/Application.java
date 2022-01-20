package spring.data.jpa.docker;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.List;
import spring.data.jpa.docker.model.Book;
import spring.data.jpa.docker.model.Course;
import spring.data.jpa.docker.model.Enrolment;
import spring.data.jpa.docker.model.EnrolmentId;
import spring.data.jpa.docker.model.Student;
import spring.data.jpa.docker.model.StudentIdCard;

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

            //Création d'un étudiant
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));

            //Ajouter des livres  à l'étudiant
            student.addBook(new Book("Clean Code", LocalDateTime.now().minusDays(4)));
            student.addBook(new Book("Think and Grow Rich", LocalDateTime.now()));
            student.addBook(new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

            //Ajouter un IdCard à l'étudiant
            StudentIdCard studentIdCard = new StudentIdCard("123456789",student);
            student.setStudentIdCard(studentIdCard);

            //Ajouter des inscriptions à l'étudiant
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 1L),
                    student,
                    new Course("Computer Science", "IT"),
                    LocalDateTime.now()
            ));
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    student,
                    new Course("Amigoscode Spring Data JPA", "IT"),
                    LocalDateTime.now().minusDays(18)
            ));
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    student,
                    new Course("Amigoscode Spring Data JPA", "IT"),
                    LocalDateTime.now().minusDays(18)
            ));


            //Enregistrer un étudiant dans la BDD
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
