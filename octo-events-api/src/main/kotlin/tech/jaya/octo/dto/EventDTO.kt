package tech.jaya.octo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class EventDTO(
	
	@JsonProperty(value = "action", required = true)
	val action: String,
	@JsonProperty(value = "issue", required = true)
	val issue: IssueDTO

) {
	
}