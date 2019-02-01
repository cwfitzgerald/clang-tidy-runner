package com.cwfitz.clang_tidy_runner

import better.files._
import File._
import java.io.{File => JFile}
import scopt.OParser

object Main {
	case class Config(inYaml: JFile = new JFile("."))

	def main(args: Array[String]): Unit = {
		val builder = OParser.builder[Config]
		val parser = {
			import builder._

			OParser.sequence(
				programName("clang-tidy-runner"),
				head("clang-tidy-runner", "0.1.0"),
				help("help")
					.text("prints this dialogue"),
				arg[JFile]("<file>")
    				.required()
    				.validate(f => if (f.exists) Right(()) else Left("File not found"))
    				.action((f, c) => c.copy(inYaml = f))
			)
		}

		OParser.parse(parser, args, Config()) match {
			case Some(config) =>
				val file = config.inYaml.toScala
				val str = file.contentAsString
				val parsed = YamlParse.parse(str)
				println(parsed.Diagnostics.length)
			case None =>
		}
	}
}
