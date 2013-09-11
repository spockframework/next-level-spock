package condition

import spock.lang.Specification

import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

class ConditionFlavors extends Specification {
    def "when-then style"() {
        when:
        def x = Math.max(5, 9)

        then:
        x == 9
    }

    def "expect style"() {
        expect:
        Math.max(5, 9) == 9
    }

    def "complex condition"() {
        expect:
        getGermanCarBrands().any { it.size() >= 3 }
    }

    def "Hamcrest matcher"() {
        expect:
        that computeAnswerToTheUniverse(), closeTo(42, 0.01)
    }

    private getGermanCarBrands() { ["audi", "bmw", "porsche"] }

    private computeAnswerToTheUniverse() { 42.00387455 }
}
