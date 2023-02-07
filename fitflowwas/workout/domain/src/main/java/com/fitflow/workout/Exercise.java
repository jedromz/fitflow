package com.fitflow.workout;


import com.fitflow.workout.vo.ExerciseId;
import com.fitflow.workout.vo.ExerciseName;
import com.fitflow.workout.vo.ExerciseTips;

class Exercise {
    private ExerciseId exerciseId;
    private ExerciseName name;
    private ExerciseTips tips;

    Exercise(ExerciseId exerciseId, ExerciseName name, ExerciseTips tips) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.tips = tips;
    }

    ExerciseName getName() {
        return name;
    }

    void setName(ExerciseName name) {
        this.name = name;
    }

    ExerciseTips getTips() {
        return tips;
    }

    void setTips(ExerciseTips tips) {
        this.tips = tips;
    }

    ExerciseId getExerciseId() {
        return exerciseId;
    }
}
