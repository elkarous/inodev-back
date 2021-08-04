package com.brightcoding.app.ws.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brightcoding.app.ws.shared.dto.OriginDto;
@Service
public interface OrigineService {
	   List<OriginDto> getAllSource(String email);

	    OriginDto createSource(OriginDto source, String email);

	    OriginDto getSource(String sourceId);
	    OriginDto updateSource(String Id, OriginDto originDto);
	    void deleteSource(String sourceId);
	}

