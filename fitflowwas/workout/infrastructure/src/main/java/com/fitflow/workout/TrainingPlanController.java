package com.fitflow.workout;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training-plans")
class TrainingPlanController {

    private final TrainingPlanFacade trainingPlanFacade;

    TrainingPlanController(TrainingPlanFacade trainingPlanFacade) {
        this.trainingPlanFacade = trainingPlanFacade;
    }

    @PostMapping
    ResponseEntity<TrainingPlan> create(@RequestBody TrainingPlan toCreate) {
        TrainingPlanSnapshot result = trainingPlanFacade.save(toCreate);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    String ok() {
        return "OK";
    }
}
