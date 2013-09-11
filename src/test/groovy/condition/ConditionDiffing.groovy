package condition

import groovy.transform.Canonical
import spock.lang.Specification

@Canonical
class Person {
  String name
  String address
  int age
}

class ConditionDiffing extends Specification {
  def "compare sets"() {
    expect:
    ["foo", "bar", "baz"] as Set == ["foo", "bar", "baz"] as Set
  }

  def "compare POJOs"() {
    def fred1 = new Person(name: "fred", address: "greenwich st.", age: 35)
    def fred2 = new Person(name: "fred", address: "greenwich st.", age: 35)

    expect:
    fred1 == fred2
  }

  def "compare text"() {
    expect:
    generateLoremIpsum() ==
"""
Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet
clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit
amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam
nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,
sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor
sit amet.
"""
  }

  private generateLoremIpsum() {
"""
Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet
clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit
amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam
nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,
sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor
sit amet.
"""
  }
}

