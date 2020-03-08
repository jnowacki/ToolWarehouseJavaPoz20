package pl.jnowacki.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void hashPassword() {
        System.out.println(PasswordUtil.hashPassword("user2"));
    }

    @Test
    public void checkPassword() {
    }
}