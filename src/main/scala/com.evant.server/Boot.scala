package com.evant.server

import akka.actor.ActorSystem

object Boot extends EvantServer(ActorSystem("Evant-Actor-System")) with Instrumented {

  // add gauge with scala metrics
  metrics.gauge("myGauge")("1")

  // add gauge with without instrumented prefix
  def gauge = 777

  Stats.metricRegistry.register("myGaugedd2", Stats.createGauge[Int](gauge))
}