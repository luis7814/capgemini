package co.com.capgemini.bank.core.commons.utilities;

import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.commons.entities.Status;

/*
 * Clase : Utilities.java
 * Comentario : Clase que contiene metodos transversales para la aplicación
 */

public class Utilities {
	
	public ResponseService responseService(int statusCode, String response) {
		
		Status status = new Status();
		ResponseService responseService = new ResponseService();
		
		status.setStatus_code(statusCode);
		status.setStatus_desc(statusCode == PrintMessage.STATUS_CODE_OK ? PrintMessage.STATUS_DESC_OK : PrintMessage.STATUS_DESC_ERROR);
		
		responseService.setStatus(status);
		responseService.setResponse(response);
		
		return responseService;
		
	}

}
