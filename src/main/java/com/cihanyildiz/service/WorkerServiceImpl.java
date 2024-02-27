package com.cihanyildiz.service;

import com.cihanyildiz.entity.Worker;
import com.cihanyildiz.repository.WorkerRepository;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> getAllWorker() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id).orElse(null);
    }

    @Override
    public Worker updateWorker(Long id, Worker worker) {
        Optional<Worker> existingWorker = workerRepository.findById(id);
        if (existingWorker.isPresent()){
            Worker updatedWorker = existingWorker.get();
            updatedWorker.setFirstName(worker.getFirstName());
            updatedWorker.setLastName(worker.getLastName());
            updatedWorker.setBranch(worker.getBranch());
            updatedWorker.setSalary(worker.getSalary());

            return updatedWorker;
        }
        return null;
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
        // boş döndürünce return yazmaya gerek kalmıyormu ???
            // return yazınca hata veriyo
    }
}
