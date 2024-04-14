package com.fitflow.api.mentorships.controller;

import com.fitflow.api.mentorships.dto.CreateMentorshipRequest;
import com.fitflow.api.mentorships.dto.DefaultMentorshipResponse;
import com.fitflow.api.mentorships.dto.MentorshipResponse;
import com.fitflow.api.mentorships.repository.MentorshipRepository;
import com.fitflow.api.mentorships.service.MentorshipService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentorships")
public class MentorshipController {

    private final MentorshipRepository mentorshipRepository;
    private final MentorshipService mentorshipService;
    private final ModelMapper modelMapper;

    public MentorshipController(MentorshipRepository mentorshipRepository, MentorshipService mentorshipService, ModelMapper modelMapper) {
        this.mentorshipRepository = mentorshipRepository;
        this.mentorshipService = mentorshipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MentorshipResponse> getMentorship() {
        return mentorshipRepository.findAll()
                .stream()
                .map(mentorship -> modelMapper.map(mentorship, MentorshipResponse.class))
                .toList();
    }

    @PostMapping
    public MentorshipResponse addMentorship(@RequestBody CreateMentorshipRequest mentorship) {
        return modelMapper.map(mentorshipService.createMentorship(mentorship), DefaultMentorshipResponse.class);
    }
}
