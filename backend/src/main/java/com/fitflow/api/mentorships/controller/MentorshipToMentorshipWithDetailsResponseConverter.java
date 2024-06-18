package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.dto.MentorshipResponseWithDetails;
import com.fitflow.api.mentorships.model.Mentorship;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
public class MentorshipToMentorshipWithDetailsResponseConverter implements Converter<Mentorship, MentorshipResponseWithDetails> {
    @Override
    public MentorshipResponseWithDetails convert(MappingContext<Mentorship, MentorshipResponseWithDetails> mappingContext) {
        Mentorship mentorship = mappingContext.getSource();
        MentorshipResponseWithDetails response = new MentorshipResponseWithDetails();

        response.setFromDate(mentorship.getFromDate());
        response.setToDate(mentorship.getToDate());
        response.setPrice(mentorship.getPrice());

        MentorshipResponseWithDetails.TraineeDetails traineeDetails = new MentorshipResponseWithDetails.TraineeDetails();
        traineeDetails.setName(mentorship.getTrainee().getName());
        traineeDetails.setEmail(mentorship.getTrainee().getEmail());
        traineeDetails.setHeight(mentorship.getTrainee().getHeight());
        traineeDetails.setWeight(mentorship.getTrainee().getWeight());
        response.setTrainee(traineeDetails);

        MentorshipResponseWithDetails.TrainerDetails trainerDetails = new MentorshipResponseWithDetails.TrainerDetails();
        trainerDetails.setName(mentorship.getTrainer().getName());
        trainerDetails.setEmail(mentorship.getTrainer().getEmail());
        response.setTrainer(trainerDetails);

        return response;
    }
}
