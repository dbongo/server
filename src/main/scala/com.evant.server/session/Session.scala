package com.evant.server.session

import spray.http.DateTime

private case class Session(map: Map[String, Any], expires: Option[DateTime])