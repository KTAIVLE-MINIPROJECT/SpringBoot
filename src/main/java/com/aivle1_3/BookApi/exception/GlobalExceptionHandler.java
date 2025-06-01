package com.aivle1_3.BookApi.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 500);
        body.put("message", "서버 내부 오류가 발생했습니다. 관리자에게 문의하세요.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", 400);
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> response = new HashMap<>();
        String msg = ex.getMessage();

        if (msg != null && msg.contains("권한이 없습니다")) {
            response.put("status", 403);
            response.put("message", msg);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } else if (msg != null && msg.contains("로그인이 필요합니다")) {
            response.put("status", 401);
            response.put("message", msg);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            // 기타 RuntimeException은 400 (Bad Request)
            response.put("status", 400);
            response.put("message", msg);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

