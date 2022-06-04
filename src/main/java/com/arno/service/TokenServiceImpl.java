package com.arno.service;

import com.arno.domain.Token;
import com.arno.domain.User;
import com.arno.repository.TokenR;
import com.arno.repository.UserR;
import com.arno.rest.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenR tokenR;
    private final UserR userR;


    @Override
    public Token insert(String value, long expiration, int userId) {

        Optional<User> user = userR.findById(userId);

        if(user == null){
            User.builder()
                    .id(userId).build();
        }

        Token token = Token.builder()
                .value(value)
                .expiration(expiration)
                .user(userId)
                .build();

        return tokenR.save(token);
    }

    @Override
    public List<Token> getAll() {
        return tokenR.findAll();
    }

    @Override
    public Token getById(int id) {
        return tokenR.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        tokenR.deleteById(id);
    }

    @Override
    public Token getTokenByValue(String token) {
        return tokenR.getTokenByValue(token);
    }

    public Token generateToken(int userId){

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String value = bytes.toString();

        Token token = new Token();

        token.setValue(value);
        token.setExpiration(Instant.now().getEpochSecond());
        token.setUser(userId);

        return token;
    }
}
