package tech.jaya.octo.service.impl

import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import tech.jaya.octo.dto.IssueDetailsDTO
import tech.jaya.octo.persistence.entity.Issue
import tech.jaya.octo.persistence.model.Issues
import tech.jaya.octo.service.IssueService

class IssueService: IssueService {
	
	private val DATE_FORMAT: String = "dd/MM/yyyy"
	
	override fun getIssueEvents(numberIssue: Int): List<IssueDetailsDTO> {
		
		val dtf: DateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT)
		
		var details: MutableList<IssueDetailsDTO> = mutableListOf()
		
		transaction {
			
			val issues = Issue.find { Issues.number eq numberIssue }
			for(issue: Issue in issues){
				var detail: IssueDetailsDTO = IssueDetailsDTO(issue.event.action,
															  issue.number,
															  issue.title,
															  issue.body,
															  dtf.print(issue.createdAt))
				details.add(detail)
			}
		}
		
		return details
					
	}
}