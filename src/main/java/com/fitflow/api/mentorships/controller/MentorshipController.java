package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.dto.CreateMentorshipRequest;
import com.fitflow.api.mentorships.repository.MentorshipRepository;
import com.fitflow.api.mentorships.service.MentorshipService;
import com.fitflow.api.mentorships.model.Mentorship;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentorships")
public class MentorshipController {

    private final MentorshipRepository mentorshipRepository;
    private final MentorshipService mentorshipService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<MentorshipResponse> getMentorship() {
        return mentorshipRepository.findAllBy();
    }

    @PostMapping
    public MentorshipResponse addMentorship(@RequestBody CreateMentorshipRequest mentorship) {
        return modelMapper.map(mentorshipService.createMentorship(mentorship), DefaultMentorshipResponse.class);
    }
}
