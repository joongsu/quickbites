package quickbites.qubit.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import quickbites.qubit.global.response.error.ErrorType;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorType errorType;
}
