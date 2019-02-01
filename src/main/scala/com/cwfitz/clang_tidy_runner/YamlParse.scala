package com.cwfitz.clang_tidy_runner

import net.jcazevedo.moultingyaml._

object YamlParse {
	case class ClangTidyOutput(MainSourceFile: String, Diagnostics: Array[Diagnostic])
	case class Diagnostic(DiagnosticName: String, Message: String, FileOffset: Int, FilePath: String, Notes: Option[Array[Note]],  Replacements: Array[Replacement])
	case class Replacement(FilePath: String, Offset: Int, Length: Int, ReplacementText: String)
	case class Note(Message: String, FilePath: String, FileOffset: Int)

	object ClangTidyYamlProtocol extends DefaultYamlProtocol {
		implicit val noteFormat = yamlFormat3(Note)
		implicit val replacementFormat = yamlFormat4(Replacement)
		implicit val diagnosticFormat = yamlFormat6(Diagnostic)
		implicit val clangTidyOutputFormat = yamlFormat2(ClangTidyOutput)
	}

	import ClangTidyYamlProtocol._

	def parse(input: String): ClangTidyOutput = {
		input.parseYaml.convertTo[ClangTidyOutput]
	}
}
