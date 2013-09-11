package extension.builtin

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import spock.lang.Specification

/**
 * Add this to ~/.spock/SpockConfig.groovy:
 *
 * runner {
 *   include extension.builtin.Database
 *   exclude extension.builtin.UI
 * }
 */
@Database
class IncludeExclude extends Specification {
  def "a database test"() {
    expect: true
  }

  @UI
  def "a UI database test"() {
    expect: true
  }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Database {}

@Retention(RetentionPolicy.RUNTIME)
@interface UI {}

