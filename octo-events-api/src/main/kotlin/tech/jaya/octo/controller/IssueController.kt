package tech.jaya.octo.controller

import io.javalin.Context
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.jaya.octo.service.impl.IssueService
import tech.jaya.octo.HttpStatus

class IssueController: KoinComponent {
	
	private val issueService: IssueService by inject()
	
	fun getIssueEvents(context: Context) {
		val issueNumber: Int = context.pathParam("number-issue").toInt()
		context.status(HttpStatus.OK.status)
		context.json(issueService.getIssueEvents(issueNumber))
	}
}