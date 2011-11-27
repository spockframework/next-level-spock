package extension.custom.solution

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.SpecInfo
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.extension.IGlobalExtension

class ReportExtension implements IGlobalExtension {
  void visitSpec(SpecInfo spec) {
    spec.addListener(new AbstractRunListener() {
      @Override
      void afterFeature(FeatureInfo feature) {
        for (block in feature.blocks) {
          for (text in block.texts) {
            println text
          }
        }
      }
    })
  }
}

