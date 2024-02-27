package com.cihanyildiz.controller;

import com.cihanyildiz.entity.Worker;
import com.cihanyildiz.service.WorkerService;
import org.hibernate.jdbc.Work;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers(){
        return ResponseEntity.ok(workerService.getAllWorker());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id){
        return ResponseEntity.ok(workerService.getWorkerById(id));
    }

    @PostMapping                               // burda neden id de tanımlamıyoruz sonuçta yeni bir kullanıcı kaydediyoruz
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker){
        //return ResponseEntity.ok(workerService.createWorker(worker)); // çalışmaz mı
        return new ResponseEntity<>(workerService.createWorker(worker), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updatedWorker(@PathVariable Long id, @RequestBody Worker worker) {
        return ResponseEntity.ok(workerService.updateWorker(id,worker));
    }

    @DeleteMapping({"/{id}"})
    public void deleteWorker(@PathVariable Long id){
        workerService.deleteWorker(id);
    }
}
