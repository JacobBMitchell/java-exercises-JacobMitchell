package memories.domain;

import memories.models.Memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryResult {// is an error message handler

    private ArrayList<String> messages = new ArrayList<>();
    private Memory memory;

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message){
        messages.add(message);
    }

    public boolean isSuccess() {
        return messages.size() == 0;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory){
        this.memory = memory;
    }

}
