package tech.jaya.octo.service.impl

import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import tech.jaya.octo.dto.EventDTO
import tech.jaya.octo.persistence.entity.Event
import tech.jaya.octo.persistence.entity.Issue
import tech.jaya.octo.service.EventService

class EventService : EventService {

	override fun create(eventDTO: EventDTO) {
	
		/*Create Event*/
		val eventEntity = transaction {
			Event.new {
				action = eventDTO.action
			}
		}
		
		/*Create Issue*/
		val issueDTO = eventDTO.issue
		transaction {
			Issue.new {
				number = issueDTO.number
				title = issueDTO.title
				body = issueDTO.body
				createdAt = DateTime(issueDTO.createdAt)
				event = eventEntity
			}
		}
					
	}
	
	override fun validate(eventDTO: EventDTO): Boolean {
		
		val minInt: Int = 0;
		val maxTitle: Int = 500
		
		val valid = if(eventDTO.action.isBlank()){
			false
		}else if(eventDTO.issue.number < minInt){
			false
		}else if(eventDTO.issue.title.isBlank() || eventDTO.issue.title.length > maxTitle){
			false
		} else{
			true
		}
			
		return valid
	}
	
}