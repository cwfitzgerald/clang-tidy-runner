
lazy val clang_tidy_runner =
	Project("clang-tidy-runner", file("."))
    	.settings(Seq(
			    name := "clang-tidy-runner",
			    version := "0.1",
			    scalaVersion := "2.12.8",
			    libraryDependencies ++= Seq(
				    "com.github.pathikrit" %% "better-files" % "3.7.0",
				    "com.github.scopt" %% "scopt" % "4.0.0-RC2",
				    "com.typesafe.akka" %% "akka-actor" % "2.5.19",
				    "net.jcazevedo" %% "moultingyaml" % "0.4.0",
				    "org.scala-lang.modules" %% "scala-async" % "0.9.7"
			    )
		    ),
		    scalacOptions ++= Seq(
			    "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
			    "-encoding", "utf-8",                // Specify character encoding used by source files.
			    "-explaintypes",                     // Explain type errors in more detail.
			    "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
			    "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
			    "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
			    "-language:higherKinds",             // Allow higher-kinded types
			    "-language:implicitConversions",     // Allow definition of implicit functions called views
			    "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
			    "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
			    "-Xfuture",                          // Turn on future language features.
			    "-Xlint:by-name-right-associative",  // By-name parameter of right associative operator.
			    "-Xlint:constant",                   // Evaluation of a constant arithmetic expression results in an error.
			    "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
			    "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
			    "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
			    "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
			    "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
			    "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
			    "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
			    "-Xlint:option-implicit",            // Option.apply used implicit view.
			    "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
			    "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
			    "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
			    "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
			    "-Xlint:unsound-match",              // Pattern match may not be typesafe.
			    "-Ypartial-unification",             // Enable partial unification in type constructor inference
			    "-Ywarn-dead-code",                  // Warn when dead code is identified.
			    "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
			    "-Ywarn-inaccessible",               // Warn about inaccessible types in method signatures.
			    "-Ywarn-infer-any",                  // Warn when a type argument is inferred to be `Any`.
			    "-Ywarn-nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
			    "-Ywarn-nullary-unit",               // Warn when nullary methods return Unit.
			    "-Ywarn-numeric-widen",              // Warn when numerics are widened.
			    "-Ywarn-unused:implicits",           // Warn if an implicit parameter is unused.
			    "-Ywarn-unused:imports",             // Warn if an import selector is not referenced.
			    "-Ywarn-unused:locals",              // Warn if a local definition is unused.
			    "-Ywarn-unused:patvars",             // Warn if a variable bound in a pattern is unused.
			    "-Ywarn-unused:privates",            // Warn if a private member is unused.
		    ),
		    scalacOptions in (Compile, console) --= Seq("-Ywarn-unused:imports"),
		    assemblyJarName in assembly := "clang-tidy-runner.jar",
		    mainClass in assembly := Some("com.cwfitz.clang-tidy-runner.Main")
	    )
