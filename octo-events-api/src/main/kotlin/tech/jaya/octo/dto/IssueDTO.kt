package tech.jaya.octo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date
import com.fasterxml.jackson.annotation.JsonFormat


@JsonIgnoreProperties(ignoreUnknown = true)
class IssueDTO(
	
	@JsonProperty(value = "number", required = true)
	val number: Int,
	@JsonProperty(value = "title", required = true)
	val title: String,
	@JsonProperty(value = "body", required = true)
	val body: String,	
	@JsonProperty(value = "created_at")
	val createdAt: Date

) {
	
}