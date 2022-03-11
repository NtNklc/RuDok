package rudok.action.error;

public class ErrorClass {
    private ErrorEnum error;
    private String msg;

    public ErrorClass(String msg, ErrorEnum error){
        this.error = error;
        this.msg = msg;
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
