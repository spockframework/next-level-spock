package datadriven

import spock.lang.Specification
import spock.lang.Unroll

import condition.Account

class AccountSpecDataDriven extends Specification {
    static final Random random = new Random()

    def "withdraw some amount"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(withdrawn)

        then:
        account.balance == remaining

        where:
        balance | withdrawn || remaining
        5.0     | 2.0       || 3.0
        4.0     | 0.0       || 4.0
        4.0     | 4.0       || 0.0
    }

    def "withdraw some amount (2)"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(withdrawn)

        then:
        account.balance == remaining

        where:
        balance << [5.0, 4.0, 4.0]
        withdrawn << [2.0, 0.0, 4.0]
        remaining << [3.0, 4.0, 0.0]
    }

    @Unroll("withdraw amount of #balance")
    def "withdraw some amount (3)"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(withdrawn)

        then:
        account.balance == remaining

        where:
        balance << (1..3).collect { random.nextInt(100) + 2 }
        withdrawn = balance - 2
        remaining = 2
    }
}
