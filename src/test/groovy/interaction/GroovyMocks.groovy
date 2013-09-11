package interaction

import spock.lang.Specification

class GroovyMocks extends Specification {
    def "mock and stub dynamic methods"() {
        def person = GroovyMock(Person) {
            1 * fooBarBaz() >> "Look Ma', dynamic methods!"
        }

        expect:
        person.fooBarBaz() == "Look Ma', dynamic methods!"
    }

    def "mock constructors"() {
        GroovySpy(Person, global: true)

        when:
        new Person("Fred", 42)

        then:
        1 * new Person("Fred", 42)
    }

    def "mock static methods"() {
        GroovySpy(Person, global: true)

        when:
        Person.findSpock()
        Person.findSpock()

        then:
        2 * Person.findSpock()
    }

    def "mock all instances of a type, similar to Groovy's MockFor and StubFor"() {
        // only affects instances created from here on
        def anyPerson = GroovySpy(Person, global: true)

        def fred = new Person("Fred", 42)
        def barney = new Person("Barney", 33)

        when:
        fred.sing()
        barney.sing()

        then:
        2 * anyPerson.sing() >>> ["a", "b", "c"] >> { throw new Exception("ff") }
    }
}
