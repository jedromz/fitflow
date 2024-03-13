package com.fitflow.api.mentorships.dto;

import com.fitflow.api.mentorships.controller.MentorshipController;
import com.fitflow.api.mentorships.model.Mentorship;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MentorshipToDefaultMentorshipConverter implements Converter<Mentorship, DefaultMentorshipResponse> {
    @Override
    public DefaultMentorshipResponse convert(MappingContext<Mentorship, DefaultMentorshipResponse> mappingContext) {
        Mentorship source = mappingContext.getSource();
        DefaultMentorshipResponse mentorship = new DefaultMentorshipResponse();
        mentorship.setFromDate(source.getFromDate());
        mentorship.setToDate(source.getToDate());
        mentorship.setPrice(source.getPrice());

        mentorship.add(linkTo(methodOn(MentorshipController.class).getMentorship()).withSelfRel());
        //trainee
        mentorship.add(linkTo(methodOn(MentorshipController.class).getMentorship()).withRel("mentorship"));
        return mentorship;
    }
}
