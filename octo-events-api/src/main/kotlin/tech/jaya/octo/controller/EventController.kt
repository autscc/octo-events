package tech.jaya.octo.controller

import io.javalin.Context
import org.koin.core.KoinComponent
import org.koin.core.inject
import tech.jaya.octo.HttpStatus
import tech.jaya.octo.dto.EventDTO
import tech.jaya.octo.service.impl.EventService

class EventController: KoinComponent {

	private val eventService: EventService by inject()
	
	fun create(context: Context) {
	    val eventDTO = context.validatedBody<EventDTO>()
	    					  .check({eventService.validate(it)})
	    					  .getOrThrow() /*Parse request context body to DTO*/
		eventService.create(eventDTO)
		context.status(HttpStatus.CREATED.status)
		context.json("Event created with success")
	}
	
}