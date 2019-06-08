package com.amdocs.hackathon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.amdocs.hackathon.ErrorCode.InternalServerError;
import static org.springframework.http.HttpStatus.valueOf;

@RestControllerAdvice
public class BaseController {

  private static AppException convertToAppEx(Throwable th) {
    if (th instanceof AppException) return (AppException) th;
    return new AppException(InternalServerError);
  }

  @ExceptionHandler(AppException.class)
  public ResponseEntity<Object> appExceptionHandler(HttpServletRequest req, AppException appEx) {
    Map<String, Object> errorMap = new HashMap<>();

    return new ResponseEntity<>(errorMap, valueOf(appEx.statusCode()));
  }
}
