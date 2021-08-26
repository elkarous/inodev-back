package com.brightcoding.app.ws.controllers;

import com.brightcoding.app.ws.entities.OriginEntity;
import com.brightcoding.app.ws.requests.OriginRequest;
import com.brightcoding.app.ws.responses.OriginResponse;
import com.brightcoding.app.ws.services.OriginService;
import com.brightcoding.app.ws.shared.dto.EventDto;
import com.brightcoding.app.ws.shared.dto.OriginDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    OriginService educationService;
  //http://localhost:8081/source
    @GetMapping
    public ResponseEntity<List<OriginResponse>> getSource(Principal principal) {

        List<OriginEntity> education = educationService.getAllSource(principal.getName());

        Type listType = new TypeToken<List<OriginResponse>>() {}.getType();
        List<OriginResponse> OriginResponse = new ModelMapper().map(education, listType);

        return new ResponseEntity<List<OriginResponse>>(OriginResponse, HttpStatus.OK);

    }
  //http://localhost:8081/source
    @PostMapping(
            consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<OriginResponse> StoreSource(@RequestBody OriginRequest OriginRequest, Principal principale) {

        ModelMapper modelMapper = new ModelMapper();

        EventDto EventDto = modelMapper.map(OriginRequest, EventDto.class);
        EventDto createEducation = educationService.createSource(EventDto, principale.getName());

        OriginResponse newEducation = modelMapper.map(createEducation, OriginResponse.class);

        return new ResponseEntity<OriginResponse>(newEducation, HttpStatus.CREATED);
    }
  //http://localhost:8081/source/{id}
    @GetMapping("/{id}")
    public  ResponseEntity<OriginResponse> getOneSource(@PathVariable(name="id") String educationId) {

        OriginDto EventDto = educationService.getSource(educationId);

        ModelMapper modelMapper = new ModelMapper();

        OriginResponse OriginResponse = modelMapper.map(EventDto, OriginResponse.class);

        return new ResponseEntity<OriginResponse>(OriginResponse, HttpStatus.OK);
    }

  //http://localhost:8081/source/{id}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSource(@PathVariable(name="id") String educationId) {

        educationService.deleteSource(educationId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  //http://localhost:8081/source/{id}
    @PutMapping(
            path="/{id}",
            consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<OriginResponse> updateSource(@PathVariable String id , @RequestBody OriginRequest OriginRequest) {

        EventDto EventDto = new EventDto();

        BeanUtils.copyProperties(OriginRequest, EventDto);

        EventDto updateEducation = educationService.updateSource(id, EventDto);

        OriginResponse OriginResponse = new OriginResponse();

        BeanUtils.copyProperties(updateEducation, OriginResponse);

        return new ResponseEntity<OriginResponse>(OriginResponse, HttpStatus.ACCEPTED);
    }
}
