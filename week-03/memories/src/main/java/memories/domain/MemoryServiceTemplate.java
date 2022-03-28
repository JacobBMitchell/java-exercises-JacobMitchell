package memories.domain;

import memories.data.DataAccessException;
import memories.models.Memory;

import java.util.List;

public interface MemoryServiceTemplate {
    List<Memory> findPublicMemories() throws DataAccessException;

    List<Memory> findPrivateMemories() throws DataAccessException;

    MemoryResult add(Memory memory) throws DataAccessException;

    MemoryResult update(Memory memory) throws DataAccessException;

    MemoryResult deleteById(int memoryId) throws DataAccessException;
}
