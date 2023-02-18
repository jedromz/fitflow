package com.fitflow.workout;

import com.fitflow.workout.dto.TrainingPlanDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training-plans")
class TrainingPlanController {

    private final TrainingPlanFacade trainingPlanFacade;
    private final TrainingPlanQueryRepository trainingPlanQueryRepository;

    TrainingPlanController(TrainingPlanFacade trainingPlanFacade, TrainingPlanQueryRepository trainingPlanQueryRepository) {
        this.trainingPlanFacade = trainingPlanFacade;
        this.trainingPlanQueryRepository = trainingPlanQueryRepository;
    }

    @PostMapping
    ResponseEntity<TrainingPlanDto> create(@RequestBody TrainingPlanDto toCreate) {
        trainingPlanFacade.save(toCreate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<TrainingPlanDto> update(@PathVariable String id, @RequestBody TrainingPlanDto toCreate) {
        trainingPlanFacade.save(toCreate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<TrainingPlanDto> get(@PathVariable int id) {
        return trainingPlanQueryRepository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable int id) throws Exception {
        trainingPlanFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
