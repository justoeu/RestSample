package br.com.justoeu.resource;

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BaseResourceWS {

	public static final String PRODUCES_XML_STREAMING    = APPLICATION_OCTET_STREAM + ";charset=UTF-8";
	public static final String PRODUCES_JSON_STREAMING   = APPLICATION_OCTET_STREAM + ";charset=UTF-8";
	public static final String PRODUCES_STRING_STREAMING = TEXT_PLAIN 				+ ";charset=UTF-8";
	
}