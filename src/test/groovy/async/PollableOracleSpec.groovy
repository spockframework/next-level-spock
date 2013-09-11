package async

import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class PollableOracleSpec extends Specification {
  def oracle = new PollableOracle()
  def conditions = new PollingConditions(timeout: 1.5)

  def "doesn't provide an immediate answer"() {
    when:
    def token = oracle.ask("What's the coolest language in town?")

    then:
    oracle.getAnswer(token) == null
  }

  def "eventually provides an answer"() {
    when:
    def token = oracle.ask("What's the coolest language in town?")

    then:
    conditions.eventually {
      assert oracle.getAnswer(token) == "Java"
    }
  }

  def "changes its mind when asked twice"() {
    when:
    def token1 = oracle.ask("What's the coolest language in town?")
    def token2 = oracle.ask("What's the coolest language in town?")

    then:
    conditions.within(5) {
      assert oracle.getAnswer(token1) == "Java"
      assert oracle.getAnswer(token2) == "Groovy. But don't tell anyone that you heard it from me."
    }
  }

  // experimental feature
  def "look Ma', no assert!"() {
    // *must* be statically typed (otherwise, condition turns into no-op!)
    PollingConditions conditions = new PollingConditions(timeout: 2)

    when:
    def token = oracle.ask("What's the coolest language in town?")

    then:
    conditions.eventually {
      oracle.getAnswer(token) == "Java"
    }
  }
}
