package tech.jaya.octo.persistence.model

import org.jetbrains.exposed.dao.IntIdTable

object Issues: IntIdTable("tb_issue") {
	
	val number = integer("number")
	val title = varchar("title", 500)
	val body = varchar("body", 2500)
	val createdAt = datetime("created_at")
	val event = reference("event", Events)
	
}