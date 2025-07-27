package com.piturria.TasksWebApp.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken() {     //https://www.jwt.io
//        https://www.scottbrady.io/tools/jwt
//        Header: { "alg": "HS256", "typ": "JWT" }
//        Decoded Payload: { "sub": "1234567890", "name": "John Doe", "admin": true, "iat": 1753653262 }
//        Generate Hash with encoding algorithm

        String fakeJWT="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
        return fakeJWT;
    }
}
