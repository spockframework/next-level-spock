package extension.builtin

import spock.lang.Specification

/**
 * Add this to ~/.spock/SpockConfig.groovy:
 *
 * runner {
 *   optimizeRunOrder = true
 * }
 *
 * Forgets about previously failed/slow tests after a while.
 * To wipe out history, delete ~/.spock/RunHistory.
 */
class OptimizeRunOrder extends Specification {
    def "a slow test"() {
        expect: Thread.sleep(3000)
    }

    def "a fast test"() {
        expect: true
    }

    def "a sometimes bad test"() {
        //expect: System.currentTimeMillis() % 3
    }

    def "a bad test"() {
        //expect: false
    }
}
