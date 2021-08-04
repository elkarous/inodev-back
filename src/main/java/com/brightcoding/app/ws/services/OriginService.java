package com.brightcoding.app.ws.services;

import com.brightcoding.app.ws.shared.dto.EventDto;

import java.util.List;

public interface OriginService {
    List<EventDto> getAllSource(String email);

    EventDto createSource(EventDto source, String email);

    EventDto getSource(String sourceId);
    EventDto updateSource(String Id, EventDto eventDto);
    void deleteSource(String sourceId);
}
