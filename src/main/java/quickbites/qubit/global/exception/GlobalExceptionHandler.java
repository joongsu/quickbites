package quickbites.qubit.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import quickbites.qubit.global.response.error.ErrorRes;
import quickbites.qubit.global.response.error.ErrorType;

import static quickbites.qubit.global.response.error.ErrorType.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //커스텀 에러
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<?> handleCustomException(CustomException e) {
        ErrorType errorType = e.getErrorType();
        ErrorRes error = ErrorRes.of(errorType.getStatusCode(), errorType.getMessage());
        log.error("Error occurred : [errorCode={}, message={}]",e.getClass(), e.getMessage());;
        return ResponseEntity.status(error.status()).body(error);
    }

    // 설정하지 않은 예외 전부 처리
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleException(Exception e) {
        ErrorRes error = ErrorRes.of(INTERNAL_SERVER_ERROR.getStatusCode(), INTERNAL_SERVER_ERROR.getMessage());
        log.error("Error occurred : [errorCode={}, message={}]",e.getClass(), e.getMessage());
        return ResponseEntity.status(error.status()).body(error);
    }
}
