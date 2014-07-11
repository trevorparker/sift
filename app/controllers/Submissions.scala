package controllers

import play.api.libs.json._
import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import models.Submission

object Submissions extends Controller {

  implicit val submissionFormat = Json.format[Submission]

  val submissionForm = Form(mapping(
    "id" -> ignored(-1L),
    "title" -> nonEmptyText,
    "url" -> nonEmptyText
  )(Submission.apply)(Submission.unapply))

  def index = Action { implicit request =>
    val submissions = Submission.all
    render {
      case Accepts.Html() => Ok(views.html.submissions.index(submissions))
      case Accepts.Json() => Ok(Json.toJson(submissions))
    }
  }
  def create = Action { implicit request =>
    submissionForm.bindFromRequest.fold(
      formWithErrors => BadRequest,
      submission => {
        Submission.create(submission.title, submission.url)
        Ok(Json.toJson(submission))
      }
    )
  }
  def show(id: Long) = TODO
  def update(id: Long) = TODO
  def destroy(id: Long) = TODO

}

