package tech.jaya.octo.test

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject
import org.koin.dsl.module
import tech.jaya.octo.controller.EventController
import tech.jaya.octo.controller.IssueController
import tech.jaya.octo.persistence.entity.Event
import tech.jaya.octo.persistence.entity.Issue
import tech.jaya.octo.persistence.model.Events
import tech.jaya.octo.persistence.model.Issues
import tech.jaya.octo.service.impl.EventService
import tech.jaya.octo.service.impl.IssueService

class OctoEventsApplicationTest : KoinComponent {

	private val SERVER_PORT: Int = 9091

	fun init(): Javalin {

		/* Configure Octos database for testing
 		*
 		* In memory / Keep alive between connections/transactions
 		*/
		Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;", "org.h2.Driver")

		transaction {

			addLogger(StdOutSqlLogger)

			SchemaUtils.create(Issues, Events)

			/*Create Event*/
			val eventEntity = transaction {
				Event.new {
					action = "tested"
				}
			}

			/*Create Issue*/
			Issue.new {
				number = 150
				title = "Test"
				body = "Test Integration"
				createdAt = DateTime.now()
				event = eventEntity
			}
			
		}

		/*Configure Javalin Server*/
		val app = Javalin.create().apply {
			contextPath("/test/api/v1")
			maxBodySizeForRequestCache(10000)
			port(SERVER_PORT)
		}

		/*Koin modules*/
		val modules = module {
			factory { IssueController() }
			factory { EventController() }
			factory { EventService() }
			factory { IssueService() }
		}

		startKoin {
			modules(modules)
		}

		val eventController: EventController by inject()
		val issueController: IssueController by inject()

		app.routes {

			path("/events") {
				post() { context ->
					eventController.create(context)
				}
			}
			path("/issues/:number-issue/events") {
				get() { context ->
					issueController.getIssueEvents(context);
				}
			}
		}

		return app
	}
}