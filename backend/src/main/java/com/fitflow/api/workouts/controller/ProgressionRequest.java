package com.fitflow.api.workouts.controller;

import java.util.Map;

public class ProgressionRequest {
    
    private Map<String, ExerciseProgression> progressions;

    public Map<String, ExerciseProgression> getProgressions() {
        return progressions;
    }

    public void setProgressions(Map<String, ExerciseProgression> progressions) {
        this.progressions = progressions;
    }

    public static class ExerciseProgression {
        private int sets;
        private int reps;
        private int weight;

        public int getSets() {
            return sets;
        }

        public void setSets(int sets) {
            this.sets = sets;
        }

        public int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
