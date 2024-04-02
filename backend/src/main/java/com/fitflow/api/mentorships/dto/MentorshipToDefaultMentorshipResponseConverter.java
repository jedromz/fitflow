package com.fitflow.api.mentorships.dto;

import com.fitflow.api.mentorships.model.Mentorship;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
public class MentorshipToDefaultMentorshipResponseConverter implements Converter<Mentorship, DefaultMentorshipResponse> {

    @Override
    public DefaultMentorshipResponse convert(MappingContext<Mentorship, DefaultMentorshipResponse> mappingContext) {
        Mentorship mentorship = mappingContext.getSource();
        return new DefaultMentorshipResponse(mentorship.getFromDate(), mentorship.getToDate(), mentorship.getPrice(), mentorship.getTrainee().getName());
    }
}
