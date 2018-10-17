package com.wossha.auth.commands.modifyuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.auth.WosshaAuthApplication;
import com.wossha.auth.commands.modifyuser.model.ModifyUser;
import com.wossha.auth.commands.modifyuser.model.UserDTO;
import com.wossha.auth.infrastructure.dao.user.UserRecord;
import com.wossha.auth.infrastructure.mapper.MapperDozer;
import com.wossha.auth.infrastructure.repositories.UserRepository;
import com.wossha.json.events.events.api.Event;
import com.wossha.json.events.events.pictures.SavePictureEvent.Message;
import com.wossha.json.events.events.pictures.SavePictureEvent.SavePictureEvent;
import com.wossha.json.events.services.UUIDGenerator;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.enums.PictureTypesEnum;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class ModifyUserCommand implements ICommand<ModifyUser>{
	
	private ModifyUser data;
	private String username;
	private MapperDozer map = new MapperDozer();
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public String commandName() {
		return "ModifyUser";
	}
	
	@Override
	public ModifyUser data() {
		return this.data;
	}

	@Override
	public void setData(ModifyUser data) {
		this.data = data;
		
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		
		CommandResult result = new CommandResult();
		UserRecord user = repo.findUserByUsername(username);
		
		if(user == null) {
			throw new BusinessException("El usuario a modificar no existe");
		}
		
		try {
			
			UserRecord newUser = map.mapClotheDTOToClothe(data.getUser());
			
			//profile picture
			if (data.getUser().getProfilePicture().getValue() != null) {
				Event pictureEvent = null;
				String uuidPicture = UUIDGenerator.generateUUID();
				newUser.setProfilePicture(uuidPicture);
				
				pictureEvent = generateSavePictureEvent(uuidPicture,
						data.getUser().getProfilePicture().getFilename(), data.getUser().getProfilePicture().getFiletype(),
						data.getUser().getProfilePicture().getSize(), data.getUser().getProfilePicture().getValue(), PictureTypesEnum.PROFILE_PICTURE.name());
				
				result.addEvent(pictureEvent);
			}else {
				newUser.setProfilePicture(user.getProfilePicture());
			}
			
			//cover picture
			if (data.getUser().getCoverPicture().getValue() != null) {
				Event pictureEvent = null;
				String uuidPicture = UUIDGenerator.generateUUID();
				newUser.setCoverPicture(uuidPicture);
				
				pictureEvent = generateSavePictureEvent(uuidPicture,
						data.getUser().getProfilePicture().getFilename(), data.getUser().getProfilePicture().getFiletype(),
						data.getUser().getProfilePicture().getSize(), data.getUser().getProfilePicture().getValue(), PictureTypesEnum.COVER_PICTURE.name());
				
				result.addEvent(pictureEvent);
			}else {
				newUser.setCoverPicture(user.getCoverPicture());
			}
			
			repo.update(newUser);
			result.setMessage("La modificación de datos se ha realizado correctamente");
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			throw new TechnicalException("Ha ocurrido un error al intentar modificar el usuario");
		}
	}
	
	private SavePictureEvent generateSavePictureEvent(String uuidPicture, String picName, String fileType,
			Integer fileSize, String value, String type) {
		Message message = new Message(uuidPicture, picName, fileType, type, fileSize,
				value);
		SavePictureEvent event = new SavePictureEvent(WosshaAuthApplication.APP_NAME, this.username, message);
		return event;
	}


	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}
