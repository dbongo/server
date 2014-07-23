package com.evant.server

import akka.actor.ActorSystem

class EvantServer(val system: ActorSystem = EvantServer.defaultSystem) extends App {

  system.actorOf(AdminHttpServerActor.props, "AdminHttpServer")

  sys addShutdownHook {
    system.shutdown()
  }
}

object EvantServer {
  lazy val defaultSystem = ActorSystem("EvantServer")
}