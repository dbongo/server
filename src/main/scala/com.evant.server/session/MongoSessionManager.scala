// package com.evant.server.session
// /**
//  *
//  * @author  Michael Crowther
//  *          created 7/23/14
//  */

// import java.util

// import akka.actor.ActorRefFactory
// import akka.util.Timeout
// import com.mongodb.casbah.Imports._
// import spray.json.JsonFormat
// import spray.json.DefaultJsonProtocol._

// import com.typesafe.config.Config

// import java.util.concurrent.TimeUnit

// import scala.collection
// import scala.collection.JavaConverters._
// import scala.concurrent.Future
// import scala.concurrent.duration._

// import spray.http.{HttpCookie, DateTime}

// class MongoSessionManager[T](config: Config)(implicit system: ActorRefFactory, timeout: Timeout, format: JsonFormat[T])
//   extends StatefulSessionManager[T](config) {

//   import system.dispatcher

//   private val SERVER = config.getString("evant.server.session.mongo.host")
//   private val HOST = config.getInt("evant.server.session.mongo.port")
//   private val DATABASE = config.getString("evant.server.session.mongo.dbName")
//   private val COLLECTION = "sessions"

//   val connection = MongoClient(SERVER, HOST)
//   val collection = connection(DATABASE)(COLLECTION)

//   def start(): Future[String] = {
//     val id = newSid()
//     for {
//       true <- collection.createIndex(id, Map.empty[String, T])
//       true <- collection.ensureIndex(id, sessionTimeout.toSeconds)
//     } yield id
//   }

//   def get(id: String): Future[Option[Map[String, T]]] =
//     collection.findOneByID(id)[Map[String, T]]  {
//       case Some(map) =>
//         collection.ensureIndex(id, sessionTimeout.toSeconds) util.Ma
//       case None =>
//         Future.successful(None)
//     }

//   def isValid(id: String): Future[Boolean] = ???

//   def update(id: String, map: Map[String, T]): Future[Unit] = ???

//   def get(id: String): Future[Option[Map[String, T]]] = ???

//   def cookify(id: String): Future[HttpCookie] = ???

//   def invalidate(id: String): Future[Unit] = ???

//   def shutdown(): Unit = client.requestDone()
