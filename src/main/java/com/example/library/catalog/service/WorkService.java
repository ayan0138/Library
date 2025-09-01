package com.example.library.catalog.service;

import com.example.library.catalog.model.Work;
import com.example.library.catalog.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class WorkService {

    private final WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
}
    public void createWork(Work work) {
        return;

}
    public List<Work> getAllWorks(String title) {
        return workRepository.findByTitleContaining(title);
}

    public Work getWorkById(Long id) {
        Optional<Work> work = workRepository.findById(id);
        if (work.isPresent()) {
            return work.get();

}
    throw new RuntimeException("Work not found with id:" + id ) ;


}
    public void updateWork(Long id, Work work)  {
        return;
    
}
    public void deleteWork(Long id) {
        if (workRepository.existsById(id)) {
            workRepository.deleteById(id);
        } else {
            throw new RuntimeException("Work not found with this id:" + id) ;
        }


}
     public void searchWorks(String title) {
        return;
}
}
