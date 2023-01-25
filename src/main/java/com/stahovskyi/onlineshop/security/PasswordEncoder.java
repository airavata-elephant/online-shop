package com.stahovskyi.onlineshop.security;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class PasswordEncoder { // todo -> static context ??

    public String generateHash(String password, String salt) {
        return DigestUtils.md2Hex(password + salt);
    }

    public String generateSalt() {
        return UUID.randomUUID().toString();
    }

}