package models

import play.api._
import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Submission(id: Long, title: String, url: String)

object Submission {

  val simple = {
    get[Long]("submissions.id") ~
    get[String]("submissions.title") ~
    get[String]("submissions.url") map {
      case id~title~url => Submission(id, title, url)
    }
  }

  def all(): List[Submission] = DB.withConnection { implicit connection =>
    SQL("select * from submissions").as(Submission.simple *)
  }
  def create(title: String, url: String) = DB.withConnection { implicit connection =>
    SQL(
      """
        insert into submissions (title, url)
        values ({title}, {url})
      """
    ).on(
      'title -> title,
      'url -> url
    ).executeUpdate()
  }
  def find(id: Long) {}
  def update(id: Long) {}
  def destroy(id: Long) {}

}

