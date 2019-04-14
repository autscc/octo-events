package tech.jaya.octo.service

import tech.jaya.octo.dto.IssueDetailsDTO

interface IssueService {
	
	/**
     * Get all Issues events
	 *
	 * @return [List<IssueDetailsDTO>] - List of events from issue
     */
	fun getIssueEvents(numberIssue: Int): List<IssueDetailsDTO>
	
}