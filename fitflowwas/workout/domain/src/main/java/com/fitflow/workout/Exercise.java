package com.fitflow.workout;


class Exercise {
    private String name;
    private String tips;

    Exercise() {
    }

    Exercise(String name, String tips) {
        this.name = name;
        this.tips = tips;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getTips() {
        return tips;
    }

    void setTips(String tips) {
        this.tips = tips;
    }
}
