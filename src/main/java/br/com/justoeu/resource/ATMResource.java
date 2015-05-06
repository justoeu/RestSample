package br.com.justoeu.resource;

//import java.util.concurrent.ExecutorService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.justoeu.domain.ATM;
import br.com.justoeu.domain.response.APIResponse;
import br.com.justoeu.infrastructure.exception.APIException;
import br.com.justoeu.infrastructure.security.SecurityService;
import br.com.justoeu.service.ATMService;
import br.com.justoeu.util.date.CalendarParams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.jaxrs.PATCH;

//import com.airhacks.porcupine.execution.boundary.Dedicated;

@Path("/atm")
@RequestScoped
@Api(value = "ATM Services", description = "Service Integration to ATM")
public class ATMResource extends BaseResourceWS {

	@Inject
	privat ATM atm;
	
	@Inject
	private ATMService atmService;
	
//	@Inject
//    @Dedicated("custom-pool")
//    private ExecutorService first;

	@POST
	@Path("deposit/{value}")
	@ApiOperation(
			value = "Money of deposit in client account",
			notes = "Money of deposit in client account",
			response = APIResponse.class,
			position = 1
	 )
	@ApiResponses(value = { @ApiResponse (code = 400, message = "Value is not Zero!") })
	@SecurityService
	public Response deposit(
			@ApiParam(
					defaultValue = "10.5",
					value = "Money to Deposit",
					required = true)
			@PathParam("value") 
			Double value) throws APIException {
		
		try{
			
			if (value == 0) {
				throw new APIException("Value is not Zero!");
			}
			
			atm.deposit(value);
			return Response.ok().entity(
										new APIResponse(APIResponse.OK, 
										"Transaction OK. Value " + value + " deposited.")
									   ).build();
					
		} catch (Exception e){
			return response(Status.BAD_REQUEST,APIResponse.ERROR,e);
			//throw new APIException(Status.BAD_REQUEST.getStatusCode(), e.getMessage());
		}
		
	}
	
	@POST
	@Path("account/balance/{idAccount}")
	@ApiOperation(
			value = "Value total of Client Account",
			notes = "Value total of Client Account",
			response = APIResponse.class,
			position = 2
	 )
	@ApiResponses(value = { @ApiResponse (code = 400, message = "ID reference to Account do not 0 or null") })
	@SecurityService
	public Response balance(
			@ApiParam(
					defaultValue = "1",
					value = "ID reference Client Account",
					required = true)
			@PathParam("idAccount") 
			int idAccount) throws APIException {
		
		try{
			
			if (idAccount == 0) {
				throw new APIException("Client's Account ID is not Zero or Null!");
			} else if (idAccount == 1){

				Gson gson = new GsonBuilder().create();
				
				return Response.ok().entity(new APIResponse(APIResponse.OK,gson.toJson(atmService.balanceOfAccount(idAccount)))).build();
			} else{
				throw new APIException("Client's Account ID is not Avaliable!");
			}
		} catch (Exception e){
			e.printStackTrace();
			return response(Status.BAD_REQUEST,APIResponse.ERROR,e);
		}
	}
	
	
	@GET
	@Path("account/services/{idAccount}")
	@ApiOperation(
			value = "Method with return all Services avaliable to Account",
			notes = "Method with return all Services avaliable to Account",
			position = 3
	 )
	@ApiResponses(value = { @ApiResponse (code = 400, message = "ID reference to Account do not 0 or null") })
	@SecurityService
	public Response accountService(
			@ApiParam(
					defaultValue = "1",
					value = "ID reference Client Account",
					required = true)
			@PathParam("idAccount") 
			int idAccount) throws APIException {
		
		try{
			
			if (idAccount == 0) {
				throw new APIException("Client's Account ID is not Zero or Null!");
			}
			
			Gson gson = new GsonBuilder().setDateFormat(CalendarParams.FORMATDATEPT).create();
			
			return Response.ok().entity(new APIResponse(APIResponse.OK,gson.toJson(atmService.allServices(idAccount)))).build();
					
		} catch (Exception e){
			e.printStackTrace();
			return response(Status.BAD_REQUEST,APIResponse.ERROR,e);
		}
		
	}

	@PATCH
	//@GET
	@Path("account/info/{idAccount}")
	@ApiOperation(
			value = "Method with return information about Client Account",
			notes = "Method with return information about Client Account",
			position = 4
	 )
	@ApiResponses(value = { @ApiResponse (code = 400, message = "ID reference to Account do not 0 or null") })
	@SecurityService
	public Response accountInformation(
			@ApiParam(
					defaultValue = "1",
					value = "ID reference Client Account",
					required = true)
			@PathParam("idAccount") 
			int idAccount) throws APIException {
		
		try{
			
			if (idAccount == 0) {
				throw new APIException("Client's Account ID is not Zero or Null!");
			}
			else if (idAccount == 1){
			
				Gson gson = new GsonBuilder().setDateFormat(CalendarParams.FORMATDATEPT).create();
				
				return Response.ok().entity(new APIResponse(APIResponse.OK,gson.toJson(atmService.accountInformation(idAccount)))).build();
			} else{
				throw new APIException("Client's Account Information is not Avaliable!");
			}
		} catch (Exception e){
			e.printStackTrace();
			return response(Status.BAD_REQUEST,APIResponse.ERROR,e);
		}
		
	}
	
	private Response response(Status status, int codeResponse, Exception e) {
		return Response.status(status.getStatusCode()).entity(new APIResponse(codeResponse, e.getMessage())).build();
	}

	
}
