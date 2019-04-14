package tech.jaya.octo.persistence.model

import org.jetbrains.exposed.dao.IntIdTable

object Events: IntIdTable("tb_event") {
	
	val action = varchar("action", 25)

}