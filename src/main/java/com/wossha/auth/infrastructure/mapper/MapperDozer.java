package com.wossha.auth.infrastructure.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import com.wossha.auth.commands.modifyuser.model.UserDTO;
import com.wossha.auth.infrastructure.dao.user.UserRecord;
import java.util.ArrayList;

public class MapperDozer {

    protected static Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    static {
        ArrayList<String> mappingfileUrls = new ArrayList<>();
        mappingfileUrls.add("dozer/dozerAuthMapping.xml");
        ((DozerBeanMapper) mapper).setMappingFiles(mappingfileUrls);
    }

    public <T> T map(Object source, Class<T> destinationClass){
        return mapper.map(source, destinationClass);
    }

    public UserRecord mapClotheDTOToClothe(UserDTO user){
        return mapper.map(  user,  UserRecord.class);
    }

}
