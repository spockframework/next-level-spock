package treasures

import spock.lang.Specification
import java.lang.annotation.Target
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.ElementType

class UseIncludeExclude extends Specification {
  @Database
  def "a database test"() {
    expect: true
  }

  @UI
  def "a UI test"() {
    expect: true
  }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Database {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface UI {}

