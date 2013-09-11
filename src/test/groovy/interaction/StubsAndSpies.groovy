package interaction

import spock.lang.Specification

class StubsAndSpies extends Specification {
    def "stubs"() {
        def person = Stub(Person)

        // stubs cannot demand interactions
        // 1 * person.sing()

        // stubs have more ambitious default return values than plain mocks
        expect:
        person.name == ""
        person.bestFriend instanceof Person
        person.bestFriend.name == "Mr. Unknown"
    }

    def "spies"() {
        // can only spy on class, not on interface
        // creates a real person underlying the spy
        def person = Spy(Person, constructorArgs: ["Fred", 42])

        expect:
        // calls through to real person
        person.name == "Fred"

        when:
        def text = person.sing()

        then:
        // can selectively stub and/or mock as required
        1 * person.sing() >> { callRealMethod() * 2 }
        text == "tra-la-latra-la-la"
    }

    def "half-mocks"() {
        def person = Spy(Person, constructorArgs: ["Fred", 42])

        when:
        person.singRepeatedly()

        then:
        3 * person.sing()
    }
}


