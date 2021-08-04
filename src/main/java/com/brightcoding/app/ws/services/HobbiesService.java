package com.brightcoding.app.ws.services;

import java.util.List;

import com.brightcoding.app.ws.shared.dto.HobbiesDto;

public interface HobbiesService {
	List<HobbiesDto> getAllHobbies();

    HobbiesDto createHobbies(HobbiesDto hobbiesDto);

    HobbiesDto getHobbies(Long HobbiesId);
    HobbiesDto updateHobbies(Long Id, HobbiesDto HobbiesDto);
    void deleteHobbies(long HobbiesId);

}
