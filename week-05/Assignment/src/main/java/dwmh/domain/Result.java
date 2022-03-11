package dwmh.domain;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
    private List<String> errors = new ArrayList<>();
    private T payload;


    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isSuccess(){
        return errors.size() == 0;
    }
}
