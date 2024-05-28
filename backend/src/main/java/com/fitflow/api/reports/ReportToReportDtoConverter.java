package com.fitflow.api.reports;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class ReportToReportDtoConverter implements Converter<Report, ReportDto> {
    @Override
    public ReportDto convert(MappingContext<Report, ReportDto> mappingContext) {
        Report source = mappingContext.getSource();
        ReportDto destination = mappingContext.getDestination();
        if (destination == null) {
            destination = new ReportDto();
        }
        destination.setTitle(source.getTitle());
        destination.setContent(source.getContent());
        destination.setDate(source.getDate());
        destination.setPhotos(source.getPhotos().stream().map(Photo::getPath).collect(toList()));
        return destination;
    }
}
