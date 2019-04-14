package tech.jaya.octo.test.integration

import io.javalin.Javalin
import junit.framework.TestCase
import org.json.JSONObject
import org.koin.core.context.stopKoin
import tech.jaya.octo.HttpStatus
import tech.jaya.octo.test.OctoEventsApplicationTest

class IntegrationTest : TestCase() {

	private lateinit var app: Javalin
	private val api = "http://localhost:9091/test/api/v1/"
	
	override fun setUp() {
		app = OctoEventsApplicationTest().init().start()
	}

	override fun tearDown() {
		app.stop()
		stopKoin()
	}
	
	fun testIssueNotFoundResource() {
		val response = khttp.get(url = api + "issues/1/noevents")
		assertEquals(HttpStatus.NOT_FOUND.status, response.statusCode)
	}

	fun testIssueFoundResult() {
		val response = khttp.get(url = api + "issues/1/events")
		assertEquals(HttpStatus.OK.status, response.statusCode)
	}

	fun testOkGetIssueByNumber() {
		val first: Int = 0;
		val response = khttp.get(url = api + "issues/150/events")
		val issue : JSONObject = response.jsonArray.getJSONObject(first)
		assertEquals(issue.get("number"), 150)
	}

}