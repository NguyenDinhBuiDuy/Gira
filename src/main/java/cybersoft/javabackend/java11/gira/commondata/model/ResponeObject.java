package cybersoft.javabackend.java11.gira.commondata.model;


import java.time.LocalDateTime;
import java.util.List;

import cybersoft.javabackend.java11.gira.util.DateUtils;
import cybersoft.javabackend.java11.gira.util.ListUtils;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ResponeObject {
	private Object content;
	private List<String> errorMessages;
	private String responseTime = DateUtils.toString(LocalDateTime.now());
	
	public ResponeObject (Object content) {
		this.content = content;
		this.errorMessages = ListUtils.emtyString;
	}
	
	public ResponeObject (List<String> errorMessages) {
		this.errorMessages = errorMessages;
		this.content = ListUtils.emtyString;
	}
	
	public ResponeObject content(Object content) {
		this.content = content;
		return this;
	}
	
	public ResponeObject errorMessages (List<String> messages) {
		this.errorMessages = messages;
		return this;
	}
	
}
