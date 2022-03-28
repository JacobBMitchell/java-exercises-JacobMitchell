package memories.ui;

import memories.data.DataAccessException;
import memories.domain.DbResult;
import memories.domain.MemoryResult;
import memories.domain.MemoryServiceTemplate;
import memories.models.Memory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoryController {
    MemoryServiceTemplate service;

    MemoryController(MemoryServiceTemplate service){
        this.service = service;
    }

    @GetMapping("/api/getallmemories")
    public List<Memory> getAll(){
        try {
            return service.findPublicMemories();
        } catch (DataAccessException e) {
            return null;
        }
    }

    @PostMapping("/api/addmemory")
    public ResponseEntity<Memory> addMemory(@RequestBody Memory mem){
        try {
            //TODO: set following statement equal to DBResult
            MemoryResult serviceResult = service.add(mem);
            if (serviceResult.isSuccess() && serviceResult.getMemory() != null){
                //TODO:Add good ending
                return new ResponseEntity<>(serviceResult.getMemory(), HttpStatus.CREATED);
            }
            if (serviceResult.getMemory() == null){
                //TODO:Add 500 ending
                return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                //400 error
            }
        } catch (DataAccessException e) {
            //TODO:add bad data result 500
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @DeleteMapping("/api/delete/{id}")
    public boolean deleteId(@PathVariable int id){
        //System.out.println(id);
        try {
            MemoryResult result = service.deleteById(id);
            if (result.isSuccess()){
                return true;
            }
            else{
                return false;
            }
        } catch (DataAccessException e) {
            return false;
        }
    }

    @PutMapping("/api/update/{id}")
    public ResponseEntity<Memory> updateById(@PathVariable int id, @RequestBody Memory mem){
        if (mem.getId() <= 0) {
            mem.setId(id);
        }
        try {
            //TODO: set following statement equal to DBResult
            MemoryResult serviceResult = service.update(mem);
            if (serviceResult.isSuccess() && serviceResult.getMemory() != null){
                //TODO:Add good ending
                return new ResponseEntity<>(serviceResult.getMemory(), HttpStatus.CREATED);
            }
            if (serviceResult.getMemory() == null){
                //TODO:Add 500 ending
                return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                //400 error
            }
        } catch (DataAccessException e) {
            //TODO:add bad data result 500
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

}
