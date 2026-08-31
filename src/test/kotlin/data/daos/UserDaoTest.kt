package data.daos

import org.example.data.daos.UserDao
import org.example.data.mappers.BorrowingRecordMapper
import org.example.data.mappers.UserMapper
import org.example.domain.models.UserType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class UserDaoTest {
    private lateinit var userDao: UserDao

    @BeforeEach
    fun initDao() {
        val mapper = UserMapper()
        userDao = UserDao(mapper)
    }

    @Test
    fun `check register user`() {
        val id0 = userDao.registerUser("student", "a@a", UserType.STUDENT)
        val id1 = userDao.registerUser("guest", "a@a", UserType.GUEST)
        val id2 = userDao.registerUser("faculty", "a@a", UserType.FACULTY)

        assertEquals("0", id0)
        assertEquals("1", id1)
        assertEquals("2", id2)

        assertThrows<IllegalArgumentException> {
            userDao.registerUser("error", "incorrect", UserType.FACULTY)
        }
        assertThrows<IllegalArgumentException> {
            userDao.registerUser("error", "incorrect", UserType.STUDENT)
        }
        assertThrows<IllegalArgumentException> {
            userDao.registerUser("error", "incorrect", UserType.GUEST)
        }
    }

    @Test
    fun `check find user`() {
        val id0 = userDao.registerUser("student", "a@a", UserType.STUDENT)
        val id1 = userDao.registerUser("guest", "a@a", UserType.GUEST)
        val id2 = userDao.registerUser("faculty", "a@a", UserType.FACULTY)

        assertEquals(null, userDao.findUser("9"))
        assertEquals("0", userDao.findUser("0")?.userId)
    }

    @Test
    fun `check get users`() {
        val id0 = userDao.registerUser("student", "a@a", UserType.STUDENT)
        val id1 = userDao.registerUser("guest", "a@a", UserType.GUEST)
        val id2 = userDao.registerUser("faculty", "a@a", UserType.FACULTY)

        assertEquals(3, userDao.getAllUsers().size)
        assertEquals(listOf("0", "1", "2"), userDao.getAllUsers().map { it.userId })
    }


}