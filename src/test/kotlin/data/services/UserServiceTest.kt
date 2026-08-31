package data.services

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.example.data.daos.UserDao
import org.example.data.services.UserService
import org.example.domain.models.Student
import org.example.domain.models.UserType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class UserServiceTest {
    private val userDao = mockk<UserDao>()
    private val userService = UserService(userDao)

    @Test
    fun `check add new user`() {
        every { userDao.registerUser("", "", UserType.GUEST) } throws IllegalArgumentException()
        every { userDao.registerUser("", "@", UserType.GUEST) } returns "0"

        assertThrows<IllegalArgumentException> {
            userService.registerUser("", "", UserType.GUEST)
        }

        assertEquals("0", userService.registerUser("", "@", UserType.GUEST))
    }

    @Test
    fun `check find users`() {
        val correctUser = Student("", "", "@")

        every { userDao.findUser("correct") } returns correctUser
        every { userDao.findUser("incorrect") } returns null

        assertEquals(null, userService.findUser("incorrect"))
        assertEquals(correctUser, userService.findUser("correct"))
    }

    @Test
    fun `check getAllUsers`() {
        every { userDao.getAllUsers() } returns emptyList()

        assertEquals(emptyList(), userService.getAllUsers())
    }

    @Test
    fun `check save in file`(){
        every{userDao.saveUserInFile()} just Runs

        assertEquals(Unit, userService.saveInFile())
    }
}