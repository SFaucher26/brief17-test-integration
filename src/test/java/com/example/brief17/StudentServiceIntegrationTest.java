package com.example.brief17;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.example.brief17.entity.Student;
import com.example.brief17.service.StudentService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;



@DataJpaTest
@Import(StudentService.class)

@ActiveProfiles("test")

class StudentServiceIntegrationTest {

    @Autowired
    private StudentService studentService;

    @Test
    void shouldSaveAndRetrieveStudent() {
        // Insertion d'un student
        Student student = new Student();
        student.setName("Marc");
        student.setAddress("12 rue des plantes");

        // Sauvegarde et récupération de l'objet avec l'ID généré
        Student savedStudent = studentService.saveStudent(student);

        // Vérification avec l'ID généré dynamiquement
        Optional<Student> studentById = studentService.findStudentById(savedStudent.getId());

        // Vérifier que le student est bien présent
        assertThat(studentById).isPresent();


        // Comparer les attributs de l'objet sauvegardé et récupéré

        assertThat(studentById.get().getId()).isEqualTo(savedStudent.getId());
        assertThat(studentById.get().getName()).isEqualTo(savedStudent.getName());
        assertThat(studentById.get().getAddress()).isEqualTo(savedStudent.getAddress());
    }
}