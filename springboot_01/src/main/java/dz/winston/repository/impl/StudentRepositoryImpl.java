package dz.winston.repository.impl;

import dz.winston.entity.Student;
import dz.winston.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<Long, Student>();
        studentMap.put(1L,new Student(1L,"张三",23));
        studentMap.put(2L,new Student(2L,"李四",24));
        studentMap.put(3L,new Student(3L,"王五",25));
    }

    public Collection<Student> findAll() {
        return studentMap.values();
    }

    public Student findById(long id) {
        return studentMap.get(id);
    }

    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
