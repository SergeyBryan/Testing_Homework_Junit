package com.example.testing_homework_junit.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.testing_homework_junit.constants.UserTestConstants.*;


public class UserTest {
    final User out = new User(CORRECT_LOGIN, CORRECT_EMAIL);

    @Test
    public void ShouldCreateUserWithWrongArguments() {
        Assertions.assertThrows(IllegalArgumentException.class,()->new User(EMPTY_LOGIN, CORRECT_EMAIL));
        Assertions.assertThrows(IllegalArgumentException.class,()->new User(CORRECT_EMAIL, CORRECT_EMAIL));
        Assertions.assertThrows(IllegalArgumentException.class,()->new User(CORRECT_LOGIN, ILLEGAL_EMAIL));
        Assertions.assertDoesNotThrow(()->new User(CORRECT_LOGIN, CORRECT_EMAIL));
    }

    @Test
    public void shouldCreateUserWithoutArguments() {
        User userNullable = new User();
        Assertions.assertNotNull(userNullable);
    }

    @Test
    public void shouldUserSetEmptyLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.setLogin(EMPTY_LOGIN));
    }

    @Test
    public void shouldUserSetBlankLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.setLogin(ONLY_SPACES_LOGIN));
    }

    @Test()
    public void shouldUserSetNullLogin() {
        Assertions.assertThrows(NullPointerException.class, () -> out.setLogin(null));
    }


    @Test
    public void shouldUserSetCorrectLogin() {
        out.setLogin(ONE_BIG_LETTER_LOGIN);
        Assertions.assertEquals(CORRECT_LOGIN, out.getLogin());
    }


    @Test
    public void shouldUserSetUpperCaseLogin() {
        out.setLogin(UPPER_CASE_LOGIN);
        Assertions.assertEquals(CORRECT_LOGIN, out.getLogin());
    }

    @Test
    public void shouldUserSetCorrectEmail() {
        out.setEmail(CORRECT_EMAIL);
        Assertions.assertEquals(CORRECT_EMAIL, out.getEmail());
    }

    @Test
    public void shouldUserSetDotEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.setEmail(ONLY_DOT_EMAIL));
    }

    @Test
    public void shouldUserSetWithoutDotEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.setEmail(WITHOUT_DOT_EMAIL));
    }

    @Test
    public void shouldUserSetIllegalEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.setEmail(ILLEGAL_EMAIL));
    }

    @Test
    public void shouldUserSetUpperCaseEmail() {
        out.setEmail(UPPER_CASE_EMAIL);
        Assertions.assertEquals(CORRECT_EMAIL, out.getEmail());
    }

    @Test
    public void shouldUserSetOneBigLetterCaseEmail() {
        out.setEmail(ONE_BIG_LETTER_CASE_EMAIL);
        Assertions.assertEquals(CORRECT_EMAIL, out.getEmail());
    }

    @Test
    public void shouldUserEmailNotEqualWithLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.setLogin(CORRECT_EMAIL));
    }
}
