/*
 * Copyright 2017 Daniel Spiewak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

addSbtPlugin("io.get-coursier"   % "sbt-coursier"    % "1.0.0-M15-5")
addSbtPlugin("com.dwijnand"      % "sbt-travisci"    % "1.1.0")
addSbtPlugin("com.typesafe.sbt"  % "sbt-git"         % "0.9.0")
addSbtPlugin("de.heikoseeberger" % "sbt-header"      % "1.8.0")
addSbtPlugin("com.typesafe"      % "sbt-mima-plugin" % "0.1.13")

addSbtPlugin("com.jsuereth"   % "sbt-pgp"      % "1.0.0")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.5.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.14")
addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.1.6")
