package tech.jaya.octo.dto

import org.joda.time.DateTime
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonFormat

data class IssueDetailsDTO(
	
	val action: String,
	val number: Int,
	val title: String,
	val body: String,
	@JsonProperty("created_at")
	val createdAt: String

) {
	
}