package quickbites.qubit.global.response.error;


public record ErrorRes (
        int status,
        String message
){
    public static ErrorRes of(int status , String message) {
        return new ErrorRes(status, message);
    }

    public static ErrorRes from(ErrorType error){
        return new ErrorRes(error.getStatusCode(), error.getMessage());
    }
}
