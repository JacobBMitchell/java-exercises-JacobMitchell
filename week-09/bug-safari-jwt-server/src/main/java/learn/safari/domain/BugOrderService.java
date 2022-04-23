package learn.safari.domain;

import learn.safari.data.BugOrderRepository;
import learn.safari.models.BugOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugOrderService {

    private final BugOrderRepository bugOrderRepository;

    public BugOrderService(BugOrderRepository bugOrderRepository) {
        this.bugOrderRepository = bugOrderRepository;
    }

    public List<BugOrder> findAll() {
        return bugOrderRepository.findAll();
    }
}
