package com.fitflow.api.mentorships.dto;

import com.fitflow.api.mentorships.model.Mentorship;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
public class CreateMentorshipRequestToMentorshipConverter implements Converter<CreateMentorshipRequest, Mentorship> {
    @Override
    public Mentorship convert(MappingContext<CreateMentorshipRequest, Mentorship> mappingContext) {
        CreateMentorshipRequest source = mappingContext.getSource();
        Mentorship mentorship = new Mentorship();
        mentorship.setFromDate(source.getFromDate());
        mentorship.setToDate(source.getFromDate());
        mentorship.setPrice(source.getPrice());
        return mentorship;
    }
}
