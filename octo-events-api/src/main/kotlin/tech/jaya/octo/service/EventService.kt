package tech.jaya.octo.service

import tech.jaya.octo.dto.EventDTO

interface EventService {
	
    /**
     * Create a [eventDTO] new Event(Webhook)
     */
	fun create(eventDTO: EventDTO)
	
	 /**
     * Valid a [eventDTO] before Create
	  
	 * @return [Boolean] - True, if event is valid
     */
	fun validate(eventDTO: EventDTO): Boolean
}