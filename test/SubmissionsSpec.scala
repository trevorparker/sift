import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class SubmissionsSpec extends Specification {

  "Submissions" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/submissions/noop")) must beNone
    }

    "render the index page" in new WithApplication{
      val submissions = route(FakeRequest(GET, "/submissions")).get

      status(submissions) must equalTo(OK)
      contentType(submissions) must beSome.which(_ == "text/html")
      contentAsString(submissions) must contain ("Current submissions")
    }
  }
}
