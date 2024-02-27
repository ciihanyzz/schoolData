package com.cihanyildiz.service;

import com.cihanyildiz.entity.Worker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface WorkerService {

    Worker createWorker(Worker worker);
    List<Worker> getAllWorker();
    Worker getWorkerById(Long id);               // burada neden @RequestBody veya @PathVariable kullanmıyoz
    Worker updateWorker(Long id, Worker worker);
    void deleteWorker(Long id);

}
