package com.brightcoding.app.ws.services.impl;
import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.entities.OriginEntity;
import com.brightcoding.app.ws.entities.Role;
import com.brightcoding.app.ws.repositories.CondidatRepository;
import com.brightcoding.app.ws.repositories.OriginRepository;
import com.brightcoding.app.ws.services.OriginService;
import com.brightcoding.app.ws.shared.Utils;
import com.brightcoding.app.ws.shared.dto.CondidatDto;
import com.brightcoding.app.ws.shared.dto.EventDto;
import com.brightcoding.app.ws.shared.dto.OriginDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
	public class OriginServiceImp implements OriginService {
	    @Autowired
	    OriginRepository originRepository;

	    @Autowired
	    CondidatRepository condidatRepository;

	    @Autowired
	    Utils util;

	    @Override
	    public List<OriginEntity> getAllSource(String email) {

	        CondidatEntity currentCondidat = condidatRepository.findByEmail(email).get();

	        
	        

	        return currentCondidat.getOrigins();
	    }


	    @Override
	    public OriginDto createSource(OriginDto education, String email) {

	        CondidatEntity currentCondidat = condidatRepository.findByEmail(email).get();

	        ModelMapper modelMapper = new ModelMapper();
	  
	        education.setSourceId(util.generateStringId(30));
	     

	        OriginEntity educationEntity = modelMapper.map(education, OriginEntity.class);
	        currentCondidat.getOrigins().add(educationEntity);
	        condidatRepository.save(currentCondidat);

	     

	        return education;
	    }


	    @Override
	    public OriginDto getSource(String educationId) {

	        OriginEntity educationEntity = originRepository.findBySourceId(educationId);

	        ModelMapper modelMapper = new ModelMapper();

	        OriginDto educationDto = modelMapper.map(educationEntity, OriginDto.class);

	        return educationDto;
	    }

	    @Override
	    public void deleteSource(String educationId) {

	        OriginEntity education = originRepository.findBySourceId(educationId);

	        if(education == null) throw new RuntimeException("education not found");

	        originRepository.delete(education);

	    }
	    @Override
	    public OriginDto updateSource(String id, OriginDto educationDto) {

	        OriginEntity educationEntity = originRepository.findBySourceId(id);


	        if(educationDto == null) throw new UsernameNotFoundException(id);
	        educationEntity.setDescrib(educationDto.getDescrib());
	        educationEntity.setPosition(educationDto.getPosition());

	        OriginEntity educ = originRepository.save(educationEntity);

	        OriginDto educt = new OriginDto();

	        BeanUtils.copyProperties(educ, educt);

	        return educt;
	    }


		@Override
		public EventDto createSource(EventDto source, String email) {
			// TODO Auto-generated method stub
			return null;
		}


		


		@Override
		public EventDto updateSource(String Id, EventDto eventDto) {
			// TODO Auto-generated method stub
			return null;
		}
}
