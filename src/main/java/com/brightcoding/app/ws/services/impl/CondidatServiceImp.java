package com.brightcoding.app.ws.services.impl;

import com.brightcoding.app.ws.entities.Application;
import com.brightcoding.app.ws.entities.AuthProvider;
import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.repositories.CondidatRepository;
import com.brightcoding.app.ws.services.CondidatService;
import com.brightcoding.app.ws.shared.Utils;
import com.brightcoding.app.ws.shared.dto.CondidatDto;



import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class CondidatServiceImp implements CondidatService {

    @Autowired
    CondidatRepository condidatRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    Utils util;

    @Override
    public String  getUserID(String email ) {
    	  
    	  
    	return condidatRepository.findByEmail(email).get().getUserId();

    	  
      }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CondidatEntity condidatEntity = condidatRepository.findByEmail(email).get();

        if(condidatEntity == null) throw new UsernameNotFoundException(email);

        return new User(condidatEntity.getEmail(), condidatEntity.getEncryptedPassword(), new ArrayList<>());
    }
    @Override
    public CondidatDto getCondidatByUserId(String userId) {

        CondidatEntity condidatEntity = condidatRepository.findByUserId(userId);

        if(condidatEntity == null) throw new UsernameNotFoundException(userId);


        ModelMapper modelMapper = new ModelMapper();

        CondidatDto condidatDto = modelMapper.map(condidatEntity, CondidatDto.class);

        return condidatDto;

    }
    @Override
    public List<CondidatDto> getCondidat(int page, int limit, String search, int status) {

        if(page > 0) page = page - 1;

        List<CondidatDto> condidatsDto = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<CondidatEntity> condidatPage;

        if(search.isEmpty()) {
            condidatPage = condidatRepository.findAllCondidats(pageableRequest);
        }
        else {

            condidatPage = condidatRepository.findAllCondidatByCriteria(pageableRequest, search, status);
        }


        List<CondidatEntity> condidats = condidatPage.getContent();

        for(CondidatEntity condidatEntity: condidats) {

            ModelMapper modelMapper = new ModelMapper();
            CondidatDto condidat = modelMapper.map(condidatEntity, CondidatDto.class);

            condidatsDto.add(condidat);
        }

        return condidatsDto;
    }
    @Override
    public CondidatDto updateCondidat(String id, CondidatEntity condidatDto) {

        CondidatEntity condidatEntity = condidatRepository.findByUserId(id);


        if(condidatEntity == null) throw new UsernameNotFoundException(id);
        condidatEntity.setFirstName(condidatDto.getFirstName());
        condidatEntity.setPhone(condidatDto.getPhone());
        condidatEntity.setLastName(condidatDto.getLastName());
        condidatEntity.setEmail(condidatDto.getEmail());
        condidatEntity.setDate_birthday(condidatDto.getDate_birthday());
        condidatEntity.setGender(condidatDto.getGender());
        condidatEntity.setNationality(condidatDto.getNationality());
        condidatEntity.setPhoto(condidatDto.getPhoto());
        CondidatEntity cond = condidatRepository.save(condidatEntity);

        CondidatDto con = new CondidatDto();

        BeanUtils.copyProperties(cond, con);

        return con;
    }
    @Override
    public CondidatDto createCondidat( CondidatDto condidat) {
       



    condidat.setApplication(Application.NewApplication);
    condidat.setAuthProvider(AuthProvider.local);
        	 
            ModelMapper modelMapper = new ModelMapper();

            CondidatEntity condidatEntity = modelMapper.map(condidat, CondidatEntity.class);
            condidatRepository.save(condidatEntity);


            condidatEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(condidat.getEncryptedPassword()));

            condidatEntity.setUserId(util.generateStringId(32));

             condidatRepository.save(condidatEntity);

          
        	
        
        
        	
       

        return condidat;
    }
    @Override
    public void delete(String userId) {

        CondidatEntity userEntity = condidatRepository.findByUserId(userId);

        if(userEntity == null) throw new UsernameNotFoundException(userId);

        condidatRepository.delete(userEntity);

    }
	@Override
	public List<CondidatDto> getAll() {
		 ModelMapper modelMapper = new ModelMapper();
		List<CondidatDto> list= new ArrayList<>();
		for(CondidatEntity condidat:condidatRepository.findAll()) {
			CondidatDto condidatDto = modelMapper.map(condidat, CondidatDto.class);
			list.add(condidatDto);
			
		}

		return list ;
	}
	 @Override
	    public CondidatEntity connect(CondidatEntity user)  {
		 CondidatEntity dbUser = condidatRepository.findByEmail(user.getEmail()).get();

	        if (dbUser != null) {

	            if (dbUser.getConnected()) {
	                throw new RuntimeException("This user is already connected: " + dbUser.getFirstName());
	            }

	            dbUser.setConnected(true);
	            return condidatRepository.save(dbUser);
	        }

	        user.setConnected(true);
	        return condidatRepository.save(user);
	    }

	    @Override
	    public CondidatEntity disconnect(CondidatEntity user) {
	        if (user == null) {
	            return null;
	        }

	        CondidatEntity dbUser = condidatRepository.findByEmail(user.getEmail()).get();
	        if (dbUser == null) {
	            return user;
	        }

	        dbUser.setConnected(false);
	        return condidatRepository.save(dbUser);
	    }

}
