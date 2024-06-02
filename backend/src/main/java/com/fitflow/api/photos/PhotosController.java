package com.fitflow.api.photos;

import com.fitflow.api.minio.MinioStorageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PhotosController {
    //find all photos by trainee id
    private final PhotosRepository photosRepository;
    private final MinioStorageService minioStorageService;

    @GetMapping("/trainees/{traineeId}/photos")
    public List<String> getPhotosByTraineeId(@PathVariable long traineeId) {
        List<PhotoUrl> paths = photosRepository.findAllByTraineeId(traineeId);
        List<String> urls = new ArrayList<>();
        for (PhotoUrl path : paths) {
            urls.add(minioStorageService.getObjectByPath(path.getPath()));
        }
        return urls;
    }
}
