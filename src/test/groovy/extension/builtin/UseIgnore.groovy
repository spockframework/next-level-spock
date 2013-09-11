package extension.builtin

import spock.lang.Specification

//@Ignore
class UseIgnore extends Specification {
  def test1() {
    expect: true
  }

  //@IgnoreRest
  def test2() {
    expect: true
  }

  //@IgnoreIf({ System.getProperty("os.name").contains("Mac") })
  def test3() {
    expect: true
  }
}
