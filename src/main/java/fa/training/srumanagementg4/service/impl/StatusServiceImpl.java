package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.entities.Status;
import fa.training.srumanagementg4.repository.StatusRepository;
import fa.training.srumanagementg4.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
