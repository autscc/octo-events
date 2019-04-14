package tech.jaya.octo.persistence.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import tech.jaya.octo.persistence.model.Events

class Event(id: EntityID<Int>) : IntEntity(id) {
	
	companion object : IntEntityClass<Event>(Events)
	
	var action by Events.action
	
}