package extension.custom

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class ReportExtension implements IGlobalExtension {
  void visitSpec(SpecInfo spec) {}
}