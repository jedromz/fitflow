package com.fitflow.api.minio;

import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import io.minio.messages.Item;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MinioStorageService {

    private final MinioClient minioClient;

    public MinioStorageService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @PostConstruct
    public void initializeBucket() {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("photos").build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("photos").build());
            }
        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("Error occurred: " + e.getMessage());
            throw new RuntimeException("Error initializing bucket: " + e.getMessage());
        }
    }

    public String store(MultipartFile file) {
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket("photos")
                            .object(filename)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
        } catch (MinioException | IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
            throw new RuntimeException("Error storing file: " + e.getMessage());
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        return filename;
    }

    public List<String> listObjectUrls() {
        List<String> urls = new ArrayList<>();
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket("photos").build());

            for (Result<Item> result : results) {
                Item item = result.get();
                String url = minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.GET)
                                .bucket("photos")
                                .object(item.objectName())
                                .build()
                );
                urls.add(url);
            }
        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("Error occurred: " + e.getMessage());
            throw new RuntimeException("Error generating presigned URLs: " + e.getMessage());
        }
        return urls;
    }

    public String getObjectByPath(String path) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket("photos")
                            .object(path)
                            .build()
            );
        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("Error occurred: " + e.getMessage());
            throw new RuntimeException("Error generating presigned URLs: " + e.getMessage());
        }
    }
}
