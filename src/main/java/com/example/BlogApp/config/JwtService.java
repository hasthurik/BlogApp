//package com.example.BlogApp.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//
//    private static final String SECRET_KEY = "3df18585ff152b6d70def51c025a01af732e075aa9856dff2edc801490a9270703719fe4fe85a3b85a17f21f1fd7a80102df6a6d6a9de66bdaf4e6864ec826f6";
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
////    public String generateToken(
////            Map<String, Object> extractClaims,
////            UserDetails userDetails
////    )
//
//    private Claims extractAllClaims(String token) {
//        return Jwts
//                .parser() // Создает парсер для JWT
//                .setSigningKey(getSignInKey()) // Устанавливает ключ для проверки подписи
//                .build() // Собирает парсер
//                .parseClaimsJws(token) // Парсит JWT и проверяет его подпись
//                .getBody(); // Возвращает тело (payload) JWT в виде объекта Claims
//    }
//
//    private Key getSignInKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//}
