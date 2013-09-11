package condition

import spock.lang.Specification

class BasicsSpec extends Specification {
    def "withdraw some amount"() {
        given:
        def account = new Account(5.0)

        when:
        account.withdraw(2.0)

        then:
        account.balance == 3.0
    }
}
