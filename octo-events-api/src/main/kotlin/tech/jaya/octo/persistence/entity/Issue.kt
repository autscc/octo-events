package tech.jaya.octo.persistence.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import tech.jaya.octo.persistence.model.Issues

class Issue(id: EntityID<Int>): IntEntity(id) {
	
	companion object : IntEntityClass<Issue>(Issues)
	
	var number by Issues.number
	var title by Issues.title
	var body by Issues.body
	var createdAt by Issues.createdAt
	var event by Event referencedOn Issues.event
	
}