package fittoring.mentoring.presentation;

import org.springframework.http.ResponseCookie;

public class CookieProvider {

    public static ResponseCookie createCookie(final String name, final String value) {
        return ResponseCookie.from(name, value)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("None")
                .build();
    }

    public static ResponseCookie clearCookie(final String name) {
        return ResponseCookie.from(name, "")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("None")
                .maxAge(0)
                .build();
    }
}
