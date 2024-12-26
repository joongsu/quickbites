package quickbites.qubit.global.response.success;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessType {

    //200
    OK(HttpStatus.OK, "요청이 성공했습니다.");

    private final HttpStatus status;
    private final String message;

    public int getStatusCode(){
        return status.value();
    }
}
