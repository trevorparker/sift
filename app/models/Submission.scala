package models

case class Submission(id: Long, title: String, url: String)

object Submission {

  def all(): List[Submission] = Nil
  def create(submission: Submission) {}
  def find(id: Long) {}
  def update(id: Long) {}
  def destroy(id: Long) {}

}

