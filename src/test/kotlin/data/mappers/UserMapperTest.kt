package data.mappers

import org.example.data.entities.UserEntity
import org.example.data.mappers.UserMapper
import org.example.domain.models.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserMapperTest {
    private val mapper = UserMapper()

    @Test
    fun `check toDomain`(){
        val userEntityStudent = UserEntity("", "", "@", listOf(), UserType.STUDENT)
        val userEntityGuest = UserEntity("", "", "@", listOf(), UserType.GUEST)
        val userEntityFaculty = UserEntity("", "", "@", listOf(), UserType.FACULTY)

        val student = mapper.toUser(userEntityStudent)
        val guest = mapper.toUser(userEntityGuest)
        val faculty = mapper.toUser(userEntityFaculty)

        //check Student
        assertEquals("", student.name)
        assertEquals("", student.userId)
        assertEquals("@", student.email)
        assertEquals(listOf<String>(), student.borrowedBooks)
        assertTrue(student as? Student != null)

        // check Guest
        assertEquals("", guest.name)
        assertEquals("", guest.userId)
        assertEquals("@", guest.email)
        assertEquals(listOf<String>(), guest.borrowedBooks)
        assertTrue(guest as? Guest != null)

        //check Student
        assertEquals("", faculty.name)
        assertEquals("", faculty.userId)
        assertEquals("@", faculty.email)
        assertEquals(listOf<String>(), faculty.borrowedBooks)
        assertTrue(faculty as? Faculty != null)
    }

    @Test
    fun `check toEntity`(){
        val student = Student("", "", "@")
        val guest = Guest("", "", "@")
        val faculty = Faculty("", "", "@")

        val studentEntity = mapper.toUserEntity(student)
        val guestEntity = mapper.toUserEntity(guest)
        val facultyEntity = mapper.toUserEntity(faculty)

        // check userEntity
        assertEquals("", studentEntity.name)
        assertEquals("", studentEntity.userId)
        assertEquals("@", studentEntity.email)
        assertEquals(listOf<String>(), studentEntity.booksList)
        assertEquals(UserType.STUDENT, studentEntity.type)

        // check facultyEntity
        assertEquals("", facultyEntity.name)
        assertEquals("", facultyEntity.userId)
        assertEquals("@", facultyEntity.email)
        assertEquals(listOf<String>(), facultyEntity.booksList)
        assertEquals(UserType.FACULTY, facultyEntity.type)

        // check guestEntity
        assertEquals("", guestEntity.name)
        assertEquals("", guestEntity.userId)
        assertEquals("@", guestEntity.email)
        assertEquals(listOf<String>(), guestEntity.booksList)
        assertEquals(UserType.GUEST, guestEntity.type)
    }
}