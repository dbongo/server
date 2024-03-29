package com.evant.server

import akka.actor.{Props, ActorSystem, Actor}
import spray.routing.HttpService
import spray.http.MediaTypes._
import akka.io.IO
import spray.can.Http
import org.json4s.Formats

class AdminHttpServerActor extends Actor with AdminHttpServerRoutes {

  private lazy val adminPort = context.system.settings.config.getInt("evant.server.admin.port")
  private lazy val adminInterface = context.system.settings.config.getString("evant.server.admin.interface")

  def httpListener = actorRefFactory.actorSelection("/user/IO-HTTP/listener-0")

  IO(Http)(context.system) ! Http.Bind(self, interface = adminInterface, port = adminPort)

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(adminRoutes)
}

object AdminHttpServerActor {
  def props = Props(new AdminHttpServerActor)
}
