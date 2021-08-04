package com.brightcoding.app.ws.services;

import com.brightcoding.app.ws.shared.dto.EventDto;
import com.brightcoding.app.ws.shared.dto.OriginDto;

import java.util.List;

public interface OriginService {
    List<OriginDto> getAllSource(String email);

    EventDto createSource(EventDto source, String email);

    OriginDto getSource(String sourceId);
    EventDto updateSource(String Id, EventDto eventDto);
    void deleteSource(String sourceId);

	OriginDto createSource(OriginDto education, String email);

	OriginDto updateSource(String id, OriginDto educationDto);
}
