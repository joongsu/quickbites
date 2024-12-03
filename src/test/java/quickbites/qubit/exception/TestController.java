package quickbites.qubit.exception;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickbites.qubit.global.exception.CustomException;
import quickbites.qubit.global.response.error.ErrorType;

@SpringBootTest
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/not-found")
    public void throwNotFoundException() {
        throw new CustomException(ErrorType.NOT_FOUND);
    }

    @GetMapping("/exception")
    public void throwException() throws Exception {
        throw new Exception("test exception");
    }
}
